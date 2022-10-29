package com.kevtubio.questionados.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "respuesta_id")

    private Integer respuestaId;

    @Column(name = "es_correcta")
    private Boolean esCorrecta;

    @Column(unique = true)
    private String texto;

}
