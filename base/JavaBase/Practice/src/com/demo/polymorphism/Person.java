package com.demo.polymorphism;

public class Person {
    String name;
    int age;
    private int demo1 = 100;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println("人吃饭");
    }

    public void sleep() {
        System.out.println("人睡觉");
    }

    public void make() {
        System.out.println("人做饭");
    }

}
