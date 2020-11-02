package com.recipe.backend.Models;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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

  @NonNull 
  @Column(name = "INGREDIENT_NAME")
  public String name;

  @ManyToOne()
  @JoinColumn(name ="CATEGORY_ID")
  public IngredientCategory categoryID;

  @Column(name = "IMAGE")
  public String image;

  public void setName(String name){
    this.name = name;
  }
}