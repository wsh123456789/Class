package com.demo._singleton;

// 简单工厂模式来创建对象，提高代码复用性
public class OperationFactory {
    public static Animal getAnimal(String name){
        switch (name) {
            case "猫" :
                return new Cat();
            case "狗" :
                return new Dog();
            default:
                return null;
        }
    }
}
class Animal {
    public void eat(){};
}

class Cat extends Animal{
    @Override
    public void eat(){
        System.out.println("猫吃鱼");
    }
}

class Dog extends Animal{
    @Override
    public void eat(){
        System.out.println("狗吃肉");
    }
}
