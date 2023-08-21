package homework.practice05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Collection13 {
    public static void main(String[] args) throws IOException {
        /**
         *2.在当前项目根目录下有一个“qq.txt文件”里面存放的内容如下：（14分）
         （项目根目录,假设qq号的长度最大为11位）
         12345
         67891
         12347809933
         98765432102
         67891
         12347809933
         a.将该文件里面的所有qq号都存放在list中
         b.将list中重复元素删除
         c.将剩余元素进行排序(按照长度由小到大)
         d.将list中所有元素用两种方式打印出来

         */
        List<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("src/homework/practice05/files/qq.txt"));
        String str = null;
        while ((str = br.readLine()) != null) {
           if (!list.contains(str)) {
               list.add(str);
           }
        }
        list.sort((o1,o2) -> Long.parseLong(o1) > Long.parseLong(o2) ? 0 : -1 );
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("------------------------------");

        for (String s: list
             ) {
            System.out.println(s);
        }

        System.out.println("------------------------------");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
