package com.demo._annotation;

import org.junit.Test;

public class AnnotationDemo {
    public static void main(String[] args) {
        // @override 重写父类方法
        // @Deprecated 已过时
        // @SuppressWarnings 抑制编译器警告


    }

    // 单元测试注解，让注解后的方法单独执行
    // 所在类必须是public的，非抽象，包含唯一的无参构造器。
    // @Test标记的方法本身必须是public，非抽象非静态的，void无返回值，（）无参的
    @Test
    public void eat(){
        System.out.println("hello");
    }

}
