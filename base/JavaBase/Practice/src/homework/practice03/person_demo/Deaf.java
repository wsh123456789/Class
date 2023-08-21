package homework.practice03.person_demo;

public class Deaf extends Person implements Eatable, Sayable {

    public Deaf() {
    }

    public Deaf(String name, String gender, int age) {
        super(name, gender, age);
    }

    @Override
    public void show() {
        System.out.println("聋子姓名为" + getName() + "性别为" + getGender() + "年龄为" + getAge());
    }

    @Override
    public void eat() {
        System.out.println("聋子可以吃饭");
    }

    @Override
    public void speak() {
        System.out.println("聋子可以说话");
    }
}
