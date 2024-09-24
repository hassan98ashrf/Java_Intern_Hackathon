package gui.BankAppGUI.Customer.Withdrew;

import gui.BankAppGUI.Customer.Deposit.InitializeDepositComponents;
import gui.Service.*;
import model.Account;
import model.CheckingAccount;
import model.SavingAccount;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class WithdrewGUIView extends JFrame {
    private InitializeWithdrewComponents initializeWithdrewComponents;
    private SetUpFrame withdrewGUIFrame;
    private PathOfText pathOfText = new PathOfText();
    private CheckingAccount checkingAccount;
    private SavingAccount savingAccount;
        public WithdrewGUIView(){

            //Setup frame
            withdrewGUIFrame  = new SetUpFrame();
            withdrewGUIFrame.setFrame(this,"Withdrew",400,300);

            //Initialize components
            initializeWithdrewComponents = new InitializeWithdrewComponents();
            initializeWithdrewComponents.addWithdrewComponentsToFrame(this);



            initializeWithdrewComponents.withdrewButtonActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //get data from administrator
                    String accountID = initializeWithdrewComponents.getTxtAccountID().getText();
                    String withdrewAmount = initializeWithdrewComponents.getTxtWithdrewAmount().getText();
                    String accountType = (String) initializeWithdrewComponents.getComboType().getSelectedItem();

                    initializeWithdrewComponents.getTxtAccountID().setText("");
                    initializeWithdrewComponents.getTxtWithdrewAmount().setText("");

                    // Check valid
                    if (accountID.isEmpty() || withdrewAmount.isEmpty() || accountType.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Check if account ID already exists and has the same type
                    if (!CheckAccountDepositOrWithdrew.doesAccountIDExist(accountID,accountType)) {
                        JOptionPane.showMessageDialog(null, "Account ID not exists. Please choose another.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String accountInfo = null;
                    double limit = 0;
                    double balance=0;
                    switch (accountType){
                        case "Checking":
                            checkingAccount = new CheckingAccount(accountID,accountType);
                            try {
                                limit = UpdateAccount.withdrewLimit(accountID);
                                balance = UpdateAccount.withdrewBalance(accountID);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                            if(checkingAccount.withdraw(Double.parseDouble(withdrewAmount),limit,balance)){
                                accountInfo = accountID + "  ,  " + CreateTime.getTime()+ "  ,  "+ accountType + "  ,  " + withdrewAmount ;
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "It is bigger than your limit", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            break;

                        case "Saving":
                            savingAccount = new SavingAccount(accountID,accountType);
                            try {
                                balance = UpdateAccount.withdrewBalance(accountID);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                            if(savingAccount.withdraw(Double.parseDouble(withdrewAmount),0,balance)){
                                accountInfo = accountID + "  ,  " + CreateTime.getTime()+ "  ,  "+ accountType + "  ,  " + withdrewAmount ;
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "It is bigger than your limit", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                            break;
                    }

                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathOfText.getAccountTransactionPath(), true))) {

                        //Write in transaction
                        writer.write(accountInfo);
                        writer.newLine();

                        //update Accounts.txt
                        if(UpdateAccount.editWithdrew(accountID,withdrewAmount))
                            JOptionPane.showMessageDialog(null, "Account updated successfully");
                        else{
                            JOptionPane.showMessageDialog(null, "Error saving account data", "Error", JOptionPane.ERROR_MESSAGE);
                        }



                    } catch (IOException ioException) {
                        JOptionPane.showMessageDialog(null, "Error saving account data", "Error", JOptionPane.ERROR_MESSAGE);
                        ioException.printStackTrace();
                    }

                }
            });

            initializeWithdrewComponents.backButtonActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
        }

}
