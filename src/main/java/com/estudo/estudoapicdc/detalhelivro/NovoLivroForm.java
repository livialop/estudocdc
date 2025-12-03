package com.estudo.estudoapicdc.detalhelivro;

import io.swagger.v3.oas.annotations.media.Content;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

public class NovoLivroForm {

    @NotBlank
    @Size(max=100)
    private String titulo;
    @NotBlank
    @Size(max=50)
    private String subTitulo;
    @Min(20)
    private BigDecimal preco;
    @NotBlank
    private String conteudo;
    @NotBlank
    private String sumario;
    @Min(100)
    private int numeroPaginas;
    @NotBlank
    private String isbn;
    @NotNull
    private MultipartFile capa;
    // precisa colocar um autor
    // seria uma fk ?

    public BigDecimal getPreco() {
        return preco;
    }
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
    public int getNumeroPaginas() {
        return numeroPaginas;
    }
    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
    public MultipartFile getCapa() {
        return capa;
    }
    public void setCapa(MultipartFile capa) {
        this.capa = capa;
    }
    public String getConteudo() {
        return conteudo;
    }
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getSubTitulo() {
        return subTitulo;
    }
    public void setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
    }
    public String getSumario() {
        return sumario;
    }
    public void setSumario(String sumario) {
        this.sumario = sumario;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
