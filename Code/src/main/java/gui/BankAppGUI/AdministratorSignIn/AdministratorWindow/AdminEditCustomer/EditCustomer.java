package gui.BankAppGUI.AdministratorSignIn.AdministratorWindow.AdminEditCustomer;

import gui.Service.ReadCustomer;
import gui.Service.WriteCustomer;
import model.Customer;

import java.io.*;
import java.util.List;

public class EditCustomer {

    private static final ReadCustomer readCustomers =new ReadCustomer();
    private static final WriteCustomer writeCustomers =new WriteCustomer();

    public static boolean editCustomer(String customerID, String newName, String newAddress, String newPhone, String newEmail) throws IOException, IOException {
        List<Customer> customers = readCustomers.readCustomers();
        boolean found = false;

        for (Customer customer : customers) {
            if (customer.getCustomerID().equals(customerID)) {
                customer.setName(newName);
                customer.setAddress(newAddress);
                customer.setPhone(newPhone);
                customer.setEmail(newEmail);
                found = true;
                break;
            }
        }

        if (found) {
            writeCustomers.writeCustomers(customers);
            return true;
        } else {
            return false;
        }
    }
}
