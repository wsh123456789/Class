package homework.practice05;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Collection05 {
    public static void main(String[] args) throws IOException {
        /**
         * 有五个学生，每个学生有3门课（语文、数学、英语）的成绩，
         * 写一个程序接收从键盘输入学生的信息， 输入格式为：name,30,30,30
         * （姓名，三门课成绩），  然后把输入的学生信息按总分从高到低的顺序写入
         * 到一个名称"stu.txt"文件中。要求：stu.txt文件的格式要比较直观，
         * 打开这个文件，就可以很清楚的看到学生的信息。
         *
         */
        Scanner sc = new Scanner(System.in);
        List<Student1> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            System.out.println("请输入第" + (i + 1) + "学生信息：（用空格隔开）");
            System.out.println("姓名  语文  数学  英语");
            String[] s = sc.nextLine().split(" ");
            String name = s[0];
            int a = Integer.parseInt(s[1]);
            int b = Integer.parseInt(s[2]);
            int c = Integer.parseInt(s[3]);
            Student1 student1 = new Student1(name, a, b, c);
            list.add(student1);
        }
        Collections.sort(list, new StuCompare());
        BufferedWriter bf = new BufferedWriter(new FileWriter("src/homework/practice05/files/stu.txt"));
        for (Student1 stu : list) {
            bf.write(stu.toString());
            bf.newLine();
            bf.flush();
        }
        sc.close();
        bf.close();

    }
}

class Student1 {
    private String name;
    private int a, b, c, sum;

    //学生对象建立需要传入姓名和3门课的成绩
    public Student1(String name, int a, int b, int c) {
        this.name = name;
        this.a = a;
        this.b = b;
        this.c = c;
        sum = a + b + c;
    }

    public int getsum() {
        return sum;
    }

    @Override
    public String toString() {
        return name + "    语文：" + a + "    数学：" + b + "    英语：" + c + "    总分：" + sum;
    }

}

//定义比较器，按总分排序
class StuCompare implements Comparator<Student1> {
    public int compare(Student1 s1, Student1 s2) {
        int a = Integer.compare(s2.getsum(), s1.getsum());
        return a;
    }

}
