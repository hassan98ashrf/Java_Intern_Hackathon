package model;

import gui.Service.CreateTime;

public class SavingAccount extends Account {
    private double interestRate;
    private String savingAccountType;
    private String savingAccountID;


    public SavingAccount(String customerID ,String accountID,String accountType,  double balance, double interestRate) {
        super(customerID,accountID, accountType,balance);
        this.interestRate = interestRate;
    }

    public SavingAccount(String savingAccountID,String savingAccountType){
        super();
        this.savingAccountID = savingAccountID;
        this.savingAccountType = savingAccountType;
    }


    @Override
    public boolean withdraw(double amount, double withdrewBalance,double balances) {

        return balances >= amount;
    }



    public String getSavingDetails() {
        return  getAccountID() + "  ,  " + getCustomerID() + "  ,  " + getAccountType() + "  ,  " + balance + "  ,  " + interestRate + "  ,  " + "NULL";
    }
}
