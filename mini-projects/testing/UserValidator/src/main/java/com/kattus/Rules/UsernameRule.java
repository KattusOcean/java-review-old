package com.kattus.Rules;

import com.kattus.User;
import com.kattus.Validator;
import com.kattus.ValidatorException;

public class UsernameRule extends Validator.Rule {

    @Override
    public void validate(User user) {
        String username = user.getUsername();
        if (username == null || username.isBlank()) {
            throw new ValidatorException("Username cannot be empty");
        }
    }
}
