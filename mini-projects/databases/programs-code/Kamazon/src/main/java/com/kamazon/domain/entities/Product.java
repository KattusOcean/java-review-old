package main.java.com.kamazon.domain.entities;

import main.java.com.kamazon.domain.enums.ProductCategory;

public class Product {
    private String name;
    private double price;
    private ProductCategory category;
    private int stock;
    private double rating;

    public Product(String name, double price, ProductCategory category, int stock, double rating) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.rating = rating;

        validateProductFields();
        validateProductBusinessRules();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Product{ Name: " + name + " | Price: " + price + " | Category: " + category + " | Stock: " + stock + " | Rating: " + rating + " }";
    }

    public void validateProductFields() {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name is required");
        if (price < 0) throw new IllegalArgumentException("Price is required");
        if (category == null) throw new IllegalArgumentException("Category is required");
        if (stock < 0) throw new IllegalArgumentException("Stock is required");
        if (rating < 0 || rating > 5) throw new IllegalArgumentException("Rating is required");
    }

    public void validateProductBusinessRules() {
        if (price < 0) throw new IllegalStateException("Price cannot be negative");
        if (stock < 0) throw new IllegalStateException("Stock cannot be negative");
        if (rating < 0 || rating > 5) throw new IllegalStateException("Rating must be between 0 and 5");

        if (
                category == ProductCategory.TECHNOLOGY ||
                category == ProductCategory.SPORT ||
                category == ProductCategory.FOOD ||
                category == ProductCategory.CLOTHING ||
                category == ProductCategory.BOOKS
        ) {
            throw new IllegalStateException("Product must have a fixed category");
        }
    }
}
