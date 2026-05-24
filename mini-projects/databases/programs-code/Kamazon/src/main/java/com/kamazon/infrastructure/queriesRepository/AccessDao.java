package main.java.com.kamazon.infrastructure.queriesRepository;

import main.java.com.kamazon.domain.entities.User;

public interface AccessDao {
    User logIn(String email, String password);
    void register(String name, String email, String password);
}
