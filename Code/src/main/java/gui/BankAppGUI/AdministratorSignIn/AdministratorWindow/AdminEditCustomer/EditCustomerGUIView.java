package gui.BankAppGUI.AdministratorSignIn.AdministratorWindow.AdminEditCustomer;

import gui.BankAppGUI.AdministratorSignIn.AdministratorWindow.AddCustomer.InitializeAddCustomerComponents;
import gui.Service.SetUpFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class EditCustomerGUIView extends JFrame {
    private InitializeAddCustomerComponents initializeEditComponents;
    private SetUpFrame editCustomerGUIFrame ;   //its have same gui frame of add customer
    private EditCustomer editCustomer;

    public EditCustomerGUIView() {

        //Setup Frame
        editCustomerGUIFrame  = new SetUpFrame();
        editCustomerGUIFrame.setFrame(this,"Edit Customer",400,300);

        //Initialize Components
        initializeEditComponents = new InitializeAddCustomerComponents();
        initializeEditComponents.addComponentsToFrame(this);

        initializeEditComponents.submitButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get data from administrator
                String customerID = initializeEditComponents.getTxtCustomerID().getText();
                String name = initializeEditComponents.getTxtName().getText();
                String address = initializeEditComponents.getTxtAddress().getText();
                String phone = initializeEditComponents.getTxtPhone().getText();
                String email = initializeEditComponents.getTxtEmail().getText();

                //Check of fields empty
                if (customerID.isEmpty() || name.isEmpty() || address.isEmpty() || phone.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    if(EditCustomer.editCustomer(customerID, name, address, phone, email)){
                        JOptionPane.showMessageDialog(null, "Customer updated successfully");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Customer not found", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    //Empty the fields
                    initializeEditComponents.getTxtCustomerID().setText("");
                    initializeEditComponents.getTxtName().setText("");
                    initializeEditComponents.getTxtAddress().setText("");
                    initializeEditComponents.getTxtPhone().setText("");
                    initializeEditComponents.getTxtEmail().setText("");

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        initializeEditComponents.cancelButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

}
