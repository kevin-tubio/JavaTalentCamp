package com.kevtubio.questionados.security.jwt;

import com.kevtubio.questionados.entity.Usuario;

import io.jsonwebtoken.*;

import io.jsonwebtoken.impl.DefaultClaims;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    private final JwtProperties jwtProperties;

    public String generateJwtToken(Authentication authentication) {
        Usuario usuario = (Usuario) authentication.getPrincipal();

        Claims claims = new DefaultClaims();
        claims.setSubject(usuario.getUsername());
        claims.setIssuedAt(new Date());
        claims.put("grant_type", usuario.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(",")));
        claims.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(jwtProperties.getTokenDurationMinutes())));

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecret()).compact();
    }

    public String generateJwtToken(Claims claims) {

        claims.setIssuedAt(new Date());
        claims.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(jwtProperties.getTokenDurationMinutes())));

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecret()).compact();
    }

    public String generateJwtRefreshToken(Authentication authentication) {
        Usuario usuario = (Usuario) authentication.getPrincipal();

        Claims claims = new DefaultClaims();
        claims.setSubject(usuario.getUsername());
        claims.setIssuedAt(new Date());
        claims.put("grant_type", "ROLE_REFRESH");
        claims.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(jwtProperties.getRefreshTokenDurationDays())));

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecret()).compact();
    }

    public String generateJwtRefreshToken(Claims claims) {
        claims.setIssuedAt(new Date());
        claims.put("grant_type", "ROLE_REFRESH");
        claims.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(jwtProperties.getRefreshTokenDurationDays())));

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecret()).compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtProperties.getSecret()).parseClaimsJws(token).getBody().getSubject();
    }

    public Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtProperties.getSecret())
                .parseClaimsJws(token)
                .getBody();
    }

    public List<GrantedAuthority> getGrants(String token) {
        String grantTypes = parseToken(token).get("grant_type", String.class);
        return Arrays
                .stream(grantTypes.split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    public boolean isValidToken(String authToken) {
        return isValidToken(authToken, token -> {
            Jwts.parser()
                    .setSigningKey(jwtProperties.getSecret())
                    .parseClaimsJws(token);
            return true;
        });
    }

    public boolean isValidToken(String authToken, Predicate<String> validation) {
        try {
            return validation.test(authToken);
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

    public boolean isValidRefreshToken(String refreshToken) {
        return isValidToken(refreshToken, token -> {
            String grantType = Jwts.parser()
                    .setSigningKey(jwtProperties.getSecret())
                    .parseClaimsJws(token)
                    .getBody()
                    .get("grant_type", String.class);

            return "ROLE_REFRESH".equals(grantType);
        });
    }

}
