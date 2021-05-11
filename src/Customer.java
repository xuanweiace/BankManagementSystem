import java.util.ArrayList;

public class Customer {
    public int customerId;//银行卡号
    public String pwd;//银行卡密码
    public String address;//持有者身份证号
    public String name;//持有者姓名
    public String phone_num;//持有者电话

    private ArrayList<Account> accounts;

    public Customer(int customerId, String pwd, String address, String name, String phone_num) {
        accounts = new ArrayList<>();
        this.customerId = customerId;
        this.pwd = pwd;
        this.address = address;
        this.name = name;
        this.phone_num = phone_num;
    }

    public boolean addAccount(Account account) {
        if (accounts.size() >= 3) return false;//如果这个customer有>=3张银行卡，则禁止添加银行卡。
        accounts.add(account);
        return true;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    @Override
    public String toString() {
        String s = "Customer{" +
                "customerId=" + customerId +
                ", pwd='" + pwd + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", phone_num='" + phone_num + '\'' +
                '}'+'\n';
        s += "Accounts:\n";
        for(int i = 0; i<accounts.size(); i++) {
            s += accounts.get(i).toString()+'\n';
        }
        return s;
    }
}
