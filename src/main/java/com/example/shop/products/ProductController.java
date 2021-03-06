package com.example.shop.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping("/add")
    public ResponseEntity<String> postProduct(@RequestParam("name") String name, @RequestParam("quantity") int quantity, @RequestParam("description") String description, @RequestParam("file") MultipartFile file) {
        return productService.postProduct(name, quantity, description, file);
    }

    @DeleteMapping(path = "/{name}")
    public ResponseEntity<String> deleteProduct(@PathVariable String name) {
        return productService.deleteProduct(name);
    }
}
