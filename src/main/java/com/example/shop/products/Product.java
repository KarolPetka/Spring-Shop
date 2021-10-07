package com.example.shop.products;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "description", length = 2000, nullable = true)
    private String description;

    @Column(name = "fileLocation", nullable = true)
    private String fileLocation;

    public Product() {
    }

    public Product(String name, int quantity, String description, String fileLocation) {
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.fileLocation = fileLocation;
    }

    public Product(Long id, String name, int quantity, String description, String fileLocation) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.fileLocation = fileLocation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }
}
