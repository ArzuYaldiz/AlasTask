package com.example.liquibase.Repository;

import com.example.liquibase.Entity.Categories;
import com.example.liquibase.Entity.Productdetail;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository <Categories, Integer> {

    @Query(value = "SELECT COALESCE(MAX(categories_id), 0) FROM categories WHERE name = :name", nativeQuery = true)
    int findCategoryId(String name);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO categories (name) VALUES (:name)", nativeQuery = true)
    void createCategory(String name);
}
