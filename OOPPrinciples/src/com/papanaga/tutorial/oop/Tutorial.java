package com.papanaga.tutorial.oop;

import com.papanaga.tutorial.oop.abstraction.*;
import com.papanaga.tutorial.oop.encapsulation.Person;
import com.papanaga.tutorial.oop.inheritance.Bicycle;
import com.papanaga.tutorial.oop.inheritance.MountainBike;
import com.papanaga.tutorial.oop.polymorphism.Helper;

public class Tutorial {
    public static void main(String[] args) {
        System.out.println("The Object Oriented Main principles are: ");
        System.out.println("\ta. Abstraction");
        System.out.println("\tb. Encapsulation");
        System.out.println("\tc. Polymorphism");
        System.out.println("\td. Inheritance");
        System.out.println("");

        //    TestAbstraction();
        //    TestEncapsulation();
        //   TestInheritance();
        TestPolymorphism();
    }

    private static void TestPolymorphism() {
        Helper myHelper = new Helper();

        System.out.println("myHelper.Multiply(4,7) = " + myHelper.Multiply(4, 7));
        System.out.println("myHelper.Multiply(4.7,9.9) = " + myHelper.Multiply(4.7, 9.9));
        System.out.println("myHelper.Multiply(3,5,6) = " + myHelper.Multiply(3, 5, 6));
        System.out.println("myHelper.Multiply(3.7,8.9,11.9) = " + myHelper.Multiply(3.7, 8.9, 11.9));
    }

    private static void TestAbstraction() {
        System.out.println("This is  the test of Abstraction!");
        Shape s1 = new Circle("Red", 2.2);
        Shape s2 = new Rectangle("Yellow", 2, 4);

        System.out.println(s1.toString());
        System.out.println(s2.toString());
    }

    private static void TestEncapsulation() {
        System.out.println("This is  the test of Encapsulation!");
        // Method 1: instantiation using Constructor without parameters
        Person person1 = new Person();
        person1.setName("John");
        person1.setAge(30);
        System.out.println("-->Name: " + person1.getName() + ", Age: " + person1.getAge());

        // Method 2: setting the parameters
        Person person2 = new Person();
        person2.setNameGood("Will").setAgeGood(23);
        System.out.println("-->Name: " + person2.getName() + ", Age: " + person2.getAge());

        // Method 3: instantiation using Constructor with parameters
        Person person3 = new Person("Pumkin", 12);
        System.out.println("-->Name: " + person3.getName() + ", Age: " + person3.getAge());

        // Method 4: demonstrating how method toString() works
        Person person = new Person("Anastasia", 45);
        System.out.println("-->" + person);
    }

    private static void TestInheritance() {
        // Test the original class
        Bicycle bicycle = new Bicycle(5, 80);
        System.out.println(bicycle.toString());

        // Test the extended class
        MountainBike mb = new MountainBike(3, 100, 25);
        System.out.println(mb.toString());
    }
}
