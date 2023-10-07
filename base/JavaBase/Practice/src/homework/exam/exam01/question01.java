package homework.exam.exam01;

import java.util.Objects;
import java.util.TreeSet;

public class question01 {
    public static void main(String[] args) {
        TreeSet<Worker> treeSet = new TreeSet<>();
        Worker w1 = new Worker("aaa", 20, 100);
        Worker w2 = new Worker("ccc", 22, 200);
        Worker w3 = new Worker("bbb", 22, 300);
        treeSet.add(w1);
        treeSet.add(w2);
        treeSet.add(w3);
        for (Worker w: treeSet) {
            System.out.println(w);
        }
    }
}

class Worker implements Comparable<Worker>{
    private String name;
    private int age;
    private double salary;


    public Worker() {
    }

    public Worker(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Worker worker = (Worker) o;

        if (age != worker.age) return false;
        if (Double.compare(worker.salary, salary) != 0) return false;
        return Objects.equals(name, worker.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "worker{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Worker o) {
        if (this.age != o.age){
            return Integer.compare(this.age, o.age);
        }else {
            return this.name.compareTo(o.name);
        }

    }
}
