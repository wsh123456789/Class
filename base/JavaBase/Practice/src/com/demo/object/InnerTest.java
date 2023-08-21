package com.demo.object;

public class InnerTest {
    public static void main(String[] args) {
        Animal.Dog dog = new Animal.Dog();
        dog.eat();
    }
}

class Animal {

    static class Dog{
        public void eat() {
            System.out.println("狗汪汪叫");
        }
    }
}

