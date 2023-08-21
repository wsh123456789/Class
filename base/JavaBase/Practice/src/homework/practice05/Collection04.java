package homework.practice05;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Collection04 {
    public static void main(String[] args) throws IOException {
        /**
         * 部门有5个人,信息如下:(姓名-工资)[安迪-38000,曲筱绡-20000,关雎尔-8000,樊胜美-9000,邱莹莹-6000]
         * 1.将以上员工的相关信息存放在合适的集合中
         * 2.给邱莹莹的工资涨500(不可以直接赋值)
         * 3.将工资大于7000的员工名单写到当前工程目录info.txt中,并写入行号
         *
         */
//        new FileWriter("src/homework/practice05/files/stu.txt")
        List<Emp> list = new ArrayList<>();
        list.add(new Emp("安迪", 38000));
        list.add(new Emp("曲筱绡", 20000));
        list.add(new Emp("关雎尔", 8000));
        list.add(new Emp("樊胜美", 9000));
        list.add(new Emp("邱莹莹", 6000));

        for (Emp emp : list) {
            if (emp.getName().equals("邱莹莹")) {
                emp.setSalary(emp.getSalary() + 500);
            }
        }
        int line = 1;
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/homework/practice05/files/info.txt"));
        for (Emp emp : list) {
            if (emp.getSalary() > 7000) {
                bw.write(String.valueOf(line)+ "    姓名：" + emp.getName() + "    工资：" + emp.getSalary());
                bw.newLine();
                bw.flush();
                line++;
            }
        }
        bw.close();
    }
}

class Emp {
    private String name;
    private double salary;

    public Emp() {
    }

    public Emp(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
