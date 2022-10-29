package com.kevtubio.questionados.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@RequiredArgsConstructor
public class CategoriaRequestDTO {

    @NotBlank
    private String nombre;

    @NotBlank
    private String descripcion;

}
