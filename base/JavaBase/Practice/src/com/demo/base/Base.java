package com.demo.base;

import static java.util.Arrays.sort;

public class Base {
    public static void main(String[] args) {
//        数组的声明与初始化
        double[] d1 = new double[]{1, 2, 3, 4, 5};
        double[] d2 = new double[4];
        String[] str1 = new String[]{"liming", "Jenny"};
        String[] str2 = new String[4];

        for (int i = 0; i <= d1.length - 1; i++) {
            System.out.println(d1[i]);
        }

        // 二维数组
        String[][] str3 = new String[][]{{"零零", "零一", "零二"}, {"一零", "一一", "一二"}, {"二零", "二一", "二二"}};
        System.out.println(str3[0]); // [Ljava.lang.String;@7ba4f24f
        System.out.println(str3[0][0]);
        System.out.println(str3.length);



    }
}
