package com.example.liquibase.Service.ımpl;

import com.example.liquibase.Dto.CategoriesDto;
import com.example.liquibase.Dto.ProductDetailDto;
import com.example.liquibase.Dto.ProductDto;
import com.example.liquibase.Entity.Categories;
import com.example.liquibase.Entity.Product;
import com.example.liquibase.Entity.Productdetail;
import com.example.liquibase.Repository.CategoriesRepository;
import com.example.liquibase.Repository.ProductDetailRepository;
import com.example.liquibase.Repository.ProductRepository;

import com.example.liquibase.Service.ProductService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Transactional
public class ProductImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductDetailRepository productDetailRepository;
    @Autowired
    CategoriesRepository categoriesRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Product createProduct(ProductDto productDto) {
        Product product = new Product();

        Productdetail productdetail = productDto.getProductdetail();

        int detail_id;
        int category_id;

        String color = productdetail.getColor();
        String image_url = productdetail.getImage_url();

        if(productDetailRepository.findProductDetailId(color, image_url) == 0){
            productDetailRepository.createProductDetail(color, image_url);
            detail_id = productDetailRepository.findProductDetailId(color, image_url);
        }
        else{
            detail_id = productDetailRepository.findProductDetailId(color, image_url);

        }
        product.setProductdetail(productDetailRepository.findById(detail_id)
                .orElseThrow(() -> new RuntimeException("Product detail not found")));

        Categories category = productDto.getCategories();
        String categoryname = category.getName();

        if(categoriesRepository.findCategoryId(categoryname) == 0){
            categoriesRepository.createCategory(categoryname);
            category_id = categoriesRepository.findCategoryId(categoryname);
        }
        else{
            product.setCategory(category);
            category_id = categoriesRepository.findCategoryId(categoryname);
        }

        product.setCategory(categoriesRepository.findById(category_id)
                .orElseThrow(() -> new RuntimeException("Category not found")));

        product.setName(productDto.getName());

        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    public void removeProduct(int product_id) {
        productRepository.deleteById(product_id);
    }


}
