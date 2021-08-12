package smallchangesys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 账户类
 * 1. 属性：余额
 * 2. 方法：输出
 */
public class Account {

    private double sum;
    private List<Record> records;

    public Account(double sum) {
        records = new ArrayList<>();
        this.sum = sum;
    }

    public void handle(boolean income, String info, Date date, double amount) {
        if (income)
            sum += amount;
        else
            sum -= amount;
        records.add(new Record(income, info, date, amount, sum));
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
}
