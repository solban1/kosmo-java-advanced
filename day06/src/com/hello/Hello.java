package com.hello;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello");
        ImageIcon i = new ImageIcon("imgs\\p1.png");
        JFrame f = new JFrame("test");
        f.getContentPane().add(new JLabel(i));
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}