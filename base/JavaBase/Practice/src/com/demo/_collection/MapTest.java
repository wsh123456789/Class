package com.demo._collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        /// HashMap 和 TreeMap 用法一致
        HashMap<String, Integer> map = new HashMap<>();
        // 将指定的值与此映射中的指定键关联。(添加元素)
        // 键不能重复，一个键最多对应一个值，重复存入会覆盖前边的值
        map.put("aaa", 111);
        map.put("aaa", 222);
        System.out.println(map);
        map.put("bbb",333);
        map.put("ccc",666);
        System.out.println(map);
        // 如果存在的话，从这个映射中移除指定的键的映射。
        map.remove("bbb");
        System.out.println(map);
        // 仅当它当前映射到某一值时，替换指定的键的条目。
        map.replace("aaa", 111);
        System.out.println(map);
        // 仅当当前映射到指定的值时，替换指定的键的条目。
        // 此时不会修改，因为aaa已经与111映射， 只有当aaa映射到222时才会修改
        map.replace("aaa", 222, 333);
        System.out.println(map);
        // 返回这个映射中的键值映射的数目。
        System.out.println(map.size());
        // 判断是否为空
        System.out.println(map.isEmpty());
        // 返回一个 Set的关键视图包含在这个Map。
        System.out.println(map.keySet());
        // 返回一个 Collection视图的值包含在这个Map。
        System.out.println(map.values());
        // 返回一个 Set视图的映射包含在这个Map。
        System.out.println(map.entrySet());
        // 迭代器实现遍历
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        // 返回 true如果这Map包含一个指定的键映射。
        System.out.println(map.containsKey("ccc"));
        // 返回 true如果映射到指定的值的一个或多个键
        System.out.println(map.containsValue(666));
        // 返回该 HashMap实例浅拷贝：键和值本身不是克隆
        System.out.println(map.clone());
        // 从这个映射中移除所有的映射。
        map.clear();
        System.out.println(map);

    }
}
