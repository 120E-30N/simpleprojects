/**
 * 题目来源：
 * 【零基础 快速学Java】韩顺平 零基础30天学会Java
 */
public class ArrayDemo {

    public static void main(String[] args) {
        function1(100);
        function1(1);
        function1(23);
        System.out.println("------------------");
        function2();
    }

    /**
     * 在一个升序数组中插入一个元素后，仍为升序数组
     */
    public static void function1(int number) {
        int[] numbers = {10, 12, 45, 90};
        int index = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= number) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            index = numbers.length;
        }
        int[] newNumbers = new int[numbers.length + 1];
        for (int i = 0, j = 0; i < newNumbers.length; i++) {
            if (i != index) {
                newNumbers[i] = numbers[j];
                j++;
            } else {
                newNumbers[i] = number;
            }
        }
        numbers = newNumbers;
        for (int num : numbers) {
            System.out.print(num + "\t");
        }
        System.out.println();
        /*
         for (int i = 0; i < newNumbers.length; i++) {
             if (i < index) {
                 newNumbers[i] = numbers[i];
             } else if (i == index){
                 newNumbers[i] = number;
             } else {
                 newNumbers[i] = numbers[i - 1];
             }
             System.out.print(newNumbers[i] + "\t");
         }
        */
    }

    /**
     * 生成一个有十个 1-100 范围内随机整数的数组
     * 1. 倒序打印
     * 2. 求平均、求最大值、求最大值下标
     * 3. 查找是否存在 8
     */
    public static void function2() {
        int[] numbers = new int[10];
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 100) + 1;
        }
        System.out.println("原数组：");
        int max = numbers[0];
        int maxIndex = 0;
        boolean is8 = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
                maxIndex = i;
            }
            if (numbers[i] == 8) {
                is8 = true;
            }
            sum += numbers[i];
            System.out.print(numbers[i] + "\t");
        }
        System.out.println("\n倒序数组：");
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i] + "\t");
        }
        System.out.printf("\n平均值：%.2f，最大值：%d，最大值下标：%d\n", sum/numbers.length, max, maxIndex);
        System.out.println("是否存在8：" + is8);
    }
}
