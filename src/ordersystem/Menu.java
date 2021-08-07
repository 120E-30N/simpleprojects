package ordersystem;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<Dish> dishes = new ArrayList<>();
    private List<Dish> orders = new ArrayList<>();

    public Menu() {
        initDishes();
        showDishes();
    }

    private void initDishes() {
        dishes.add(new Dish("酸辣土豆丝", 12.00));
        dishes.add(new Dish("鱼香肉丝", 20.00));
        dishes.add(new Dish("番茄炒蛋", 15.00));
        dishes.add(new Dish("凉拌四季青", 8.00));
        dishes.add(new Dish("地三鲜", 17.00));
    }

    private void showDishes() {
        for (Dish dish : dishes) {
            dish.showInfo();
        }
    }

}
