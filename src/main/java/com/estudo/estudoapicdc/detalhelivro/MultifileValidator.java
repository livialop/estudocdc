package com.estudo.estudoapicdc.detalhelivro;

import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

import java.util.Optional;


public class MultifileValidator implements Validator {

    private LivroRepository livroRepository;

    // construtor
    public MultifileValidator(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoLivroForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NovoLivroForm form = (NovoLivroForm) target;
        Optional<Livro> fileVazio = livroRepository.findByIsbn(form.getIsbn());

        if(form.getCapa().isEmpty()) {
            errors.rejectValue("capa", null, "Arquivo de capa vazio.");
        }
    }


    public void multifileEmpty(Object target, Errors errors) {
        errors.rejectValue("capa", null, "Arquivo de capa vazio.");
    }

}