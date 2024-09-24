package gui.BankAppGUI.Customer;

import javax.swing.*;
import java.awt.event.ActionListener;

public class InitializeCustomerComponents {
    private JButton btnAddAccount,btnViewTransactions,btnDeposit,btnWithdrew,btnBalanceEnquiry;
    public InitializeCustomerComponents(){
        btnAddAccount = new JButton("Add Account");
        btnAddAccount.setBounds(115, 40, 150, 30);
        btnViewTransactions = new JButton("View Transactions");
        btnViewTransactions.setBounds(115, 80, 150, 30);
        btnDeposit = new JButton("Deposit");
        btnDeposit.setBounds(115, 120, 150, 30);
        btnWithdrew = new JButton("Withdrew");
        btnWithdrew.setBounds(115, 160, 150, 30);
        btnBalanceEnquiry = new JButton("Balance Enquiry");
        btnBalanceEnquiry.setBounds(115, 200, 150, 30);

    }
    public void addComponentsToFrame(JFrame frame) {
        frame.add(btnAddAccount);
        frame.add(btnViewTransactions);
        frame.add(btnDeposit);
        frame.add(btnWithdrew);
        frame.add(btnBalanceEnquiry);
    }

    public void addAccountButtonActionListener(ActionListener actionListener) {
        btnAddAccount.addActionListener(actionListener);
    }

    public void depositButtonActionListener(ActionListener actionListener) {
        btnDeposit.addActionListener(actionListener);
    }

    public void withdrewButtonActionListener(ActionListener actionListener) {
        btnWithdrew.addActionListener(actionListener);
    }


    public void viewTransactionsButtonActionListener(ActionListener actionListener) {
        btnViewTransactions.addActionListener(actionListener);
    }

    public void balanceEnquiryButtonActionListener(ActionListener actionListener) {
        btnBalanceEnquiry.addActionListener(actionListener);
    }

}
