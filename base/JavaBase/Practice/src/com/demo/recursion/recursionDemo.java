package com.demo.recursion;

import java.util.Scanner;

public class recursionDemo {
    public static void main(String[] args) {
        // 递归求和
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字，计算此数字以内的正数和");
        int n = sc.nextInt();
        int sum = getNum(n);
        System.out.println(n + "以内的正数和为" + sum);

        // 求 n!
        System.out.println("请输入数字求其阶乘");
        n = sc.nextInt();
        sum = getMul(n);
        System.out.println(n + "的阶乘为" + sum);

        // 汉诺塔
        hanoiTower(3, 'A', 'B', 'C');

        // 已知一个数列 f(0) = 1, f(1) = 4, f(n+2) = 2 * f(n + 1) + f(n)
        System.out.println("请输入一个数字求f(n)");
        int fn = sc.nextInt();
        System.out.println("f(" + fn + ") = " + f(fn));

        // 不死神兔
        // 有一对兔子，从出生第三个月起每个月都生一对兔子，小兔子长到第三个月后，每个月又生一只兔子，假如兔子都不死，问第二十个月的兔子对数为多少。
        System.out.println("请输入月份查看兔子数量");
        int r = sc.nextInt();
        System.out.println("第" + r + "个月的兔子对数为" + getRabbitNumber(r));

        // 假设有n个台阶，每跨一步只能上1阶或者2阶台阶。求总共有多少种走法
        System.out.println("请输入有几个台阶");
        sum = sc.nextInt();
        System.out.println("共有" + climbStairs(sum) + "种走法");

    }

    // 递归求和
    public static int getNum(int num) {
        if (num == 1) {
            return 1;
        } else {
            return getNum(num - 1) + num;
        }
    }

    // 计算 n!
    public static int getMul(int num) {
        if (num == 1) {
            return 1;
        } else {
            return num * getMul(num - 1);
        }
    }

    // 汉诺塔
    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第" + num + "个盘" + "从" + a + "移动到" + c);
        }
        if (num > 1) {
            // 中间为借助柱子
            hanoiTower(num - 1, a, c, b);
            System.out.println("第" + num + "个盘" + "从" + a + "移动到" + c);
            hanoiTower(num - 1, b, a, c);
        }
    }

    // 已知一个数列 f(0) = 1, f(1) = 4, f(n+2) = 2 * f(n + 1) + f(n)
    public static int f(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 4;
        } else {
            return 2 * f(n - 1) + f(n - 2);
        }
    }

    // 不死神兔
    // 有一对兔子，从出生第三个月起每个月都生一对兔子，小兔子长到第三个月后，每个月又生一只兔子，假如兔子都不死，问第二十个月的兔子对数为多少。
    public static int getRabbitNumber(int month) {
        if (month == 1 || month == 2) {
            return 1;
        } else {
            return getRabbitNumber(month - 1) + getRabbitNumber(month - 2);
        }
    }

    // 假设有n个台阶，每跨一步只能上1阶或者2阶台阶。求总共有多少种走法
    public static int climbStairs(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }
}
