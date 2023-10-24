package com.example.healthy.DTO;

public class NutritionalInfo {
  private int kcal;
  private double protein;
  private double fat;
  private double carbohydrates;

  public int getKcal() {
    return kcal;
  }

  public void setKcal(int kcal) {
    this.kcal = kcal;
  }

  public double getProtein() {
    return protein;
  }

  public void setProtein(double protein) {
    this.protein = protein;
  }

  public double getFat() {
    return fat;
  }

  public void setFat(double fat) {
    this.fat = fat;
  }

  public double getCarbohydrates() {
    return carbohydrates;
  }

  public void setCarbohydrates(double carbohydrates) {
    this.carbohydrates = carbohydrates;
  }
}