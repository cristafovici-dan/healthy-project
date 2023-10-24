package com.example.healthy.DTO;

import javax.validation.constraints.NotNull;

public class CreateProductDTO {
  @NotNull(message = "Name cannot be null")
  private String name;
  
  private NutritionalInfo nutritionalInfo;

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
