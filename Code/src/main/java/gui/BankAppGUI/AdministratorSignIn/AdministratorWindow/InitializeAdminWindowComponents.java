package gui.BankAppGUI.AdministratorSignIn.AdministratorWindow;

import javax.swing.*;
import java.awt.event.ActionListener;

public class InitializeAdminWindowComponents {
    private JButton btnAddCustomer,btnEditCustomer,btnDeleteCustomer,btnAdminReport;

    public InitializeAdminWindowComponents(){

        btnAddCustomer = new JButton("Add Customer");
        btnAddCustomer.setBounds(110, 35, 150, 30);
        btnEditCustomer = new JButton("Edit Customer");
        btnEditCustomer.setBounds(110, 85 , 150 ,30);
        btnDeleteCustomer = new JButton("Delete Customer");
        btnDeleteCustomer.setBounds(110, 135 , 150 ,30);
        btnAdminReport = new JButton("Admin Report");
        btnAdminReport.setBounds(110, 185 , 150 ,30);

    }
    public void addComponentsToFrame(JFrame frame) {
        frame.add(btnAddCustomer);
        frame.add(btnEditCustomer);
        frame.add(btnDeleteCustomer);
        frame.add(btnAdminReport);
    }

    public void addCustomerButtonActionListener(ActionListener actionListener) {
        btnAddCustomer.addActionListener(actionListener);
    }

    public void editCustomerButtonActionListener(ActionListener actionListener) {
        btnEditCustomer.addActionListener(actionListener);
    }

    public void deleteCustomerButtonActionListener(ActionListener actionListener) {
        btnDeleteCustomer.addActionListener(actionListener);
    }

    public void adminReportButtonActionListener(ActionListener actionListener) {
        btnAdminReport.addActionListener(actionListener);
    }


}
