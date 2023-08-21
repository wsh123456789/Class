package homework.practice05;

import java.util.*;

public class Collection11 {
    public static void main(String[] args) {
        /**
         * 定义一个实体类有姓名、学号、成绩(int类型)三个属性
         (1)在创建对象时给这些属性进行显式初始化
         (2)将学生的信息(姓名、学号、成绩)存入到适当的集合，并且根据学生成绩按照降序打印到控制台

         */
        Student[] stu = new Student[3];
        stu[0] = new Student("aaa", "0101", 72);
        stu[1] = new Student("bbb", "0102", 80);
        stu[2] = new Student("ccc", "0103", 75);
        List<Student> list = new ArrayList<>();
        list.add(stu[0]);
        list.add(stu[1]);
        list.add(stu[2]);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j).getScore() < list.get(j + 1).getScore()) {
                    Student s = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,s);
                }
            }
        }

        System.out.println(list);
    }
}

class Student {
    private String name;
    private String uid;
    private int score;

    public Student() {
    }

    public Student(String name, String uid, int score) {
        this.name = name;
        this.uid = uid;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "\nStudent{" +
                "name='" + name + '\'' +
                ", uid='" + uid + '\'' +
                ", score=" + score +
                '}';
    }

}
