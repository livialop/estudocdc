package com.estudo.estudoapicdc.detalhelivro;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class TituloLivroUnicoValidator implements Validator {

    private LivroRepository livroRepository;

    public TituloLivroUnicoValidator(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoLivroForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NovoLivroForm form = (NovoLivroForm) target;
        Optional<Livro> possivelTitulo = livroRepository.findByTitulo(form.getTitulo());

        if (possivelTitulo.isPresent()) {
            errors.rejectValue("titulo", null, "Já existe um livro com esse título.");
        }

    }
}
