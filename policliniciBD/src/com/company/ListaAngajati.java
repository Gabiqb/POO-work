package com.company;
import javax.swing.*;
import java.awt.*;

public class ListaAngajati extends JFrame {
    private JLabel photo;
    private JButton medic;
    private JButton asistent;
    private JButton receptionist;
    private JButton superadmin;
    private JButton admin;
    private JButton expert;
    private JButton inspector;

    public ListaAngajati() {
        this.setTitle("Lista Angajati");
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
        photo.setBounds(340, 20, 120, 120);
        this.add(photo);

        Font font2 = new Font("Georgia", Font.BOLD, 20);

        superadmin = new JButton("Super-Administrator");
        superadmin.setFont(font2);
        superadmin.setBounds(100, 150, 250, 50);
        superadmin.setBackground(new java.awt.Color(0, 205, 255));
        superadmin.setFocusPainted(false);
        this.add(superadmin);

        admin = new JButton("Administrator");
        admin.setFont(font2);
        admin.setBounds(100, 250, 250, 50);
        admin.setBackground(new java.awt.Color(0, 205, 255));
        admin.setFocusPainted(false);
        this.add(admin);

        receptionist = new JButton("Receptionist");
        receptionist.setFont(font2);
        receptionist.setBounds(100, 350, 250, 50);
        receptionist.setBackground(new java.awt.Color(0, 205, 255));
        receptionist.setFocusPainted(false);
        this.add(receptionist);

        medic = new JButton("Medic");
        medic.setFont(font2);
        medic.setBounds(450, 150, 250, 50);
        medic.setBackground(new java.awt.Color(0, 205, 255));
        medic.setFocusPainted(false);
        this.add(medic);

        asistent = new JButton("Asistent");
        asistent.setFont(font2);
        asistent.setBounds(450, 250, 250, 50);
        asistent.setBackground(new java.awt.Color(0, 205, 255));
        asistent.setFocusPainted(false);
        this.add(asistent);

        expert = new JButton("Expert Financiar");
        expert.setFont(font2);
        expert.setBounds(450, 350, 250, 50);
        expert.setBackground(new java.awt.Color(0, 205, 255));
        expert.setFocusPainted(false);
        this.add(expert);

        inspector = new JButton("Inspector");
        inspector.setFont(font2);
        inspector.setBounds(275, 450, 250, 50);
        inspector.setBackground(new java.awt.Color(0, 205, 255));
        inspector.setFocusPainted(false);
        this.add(inspector);


        ClockPane c1 = new ClockPane();
        c1.setBounds(0, 0, 300, 50);

        c1.setOpaque(false);
        this.add(c1);


       // this.setVisible(true);
    }
}
