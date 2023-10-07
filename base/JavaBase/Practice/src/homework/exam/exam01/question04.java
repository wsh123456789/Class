package homework.exam.exam01;

import java.util.Scanner;
import java.util.TreeSet;

public class question04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Student> treeSet = new TreeSet<>();
        for (int i = 0; i < 5; i++) {
            Student s = new Student();
            System.out.println("请输入第" + (i + 1) + "个学生的姓名");
            s.setName(sc.next());
            System.out.println("请输入第" + (i + 1) + "个学生的语文成绩");
            s.setChinese(sc.nextDouble());
            System.out.println("请输入第" + (i + 1) + "个学生的数学成绩");
            s.setMath(sc.nextDouble());
            System.out.println("请输入第" + (i + 1) + "个学生的英语成绩");
            s.setEnglish(sc.nextDouble());
            s.setScore();
            treeSet.add(s);
        }
        for (Student stu: treeSet) {
            System.out.println(stu);
        }

    }
}

class Student implements Comparable<Student> {
    private String name;
    private double chinese;
    private double math;
    private double English;
    private double score;

    public Student() {
    }

    public Student(String name, double chinese, double math, double english, double score) {
        this.name = name;
        this.chinese = chinese;
        this.math = math;
        English = english;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getChinese() {
        return chinese;
    }

    public void setChinese(double chinese) {
        this.chinese = chinese;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getEnglish() {
        return English;
    }

    public void setEnglish(double english) {
        English = english;
    }

    public void setScore() {
        score = score = this.chinese + this.math + this.English;
    }
    public double getScore() {
        return score;
    }

    @Override
    public int compareTo(Student o) {
        return -Double.compare(this.score, o.score);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", chinese=" + chinese +
                ", math=" + math +
                ", English=" + English +
                ", score=" + score +
                '}';
    }
}
