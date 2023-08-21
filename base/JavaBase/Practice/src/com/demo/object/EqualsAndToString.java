package com.demo.object;

import java.util.Objects;

public class EqualsAndToString {
    public static void main(String[] args) {
        /*equals
         * 任何引用数据类型都可以使用
         * 比较的是两个对象的引用地址
         * */
        User u1 = new User("Tom", 10);
        User u2 = new User("Tom", 10);

        System.out.println(u1.equals(u2));
        System.out.println(u1);
    }
}

class User {
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return Objects.equals(name, user.name);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
