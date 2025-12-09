package com.estudo.estudoapicdc.site;

import com.estudo.estudoapicdc.detalhelivro.Livro;

public class LivroParaHomeDTO {

    private String titulo;
    private Long id;
    private String nomeAutor;

    // Aqui que coloca as colunas que serão exibidas para home
    public LivroParaHomeDTO(Livro livro) {
        this.titulo = livro.getTitulo();
        this.id = livro.getId();
        this.nomeAutor = livro.getAutor().getNome();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }
}
