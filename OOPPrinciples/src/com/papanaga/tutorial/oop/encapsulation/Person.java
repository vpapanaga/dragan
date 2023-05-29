package com.papanaga.tutorial.oop.encapsulation;

public class Person {
    private String name;
    private int age;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public Person setNameGood(String name) {
        this.name = name;
        return  this;
    }

    public Person setAgeGood(int ageGood) {
        this.age = ageGood;
        return  this;
    }

    public Person(String name, int age) {
        System.out.println("Call the  constructor with parameters");
        this.name = name;
        this.age = age;
    }

    public Person() {
        System.out.println("-> Call the  constructor without parameters");
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + ", Age: "+ this.getAge();
    }
}