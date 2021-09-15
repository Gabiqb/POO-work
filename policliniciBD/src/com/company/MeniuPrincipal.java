package com.company;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MeniuPrincipal extends JFrame {
    class ImagePanel extends JComponent {
        private Image image;

        public ImagePanel(Image image) {
            this.image = image;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }
    }

    private JButton button;


    public JButton getButton() {
        return button;
    }

    public MeniuPrincipal() {
        this.setTitle("Meniu");
        this.setDefaultCloseOperation(firstFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.pack();
        this.setSize(800, 601);
        this.setBounds(560,200,800,601);
        ImageIcon img = new ImageIcon("icon.png");
        this.setIconImage(img.getImage());

        try {
            this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("policlinica.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Font font2 = new Font("Georgia", Font.BOLD, 30);

        button = new JButton("Autentificare");
        button.setFont(font2);
        button.setBounds(310, 235, 250, 50);
        button.setBackground(new java.awt.Color(0, 26, 6));
        button.setForeground(new java.awt.Color(0, 100, 153));
        button.setOpaque(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        this.add(button);

        ClockPane c1 = new ClockPane();
        c1.setBounds(0, 0, 300, 50);

        c1.setOpaque(false);
        this.add(c1);

    }
}
