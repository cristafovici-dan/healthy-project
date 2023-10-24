package com.example.healthy.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.healthy.DTO.CreateProductDTO;
import com.example.healthy.DTO.NutritionalInfo;
import com.example.healthy.DTO.ProductDTO;
import com.example.healthy.Entity.ProductEntity;
import com.example.healthy.Exception.CustomException;
import com.example.healthy.Repository.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service()
public class ProductService {
  @Autowired()
  private ProductRepository productRepository;

   private ProductDTO convertToDTO(ProductEntity productEntity) {
    ProductDTO productDTO = new ProductDTO();
    productDTO.setId(productEntity.getId());
    productDTO.setName(productEntity.getName());

    ObjectMapper objectMapper = new ObjectMapper();

    try {
        NutritionalInfo nutritionalInfo = objectMapper.readValue(productEntity.getNutritionalInfo(), NutritionalInfo.class);
        productDTO.setNutritionalInfo(nutritionalInfo);
    } catch (JsonProcessingException e) {
        throw new CustomException("Error parsing nutritionalInfo JSON: " + e.getMessage());
    }

    return productDTO;
  }


  public List<ProductDTO> getAllProducts() {
    List<ProductEntity> products = productRepository.findAll();

    return products
      .stream()
      .map(this::convertToDTO)
      .collect(Collectors.toList());
  }
 
  public ProductDTO getProductById(Long id) {
    ProductEntity productEntity = productRepository
      .findById(id)
      .orElseThrow(() -> new CustomException("Product with id " + id + " was not found"));
     
    ProductDTO product = new ProductDTO();
    product.setId(productEntity.getId());
    product.setName(productEntity.getName());
    
    ObjectMapper objectMapper = new ObjectMapper();

    try {
      NutritionalInfo nutritionalInfo = objectMapper.readValue(productEntity.getNutritionalInfo(), NutritionalInfo.class);
      product.setNutritionalInfo(nutritionalInfo);
    } catch( JsonProcessingException e) {
      throw new CustomException("Error parsing nutritionalInfo JSON: " + e.getMessage());
    }
    
    return product;
  }

  public ProductEntity create(CreateProductDTO dataPayload) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    String nutritionalInfoJson = objectMapper.writeValueAsString(dataPayload.getNutritionalInfo());

    ProductEntity productEntity = new ProductEntity();

    productEntity.setName(dataPayload.getName());
    productEntity.setNutritionalInfo(nutritionalInfoJson);

    return productRepository.save(productEntity);
  }

  
}
