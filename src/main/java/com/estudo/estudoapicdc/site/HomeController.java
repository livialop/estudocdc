package com.estudo.estudoapicdc.site;

import com.estudo.estudoapicdc.detalhelivro.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class HomeController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping(value = "/api/home")
    public Collection<LivroParaHomeDTO> lista() {
        return livroRepository.findAll().stream()
                .map(LivroParaHomeDTO:: new)
                .collect(Collectors.toList());
    }
}
