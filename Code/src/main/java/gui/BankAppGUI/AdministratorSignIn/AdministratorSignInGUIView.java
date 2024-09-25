package gui.BankAppGUI.AdministratorSignIn;


import gui.BankAppGUI.AdministratorSignIn.AdministratorWindow.AdministratorWindowGUIView;
import gui.Service.SetUpFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministratorSignInGUIView extends JFrame {
    private InitializeSignInComponents initializeComponents;
    private SetUpFrame AdminGUIFrame ;
    private final String userName = "Admin";
    private final String passwords = "Admin";

    public AdministratorSignInGUIView(){

        //Set up frame
        AdminGUIFrame = new SetUpFrame();
        AdminGUIFrame.setFrame(this,"Administrator sign in",400,300);

        //Initialize components
        initializeComponents = new InitializeSignInComponents();
        initializeComponents.addComponentsToFrame(this);

        initializeComponents.backButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        initializeComponents.enterButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Get data form Administrator
                String name = initializeComponents.getTxtName().getText();
                String password = initializeComponents.getTxtPassword().getText();

                //check field is empty
                if (name.isEmpty() || password.isEmpty() ) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(name.equals(userName) && password.equals(passwords))
                {
                    new AdministratorWindowGUIView().setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Wrong Information", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
