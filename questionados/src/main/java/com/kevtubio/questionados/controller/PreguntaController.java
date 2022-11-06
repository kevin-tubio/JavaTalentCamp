package com.kevtubio.questionados.controller;

import com.kevtubio.questionados.dto.request.PreguntaRequestDTO;
import com.kevtubio.questionados.entity.Pregunta;
import com.kevtubio.questionados.service.PreguntaService;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping(path = "/api/preguntas")
@RequiredArgsConstructor
public class PreguntaController {

    private final PreguntaService preguntaService;
    private final ModelMapper modelMapper;

    @GetMapping
    @Secured({"ROLE_USER", "ROLE_MODERATOR", "ROLE_ADMIN"})
    public List<Pregunta> getAllPreguntas() {
        return preguntaService.getAllPreguntas();
    }

    @PostMapping
    @Secured({"ROLE_MODERATOR", "ROLE_ADMIN"})
    public Pregunta createPregunta(@Valid @RequestBody PreguntaRequestDTO preguntaRequestDto) {
        Pregunta pregunta = modelMapper.map(preguntaRequestDto, Pregunta.class);
        preguntaService.createPregunta(pregunta);
        return pregunta;
    }

    @GetMapping(path = "/{id}")
    @Secured({"ROLE_USER", "ROLE_MODERATOR", "ROLE_ADMIN"})
    public Pregunta getPreguntaById(@PathVariable Integer id) {
        return preguntaService.getPreguntaById(id);
    }

}
