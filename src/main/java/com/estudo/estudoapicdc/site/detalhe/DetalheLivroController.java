package com.estudo.estudoapicdc.site.detalhe;

import com.estudo.estudoapicdc.detalhelivro.Livro;
import com.estudo.estudoapicdc.detalhelivro.LivroRepository;
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

    @GetMapping(value = "/api/livro/{id}")
    @Operation(summary = "Visualização detalhes dos livros")
    public LivroDetalheDTO exibeDetalhes(@PathVariable("id") Long id) {
        Livro livro = livroRepository.findById(id).get();
        return new LivroDetalheDTO(livro);
    }

    @PostMapping(value = "/api/carrinho/{idLivro}")
    public String adicionaLivroCarrinho(@PathVariable("idLivro") Long idLivro, @CookieValue("carrinho") Optional<String> jsonCarrinho, HttpServletResponse response) {
        Carrinho carrinho = jsonCarrinho.map(json -> {
            try {
                String decoded = new String(Base64.getUrlDecoder().decode(json));
                return new ObjectMapper().readValue(decoded, Carrinho.class);
            } catch (Exception e) {
                return new Carrinho();
            }
        }).orElse(new Carrinho());

        carrinho.adiciona(livroRepository.findById(idLivro).get());

        String json = new ObjectMapper().writeValueAsString(carrinho);
        String encoded = Base64.getUrlEncoder().encodeToString(json.getBytes());

        Cookie cookie = new Cookie("carrinho", encoded);
        cookie.setHttpOnly(true);
        cookie.setPath("/");

        response.addCookie(cookie);

        return carrinho.toString();
    }
}
