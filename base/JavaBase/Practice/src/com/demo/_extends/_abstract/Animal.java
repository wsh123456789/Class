package com.demo._extends._abstract;

// 被它修饰的类  抽象类
//基本类
// 抽象类里可以没有抽象方法,但是有抽象方法的类，一定是抽象类

/*
		 *
		 == 和equals的区别
			 == 可以判断基本数据类型 判断的是值
			 	也可以判断引用数据类型 判断的是地址值

			 equals（） 只能判断引用数据类型 重写之前 只能判断地址值
			 			重写之后 比较的是属性

		 */


public abstract class Animal {

    int a;
    /*
	  final：
	  	修饰的变量，都是常量(如果修饰的是成员变量，并且不给赋值，则无法使用无参构造)
	  	修饰的方法，可以被继承，不能被重写
	  	修饰的类，不能被继承

	 */

    final int b = 10;

    // abstract 抽象的  被它修饰的方法 叫抽象方法，并且没有方法体
    //当子类继承了有抽象方法的抽象类时，要么重写该方法，要么把自己也变成抽象类
    public abstract void eat();


    public void sleep(){
        System.out.println("动物睡觉");
    }

}
