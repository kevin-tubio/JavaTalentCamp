package com.kevtubio.questionados.dto.request;

import com.kevtubio.questionados.entity.Respuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PreguntaRequestDTO {

    private Integer categoriaId;

    @NotBlank
    private String enunciado;

    @Size(min = 1)
    private List<Respuesta> opciones;

}
