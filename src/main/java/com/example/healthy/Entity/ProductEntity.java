package com.example.healthy.Entity;

import java.util.Date;

import jakarta.persistence.*;

@Entity(name = "PRODUCT")
public class ProductEntity  {
  @Id()
  @GeneratedValue(strategy =  GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "nutritional_info", columnDefinition = "TEXT" )
  private String nutritionalInfo;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", updatable = false)
  private Date createdAt;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "updated_at")
  private Date updatedAt;

  @PrePersist()
  protected void onCreate() {
    createdAt = new Date();
  }

  @PreUpdate()
  protected void onUpdate() {
    updatedAt = new Date();
  }

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

  public String getNutritionalInfo() {
    return nutritionalInfo;
  }

  public void setNutritionalInfo(String nutritionalInfo) {
    this.nutritionalInfo = nutritionalInfo;
  }

}
