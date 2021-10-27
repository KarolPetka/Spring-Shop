package com.example.shop.products;

import com.example.shop.exception.FileStorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

@Service
public class ProductService {

    protected final String targetLocation = "./uploads/products";
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void postProduct(String name, int quantity, String description, MultipartFile file) {
        String fileName = "";

        if (file.getSize() > 0) {
            Random random = new Random();
            fileName = StringUtils.cleanPath(random.nextInt(10000) + "-" + file.getOriginalFilename());
            try {
                Files.write(Paths.get(targetLocation).resolve(fileName), file.getBytes());
            } catch (IOException ex) {
                throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
            }
        }

        Product product = new Product(name, quantity, description, fileName.equals("") ? fileName : targetLocation + "/" + fileName);
        productRepository.save(product);
    }
}
