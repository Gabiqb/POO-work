package com.company;

import com.toedter.calendar.JDateChooser;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;

import java.text.SimpleDateFormat;

public class AdaugareConcediu extends JFrame {

    String[][] date;
    String[] header;
    JButton sterge;
    JButton updateb;
    JButton confirma;
    JTextField id_a;
    JDateChooser data_i;
    JDateChooser data_f;
    JLabel tabela;
    JButton logout;
    Table tab1;
    EroareInsert err;
    EroareStergere ers;

    int selectedrow = 0;
    int selrow = 0;


    public AdaugareConcediu() {
        Font font2 = new Font("Georgia", Font.BOLD, 12);
        Font font4 = new Font("Georgia", Font.BOLD, 14);
        this.setTitle("Administrator");
        this.setFont(font2);
        this.getContentPane().setBackground(new Color(119, 161, 160));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        //////////////////////////////////////////////////////////////////////////////initilaizare frame + grafica
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
        tabela.setText("Concediu angajati");
        tabela.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 204)));
        tabela.setOpaque(true);
        tabela.setBounds(580, 50, 145, 50);
        tabela.setBackground(new Color(252, 242, 206));
        tabela.setFont(font2);
        this.add(tabela);

        date = ExecProc.getData(Model.c, "select * from concedii");
        header = ExecHeader.getHeader(Model.c, "select * from concedii");
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
        JLabel id_al = new JLabel("ID Angajat");
        id_al.setOpaque(true);
        id_al.setBackground(new Color(252, 242, 206));
        id_al.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 2, 3, new java.awt.Color(0, 153, 204)));
        id_al.setFont(new Font("Georgia", Font.BOLD, 16));
        id_al.setBounds(80, 670, 100, 20);
        this.add(id_al);
        this.add(id_a);

        data_i = new JDateChooser();
        data_i.setBounds(300, 690, 150, 30);
        data_i.setOpaque(true);
        data_i.setForeground(Color.BLACK);
        data_i.setFont(font4);
        JLabel data_il = new JLabel("Data incepere concediu");
        data_il.setOpaque(true);
        data_il.setBackground(new Color(252, 242, 206));
        data_il.setFont(new Font("Georgia", Font.BOLD, 16));
        data_il.setBounds(270, 670, 230, 20);
        data_il.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 2, 3, new java.awt.Color(0, 153, 204)));
        this.add(data_il);
        this.add(data_i);


        data_f = new JDateChooser();
        data_f.setBounds(600, 690, 150, 30);
        data_f.setFont(new Font("Georgia", Font.BOLD, 12));
        JLabel data_fl = new JLabel("Data finalizare concediu");
        data_fl.setOpaque(true);
        data_fl.setBackground(new Color(252, 242, 206));
        data_fl.setFont(new Font("Georgia", Font.BOLD, 16));
        data_fl.setBounds(570, 670, 230, 20);
        data_fl.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 2, 3, new java.awt.Color(0, 153, 204)));

        this.add(data_fl);
        this.add(data_f);
        //////////////////////////////////////////////////////////////////////////////initilaizare frame + grafica
        sterge = new JButton("Șterge");
        sterge.setBounds(1450, 200, 100, 50);
        sterge.setFont(new Font("Georgia", Font.BOLD, 12));
        sterge.setBackground(new Color(252, 242, 206));
        sterge.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 204)));
        sterge.setFocusPainted(false);
        this.add(sterge);
        sterge.addActionListener(new ActionListener() {
            //////////////////////////////////////////////////////////////////////////////sterge un concediu
            public void actionPerformed(ActionEvent e) {

                selectedrow = tab1.t.getSelectedRow();
                date = ExecProc.getData(Model.c, "select * from concedii");


                if (selectedrow >= 0) {
                    if (date.length > selectedrow) {
                        try {
                            selrow = Integer.parseInt(date[selectedrow][0]);
                            PreparedStatement s = Model.c.prepareCall("{call stergeconcediu(?)}");
                            s.setInt(1, selrow);
                            s.execute();
                            date = ExecProc.getData(Model.c, "select * from concedii");
                            header = ExecHeader.getHeader(Model.c, "select * from concedii");

                            ((DefaultTableModel) tab1.t.getModel()).setDataVector(date, header);
                            updateb.setVisible(false);
                        } catch (Exception sqe) {

                        }
                    } else if (tab1.t.getSelectedRow() >= 0) {
                        date = ExecProc.getData(Model.c, "select * from concedii");

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

            public void actionPerformed(ActionEvent e) {
                selectedrow = tab1.t.getSelectedRow();
                //////////////////////////////////////////////////////////////////////////////modifica un concediu existent
                try {
                    if (selectedrow >= 0) {
                        String data_inc, data_fi;
                        int ida = Integer.parseInt(tab1.t.getValueAt(selectedrow, 0).toString());
                        data_inc = tab1.t.getValueAt(selectedrow, 1).toString();
                        data_fi = tab1.t.getValueAt(selectedrow, 2).toString();
                        CallableStatement ss = Model.c.prepareCall("call updateconcediu(?,?,?)");
                        ss.setInt(1, ida);
                        ss.setString(2, data_inc);
                        ss.setString(3, data_fi);

                        ss.execute();
                        date = ExecProc.getData(Model.c, "select * from concedii");
                        header = ExecHeader.getHeader(Model.c, "select * from concedii");

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
        confirma.setBounds(800, 760, 100, 50);
        confirma.setFont(new Font("Georgia", Font.BOLD, 12));
        confirma.setBackground(new Color(252, 242, 206));
        confirma.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 204)));
        confirma.setFocusPainted(false);
        confirma.addActionListener(new ActionListener() {
            //////////////////////////////////////////////////////////////////////////////adauga un concediu in tabela 'concedii'
            public void actionPerformed(ActionEvent e) {
                updateb.setVisible(false);
                try {
                    if (tab1.t.isEditing()) {
                        tab1.t.getCellEditor().stopCellEditing();
                    }
                    String data_inc, data_fi;
                    int ida = 0;
                    ida = Integer.parseInt(id_a.getText());
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    data_inc = formatter.format(data_i.getDate());
                    data_fi = formatter.format(data_f.getDate());

                    CallableStatement ss = Model.c.prepareCall("call adaugaconcediu(?,?,?)");
                    ss.setInt(1, ida);
                    ss.setString(2, data_inc);
                    ss.setString(3, data_fi);
                    ss.execute();


                    id_a.setText("");
                    data_i.setDate(null);
                    data_f.setDate(null);
                    date = ExecProc.getData(Model.c, "select * from concedii");
                    header = ExecHeader.getHeader(Model.c, "select * from concedii");

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
                date = ExecProc.getData(Model.c, "select * from concedii");
                header = ExecHeader.getHeader(Model.c, "select * from concedii");

                ((DefaultTableModel) tab1.t.getModel()).setDataVector(date, header);
            }
        });

        ers = new EroareStergere();
        ers.setBounds(960, 500, 300, 168);

        ers.continua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ers.setVisible(false);
                date = ExecProc.getData(Model.c, "select * from concedii");
                header = ExecHeader.getHeader(Model.c, "select * from concedii");

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
