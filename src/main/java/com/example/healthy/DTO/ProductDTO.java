package com.example.healthy.DTO;

public class ProductDTO {
  private Long id;
  private String name;
  private NutritionalInfo nutritionalInfo;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public NutritionalInfo getNutritionalInfo() {
    return nutritionalInfo;
  }

  public void setNutritionalInfo(NutritionalInfo nutritionalInfo) {
    this.nutritionalInfo = nutritionalInfo;
  }
}
