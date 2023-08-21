package com.demo._string;

public class StringClass {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer("aaabbbccc");
        System.out.println(s1);
        System.out.println(s2);

        s1.append(1);
        System.out.println(s1);
        // 插入
        s1.insert(1, "aaabbbccc");
        System.out.println(s1);
        // 添加
        s1.append(1);
        System.out.println(s1);
        // 删除单个字符
        s1.deleteCharAt(0);
        System.out.println(s1);
        s1.delete(0,2);
        System.out.println(s1);
        s1.replace(0,2, "aaa");
        System.out.println(s1);
        s1.reverse();
        System.out.println(s1);
    }
}
