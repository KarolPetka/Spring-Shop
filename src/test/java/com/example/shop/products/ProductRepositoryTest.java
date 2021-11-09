package com.example.shop.products;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repositoryTest;

    @BeforeEach
    void setUp() {
        repositoryTest.deleteAll();
    }


}
