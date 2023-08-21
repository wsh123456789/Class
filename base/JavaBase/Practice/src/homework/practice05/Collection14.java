package homework.practice05;

import java.util.*;

public class Collection14 {
    static class Student {
        private String name;
        private int chinese;
        private int math;
        private int english;
        private int score;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getChinese() {
            return chinese;
        }

        public void setChinese(int chinese) {
            this.chinese = chinese;
        }

        public int getMath() {
            return math;
        }

        public void setMath(int math) {
            this.math = math;
        }

        public int getEnglish() {
            return english;
        }

        public void setEnglish(int english) {
            this.english = english;
        }

        public int getScore() {
            score = chinese + math + english;
            return score;
        }

        @Override
        public String toString() {
            return "\nStudent{" +
                    "name='" + name + '\'' +
                    ", chinese=" + chinese +
                    ", math=" + math +
                    ", english=" + english +
                    ", score=" + score +
                    '}';
        }
    }
    public static void main(String[] args) {
        /**
         * 需求:键盘录入5个学生的信息(姓名,语文成绩,数学成绩,英语成绩),按照总分从高到低输出到控制台
         * 1.定义一个学生类,属性姓名,语文成绩,数学成绩,英语成绩,总分

         */

        Scanner sc = new Scanner(System.in);
        Student[] stu = new Student[5];
//        Collection14.Student[] stu = new new Student[5];
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            stu[i] = new Student();
            System.out.println("请输入第" + (i + 1) + "个学生的姓名");
            stu[i].setName(sc.next());
            System.out.println("请输入第" + (i + 1) + "个学生的语文成绩");
            stu[i].setChinese(sc.nextInt());
            System.out.println("请输入第" + (i + 1) + "个学生的数学成绩");
            stu[i].setMath(sc.nextInt());
            System.out.println("请输入第" + (i + 1) + "个学生的英语成绩");
            stu[i].setEnglish(sc.nextInt());
            list.add(stu[i]);
        }
        list.sort((o1, o2) -> -(o1.getScore() - o2.getScore()));
        System.out.println(list);

    }
}
