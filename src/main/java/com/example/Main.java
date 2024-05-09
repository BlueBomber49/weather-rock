package com.example;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
public static void main(String[] args) throws Exception {
        Frame mainFrame = new Frame();

        JPanel panel = new JPanel();

        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        panel.setBackground(Color.blue);

        LocalTime currentTime = LocalTime.now();
        String cur_time = currentTime.toString();
        //String formattedTime = currentTime.format(formatter);
        System.out.println(cur_time);


         //additions for text input
        JLabel label1 = new JLabel("When's you next class? (Input as hh:mm am/pm)");
        label1.setForeground (Color.red);
        panel.add(label1);
        JTextField textField = new JTextField(20);
        panel.add(textField);
        JButton button = new JButton("Submit");
        button.addActionListener(e -> {
            String userInput = textField.getText();
            String regex = "(1[0-2]|0?[1-9]):([0-5][0-9])\\s(AM|PM)";

            boolean matches = userInput.matches(regex);

            if (matches) {
                System.out.println("Input matches the regex pattern.");
                int class_hour = 0;

                if (userInput.contains("PM") && !userInput.substring(0, 2).equals("12")) {
                    int old_class_hour = Integer.parseInt(userInput.substring(0, 2));
                    class_hour = 12 + old_class_hour;
                } else {
                    class_hour = Integer.parseInt(userInput.substring(0, 2));
                }
                System.out.println(class_hour);
                int cur_hour = Integer.parseInt(cur_time.substring(0, 2));
                int hours_till_class = class_hour - cur_hour;
                System.out.println(hours_till_class);

                Long temperature = APICaller.main_api(hours_till_class);
                System.out.println(temperature);

                
                JOptionPane.showMessageDialog(mainFrame, "At " + userInput + " it will be " + temperature.toString() + " Degrees Fahrenheit");
            } else {
                System.out.println("Input does not match the regex pattern.");
                JOptionPane.showMessageDialog(mainFrame, "Your input '" + userInput + "' was not a valid time. Please enter a time with the format 'HH:MM AM|PM'");
            }

            
            //JOptionPane.showMessageDialog(mainFrame, "User Input: " + userInput);


        });
        panel.add(button);

        //end

        mainFrame.add(panel, BorderLayout.NORTH);
        panel.setVisible(true);
        mainFrame.setVisible(true);



        
    }
}
