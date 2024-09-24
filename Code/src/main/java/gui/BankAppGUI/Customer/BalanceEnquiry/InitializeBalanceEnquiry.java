package gui.BankAppGUI.Customer.BalanceEnquiry;

import javax.swing.*;
import java.awt.event.ActionListener;

public class InitializeBalanceEnquiry {
    private JLabel lblAccountID;
    private JTextField txtAccountID;
    private JTextArea txtAreaTransactions;
    private JButton btnView, btnCancel;

    public InitializeBalanceEnquiry(){
        // Initialize components
        lblAccountID = new JLabel("Account ID:");
        lblAccountID.setBounds(30, 50, 100, 25);
        txtAccountID = new JTextField();
        txtAccountID.setBounds(150, 50, 150, 25);
        txtAreaTransactions = new JTextArea();
        txtAreaTransactions.setBounds(30, 85, 330, 50);
        btnView = new JButton("View");
        btnView.setBounds(70, 210, 100, 30);
        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(220, 210, 100, 30);
    }
    public void addComponentsToFrame(JFrame frame) {
        frame.add(lblAccountID);
        frame.add(txtAccountID);
        frame.add(txtAreaTransactions);
        frame.add(btnView);
        frame.add(btnCancel);
    }

    public JTextField getTxtAccountID() {
        return txtAccountID;
    }

    public JTextArea getTxtAreaTransactions() {
        return txtAreaTransactions;
    }

    public void viewButtonActionListener(ActionListener actionListener) {
        btnView.addActionListener(actionListener);
    }

    public void cancelButtonActionListener(ActionListener actionListener) {
        btnCancel.addActionListener(actionListener);
    }


}
