package com.example.shop.stores;

import com.example.shop.products.ProductRepository;
import com.example.shop.products.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StoreServiceTest {

    @Mock
    private StoreRepository repositoryTest;
    private StoreService serviceTest;

    @BeforeEach
    void setUp() {
        serviceTest = new StoreService(repositoryTest);
    }

    @Test
    void getStores() {
        fail();
    }

    @Test
    void postStore() {
        fail();
    }

    @Test
    void deleteStore() {
        fail();
    }
}