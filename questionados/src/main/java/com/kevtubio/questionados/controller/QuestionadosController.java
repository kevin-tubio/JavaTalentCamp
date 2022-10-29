package com.kevtubio.questionados.controller;

import com.kevtubio.questionados.dto.request.RespuestaAVerificarDTO;
import com.kevtubio.questionados.dto.response.RespuestaVerificada;
import com.kevtubio.questionados.entity.Pregunta;
import com.kevtubio.questionados.service.PreguntaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/questionados")
@RequiredArgsConstructor
public class QuestionadosController {

    private final PreguntaService preguntaService;

    @GetMapping(path = "/next")
    public Pregunta traerPreguntaRandom() {
        return preguntaService.getRandomPregunta();
    }

    @PostMapping(path = "/verificaciones")
    public RespuestaVerificada evaluarRespuesta(@Valid @RequestBody RespuestaAVerificarDTO respuestaAVerificarDTO) {
        return preguntaService.isValidResponse(respuestaAVerificarDTO);
    }

}
