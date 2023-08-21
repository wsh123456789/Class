package com.demo.polymorphism;

public class Woman extends Person {
    boolean isBeauty;

    public Woman() {

    }

    public Woman(String name, int age, boolean isBeauty) {
        super(name, age);
        this.isBeauty = isBeauty;
    }

    @Override
    public void eat() {
        System.out.println("女人睡觉");
    }

    @Override
    public void sleep() {
        System.out.println("女人睡觉");
    }

    public void goShopping() {
        System.out.println("女人逛街......");
    }

}
