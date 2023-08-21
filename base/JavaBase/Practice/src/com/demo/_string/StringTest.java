package com.demo._string;

import java.util.Arrays;


public class StringTest {
    public static void main(String[] args) {
//      String概述和构造方法
//
//      概述：
//        String类代表字符串。 Java程序中的所有字符串文字（例如"abc" ）都被实现为此类的实例。
//        引用数据类型，一般都是用new关键字创建对象
//        string一个不可变的字符序列（对象的属性值不可变）
//
//      构造方法：
//
//public String():空构造   “”
        String s1 = "";
//public String(byte[] bytes):把字节数组转成字符串
        byte[] arr1 = {72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100};
        String str1 = new String(arr1);
        System.out.println(str1);
//public String(byte[] bytes,int index,int length):把字节数组的一部分转成字符串
        String str2 = new String(arr1, 0, 5);
        System.out.println(str2);
//public String(char[] value):把字符数组转成字符串   //字符常量 字符串
        char[] c = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', '!'};
        String str3 = new String(c);
        System.out.println(str3);
//public String(char[] value,int index,int count):把字符数组的一部分转成字符串
        String str4 = new String(c, 6, 6);
        System.out.println(str4);
//public String(String original):把字符串常量值转成字符串
        final String s2 = "ni hao";
        String str5 = new String(s2);
        System.out.println(str5);
//        String类的获取功能
//
//        int length():获取字符串的长度。
        String str6 = "hello world world!";
        System.out.println(str6.length());
//        char charAt(int index):获取指定索引位置的字符
        System.out.println(str6.charAt(1));
//        int indexOf(int ch):返回指定字符在此字符串中第一次出现处的索引。
        System.out.println(str6.indexOf("l"));
//        int indexOf(String str):返回指定字符串在此字符串中第一次出现处的索引。
        System.out.println(str6.indexOf("wor"));
//        int indexOf(int ch,int fromIndex):返回指定字符在此字符串中从指定位置后第一次出现处的索引。
        System.out.println(str6.indexOf("l", 6));
//        int indexOf(String str,int fromIndex):返回指定字符串在此字符串中从指定位置后第一次出现处的索引。
        System.out.println(str6.indexOf("world", 5));
//        lastIndexOf ( 从后往前检索)
        System.out.println(str6.lastIndexOf("d"));
        System.out.println(str6.lastIndexOf("world"));
        System.out.println(str6.lastIndexOf("world", 6));
//        String substring(int start):从指定位置开始截取字符串,默认到末尾。
        System.out.println(str6.substring(6));
//        String substring(int start,int end):从指定位置开始到指定位置结束截取字符串。
        System.out.println(str6.substring(6, 11));
//      String类的转换功能
//
//        byte[] getBytes():把字符串转换为字节数组。
        System.out.println(Arrays.toString(str6.getBytes()));
//        char[] toCharArray():把字符串转换为字符数组。
        System.out.println(Arrays.toString(str6.toCharArray()));
//        static String valueOf(char[] chs):把字符数组转成字符串。
        char[] ch = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(String.valueOf(ch));
//        static String valueOf(int i):把int类型的数据转成字符串。
        int arr = 123;
        System.out.println(String.valueOf(arr).equals("123"));
        System.out.println(String.valueOf(arr));
//        注意：String类的valueOf方法可以把任意类型的数据转成字符串。
//
//        String toLowerCase():把字符串转成小写。(了解)
        String a = "Hello World!";
        System.out.println(a.toLowerCase());
//                String toUpperCase():把字符串转成大写。
        System.out.println(a.toUpperCase());
//        String concat(String str):把字符串拼接。  +
        a = a.concat(" wsh");
        System.out.println(a);
//      String类的判断功能
//
//        boolean equals(Object obj):比较字符串的内容是否相同,区分大小写
        String eq1 = "AbCd";
        String eq2 = "aBcD";
        System.out.println(eq1.equals(eq2));
//        boolean equalsIgnoreCase(String str):比较字符串的内容是否相同,忽略大小写
        System.out.println(eq1.equalsIgnoreCase(eq2));
//        boolean contains(String str):判断字符串中是否包含参数字符串
        System.out.println(eq1.contains("Ab"));
//        boolean startsWith(String str):判断字符串是否以指定的参数字符串开头
        System.out.println(eq1.startsWith("A"));
        System.out.println(eq1.startsWith("b", 1));
//        boolean endsWith(String str):判断字符串是否以某个指定的参数字符串结尾
        System.out.println(eq1.endsWith("d"));
//        boolean isEmpty():判断字符串是否为空。 null
        System.out.println(eq1.isEmpty());
//#### String类的其他功能
//
//###### String的替换功能
//
//      String replace(char old,char new)
//      不会改变原字符串，会返回一个新字符串
        String eq3 = eq1.replace('A','a');
        System.out.println(eq3);
        System.out.println(eq1);
//      String replace(String old,String new)
        System.out.println(eq1.replace("Ab", "aB"));
//      String的去除字符串首尾空格
//      不会改变原字符串，返回一共新字符串;
        String tr = "  abcd   ";
//      String trim()
        String tr1 = tr.trim();
        System.out.println(tr1);
        System.out.println(tr);
    }
}
