package com.example.shop.products;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repositoryTest;

    @BeforeEach
    void setUp() {
        repositoryTest.deleteAll();
    }


    @Test
    void findProductUsingName() {
        fail();
    }

    @Test
    void deleteProductByName() {
        fail();
    }
}
