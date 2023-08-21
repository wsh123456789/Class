package homework.practice05;

import java.io.*;
import java.util.ArrayList;

public class Collection12 {
    public static void main(String[] args) throws IOException {
        /**
         *  有一个数组 String arr[]={"abc","bad","abc","aab","bad","cef","jhi"};
         *  a. 创建一个ArrayList，将数组里面的元素添加进去，但元素不能重复 (该数组不变)
         *  b. 创建一个TreeSet，将数组里面的元素按升序序存入该集合里，并且不能去重
         *  c. 将数组里面的所有元素存入到项目根目录下的String.txt文件中
         */
        String arr[] = {"abc", "bad", "abc", "aab", "bad", "cef", "jhi"};
        ArrayList<String> aList = new ArrayList<>();
        for (String str : arr
        ) {
            if (!aList.contains(str)) {
                aList.add(str);
            }
        }
        System.out.println(aList);

//        TreeSet<String> tSet = new TreeSet<>();
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/homework/practice05/files/String.txt"));
        for (int i = 0; i < aList.size(); i++) {
            bw.write(aList.get(i));
            bw.newLine();
            bw.flush();
        }
        bw.close();
        BufferedReader br = new BufferedReader(new FileReader("src/homework/practice05/files/String.txt"));
        String str = null;
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
    }
}
