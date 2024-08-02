package com.example.liquibase.Controller;

import com.example.liquibase.Dto.ProductDto;
import com.example.liquibase.Entity.Product;
import com.example.liquibase.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto request) {

        if(request == null) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("AAAAA");
        }

        Product createdProduct = productService.createProduct(request);
        productService.redisSave(createdProduct.getId(), createdProduct);

        return ResponseEntity.ok(createdProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") int id) {
        productService.removeProduct(id);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product deleted from cart successfully");
    }
}
