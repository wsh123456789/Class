package com.demo._extends._abstract;

//类与类之间是继承关系 单继承  可以多层继承
//implements 实现关键字  后面跟的一定是接口类
public class Cat extends Animal implements PS {

    @Override
    public void eat() {
        System.out.println("小猫吃鱼");
    }

    @Override
    public void pa() {
        System.out.println("小猫爬树");

    }

}
