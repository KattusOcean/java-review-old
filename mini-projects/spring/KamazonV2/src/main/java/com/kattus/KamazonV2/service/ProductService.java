package com.kattus.KamazonV2.service;

import com.kattus.KamazonV2.model.Product;
import com.kattus.KamazonV2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

//    List<Product> products = new ArrayList<>(Arrays.asList(
//            new Product(1000, "Tablet", 250),
//            new Product(1001, "Water bottle", 3),
//            new Product(1002, "Book", 24.99F)
//    ));

    public List<Product> getProducts() {
//        return products;
        return productRepository.findAll();
    }

    public Product getProductById(int proId) {
//        return products.stream()
//                .filter(product -> product.getProdId() == proId)
//                .findFirst().get();
        return productRepository.findById(proId).orElse(new Product());
    }

    public void addProduct(Product product) {
//        products.add(product);
        productRepository.save(product);
    }

    public void updateProduct(Product product) {
//        int index = 0;
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getProdId() == product.getProdId()) {
//                index = i;
//            }
//        }
//        products.set(index, product);
        productRepository.save(product);
    }

    public void deleteProduct(int prodId) {
//        int index = 0;
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getProdId() == prodId) {
//                index = i;
//            }
//        }
//        products.remove(index);
        productRepository.deleteById(prodId);
    }
}
