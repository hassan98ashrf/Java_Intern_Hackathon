package gui.BankAppGUI.Customer.ViewTransactions;

import gui.Service.AccountIDExist;

import javax.swing.*;
import java.awt.event.ActionListener;

public class InitializeViewTransaction extends JFrame {
    private JLabel lblAccountID;
    private JTextField txtAccountID;
    private JTextArea txtAreaTransactions;
    private JButton btnView, btnCancel;

    public InitializeViewTransaction(){
        lblAccountID = new JLabel("Account ID:");
        lblAccountID.setBounds(30, 20, 100, 25);
        txtAccountID = new JTextField();
        txtAccountID.setBounds(150, 20, 150, 25);
        txtAreaTransactions = new JTextArea();
        txtAreaTransactions.setBounds(30, 70, 400, 230);

        btnView = new JButton("View");
        btnView.setBounds(130, 310, 100, 30);
        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(260, 310, 100, 30);

    }
    public void addComponentsToFrame(JFrame frame) {
        frame.add(lblAccountID);
        frame.add(txtAccountID);
        frame.add(txtAreaTransactions);
        frame.add(btnView);
        frame.add(btnCancel);
    }

    public JTextArea getTxtAreaTransactions() {
        return txtAreaTransactions;
    }

    public JTextField getTxtAccountID() {
        return txtAccountID;
    }

    public void viewButtonActionListener(ActionListener actionListener) {
        btnView.addActionListener(actionListener);
    }

    public void cancelButtonActionListener(ActionListener actionListener) {
        btnCancel.addActionListener(actionListener);
    }
}
