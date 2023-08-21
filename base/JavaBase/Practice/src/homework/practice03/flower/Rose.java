package homework.practice03.flower;

public class Rose extends Flower {
    private String pop;

    public Rose(String color, double price, String pop) {
        super(color, price);
        this.pop = pop;
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    @Override
    public void showInfo() {
        System.out.println("玫瑰花颜色为" + getColor() + "价格为" + getPrice());
        System.out.println("玫瑰花产地为" + pop);
    }

    public void warn() {
        System.out.println("警告显示：不要摘玫瑰花，小心扎手。");
    }
}
