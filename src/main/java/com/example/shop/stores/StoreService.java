package com.example.shop.stores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    private final StoreRepository storeRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<Store> getStores() {
        return storeRepository.findAll();
    }

    public ResponseEntity<String> postStore(String location) {
        Store store = new Store(location);
        storeRepository.save(store);
        return ResponseEntity.ok().body("Store added to database");
    }
}
