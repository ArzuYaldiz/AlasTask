package com.example.liquibase.Service.ımpl;

import com.example.liquibase.Entity.Product;
import com.example.liquibase.Entity.ShoppingCart;
import com.example.liquibase.Repository.ProductRepository;
import com.example.liquibase.Repository.ShoppingCartRepository;
import com.example.liquibase.Service.ShoppingProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ShoppingProductImpl implements ShoppingProductService {
    ShoppingCartRepository shoppingCartRepository;
    ProductRepository productRepository;

    @Override
    @CachePut(value = "shopping_cart_products", key = "#shopping_cart_id")
    public ShoppingCart addShoppingCart(int shopping_cart_id, int product_id) {

        ShoppingCart shoppingProducts = shoppingCartRepository.findById(shopping_cart_id);
        if (shoppingProducts == null) {
            throw new IllegalArgumentException("Shopping cart not found with ID: " + shopping_cart_id);
        }

        Product product = productRepository.findById(product_id);
        if (product == null) {
            throw new IllegalArgumentException("Product not found with ID: " + product_id);
        }

        shoppingCartRepository.addProductToShoppingCart(shopping_cart_id, product_id);

        return  shoppingCartRepository.save(shoppingProducts);
    }


    @Override
    @CacheEvict(value = "shopping_cart_products", key = "#shopping_cart_id")
    public void removeProductFromCart(int shopping_cart_id, int product_id) {
        ShoppingCart shoppingProducts = shoppingCartRepository.findById(shopping_cart_id);
        if (shoppingProducts == null) {
            throw new IllegalArgumentException("Shopping cart not found with ID: " + shopping_cart_id);
        }
        Product product = productRepository.findById(product_id);
        if (product == null) {
            throw new IllegalArgumentException("Product not found with ID: " + product_id);
        }

        shoppingCartRepository.removeProductFromShoppingCart(shopping_cart_id, product_id);

        shoppingCartRepository.save(shoppingProducts);

    }

    @Override

    @Cacheable(value = "shopping_cart_products", key = "#shopping_cart_id")
    public List<Object[]> getProductsFromCart(int shopping_cart_id) {
        ShoppingCart shoppingProducts = shoppingCartRepository.findById(shopping_cart_id);

        if (shoppingProducts == null) {
            throw new IllegalArgumentException("Shopping cart not found with ID: " + shopping_cart_id);
        }
        return shoppingCartRepository.getShoppingCart(shopping_cart_id);
    }
}
