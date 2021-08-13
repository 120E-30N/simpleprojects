package smallchangesys;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 内部类记录：
 * 1. 属性：信息，金额，时间
 * 2. 方法：输出
 */
class Record {

    private boolean income;
    private String info;
    private Date date;
    private double amount;
    private double sum;

    public Record(boolean income, Date date, double amount, double sum) {
        this.income = income;
        this.date = date;
        this.amount = amount;
        this.sum = sum;
    }

    public Record(boolean income, String info, Date date, double amount, double sum) {
        this(income, date, amount, sum);
        this.info = info;
    }

    @Override
    public String toString() {
        if (income)
            return info + "\t+" + amount + "\t"
                    + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date) + "\t余额：" + sum;
        else
            return info + "\t-" + amount + "\t"
                    + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date) + "\t余额：" + sum;
    }
}
