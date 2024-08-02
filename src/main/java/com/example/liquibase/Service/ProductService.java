package com.example.liquibase.Service;

import com.example.liquibase.Dto.ProductDto;
import com.example.liquibase.Entity.Product;

public interface ProductService {

    Product createProduct(ProductDto productDto);

    Product redisSave(int product_id, Product product);

    void removeProduct(int product_id);
}
