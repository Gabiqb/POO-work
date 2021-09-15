package com.company;

import com.company.JTimeChooser.src.lu.tudor.santec.jtimechooser.JTimeChooser;
import com.toedter.calendar.JDateChooser;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class ProgramUnitate extends JFrame {

    String[][] date;
    String[] header;
    JButton sterge;
    JButton updateb;
    JButton confirma;
    JTextField id_a;

    JTextField luni;
    JTextField marti;
    JTextField miercuri;
    JTextField joi;
    JTextField vineri;
    JTextField sambata;
    JTextField duminica;
    JTextField locatie;
    JLabel tabela;
    JButton logout;
    Table tab1;
    EroareInsert err;
    EroareStergere ers;



    int selectedrow = 0;
    int selrow = 0;


    public ProgramUnitate() {
        Font font2 = new Font("Georgia", Font.BOLD, 12);
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
        tabela.setText("Program unitate");
        tabela.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 204)));
        tabela.setOpaque(true);
        tabela.setBounds(580, 50, 145, 50);
        tabela.setBackground(new Color(252, 242, 206));
        tabela.setFont(font2);
        this.add(tabela);

        date = ExecProc.getData(Model.c, "select * from program_unitate");
        header = ExecHeader.getHeader(Model.c, "select * from program_unitate");
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
        id_a.setBounds(10, 690, 150, 30);
        id_a.setFont(new Font("Georgia", Font.BOLD, 12));
        JLabel id_al = new JLabel("ID Unitate");
        id_al.setOpaque(true);
        id_al.setBackground(new Color(252, 242, 206));
        id_al.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 2, 3, new java.awt.Color(0, 153, 204)));
        id_al.setFont(new Font("Georgia", Font.BOLD, 16));
        id_al.setBounds(30, 670, 100, 20);
        this.add(id_al);
        this.add(id_a);

        luni = new JTextField("");
        luni.setBounds(210, 690, 150, 30);
        luni.setFont(new Font("Georgia", Font.BOLD, 12));
        JLabel lunil = new JLabel("Luni");
        lunil.setOpaque(true);
        lunil.setBackground(new Color(252, 242, 206));
        lunil.setFont(new Font("Georgia", Font.BOLD, 16));
        lunil.setBounds(240, 670, 50, 20);
        lunil.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 2, 3, new java.awt.Color(0, 153, 204)));

        this.add(lunil);
        this.add(luni);
        marti = new JTextField("");
        marti.setBounds(420, 690, 150, 30);
        marti.setFont(new Font("Georgia", Font.BOLD, 12));
        JLabel martil = new JLabel("Marti");
        martil.setOpaque(true);
        martil.setBackground(new Color(252, 242, 206));
        martil.setFont(new Font("Georgia", Font.BOLD, 16));
        martil.setBounds(450, 670, 60, 20);
        martil.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 2, 3, new java.awt.Color(0, 153, 204)));
        this.add(martil);
        this.add(marti);

        miercuri = new JTextField("");
        miercuri.setBounds(620, 690, 150, 30);
        miercuri.setFont(new Font("Georgia", Font.BOLD, 12));
        JLabel miercuril = new JLabel("Miercuri");
        miercuril.setOpaque(true);
        miercuril.setBackground(new Color(252, 242, 206));
        miercuril.setFont(new Font("Georgia", Font.BOLD, 16));
        miercuril.setBounds(650, 670, 100, 20);
        miercuril.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 2, 3, new java.awt.Color(0, 153, 204)));
        this.add(miercuril);
        this.add(miercuri);

        joi = new JTextField("");
        joi.setBounds(820, 690, 150, 30);
        joi.setFont(new Font("Georgia", Font.BOLD, 12));
        JLabel joil = new JLabel("Joi");
        joil.setOpaque(true);
        joil.setBackground(new Color(252, 242, 206));
        joil.setFont(new Font("Georgia", Font.BOLD, 16));
        joil.setBounds(850, 670, 40, 20);
        joil.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 2, 3, new java.awt.Color(0, 153, 204)));
        this.add(joil);
        this.add(joi);

        vineri = new JTextField("");
        vineri.setBounds(1020, 690, 150, 30);
        vineri.setFont(new Font("Georgia", Font.BOLD, 12));
        JLabel vineril = new JLabel("Vineri");
        vineril.setOpaque(true);
        vineril.setBackground(new Color(252, 242, 206));
        vineril.setFont(new Font("Georgia", Font.BOLD, 16));
        vineril.setBounds(1050, 670, 70, 20);
        vineril.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 2, 3, new java.awt.Color(0, 153, 204)));
        this.add(vineril);
        this.add(vineri);

        sambata = new JTextField("");
        sambata.setBounds(1220, 690, 150, 30);
        sambata.setFont(new Font("Georgia", Font.BOLD, 12));
        JLabel sambatal = new JLabel("Sambata");
        sambatal.setOpaque(true);
        sambatal.setBackground(new Color(252, 242, 206));
        sambatal.setFont(new Font("Georgia", Font.BOLD, 16));
        sambatal.setBounds(1250, 670, 80, 20);
        sambatal.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 2, 3, new java.awt.Color(0, 153, 204)));
        this.add(sambatal);
        this.add(sambata);

        duminica = new JTextField("");
        duminica.setBounds(1420, 690, 150, 30);
        duminica.setFont(new Font("Georgia", Font.BOLD, 12));
        JLabel duminical = new JLabel("Duminica");
        duminical.setOpaque(true);
        duminical.setBackground(new Color(252, 242, 206));
        duminical.setFont(new Font("Georgia", Font.BOLD, 16));
        duminical.setBounds(1450, 670, 100, 20);
        duminical.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 2, 3, new java.awt.Color(0, 153, 204)));
        this.add(duminical);
        this.add(duminica);



        locatie = new JTextField("");
        locatie.setBounds(870, 690, 150, 30);
        locatie.setFont(new Font("Georgia", Font.BOLD, 12));
        locatie.setEditable(false);
        locatie.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    int ida = Integer.parseInt(id_a.getText());
                    PreparedStatement st = Model.c.prepareStatement("select id_unitate from angajat where id=" + ida);
                    ResultSet rs = st.executeQuery();
                    int idu = 0;
                    while (rs.next()) {
                        idu = rs.getInt(1);
                    }
                    st = Model.c.prepareStatement("select adresa from unitate_medicala where id=" + idu);
                    rs = st.executeQuery();
                    while (rs.next()) {
                        locatie.setText(rs.getString(1));
                    }

                } catch (Exception se) {

                }
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


        sterge = new JButton("Șterge");
        sterge.setBounds(1450, 200, 100, 50);
        sterge.setFont(new Font("Georgia", Font.BOLD, 12));
        sterge.setBackground(new Color(252, 242, 206));
        sterge.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 204)));
        sterge.setFocusPainted(false);
        this.add(sterge);
        sterge.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                selectedrow = tab1.t.getSelectedRow();
                date = ExecProc.getData(Model.c, "select * from program_unitate");


                if (selectedrow >= 0) {
                    if (date.length > selectedrow) {
                        try {
                            selrow = Integer.parseInt(date[selectedrow][0]);
                            PreparedStatement s = Model.c.prepareCall("{call stergepunitate(?)}"); ///sterge un utilizator
                            s.setInt(1, selrow);
                            s.execute();
                            date = ExecProc.getData(Model.c, "select * from program_unitate");
                            header = ExecHeader.getHeader(Model.c, "select * from program_unitate");
                            ((DefaultTableModel) tab1.t.getModel()).setDataVector(date, header);
                            updateb.setVisible(false);
                        } catch (Exception sqe) {

                        }
                    } else if (tab1.t.getSelectedRow() >= 0) {
                        date = ExecProc.getData(Model.c, "select * from program_unitate");
                        header = ExecHeader.getHeader(Model.c, "select * from program_unitate");
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

                try {
                    if (selectedrow >= 0) {
                        int id=0;
                        String l,m,mm,j,v,s,d;
                        l=tab1.t.getValueAt(selectedrow,1).toString();
                        m=tab1.t.getValueAt(selectedrow,2).toString();
                        mm=tab1.t.getValueAt(selectedrow,3).toString();
                        j=tab1.t.getValueAt(selectedrow,4).toString();
                        v=tab1.t.getValueAt(selectedrow,5).toString();
                        s=tab1.t.getValueAt(selectedrow,6).toString();
                        d=tab1.t.getValueAt(selectedrow,7).toString();
                        id=Integer.parseInt(tab1.t.getValueAt(selectedrow,0).toString());
                        CallableStatement sc=Model.c.prepareCall("{call updatepunitate(?,?,?,?,?,?,?,?)}");
                        sc.setInt(1,id);
                        sc.setString(2,l);
                        sc.setString(3,m);
                        sc.setString(4,mm);
                        sc.setString(5,j);
                        sc.setString(6,v);
                        sc.setString(7,s);
                        sc.setString(8,d);
                        sc.execute();
                        date = ExecProc.getData(Model.c, "select * from program_unitate");
                        header = ExecHeader.getHeader(Model.c, "select * from program_unitate");
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

            public void actionPerformed(ActionEvent e) {
                updateb.setVisible(false);
                try {
                    if (tab1.t.isEditing()) {
                        tab1.t.getCellEditor().stopCellEditing();
                    }
                    int id=0;
                    String l,m,mm,j,v,s,d;
                    l=luni.getText();
                    m=marti.getText();
                    mm=miercuri.getText();
                    j=joi.getText();
                    v=vineri.getText();
                    s=sambata.getText();
                    d=duminica.getText();
                    id=Integer.parseInt(id_a.getText());
                    CallableStatement sc=Model.c.prepareCall("{call insertpunitate(?,?,?,?,?,?,?,?)}");
                    sc.setInt(1,id);
                    sc.setString(2,l);
                    sc.setString(3,m);
                    sc.setString(4,mm);
                    sc.setString(5,j);
                    sc.setString(6,v);
                    sc.setString(7,s);
                    sc.setString(8,d);
                    sc.execute();
                    luni.setText("");
                    marti.setText("");
                    miercuri.setText("");
                    joi.setText("");
                    vineri.setText("");
                    sambata.setText("");
                    duminica.setText("");

                    date = ExecProc.getData(Model.c, "select * from program_unitate");
                    header = ExecHeader.getHeader(Model.c, "select * from program_unitate");
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
                date = ExecProc.getData(Model.c, "select * from program_unitate");
                header = ExecHeader.getHeader(Model.c, "select * from program_unitate");
                ((DefaultTableModel) tab1.t.getModel()).setDataVector(date, header);
            }
        });

        ers = new EroareStergere();
        ers.setBounds(960, 500, 300, 168);

        ers.continua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ers.setVisible(false);
                date = ExecProc.getData(Model.c, "select * from program_unitate");
                header = ExecHeader.getHeader(Model.c, "select * from program_unitate");
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
