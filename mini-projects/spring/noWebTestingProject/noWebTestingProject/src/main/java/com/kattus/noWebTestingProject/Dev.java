package com.kattus.noWebTestingProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dev {

    // Field injection (not the best)
//    @Autowired
    Laptop laptop;

    // Constructor injection (@Autowired is by default, so it can be avoided)
    @Autowired
    public Dev(Laptop laptop) {
        this.laptop = laptop;
    }

    // Setter injection
//    @Autowired
//    public void setLaptop(Laptop laptop) {
//        this.laptop = laptop;
//    }

    public void build() {
        System.out.println("Hey, im the D.O.A.T. (Dev Of The Year)!");
        laptop.compile();
    }

}
