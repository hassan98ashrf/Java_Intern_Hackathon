package gui.BankAppGUI.AdministratorSignIn.AdministratorWindow.AdminDeleteCustomer;

import gui.Service.ReadAccount;
import gui.Service.ReadCustomer;
import gui.Service.WriteAccount;
import gui.Service.WriteCustomer;
import model.Account;
import model.Customer;

import java.io.IOException;
import java.util.List;

public class DeleteAccount {
    private ReadAccount readAccount = new ReadAccount();
    private WriteAccount writeAccount = new WriteAccount();

    public  boolean deleteAccounts(String customerID) throws IOException {
        List<Account> accounts = readAccount.readAccounts();
        boolean removedID = accounts.removeIf(account -> account.getCustomerID().equals(customerID));
        if (removedID ) {
            writeAccount.writeAccount(accounts);
            return true;
        } else {
            return false;
        }
    }
}
