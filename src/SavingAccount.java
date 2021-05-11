import java.util.Calendar;
import java.util.GregorianCalendar;

public class SavingAccount extends Account {//储蓄卡类
    private final int minInitDeposit = 100;
    private double notAddInterest = 0;

    public SavingAccount(double balance, String type) {
        super(balance, type);
    }

    public void savingInterest(int day, int month) {
        GregorianCalendar calendar = new GregorianCalendar();
        int days_of_year = calendar.get(Calendar.DAY_OF_YEAR);//获取当前年份
        System.out.println("DDD"+days_of_year);
        notAddInterest += balance * 0.00125 / days_of_year * day;
        if (month == 6 || month == 12) {
            balance += notAddInterest;
            notAddInterest = 0;
        }
    }



    @Override
    public String toString() {
        return "Saving account{" +
                "balance=" + balance +
                ", type='" + type + '\'' +
                '}';
    }

    public boolean withdraw(double money, Account overdraftAccount) {
        if (money <= this.balance) {//如果余额够的话，就直接取钱
            this.balance -= money;
            return true;
        } else {
            double needToWithdraw = money - this.balance;
            if (overdraftAccount == null || !overdraftAccount.withdraw(needToWithdraw)) return false;
            else {
                this.balance = 0;
                return true;
            }
        }
    }
}
