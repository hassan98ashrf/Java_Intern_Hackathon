package gui.BankAppGUI.Customer.Deposit;

import gui.Service.*;
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
import gui.Service.CheckAccountDepositOrWithdrew;

public class DepositGUIView extends JFrame {
    private InitializeDepositComponents initializeDepositComponents;
    private SetUpFrame depositGUIFrame;
    private PathOfText pathOfText = new PathOfText();
    private Account account;

    public DepositGUIView() {
        depositGUIFrame = new SetUpFrame();
        depositGUIFrame.setFrame(this, "Deposit", 400, 300);

        initializeDepositComponents = new InitializeDepositComponents();
        initializeDepositComponents.addDepositComponentsToFrame(this);



        initializeDepositComponents.depositButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //get data from administrator
                String accountID = initializeDepositComponents.getTxtAccountID().getText();
                String depositAmount = initializeDepositComponents.getTxtDepositAmountAmount().getText();
                String accountType = (String) initializeDepositComponents.getComboType().getSelectedItem();

                // Check valid
                if (accountID.isEmpty() || depositAmount.isEmpty() || accountType.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Check if account ID already exists and has the same type
                if (!CheckAccountDepositOrWithdrew.doesAccountIDExist(accountID,accountType)) {
                    JOptionPane.showMessageDialog(null, "Account ID not exists. Please choose another.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String accountInfo = null;
                account = new Account(accountID,accountType);
                accountInfo = account.deposit(Double.parseDouble(depositAmount));

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathOfText.getAccountTransactionPath(), true))) {

                    //Write in transaction
                    writer.write(accountInfo);
                    writer.newLine();

                    //update Accounts.txt
                    if(UpdateAccount.editDeposit(accountID,depositAmount))
                        JOptionPane.showMessageDialog(null, "Account updated successfully");
                    else{
                        JOptionPane.showMessageDialog(null, "Error saving account data", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    initializeDepositComponents.getTxtAccountID().setText("");
                    initializeDepositComponents.getTxtDepositAmountAmount().setText("");


                } catch (IOException ioException) {
                    JOptionPane.showMessageDialog(null, "Error saving account data", "Error", JOptionPane.ERROR_MESSAGE);
                    ioException.printStackTrace();
                }

            }
        });


        initializeDepositComponents.backButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }


}
