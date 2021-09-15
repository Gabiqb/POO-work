package com.company;
import javax.swing.*;
import java.awt.*;

public class firstFrame extends JFrame {
    private JLabel photo;
    private JTextField email;
    private JPasswordField password;
    private JLabel emailText;
    private JLabel passwordText;
    private JButton button;

    public JTextField getEmail() {
        return email;
    }

    public JPasswordField getPassword() {
        return password;
    }

    public JButton getButton() {
        return button;
    }

    public firstFrame() {
        this.setTitle("Autentificare");
        this.setDefaultCloseOperation(firstFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.pack();
        this.setSize(816, 578);
        this.setBounds(560,200,816,578);
        ImageIcon img = new ImageIcon("icon.png");
        this.setIconImage(img.getImage());
        this.getContentPane().setBackground(new java.awt.Color(159, 255, 128));

        photo = new JLabel();
        ImageIcon img2 = new ImageIcon("spital.png");
        Image resized = img2.getImage();
        Image newimg = resized.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon newicon = new ImageIcon(newimg);
        photo.setIcon(newicon);
        photo.setBounds(335, 20, 120, 120);
        this.add(photo);

        Font font = new Font("Georgia", Font.ROMAN_BASELINE, 20);
        Font font2 = new Font("Georgia", Font.BOLD, 20);

        email = new JTextField();
        email.setBounds(290, 200, 300, 50);
        email.setFont(font);
        this.add(email);

        password = new JPasswordField();
        password.setBounds(290, 280, 300, 50);
        password.setFont(font);
        this.add(password);

        emailText = new JLabel("E-mail:");
        emailText.setFont(font2);
        emailText.setBounds(190, 200, 100, 50);
        emailText.setForeground(new java.awt.Color(0, 26, 0));
        this.add(emailText);

        passwordText = new JLabel("Parola:");
        passwordText.setFont(font2);
        passwordText.setBounds(190, 280, 100, 50);
        passwordText.setForeground(new java.awt.Color(0, 26, 0));
        this.add(passwordText);

        button = new JButton("Autentificare");
        button.setFont(font2);
        button.setBounds(300, 400, 200, 50);
        button.setBackground(new java.awt.Color(0, 205, 255));
        this.add(button);

        ClockPane c1 = new ClockPane();
        c1.setBounds(0, 0, 300, 50);

        c1.setOpaque(false);
        this.add(c1);


    }
}
