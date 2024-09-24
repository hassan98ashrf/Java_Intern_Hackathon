package gui.Service;

import model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadAccount {
    private static final PathOfText accountPath = new PathOfText();

    public List<Account> readAccounts() throws IOException {
        List<Account> accounts = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(accountPath.getAccountPath()));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] details = line.split("  ,  ");
            String accountID = details[0];
            String customerID = details[1];
            String accountType = details[2];
            String Balance = details[3];
            String interestRate = details[4];
            String loan = details[5];

            accounts.add(new Account(customerID, accountID, accountType, Balance, interestRate, loan));
        }
        reader.close();
        return accounts;
    }

}
