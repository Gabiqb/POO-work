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
import java.text.SimpleDateFormat;

public class Program extends JFrame {

    String[][] date;
    String[] header;
    JButton sterge;
    JButton updateb;
    JButton confirma;
    JTextField id_a;
    JTimeChooser ora_inceput;
    JTimeChooser ora_final;
    JTextField locatie;
    JTextField concediu;
    JLabel tabela;
    JButton logout;
    Table tab1;
    EroareInsert err;
    EroareStergere ers;
    JDateChooser cl;


    int selectedrow = 0;
    int selrow = 0;


    public Program() {
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

        date=ExecProc.getData(Model.c,"select * from program_angajat p,utilizator u where id_angajat=id and functie<>'administrator' and functie <>'super-administrator'");
        header=ExecHeader.getHeader(Model.c,"select * from program_angajat");
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

        cl=new JDateChooser();
        cl.setBounds(260, 690, 150, 30);
        cl.setOpaque(true);
        cl.setForeground(Color.BLACK);
        cl.setFont(font4);
        JLabel zi_lucrul = new JLabel("Zi lucru");
        zi_lucrul.setOpaque(true);
        zi_lucrul.setBackground(new Color(252, 242, 206));
        zi_lucrul.setFont(new Font("Georgia", Font.BOLD, 16));
        zi_lucrul.setBounds(290, 670, 100, 20);
        zi_lucrul.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 2, 3, new java.awt.Color(0, 153, 204)));
        this.add(zi_lucrul);
        this.add(cl);



        ora_inceput= new JTimeChooser();
        ora_inceput.setBounds(470, 690, 150, 30);
        ora_inceput.setFont(new Font("Georgia", Font.BOLD, 12));
        JLabel ora_inceputl = new JLabel("Ora inceput");
        ora_inceputl.setOpaque(true);
        ora_inceputl.setBackground(new Color(252, 242, 206));
        ora_inceputl.setFont(new Font("Georgia", Font.BOLD, 16));
        ora_inceputl.setBounds(490, 670, 120, 20);
        ora_inceputl.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 2, 3, new java.awt.Color(0, 153, 204)));

        this.add(ora_inceputl);
        this.add(ora_inceput);
        ora_final = new JTimeChooser();
        ora_final.setBounds(670, 690, 150, 30);
        ora_final.setFont(new Font("Georgia", Font.BOLD, 12));
        JLabel ora_finall = new JLabel("Ora final");
        ora_finall.setOpaque(true);
        ora_finall.setBackground(new Color(252, 242, 206));
        ora_finall.setFont(new Font("Georgia", Font.BOLD, 16));
        ora_finall.setBounds(700, 670, 100, 20);
        ora_finall.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 2, 3, new java.awt.Color(0, 153, 204)));
        this.add(ora_finall);
        this.add(ora_final);
        locatie = new JTextField("");
        locatie.setBounds(870, 690, 150, 30);
        locatie.setFont(new Font("Georgia", Font.BOLD, 12));
        locatie.setEditable(false);
        locatie.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    int ida=Integer.parseInt(id_a.getText());
                    PreparedStatement st=Model.c.prepareStatement("select id_unitate from angajat where id="+ida);
                    ResultSet rs=st.executeQuery();
                    int idu=0;
                    while(rs.next())
                    {
                        idu=rs.getInt(1);
                    }
                    st=Model.c.prepareStatement("select adresa from unitate_medicala where id="+idu);
                    rs=st.executeQuery();
                    while(rs.next())
                    {
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
        JLabel  locatiel = new JLabel("Locatie");
        locatiel.setOpaque(true);
        locatiel.setBackground(new Color(252, 242, 206));
        locatiel.setFont(new Font("Georgia", Font.BOLD, 16));
        locatiel.setBounds(900, 670, 80, 20);
        locatiel.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 2, 3, new java.awt.Color(0, 153, 204)));
        this.add(locatiel);
        this.add(locatie);
        concediu = new JTextField("");
        concediu.setBounds(1070, 690, 150, 30);
        concediu.setFont(new Font("Georgia", Font.BOLD, 12));
        JLabel concediul = new JLabel("Concediu");
        concediul.setOpaque(true);
        concediul.setBackground(new Color(252, 242, 206));
        concediul.setFont(new Font("Georgia", Font.BOLD, 16));
        concediul.setBounds(1090, 670, 100, 20);
        concediul.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 2, 3, new java.awt.Color(0, 153, 204)));
        this.add(concediul);
        this.add(concediu);

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
                date=ExecProc.getData(Model.c,"select * from program_angajat p,utilizator u where id_angajat=id and functie<>'administrator' and functie <>'super-administrator'");


                if (selectedrow >= 0) {
                    if (date.length > selectedrow) {
                        try {
                            selrow = Integer.parseInt(date[selectedrow][0]);
                            PreparedStatement s = Model.c.prepareCall("{call stergeprogram(?)}"); ///sterge un utilizator
                            s.setInt(1, selrow);
                            s.execute();
                            date=ExecProc.getData(Model.c,"select * from program_angajat p,utilizator u where id_angajat=id and functie<>'administrator' and functie <>'super-administrator'");
                            header=ExecHeader.getHeader(Model.c,"select * from program_angajat");
                            ((DefaultTableModel) tab1.t.getModel()).setDataVector(date, header);
                            updateb.setVisible(false);
                        } catch (Exception sqe) {

                        }
                    } else if (tab1.t.getSelectedRow() >= 0) {
                        date=ExecProc.getData(Model.c,"select * from program_angajat p,utilizator u where id_angajat=id and functie<>'administrator' and functie <>'super-administrator'");
                        header=ExecHeader.getHeader(Model.c,"select * from program_angajat");
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
                        String zi_l,ora_inc,ora_f,loc,conc;
                        int ida=Integer.parseInt(tab1.t.getValueAt(selectedrow,0).toString());
                        zi_l=tab1.t.getValueAt(selectedrow,1).toString();
                        ora_inc=tab1.t.getValueAt(selectedrow,2).toString();
                        ora_f=tab1.t.getValueAt(selectedrow,3).toString();
                        loc=tab1.t.getValueAt(selectedrow,4).toString();
                        conc=tab1.t.getValueAt(selectedrow,5).toString();
                        CallableStatement ss=Model.c.prepareCall("call updateprogram(?,?,?,?,?,?)");
                        ss.setInt(1,ida);
                        ss.setString(2,zi_l);
                        ss.setString(3,ora_inc);
                        ss.setString(4,ora_f);
                        ss.setString(5,loc);
                        ss.setString(6,conc);
                        ss.execute();
                        date=ExecProc.getData(Model.c,"select * from program_angajat p,utilizator u where id_angajat=id and functie<>'administrator' and functie <>'super-administrator'");
                        header=ExecHeader.getHeader(Model.c,"select * from program_angajat");
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

            public void actionPerformed(ActionEvent e) {
                updateb.setVisible(false);
                try {
                    if (tab1.t.isEditing()) {
                        tab1.t.getCellEditor().stopCellEditing();
                    }
                        String zi_l,ora_inc,ora_f,loc,conc;
                        int ida=0;
                        ida=Integer.parseInt(id_a.getText());
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
                        zi_l=formatter.format(cl.getDate());
                        ora_inc=ora_inceput.getFormatedTime();
                        ora_f=ora_final.getFormatedTime();
                        loc=locatie.getText();
                        conc=concediu.getText();
                        CallableStatement ss=Model.c.prepareCall("call insertprogram(?,?,?,?,?,?)");
                        ss.setInt(1,ida);
                        ss.setString(2,zi_l);
                        ss.setString(3,ora_inc);
                        ss.setString(4,ora_f);
                        ss.setString(5,loc);
                        ss.setString(6,conc);
                        ss.execute();
                        date=ExecProc.getData(Model.c,"select * from program_angajat p,utilizator u where id_angajat=id and functie<>'administrator' and functie <>'super-administrator'");
                        header=ExecHeader.getHeader(Model.c,"select * from program_angajat");
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
                date=ExecProc.getData(Model.c,"select * from program_angajat p,utilizator u where id_angajat=id and functie<>'administrator' and functie <>'super-administrator'");
                header=ExecHeader.getHeader(Model.c,"select * from program_angajat");
                ((DefaultTableModel) tab1.t.getModel()).setDataVector(date, header);
            }
        });

        ers = new EroareStergere();
        ers.setBounds(960, 500, 300, 168);

        ers.continua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ers.setVisible(false);
                date=ExecProc.getData(Model.c,"select * from program_angajat p,utilizator u where id_angajat=id and functie<>'administrator' and functie <>'super-administrator'");
                header=ExecHeader.getHeader(Model.c,"select * from program_angajat");
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
