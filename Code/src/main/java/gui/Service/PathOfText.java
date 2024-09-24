package gui.Service;

public class PathOfText {

    //add your path of text here
    private final String customerPath = "D:\\ITI_Testing\\Bqnk2\\src\\main\\resources\\customers.txt";
    private final String accountPath = "D:\\ITI_Testing\\Bqnk2\\src\\main\\resources\\accounts.txt";
    private final String accountTransactionPath = "D:\\ITI_Testing\\Bqnk2\\src\\main\\resources\\account_transaction.txt";

    public String getCustomerPath() {
        return customerPath;
    }

    public String getAccountPath() {
        return accountPath;
    }

    public String getAccountTransactionPath() {
        return accountTransactionPath;
    }
}
