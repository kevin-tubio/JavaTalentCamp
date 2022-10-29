package com.kevtubio.questionados.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pregunta_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @Column(unique = true)
    private String enunciado;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pregunta_id")
    private List<Respuesta> opciones;

}
