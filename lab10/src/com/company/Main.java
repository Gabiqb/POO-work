package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static public int count=0;
    public static void main(String[] args) {
        JFrame frame = new JFrame ("Simple Frame");
      //  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 120);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        JLabel l = new JLabel ("Label1 ");
        JTextField tf = new JTextField("TextField1");
        panel1.add(l);
        panel1.add(tf);
        panel1.setLayout(new FlowLayout());

        JButton b1 = new JButton("Button 1");
        JButton b2 = new JButton("Button 2");
        JButton b3 = new JButton("Button 3");
        panel2.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ++count;
                tf.setText(count + "");
            }
        });
        panel2.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l.setText(tf.getText());
            }
        });
        panel2.add(b3);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int r,g,b;

                r=(int)(Math.random()*255);
                g=(int)(Math.random()*255);
                b=(int)(Math.random()*255);
                Color color1=new Color(r,g,b);
                panel1.setBackground(color1);

                r=(int)(Math.random()*255);
                g=(int)(Math.random()*255);
                b=(int)(Math.random()*255);
                Color color2=new Color(r,g,b);
                panel2.setBackground(color2);

            }
        });
        JPanel p = new JPanel();
        p.add(panel1);
        p.add(panel2);
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        frame.setContentPane(p);
        frame.setVisible(true);

        CalcMVC c1=new CalcMVC();
         c1.view.setVisible(true);


    }
}
