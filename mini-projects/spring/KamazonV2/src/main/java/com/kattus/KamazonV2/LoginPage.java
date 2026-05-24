package com.kattus.KamazonV2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginPage {

    @RequestMapping("login")
    public String login() {
        return "Place your data";
    }
}
