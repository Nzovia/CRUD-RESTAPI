package com.example.crudrestapi.model;

import javax.persistence.*;

@Entity
@Table(name = "product_details")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column(name = "name")
    private String productName;
    @Column(name = " price")
    private String price;

    public Product() {
    }

    public Product(Long productId, String productName, String price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
