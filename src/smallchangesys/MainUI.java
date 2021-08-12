package smallchangesys;

import java.util.Date;
import java.util.Scanner;

/**
 * 主界面
 *  信息 + 金额 + 时间 + 余额
 * 1. 明细
 * 2. 收益
 * 3. 消费
 * 4. 退出
 */
public class MainUI {

    private boolean isRun = true;
    private Scanner scanner;
    private Account account;

    public MainUI() {
        account = new Account(0);
        scanner = new Scanner(System.in);

        do {
            showMainUI();
            interactive();
        } while (isRun);
    }

    private void showMainUI() {
        System.out.println("-----------零钱通-----------");
        System.out.println("\t\t1\t明 细");
        System.out.println("\t\t2\t收 益");
        System.out.println("\t\t3\t消 费");
        System.out.println("\t\t4\t退 出");
        System.out.println("--------输入数字选择---------");
    }

    private void interactive() {
        System.out.print("请输入：");
        int input = scanner.nextInt();

        switch (input) {
            case 1:
                details();
                break;
            case 2:
                income();
                break;
            case 3:
                consume();
                break;
            case 4:
                System.out.println("退出系统");
                isRun = false;
                break;
            default:
                break;
        }
    }

    /**
     * 输出明细
     */
    private void details() {
        System.out.println("----------消费明细----------");
        System.out.println(account.toString());
    }

    /**
     * 获取收益信息
     */
    private void income() {
        System.out.print("请输入金额：");
        int income = scanner.nextInt();
        account.handle(true, "收益", new Date(), income);
    }

    /**
     * 获取消费信息
     */
    private void consume() {
//        System.out.println("请输入用途：");
//        String info = scanner.nextLine();
        System.out.print("请输入金额：");
        int income = scanner.nextInt();
        account.handle(false, "消费", new Date(), income);
    }

}
