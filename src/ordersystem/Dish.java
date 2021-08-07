package ordersystem;

/**
 * 菜品：
 * 1. 属性：编号、名字、价格
 * 2. 方法：显示菜品信息
 */
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
        System.out.printf("%d \t%s   \t %.2f\n", number, name, price);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
