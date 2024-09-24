package gui.BankAppGUI.Customer.ViewTransactions;
import gui.BankAppGUI.AdministratorSignIn.AdministratorWindow.AdminReport.InitializeAdminReport;
import gui.Service.AccountIDExist;
import gui.Service.PathOfText;
import gui.Service.SetUpFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ViewTransactionsGUI extends JFrame {

    private InitializeViewTransaction initializeViewTransaction;
    private SetUpFrame viewTransactionGUIFrame;
    private PathOfText pathOfAccounts =new PathOfText();

    public ViewTransactionsGUI()  {
        // Set up frame
        viewTransactionGUIFrame = new SetUpFrame();
        viewTransactionGUIFrame.setFrame(this, "View Transactions", 500, 400);

        // Initialize components
        initializeViewTransaction = new InitializeViewTransaction();
        initializeViewTransaction.addComponentsToFrame(this);

        // Action listener for View button
        initializeViewTransaction.viewButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get accountID from customer
                String accountID = initializeViewTransaction.getTxtAccountID().getText();
                // Clear text area
                initializeViewTransaction.getTxtAreaTransactions().setText("");

                //Check if account ID is exist
                if (!AccountIDExist.doesAccountIDExist(accountID, pathOfAccounts.getAccountPath())) {
                    JOptionPane.showMessageDialog(null, "Account ID not exists. Please choose another.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Read transactions from file
                try (BufferedReader reader = new BufferedReader(new FileReader(pathOfAccounts.getAccountTransactionPath()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] data = line.split("  ,  ");
                        if (data[0].equals(accountID)) {
                            initializeViewTransaction.getTxtAreaTransactions().append(data[1] + "  -  " + data[2] + "  -  " + data[3] + "\n");
                        }
                    }
                } catch (IOException ioException) {
                    JOptionPane.showMessageDialog(null, "Error reading transaction data", "Error", JOptionPane.ERROR_MESSAGE);
                    ioException.printStackTrace();
                }
            }
        });


        initializeViewTransaction.cancelButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

}