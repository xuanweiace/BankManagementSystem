//import java.util.Scanner;
//
//public class AccountDealer {//用这个类来处理用户对该银行账户的操作
//    public void run(Account account, Scanner in) {
//        boolean running = true, state = false;
//        double money;
//        String type = account.type;
//        while (running) {
//            showMenu(type);
//            int choice = getChoice(in);
//            if (type.equals("save")) {
//                switch (choice) {
//                    case 1:
//                        System.out.println("Pleases enter the amount of money:");
//                        money = in.nextDouble();
//                        state = account.deposit(money);
//                        if(state) System.out.println("***Successful***");
//                        else System.out.println("***Failed***");
//                        break;
//                    case 2:
//                        System.out.println("Pleases enter the amount of money:");
//                        money = in.nextDouble();
//                        state = account.withdraw(money, overdraftAccount);
//                        if(state) System.out.println("***Successful***");
//                        else System.out.println("***Failed***");
//                        break;
//                    case 3:
//                        System.out.println(account.toString());
//                        break;
//                    case 4:
//                        running = false;
//                        System.out.println("Bye!");
//                        break;
//                    default:
//                        System.out.println("Wrong input! Please try again!");
//                }
//            } else if (type.equals("credit")) {
//                switch (choice) {
//                    case 1:
//                    case 4:
//                        System.out.println("Pleases enter the amount of money:");
//                        money = in.nextDouble();
//                        state = account.deposit(money);
//                        if(state) System.out.println("***Successful***");
//                        else System.out.println("***Failed***");
//                        break;
//                    case 2:
//                    case 3:
//                        System.out.println("Pleases enter the amount of money:");
//                        money = in.nextDouble();
//                        state = account.withdraw(money, overdraftAccount);
//                        if(state) System.out.println("***Successful***");
//                        else System.out.println("***Failed***");
//                        break;
//                    case 5:
//                        System.out.println(account.toString());
//                        break;
//                    case 6:
//                        running = false;
//                        System.out.println("Bye!");
//                        break;
//                    default:
//                        System.out.println("Wrong input! Please try again!");
//                }
//            } else System.out.println("Wrong input! Please try again!");
//        }
//
//
//    }
//
//    private int getChoice(Scanner in) {
//        System.out.println("Please enter your choice:");
//        return in.nextInt();
//    }
//
//    private void showMenu(String type) {
//        if (type.equals("save")) {
//            System.out.println("******Please select business:************");
//            System.out.println("******1、deposit*****************");
//            System.out.println("******2、withdraw*****************");
//            System.out.println("******3、Print Account Information*****************");
//            System.out.println("******4、exit*****************");
//        } else {
//            System.out.println("******Please select business:************");
//            System.out.println("******1、deposit*****************");
//            System.out.println("******2、withdraw*****************");
//            System.out.println("******3、loans*****************");
//            System.out.println("******4、repayment*****************");
//            System.out.println("******5、Print Account Information*****************");
//            System.out.println("******6、exit*****************");
//        }
//    }
//}
