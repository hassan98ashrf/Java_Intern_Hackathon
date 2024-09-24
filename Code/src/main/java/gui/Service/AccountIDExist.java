package gui.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AccountIDExist {


    public static boolean doesAccountIDExist(String accountID , String type) {
        try (BufferedReader reader = new BufferedReader(new FileReader(type))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("  ,  ");
                if (data[0].equals(accountID)) {
                    return true;  // Account ID found
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;  // Account ID not found
    }
}
