package gui.Service;

import model.Account;
import model.CheckingAccount;
import model.Customer;
import model.SavingAccount;
import gui.Service.ReadAccount;
import java.io.IOException;
import java.util.List;

public class UpdateAccount {
    private static final ReadAccount readAccount =new ReadAccount();
    private static final WriteAccount writeAccount =new WriteAccount();

    public static boolean editDeposit( String accountID,String depositAmount) throws IOException, IOException {

        List<Account> accounts = readAccount.readAccounts();
        boolean found = false;
        for (Account account : accounts) {
            if (account.getAccountID().equals(accountID)) {
                account.setBalanceString(String.valueOf(Double.parseDouble(account.getBalanceString())+Double.parseDouble(depositAmount)));
                found = true;
                break;
            }
        }
        if (found) {
            writeAccount.writeAccount(accounts);
            return true;
        }
        else {
            return false;
        }

    }

    public static boolean editWithdrew( String accountID,String withdrewAmount) throws IOException, IOException {

        List<Account> accounts = readAccount.readAccounts();
        boolean found = false;
        for (Account account : accounts) {
            if (account.getAccountID().equals(accountID)) {
                account.setBalanceString(String.valueOf(Double.parseDouble(account.getBalanceString())-Double.parseDouble(withdrewAmount)));
                found = true;
                break;
            }
        }
        if (found) {
            writeAccount.writeAccount(accounts);
            return true;
        }
        else {
            return false;
        }

    }

    public static double withdrewLimit(String accountID)throws IOException, IOException {
        List<Account> accounts = readAccount.readAccounts();
        double limit = 0;
        for (Account account : accounts) {
            if (account.getAccountID().equals(accountID)) {
                limit = Double.parseDouble(account.getInteresetString());
                break;
            }
        }
        return limit;
    }

    public static double withdrewBalance(String accountID)throws IOException, IOException {
        List<Account> accounts = readAccount.readAccounts();
        double balance = 0;
        for (Account account : accounts) {
            if (account.getAccountID().equals(accountID)) {
                balance = Double.parseDouble(account.getBalanceString());
                break;
            }
        }
        return balance;
    }


}
