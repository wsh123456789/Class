package homework.practice05;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Collection10 {
    public static void main(String[] args) throws IOException {
        /**
         * 3.有一个Map集合里面存储的是学生的姓名和年龄，内容如下{张三丰=21, 灭绝师太=38, 柳岩=28, 刘德华=40, 老鬼=36, 王二麻子=38}
         a.将里面的元素用两种遍历方式打印到控制台上
         b.将老鬼的年龄改成66
         c.将年龄大于24的学生姓名，存入到D:\\student.txt中
         *
         */
        Map<String,Integer> map = new HashMap<>();
        map.put("张三丰", 21);
        map.put("灭绝师太", 38);
        map.put("柳岩", 28);
        map.put("刘德华", 40);
        map.put("老鬼", 36);
        map.put("王二麻子", 38);
        // 方法一
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//        }

        // 方法二
//        for (String key : map.keySet()) {
//            int value = map.get(key);
//            System.out.println("Key = " + key + ", Value = " + value);
//        }

        // 方法三
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/homework/practice05/files/student.txt"));
        Iterator<Map.Entry<String, Integer>> entries = map.entrySet().iterator();

        while (entries.hasNext()) {
            Map.Entry<String, Integer> entry = entries.next();
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            if (entry.getKey().equals("老鬼")) {
                entry.setValue(66);
            }
            if (entry.getValue() > 24) {
                bw.write(entry.getKey() + entry.getValue());
                bw.newLine();
                bw.flush();
            }
        }
        bw.close();
        System.out.println(map);

    }
}
