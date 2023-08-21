package com.demo.base;

/*
 * java类及类成员： （重点）属性，方法，构造器，（熟悉）代码块， 内部类
 * 面向对象的特征： 封装，继承， 多态， （抽象）
 * 其他关键字的使用： this、super、package、import、static、final、interface、abstract等*/

/*
* 按照变量在类中声明的位置不同: 成员变量 和 局部变量
* 权限修饰符: public protected  缺省  private
* 可变参数 参数类型 ...参数名 （int[] aaa）和（int ... aaa）不构成重载 必须写在形参最后 */

/*
* java.lang    包含一些Java语言的核心类、如String、Math、Integer、System和Thread,提供常用功能
* java.net     包含执行与网络相关的操作的类和接口
* java.in      包含能提供多种输入/输出功能的类
* java.util    包含一些使用工具类，如定义系统特性、接口的集合框架类、使用与日期相关的函数。
* java.text    包含了一些Java格式化相关的类
* java.sql     包含了java进行JDBC数据库编程的相关类/接口
* java.awt     包含了构成抽象窗口工具集（abstract window toolkits）的多个类，这些类被用来构建和管理应用*/

/*
this 只能调成员变量、方法、构造器
this 理解为当前对象

* */
public class Phone {
    String name;
    double price;

//    封装 用get set方法去调用
    private int date;

    public void setDate(int date) {
        if (date >= 2000 && date <= 2100) {
            this.date = date;
        } else {
            System.out.println("您输入的日期有误");
        }
    }

    public int getDate() {
        return  date;
    }

    public void call() {
        System.out.println("手机能打电话");
    }

    public void sendMessage(String message) {
        System.out.println("发信息:" + message);
    }

    public void playGame(){
        System.out.println("可以玩游戏");
    }
}
