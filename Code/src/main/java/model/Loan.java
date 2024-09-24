package model;

public class Loan extends Account {
    private double interestRate;
    private double loanDuration;

    public Loan(String customerID ,String accountID,String accountType,  double balance, double interestRate,double loanDuration) {
        super(customerID,accountID,accountType, balance);
        this.interestRate = interestRate;
        this.loanDuration = loanDuration;
    }


    public String getLoanDetails() {
        return getAccountID() + "  ,  " + getCustomerID()+ "  ,  " + getAccountType() + "  ,  " + balance + "  ,  " + interestRate + "  ,  " + loanDuration;
    }
}
