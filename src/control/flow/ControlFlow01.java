package control.flow;

/**
 * 题目来源：
 * 【零基础 快速学Java】韩顺平 零基础30天学会Java
 */
public class ControlFlow01 {

    public static void main(String[] args) {
        function1(100_000);
        function2(0);
        function2(1);
        function2(-1);
        function3(1900);
        function3(2008);
        function4(153);
        function4(154);
        function4(13);
        function4(999);
    }

    /**
     * 某人有 100_000 元，每次经过路口都需要缴费：
     *  1. > 50_000: 每次交 5%
     *  2. <= 50_000: 每次交 1_000
     * 计算该人可以经过多少次路口
     */
    public static void function1(double money) {
        int count = 0;
        double sum = money;
        while (true) {
            if (sum < 1_000) {
                break;
            } else if (sum > 50_000) {
                sum *= 0.95;    // sum -= sum * 0.05;
                count++;
            } else if (sum <= 50_000){
                sum -= 1_000;
                count++;
            }
        }
        System.out.printf("当有%.2f元时，可以通过路口%d次\n", money, count);
    }

    /**
     * 判断一个整数，属于哪个范围：
     * 1. 大于 0
     * 2. 小于 0
     * 3. 等于 0
     */
    public static void function2(int number) {
        if (number > 0) {
            System.out.println("大于 0");
        } else if (number < 0) {
            System.out.println("小于 0");
        } else {
            System.out.println("等于 0");
        }
    }

    /**
     * 判断一个年份是否为闰年 leap year
     * 1. 普通年能被4整除；且不能被100整除的为闰年
     * 2. 世纪年能被400整除的是闰年
     */
    public static void function3(int year) {
        if (year % 100 == 0 && year % 400 == 0) {
            System.out.println(year + "是闰年");
        } else if (year % 4 == 0 && year % 100 != 0) {
            System.out.println(year + "是闰年");
        } else {
            System.out.println(year + "不是闰年");
        }
    }

    /**
     * 判断一个整数是否为水仙花数：
     * 1. 一个三位数
     * 2. 各个位上数字的立方和等于其本身
     */
    public static void function4(int number) {
        if (number/100 < 1 || number/100 > 9) {
            System.out.println("请输入一个三位数");
            return;
        }
        int first = number % 10;  // 个位
        int second = number / 10 % 10;  // 十位，或 number % 100 / 10
        int third = number / 100;  // 百位
//        if (number == first*first*first + second*second*second + third*third*third) {
        if (number == Math.pow(first, 3) + Math.pow(second, 3) + Math.pow(third, 3)) {
            System.out.println(number + "是水仙花数");
        } else {
            System.out.println(number + "不是水仙花数");
        }
    }
}
