package com.demo.base;
/*
* 构造器(构造方法)的作用  constructor
* 作用1. 搭配new关键字，创建类的对象
* 作用2. 在创建对象时，可以给对象的相关属性赋值
*
*
* 构造器的使用
* 构造器声明格式： 权限修饰符  类名(形参列表){}。
* 创建类以后，在没有提供任何构造器的情况下，系统默认提供一个空参构造器，与类声明权限相同。
* 一旦类中显示声明了构造器，则系统不在提供默认的空参构造器。
* 一个类中可以声明多个构造器，彼此之间构成重载。
*
*
* JavaBean，是指符合以下标准的Java类
* ① 类是公共的
* ② 又有一个无参的公共构造器
* ③ 有属性，且有对应的get和set方法
*
* UML类图
*  + 表示 public类型， - 表示private类型，# 表示protect类型
*  方法的写法： 方法类型（+，-） 方法名（参数名: 参数类型）: 返回值类型
*  斜体表示抽象方法和类
*  方法有下划线表示为构造器
*
* 权限修饰
*   private : 只能在本类使用
*   protected: 本包内都可使用，不同包内但是是本类的子类的可用
*   default(默认): 只能在本类和同包的类中使用
*   public : 公共的，可以在任意类中调用
*
*   修饰符             同类中    同一个包中（子类和无关类）   不同包（子类）   不同包（无关类）
*   public             Y           Y                     Y                Y
*   protected          Y           Y                     Y                N
*   default(默认)       Y           Y                     N                N
*   private            Y           N                     N                N
*
* */
public class Constructor {
    String name;
    int age;


    public Constructor(){
        System.out.println("构造器内容......");
    }
    public void eat() {
        System.out.println("人吃饭");
    }

    public void sleep(int hour) {
        System.out.println("人每天睡"+ hour + "小时");
    }
}
