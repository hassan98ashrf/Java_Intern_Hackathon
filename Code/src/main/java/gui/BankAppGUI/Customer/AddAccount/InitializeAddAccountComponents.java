package gui.BankAppGUI.Customer.AddAccount;

import javax.swing.*;
import java.awt.event.ActionListener;

public class InitializeAddAccountComponents {
    private JLabel lblAccountID, lblCustomerID, lblType, lblBalance, lblCreditLimitOrInterest,lblLoanDuration;
    private JTextField txtAccountID, txtCustomerID, txtBalance, txtCreditLimitOrInterest ,txtLoanDuration;
    private JComboBox<String> comboType;
    private JButton btnSubmit, btnCancel;

    public InitializeAddAccountComponents(){
        lblAccountID = new JLabel("Account ID:");
        lblAccountID.setBounds(30, 30, 100, 25);
        lblCustomerID = new JLabel("Customer ID:");
        lblCustomerID.setBounds(30, 60, 100, 25);
        lblType = new JLabel("Account Type:");
        lblType.setBounds(30, 90, 100, 25);
        lblBalance = new JLabel("Initial Balance:");
        lblBalance.setBounds(30, 120, 100, 25);
        lblCreditLimitOrInterest = new JLabel("Credit Limit/Interest Rate:");
        lblCreditLimitOrInterest.setBounds(30, 150, 180, 25);
        lblLoanDuration = new JLabel("Loan duration");
        lblLoanDuration.setBounds(30, 180, 100, 25);

        txtAccountID = new JTextField();
        txtAccountID.setBounds(180, 30, 150, 25);
        txtCustomerID = new JTextField();
        txtCustomerID.setBounds(180, 60, 150, 25);
        txtBalance = new JTextField();
        txtBalance.setBounds(180, 120, 150, 25);
        txtCreditLimitOrInterest = new JTextField();
        txtCreditLimitOrInterest.setBounds(180, 150, 150, 25);
        txtLoanDuration = new JTextField();
        txtLoanDuration.setBounds(180, 180, 150, 25);

        // Initialize combo box for account type
        String[] accountTypes = {"Checking", "Saving", "Loan"};
        comboType = new JComboBox<>(accountTypes);
        comboType.setBounds(180, 90, 150, 25);

        // Initialize buttons
        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(70, 250, 100, 30);
        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(200, 250, 100, 30);
    }
    public void addComponentsToFrame(JFrame frame) {
        frame.add(lblAccountID);
        frame.add(txtAccountID);
        frame.add(lblCustomerID);
        frame.add(txtCustomerID);
        frame.add(txtLoanDuration);
        frame.add(lblLoanDuration);
        frame.add(lblType);
        frame.add(comboType);
        frame.add(lblBalance);
        frame.add(txtBalance);
        frame.add(lblCreditLimitOrInterest);
        frame.add(txtCreditLimitOrInterest);
        frame.add(btnSubmit);
        frame.add(btnCancel);
    }

    public JComboBox<String> getComboType() {
        return comboType;
    }

    public JTextField getTxtAccountID() {
        return txtAccountID;
    }

    public JTextField getTxtCustomerID() {
        return txtCustomerID;
    }

    public JTextField getTxtBalance() {
        return txtBalance;
    }

    public JTextField getTxtLoanDuration() {
        return txtLoanDuration;
    }

    public JTextField getTxtCreditLimitOrInterest() {
        return txtCreditLimitOrInterest;
    }

    public void submitButtonActionListener(ActionListener actionListener) {
        btnSubmit.addActionListener(actionListener);
    }

    public void cancelButtonActionListener(ActionListener actionListener) {
        btnCancel.addActionListener(actionListener);
    }
}
