package main.java.com.kamazon.infrastructure.queriesRepository;

import main.java.com.kamazon.domain.entities.Product;
import main.java.com.kamazon.domain.entities.User;

public interface EntitiesDao {
    void addUser (User user);
    void addProduct(Product product);
    Integer getUserId(String email);
}
