public class CreditAccount extends Account {//信用卡类，继承自银行卡类，对于信用卡类，需要Override存钱和取钱方法。
    private double loan_limit;//贷款额度
    private double now_loan;//已贷款金额
    private final double MAX_LOAN_LIMIT = 100000;
    private final double defaultMonthlyFee = 80;

    public CreditAccount(double balance, String type, double loan_limit, double now_loan) {
        super(balance, type);
        this.loan_limit = loan_limit;
        this.now_loan = now_loan;
    }

    public boolean payMonthlyFee(int numOfMonth) {
        if (balance + (loan_limit - now_loan) >= defaultMonthlyFee * numOfMonth) {//如果当前余额加上 可贷款额度，是可以付monthlyfee的，则付。
            balance -= defaultMonthlyFee * numOfMonth;
            if(balance < 0) {//如果付款后余额<0了，则这部分要算到loan中。
                now_loan -= balance;
                balance = 0;
            }
            return true;
        }
        return false;
    }

    public boolean setLoan_limit(double loan_limit) {
        if (loan_limit > MAX_LOAN_LIMIT) {//如果贷款超出额度了，则报错
            System.out.println("The loan limit can not exceed " + MAX_LOAN_LIMIT + "dollars!");
            return false;
        }
        this.loan_limit = loan_limit;
        return true;
    }

    @Override
    public boolean deposit(double money) {
        if (now_loan >= money) {//如果当前还有贷款则需要先还贷款
            now_loan -= money;
        } else {
            money -= now_loan;
            now_loan = 0;
            balance += money;
        }
        return true;
    }

    @Override
    public boolean withdraw(double money) {
        if (money <= this.balance) {//如果还有余额，则先取余额
            this.balance -= money;
            return true;
        }
        if (money > balance + loan_limit - now_loan) return false;//加上可用的贷款额度也不够想取钱的money数额，因此无法取钱
        money -= balance;
        balance = 0;
        now_loan += money;
        return true;
    }

    @Override
    public String toString() {
        return "Credit Card{" +
                "balance=" + balance +
                ", type='" + type + '\'' +
                ", loan_limit=" + loan_limit +
                ", now_loan=" + now_loan +
                '}';
    }

}
