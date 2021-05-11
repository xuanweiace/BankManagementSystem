import java.util.ArrayList;
import java.util.Scanner;

public class CustomerDealer {//用这个类来处理用户对该银行账户的操作
    Customer customer;
    SavingAccount savingAccount;
    OverdraftProtectionAccount overdraftAccount;
    CreditAccount locAccount;

    public CustomerDealer() {
        savingAccount = null;
        overdraftAccount = null;
        locAccount = null;
        customer = null;
    }

    private void setDealer(Customer cus) {
        //先初始化
        savingAccount = null;
        overdraftAccount = null;
        locAccount = null;

        customer = cus;
        ArrayList<Account> customerAccounts = customer.getAccounts();
        for (int i = 0; i < customerAccounts.size(); i++) {
            Account now = customerAccounts.get(i);
            if (now.type.equals("S")) savingAccount = (SavingAccount) now;
            if (now.type.equals("O")) overdraftAccount = (OverdraftProtectionAccount) now;
            if (now.type.equals("L")) locAccount = (CreditAccount) now;
        }
    }

    public void run(Customer customer, Scanner in) {
        setDealer(customer);
        boolean running = true, state = false;
        double money;
        while (running) {
            showMenu();
            int choice = getChoice(in);
            switch (choice) {
                case 1:
                    state = createOverdraftAccount();
                    if (state) System.out.println("***Successful***");
                    else System.out.println("***Failed***");
                    break;
                case 2:
                    state = createLOCAccount();
                    if (state) System.out.println("***Successful***");
                    else System.out.println("***Failed***");
                    break;
                case 3://deposit saving account
                    System.out.println("Pleases enter the amount of money:");
                    money = in.nextDouble();
                    state = savingAccount.deposit(money);
                    if (state) System.out.println("***Successful***");
                    else System.out.println("***Failed***");
                    break;
                case 4://withdraw saving account
                    System.out.println("Pleases enter the amount of money:");
                    money = in.nextDouble();
                    state = savingAccount.withdraw(money, overdraftAccount);
                    if (state) System.out.println("***Successful***");
                    else System.out.println("***Failed***");
                    break;
                case 5://deposit overdraft protection account
                    if (overdraftAccount == null) {
                        System.out.println("This customer doesn't have overdraft protection account!");
                        System.out.println("***Failed***");
                        break;
                    }
                    System.out.println("Pleases enter the amount of money:");
                    money = in.nextDouble();
                    state = overdraftAccount.deposit(money);
                    if (state) System.out.println("***Successful***");
                    else System.out.println("***Failed***");
                    break;
                case 6://deposit LOC account
                    if (locAccount == null) {
                        System.out.println("This customer doesn't have LOC account!");
                        System.out.println("***Failed***");
                        break;
                    }
                    System.out.println("Pleases enter the amount of money:");
                    money = in.nextDouble();
                    state = locAccount.deposit(money);
                    if (state) System.out.println("***Successful***");
                    else System.out.println("***Failed***");
                    break;
                case 7://withdraw LOC account
                    if (locAccount == null) {
                        System.out.println("This customer doesn't have LOC account!");
                        System.out.println("***Failed***");
                        break;
                    }
                    System.out.println("Pleases enter the amount of money:");
                    money = in.nextDouble();
                    state = locAccount.withdraw(money);
                    if (state) System.out.println("***Successful***");
                    else System.out.println("***Failed***");
                    break;
                case 8:
                    System.out.println("---Start to print-----");
                    System.out.println(customer);
                    System.out.println("---End to print-----");
                    break;
                case 9:
                    running = false;
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Wrong input! Please try again!");
            }
        }
    }

    private boolean createLOCAccount() {
        if (locAccount != null) {
            System.out.println("LOC Account exist.");
            return false;
        }
        locAccount = new CreditAccount(0, "O", 10000, 0);
        customer.addAccount(locAccount);
        return true;
    }

    private boolean createOverdraftAccount() {
        if (overdraftAccount != null) {
            System.out.println("Overdraft Protection Account exist.");
            return false;
        }
        overdraftAccount = new OverdraftProtectionAccount(0, "O");
        customer.addAccount(overdraftAccount);
        return true;
    }

    private int getChoice(Scanner in) {
        System.out.println("Please enter your choice:");
        return in.nextInt();
    }


    private void showMenu() {
        System.out.println("******Please select business:************");
        System.out.println("******1、create overdraft protection account*****************");
        System.out.println("******2、create LOC account*****************");
        System.out.println("******3、deposit saving account*****************");
        System.out.println("******4、withdraw saving account*****************");
        System.out.println("******5、deposit overdraft protection account*****************");
        System.out.println("******6、deposit LOC account*****************");
        System.out.println("******7、withdraw LOC account*****************");
        System.out.println("******8、print info*****************");
        System.out.println("******9、exit*****************");

    }
}
