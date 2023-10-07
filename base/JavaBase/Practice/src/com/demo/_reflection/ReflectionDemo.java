package com.demo._reflection;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {

        // 反射调用公共属性，空参构造方法，方法

        // 调用ref对象的class
        Class<Ref> ref = Ref.class;
        // 调用空参构造
        Ref r1 = ref.newInstance();
        System.out.println(r1);


        // 获取/修改 成员变量
        Field age = ref.getField("age");
        age.set(r1, 10);
        System.out.println(age.get(r1));

        // 调用成员方法
        Method toString = ref.getMethod("toString");
        System.out.println(toString.invoke(r1));

        // 反射调用所有声明过属性，构造方法，方法
        Class<Ref> ref1 = Ref.class;
        // 调用私有的有参构造
        Constructor<Ref> cons = ref1.getDeclaredConstructor(String.class, int.class);
        cons.setAccessible(true);
        Ref tom = cons.newInstance("Tom", 12);
        System.out.println(tom);

        // 调用私有属性
        Field name = ref1.getDeclaredField("name");
        name.setAccessible(true);
        name.set(tom,"tom01");
        System.out.println(name.get(tom));
        // 调用私有方法

        Method show = ref1.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        String s = (String) show.invoke(tom,"中国");
        System.out.println(s);

    }
}

class Ref {
    private String name;
    public int age;

    public Ref() {
        System.out.println("空参构造");
    }

    private Ref(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String show(String s){
        return this.name + "是" + s + "人";
    }

    @Override
    public String toString() {
        return "Ref{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
