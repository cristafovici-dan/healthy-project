package com.example.healthy.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.healthy.Entity.ProductEntity;
import com.example.healthy.Repository.ProductRepository;

@Service()
public class ProductService {
  @Autowired()
  private ProductRepository productRepository;

  public List<ProductEntity> getAllProducts() {
    return productRepository.findAll();
  }

  public ProductEntity getProductById(Long id) {
    return productRepository.findById(id).orElseThrow();
  }

  public ProductEntity create(ProductEntity dataPayload) {
    return productRepository.save(dataPayload);
  }

  
}
