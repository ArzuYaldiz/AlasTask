package com.example.liquibase.Repository;

import com.example.liquibase.Entity.ShoppingCart;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO shopping_cart_products (cart_id, product_id) VALUES (:cart_id, :productId)", nativeQuery = true)
    void addProductToShoppingCart(int cart_id, int productId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM shopping_cart_products WHERE cart_id = (:cart_id) and product_id= (:productId) LIMIT 1;", nativeQuery = true)
    void removeProductFromShoppingCart(int cart_id, int productId);


    ShoppingCart findById(int cartId);


    @Transactional
    @Modifying
    @Query(value = "SELECT p.name AS product_name, c.name AS category_name " +
            "FROM shopping_cart_products scp INNER JOIN products p " +
            "ON scp.product_id = p.products_id INNER JOIN categories c ON p.category_id = c.categories_id " +
            "Where scp.cart_id = :cart_id", nativeQuery = true)
    List<Object[]> getShoppingCart(int cart_id);

}