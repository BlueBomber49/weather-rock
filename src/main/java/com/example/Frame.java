package com.example;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Frame extends JFrame{

    public Frame(){

        this.setTitle("Weather Rock");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 400);
        this.setVisible(true);
    }
}