package homework.practice03.wangzhe;

public class WangZhe {
    private String name;
    private double price;
    private String color;

    public WangZhe() {
    }

    public WangZhe(String name, double price, String color) {
        this.name = name;
        this.price = price;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void JN() {
        System.out.println("我是技能");
    }

    public void pA() {
        System.out.println("平A");
    }

    public void JS() {
        System.out.println("英雄简介");
    }
}

