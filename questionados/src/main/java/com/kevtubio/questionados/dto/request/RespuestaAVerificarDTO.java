package com.kevtubio.questionados.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class RespuestaAVerificarDTO {

    private Integer preguntaId;

    private Integer respuestaId;

}
