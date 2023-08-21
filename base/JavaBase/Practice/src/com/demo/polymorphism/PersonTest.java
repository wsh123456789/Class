package com.demo.polymorphism;


public class PersonTest {

    public static void main(String[] args) {
        Person p1 = new Person();
        Man m1 = new Man();
        Woman w1 = new Woman();

         /*
         多态  父类引用指向子类对象
         多态性的应用 ： 虚拟方法调用
         好处： 减少代码冗余，不需要定义多个重载方法
         弊端： 在多态的场景下，我们创建了子类对象，也加载了子类的特有的属性和方法。但是由于声明为父类的引用，
         导致我们没有办法直接调用子类特有的属性和方法。
         编译看左，执行看右
         多态使用前提： ①要有类的继承关系 ②要有方法的重写
         多态的适用性： 适用于方法，不适用于属性
         */
        Person p2 = new Man();
        Person p3 = new Woman();
//        在Person 设置private demo1属性时，不能调用demo属性
//        p2.demo1;
//        在Man设置private demo2属性时，依旧不能调用
//        p2.demo2;
//        只能调用Person的非私有属性与方法

        // 在向下转型时，建议用instanceof进行判断避免出现类型转换异常
        if (p2 instanceof Man) {
            Man m2 = (Man) p2;
            m2.earnMoney();
        }

    }
}

