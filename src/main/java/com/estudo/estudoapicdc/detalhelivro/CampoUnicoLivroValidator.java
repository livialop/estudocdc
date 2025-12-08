package com.estudo.estudoapicdc.detalhelivro;

import org.jspecify.annotations.Nullable;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public abstract class CampoUnicoLivroValidator implements Validator { // abstract para que não obrigue a implementar um mét-odo que valida

    @Override
    public boolean supports (Class < ? > clazz) {
        return NovoLivroForm.class.isAssignableFrom(clazz);
    }

    public abstract Optional<Livro> buscaLivroPorCampo(NovoLivroForm novoLivroForm);

    @Override
    public void validate (Object target, Errors errors){
        NovoLivroForm form = (NovoLivroForm) target;
        Optional<Livro> possivelTitulo = buscaLivroPorCampo(form);

        if (possivelTitulo.isPresent()) {
            String nomeCampoInvalido = getNomeCampoInvalido();
            errors.rejectValue(getNomeCampoInvalido(), null, nomeCampoInvalido + ": Já existe um livro igual cadastrado.");
        }
    }

    protected abstract String getNomeCampoInvalido();
}
