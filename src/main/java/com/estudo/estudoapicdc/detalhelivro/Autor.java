package com.estudo.estudoapicdc.detalhelivro;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.net.URL;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NotBlank String nome;
    private @NotBlank URL linkGithub;
    @PastOrPresent
    private LocalDateTime createdAt = LocalDateTime.now();

    @Deprecated
    public Autor() {

    }

    public Autor(@NotBlank String nome, @NotBlank URL linkGithub) {
        this.nome = nome;
        this.linkGithub = linkGithub;
    }

    @Override
    public String toString() {
        return "Autor [nome=" + nome + ", linkGithub=" + linkGithub + ", createdAt=" + createdAt +"]";
    }

    public String getNome() {
        return nome;
    }
}
