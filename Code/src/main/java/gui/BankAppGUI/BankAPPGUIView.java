package gui.BankAppGUI;


import gui.BankAppGUI.AdministratorSignIn.AdministratorSignInGUIView;
import gui.BankAppGUI.Customer.CustomerGUIView;
import gui.Service.SetUpFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankAPPGUIView extends JFrame {
    private InitializeBankComponents initializeComponents;
    private SetUpFrame bankGUIFrame ;
    public BankAPPGUIView(){

        //Set up frame
        bankGUIFrame = new SetUpFrame();
        bankGUIFrame.setFrame(this,"Bank Management System",400,300);

        //Initialize components
        initializeComponents = new InitializeBankComponents();
        initializeComponents.addComponentsToFrame(this);

        initializeComponents.addAdministratorButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdministratorSignInGUIView().setVisible(true);
            }
        });

        initializeComponents.addCustomerButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CustomerGUIView().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new BankAPPGUIView().setVisible(true);
    }

}
