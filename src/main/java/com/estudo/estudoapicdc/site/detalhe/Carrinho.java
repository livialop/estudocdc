package com.estudo.estudoapicdc.site.detalhe;

import com.estudo.estudoapicdc.detalhelivro.Livro;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Carrinho {

    private List<LivroCarrinhoDTO> livros = new ArrayList<>();

    public void adiciona(Livro livro) {
        livros.add(new LivroCarrinhoDTO(livro));
    }

    @Override
    public String toString() {
        return "Carrinho [livros=" + livros + "]";
    }

    public List<LivroCarrinhoDTO> getLivros() {
        return livros;
    }

    public static Carrinho reconstroi(String json) {
        try {
            String decoded = new String(Base64.getUrlDecoder().decode(json));
            return new ObjectMapper().readValue(decoded, Carrinho.class);
        } catch (Exception e) {
            return new Carrinho();
        }
    }

}
