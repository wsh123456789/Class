package com.demo._singleton;

public class OperationFactoryDemo {
    public static void main(String[] args) {
        OperationFactory.getAnimal("猫").eat();
        OperationFactory.getAnimal("狗").eat();
    }
}

