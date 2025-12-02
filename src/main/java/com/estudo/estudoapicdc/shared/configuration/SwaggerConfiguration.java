package com.estudo.estudoapicdc.shared.configuration;

import io.swagger.v3.oas.models.annotations.OpenAPI30;
import org.springframework.context.annotation.Configuration;

@OpenAPI30
@Configuration
public class SwaggerConfiguration {

    public static void main (String[] args) {
        System.out.println("Classe de configuração do Swagger. Utilizando o SpringDoc OpenAPI 3.0");
    }
}
