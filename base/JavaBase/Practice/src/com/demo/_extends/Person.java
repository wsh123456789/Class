package com.demo._extends;

/*类A ： 父类 superClass 超类 基类
* 类B ： 子类 subClass 派生类
* class A {}
* class B extends A {}
* 子类继承父类所有属性和方法（private修饰的属性也能继承但是子类不可调用)*/
public class Person {
    String name;
    private int age;

    public void eat() {
        System.out.println("人吃饭");
    }
    public void sleep() {
        System.out.println("人睡觉");
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
}
