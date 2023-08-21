package com.demo._collection;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
        // Collection只能存储引用数据类型
        // 基本数据类型能直接存储的原因是进行了自动装箱转为了对应的对象类
        Collection c = new ArrayList<>();
        c.add(10);
        System.out.println(c);
//        基本功能演示
//        Collection c = new ArrayList();         父类引用指向子类对象
        Collection<Person> c1 = new ArrayList<>();
//        boolean add(E e)
        Person p1 = new Person("坤坤", 18);
        Person p2 = new Person("凡凡", 19);
        Person p3 = new Person("战战", 20);
        Person p4 = new Person("晗晗", 21);
        c1.add(p1);
        c1.add(p2);
        c1.add(p3);
        c1.add(p4);
        System.out.println(c1);
//        boolean remove(Object o)
        System.out.println(c1.remove(p2));
        System.out.println(c1);
//        boolean contains(Object o)//多态的应用场景
        boolean isContains = c1.contains(p1);
        System.out.println(isContains);
//        boolean isEmpty()//null
        System.out.println(c1.isEmpty());
//        int size()
        System.out.println(c1.size());
//        void clear()
        c1.clear();
        System.out.println(c1);
    }
}

class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
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
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}' + '\n';
    }
}


class BeanPerson extends Person{
    private String name;
    private int age;

    public BeanPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public BeanPerson(String name, int age, String name1, int age1) {
        super(name, age);
        this.name = name1;
        this.age = age1;
    }

    @Override
    public String toString() {
        return "BeanPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}' + '\n';
    }
}
