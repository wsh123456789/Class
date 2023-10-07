package homework.base;

import java.util.ArrayList;
import java.util.Arrays;

public class baseTest03 {
    public static void main(String[] args) {
//     【程序21】
//        题目：求1+2!+3!+...+20!的和
//        long sum = 0;
//        for (int i = 1; i <= 20; i++) {
//            sum += factorial(i);
//        }
//        System.out.println(sum);

//     【程序22】
//        题目：利用递归方法求5!。
//        System.out.println("阶乘为" + fun22(5));
//     【程序23】
//        题目：有5个人坐在一起，问第五个人多少岁？他说比第4个人大2岁。问第4个人岁数，他说比第3个人大2岁。
//        问第三个人，又说比第2人大两岁。问第2个人，说比第一个人大两岁。最后问第一个人，他说是10岁。
//        请问第五个人多大？
//        System.out.println(fun23(5));
//     【程序24】
//        题目：给一个不多于5位的正整数，要求：一、求它是几位数，二、逆序打印出各位数字。
//        fun24(1234);
//     【程序25】
//        题目：一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同。
//        fun25(12331);
//     【程序26】
//        题目：请输入星期几的第一个字母来判断一下是星期几，如果第一个字母一样，则继续 判断第二个字母。
//        星期一 Monday
//        星期二 Tuesday
//        星期三 Wednesday
//        星期四 Thursday
//        星期五 Friday
//        星期六 Saturday
//        星期日 Sunday
//        fun26("Thu");
//     【程序27】
//        题目：求100之内的素数
//        fun27(100);
//     【程序28】
//        题目：对10个数进行排序
//        fun28();
//     【程序29】
//        题目：求一个3*3矩阵对角线元素之和
//        fun29();
//     【程序30】
//        题目：有一个已经排好序的数组。现输入一个数，要求按原来的规律将它插入数组中。
//        fun30(5);
    }


    // 阶乘和
    private static long factorial(int num) {
        long sum = 1;
        for (int i = 1; i <= num; i++) {
            sum *= i;
        }
        return sum;
    }

    // 递归求阶乘
    private static int fun22(int i) {
        if (i == 1) {
            return 1;
        }
        return i * fun22(i - 1);
    }

    // 求第五个人多少岁
    private static int fun23(int i) {
        if (i == 1) {
            return 10;
        }
        return 2 + fun23(i - 1);

    }

    // 倒叙打印数字 并输出是几位数
    private static void fun24(int i) {
        StringBuffer str = new StringBuffer(String.valueOf(i));
        System.out.println("数字为" + str.length() + "位数, 反转后为" + str.reverse());
    }

    // 判断是否为回文数
    private static void fun25(int i) {
        String str1 = String.valueOf(i);
        StringBuffer str = new StringBuffer(str1);
        String str2 = String.valueOf(str.reverse());
        if (str1.equals(str2)) {
            System.out.println(str + "是回文数");
        } else {
            System.out.println(str + "不是回文数");
        }
    }

    // 根据单词前两位或前三位判断是星期几
    private static void fun26(String s) {
        // 星期一 Monday
        // 星期二 Tuesday
        // 星期三 Wednesday
        // 星期四 Thursday
        // 星期五 Friday
        // 星期六 Saturday
        // 星期日 Sunday
        int day = 0;
        if (s.trim().equalsIgnoreCase("Mo") || s.trim().equalsIgnoreCase("Mon") || s.trim().equalsIgnoreCase("Mond")) {
            day = 1;
        } else if (s.trim().equalsIgnoreCase("Tu") || s.trim().equalsIgnoreCase("Tue")) {
            day = 2;
        } else if (s.trim().equalsIgnoreCase("We") || s.trim().equalsIgnoreCase("Wed")) {
            day = 3;
        } else if (s.trim().equalsIgnoreCase("Th") || s.trim().equalsIgnoreCase("Thu")) {
            day = 4;
        } else if (s.trim().equalsIgnoreCase("Fr") || s.trim().equalsIgnoreCase("Fri")) {
            day = 5;
        } else if (s.trim().equalsIgnoreCase("Sa") || s.trim().equalsIgnoreCase("Sat")) {
            day = 6;
        } else if (s.trim().equalsIgnoreCase("Su") || s.trim().equalsIgnoreCase("Sun")) {
            day = 7;
        }

        switch (day) {
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            case 6:
                System.out.println("星期六");
                break;
            case 7:
                System.out.println("星期日");
                break;
            default:
                System.out.println("输入有误");
                break;
        }
    }

    // 输出一百以内的素数
    private static void fun27(int num) {
        for (int i = 2; i <= num; i++) {
            int flag = 0;
            for (int j = 2; j < Math.sqrt(i) + 1; j++) {
                if (i % j == 0) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.print(i + "\t");
            }
        }
    }

    // 对十个数进行排续
    private static void fun28() {
        System.out.println("排序前:");
        int[] ints = {10, 8, 6, 7, 9, 5, 3, 4, 1, 2};
        System.out.println(Arrays.toString(ints));
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));

    }

    // 3 * 3矩阵对角线之和
    private static void fun29() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == i) {
                    sum1 += arr[i][j];
                }
                if (i + j == 2) {
                    sum2 += arr[i][j];
                }
            }
        }
        System.out.println("对角和为" + sum1 + "," + sum2);
    }

    // 有一个已经排好序的数组。现输入一个数，要求按原来的规律将它插入数组中。
    private static void fun30(int num) {
        int[] arr1 = {1, 2, 3, 6, 7, 8,};
        int len = arr1.length;
        int[] arr2 = new int[len + 1];
        int flag = 0;
        for (int i = len - 1, j = len; j >= 0; i--, j--) {
            if (num > arr1[i] && flag == 0) {
                arr2[j] = num;
                flag = 1;
                i++;
            } else {
                arr2[j] = arr1[i];
            }
        }
        System.out.println("插入前" + Arrays.toString(arr1));
        System.out.println("插入后" + Arrays.toString(arr2));
    }

}
