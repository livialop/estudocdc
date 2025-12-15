package com.estudo.estudoapicdc.shared;

import com.estudo.estudoapicdc.site.detalhe.Carrinho;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.util.Base64;

@Component
public class Cookies {

    /**
     *
     * @param key - chave que vai ser gerada para o cookie
     * @param carrinho - carrinho de compras
     * @param response
     */

    public void writeAsJson(String key, Carrinho carrinho, HttpServletResponse response) {

        String json = new ObjectMapper().writeValueAsString(carrinho);
        String encoded = Base64.getUrlEncoder().encodeToString(json.getBytes());

        Cookie cookie = new Cookie(key, encoded);
        cookie.setHttpOnly(true);
        cookie.setPath("/");

        response.addCookie(cookie);
    }
}
