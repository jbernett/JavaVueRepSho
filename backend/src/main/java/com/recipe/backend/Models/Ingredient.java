package com.recipe.backend.Models;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity  
@Data  
@NoArgsConstructor  
@Table(name="INGREDIENT")
public class Ingredient {  
      
  @Id
  @GeneratedValue
  @Column(name = "ID")
  public Long id;  

  @Column(name = "MANUFACTURER")
  public String manufacturer;

  @Column(name = "FDC_ID")
  public Integer fdcId;

  @NotNull 
  @Column(name = "INGREDIENT_NAME")
  public String name;

  @ManyToOne()
  @JoinColumn(name ="CATEGORY_ID")
  public IngredientCategory categoryID;

  @Column(name = "IMAGE_URL")
  public String imageUrl;

  public void setName(String name){
    this.name = name;
  }

  public void setManufacturer(String manufacturer){
    this.manufacturer = manufacturer;
  }

  public void setFdcId(Integer facId){
    this.fdcId = facId;
  }

  public void setImage(String imageUrl){
    this.imageUrl = imageUrl;
  }
}