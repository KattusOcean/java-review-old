package com.kattus.KamazonV2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePage {

    @RequestMapping("/")
    public String greet() {
        return "Hello, folk";
    }
}
