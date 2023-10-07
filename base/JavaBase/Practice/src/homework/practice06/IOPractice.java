package homework.practice06;

import java.io.*;
import java.util.Scanner;
import java.util.TreeMap;

public class IOPractice {
    public static void main(String[] args) throws IOException {
        IOPractice io = new IOPractice();
//        1.需求：在控制台录入一个文件的路径,将此文件拷贝到当前项目下（要求拷贝后的文件与原文件同名）
        io.copyDir();
//        2. 需求：将键盘录入的数据拷贝到当前项目下的text.txt文件中,键盘录入数据当遇到quit时就退出
        io.keyBoardInputFile();
//        3.需求：获取一个文本上每个字符出现的次数,将结果写在times.txt上
        io.countCharNum();
//        4.需求：当我们下载一个试用版软件,没有购买正版的时候,
//        每执行一次就会提醒我们还有多少次使用机会用学过的IO流知识,模拟试用版软件,
//        试用10次机会,执行一次就提示一次您还有几次机会,如果次数到了提示请购买正版
        io.timeOfUse();
    }

    // 拷贝文件
    public void copyDir() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要拷贝文件的路径");
        String filePath = sc.nextLine();
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            bw = new BufferedWriter(new FileWriter("src/homework/practice06/fileDemo.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null && bw != null) {
                try {
                    br.close();
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 键盘录入数据写入文件
    public void keyBoardInputFile() {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw1 = null;
        try {
            bw1 = new BufferedWriter(new FileWriter("src/homework/practice06/text.txt"));
            String line;
            System.out.println("请输入要录入的数据");
            while (!(line = sc.nextLine()).equals("quit")) {
                bw1.write(line);
                bw1.newLine();
                bw1.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw1 != null) {
                try {
                    bw1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 计算字符个数写入文件
    public void countCharNum() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader("src/homework/practice06/text.txt"));
            bw = new BufferedWriter(new FileWriter("src/homework/practice06/times.txt"));
            TreeMap<String, Integer> treeMap = new TreeMap<>();

            String str;
            while ((str = br.readLine()) != null) {
                String[] s = str.split("");
                for (int i = 0; i < s.length; i++) {
                    if (treeMap.containsKey(s[i])) {
                        int value = treeMap.get(s[i]) + 1;
                        treeMap.put(s[i], value);
                    } else {
                        treeMap.put(s[i], 1);
                    }
                }
            }
            for (String key : treeMap.keySet()) {
                String message = key + ": " + treeMap.get(key);
                bw.write(message);
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null && bw != null) {
                try {
                    br.close();
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 计算使用次数
    public void timeOfUse() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/homework/practice06/config.txt"));
        String line = br.readLine();
        int times = Integer.parseInt(line);
        if (times > 0) {
            System.out.println("您还有" + times-- + "次机会");
            FileWriter fw = new FileWriter("src/homework/practice06/config.txt");
            fw.write(times + "");
            fw.close();

        } else {
            System.out.println("您的试用次数已到,请购买正版");
        }
        br.close();

    }
}
