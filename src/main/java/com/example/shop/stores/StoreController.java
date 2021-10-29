package com.example.shop.stores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/stores")
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public List<Store> getStores() {
        return storeService.getStores();
    }

    @PostMapping("/add")
    public ResponseEntity<String> postStore(@RequestParam("location") String location) {
        return storeService.postStore(location);
    }
}
