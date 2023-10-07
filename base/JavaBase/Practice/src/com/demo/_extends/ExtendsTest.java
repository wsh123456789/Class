package com.demo._extends;

public class ExtendsTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        Student stu1 = new Student();
        p1.name = "Danny";
        p1.setAge(10);
        stu1.name = "LiMing";
        stu1.setAge(20);
        System.out.println(p1.name);
        System.out.println(stu1.name);
        stu1.school = "五道口职业技术学院";
        stu1.study();
        System.out.println("Person" + p1.getAge());
        System.out.println("Student" + stu1.getAge());
        stu1.sleep();

        Person a = new Student();
        a.eat();
        a.sleep();
    }
}
