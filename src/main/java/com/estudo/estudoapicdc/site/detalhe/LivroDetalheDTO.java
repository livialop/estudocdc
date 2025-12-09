package com.estudo.estudoapicdc.site.detalhe;

import com.estudo.estudoapicdc.detalhelivro.Autor;
import com.estudo.estudoapicdc.detalhelivro.Livro;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.net.URL;

public class LivroDetalheDTO {

    private String titulo;
    private String subTitulo;
    private String linkCapaLivro;
    private String conteudo;
    private String sumario;
    private int numeroPaginas;
    private BigDecimal preco;
    private String isbn;
    private AutorLivroDetalheDTO autor;
    private Long id;


    public LivroDetalheDTO(Livro livro) {
        titulo = livro.getTitulo();
        subTitulo = livro.getSubTitulo();
        linkCapaLivro = livro.getLinkCapaLivro();
        conteudo = livro.getConteudo();
        sumario = livro.getSumario();
        numeroPaginas = livro.getNumeroPaginas();
        preco = livro.getPreco();
        isbn = livro.getIsbn();
        autor = new AutorLivroDetalheDTO(livro.getAutor());
        id = livro.getId();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSubTitulo() {
        return subTitulo;
    }

    public String getLinkCapaLivro() {
        return linkCapaLivro;
    }

    public String getConteudo() {
        return conteudo;
    }

    public String getSumario() {
        return sumario;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getIsbn() {
        return isbn;
    }

    public AutorLivroDetalheDTO getAutor() {
        return autor;
    }

    public Long getId() {
        return id;
    }
}
