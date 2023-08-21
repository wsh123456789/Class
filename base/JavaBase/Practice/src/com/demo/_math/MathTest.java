package com.demo._math;

public class MathTest {
    public static void main(String[] args) {
      /*
        Scanner常见的bug及解决方案

        bug：先录入整数再录入字符串，出现获取不到数据的情况

        解决方案：1. 创建两个Scanner；2. 都是用nextLine

        Math类
        概述：
        Math 类包含用于执行基本数学运算的方法，如初等指数、对数、平方根和三角函数。
   */
//        方法：

//        public static int abs ( int a)//绝对值
        int sum = -1;
        System.out.println(Math.abs(sum));
//        public static double ceil ( double a)//ceil天花板 向上取整
        double d1 = 1.1;
        System.out.println(Math.ceil(d1));
//        public static double floor ( double a)//floor地板，向下取整
        System.out.println(Math.floor(1.9));
//        public static int max ( int a, int b)//两数中的最大值 min自学
        System.out.println(Math.max(1, 2));
        System.out.println(Math.min(1, 2));
//        public static double pow ( double a, double b)//a的b次幂
        System.out.println(Math.pow(2, 3));
//        public static double random ()//生成0.0-1.0之间的随机数 [0.0-1.0)
        System.out.println((int)(Math.random() * 100));
//        public static int round ( float a) //四舍五入参数为double的自学
        System.out.println(Math.round(10.4f));
        System.out.println(Math.round(10.5f));
        System.out.println(Math.round(10.4));
        System.out.println(Math.round(10.5));
//        public static double sqrt ( double a)//开平方
        System.out.println(Math.sqrt(100.0));


    }
}
