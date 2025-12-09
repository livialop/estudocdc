package com.estudo.estudoapicdc.detalhelivro;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {
    Optional<Livro> findByIsbn(String isbn);

    Optional<Livro> findByTitulo(String titulo);

    @Override
    Collection<Livro> findAll();
}
