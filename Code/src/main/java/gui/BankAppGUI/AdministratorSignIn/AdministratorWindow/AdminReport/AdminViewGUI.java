package gui.BankAppGUI.AdministratorSignIn.AdministratorWindow.AdminReport;

import gui.BankAppGUI.AdministratorSignIn.AdministratorWindow.AdminDeleteCustomer.DeleteCustomer;
import gui.BankAppGUI.AdministratorSignIn.AdministratorWindow.AdminDeleteCustomer.InitializeDeleteCustomer;
import gui.Service.PathOfText;
import gui.Service.SetUpFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AdminViewGUI extends JFrame{
    private InitializeAdminReport initializeComponents;
    private SetUpFrame adminReportGUIFrame;
    private PathOfText pathOfAccounts =new PathOfText();


    public AdminViewGUI()  {

        adminReportGUIFrame = new SetUpFrame();
        adminReportGUIFrame.setFrame(this, "Admin Report", 500, 400);

        //Initialize components
        initializeComponents = new InitializeAdminReport();
        initializeComponents.adminViewComponentsToFrame(this);

        initializeComponents.viewButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeComponents.getTxtAreaCustomerBalances().setText("");  // Clear text area

                try (BufferedReader reader = new BufferedReader(new FileReader(pathOfAccounts.getAccountPath()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] data = line.split("  ,  ");
                        initializeComponents.getTxtAreaCustomerBalances().append(data[0] + "  -  " + data[1] + "  -  " + data[2] + "  -  " + data[3] + "  -  " + data[4] + "\n");
                    }

                } catch (IOException ioException) {
                    JOptionPane.showMessageDialog(null, "Error reading account data", "Error", JOptionPane.ERROR_MESSAGE);
                    ioException.printStackTrace();
                }
            }
        });

        initializeComponents.cancelButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();  // Close the window
            }
        });
    }

}


