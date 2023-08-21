package com.demo._collection;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest {
    public static void main(String[] args) {
        // HashSet 和 TreeSet 用法相同，存储方式和保证唯一性方法不同
        HashSet<String> hs = new HashSet<>();
        // 添加元素
        hs.add("aaa");
        hs.add("bbb");
        hs.add("ccc");
        hs.add("ddd");
        System.out.println(hs);
        // 查询是否含有指定元素
        System.out.println(hs.contains("bbb"));
        // 集合是否为空
        System.out.println(hs.isEmpty());
        // 返回该集合中元素个数（其基数）
        System.out.println(hs.size());
        // 如果当前存在，则从该集合中移除指定的元素。
        hs.remove("aaa");
        System.out.println(hs);
        Iterator<String> it = hs.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        // 清空值
        hs.clear();
        System.out.println(hs);

    }
}
