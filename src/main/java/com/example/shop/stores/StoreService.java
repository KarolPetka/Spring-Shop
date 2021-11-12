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

    public ResponseEntity<String> deleteStore(Long storeId) {
            storeRepository.deleteById(storeId);
        if (storeRepository.findById(storeId).isPresent()) {
            return ResponseEntity.ok().body("Successfully deleted store with id " + storeId);
        } else return ResponseEntity.status(500).body("Could not find store with id " + storeId + " to delete");
    }
}
