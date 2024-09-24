package gui.BankAppGUI.AdministratorSignIn.AdministratorWindow;


import gui.BankAppGUI.AdministratorSignIn.AdministratorWindow.AddCustomer.AddCustomerGUIView;
import gui.BankAppGUI.AdministratorSignIn.AdministratorWindow.AdminDeleteCustomer.DeleteCustomerGUIView;
import gui.BankAppGUI.AdministratorSignIn.AdministratorWindow.AdminEditCustomer.EditCustomerGUIView;
import gui.BankAppGUI.AdministratorSignIn.AdministratorWindow.AdminReport.AdminViewGUI;
import gui.Service.SetUpFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministratorWindowGUIView extends JFrame{
    private InitializeAdminWindowComponents initializeComponents;
    private SetUpFrame AdminWindowGUIFrame ;
    public AdministratorWindowGUIView(){

        //Set up frame
        AdminWindowGUIFrame = new SetUpFrame();
        AdminWindowGUIFrame.setFrame(this,"Administrator",400,300);

        //Initialize components
        initializeComponents = new InitializeAdminWindowComponents();
        initializeComponents.addComponentsToFrame(this);

        initializeComponents.addCustomerButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddCustomerGUIView().setVisible(true);
            }
        });

        initializeComponents.editCustomerButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditCustomerGUIView().setVisible(true);
            }
        });

        initializeComponents.deleteCustomerButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteCustomerGUIView().setVisible(true);
            }
        });

        initializeComponents.adminReportButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminViewGUI().setVisible(true);
            }
        });

    }

}
