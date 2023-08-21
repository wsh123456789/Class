package com.demo._extends;

public class Student extends Person {
    String school;

    /*
    * 父类被重写的方法与子类重写的方法名和形参列表必须相同
    * 子类重写的方法的权限修饰服不得小于父类被重写的方法的权限修饰符
    * 子类不能重写父类中声明为 private 权限修饰符的方法
    * 返回值类型为 void 和 基本数据类型时，子类重写必须与父类一致
    * 返回值类型为 引用数据类型，子类返回值类型可以与父类相同，也可以是父类返回值类型的子类
    * */

    /*
    * super 调用构造器
    *   子类继承父类时，不会继承父类的构造器。只能通过super(形参列表)的方式调用父类指定构造器
    *   规定super必须声明在构造器首行
    *   this()调用本类中的重载构造器和super()只能选一个
    *   子类构造器没有特殊修饰默认使用super()调用父类空参构造器
    *   */
    @Override
    public void sleep() {
        System.out.println("学生睡觉");
    }
    public void study() {
        System.out.println(name + "在" + school + "上学");
    }

    public void show() {
        System.out.println("Age" + getAge());
    }

}
