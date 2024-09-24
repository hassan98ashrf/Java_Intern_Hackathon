package gui.BankAppGUI.Customer.BalanceEnquiry;

import gui.BankAppGUI.Customer.AddAccount.InitializeAddAccountComponents;
import gui.Service.AccountIDExist;
import gui.Service.CheckCustomerID;
import gui.Service.PathOfText;
import gui.Service.SetUpFrame;
import model.CheckingAccount;
import model.Loan;
import model.SavingAccount;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class BalanceEnquiryGUI extends JFrame {
    private InitializeBalanceEnquiry initializeComponents;
    private SetUpFrame balanceEnquiryGui ;
    private CheckingAccount checkingAccount;
    private SavingAccount savingAccount;
    private Loan loan;
    private PathOfText accountPath = new PathOfText();

    public BalanceEnquiryGUI(){

        //Setup frame
        balanceEnquiryGui = new SetUpFrame();
        balanceEnquiryGui.setFrame(this,"Customer Services",400,300);

        //Initialize components
        initializeComponents = new InitializeBalanceEnquiry();
        initializeComponents.addComponentsToFrame(this);
        initializeComponents.viewButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Get account ID from Customer
                String accountID = initializeComponents.getTxtAccountID().getText();
                // Clear text area
                initializeComponents.getTxtAreaTransactions().setText("");  // Clear text area


                // Validate inputs
                if (accountID.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }


                //Check if account ID exist
                if (!AccountIDExist.doesAccountIDExist(accountID, accountPath.getAccountPath())) {
                    JOptionPane.showMessageDialog(null, "Account ID not exists. Please choose another.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Read Balance from file
                try (BufferedReader reader = new BufferedReader(new FileReader(accountPath.getAccountPath()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] data = line.split("  ,  ");
                        if (data[0].equals(accountID)) {
                            initializeComponents.getTxtAreaTransactions().append("- Account Type : " + data[2] + "  \n- Balance : " + data[3] + "\n");
                        }
                    }
                } catch (IOException ioException) {
                    JOptionPane.showMessageDialog(null, "Error reading transaction data", "Error", JOptionPane.ERROR_MESSAGE);
                    ioException.printStackTrace();
                }
            }
        });

        initializeComponents.cancelButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

}
