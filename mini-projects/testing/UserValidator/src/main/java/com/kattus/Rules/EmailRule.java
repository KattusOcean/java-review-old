package com.kattus.Rules;

import com.kattus.User;
import com.kattus.Validator;
import com.kattus.ValidatorException;

public class EmailRule extends Validator.Rule {

    @Override
    public void validate(User user) {
        String email = user.getEmail();

        if (email == null || email.isBlank()) {
            throw new ValidatorException("Email cannot be empty");
        } else if (!email.contains("@")) {
            throw new ValidatorException("Email must contain '@'");
        }
//        else if (email.matches("")) {
//            throw new ValidatorException("Email cannot have any other sign except from '.'");
//        }
    }
}
