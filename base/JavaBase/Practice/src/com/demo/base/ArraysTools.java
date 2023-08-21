package com.demo.base;

import java.util.Arrays;

public class ArraysTools {

    public static void main(String[] args) {
        int arr[] = {11, 22, 33, 44, 55};
//		 * toString(int[] a)  将数组以字符串形式返回
//		System.out.println(Arrays.toString(arr));
//
//		 * binarySearch(int[] a, int key)  查找元素索引
//		System.out.println(Arrays.binarySearch(arr, 12));
//		 * binarySearch(int[] a, int fromIndex, int toIndex, int key)  在指定范围内查找元素索引 - 含左不含右
//		 *                        从几索引开始        ，   到几索引结束   ， 查谁
//		 *
//		System.out.println(Arrays.binarySearch(arr,3,6, 33));
//
//		 * copyOf(int[] original, int newLength) 复制指定的数组  newLength - 长度
//		 * 			复制的数组                    复制的长度

//		System.out.println(Arrays.toString(Arrays.copyOf(arr, 10)));
//		 * copyOfRange(int[] original, int from, int to)  复制指定范围的数组 - 左含右不含
//		 * 							  从哪开始复制        从哪结束复制
//		 *
//		System.out.println(Arrays.toString( Arrays.copyOfRange(arr, 1, 4)));
//
        int arr2[] = {11, 22, 33, 44, 55}; //[I@15db9742
        int arr3[] = {11, 22, 33, 44, 55};

//		 * equals(long[] a, long[] a2) 判断两个数组是否相等
//		 System.out.println(Arrays.equals(arr2, arr3));
//
//
//		* fill(int[] a, int val)  一次性改变数组所有的元素
//		  *     需改的数组       改成什么内容

//		Arrays.fill(arr2, 1);
//		System.out.println(Arrays.toString(arr2));

//		 * hashCode(int[] a)  返回数组的哈希码表值
//		System.out.println(Arrays.hashCode(arr2));
//
//
//		 * sort(int[] a)  对指定数组，进行升序排序
        int arr5[] = {99, 33, 66, 44, 22, 11};
        Arrays.sort(arr5, 0, 3);
        System.out.println(Arrays.toString(arr5));
//		 * sort(int[] a, int fromIndex, int toIndex)   对指定数组，在一定范围内进行升序排序
//		 *               [ 从哪个索引开始     ，   从哪个索引结束  )
    }
}
