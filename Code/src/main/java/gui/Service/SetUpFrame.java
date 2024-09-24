package gui.Service;

import javax.swing.*;

public class SetUpFrame {

    public void setFrame(JFrame frame,String title, int width , int height){
        frame.setTitle(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
    }

}
