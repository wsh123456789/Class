package homework.base;

import java.util.Arrays;

public class baseTest04 {
    public static void main(String[] args) {
//     【程序31】
//        题目：将一个数组逆序输出。
//        fun31();
//     【程序32】
//        题目：取一个整数a从右端开始的4～7位。
//        fun32();
//     【程序33】
//        题目：打印出杨辉三角形（要求打印出10行如下图）
//        fun33(10);
//     【程序34】
//        题目：输入3个数a,b,c，按大小顺序输出。
//        fun34();
//     【程序35】
//        题目：输入数组，最大的与第一个元素交换，最小的与最后一个元素交换，输出数组。
//        fun35();
//     【程序36】
//        题目：有n个整数，使其前面各数顺序向后移m个位置，最后m个数变成最前面的m个数
//        fun36(10, 5);
//     【程序37】
//        题目：有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问最后留下的是原来第几号的那位。
//        fun37(10);
//     【程序38】
//        题目：写一个函数，求一个字符串的长度，在main函数中输入字符串，并输出其长度。
//        System.out.println(fun38("wasd"));
//     【程序39】
//        题目：编写一个函数，输入n为偶数时，调用函数求1/2+1/4+...+1/n,当输入n为奇数时，调用函数1/1+1/3+...+1/n(利用指针函数)
//        fun39(10);
//     【程序40】
//        题目：字符串排序。
        fun40("fdbace");
    }


    // 数组逆序输出
    private static void fun31() {
        int[] arr = {1, 2, 3, 6, 7, 8,};
        int len = arr.length - 1;
        for (int i = len; i >= 0; i--) {
            System.out.print(arr[i] + "\t");
        }

    }

    // 取一个整数a从右端开始的4～7位。
    private static void fun32() {
        long num = 987654321L;
        String str = String.valueOf(num);
        int len = str.length();
        System.out.println(str.substring(len - 7, len - 3));
    }

    // 杨辉三角
    private static void fun33(int n) {
        int[][] arr = new int[n][2 * n + 1];
        arr[0][n] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = n - i; j < n + i + 1; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j + 1];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n + 1; j++) {
                if (arr[i][j] == 0) {
                    System.out.print("   ");
                } else {
                    if (arr[i][j] < 10) {
                        System.out.print("  " + arr[i][j]);
                    } else if (arr[i][j] < 100) {
                        System.out.print(" " + arr[i][j]);
                    } else {
                        System.out.print(arr[i][j]);
                    }
                }
            }
            System.out.println();
        }
    }

    // 按顺序输出
    private static void fun34() {
        int a = 20;
        int b = 10;
        int c = 30;
        int arr[] = new int[3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    // 最大的与第一个元素交换，最小的与最后一个元素交换
    private static void fun35() {
        int[] arr = {3, 6, 1, 0, 9, 8, 4};
        int max = arr[0];
        int min = arr[0];
        int maxIndex = 0;
        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
        arr[maxIndex] = arr[0];
        arr[0] = max;
        arr[minIndex] = arr[arr.length - 1];
        arr[arr.length - 1] = min;

        System.out.println(Arrays.toString(arr));

    }

    // 有n个整数，使其前面各数顺序向后移m个位置，最后m个数变成最前面的m个数
    private static void fun36(int n, int m) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = new int[m];
        int[] arr3 = new int[n];
        for (int i = m, j = 0; i < n; i++, j++) {
            arr2[j] = arr1[i];
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i < m) {
                arr3[i] = arr2[i];
            } else {
                arr3[i] = arr1[count++];
            }
        }
        System.out.println(Arrays.toString(arr3));
    }

    // 有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问最后留下的是原来第几号的那位。
    private static void fun37(int n) {
        int[] arr = new int[n];
        int count = 1;
        int flag = 0;
        Arrays.fill(arr, 1);
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                if (count == 3) {
                    arr[i] = 0;
                    count = 0;
                    flag++;
                }
                count++;
            }
            if (i == n - 1) {
                i = -1;
            }
            if (flag == n - 1) {
                break;
            }

        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                System.out.println(i + 1);
            }
        }
    }

    // 求字符串长度
    private static int fun38(String str) {
        return str.length();
    }

    // 编写一个函数，输入n为偶数时，调用函数求1/2+1/4+...+1/n,当输入n为奇数时，调用函数1/1+1/3+...+1/n(利用指针函数)
    private static void fun39(double n) {
        double sum = 0;
        if (n % 2 != 0) {
            for (int i = 1; i < n + 1; i += 2) {
                sum += 1.0 / i;
            }
            System.out.println(n + "为奇数,和为" + sum);
        } else {
            for (int i = 2; i < n + 1; i += 2) {
                sum += 1.0 / i;
            }
            System.out.println(n + "为偶数,和为" + sum);
        }
    }

    // 字符串排序。
    private static void fun40(String str) {
        String[] s = str.split("");
        String[] strings = {"aaa", "ace", "acd","abc"};
        Arrays.sort(strings);
        Arrays.sort(s);
        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.toString(s));
    }
}
