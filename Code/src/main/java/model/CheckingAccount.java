package model;

import gui.Service.CreateTime;

public class CheckingAccount extends Account {
    private double creditLimit;
    private String checkingAccountType;
    private String checkingAccountID;


    public CheckingAccount(String customerID ,String accountID,String accountType, double balance, double creditLimit ) {
        super(customerID,accountID, accountType,balance);
        this.creditLimit = creditLimit;
    }

    public CheckingAccount(String checkingAccountID,String checkingAccountType) {
        super();
        this.checkingAccountID = checkingAccountID;
        this.checkingAccountType = checkingAccountType;
    }


    @Override
    public boolean withdraw(double amount, double creditLimit , double balances) {
        return (amount <= creditLimit) && (balances >= amount);

    }


    public String getCheckingDetails() {
        return  getAccountID() + "  ,  " + getCustomerID() + "  ,  " + getAccountType() + "  ,  " + balance + "  ,  " + creditLimit + "  ,  " + "NULL";
    }
}