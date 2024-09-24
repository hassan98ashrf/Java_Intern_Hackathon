package gui.BankAppGUI;

import javax.swing.*;
import java.awt.event.ActionListener;

public class InitializeBankComponents {

    private JButton btnAdministrator,btnCustomer;

    public InitializeBankComponents(){
        btnAdministrator = new JButton("Administrator");
        btnAdministrator.setBounds(115, 80, 150, 30);
        btnCustomer = new JButton("Customer");
        btnCustomer.setBounds(115, 150, 150, 30);
    }
    public void addComponentsToFrame(JFrame frame) {
        frame.add(btnAdministrator);
        frame.add(btnCustomer);
    }

    public void addAdministratorButtonActionListener(ActionListener actionListener) {
        btnAdministrator.addActionListener(actionListener);
    }

    public void addCustomerButtonActionListener(ActionListener actionListener) {
        btnCustomer.addActionListener(actionListener);
    }

}
