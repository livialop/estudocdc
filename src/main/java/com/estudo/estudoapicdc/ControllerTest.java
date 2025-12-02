package com.estudo.estudoapicdc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTest {

    @GetMapping("/teste")
    public String teste() {
        return "deu certo a configuracao";
    }
}
