package com.kevtubio.questionados.service;

import com.kevtubio.questionados.dto.request.RespuestaAVerificarDTO;
import com.kevtubio.questionados.dto.response.RespuestaVerificada;
import com.kevtubio.questionados.entity.Pregunta;
import com.kevtubio.questionados.entity.Respuesta;
import com.kevtubio.questionados.exceptions.custom.ResourceNotFoundException;
import com.kevtubio.questionados.repository.PreguntaRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class PreguntaService {

    private final PreguntaRepository preguntaRepository;
    private final RespuestaService respuestaService;
    private final Random random;

    public List<Pregunta> getAllPreguntas() {
        return preguntaRepository.findAll();
    }

    public Pregunta getPreguntaById(Integer id) {
        return preguntaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pregunta", "id", id));
    }

    public void createPregunta(Pregunta pregunta) {
        preguntaRepository.save(pregunta);
    }

    public Pregunta getRandomPregunta() {
        List<Pregunta> todasLasPreguntas = preguntaRepository.findAll();

        int index = random.ints(0, todasLasPreguntas.size())
                .findFirst()
                .orElse(0);

        return todasLasPreguntas.get(index);
    }

    public RespuestaVerificada isValidResponse(RespuestaAVerificarDTO respuestaAVerificarDTO) {
        Pregunta pregunta = getPreguntaById(respuestaAVerificarDTO.getPreguntaId());
        Respuesta respuesta = respuestaService.getRespuestaById(respuestaAVerificarDTO.getRespuestaId());
        return new RespuestaVerificada(validateResponse(pregunta, respuesta));
    }

    private boolean validateResponse(Pregunta pregunta, Respuesta respuesta) {
        if (!pregunta.getOpciones().contains(respuesta))
            return false;

        return respuesta.getEsCorrecta();
    }

}
