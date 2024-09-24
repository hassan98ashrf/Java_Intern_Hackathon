package gui.BankAppGUI.Customer;

import gui.BankAppGUI.Customer.AddAccount.AddAccountGUIView;

import gui.BankAppGUI.Customer.BalanceEnquiry.BalanceEnquiryGUI;
import gui.BankAppGUI.Customer.Deposit.DepositGUIView;
import gui.BankAppGUI.Customer.ViewTransactions.ViewTransactionsGUI;
import gui.BankAppGUI.Customer.Withdrew.WithdrewGUIView;
import gui.Service.SetUpFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerGUIView extends JFrame {
    private InitializeCustomerComponents initializeComponents;
    private SetUpFrame customerGui ;

    public CustomerGUIView(){
        customerGui = new SetUpFrame();
        customerGui.setFrame(this,"Customer Services",400,300);

        initializeComponents = new InitializeCustomerComponents();
        initializeComponents.addComponentsToFrame(this);
        initializeComponents.addAccountButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddAccountGUIView().setVisible(true);
            }
        });

        initializeComponents.viewTransactionsButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewTransactionsGUI().setVisible(true);

            }
        });

        initializeComponents.withdrewButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WithdrewGUIView().setVisible(true);

            }
        });

        initializeComponents.depositButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DepositGUIView().setVisible(true);
            }
        });

        initializeComponents.balanceEnquiryButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BalanceEnquiryGUI().setVisible(true);
            }
        });

    }

}
