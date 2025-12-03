package com.estudo.estudoapicdc.detalhelivro;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {
    // CrudRepository é méto-do da interface
    // O Repository chama o transactional automático
    // entretanto, é uma boa prática chamar o transactional explicitamente
}
