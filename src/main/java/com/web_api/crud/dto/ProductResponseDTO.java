package com.web_api.crud.dto;

import lombok.Data;

@Data
public class ProductResponseDTO {
    private String Id;
    private String name;
    private String description;
    private Double price;
}
