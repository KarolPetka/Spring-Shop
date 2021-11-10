package com.example.shop.products;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repositoryTest;

    @BeforeEach
    @AfterEach
    void setUp() {
        repositoryTest.deleteAll();
    }

    @Test
    void findProductUsingName() {
        //given
        Product product = new Product("Product Name", 1, null, null);
        repositoryTest.save(product);

        //when
        String productName = repositoryTest.findProductUsingName(product.getName());

        //then
        assertEquals(productName, product.getName());
        assertNotEquals("Not existing product", product.getName());
    }

    @Test
    void deleteProductByName() {
        //given
        Product product = new Product("Product Name", 1, null, null);
        repositoryTest.save(product);

        //when
        repositoryTest.deleteProductByName(product.getName());
        List<Product> listAfterDelete = repositoryTest.findAll();

        //then
        assertTrue(listAfterDelete.isEmpty());
    }
}
