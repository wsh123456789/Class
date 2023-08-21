package com.demo.base;

import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args) {
        // 常用数组方法
        /*
         * Math.random() 生成随机数[0,1)
         * */

        // 数组扩容
        int[] arr4 = new int[]{1, 2, 3, 4};
        int[] newArr = new int[arr4.length << 1];
        for (int i = 0; i < arr4.length; i++) {
            newArr[i] = arr4[i];
        }
        newArr[arr4.length] = 10;
        newArr[arr4.length + 1] = 20;
        newArr[arr4.length + 2] = 30;

        arr4 = newArr;
        System.out.println(arr4.length);

        // 数组元素的删除
        // 删除一个元素，把后边元素前移，最后元素归零

        // 比较两个数组的元素是否相等
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[]{1, 2, 3, 4, 5};

        System.out.println(arr1 == arr2); //比地址 false
        boolean isEquals = Arrays.equals(arr1, arr2);// 比内容 true
        System.out.println(isEquals);

        // 输出元素信息
        System.out.println(Arrays.toString(arr1));

        // 将指定元素填充数组
        Arrays.fill(arr1, 10);
        System.out.println(Arrays.toString(arr1));

        // 二分查找 (数组必须有序)
        int[] arr5 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 5;
        int head = 0;
        int end = arr5.length - 1;
        while (head <= end) {
            int mid = (head + end) / 2;
            if (target == arr5[mid]) {
                System.out.println("找到了" + target);
                break;
            } else if (target > arr5[mid]) {
                head = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        // 二分查找
        arr5 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int index = Arrays.binarySearch(arr5, 5);
        System.out.println("二分查找结果索引为" + index);

        // 时间复杂度 1 < log2n < n < nlog2n < n² < n³ < ... < 2ⁿ < n! < nⁿ
        // 冒泡排序(n²)
        int[] arr6 = new int[]{34, 54, 3, 2, 65, 7, 34, 5, 76, 34, 67};

        for (int i = 0; i < arr6.length - 1; i++) {
            for (int j = 0; j < arr6.length - 1 - i; j++) {
                if (arr6[j] > arr6[j + 1]) {
                    int temp = arr6[j];
                    arr6[j] = arr6[j + 1];
                    arr6[j + 1] = temp;
                }
            }

        }
        System.out.print("冒泡排序:\t");
        for (int i = 0; i < arr6.length; i++) {
            System.out.print(arr6[i] + "\t");
        }

        // 快排 (nlog2n)
        int[] arr7 = new int[]{34, 54, 3, 2, 65, 7, 34, 5, 76, 34, 67};
        Arrays.sort(arr7);
        System.out.println("\n快排: " + Arrays.toString(arr7));

        // 常见异常
        // 数组角标越界异常: ArrayIndexOutOfBoundsException
        // 空指针: NullPointerException


    }
}
