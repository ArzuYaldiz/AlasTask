package com.example.liquibase.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "productdetails")
public class Productdetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_details_id", nullable = false)
    private int id;

    @Column(name = "color")
    private String color;

    @Column(name = "image_url")
    private String image_url;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "productdetail",fetch = FetchType.LAZY)
    @JsonIgnore
    private Product product;

    public Productdetail(String color, String image_url) {
        this.color = color;
        this.image_url = image_url;
    }

    public Productdetail() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String imageUrl) {
        this.image_url = imageUrl;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}