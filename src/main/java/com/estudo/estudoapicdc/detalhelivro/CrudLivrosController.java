package com.estudo.estudoapicdc.detalhelivro;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrudLivrosController {

    @PostMapping(value = "/api/livro", consumes = MediaType.MULTIPART_FORM_DATA_VALUE) // para o input media
    @Operation(summary = "Cadastro de novo livro")
    //@ApiResponses({
    //        @ApiResponse(responseCode = "200", description = "Novo livro cadastrado.")
    //})
    public void novo(@ModelAttribute @Valid NovoLivroForm form) {
        System.out.println("Teste");
    }
}
