public abstract class Account {
    public double balance;//银行卡余额
    public String type;//银行卡类型

    public Account(double balance, String type) {
        this.balance = balance;
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //取钱
    public boolean withdraw(double money) {
        if (money <= this.balance) {//如果余额够的话，就直接取钱
            this.balance -= money;
            return true;
        }
        return false;
    }
    //存钱
    public boolean deposit(double money) {
        this.balance += money;//存到余额中
        return true;
    }

}
