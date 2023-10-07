package homework;

import java.util.Arrays;
import java.util.Scanner;

public class Practice01{
    public static void main(String[] args) {
//        1、声明一个int 类型的变量，跟byte 类型的变量做加法运算，要求结果为一个byte类型
//        int a = 10;
//        byte b = 1;
//        byte c = (byte) (a + b);
//        System.out.println(c);
//        2、int类型，double类型做相加，结果为int类型
//        int a = 10;
//        double b = 20;
//        int c = (int)(a + b);
//        System.out.println(c);
//        3、int类型的变量，跟float类型变量做乘法运算，要求结果为double
//        int a = 10;
//        float b = 20f;
//        double c = a + b;
//        System.out.println(c);
//        4、double类型的变量，跟int类型的变量做加法 ,要求返回结果为long
//        int a = 10;
//        double b = 20;
//        long c = (long)(a + b);
//        System.out.println(c);


// -------------------------------------------------------------------------------------------------------


//        键盘录入：
//        1、键盘录入学生的信息：年龄、身高、姓名、性别，并输出
        Scanner sc = new Scanner(System.in);
//        String age = sc.next();
//        String height = sc.next();
//        String name = sc.next();
//        String gender = sc.next();
//        System.out.println("年龄为:" + age + "身高为:" + height + "姓名为:" + name + "性别为:" + gender);
//        2、键盘录入两个数据，求和并输出结果
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        System.out.println(a + b);

//        3、键盘录入两个数据，获取两个数据中的最大值
//        int c = sc.nextInt();
//        int d = sc.nextInt();
//        System.out.println(c > d ? "最大值为" + c : "最大值为" + d);
//        4、键盘录入两个数据，比较两个数据是否相等
//        int e = sc.nextInt();
//        int f = sc.nextInt();
//        System.out.println(e == f);
//        5、键盘录入三个数据，获取三个数据中的最大值和最小值
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int c = sc.nextInt();
//        System.out.println( "最大值为：" + (a > b ? a > c ? a : c : b > c ? b : c));
//        6、需求：键盘录入一个三位数，将其拆分为个位、十位、百位后，打印在控制台
//        String s = sc.next();
//        for (int i = 0; i < s.length(); i++) {
//            System.out.println(s.charAt(i));
//        }


// -------------------------------------------------------------------------------------------------------


//        1、小明的爸爸为了督促小明学习，决定根据考试成绩（满分100）给出对应的礼物，请用代码完成该需求。
//        90分以上买电脑
//        80分以上买手机
//        60分以上吃大餐
//        60分以下送温暖（五年高考三年模拟）
//        System.out.println("请输入成绩");
//        int score = sc.nextInt();
//        if (score >= 90 && score <= 100){
//            System.out.println("买电脑");
//        }
//        else if (score >= 80 && score < 90) {
//            System.out.println("买手机");
//        }
//        else if (score >= 60 && score < 80) {
//            System.out.println("吃大餐");
//        }
//        else if (score >= 0 && score < 60){
//            System.out.println("送温暖，五年高考三年模拟");
//        }
//        2、打车起步价8元（3km以内）
//        超过3km，超出部分每公里1.2元
//        超过5km，超出的部分每公里1.5元
//        输入公里数，得出总价
//        System.out.println("请输入路程");
//        double s = sc.nextInt();
//        double money = 0;
//        if (s > 5){
//            money = (s-5) * 1.5 + 2 * 1.2 + 8;
//        } else if (s <= 5 && s > 3) {
//            money = (s - 3) * 1.2 + 8;
//        }
//        else {
//            money = 8;
//        }
//        System.out.println("路程为："+ s +"打车价格为：" + money);

        // -------------------------------------------------------------------------------------------------------


//        1、跟据用户输入的 1-7 ，完成星期的查询
//        int day = sc.nextInt();
//        switch (day) {
//            case 1:
//                System.out.println("星期一");
//                break;
//            case 2:
//                System.out.println("星期二");
//                break;
//            case 3:
//                System.out.println("星期三");
//                break;
//            case 4:
//                System.out.println("星期四");
//                break;
//            case 5:
//                System.out.println("星期五");
//                break;
//            case 6:
//                System.out.println("星期六");
//                break;
//            case 7:
//                System.out.println("星期七");
//                break;
//            default:
//                System.out.println("输入数据不存在");
//        }


//        2、键盘录入1-12  查询对应的季节  12-2 冬季   3-5 春季  6-8 夏季 9-11 秋季
//        int season = sc.nextInt();
//        switch (season) {
//            case 12:
//            case 1:
//            case 2:
//                System.out.println("冬季");
//                break;
//            case 3:
//            case 4:
//            case 5:
//                System.out.println("春季");
//                break;
//            case 6:
//            case 7:
//            case 8:
//                System.out.println("夏季");
//                break;
//            case 9:
//            case 10:
//            case 11:
//                System.out.println("秋季");
//                break;
//            default:
//                System.out.println("输入错误");
//        }
// -------------------------------------------------------------------------------------------------------
//        1、模拟聊天室
//        提示:
//        "欢迎进入聊天室"
//        "请文明用语，输入‘你妹哦’,将被和谐"
//        "输入拜拜 退出"
//
//        while (true) {
//            System.out.println("欢迎进入聊天室\n请用文明用语,输入‘你妹哦’,将被和谐\n输入拜拜 退出");
//            String chat = sc.next();
//            if (chat.contains("你妹哦")) {
//                String newChat = chat.replace("你妹哦", "***");
//                System.out.println(newChat);
//            } else if (chat == "拜拜"){
//                System.out.println("成功退出聊天室");
//                break;
//            }
//            else {
//                System.out.println(chat);
//            }
//        }
//
//        2、99乘法表
//        for (int j = 1; j <= 9; j++) {
//            for (int i = 1; i <= j; i++) {
//                System.out.print(i + "*" + j + "=" + (i * j) + "\t");
//            }
//            System.out.println();
//        }

        // 100 以内的奇数、偶数个数以及奇数、偶数和
        int oCount = 0;
        int jCount = 0;
        int oSum= 0;
        int jSum = 0;

        for(int i = 2; i <= 100; i+=2){
            oCount++;
            oSum += i;

        }

        for(int i = 1; i<= 100; i+=2){
            jCount++;
            jSum += i;

        }
        System.out.println("偶数个数为"+ oCount + "偶数和为" + oSum);
        System.out.println("奇数个数为"+ jCount + "奇数和为" + jSum);

//        3、给20块钱买可乐，每瓶可乐3块钱，喝完之后退瓶子可以换回1块钱，问最多可以喝多少瓶可乐
        int money = 20;
        int count = 0;
        while (money >= 3) {
            money = money - 3 + 1;
            count++;
        }
        System.out.println("能买的可乐数为:" + count);
//        4、青蛙爬井 井深7米
//        青蛙在井底，白天爬三米，晚上掉两米，请问需要几天可以爬出来
        int deep = 0;
        int day = 0;
        while (deep <= 7) {
            day++;
            if (deep + 3 >= 7) {
                System.out.println("天数为" + day);
                break;
            } else {
                deep++;
            }
        }
//
//        5、把100-150之间不能被3整除的数输出
        System.out.println("不能被三整除的数为");
        for (int i = 100; i <= 150; i++) {
            if (i % 3 == 0) {
                continue;
            }
            System.out.print(i + "\t");
        }
        System.out.println();
//
//        6、假设一座山的高度为8000米，一张A4纸厚度是1毫米，请问将纸对折多少次可以超过山的高度

        int h1 = 8000000;
        int h2 = 1;
        int count1 = 0;
        while (h2 <= h1) {
            count1++;
            h2 = h2 << 1;
        }
        System.out.println("需要对折" + count1 + "次");
//        7、小芳的妈妈每天给她2.5元，她都会存起来，
//        但每当存钱的第五天，她都会花去6元，
//        请问，经过多少天，小芳可以存到100元
        double m = 0;
        int d = 0;
        while (m < 100) {
            d++;
            m += 2.5;
            if (d % 5 == 0) {
                m -= 6;
            }
        }
        System.out.println("经过" + d + "天，小芳可以存" + m + "元");

        //	1、定义一个方法，参数是用户输入的数字，输出对应的乘法表
        System.out.println("请输入数字输出对应乘法表");
        int a = sc.nextInt();
        fun1(a);
        //  2、定义一个 两个变量相乘的方法
        System.out.println("请输入需要相乘的两个变量");
        double n1 = sc.nextDouble();
        double n2 = sc.nextDouble();
        double num = fun2(n1, n2);
        System.out.println("相乘结果为" + num);
        //  3、定义一个求最大值的方法，要求两个变量是键盘录入的
        System.out.println("请输入要比较大小的两个数字");
        double n3 = sc.nextDouble();
        double n4 = sc.nextDouble();
        double max = maxNum(n3, n4);
        System.out.println("最大值为" + max);
        //  4、用定义方法的方式，模拟王者荣耀
        //      选职业：战士、法师、射手、刺客、辅助
        //      选英雄：（介绍英雄技能）
        String[][] hero = new String[][]{{"战士1介绍", "战士2介绍", "战士3介绍"}, {"法师1介绍", "法师2介绍", "法师3介绍"}, {"射手1介绍", "射手2介绍", "射手3介绍"}, {"刺客1介绍", "刺客2介绍", "刺客3介绍"}, {"辅助1介绍", "辅助2介绍", "辅助3介绍"}};
        selected(hero);
    }

    // 九九乘法表方法
    public static void fun1(int x) {
        for (int j = 1; j <= x; j++) {
            for (int i = 1; i <= j; i++) {
                System.out.print(i + "*" + j + "=" + (i * j) + "\t");
            }
            System.out.println();
        }
    }

    // 两个变量相乘的方法
    public static double fun2(double x, double y) {
        return x * y;
    }

    // 求最大值方法
    public static double maxNum(double x, double y) {
        return x > y ? x : y;
    }

    // 模拟游戏选择角色
    public static void selected(String[][] str) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请选择你的职业的序号：0.战士、 1.法师、 2.射手、 3.刺客、 4.辅助");
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println("请选择你的角色的序号：0. 战士1, 1. 战士2, 2. 战士3");
            int h = sc.nextInt();
            System.out.println(str[n][h]);
        } else if (n == 1) {
            System.out.println("请选择你的角色的序号：0. 法师1, 1. 法师2, 2. 法师3");
            int h = sc.nextInt();
            System.out.println(str[n][h]);
        } else if (n == 2) {
            System.out.println("请选择你的角色的序号：0. 射手1, 1. 射手2, 2. 射手3");
            int h = sc.nextInt();
            System.out.println(str[n][h]);
        } else if (n == 3) {
            System.out.println("请选择你的角色的序号：0. 刺客1, 1. 刺客2, 2. 刺客3");
            int h = sc.nextInt();
            System.out.println(str[n][h]);
        } else if (n == 4) {
            System.out.println("请选择你的角色的序号：0. 辅助1, 1. 辅助2, 2. 辅助3");
            int h = sc.nextInt();
            System.out.println(str[n][h]);
        }
    }

}
