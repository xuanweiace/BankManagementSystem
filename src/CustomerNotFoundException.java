public class CustomerNotFoundException extends Exception{
    public CustomerNotFoundException(String message) {
        super(message);
    }

    public static void main(String[] args) {
        CustomerNotFoundException x = new CustomerNotFoundException("asd");
        System.out.println(x.getMessage());
    }
}
