package homework.practice03.car;

public class Vehicle {
    final String brand;
    String color;
    double speed = 0;

    public Vehicle(String brand) {

        this.brand = brand;
    }

    public Vehicle(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void run() {
        System.out.println("汽车奔跑");
    }
}
