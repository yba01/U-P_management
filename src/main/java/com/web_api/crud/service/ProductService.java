package com.web_api.crud.service;

import java.util.List;

import com.web_api.crud.dto.ProductRequestDTO;
import com.web_api.crud.dto.ProductResponseDTO;

public interface ProductService {
    ProductResponseDTO createProduct(ProductRequestDTO dto);
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProduct(String id);
    void deleteProduct(String id);
    ProductResponseDTO updateProduct(String id, ProductRequestDTO dto);
}
