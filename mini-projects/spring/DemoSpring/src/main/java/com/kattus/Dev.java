package com.kattus;

public class Dev {

    // Attributes
    private Computer computer;
//    private String name;
//    private int age;
//    private String tech;

    // Constructor
    public Dev() {
        System.out.println("Dev constructor");
    }

//    public Dev(String name, int age, String tech) {
//        this.name = name;
//        this.age = age;
//        this.tech = tech;
//        System.out.println("Dev constructor with name, age and tech??");
//    }

    public Dev(Computer computer) {
        this.computer = computer;
    }

    // Getters and setters

//    public Laptop getLaptop() {
//        return laptop;
//    }
//
//    public void setLaptop(Laptop laptop) {
//        this.laptop = laptop;
//    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getTech() {
//        return tech;
//    }
//
//    public void setTech(String tech) {
//        this.tech = tech;
//    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    // Methods
    public void build() {
        System.out.println("Hey, im the D.O.A.T. (Dev Of The Year)!");
        computer.compile();
    }

}
