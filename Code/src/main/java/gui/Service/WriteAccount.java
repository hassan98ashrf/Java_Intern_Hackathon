package gui.Service;

import model.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteAccount {

    private static final PathOfText accountPath = new PathOfText();


    public void writeAccount(List<Account> accounts) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(accountPath.getAccountPath()));
        for (Account account : accounts) {
            String line = String.format("%s  ,  %s  ,  %s  ,  %s  ,  %s  ,  %s",
                    account.getAccountID(),
                    account.getCustomerID(),
                    account.getAccountType(),
                    account.getBalanceString(),
                    account.getInteresetString(),
                    account.getLoannString()
            );
            writer.write(line);
            writer.newLine();
        }
        writer.close();
    }
}
