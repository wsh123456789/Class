package com.demo._extends._abstract;

//接口 interface
//接口 不能实例化
//在jdk1.7 接口里面的方法都是抽象方法 里面的变量都是常量
public interface PS {
    //
    int a = 10; //常量    默认public static final修饰
    void pa(); // 默认用public abstract 修饰

    //默认方法
    default void aa(){
        System.out.println("aaa");
    }

    //静态方法
    public static void bb(){
        System.out.println("bbbbb");
    }

}
