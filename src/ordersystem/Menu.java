package ordersystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 菜单：
 * 1. 属性：菜品列表，已点列表，总金额
 * 2. 方法：- 点单：各个界面直接的交互
 *         - 展示主界面
 *         - 展示菜品列表：按照菜品编号进行点单
 *         - 展示已点列表：可以根据已点菜品的编号进行退点，每次只能退点一个菜品
 *         - 展示总金额：确认总金额，以及下单
 */
public class Menu {

    private List<Dish> dishes = new ArrayList<>();
    private List<Dish> orders = new ArrayList<>();
    public Scanner scanner;
    private double sum;

    public Menu() {
        initDishes();
        this.scanner = new Scanner(System.in);
    }

    public void order() {
        while (true) {
            showMenu();
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    showDishes();
                    while (input != 0) {
                        System.out.print("请输入：");
                        input = scanner.nextInt();
                        if (input != 0) {
                            System.out.printf("已点： %s\n", dishes.get(input - 1).getName());
                            orders.add(dishes.get(input - 1));
                        }
                    }
                    break;

                case 2:
                    showOrders();
                    System.out.print("请输入：");
                    input = scanner.nextInt();
                    if (input != 0) {
                        System.out.printf("退点： %s\n", orders.get(input - 1).getName());
                        orders.remove(dishes.get(input - 1));
                    }
                    break;

                case 3:
                    showBill();
                    System.out.print("输入1确认结账： ");
                    input = scanner.nextInt();
                    if (input == 1) {
                        System.out.println("共计 " + sum + "，成功下单");
                        System.exit(0);
                    }
                    break;

                case 4:
                    System.exit(0);

                default:
                    break;
            }
        }
    }

    private void showMenu() {
        System.out.println("-----------点菜系统-----------");
        System.out.println("1\t菜单");
        System.out.println("2\t已点");
        System.out.println("3\t结账");
        System.out.println("4\t退出");
        System.out.println("-----------编号转跳-----------");
        System.out.print("请输入： ");
    }

    private void initDishes() {
        dishes.add(new Dish("酸辣土豆丝", 12.00));
        dishes.add(new Dish("鱼香肉丝", 20.00));
        dishes.add(new Dish("番茄炒蛋", 15.00));
        dishes.add(new Dish("凉拌四季青", 8.00));
        dishes.add(new Dish("地三鲜", 17.00));
    }

    private void showDishes() {
        System.out.println("-----------本店菜单-----------");
        for (Dish dish : dishes) {
            dish.showInfo();
        }
        System.out.println("----序号点单，输入0返回主菜单----");
    }

    private void showOrders() {
        System.out.println("-----------已点菜单-----------");
        int number = 0;
        for (Dish dish : orders) {
            System.out.println(++number + " " + dish.getName());
        }
        System.out.println("----序号退点，输入0返回主菜单----");
    }

    private void showBill() {
        sum = 0;
        for (Dish dish : orders) {
            sum += dish.getPrice();
        }
        System.out.println("------------账 单------------");
        System.out.println("总金额： " + sum);
        System.out.println("--------输入0返回主菜单--------");
    }
}
