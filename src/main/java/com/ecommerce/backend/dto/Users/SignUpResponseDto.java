package com.ecommerce.backend.dto.Users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponseDto {
    private String status;
    private String message;
    
    public SignUpResponseDto(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
