package gui.BankAppGUI.AdministratorSignIn.AdministratorWindow.AddCustomer;

import javax.swing.*;
import java.awt.event.ActionListener;

public class InitializeAddCustomerComponents extends JFrame {
    private JLabel lblCustomerID, lblName, lblAddress, lblPhone, lblEmail;
    private JTextField txtCustomerID, txtName, txtAddress, txtPhone, txtEmail;
    private JButton btnSubmit, btnCancel;


    public InitializeAddCustomerComponents(){
        lblCustomerID = new JLabel("Customer ID:");
        lblCustomerID.setBounds(30, 30, 100, 25);
        lblName = new JLabel("Name:");
        lblName.setBounds(30, 60, 100, 25);
        lblAddress = new JLabel("Address:");
        lblAddress.setBounds(30, 90, 100, 25);
        lblPhone = new JLabel("Phone:");
        lblPhone.setBounds(30, 120, 100, 25);
        lblEmail = new JLabel("Email:");
        lblEmail.setBounds(30, 150, 100, 25);

        txtCustomerID = new JTextField();
        txtCustomerID.setBounds(180, 30, 150, 25);
        txtName = new JTextField();
        txtName.setBounds(180, 60, 150, 25);
        txtAddress = new JTextField();
        txtAddress.setBounds(180, 90, 150, 25);
        txtPhone = new JTextField();
        txtPhone.setBounds(180, 120, 150, 25);
        txtEmail = new JTextField();
        txtEmail.setBounds(180, 150, 150, 25);

        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(70, 200, 100, 30);
        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(200, 200, 100, 30);
    }
    public void addComponentsToFrame(JFrame frame) {
        frame.add(lblCustomerID);
        frame.add(txtCustomerID);
        frame.add(lblName);
        frame.add(txtName);
        frame.add(lblAddress);
        frame.add(txtAddress);
        frame.add(lblPhone);
        frame.add(txtPhone);
        frame.add(lblEmail);
        frame.add(txtEmail);
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

    public JTextField getTxtName() {
        return txtName;
    }

    public JTextField getTxtAddress() {
        return txtAddress;
    }

    public JTextField getTxtPhone() {
        return txtPhone;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }
}
