package gui.BankAppGUI.Customer.Deposit;

import javax.swing.*;
import java.awt.event.ActionListener;

public class InitializeDepositComponents {
    private JLabel lblAccountID , lblDepositAmount,lblAccountType;
    private JTextField txtAccountID , txtDepositAmount;
    private JButton btnDeposit,btnBack;
    private JComboBox<String> comboType;

    public InitializeDepositComponents(){

        // Initialize components
        lblAccountID = new JLabel("Account ID:");
        lblAccountID.setBounds(30, 50, 100, 25);
        lblAccountType = new JLabel("Account Type:");
        lblAccountType.setBounds(30, 90, 100, 25);
        lblDepositAmount = new JLabel("Deposit Amount:");
        lblDepositAmount.setBounds(30, 130, 100, 25);

        txtAccountID = new JTextField();
        txtAccountID.setBounds(180, 50, 150, 25);

        String[] accountTypes = {"Checking", "Saving"};
        comboType = new JComboBox<>(accountTypes);
        comboType.setBounds(180, 90, 150, 25);

        txtDepositAmount = new JTextField();
        txtDepositAmount.setBounds(180, 130, 150, 25);

        btnDeposit = new JButton("Deposit");
        btnDeposit.setBounds(60, 200, 100, 30);

        btnBack = new JButton("Back");
        btnBack.setBounds(210, 200, 100, 30);
    }
    public void addDepositComponentsToFrame(JFrame frame) {
        frame.add(lblAccountID);
        frame.add(txtAccountID);
        frame.add(btnDeposit);
        frame.add(lblDepositAmount);
        frame.add(txtDepositAmount);
        frame.add(lblAccountType);
        frame.add(comboType);
        frame.add(btnBack);
    }

    public JComboBox getComboType() {
        return comboType;
    }

    public JTextField getTxtAccountID() {
        return txtAccountID;
    }

    public JTextField getTxtDepositAmountAmount() {
        return txtDepositAmount;
    }


    public void depositButtonActionListener(ActionListener actionListener) {
        btnDeposit.addActionListener(actionListener);
    }
    public void backButtonActionListener(ActionListener actionListener) {
        btnBack.addActionListener(actionListener);
    }
}
