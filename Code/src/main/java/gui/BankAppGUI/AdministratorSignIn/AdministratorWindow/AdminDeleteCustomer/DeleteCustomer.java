package gui.BankAppGUI.AdministratorSignIn.AdministratorWindow.AdminDeleteCustomer;

import gui.Service.ReadCustomer;
import gui.Service.WriteCustomer;
import model.Customer;

import java.io.IOException;
import java.util.List;

public class DeleteCustomer {
    private ReadCustomer readCustomers = new ReadCustomer();
    private WriteCustomer writeCustomers = new WriteCustomer();

    public  boolean deleteCustomer(String customerID) throws IOException {
        List<Customer> customers = readCustomers.readCustomers();
        boolean removedID = customers.removeIf(customer -> customer.getCustomerID().equals(customerID));
        if (removedID ) {
            writeCustomers.writeCustomers(customers);
            return true;
        } else {
            return false;
        }
    }
}
