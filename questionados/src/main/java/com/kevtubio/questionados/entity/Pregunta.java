package com.kevtubio.questionados.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
