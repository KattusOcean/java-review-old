package main.java.com.kamazon.domain.entities;

import main.java.com.kamazon.domain.enums.UserRole;

public class User {
    private String name;
    private String email;
    private String password;
    private UserRole role;
    private Double balance;

    public User(String name, String email, String password, UserRole role, Double balance) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.balance = balance;

        validateUserFields();
        validateUserBusinessRules();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{ Name: " + name + " | Email: " + email + " | Password: " + password + " | Role: " + role + " | Balance: " + balance + " }";
    }

    public void validateUserFields() {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name is required");
        if (email == null || email.isBlank()) throw new IllegalArgumentException("Email is required");
        if (password == null || password.isBlank()) throw new IllegalArgumentException("Password is required");
        if (role == null) throw new IllegalArgumentException("Role is required");
    }

    public void validateUserBusinessRules() {
        if (role == UserRole.ADMIN && balance != null) {
            throw new IllegalStateException("Admin must not have balance (null)");
        }

        if (role == UserRole.CLIENT && balance < 0) {
            throw new IllegalStateException("Client cannot have a negative balance");
        }
    }
}
