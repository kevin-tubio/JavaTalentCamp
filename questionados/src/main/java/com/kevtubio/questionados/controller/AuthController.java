package com.kevtubio.questionados.controller;

import com.kevtubio.questionados.dto.request.LoginRequestDTO;
import com.kevtubio.questionados.dto.request.SignupRequestDTO;
import com.kevtubio.questionados.dto.response.JwtResponse;
import com.kevtubio.questionados.dto.response.MessageResponse;
import com.kevtubio.questionados.entity.Role;
import com.kevtubio.questionados.entity.Usuario;
import com.kevtubio.questionados.exceptions.custom.TokenRefreshException;
import com.kevtubio.questionados.repository.UserRepository;
import com.kevtubio.questionados.security.jwt.JwtUtils;

import com.kevtubio.questionados.service.UserService;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;

import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final UserService userService;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequestDTO loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtils.generateJwtToken(authentication);
        String refreshToken = jwtUtils.generateJwtRefreshToken(authentication);

        Usuario userDetails = (Usuario) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());

        return ResponseEntity.ok(
                new JwtResponse(token, refreshToken, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles)
        );
    }

    @PostMapping("/signup")
    public ResponseEntity<MessageResponse> registerUser(@Valid @RequestBody SignupRequestDTO signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }

        Usuario user = new Usuario(
                signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword())
        );

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            roles.add(Role.ROLE_USER);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        roles.add(Role.ROLE_ADMIN);

                        break;
                    case "mod":
                        roles.add(Role.ROLE_MODERATOR);

                        break;
                    default:
                        roles.add(Role.ROLE_USER);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @GetMapping("/refresh")
    public ResponseEntity<JwtResponse> refreshToken(@Param("refresh_token") String refreshToken) {
        if (!jwtUtils.isValidRefreshToken(refreshToken))
            throw new TokenRefreshException(refreshToken, "Invalid Refresh Token");

        Claims claims = jwtUtils.parseToken(refreshToken);
        Usuario usuario = (Usuario) userService.loadUserByUsername(claims.getSubject());
        List<String> roles = usuario.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());

        refreshToken = jwtUtils.generateJwtRefreshToken(claims);

        claims.put("grant_type", String.join(",", roles));
        String token = jwtUtils.generateJwtToken(claims);

        return ResponseEntity.ok(
                new JwtResponse(token, refreshToken, usuario.getId(), usuario.getUsername(), usuario.getEmail(), roles)
        );
    }

}
