package com.kevtubio.questionados.service;

import com.kevtubio.questionados.entity.Respuesta;
import com.kevtubio.questionados.exceptions.custom.ResourceNotFoundException;
import com.kevtubio.questionados.repository.RespuestaRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RespuestaService {

    private final RespuestaRepository respuestaRepository;

    public Respuesta getRespuestaById(Integer id) {
        return respuestaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Respuesta", "id", id));
    }

}
