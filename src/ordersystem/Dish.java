package ordersystem;

public class Dish {

    public static int counter = 0;

    private int number;
    private String name;
    private double price;

    public Dish(String name, double price) {
        this.number = ++counter;
        this.name = name;
        this.price = price;
    }

    public void showInfo() {
        System.out.println("number: " + number + ", name: " + name + ", price: " + price);
    }
}
