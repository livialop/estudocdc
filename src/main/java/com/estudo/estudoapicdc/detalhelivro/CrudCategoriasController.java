package com.estudo.estudoapicdc.detalhelivro;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrudCategoriasController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @InitBinder("novaCategoriaForm") // model atribute
    public void init(WebDataBinder dataBinder) {
        dataBinder.addValidators(new SemCategoriaComNomeDuplicadoValidator(categoriaRepository));
    }

    @PostMapping(value = "/api/categoria")
    @Transactional
    public void nova(@Valid @RequestBody NovaCategoriaForm form) {
        Categoria novaCategoria = new Categoria(form.getNome());
        categoriaRepository.save(novaCategoria);
    }

}
