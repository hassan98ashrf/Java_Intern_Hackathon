package gui.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckAccountDepositOrWithdrew {
    private static final PathOfText accountPath =new PathOfText();

    public static boolean doesAccountIDExist(String accountID , String accountType) {
        try (BufferedReader reader = new BufferedReader(new FileReader(accountPath.getAccountPath()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("  ,  ");
                if (data[0].equals(accountID) && data[2].equals(accountType) ) {
                    return true;  // Account ID found and has the same type
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;  // Account ID not found
    }
}
