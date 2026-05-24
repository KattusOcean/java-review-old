package main.java.com.kamazon.application.port;

import main.java.com.kamazon.domain.enums.UserRole;

public class UserDto {
    private final String name;
    private final String email;
    private final String password;
    private final UserRole role;
    private final Double balance;

    public UserDto(String name, String email, String password, UserRole role, Double balance) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }

    public Double getBalance() {
        return balance;
    }
}
