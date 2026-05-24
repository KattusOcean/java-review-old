package com.kattus;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        // Both are valid
//        Dev dev = applicationContext.getBean(Dev.class);
        Dev dev = (Dev) applicationContext.getBean("dev");
//        System.out.println("Name: " + dev.getName() + " | Age: " + dev.getAge() + " | Tech: " + dev.getTech());
        dev.build();
    }

}
