package com.estudo.estudoapicdc.site.detalhe;

import com.estudo.estudoapicdc.detalhelivro.Livro;
import com.estudo.estudoapicdc.detalhelivro.LivroRepository;
import com.estudo.estudoapicdc.shared.Cookies;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.ObjectMapper;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

@RestController
public class DetalheLivroController {

    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private Cookies cookies;

    @GetMapping(value = "/api/livro/{id}")
    @Operation(summary = "Visualização detalhes dos livros")
    public LivroDetalheDTO exibeDetalhes(@PathVariable("id") Long id) {
        Livro livro = livroRepository.findById(id).get();
        return new LivroDetalheDTO(livro);
    }

    @PostMapping(value = "/api/carrinho/{idLivro}")
    public String adicionaLivroCarrinho(@PathVariable("idLivro") Long idLivro, @CookieValue("carrinho") Optional<String> jsonCarrinho, HttpServletResponse response) {
        Carrinho carrinho = jsonCarrinho.map(Carrinho :: reconstroi).orElse(new Carrinho());

        carrinho.adiciona(livroRepository.findById(idLivro).get());

        cookies.writeAsJson("carrinho", carrinho, response);

        return carrinho.toString();
    }
}
