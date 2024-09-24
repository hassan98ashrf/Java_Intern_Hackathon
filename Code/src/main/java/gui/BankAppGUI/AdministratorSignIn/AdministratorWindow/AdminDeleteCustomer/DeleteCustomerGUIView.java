package gui.BankAppGUI.AdministratorSignIn.AdministratorWindow.AdminDeleteCustomer;

import gui.Service.SetUpFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DeleteCustomerGUIView extends JFrame {
    private InitializeDeleteCustomer initializeComponents;
    private SetUpFrame deleteCustomerGUIFrame;
    private DeleteCustomer deleteCustomer = new DeleteCustomer();
    private DeleteAccount deleteAccount = new DeleteAccount();

    public DeleteCustomerGUIView() {

        //Setup Frame
        deleteCustomerGUIFrame = new SetUpFrame();
        deleteCustomerGUIFrame.setFrame(this, "Delete Customer", 400, 300);

        //Initialize components
        initializeComponents = new InitializeDeleteCustomer();
        initializeComponents.addDeleteComponentsToFrame(this);

        initializeComponents.submitButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get customerID fromm administrator
                String customerID = initializeComponents.getTxtCustomerID().getText();

                //Check if fields empty
                if (customerID.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    if (deleteCustomer.deleteCustomer(customerID) && deleteAccount.deleteAccounts(customerID)) {
                        JOptionPane.showMessageDialog(null, "Customer deleted successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "Customer not found", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    //Empty the fields
                    initializeComponents.getTxtCustomerID().setText("");

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        initializeComponents.cancelButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}