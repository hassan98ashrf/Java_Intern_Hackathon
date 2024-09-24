package gui.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckCustomerID {
    private static PathOfText customerPath = new PathOfText();

    public static boolean isCustomerIDExists(String customerID) {
        try (BufferedReader reader = new BufferedReader(new FileReader(customerPath.getCustomerPath()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("  ,  ");
                if (data[0].equals(customerID)) {
                    return true;  // Customer ID found
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
