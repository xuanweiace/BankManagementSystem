import java.util.ArrayList;
import java.util.Scanner;

public class Bank {//银行类
    private ArrayList<Customer> customers;//银行下的账户集合
    private String bankname;//银行名字
    private Scanner in;
    private int register_id;//该银行当前未使用的银行卡号，默认从100000开始依次+1
    //TODO
    private Customer login_customer;//当前登录顾客
    private CustomerDealer customerDealer;//处理用户的操作类对象
    private int now_customers;
    private final int MAX_NUM_OF_CUSTOMERS = 10000;

    public Bank() {
        customers = new ArrayList<Customer>();
        this.bankname = "THEi BANK";
        in = new Scanner(System.in);
        customerDealer = new CustomerDealer();
        register_id = 10001;
        now_customers = 0;
    }

    public Bank(String bankname) {
        customers = new ArrayList<Customer>();
        this.bankname = bankname;
        in = new Scanner(System.in);
        customerDealer = new CustomerDealer();
        register_id = 10001;
        now_customers = 0;
    }

    public void run() throws CustomerNotFoundException {
        boolean running = true;
        while (running) {
            this.showMenu();
            int choice = this.getChoice();
            switch (choice) {
                case 1:
                    this.createCustomer();
                    break;
                case 2:
                    this.logIn();
                    break;
                case 3:
                    this.searchCustomer();
                    break;
                case 4:
                    this.thankyouMessage();
                    running = false;
                    break;
                default:
                    System.out.println("Wrong input! Please try again!");
            }
        }
    }

    private void searchCustomer() throws CustomerNotFoundException {
        System.out.println("Please enter customer ID:");
        int id = in.nextInt();
        Customer tar_account = null;
        for (int i = 0; i < customers.size(); i++) {
            Customer now = customers.get(i);
            if (now.getCustomerId() == id) tar_account = now;
        }
        if (tar_account == null) {
            throw new CustomerNotFoundException("Customer not found!!");
        }
        for (int i = 0; i < customers.size(); i++) {//因为一个customer可以有多个Account所以不能直接用taraccount
            Customer now = customers.get(i);
            if (now.getCustomerId() == id) System.out.println(now.toString());
        }
    }

    private void logIn() {
        System.out.println("You can try to login at most 3 times!");
        boolean success_login = false;
        int try_times = 0;
        while (!success_login && try_times < 3) {
            try_times++;
            System.out.println("Please enter your customer id:");
            int customer_id = in.nextInt();
            System.out.println("Please enter your password:");
            String password = in.next();

            for (int i = 0; i < customers.size(); i++) {
                Customer now = customers.get(i);
                if (now.customerId == customer_id && password.equals(now.pwd)) {
                    success_login = true;
                    login_customer = now;
                    break;
                }
            }
            if (!success_login) System.out.println("You have entered wrong account id or password. Please try again!");
        }
        if (!success_login) {
            System.out.println("You have tried too many times. Login failed!");
        } else {
            System.out.println("*****Successful login!********");
            customerDealer.run(login_customer, in);
        }
    }

    private void thankyouMessage() {
        System.out.println("******Thank you for using " + this.bankname + " bank system! Bye!**************");
    }

    private void createCustomer() {
        if (now_customers >= MAX_NUM_OF_CUSTOMERS) {//检验customer数量是否超过MAX_NUM_OF_CUSTOMERS
            System.out.println("The bank has served " + MAX_NUM_OF_CUSTOMERS + "customers!");
            System.out.println("Create failed!");
        }
        //输入customer信息
        System.out.println("Enter your name:");
        String name = in.next();

        System.out.println("Enter your password:");
        String password = in.next();

        System.out.println("Enter your password again:");
        String password_again = in.next();
        while (!password_again.equals(password)) {
            System.out.println("Sorry, the two passwords you entered are not the same, please try again!");
            System.out.println("Please re-enter your password:");
            password = in.next();
            System.out.println("Please reconfirm your password");
            password_again = in.next();
        }
        System.out.println("Please enter your address:");
        String address = in.next();

        System.out.println("Please enter your phone number:");
        String phoneNumber = in.next();
        System.out.println("You have deposited 100 dollars!");
        Customer customer = new Customer(register_id, password, address, name, phoneNumber);
        customer.addAccount(new SavingAccount(100, "S"));
        customers.add(customer);
        System.out.println("Successfully create account！");
        System.out.println("Hello " + name + " !");
        System.out.println("Please remember! Your customerId id is: " + register_id);
        register_id++;
        now_customers++;
    }

    private int getChoice() {
        System.out.println("Please enter your choice:");
        return in.nextInt();
    }

    private void showMenu() {
        System.out.println("******Welcome to " + this.bankname + "management system********");
        System.out.println("******Please select business***************");
        System.out.println("******1、Create Customer**************");
        System.out.println("******2、Login**************");
        System.out.println("******3、Search Customer**************");
        System.out.println("******4、Exit system**************");
    }

}
