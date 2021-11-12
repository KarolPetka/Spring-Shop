package com.example.shop.products;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository repositoryTest;
    private ProductService serviceTest;

    @BeforeEach
    void setUp() {
        serviceTest = new ProductService(repositoryTest);
    }

    @Test
    void getProducts() {
        //when
        serviceTest.getProducts();

        //then
        verify(repositoryTest).findAll();
    }

    @Test
    void postProduct() throws IOException {
        //given
        Path path = Paths.get("./uploads/products/karo.jpg");
        String name = "karo.jpg";
        String originalFileName = "karo.jpg";
        String contentType = "image/jpeg";
        byte[] content = Files.readAllBytes(path);
        MultipartFile file = new MockMultipartFile(name, originalFileName, contentType, content);

        Product product = new Product("Product Name", 1, "Description of product that is tested", serviceTest.targetLocation + "/" + file.getOriginalFilename());

        //when
        serviceTest.postProduct(product.getName(), product.getQuantity(), product.getDescription(), file);

        //then
        ArgumentCaptor<Product> productArgumentCaptor = ArgumentCaptor.forClass(Product.class);
        verify(repositoryTest).save(productArgumentCaptor.capture());
        Product capturedProduct = productArgumentCaptor.getValue();

        assertEquals(product.getName(), capturedProduct.getName());
        assertEquals(product.getQuantity(), capturedProduct.getQuantity());
        assertEquals(product.getDescription(), capturedProduct.getDescription());
        assertEquals(product.getFileLocation(), capturedProduct.getFileLocation());
    }

    @Test
    void deleteProduct() throws IOException {
        //given
        Path path = Paths.get("./uploads/products/karo.jpg");
        String name = "karo.jpg";
        String originalFileName = "karo.jpg";
        String contentType = "image/jpeg";
        byte[] content = Files.readAllBytes(path);
        MultipartFile file = new MockMultipartFile(name, originalFileName, contentType, content);

        Product product = new Product("Product Name", 1, "Description of product that is tested", serviceTest.targetLocation + "/" + file.getOriginalFilename());

        //when
        serviceTest.deleteProduct(product.getName());

        //then
        verify(repositoryTest, times(1)).deleteProductByName(product.getName());
    }
}