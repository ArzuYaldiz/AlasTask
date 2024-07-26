package com.example.liquibase.Controller;

import com.example.liquibase.Dto.ProductDto;
import com.example.liquibase.Dto.ShoppingCartDto;
import com.example.liquibase.Entity.Product;
import com.example.liquibase.Entity.ShoppingCart;
import com.example.liquibase.Service.ShoppingCartService;
import com.example.liquibase.Service.ShoppingProductService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shopping-carts")
@RequiredArgsConstructor
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;
    private final ShoppingProductService shoppingProductService;

    @PostMapping
    public ResponseEntity<String> createShoppingCart(@RequestBody ShoppingCartDto request) {
        if (request.getName() == null || request.getName().isEmpty()) {
            return ResponseEntity.badRequest().body("Name cannot be empty");
        }
        shoppingCartService.createShoppingCart(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Shopping cart created successfully");
    }

    @PostMapping("/{id}/product")
    public ResponseEntity<String> addShoppingCart(@PathVariable("id") int cartId, @RequestBody ProductDto request) {
        int product_id = request.getId();
        System.out.println(product_id);

        try {
            int updatedCartId = shoppingProductService.addShoppingCart(cartId, product_id);

            return ResponseEntity.status(HttpStatus.CREATED).body("Product added to shopping cart successfully. ShoppingCart ID: " + updatedCartId);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}/product/{productId}")
    public ResponseEntity<String> RemoveProduct(@PathVariable("id") int cartId, @PathVariable("productId") int product_id) {
        shoppingProductService.removeProductFromCart(cartId, product_id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product deleted from cart successfully");

    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Map<String, String>>> getShoppingCart(@PathVariable("id") int cartId) {
        List<Object[]> Products = shoppingProductService.getProductsFromCart(cartId);

        if (Products.isEmpty()) {
            throw new IllegalArgumentException("No products found in the shopping cart with ID: " + cartId);
        }

        List<Map<String, String>> productArray = new ArrayList<>();
        for(Object[] product : Products){
            Map<String, String> productMap = new HashMap<>();
            productMap.put("Name", product[1].toString());
            productMap.put("Category", product[0].toString());
            productArray.add(productMap);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(productArray);
    }


}
