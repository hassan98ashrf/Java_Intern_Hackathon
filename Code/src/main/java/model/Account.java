package model;


import gui.Service.CreateTime;

public class Account extends Customer {
    protected String accountID;
    protected double balance;
    protected String accountType;
    protected String balanceString;
    protected String interesetString;
    protected String loannString;


    public Account(String customerID,String accountID, String accountType, String balance,String interesetString,String loannString) {
        super(customerID);
        this.accountID = accountID;
        this.balanceString = balance;
        this.accountType = accountType;
        this.interesetString = interesetString;
        this.loannString = loannString;
    }

    public Account(String customerID,String accountID, String accountType, double balance) {
        super(customerID);
        this.accountID = accountID;
        this.balance = balance;
        this.accountType = accountType;

    }

    public Account(String accountID,String accountType){
        super();
        this.accountID = accountID;
        this.accountType = accountType;
    }

    public Account() {

    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
        return accountID + "  ,  " + CreateTime.getTime()+ "  ,  "+ accountType + "  ,  " + balance ;
    }

    public boolean withdraw(double amount, double withdrewBalance,double balances) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }


    public String getBalanceString() {
        return balanceString;
    }

    public void setBalanceString(String balanceString) {
        this.balanceString = balanceString;
    }

    public String getInteresetString() {
        return interesetString;
    }


    public String getLoannString() {
        return loannString;
    }


    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }
}