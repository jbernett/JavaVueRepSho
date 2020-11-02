package com.recipe.backend.Models;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Table(name = "INGREDIENT_CATEGORY")
public class IngredientCategory {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    public Long id;

    @NonNull
    @Column(name = "CATEGORY_NAME")
    public String name;

    public void setName(String name){
        this.name = name;
    }
}