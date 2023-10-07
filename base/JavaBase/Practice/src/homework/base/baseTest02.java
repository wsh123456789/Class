package homework.base;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;

public class baseTest02 {
    public static void main(String[] args) {
//     【程序11】
//        题目：有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
//        numConcat();
//     【程序12】
//        题目：企业发放的奖金根据利润提成。
//        利润(I)低于或等于10万元时，奖金可提10%；
//        利润高于10万元，低于20万元时，低于10万元的部分按10%提成，高于10万元的部分，可可提成7.5%；
//        20万到40万之间时，高于20万元的部分，可提成5%；
//        40万到60万之间时高于40万元的部分，可提成3%；
//        60万到100万之间时，高于60万元的部分，可提成1.5%，
//        高于100万元时，超过100万元的部分按1%提成，
//        从键盘输入当月利润I，求应发放奖金总数？
//        bonus();
//     【程序13】
//        题目：一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？
//        int num = 1;
//        while (true){
//            if (isPerfectSquare(num + 100) && isPerfectSquare(num + 268)){
//                System.out.println(num);
//            }
//            num++;
//            if (num == 10000){
//                break;
//            }
//        }
//     【程序14】
//        题目：输入某年某月某日，判断这一天是这一年的第几天？
//        dateDemo();
//     【程序15】
//        题目：输入三个整数x,y,z，请把这三个数由小到大输出。
//        print();
//     【程序16】
//        题目：输出9*9口诀。
//        multiplication();
//     【程序17】
//        题目：猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个 第二天早上又将剩下的桃子吃掉一半，又多吃了一个。
//        以后每天早上都吃了前一天剩下的一半零一个。到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。
//        int count = peach(10, 1);
//        System.out.println(count);
//     【程序18】
//        题目：两个乒乓球队进行比赛，各出三人。甲队为a,b,c三人，乙队为x,y,z三人。已抽签决定比赛名单。
//        有人向队员打听比赛的名单。a说他不和x比，c说他不和x,z比，请编程序找出三队赛手的名单。
//        competition();
//     【程序19】
//        题目：打印出如下图案（菱形）
//         *
//        ***
//      ******
//     ********
//      ******
//       ***
//        *
//        printDemo(7);
//     【程序20】
//        题目：有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和。
//        addNum(20);
    }


    // 随机组成三位数
    private static void numConcat() {
        int count = 0;
        int n = 0;
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                if (j == i)
                    continue;
                for (int k = 1; k < 5; k++) {
                    if (k != i && k != j) {
                        n = i * 100 + j * 10 + k;
                        System.out.print(n + " ");
                        if ((++count) % 5 == 0)
                            System.out.println();
                    }
                }
            }
        }
        System.out.println();
        System.out.println("符合条件的数共：" + count + "个");
    }

    // 计算总奖金
    private static void bonus() {
        System.out.println("请输入基本奖金");
        Scanner sc = new Scanner(System.in);
        double salary = sc.nextDouble();
        double base = salary;
        double profit = 0;
        while (salary != 0) {
            if (salary > 100) {
                profit += (salary - 100) * 0.01;
                salary = 100;
                System.out.println(salary);
            } else if (salary > 60) {
                profit += (salary - 60) * 0.015;
                salary = 60;
                System.out.println(salary);
            } else if (salary > 40) {
                profit += (salary - 40) * 0.03;
                salary = 40;
                System.out.println(salary);
            } else if (salary > 20) {
                profit += (salary - 20) * 0.05;
                salary = 20;
                System.out.println(salary);
            } else if (salary > 10) {
                profit += (salary - 10) * 0.075;
                salary = 10;
            } else if (salary <= 10) {
                profit += salary * 0.1 + base;
                salary = 0;
            }
        }

        System.out.println("奖金一共为:" + profit + "元");


    }

    // 完全平方数
    private static boolean isPerfectSquare(int num) {
        if (Math.sqrt(num) == (int) (Math.sqrt(num))) {
            return true;
        } else {
            return false;
        }
    }


    // 判断这是这个月的第几天
    private static void dateDemo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入日期判断是今年的第几天，例如2023-02-01");
        String s = sc.nextLine();
        String[] date = s.split("-");
        int totalDay = 0;
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        switch (month) {
            case 1:
                totalDay = 0;
                break;
            case 2:
                totalDay = 31;
                break;
            case 3:
                totalDay = 59;
                break;
            case 4:
                totalDay = 120;
                break;
            case 5:
                totalDay = 151;
                break;
            case 6:
                totalDay = 181;
                break;
            case 7:
                totalDay = 212;
                break;
            case 8:
                totalDay = 243;
                break;
            case 9:
                totalDay = 273;
                break;
            case 10:
                totalDay = 304;
                break;
            case 11:
                totalDay = 31;
                break;
            case 12:
                totalDay = 334;
                break;
            default:
                System.out.println("date error");
                break;
        }
        totalDay += day;

        // 判断是否是闰年
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            if (month >= 3) {
                totalDay++;
            }
        }

        System.out.println(s + "是第" + totalDay + "天");
    }

    // 输入三个整数从小到大输出
    private static void print() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入三个数字，按顺序输出");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(a, "a");
        treeMap.put(b, "b");
        treeMap.put(c, "c");
        System.out.println(treeMap);

    }

    // 乘法口诀
    private static void multiplication() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }

    // 猴子吃桃子
    private static int peach(int day, int count) {
//        题目：猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个 第二天早上又将剩下的桃子吃掉一半，又多吃了一个。
//        以后每天早上都吃了前一天剩下的一半零一个。到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。
        if (day == 1) {
            return count;
        }
        return peach(day - 1, (count + 1) * 2);

    }

    // 比赛
    private static void competition() {
        char a, b, c;
        for (a = 'x'; a <= 'z'; a++) {
            for (b = 'x'; b <= 'z'; b++) {
                if (a != b) {
                    for (c = 'x'; c <= 'z'; c++) {
                        if (a != c && b != c) {
                            if (a != 'x' && c != 'x' && c != 'z') {
                                System.out.println("a ---> " + a + "\nb ---> " + b + "\nc ---> " + c);
                            }
                        }
                    }
                }
            }
        }
    }


    // 打印菱形
    private static void printDemo(int num) {
        // 计算上下部分行数
        int up = num - num / 2;
        int down = num / 2;
        // 上半部分
        for (int i = 0; i < up; i++) {
            int j = 0;
            for (j = 0; j < up - 1 - i; j++) {
                System.out.print(" ");
            }
            for (j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // 下半部分
        for (int i = 0; i < down; i++) {
            int j = 0;
            for (j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            for (j = 0; j < 2 * (down - i - 1) + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 数列和 2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和。
    private static void addNum(int num) {
        double m = 1;
        double n = 2;
        double sum = 0;
        for (int i = 0; i < num; i++) {
            sum += n / m;
            System.out.println(n / m);
            double temp = n;
            n += m;
            m = temp;
        }
        System.out.println("和为" + sum);
    }


}
