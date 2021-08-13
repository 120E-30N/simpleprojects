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
                System.out.println(account.toString());
                break;

            case 2:
                System.out.print("请输入金额：");
                double amount1 = scanner.nextDouble();
                account.income(amount1, new Date());
                break;

            case 3:
                System.out.print("请输入消费信息：");
                String note = scanner.next();
                System.out.print("请输入金额：");
                double amount2 = scanner.nextDouble();
                account.consume(note, amount2, new Date());
                break;

            case 4:
                System.out.print("确认退出输入 y：");
                String confirm = scanner.next();
                if (confirm.equals("y"))
                    isRun = false;
                break;

            default:
                break;
        }
    }
}
