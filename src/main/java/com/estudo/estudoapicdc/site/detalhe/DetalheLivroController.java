package com.estudo.estudoapicdc.site.detalhe;

import com.estudo.estudoapicdc.detalhelivro.Livro;
import com.estudo.estudoapicdc.detalhelivro.LivroRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetalheLivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping(value = "/api/livro/{id}")
    @Operation(summary = "Visualização detalhes dos livros")
    public LivroDetalheDTO getMethodName(@PathVariable("id") Long id) {
        Livro livro = livroRepository.findById(id).get();
        return new LivroDetalheDTO(livro);
    }
}
