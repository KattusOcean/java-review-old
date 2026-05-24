package main.java.com.kamazon.application.mapper;

import main.java.com.kamazon.application.port.ProductDto;
import main.java.com.kamazon.domain.entities.Product;

public class ProductMapper {
    public ProductDto toDto (Product product) {
        return new ProductDto (
                product.getName(),
                product.getPrice(),
                product.getCategory(),
                product.getStock(),
                product.getStock()
        );
    }

    public Product toEntity (ProductDto productDto) {
        return new Product (
                productDto.getName(),
                productDto.getPrice(),
                productDto.getCategory(),
                productDto.getStock(),
                productDto.getRating()
        );
    }
}
