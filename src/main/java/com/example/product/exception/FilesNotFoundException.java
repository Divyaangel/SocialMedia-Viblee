package com.example.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FilesNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public FilesNotFoundException(String message) {
        super(message);
    }

    public FilesNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}