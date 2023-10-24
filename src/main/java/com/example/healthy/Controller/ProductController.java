package com.example.healthy.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.healthy.Entity.ProductEntity;
import com.example.healthy.Service.ProductService;

@RestController()
@RequestMapping("/api/product/")
public class ProductController {
  @Autowired()
  private ProductService productService;

  @GetMapping("/")
  public List<ProductEntity> getAllProducts() {
    return productService.getAllProducts();
  }

  @GetMapping("{id}")
  public ProductEntity getProductById(@PathVariable Long id) {
    return productService.getProductById(id);
  }

  @PostMapping("/")
  public ProductEntity createProduct(@RequestBody() ProductEntity payload) {
    return productService.create(payload);
  }

}
