package homework.shop.bean;

//商品类
public class Goods {
    private int id;
    private int count;
    private String name;
    private double price;

    public Goods() {
        super();
    }

    public Goods(int id, int count, String name, double price) {
        super();
        this.id = id;
        this.count = count;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    @Override
    public String toString() {
        return "Goods [id=" + id + ", count=" + count + ", name=" + name + ", price=" + price + "]";
    }


}
