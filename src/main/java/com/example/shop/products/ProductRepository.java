package com.example.shop.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p.name FROM Product p WHERE p.name = :name")
    String findProductUsingName(@Param("name") String name);

    @Transactional
    @Modifying
    @Query("DELETE FROM Product p WHERE p.name = :name")
    void deleteProductByName(@Param("name") String name);
}
