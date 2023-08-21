package homework.practice03.car;

public class Car extends Vehicle{

    public Car(String brand) {
        super(brand);
    }

    public Car(String brand, String color) {
        super(brand, color);
    }

    int loader;

    public Car(String brand, String color, int loader) {
        super(brand, color);
        this.loader = loader;
    }

    public int getLoader() {
        return loader;
    }

    public void setLoader(int loader) {
        this.loader = loader;
    }

    @Override
    public void run() {
        System.out.println("品牌为" + brand +   "颜色为" + color + "的汽车以" + speed + "km/s 的速度在奔跑");
    }
}
