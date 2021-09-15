package com.company;


import com.toedter.calendar.JDateChooser;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;


public class AdaugaUnitate extends JFrame {

    String[][] date;
    String[] header;
    JButton sterge;
    JButton updateb;
    JButton confirma;
    JTextField id_a;
    JTextField denumire;
    JTextField adresa;
    JTextArea servicii;
    JLabel tabela;
    JButton logout;
    Table tab1;
    EroareInsert err;
    EroareStergere ers;
    JDateChooser cl;

    int selectedrow = 0;
    int selrow = 0;


    public AdaugaUnitate() {
        //////////////////////////////////////////////////////////////////////////////initializare frame
        Font font2 = new Font("Georgia", Font.BOLD, 12);
        Font font4 = new Font("Georgia", Font.BOLD, 14);
        this.setTitle("Administrator");
        this.setFont(font2);
        this.getContentPane().setBackground(new Color(119, 161, 160));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        this.pack();
        this.setSize(800, 601);
        this.setBounds(160, 100, 1600, 900);
        ClockPane c1 = new ClockPane();
        c1.setBounds(0, 0, 300, 50);
        c1.setOpaque(false);
        this.add(c1);
        ImageIcon img = new ImageIcon("icon.png");
        this.setIconImage(img.getImage());
        err = new EroareInsert();
        tabela = new JLabel();
        tabela.setText("Program angajati");
        tabela.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 204)));
        tabela.setOpaque(true);
        tabela.setBounds(580, 50, 145, 50);
        tabela.setBackground(new Color(252, 242, 206));
        tabela.setFont(font2);
        this.add(tabela);

        date=ExecProc.getData(Model.c,"select * from unitate_medicala");
        header=ExecHeader.getHeader(Model.c,"select * from unitate_medicala");
        tab1 = new Table(date, header);
        this.add(tab1);
        tab1.setBounds(50, 100, 1200, 550);
        tab1.t.setFont(font2);
        tab1.t.getTableHeader().setFont(font2);
        tab1.t.getTableHeader().setBackground(new Color(92, 143, 243));
        tab1.t.getTableHeader().setReorderingAllowed(false);
        tab1.t.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));


        this.setForeground(new Color(153, 153, 153));

        id_a = new JTextField("");
        id_a.setBounds(50, 690, 150, 30);
        id_a.setFont(new Font("Georgia", Font.BOLD, 12));
        JLabel id_al = new JLabel("ID Unitate");
        id_al.setOpaque(true);
        id_al.setBackground(new Color(252, 242, 206));
        id_al.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 2, 3, new java.awt.Color(0, 153, 204)));
        id_al.setFont(new Font("Georgia", Font.BOLD, 16));
        id_al.setBounds(80, 670, 100, 20);
        this.add(id_al);
        this.add(id_a);

        denumire=new JTextField();
        denumire.setBounds(260, 690, 150, 30);
        denumire.setOpaque(true);
        denumire.setForeground(Color.BLACK);
        denumire.setFont(font4);
        JLabel denumirel = new JLabel("Denumire");
        denumirel.setOpaque(true);
        denumirel.setBackground(new Color(252, 242, 206));
        denumirel.setFont(new Font("Georgia", Font.BOLD, 16));
        denumirel.setBounds(290, 670, 100, 20);
        denumirel.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 2, 3, new java.awt.Color(0, 153, 204)));
        this.add(denumirel);
        this.add(denumire);


        adresa= new JTextField("");
        adresa.setBounds(470, 690, 150, 30);
        adresa.setFont(new Font("Georgia", Font.BOLD, 12));
        JLabel adresal = new JLabel("Adresa");
        adresal.setOpaque(true);
        adresal.setBackground(new Color(252, 242, 206));
        adresal.setFont(new Font("Georgia", Font.BOLD, 16));
        adresal.setBounds(490, 670, 120, 20);
        adresal.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 2, 3, new java.awt.Color(0, 153, 204)));

        this.add(adresal);
        this.add(adresa);
        servicii= new JTextArea();
        servicii.setFont(new Font("Georgia", Font.BOLD, 12));
        servicii.setLineWrap(true);
        JScrollPane p3 = new JScrollPane(servicii);
        p3.setBounds(670, 690, 200, 150);
        JLabel serviciil = new JLabel("Servicii oferite");
        serviciil.setOpaque(true);
        serviciil.setBackground(new Color(252, 242, 206));
        serviciil.setFont(new Font("Georgia", Font.BOLD, 16));
        serviciil.setBounds(700, 670, 150, 20);
        serviciil.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 2, 3, new java.awt.Color(0, 153, 204)));
        this.add(serviciil);
        this.add(p3);

        sterge = new JButton("Șterge");
        sterge.setBounds(1450, 200, 100, 50);
        sterge.setFont(new Font("Georgia", Font.BOLD, 12));
        sterge.setBackground(new Color(252, 242, 206));
        sterge.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 204)));
        sterge.setFocusPainted(false);
        this.add(sterge);
        sterge.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                    //////////////////////////////////////////////////////////////////////////////sterge o unitate medicala din tabel
                selectedrow = tab1.t.getSelectedRow();
                date=ExecProc.getData(Model.c,"select * from unitate_medicala");

                if (selectedrow >= 0) {
                    if (date.length > selectedrow) {
                        try {
                            selrow = Integer.parseInt(date[selectedrow][0]);
                            PreparedStatement s = Model.c.prepareCall("{call stergeunitate(?)}");
                            s.setInt(1, selrow);
                            s.execute();
                            date=ExecProc.getData(Model.c,"select * from unitate_medicala");
                            header=ExecHeader.getHeader(Model.c,"select * from unitate_medicala");
                            ((DefaultTableModel) tab1.t.getModel()).setDataVector(date, header);
                            updateb.setVisible(false);
                        } catch (Exception sqe) {

                        }
                    } else if (tab1.t.getSelectedRow() >= 0) {
                        date=ExecProc.getData(Model.c,"select * from unitate_medicala");
                        header=ExecHeader.getHeader(Model.c,"select * from unitate_medicala");
                        ((DefaultTableModel) tab1.t.getModel()).setDataVector(date, header);
                    }
                }
            }

        });
        updateb = new JButton("Confirmi modificarea?");
        updateb.setBounds(1050, 760, 160, 50);
        updateb.setFont(new Font("Georgia", Font.BOLD, 12));
        updateb.setBackground(new Color(252, 242, 206));
        updateb.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 204)));
        updateb.setFocusPainted(false);
        updateb.addActionListener(new ActionListener() {
            ////////////////////////////////////////////////////////////////////////////// modifica datele unei unitati medicale din tabel
            public void actionPerformed(ActionEvent e) {
                selectedrow = tab1.t.getSelectedRow();

                try {
                    if (selectedrow >= 0) {
                        String den,adr,servicii_o;
                        int ida=Integer.parseInt(tab1.t.getValueAt(selectedrow,0).toString());
                        den=tab1.t.getValueAt(selectedrow,1).toString();
                        adr=tab1.t.getValueAt(selectedrow,2).toString();
                        servicii_o=tab1.t.getValueAt(selectedrow,3).toString();
                        CallableStatement ss=Model.c.prepareCall("call updateunitate(?,?,?,?,?,?)");
                        ss.setInt(1,ida);
                        ss.setString(2,den);
                        ss.setString(3,adr);
                        ss.setString(4,servicii_o);
                        ss.execute();
                        date=ExecProc.getData(Model.c,"select * from unitate_medicala");
                        header=ExecHeader.getHeader(Model.c,"select * from unitate_medicala");
                        ((DefaultTableModel) tab1.t.getModel()).setDataVector(date, header);
                    }


                } catch (Exception sqe) {
                    err.setVisible(true);

                }
                updateb.setVisible(false);
            }

        });
        updateb.setVisible(false);
        add(updateb);

        confirma = new JButton("Inserare");
        confirma.setBounds(900, 760, 100, 50);
        confirma.setFont(new Font("Georgia", Font.BOLD, 12));
        confirma.setBackground(new Color(252, 242, 206));
        confirma.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 204)));
        confirma.setFocusPainted(false);
        confirma.addActionListener(new ActionListener() {
            ////////////////////////////////////////////////////////////////////////////// adauga o unitate medicala in tabel
            public void actionPerformed(ActionEvent e) {
                updateb.setVisible(false);
                try {
                    if (tab1.t.isEditing()) {
                        tab1.t.getCellEditor().stopCellEditing();
                    }
                    String den,adr,servicii_o;
                    int ida=0;
                    ida=Integer.parseInt(id_a.getText());
                    den=denumire.getText();
                    adr=adresa.getText();
                    servicii_o=servicii.getText();
                    CallableStatement ss=Model.c.prepareCall("call adaugaunitate(?,?,?,?)");
                    ss.setInt(1,ida);
                    ss.setString(2,den);
                    ss.setString(3,adr);
                    ss.setString(4,servicii_o);
                    ss.execute();
                    denumire.setText("");
                    adresa.setText("");
                    servicii.setText("");
                    id_a.setText("");
                    date=ExecProc.getData(Model.c,"select * from unitate_medicala");
                    header=ExecHeader.getHeader(Model.c,"select * from unitate_medicala");
                    ((DefaultTableModel) tab1.t.getModel()).setDataVector(date, header);


                } catch (Exception sqe) {
                    err.setVisible(true);
                }
            }
        });
        add(confirma);
        tab1.t.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tab1.t.getSelectedRow() >= 0)
                    updateb.setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        err.setBounds(960, 500, 300, 168);
        err.continua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                err.setVisible(false);
                date=ExecProc.getData(Model.c,"select * from unitate_medicala");
                header=ExecHeader.getHeader(Model.c,"select * from unitate_medicala");
                ((DefaultTableModel) tab1.t.getModel()).setDataVector(date, header);
            }
        });

        ers = new EroareStergere();
        ers.setBounds(960, 500, 300, 168);

        ers.continua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ers.setVisible(false);
                date=ExecProc.getData(Model.c,"select * from unitate_medicala");
                header=ExecHeader.getHeader(Model.c,"select * from unitate_medicala");
                ((DefaultTableModel) tab1.t.getModel()).setDataVector(date, header);
            }
        });

        logout = new JButton("Inapoi");
        logout.setBounds(1450, 20, 100, 50);
        logout.setFont(new Font("Georgia", Font.BOLD, 13));
        logout.setBackground(new Color(216, 0, 55));
        logout.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 204)));
        logout.setFocusPainted(false);
        this.add(logout);
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {

                if (tab1.t.isEditing()) {
                    tab1.t.getCellEditor().stopCellEditing();

                }


            }
        });
    }
}
