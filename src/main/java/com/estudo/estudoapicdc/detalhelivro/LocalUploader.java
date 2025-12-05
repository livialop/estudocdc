package com.estudo.estudoapicdc.detalhelivro;

import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.InvalidMediaTypeException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import static org.apache.commons.lang3.StringUtils.length;

@Component
public class LocalUploader implements Uploader {

    @Override
    public String upload(MultipartFile file) {
        System.out.println("Enviando arquivo");
        String arq = "http://s3.amazon/bucket/"+file.getOriginalFilename();
        String[] filename = arq.split("http://s3.amazon/bucket");
        boolean valid = false;

        for (String name : filename) {
            if (length(name) > 1) {
                valid = true;
            }
        }

        if (valid) {
            return "http://s3.amazon/bucket/"+file.getOriginalFilename();
        } else {
            throw new MultipartException("Não tem arquivo.");
        }
    }
}
