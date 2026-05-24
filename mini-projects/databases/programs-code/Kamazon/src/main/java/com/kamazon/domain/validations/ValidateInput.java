package main.java.com.kamazon.domain.validations;

import main.java.com.kamazon.application.port.ProductDto;
import main.java.com.kamazon.application.port.UserDto;

public class ValidateInput {
    public boolean isUserInputValid(UserDto userDto) {
        if (userDto.getName() == null || userDto.getName().isBlank()) return false;
        if (userDto.getEmail() == null || userDto.getEmail().isBlank()) return false;
        if (userDto.getPassword() == null || userDto.getPassword().isBlank()) return false;
        if (userDto.getRole() == null) return false;
        if (userDto.getBalance() < 0) return false;

        return true;
    }

    public boolean isProductInputValid(ProductDto productDto) {
        if (productDto.getName() == null || productDto.getName().isBlank()) return false;
        if (productDto.getPrice() < 0) return false;
        if (productDto.getCategory() == null) return false;
        if (productDto.getStock() < 0) return false;
        if (productDto.getRating() < 0 || productDto.getRating() > 5) return false;

        return true;
    }
}
