package com.ecommerce.backend.exceptions;

public class CartItemsNotExistException extends Exception{
    public CartItemsNotExistException(String msg) {
        super(msg);
    }

}
