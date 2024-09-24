package gui.Service;

import model.Customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCustomer {
    private static final PathOfText customerPath = new PathOfText();

    public List<Customer> readCustomers() throws IOException {
        List<Customer> customers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(customerPath.getCustomerPath()));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] details = line.split("  ,  ");
            String customerID = details[0];
            String name = details[1];
            String address = details[2];
            String phone = details[3];
            String email = details[4];
            customers.add(new Customer(customerID, name, address, phone, email));
        }
        reader.close();
        return customers;
    }
}
