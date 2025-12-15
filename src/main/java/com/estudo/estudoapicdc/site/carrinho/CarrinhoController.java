package com.estudo.estudoapicdc.site.carrinho;

import com.estudo.estudoapicdc.detalhelivro.Livro;
import com.estudo.estudoapicdc.detalhelivro.LivroRepository;
import com.estudo.estudoapicdc.shared.Cookies;
import com.estudo.estudoapicdc.site.detalhe.Carrinho;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CarrinhoController {

    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private Cookies cookies;

    @PostMapping(value = "/api/carrinho/{idLivro}/atualiza")
    @Operation(summary = "atualiza o carrinho")
    public void atualiza(@PathVariable("idLivro") Long idLivro, @RequestParam int novaQuantidade, @CookieValue("carrinho") String jsonCarrinho, HttpServletResponse response) {
        Carrinho carrinho = Carrinho.cria(Optional.of(jsonCarrinho));
        Livro livro = livroRepository.findById(idLivro).get();

        carrinho.atualiza(livro, novaQuantidade);

        cookies.writeAsJson("carrinho", carrinho, response);
    }

}
