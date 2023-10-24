package com.example.healthy.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.healthy.DTO.CreateProductDTO;
import com.example.healthy.DTO.ProductDTO;
import com.example.healthy.Entity.ProductEntity;
import com.example.healthy.Exception.CustomException;
import com.example.healthy.Service.ProductService;

@RestController()
@RequestMapping("/api/product")
public class ProductController {
  @Autowired()
  private ProductService productService;

  @GetMapping("/")
  public List<ProductDTO> getAllProducts() {
    try {
      return productService.getAllProducts();
    } catch(Exception e) {
      throw new CustomException(e.getMessage());
    }
  }

  @GetMapping("{id}")
  public ProductDTO getProductById(@PathVariable Long id) {
    try {
      return productService.getProductById(id);
    } catch(Exception e) {
      throw new CustomException(e.getMessage());
    }
  }

  @PostMapping("/")
  public ProductEntity createProduct(@RequestBody() CreateProductDTO payload) {
    try {
      return productService.create(payload);
    } catch(Exception e) {
      throw new CustomException(e.getMessage());
    }
  }

}
