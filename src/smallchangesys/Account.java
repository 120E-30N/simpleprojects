package smallchangesys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 账户类
 * 1. 属性：余额、记录
 * 2. 方法：支出、收入、输出
 */
public class Account {

    private double sum;
    private List<Record> records;

    public Account(double sum) {
        records = new ArrayList<>();
        this.sum = sum;
    }

    @Override
    public String toString() {
        if (records.size() == 0)
            return "没有任何记录";
        else {
            String str = "";
            for (Record record : records) {
                str += record.toString() + "\n";
            }
            return str;
        }
    }

    /**
     * 收入
     */
    public void income(double amount, Date date) {
        sum += amount;
        records.add(new Record(true, "收益", date, amount, sum));
    }

    /**
     * 支出
     */
    public void consume(String note, double amount, Date date) {
        if (sum - amount >= 0) {
            sum -= amount;
            records.add(new Record(false, note, date, amount, sum));
        } else {
            System.out.println("余额不足无法消费");
        }
    }
}
