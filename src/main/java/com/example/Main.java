package com.example;

import javax.swing.*;
import java.awt.*;

public class Main {
public static void main(String[] args) throws Exception {
        Frame mainFrame = new Frame();

        JPanel panel = new JPanel();

        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        panel.setBackground(Color.blue);

        Button button = new Button("button");
        panel.add(button);
        mainFrame.add(panel, BorderLayout.CENTER);
        
    }
}