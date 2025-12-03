package com.estudo.estudoapicdc.detalhelivro;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String nome;

    @Deprecated
    public Categoria() {

    }

    // construtor - o id não vai junto
    public Categoria(@NotBlank String nome) {
        super();
        this.nome = nome;
    }
}
