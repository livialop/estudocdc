package com.estudo.estudoapicdc.detalhelivro;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class IsbnUnicoValidator extends CampoUnicoLivroValidator {

    private LivroRepository livroRepository;

    public IsbnUnicoValidator(LivroRepository livroRepository) {

        this.livroRepository = livroRepository;
    }


    @Override
    public Optional<Livro> buscaLivroPorCampo(NovoLivroForm novoLivroForm) {
        return livroRepository.findByIsbn(novoLivroForm.getIsbn());
    }

    @Override
    protected String getNomeCampoInvalido() {
        return "isbn";
    }
}
