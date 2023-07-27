package com.ecommerce.backend.exceptions;

public class AuthenticationFailException extends Exception{
    public AuthenticationFailException(String msg) {
        super(msg);
    }
}
