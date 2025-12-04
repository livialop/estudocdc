package com.estudo.estudoapicdc.detalhelivro;

import org.springframework.web.multipart.MultipartFile;

@FunctionalInterface
public interface Uploader {

    public String upload(MultipartFile file);
}
