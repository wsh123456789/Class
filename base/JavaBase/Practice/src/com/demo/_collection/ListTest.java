package com.demo._collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListTest {
    public static void main(String[] args) {
        // list
        List<String> l = new ArrayList<>();
        // 添加元素
        l.add("aaa");
        l.add("bbb");
        l.add("ccc");
        System.out.println(l);
        // 获取元素
        System.out.println(l.get(1));
        // 修改元素
        l.set(1, "ddd");
        // 是否存在元素
        System.out.println(l.contains("aaa"));
        // 返回此列表中指定元素的第一个出现的索引，或-如果此列表不包含元素，或- 1。
        System.out.println(l.indexOf("aaa"));
        // 判断列表是否为空
        System.out.println(l.isEmpty());
        // 删除元素
        l.remove(1);
        System.out.println(l);
        // 迭代器
        // hasNext() 是否存在下个元素
        // next() 返回迭代中的下个元素
        // remove()  从基础集合中移除这个迭代器返回的最后一个元素（可选操作）
        Iterator<String> iterator = l.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("------------------------------------");
        // ListIterator可对集合进行add set 等方法进行并行处理
        ListIterator<String> stringListIterator = l.listIterator();
        while (stringListIterator.hasNext()) {
            System.out.println(stringListIterator.next());
        }
    }
}
