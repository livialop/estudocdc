package com.estudo.estudoapicdc.detalhelivro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrudAutoresControllers {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping(value = "/api/autor")
    @Transactional
    public void novo(@Valid @RequestBody NovoAutorForm form) {
        // Testar a validação pelo swagger antes de começar a escrever o código
        Autor novoAutor = form.novoAutor();
        autorRepository.save(novoAutor);
    }
}
