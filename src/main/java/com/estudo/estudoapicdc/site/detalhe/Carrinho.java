package com.estudo.estudoapicdc.site.detalhe;

import com.estudo.estudoapicdc.detalhelivro.Livro;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.util.Assert;
import tools.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.util.*;

public class Carrinho {

    private Set<LivroCarrinhoDTO> livros = new LinkedHashSet<>(); // para manter a ordem de inserção no carrinho

    public static Carrinho cria(Optional<String> jsonCarrinho) {
        return jsonCarrinho.map(Carrinho::reconstroi).orElse(new Carrinho());
    }
    // um set utiliza um dicionario de dados, um hash -> vetor de vetores

    public void adiciona(Livro livro) {
        LivroCarrinhoDTO novoItem = new LivroCarrinhoDTO(livro);
        boolean result = livros.add(novoItem);
        if(!result) {
            LivroCarrinhoDTO itemExistente = livros.stream().filter(novoItem :: equals).findFirst().get();
            itemExistente.incrementa();
        }
    }

    @Override
    public String toString() {
        return "Carrinho [livros=" + livros + "]";
    }

    public Set<LivroCarrinhoDTO> getLivros() {
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

    public void atualiza(@NotNull Livro livro, @Positive int novaQuantidade) {
        Assert.isTrue(novaQuantidade > 0, "A quantidade de atualização tem que ser maior do que 0."); // defendendo a borda do sistema

        LivroCarrinhoDTO possivelItemAdicionado = new LivroCarrinhoDTO(livro);
        Optional<LivroCarrinhoDTO> possivelItem = livros.stream().filter(possivelItemAdicionado:: equals).findFirst();

        Assert.isTrue(possivelItem.isPresent(), "Você não deveria atualizar um livro não existente");

        LivroCarrinhoDTO itemQueExiste = possivelItem.get();
        itemQueExiste.atualizaQuantidade(novaQuantidade);
    }

    public BigDecimal getTotal() {
        return livros.stream().map(item -> item.getTotal()).reduce(BigDecimal.ZERO,
                (atual, proximo) -> atual.add(proximo));
        // um for pode deixar isso mais legível p mim que não entendo muito bem ainda a função map()
    }

}
