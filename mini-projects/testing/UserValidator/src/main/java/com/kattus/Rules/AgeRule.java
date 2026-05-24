package com.kattus.Rules;

import com.kattus.User;
import com.kattus.Validator;
import com.kattus.ValidatorException;

public class AgeRule extends Validator.Rule {

    @Override
    public void validate(User user) {
        int age = user.getAge();
        if (age <= 0) {
            throw new ValidatorException("User age must be positive");
        } else if (age < 18) {
            throw new ValidatorException("User must be over age (18+)");
        }
    }
}
