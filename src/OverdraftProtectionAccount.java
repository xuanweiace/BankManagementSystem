public class OverdraftProtectionAccount extends Account{
    private final double defaultMonthlyFee = 50;
    public OverdraftProtectionAccount(double balance, String type) {
        super(balance, type);
    }
    public boolean payMonthlyFee(int numOfMonth) {
        if (balance >= defaultMonthlyFee * numOfMonth) {
            balance -= defaultMonthlyFee * numOfMonth;
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return "Overdraft Protection Account{" +
                "balance=" + balance +
                ", type='" + type + '\'' +
                '}';
    }
}
