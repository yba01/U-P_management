package com.web_api.crud.dto;

import lombok.Data;

@Data
public class UserResponseDTO {
    
    private String name;
    private String email;
    private String role;
}
