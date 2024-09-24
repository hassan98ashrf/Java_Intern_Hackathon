package gui.BankAppGUI.Customer.AddAccount;

import gui.Service.AccountIDExist;
import gui.Service.CheckCustomerID;
import gui.Service.PathOfText;
import gui.Service.SetUpFrame;
import model.Account;
import model.CheckingAccount;
import model.Loan;
import model.SavingAccount;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class AddAccountGUIView extends JFrame {
    private InitializeAddAccountComponents initializeComponents;
    private SetUpFrame customerGui ;
    private CheckingAccount checkingAccount;
    private SavingAccount savingAccount;
    private Loan loan;
    private PathOfText accountPath = new PathOfText();

    public AddAccountGUIView(){

        //Setup frame
        customerGui = new SetUpFrame();
        customerGui.setFrame(this,"Customer Services",400,400);

        //Initialize components
        initializeComponents = new InitializeAddAccountComponents();
        initializeComponents.addComponentsToFrame(this);

        initializeComponents.submitButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Get data from Customer
                String accountID = initializeComponents.getTxtAccountID().getText();
                String customerID = initializeComponents.getTxtCustomerID().getText();
                String loanDuration = initializeComponents.getTxtLoanDuration().getText();
                String accountType = (String) initializeComponents.getComboType().getSelectedItem();
                String balance = initializeComponents.getTxtBalance().getText();
                String creditLimitOrInterest = initializeComponents.getTxtCreditLimitOrInterest().getText();

                // Validate inputs
                if (accountID.isEmpty() || customerID.isEmpty() || balance.isEmpty()|| creditLimitOrInterest.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Check if account ID already exists
                if (AccountIDExist.doesAccountIDExist(accountID,accountPath.getAccountPath())) {
                    JOptionPane.showMessageDialog(null, "Account ID already exists. Please choose another.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Check if Customer ID already exists
                if(!CheckCustomerID.isCustomerIDExists(customerID)){
                    JOptionPane.showMessageDialog(null, "Customer ID not exists. Please choose another.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String accountInfo = null;
                switch (accountType){
                    case "Checking":
                        checkingAccount = new CheckingAccount(customerID,accountID,accountType,Double.parseDouble(balance),Double.parseDouble(creditLimitOrInterest));
                        accountInfo = checkingAccount.getCheckingDetails();
                        break;
                    case "Saving":
                        savingAccount = new SavingAccount(customerID,accountID,accountType,Double.parseDouble(balance),Double.parseDouble(creditLimitOrInterest));
                        accountInfo = savingAccount.getSavingDetails();
                        break;
                    case "Loan":
                        loan = new Loan(customerID,accountID,accountType,Double.parseDouble(balance),Double.parseDouble(creditLimitOrInterest),Double.parseDouble(loanDuration));
                        accountInfo = loan.getLoanDetails();
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + accountType);
                }

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(accountPath.getAccountPath(), true))) {
                    writer.write(accountInfo);
                    writer.newLine();
                    JOptionPane.showMessageDialog(null, "Account added successfully!");
                    initializeComponents.getTxtAccountID().setText("");
                    initializeComponents.getTxtCustomerID().setText("");
                    initializeComponents.getTxtBalance().setText("");
                    initializeComponents.getTxtCreditLimitOrInterest().setText("");
                    initializeComponents.getTxtLoanDuration().setText("");

                } catch (IOException ioException) {
                    JOptionPane.showMessageDialog(null, "Error saving account data", "Error", JOptionPane.ERROR_MESSAGE);
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


