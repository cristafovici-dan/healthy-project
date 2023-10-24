package com.example.healthy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.healthy.Entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
  
}
