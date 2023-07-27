package com.ecommerce.backend.exceptions;

public class ProductNotExistException extends Exception{
    public ProductNotExistException(String msg) {
        super(msg);
    }
}
