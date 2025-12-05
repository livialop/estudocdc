package com.estudo.estudoapicdc.detalhelivro;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
public class CrudLivrosController {

    @Autowired
    private AutorRepository autorRepository; // Para acessar as informações do autor
    @Autowired
    private Uploader uploader;
    @Autowired
    private LivroRepository livroRepository;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(new IsbnUnicoValidator(livroRepository), new TituloLivroUnicoValidator(livroRepository));
    }

    @PostMapping(value = "/api/livro", consumes = MediaType.MULTIPART_FORM_DATA_VALUE) // para o input media
    @Transactional
    @Operation(summary = "Cadastro de novo livro")
    public void novo(@ModelAttribute @Valid NovoLivroForm form) {
        Livro livro = form.novoLivro(autorRepository, uploader);
        livroRepository.save(livro);
    }
}

// Quando o form não recebe um multifile, ele não retorna nulo, mas sim vazio "". Então o erro não ocorre explicitamente
// Verificar como fazer uma validação para que o input vazio seja tratado como um erro.
