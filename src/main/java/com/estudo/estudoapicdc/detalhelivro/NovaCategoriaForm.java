package com.estudo.estudoapicdc.detalhelivro;


import jakarta.validation.constraints.NotBlank;

public class NovaCategoriaForm {

    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
