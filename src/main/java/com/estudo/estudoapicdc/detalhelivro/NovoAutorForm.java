package com.estudo.estudoapicdc.detalhelivro;

import jakarta.validation.constraints.NotBlank;

import java.net.URL;

public class NovoAutorForm {

    @NotBlank
    private String nome;
    @NotBlank
    private URL linkGithub;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public URL getLinkGithub() {
        return linkGithub;
    }
    public void setLinkGithub(URL linkGithub) {
        this.linkGithub = linkGithub;
    }

    public Autor novoAutor() {
        return new Autor(nome, linkGithub);
    }
}
