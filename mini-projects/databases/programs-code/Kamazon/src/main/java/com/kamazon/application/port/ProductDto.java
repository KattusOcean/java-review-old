package main.java.com.kamazon.application.port;

import main.java.com.kamazon.domain.enums.ProductCategory;

public class ProductDto {
    private final String name;
    private final double price;
    private final ProductCategory category;
    private final int stock;
    private final double rating;

    public ProductDto(String name, double price, ProductCategory category, int stock, double rating) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public int getStock() {
        return stock;
    }

    public double getRating() {
        return rating;
    }
}
