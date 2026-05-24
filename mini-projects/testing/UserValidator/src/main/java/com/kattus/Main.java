package com.kattus;

import com.kattus.Rules.AgeRule;
import com.kattus.Rules.EmailRule;
import com.kattus.Rules.UsernameRule;

public class Main {
    static void main() {
        User user = new User("Alex", "alex@email.com", 19);
        Validator validator = new Validator();
        validator.addRule(new UsernameRule());
        validator.addRule(new AgeRule());
        validator.addRule(new EmailRule());

        try {
            validator.validate(user);
            System.out.println("Valid user");
        } catch (ValidatorException e) {
            System.out.println("Error during validation: " + e.getMessage());
        }
    }
}
