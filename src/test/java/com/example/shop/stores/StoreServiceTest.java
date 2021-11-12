package com.example.shop.stores;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
        //when
        serviceTest.getStores();

        //then
        verify(repositoryTest).findAll();
    }

    @Test
    void postStore() {
        //given
        Store store = new Store("USA");

        //when
        serviceTest.postStore(store.getLocation());

        //then
        ArgumentCaptor<Store> storeArgumentCaptor = ArgumentCaptor.forClass(Store.class);
        verify(repositoryTest).save(storeArgumentCaptor.capture());
        Store capturedStore = storeArgumentCaptor.getValue();

        assertEquals(store.getLocation(), capturedStore.getLocation());
    }

    @Test
    void deleteStore() {
        //given
        Store store = new Store(1L, "USA");

        //when
        serviceTest.deleteStore(store.getId());

        //then
        verify(repositoryTest, times(1)).deleteById(store.getId());
    }
}