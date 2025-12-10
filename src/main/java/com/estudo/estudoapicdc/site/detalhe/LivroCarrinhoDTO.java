package com.estudo.estudoapicdc.site.detalhe;

import com.estudo.estudoapicdc.detalhelivro.Livro;

import java.math.BigDecimal;

public class LivroCarrinhoDTO {

    private String titulo;
    private BigDecimal preco;
    private String linkCapaLivro;

    @Deprecated
    public LivroCarrinhoDTO(){

    }

    public LivroCarrinhoDTO(Livro livro) {
        titulo = livro.getTitulo();
        preco = livro.getPreco();
        linkCapaLivro = livro.getLinkCapaLivro();
    }

    @Override
    public String toString() {
        return "LivroCarrinhoDTO [titulo=" +titulo+ ", preco=" +preco+ ", linkCapaLivro" +linkCapaLivro+ "]";
    }

    public String getTitulo() {
        return titulo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getLinkCapaLivro() {
        return linkCapaLivro;
    }
}
