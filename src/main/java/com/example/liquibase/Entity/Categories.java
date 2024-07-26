package com.example.liquibase.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categories_id", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "category", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Product> products = new LinkedHashSet<>();

    public Categories(String name) {
        this.name = name;
    }

    public Categories() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

}
