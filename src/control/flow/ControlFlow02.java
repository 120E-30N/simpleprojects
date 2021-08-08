package control.flow;

/**
 * 题目来源：
 * 【零基础 快速学Java】韩顺平 零基础30天学会Java
 */
public class ControlFlow02 {
    public static void main(String[] args) {
        function1();
        function2();
        function3();
        function4();
    }

    /**
     * 输出 1-100 之间，不能被 5 整除的数，每 5 个一行
     */
    public static void function1() {
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 5 != 0) {
                count++;
                if (count % 5 != 0) {
                    System.out.print(i + "\t");
                } else {
                    System.out.print(i + "\n");
                }
            }
        }
    }

    /**
     * 输出 a-z 和 Z-A
     */
    public static void function2() {
        for (char i = 'a'; i <= 'z'; i++) {
            System.out.print(i);
        }
        System.out.println();
        for (char i = 'Z'; i >= 'A'; i--) {
            System.out.print(i);
        }
        System.out.println();
    }

    /**
     * 求结果： 1 - 1/2 + 1/3 - 1/4 ... - 1/100
     * 陷阱：保留精度，得到精确值
     */
    public static void function3() {
        double sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                sum += 1.0/i;
            } else {
                sum -= 1.0/i;
            }
        }
        System.out.println(sum);
    }

    /**
     * 求结果： 1 +（1+2）+（1+2+3）+...+（1+2+3+...+100）
     */
    public static void function4() {
        int sum = 0;
        for (int i = 1; i <= 100 ; i++) {
            for (int j = 1; j <= i; j++) {
                sum += j;
            }
        }
        System.out.println(sum);
    }
}
