package com.example.liquibase.Service.ımpl;

import com.example.liquibase.Entity.Product;
import com.example.liquibase.Entity.ShoppingCart;
import com.example.liquibase.Repository.ProductRepository;
import com.example.liquibase.Repository.ShoppingCartRepository;
import com.example.liquibase.Service.ShoppingProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ShoppingProductImpl implements ShoppingProductService {
    ShoppingCartRepository shoppingCartRepository;
    ProductRepository productRepository;


    @Override
    public int addShoppingCart(int shopping_cart_id, int product_id) {

        ShoppingCart shoppingProducts = shoppingCartRepository.findById(shopping_cart_id);
        if (shoppingProducts == null) {
            throw new IllegalArgumentException("Shopping cart not found with ID: " + shopping_cart_id);
        }

        Product product = productRepository.findById(product_id);
        if (product == null) {
            throw new IllegalArgumentException("Product not found with ID: " + product_id);
        }

        shoppingCartRepository.addProductToShoppingCart(shopping_cart_id, product_id);

        shoppingCartRepository.save(shoppingProducts);

        return shoppingProducts.getId();

    }

    @Override
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
    public List<Object[]> getProductsFromCart(int shopping_cart_id) {
        ShoppingCart shoppingProducts = shoppingCartRepository.findById(shopping_cart_id);

        if (shoppingProducts == null) {
            throw new IllegalArgumentException("Shopping cart not found with ID: " + shopping_cart_id);
        }
        return shoppingCartRepository.getShoppingCart(shopping_cart_id);
    }
}
