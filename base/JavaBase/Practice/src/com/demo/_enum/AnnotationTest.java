package com.demo._enum;

public class AnnotationTest {
}

class Person {
    String name;
    int age;

    public void eat() {
        System.out.println("人吃饭");
    }
}

class Student extends Person {

    // 重写注解
    @Override
    public void eat() {
        System.out.println("学生吃饭");
    }

//    @Deprecated 用于表示所修饰的类、方法等已过时。通常是因为所修饰的结构危险或存在更好的选择。
//    @SuppressWarnings() 抑制服务器警告
}
