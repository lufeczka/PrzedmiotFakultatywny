package com.elista.functions.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

/**
 * Created by Thrundi on 2016-05-12.
 */
public class NullException extends Exception {
    HttpStatus status;
    HttpHeaders headers;

    public HttpStatus getStatus() {
        return status;
    }

    public HttpHeaders getHeaders() {
        return headers;
    }

    public NullException(String message, HttpStatus status, HttpHeaders headers) {
        super(message);

        this.status = status;
        this.headers = headers;
    }
}
