package com.example.liquibase.Repository;

import com.example.liquibase.Entity.Productdetail;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends JpaRepository <Productdetail, Integer> {

    Productdetail findByProductId(int id);

    @Query(value = "SELECT COALESCE(MAX(product_details_id), 0) FROM productdetails WHERE color = :color and image_url = :image_url", nativeQuery = true)
    int findProductDetailId(String color, String image_url);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO productdetails (color, image_url) VALUES (:color, :image_url)", nativeQuery = true)
    void createProductDetail(String color, String image_url);
}
