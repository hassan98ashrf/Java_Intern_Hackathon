package gui.BankAppGUI.AdministratorSignIn.AdministratorWindow.AdminReport;

import gui.Service.PathOfText;
import gui.Service.SetUpFrame;

import javax.swing.*;
import java.awt.event.ActionListener;

public class InitializeAdminReport extends JFrame {
    private JTextArea txtAreaCustomerBalances;
    private JButton btnView, btnCancel;

    public InitializeAdminReport(){
        txtAreaCustomerBalances = new JTextArea();
        txtAreaCustomerBalances.setBounds(30, 30, 420, 250);
        btnView = new JButton("View");
        btnView.setBounds(110, 300, 100, 30);
        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(260, 300, 100, 30);
    }

    public void adminViewComponentsToFrame(JFrame frame) {
        frame.add(btnView);
        frame.add(btnCancel);
        frame.add(txtAreaCustomerBalances);
    }

    public JTextArea getTxtAreaCustomerBalances() {
        return txtAreaCustomerBalances;
    }


    public void viewButtonActionListener(ActionListener actionListener) {
        btnView.addActionListener(actionListener);
    }

    public void cancelButtonActionListener(ActionListener actionListener) {
        btnCancel.addActionListener(actionListener);
    }

}
