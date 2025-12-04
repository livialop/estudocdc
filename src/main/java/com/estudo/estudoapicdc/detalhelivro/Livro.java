package com.estudo.estudoapicdc.detalhelivro;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NotBlank @Size(max = 100) String titulo;
    private @NotBlank @Size(max = 50) String subTitulo;
    private @NotBlank @Min(20) BigDecimal preco;
    private @NotBlank String conteudo;
    private @NotBlank String sumario;
    private @Min(100) int numeroPaginas;
    private @NotBlank String isbn;
    private @NotBlank String linkCapaLivro;
    @ManyToOne
    private @NotNull Autor autor;

    public Livro(@NotBlank @Size(max=100) String titulo, @NotBlank @Size(max=50) String subTitulo,
                 @NotBlank @Min(20) BigDecimal preco, @NotBlank String conteudo, @NotBlank String sumario,
                 @NotBlank int numeroPaginas, @NotBlank String isbn, String linkCapaLivro, @NotNull Autor autor) {
        this.titulo = titulo;
        this.subTitulo = subTitulo;
        this.preco = preco;
        this.conteudo = conteudo;
        this.sumario = sumario;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.linkCapaLivro = linkCapaLivro;
        this.autor = autor;
    }


    @Override
    public String toString() {
        return "Livro [titulo=" + titulo + ", subTitulo=" + subTitulo + ", preco=" + preco + ", conteudo=" + conteudo +
                ", sumario=" + sumario + ", numeroPaginas=" + numeroPaginas + ", isbn=" + isbn +
                ", linkCapaLivro=" + linkCapaLivro + ", autor=" + autor + "]";
    }

}
