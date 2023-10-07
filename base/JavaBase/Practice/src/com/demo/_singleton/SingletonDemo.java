package com.demo._singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        // 饿汉式 : 立即加载，随着类的加载，当前唯一实例就创建了
        // 优点 : 写法简单，由于内存中较早加载，使用更方便、更快。是线程安全的。
        // 缺点 : 内存中占用时间较长。
        Singleton s1 = Singleton.getSingleton();

        // 懒汉式 : 延时加载，在需要使用的时候进行创建
        // 优点 : 在需要的时候创建，节省内存空间。
        // 缺点 : 线程不安全。（可用 synchronized 修饰方法解决此问题）
        Singleton1 s2 = Singleton1.getSingleton1();
    }
}


// 饿汉式
class Singleton {

    // 类构造器私有化
    private Singleton(){

    }

    // 在类内部创建当前类的实例 属性和方法用static修饰
    private static Singleton singleton = new Singleton();

    public static Singleton getSingleton(){
        return singleton;
    }
}

// s懒汉式
class Singleton1 {
    private Singleton1(){

    }

    // 声明当前类的实例
    private static Singleton1 s = null;

    // 通过get方法获取类的实例，如果未创建对象，则在方法内部进行创建
    public static synchronized Singleton1 getSingleton1(){
        if (s == null) {
            s = new Singleton1();
        }
        return s;
    }
}
