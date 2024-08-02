package com.example.liquibase.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "products")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "products_id", nullable = false)
    private int products_id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "productdetail_id")
    @JsonManagedReference
    private Productdetail productdetail;

    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "category_id")
    @JsonManagedReference
    private Categories category;

    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<ShoppingCart> shoppingCarts = new LinkedHashSet<>();

    public Product(String productName, Productdetail productDetail, Categories category) {
        this.name = productName;
        this.productdetail = productDetail;
        this.category = category;

    }

    public Product() {

    }

    public int getId() {
        return products_id;
    }

    public void setId(Integer products_id) {
        this.products_id = products_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Productdetail getProductdetail() {
        return productdetail;
    }

    public void setProductdetail(Productdetail productdetail) {
        this.productdetail = productdetail;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public Set<ShoppingCart> getShoppingCarts() {
        return shoppingCarts;
    }

    public void setShoppingCarts(Set<ShoppingCart> shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }

}
