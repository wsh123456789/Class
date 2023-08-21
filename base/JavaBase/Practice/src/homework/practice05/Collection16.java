package homework.practice05;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Collection16 {
    public static void main(String[] args) throws IOException {
        /**
         * 定义一个 集合,存储六个信息(姓名,年龄),完成以下需求
         * 1.将名为"小丫"的年龄改为18
         * 2.按年龄降序将元素存入到"D:\\child.txt"中
         */
        List<Children> list = new ArrayList<>();
        list.add(new Children("小狗", 16));
        list.add(new Children("小猫", 19));
        list.add(new Children("小丫", 20));
        list.add(new Children("小红", 12));
        list.add(new Children("小明", 15));
        list.add(new Children("小金", 17));
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().equals("小丫")) {
                list.get(i).setAge(18);
            }
        }
        list.sort((o1,o2) -> o1.getAge() < o2.getAge() ? 0 : -1);
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/homework/practice05/files/child.txt"));
        for (Children c: list
             ) {
            bw.write("姓名:" + c.getName() + "    年龄:" + c.getAge());
            bw.newLine();
            bw.flush();
        }
        bw.close();
        System.out.println(list);
    }
}

class Children {
    private String name;
    private int age;

    public Children() {
    }

    public Children(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "\nChildren{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
