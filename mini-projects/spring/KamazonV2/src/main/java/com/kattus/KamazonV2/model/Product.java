package com.kattus.KamazonV2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@Entity
public class Product {

    @Id
    private int prodId;
    private String prodName;
    private float price;

    public Product() {
    }

    public Product(int prodId, String prodName, float price) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.price = price;
    }
}
