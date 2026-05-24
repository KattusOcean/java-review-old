package main.java.com.kamazon.domain.validations;

public class ValidateAccess {
    public boolean isLogInValid(String email, String password) {
        if (email == null || email.isBlank()) return false;
        else if (password == null || password.isBlank()) return false;

        return true;
    }

    public boolean isRegistrationValid(String name, String email, String password) {
        if (name == null || name.isBlank()) return false;
        else if (email == null || email.isBlank()) return false;
        else if (password == null || password.isBlank()) return false;

        return true;
    }
}
