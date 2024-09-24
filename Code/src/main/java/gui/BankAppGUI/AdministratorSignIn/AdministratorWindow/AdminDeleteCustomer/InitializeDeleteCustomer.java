package gui.BankAppGUI.AdministratorSignIn.AdministratorWindow.AdminDeleteCustomer;


import javax.swing.*;
import java.awt.event.ActionListener;


public class InitializeDeleteCustomer {
    private JLabel lblCustomerID;
    private JTextField txtCustomerID;
    private JButton btnSubmit, btnCancel;

    public InitializeDeleteCustomer(){
        lblCustomerID = new JLabel("Customer ID:");
        lblCustomerID.setBounds(30, 80, 100, 25);
        txtCustomerID = new JTextField();
        txtCustomerID.setBounds(180, 80, 150, 25);
        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(70, 200, 100, 30);
        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(200, 200, 100, 30);
    }
    public void addDeleteComponentsToFrame(JFrame frame) {
        frame.add(lblCustomerID);
        frame.add(txtCustomerID);
        frame.add(btnSubmit);
        frame.add(btnCancel);
    }
    public void submitButtonActionListener(ActionListener actionListener) {
        btnSubmit.addActionListener(actionListener);
    }

    public void cancelButtonActionListener(ActionListener actionListener) {
        btnCancel.addActionListener(actionListener);
    }

    public JTextField getTxtCustomerID() {
        return txtCustomerID;
    }

}
