package homework.practice05;

import java.util.HashMap;
import java.util.Map;

public class Collection09 {
    public static void main(String[] args) {
        /**
         现在有一个map集合如下:{1="张三丰",2="周芷若",3="汪峰",4="灭绝师太"} 要求:
         1.将map集合中的所有信息显示到控制台上
         2.向该map集合中插入一个编码为5姓名为李晓红的信息
         3.移除该map中的编号为1的信息

         4.将map集合中编号为2的姓名信息修改为"周林"
         */
        Map<Integer, String> m = new HashMap<>();
        m.put(1 ,"张三丰");
        m.put(2 ,"周芷若");
        m.put(3 ,"汪峰");
        m.put(4 ,"灭绝师太");
        System.out.println(m);
        m.put(5, "李晓红");
        System.out.println(m);
        m.remove(1);
        System.out.println(m);
        m.replace(2, "周林");
        System.out.println(m);
    }
}
