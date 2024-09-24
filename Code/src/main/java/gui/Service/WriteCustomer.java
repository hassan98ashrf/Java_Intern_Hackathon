package gui.Service;

import model.Customer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteCustomer {
    private static final PathOfText customerPath = new PathOfText();

    public void writeCustomers(List<Customer> customers) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(customerPath.getCustomerPath()));
        for (Customer customer : customers) {
            String line = String.format("%s  ,  %s  ,  %s  ,  %s  ,  %s",
                    customer.getCustomerID(),
                    customer.getName(),
                    customer.getAddress(),
                    customer.getPhone(),
                    customer.getEmail());
            writer.write(line);
            writer.newLine();
        }
        writer.close();
    }
}
