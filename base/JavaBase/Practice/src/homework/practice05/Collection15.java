package homework.practice05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Collection15 {
    public static void main(String[] args) {
        /**
         * 创建一个Map集合,里面有如下元素[林志颖=kimi,王岳伦=王诗龄,
         * 田亮=田雨橙,黄磊=黄忆慈,郭涛=石头,陆毅=贝尔]
         * 1.两种方式遍历集合,并统计有多少对父子(女)
         * 2.将林志颖儿子修改为Jenson
         * 3.删除陆毅父女
         *

         */
        Map<String, String> map = new HashMap<>();
        map.put("林志颖", "kimi");
        map.put("王岳伦", "王诗龄");
        map.put("田亮", "田雨橙");
        map.put("黄磊", "黄忆慈");
        map.put("郭涛", "石头");
        map.put("陆毅", "贝尔");
//        System.out.println(map);
        int count = 0;

        // 方法一
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//            count++;
//        }

        // 方法二
//        for (String key : map.keySet()) {
//            String value = map.get(key);
//            System.out.println("Key = " + key + ", Value = " + value);
//            count++;
//        }

        // 方法三
        Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();

        while (entries.hasNext()) {
            Map.Entry<String, String> entry = entries.next();
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            count++;
            if (entry.getKey().equals("林志颖")) {
                entry.setValue("Jenson");
            }
            if (entry.getKey().equals("陆毅")) {
                entries.remove();
            }
        }

        System.out.println("一共有" + count + "对父子(女)");
        System.out.println(map);
    }
}
