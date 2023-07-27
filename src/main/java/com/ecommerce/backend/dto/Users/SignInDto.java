package com.ecommerce.backend.dto.Users;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInDto {
    private String email;
    private String password;
}
