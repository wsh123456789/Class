package homework.practice03.person_demo;

public class Dumb extends Person implements Eatable,Hearable{

    public Dumb() {
    }


    public Dumb(String name, String gender, int age) {
        super(name, gender, age);
    }
    @Override
    public void show() {
        System.out.println("哑巴姓名为" + getName() + "性别为" + getGender() + "年龄为" + getAge());
    }

    @Override
    public void eat() {
        System.out.println("哑巴可以吃饭");
    }

    @Override
    public void listen() {
        System.out.println("哑巴可以听见");
    }
}
