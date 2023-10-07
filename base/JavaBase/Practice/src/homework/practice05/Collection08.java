package homework.practice05;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Collection08 {
    public static void main(String[] args) throws IOException {
        /**
         * 2.给定一个list集合:{"张柏芝","刘德华","张亮","张靓颖","杨颖","黄晓明"}
         * 1.编写一个方法:将list集合中所有姓张的人员写入到D:\\a.txt中
         * 2.编写一个方法:将D:\\a.txt中所有姓张的人员信息读取出来并打印到控制台上
         *
         *
         */
        List<String> list = new ArrayList<>();
        list.add("张柏芝");
        list.add("刘德华");
        list.add("张亮");
        list.add("张靓颖");
        list.add("杨颖");
        list.add("黄晓明");
        list.add("乖张");
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/homework/practice05/files/a.txt"));
        for (String str : list) {
            if(str.toCharArray()[0] == '张') {
                bw.write(str);
                bw.newLine();
                bw.flush();
            }
        }
        bw.close();

//        File file = new File("src/homework/practice05/files/a.txt");
//        FilePractice fis = new FilePractice("src/homework/practice05/files/a.txt");
        FileReader fr = new FileReader("src/homework/practice05/files/a.txt");
        BufferedReader br = new BufferedReader(fr);
        String str = null;
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
    }
}
