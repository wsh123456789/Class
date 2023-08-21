package com.demo.polymorphism;

public class Man extends Person{

    boolean isSmoking;

    private int demo2 = 200;

    public Man() {
    }

    public Man(String name, int age, boolean isSmoking) {
        super(name, age);
        this.isSmoking = isSmoking;
    }

    @Override
    public void eat() {
        System.out.println("男人吃饭");
    }
    @Override
    public void sleep() {
        System.out.println("男人睡觉");
    }

    public void earnMoney() {
        System.out.println("男人挣钱养家...");
    }
}
