package com.web_api.crud.service;

import java.util.List;
// import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.web_api.crud.dto.ProductRequestDTO;
import com.web_api.crud.dto.ProductResponseDTO;
import com.web_api.crud.model.Product;
import com.web_api.crud.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
    
    private final ProductRepository productRepository;

    public ProductResponseDTO createProduct(ProductRequestDTO dto){
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        // product.setUserId(dto.get);

        Product saved = productRepository.save(product);
        return mapToResponseDTO(saved);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts(){
        return productRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .toList() ;
    }

    /*
        It gonna try to get a product using its id, but if the product is not found in database 
        everything stop and an error message is thrown. The program will stop unless its caught elsewhere...
    */
    
    @Override
    public ProductResponseDTO getProduct(String id) {
        Product product = productRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Product not found"));
        return mapToResponseDTO(product);
    }

    @Override
    public ProductResponseDTO updateProduct(String id, ProductRequestDTO dto) {
        Product product = productRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        Product updated = productRepository.save(product);
        return mapToResponseDTO(updated);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
    
    private ProductResponseDTO mapToResponseDTO(Product product) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        return dto;
    }
}
