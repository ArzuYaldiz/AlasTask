package com.example.liquibase.Dto;

import com.example.liquibase.Entity.Productdetail;
import com.example.liquibase.Entity.Categories;

import lombok.Data;

@Data
public class ProductDto {
    private int id;
    private String name;
    private Productdetail productdetail;
    private Categories categories;
}
