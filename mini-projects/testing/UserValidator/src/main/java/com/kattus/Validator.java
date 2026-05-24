package com.kattus;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    private List<Rule> ruleList = new ArrayList<>();

    public void addRule(Rule rule) {
        ruleList.add(rule);
    }

    public void validate(User user) {
        for (Rule rule : ruleList) {
            rule.validate(user);
        }
    }

    public static abstract class Rule {
        public abstract void validate(User user);
    }
}
