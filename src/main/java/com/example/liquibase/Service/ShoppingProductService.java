package com.example.liquibase.Service;

import com.example.liquibase.Entity.Product;
import com.example.liquibase.Entity.ShoppingCart;
import com.example.liquibase.Repository.ProductRepository;
import com.example.liquibase.Repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ShoppingProductService {

    void removeProductFromCart(int shopping_cart_id, int product_id);

    ShoppingCart addShoppingCart(int shopping_cart_id, int product_id);

    List<Object[]> getProductsFromCart(int shopping_cart_id);
}
