package com.estudo.estudoapicdc.site.detalhe;

import com.estudo.estudoapicdc.detalhelivro.Livro;

import java.util.ArrayList;
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
}
