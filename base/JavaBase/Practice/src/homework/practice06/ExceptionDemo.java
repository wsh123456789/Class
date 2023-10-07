package homework.practice06;

public class ExceptionDemo {
    public static void main(String[] args) throws Exception {
        Student s = new Student();
        s.setAge(-2);
    }
}

class Student {
    int age;

    public void setAge(int age) throws Exception {
        if (age >= 0) {
            this.age = age;
        }
        else {
            throw new Exception("年龄异常");
        }
    }
}
