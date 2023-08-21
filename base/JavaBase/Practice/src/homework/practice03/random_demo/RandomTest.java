package homework.practice03.random_demo;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
* 随机点名1.0

	 (1)、录入学生信息 String数组，由班主任决定录入学生个数
 	 (2)、查看录入的信息是否正确 - 遍历数组
	 (3)、随机点名同学 - 随机索引：
		一次随机点名三个同学 ，名字不可以重复
		随机出学生需要回答的问题，一次三个，题目不能重复

随机点名2.0
	使用Student类作为引用数据类型数组，完成点名和题目
	属性：姓名、班级
	随机出的三道题不在属性里面

*/
public class RandomTest {
    public static void main(String[] args) {
        System.out.println("请输入学生个数");
        Scanner sc = new Scanner(System.in);
        int stuNum = sc.nextInt();
        Student[] stu = new Student[stuNum];
        for (int i = 0; i < stuNum; i++) {
            Student s = new Student();
            System.out.println("请输入第" + (i + 1) + "个学生的姓名");
            s.name = sc.next();
            System.out.println("请输入第" + (i + 1) + "个学生的班级");
            s.grade = sc.nextInt();
            stu[i] = s;
        }
        System.out.println("所有学生信息如下：");
        System.out.println("姓名\t\t班级");
        for (Student s : stu) {
            System.out.printf("%-8s",s.getName());
            System.out.printf("%-8s",s.getGrade());
            System.out.println();
        }
        String[] rs = randomStu(stu, stuNum);
        String[][] rq = randomQuestion();
        for (int i = 0; i < 3; i++) {
            System.out.println("学生姓名为" + rs[i]);
            for (int j = 0; j < 3; j++) {
                System.out.println(rq[i][j]);
            }
        }
    }
    public  static String[] randomStu(Student[] stu, int stuNum) {
        String[] rs = new String[3];
        int[] arr = new int[stuNum];
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int r = random.nextInt(stuNum);
            if (arr[r] == 0) {
                arr[r] = 1;
                rs[i] = stu[r].name;
            } else {
                i--;
            }
        }
        return rs;

    }
    public static String[][] randomQuestion() {
        String[] qb = {"题目1", "题目2", "题目3", "题目4", "题目5"};
        String[][] rq = new String[3][3];
        Random random = new Random();
        int[] arr = new int[5];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(arr,0);
            for (int j = 0; j < 3; j++){
                int r = random.nextInt(5);
                if (arr[r] == 0) {
                    arr[r] = 1;
                    rq[i][j] = qb[r];
                } else {
                    i--;
                }
            }

        }
        return rq;
    }
}
