package gui.BankAppGUI.AdministratorSignIn;

import javax.swing.*;
import java.awt.event.ActionListener;

public class InitializeSignInComponents {
    private JButton btnEnter,btnBack;
    private JLabel lblName,lblPassword;
    private JTextField txtName,txtPassword;
    public InitializeSignInComponents(){
        lblName = new JLabel("Name");
        lblName.setBounds(50,50,80 , 20);

        lblPassword = new JLabel("Password");
        lblPassword.setBounds(50,100,80 , 20);

        txtName = new JTextField();
        txtName.setBounds(150,50,150,20);

        txtPassword = new JTextField();
        txtPassword.setBounds(150,100,150,20);


        btnEnter = new JButton("Enter");
        btnEnter.setBounds(80, 180, 100, 30);
        btnBack = new JButton("Back");
        btnBack.setBounds(200, 180 , 100 ,30);

    }
    public void addComponentsToFrame(JFrame frame) {
        frame.add(lblName);
        frame.add(lblPassword);
        frame.add(txtName);
        frame.add(txtPassword);
        frame.add(btnEnter);
        frame.add(btnBack);
    }

    public JTextField getTxtPassword() {
        return txtPassword;
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public void backButtonActionListener(ActionListener actionListener) {
        btnBack.addActionListener(actionListener);
    }

    public void enterButtonActionListener(ActionListener actionListener) {
        btnEnter.addActionListener(actionListener);
    }

}
