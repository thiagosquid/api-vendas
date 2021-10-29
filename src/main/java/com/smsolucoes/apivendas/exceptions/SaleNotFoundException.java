package com.smsolucoes.apivendas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SaleNotFoundException extends Exception{
    public SaleNotFoundException (Long id){
        super(String.format("Client with ID %s not found", id));
    }
}
