package com.estudo.estudoapicdc.site.detalhe;

import com.estudo.estudoapicdc.detalhelivro.Autor;

public class AutorLivroDetalheDTO {

    private String nome;
    private String descricao;

    public AutorLivroDetalheDTO(Autor autor) {
        nome = autor.getNome();
        descricao = "Aqui precisa vir a descrição do autor";
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
