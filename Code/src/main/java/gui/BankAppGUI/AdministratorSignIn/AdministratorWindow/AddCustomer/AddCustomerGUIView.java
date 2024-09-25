package gui.BankAppGUI.AdministratorSignIn.AdministratorWindow.AddCustomer;

import gui.Service.CheckCustomerID;
import gui.Service.PathOfText;
import gui.Service.SetUpFrame;
import model.Customer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class AddCustomerGUIView extends JFrame {
    private InitializeAddCustomerComponents initializeComponents;
    private SetUpFrame addCustomerGUIFrame ;
    private Customer customer;
    private PathOfText customerPath = new PathOfText();
    public AddCustomerGUIView() {

        //Set up frame
        addCustomerGUIFrame  = new SetUpFrame();
        addCustomerGUIFrame.setFrame(this,"Add Customer",400,300);

        //initialize components
        initializeComponents = new InitializeAddCustomerComponents();
        initializeComponents.addComponentsToFrame(this);

        initializeComponents.submitButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get data fromm administrator
                String customerID = initializeComponents.getTxtCustomerID().getText();
                String name = initializeComponents.getTxtName().getText();
                String address = initializeComponents.getTxtAddress().getText();
                String phone = initializeComponents.getTxtPhone().getText();
                String email = initializeComponents.getTxtEmail().getText();


                //Check all fields fill
                if (customerID.isEmpty() || name.isEmpty() || address.isEmpty() || phone.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                //Check Customer ID is not exist
                if (CheckCustomerID.isCustomerIDExists(customerID)) {
                    JOptionPane.showMessageDialog(null, "Customer ID already exists", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                //Set data of customer
                customer = new Customer(customerID,name,address,phone,email);
                String customerInfo = customer.getCustomerDetails();

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(customerPath.getCustomerPath(), true))) {
                   //Adding data
                    writer.write(customerInfo);
                    writer.newLine();
                    JOptionPane.showMessageDialog(null, "Customer added successfully!");

                    //Empty the fields
                    initializeComponents.getTxtCustomerID().setText("");
                    initializeComponents.getTxtName().setText("");
                    initializeComponents.getTxtAddress().setText("");
                    initializeComponents.getTxtPhone().setText("");
                    initializeComponents.getTxtEmail().setText("");

                } catch (IOException ioException) {
                    JOptionPane.showMessageDialog(null, "Error saving customer data", "Error", JOptionPane.ERROR_MESSAGE);
                    ioException.printStackTrace();
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
