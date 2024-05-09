package com.example;

import javax.swing.*;
import java.awt.*;

public class Main {
public static void main(String[] args) throws Exception {
        Frame mainFrame = new Frame();

        JPanel panel = new JPanel();

        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        panel.setBackground(Color.blue);


        //additions for text input
        JTextField textField = new JTextField(20);
        panel.add(textField);
        JButton button = new JButton("Submit");
        button.addActionListener(e -> {
            String userInput = textField.getText();
            JOptionPane.showMessageDialog(mainFrame, "User Input: " + userInput);

            
        });
        panel.add(button);
        //end

        mainFrame.add(panel, BorderLayout.CENTER);


        Long temperature = APICaller.main_api(0);
        System.out.println(temperature);
    }
}