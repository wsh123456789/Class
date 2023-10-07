package homework.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class baseTest01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//      【程序1】
//         题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问某个月的兔子对数为多少？
//        System.out.println("请输入月份查看兔子对数");
//        int month = sc.nextInt();
//        System.out.println("第" + month + "个月的兔子对数为" + getRabbitNumber(month));
//      【程序2】
//         题目：判断101-200之间有多少个素数，并输出所有素数。
//        System.out.println("输入一个数判断是否为素数");
//        int prime = sc.nextInt();
//        if (isPrime(prime)) {
//            System.out.println(prime + "是素数");
//        } else {
//            System.out.println(prime + "不是素数");
//        }

//     【程序3】
//        题目：打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。例如：153是一个"水仙花数"，
//        因为153=1的三次方＋5的三次方＋3的三次方。
//        System.out.println("请输入一个三位数判断是不是水仙花数");
//        int narcissistic = sc.nextInt();
//        if (isNarcissisticNumber(narcissistic)) {
//            System.out.println(narcissistic + "是水仙花数");
//        } else {
//            System.out.println(narcissistic + "不是水仙花数");
//        }
//     【程序4】
//        题目：将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
//        System.out.println("请输入一个正整数，将其分解质因数");
//        int p = sc.nextInt();
//        primeSplit(p);
//     【程序5】
//        题目：利用条件运算符的嵌套来完成此题：学习成绩>=90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
//        score(80);
//     【程序6】
//        题目：输入两个正整数m和n，求其最大公约数和最小公倍数。
//        int m = 10;
//        int n = 20;
        // 最大公约数
//        System.out.println(gcd(m,n));
        // 最小公倍数
//        System.out.println(lcm(m,n));
//     【程序7】
//        题目：输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
//        System.out.println("输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数");
//        String str = sc.next();
//        countNum(str);
//     【程序8】
//        题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。
//        addNum();
//     【程序9】
//        题目：一个数如果恰好等于它的因子之和，这个数就称为"完数"。例如6=1＋2＋3.编程找出1000以内的所有完数。
//        perfectNumber();
//     【程序10】
//        题目：一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在 第10次落地时，共经过多少米？第10次反弹多高？
//        ballSkip();
    }

    // 不死神兔
    public static int getRabbitNumber(int month) {
        if (month == 1 || month == 2) {
            return 1;
        } else {
            return getRabbitNumber(month - 1) + getRabbitNumber(month - 2);
        }
    }

    // 判断素数
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 水仙花数
    public static boolean isNarcissisticNumber(int num) {
        int a = num % 10;
        int b = num % 100 / 10;
        int c = num / 100;

        if (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3) == num) {
            return true;
        } else {
            return false;
        }
    }

    // 分解质因数
    public static void primeSplit(int num) {
        int k = 2;
        if (num <= 1) {
            System.out.println("1不可被分解");
        } else if (num == 2) {
            System.out.println("分解质因数结果为: 2");
        } else {
            System.out.print(num + "分解后的质因数为: 1");
            while (k <= num) {
                if (num % k == 0) {
                    System.out.print("*" + k);
                    num = num / k;
                } else {
                    k++;
                }
            }
        }
    }

    // 成绩分级
    public static void score(int num) {
        if (num >= 90 && num <= 100) {
            System.out.println("A");
        } else if (num >= 60 && num < 90) {
            System.out.println("B");
        } else if (num >= 0 && num < 60) {
            System.out.println("C");
        } else {
            System.out.println("成绩不合法");
        }
    }

    // 最大公约数
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        int r = a % b;
        return gcd(b, r);

    }

    // 最小公倍数
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    // 计算各个字符个数
    public static void countNum(String str) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        String[] s = str.split("");
        for (String s1 : s) {
            if (treeMap.containsKey(s1)) {
                int value = treeMap.get(s1) + 1;
                treeMap.put(s1, value);
            } else {
                treeMap.put(s1, 1);
            }
        }
        System.out.println(treeMap);
    }

    // 求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。
    public static void addNum() {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int y;
        System.out.println("请输入要相加的数");
        int a = sc.nextInt();
        System.out.println("请输入要求几个数相加");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            y = 0;
            for (int j = 0; j < i; j++) {
                y = y * 10 + a;
            }
            if (i != n-1){
                System.out.print(y + " + ");
            }else {
                System.out.print(y);
            }
            sum += y;
        }
        System.out.println( " = " + sum);
    }

    // 完数
    public static void perfectNumber() {
        for (int j = 1; j <= 1000; j++) {
            int sum = 0;
            for (int i = 1; i <= j/2 ; i++) {
                if (j % i == 0) {
                    sum += i;
                }
            }
            if (sum == j){
                System.out.println(j);
            }
        }

    }

    // 球弹跳
    private static void ballSkip() {
        double height = 100;
        double total = 100;
        for (int i = 0; i < 10; i++) {
            System.out.println(height);
            total += height;
            height = height / 2;

        }
        System.out.println("第十次落地时共经过：" + total  + "米");
        System.out.println("第十次反弹：" + height/2 + "米");
    }
}
