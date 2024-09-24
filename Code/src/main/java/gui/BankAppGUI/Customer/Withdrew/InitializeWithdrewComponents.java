package gui.BankAppGUI.Customer.Withdrew;

import javax.swing.*;
import java.awt.event.ActionListener;

public class InitializeWithdrewComponents {
    private JLabel lblAccountID , lblWithdrewAmount,lblAccountType;
    private JTextField txtAccountID , txtWithdrewAmount;
    private JButton btnWithdrew,btnBack;
    private JComboBox<String> comboType;

    public InitializeWithdrewComponents(){

        // Initialize components
        lblAccountID = new JLabel("Account ID:");
        lblAccountID.setBounds(30, 50, 100, 25);
        lblAccountType = new JLabel("Account Type:");
        lblAccountType.setBounds(30, 90, 100, 25);
        lblWithdrewAmount = new JLabel("Withdrew Amount:");
        lblWithdrewAmount.setBounds(30, 130, 100, 25);

        txtAccountID = new JTextField();
        txtAccountID.setBounds(180, 50, 150, 25);

        String[] accountTypes = {"Checking", "Saving"};
        comboType = new JComboBox<>(accountTypes);
        comboType.setBounds(180, 90, 150, 25);

        txtWithdrewAmount = new JTextField();
        txtWithdrewAmount.setBounds(180, 130, 150, 25);

        btnWithdrew = new JButton("Withdrew");
        btnWithdrew.setBounds(60, 200, 100, 30);

        btnBack = new JButton("Back");
        btnBack.setBounds(210, 200, 100, 30);
    }
    public void addWithdrewComponentsToFrame(JFrame frame) {
        frame.add(lblAccountID);
        frame.add(txtAccountID);
        frame.add(btnWithdrew);
        frame.add(lblWithdrewAmount);
        frame.add(txtWithdrewAmount);
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

    public JTextField getTxtWithdrewAmount() {
        return txtWithdrewAmount;
    }


    public void withdrewButtonActionListener(ActionListener actionListener) {
        btnWithdrew.addActionListener(actionListener);
    }
    public void backButtonActionListener(ActionListener actionListener) {
        btnBack.addActionListener(actionListener);
    }


}
