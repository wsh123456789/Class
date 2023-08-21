package homework.practice03.flower;

public class Flower {
        private String color;
        private double price;

        public Flower() {
        }

        public Flower(String color, double price) {
                this.color = color;
                this.price = price;
        }

        public String getColor() {
                return color;
        }

        public void setColor(String color) {
                this.color = color;
        }

        public double getPrice() {
                return price;
        }

        public void setPrice(double price) {
                this.price = price;
        }

        public void showInfo() {
                System.out.println("颜色为" + color + "的花价格为" + price);
        }
}
