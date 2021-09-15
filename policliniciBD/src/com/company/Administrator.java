package com.company;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;


public class Administrator extends JFrame {
    public String nume, prenume, cnp, nr_tel, email, parola, iban, nr_contr, data_a, functie;
    public int id, idu;
    public String[][] date;
    public String[] header;
    public JButton sterge;
    public JButton updateb;
    public JButton confirma;
    public JButton adaugaprogram;
    public JTextField cnpt;
    public JTextField numet;
    public JTextField prenumet;
    public JTextField nr_telt;
    public JTextField emailt;
    public JTextField parolat;
    public JTextField ibant;
    public JTextField nr_contrt;
    public JDateChooser data_angajariit;
    public JTextField functiet;
    public JTextField idunitt;
    public JTextField searcht;
    public JLabel searchl;
    public JLabel tabela;
    public JButton logout;
    public Table tab1;
    public EroareInsert err;
    public EroareStergere ers;
    public JButton adaugau;

    public int selectedrow = 0;
    public int selrow = 0;


    public Administrator(Connection c) {
        Font font2 = new Font("Georgia", Font.BOLD, 12);
        this.setTitle("Administrator");
        this.setFont(font2);
        this.getContentPane().setBackground(new Color(119, 161, 160));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        ////////////////////////////////////////////////////////////////////////////// initializare frame
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
        tabela.setText("Tabel de Utilizatori");
        tabela.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 204)));
        tabela.setOpaque(true);
        tabela.setBounds(580, 50, 145, 50);
        tabela.setBackground(new Color(252, 242, 206));
        tabela.setFont(font2);
        this.add(tabela);
        tab1 = new Table(date, header);
        tab1.t.setModel(new DefaultTableModel()
        {

            @Override
            public boolean isCellEditable(int row, int column)
            {

                return column != 0 && column!=10 && column!=2 && column!=3;
            }
        });

        this.add(tab1);
        tab1.setBounds(50, 100, 1200, 550);
        tab1.t.setFont(font2);
        tab1.t.getTableHeader().setFont(font2);
        tab1.t.getTableHeader().setBackground(new Color(92, 143, 243));
        tab1.t.getTableHeader().setReorderingAllowed(false);
        tab1.t.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        this.setForeground(new Color(153, 153, 153));

        cnpt = new JTextField("");
        cnpt.setBounds(50, 690, 150, 30);
        cnpt.setFont(new Font("Georgia", Font.BOLD, 12));
        JLabel cnpl = new JLabel("CNP");
        cnpl.setOpaque(true);
        cnpl.setBackground(new Color(252, 242, 206));
        cnpl.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 2, 3, new java.awt.Color(0, 153, 204)));
        cnpl.setFont(new Font("Georgia", Font.BOLD, 16));
        cnpl.setBounds(100, 670, 48, 20);
        this.add(cnpl);
        this.add(cnpt);
        numet = new JTextField("");
        numet.setBounds(260, 690, 150, 30);
        numet.setFont(new Font("Georgia", Font.BOLD, 12));
        JLabel numel = new JLabel("Nume");
        numel.setOpaque(true);
        numel.setBackground(new Color(252, 242, 206));
        numel.setFont(new Font("Georgia", Font.BOLD, 16));
        numel.setBounds(310, 670, 64, 20);
        numel.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 2, 3, new java.awt.Color(0, 153, 204)));
        this.add(numel);
        this.add(numet);
        prenumet = new JTextField("");
        prenumet.setBounds(470, 690, 150, 30);
        prenumet.setFont(new Font("Georgia", Font.BOLD, 12));
        JLabel prenumel = new JLabel("Prenume");
        prenumel.setOpaque(true);
        prenumel.setBackground(new Color(252, 242, 206));
        prenumel.setFont(new Font("Georgia", Font.BOLD, 16));
        prenumel.setBounds(520, 670, 98, 20);
        prenumel.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 2, 3, new java.awt.Color(0, 153, 204)));
        this.add(prenumel);
        this.add(prenumet);
        nr_telt = new JTextField("");
        nr_telt.setBounds(670, 690, 150, 30);
        nr_telt.setFont(new Font("Georgia", Font.BOLD, 12));
        JLabel nr_tell = new JLabel("Nr_tel");
        nr_tell.setOpaque(true);
        nr_tell.setBackground(new Color(252, 242, 206));
        nr_tell.setFont(new Font("Georgia", Font.BOLD, 16));
        nr_tell.setBounds(700, 670, 64, 20);
        nr_tell.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 2, 3, new java.awt.Color(0, 153, 204)));
        this.add(nr_tell);
        this.add(nr_telt);
        emailt = new JTextField("");
        emailt.setBounds(870, 690, 150, 30);
        emailt.setFont(new Font("Georgia", Font.BOLD, 12));
        JLabel emaill = new JLabel("E-mail");
        emaill.setOpaque(true);
        emaill.setBackground(new Color(252, 242, 206));
        emaill.setFont(new Font("Georgia", Font.BOLD, 16));
        emaill.setBounds(910, 670, 64, 20);
        emaill.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 2, 3, new java.awt.Color(0, 153, 204)));
        this.add(emaill);
        this.add(emailt);
        parolat = new JTextField("");
        parolat.setBounds(1070, 690, 150, 30);
        parolat.setFont(new Font("Georgia", Font.BOLD, 12));
        JLabel parolal = new JLabel("Parola");
        parolal.setOpaque(true);
        parolal.setBackground(new Color(252, 242, 206));
        parolal.setFont(new Font("Georgia", Font.BOLD, 16));
        parolal.setBounds(1110, 670, 64, 20);
        parolal.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 2, 3, new java.awt.Color(0, 153, 204)));
        this.add(parolal);
        this.add(parolat);
        ibant = new JTextField("");
        ibant.setBounds(50, 780, 150, 30);
        ibant.setFont(new Font("Georgia", Font.BOLD, 12));
        JLabel ibanl = new JLabel("IBAN");
        ibanl.setOpaque(true);
        ibanl.setBackground(new Color(252, 242, 206));
        ibanl.setFont(new Font("Georgia", Font.BOLD, 16));
        ibanl.setBounds(100, 760, 54, 20);
        ibanl.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 2, 3, new java.awt.Color(0, 153, 204)));
        this.add(ibanl);
        this.add(ibant);
        nr_contrt = new JTextField("");
        nr_contrt.setBounds(260, 780, 150, 30);
        nr_contrt.setFont(new Font("Georgia", Font.BOLD, 12));
        JLabel nr_contrl = new JLabel("Nr. contract");
        nr_contrl.setOpaque(true);
        nr_contrl.setBackground(new Color(252, 242, 206));
        nr_contrl.setFont(new Font("Georgia", Font.BOLD, 16));
        nr_contrl.setBounds(280, 760, 116, 20);
        nr_contrl.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 2, 3, new java.awt.Color(0, 153, 204)));
        this.add(nr_contrl);
        this.add(nr_contrt);
        data_angajariit = new JDateChooser();
        data_angajariit.setBounds(470, 780, 150, 30);
        data_angajariit.setFont(new Font("Georgia", Font.BOLD, 12));
        JLabel data_angajariil = new JLabel("Data angajarii");
        data_angajariil.setOpaque(true);
        data_angajariil.setBackground(new Color(252, 242, 206));
        data_angajariil.setFont(new Font("Georgia", Font.BOLD, 16));
        data_angajariil.setBounds(480, 760, 130, 20);
        data_angajariil.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 2, 3, new java.awt.Color(0, 153, 204)));
        this.add(data_angajariil);
        this.add(data_angajariit);
        functiet = new JTextField("");
        functiet.setBounds(670, 780, 150, 30);
        functiet.setFont(new Font("Georgia", Font.BOLD, 12));
        JLabel functiel = new JLabel("Functie");
        functiel.setOpaque(true);
        functiel.setBackground(new Color(252, 242, 206));
        functiel.setFont(new Font("Georgia", Font.BOLD, 16));
        functiel.setBounds(710, 760, 72, 20);
        functiel.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 153, 204)));
        this.add(functiel);
        this.add(functiet);

        idunitt = new JTextField("");
        idunitt.setBounds(870, 780, 150, 30);
        idunitt.setFont(new Font("Georgia", Font.BOLD, 12));
        JLabel idunitl = new JLabel("ID Unitate");
        idunitl.setOpaque(true);
        idunitl.setBackground(new Color(252, 242, 206));
        idunitl.setFont(new Font("Georgia", Font.BOLD, 16));
        idunitl.setBounds(910, 760, 100, 20);
        idunitl.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 153, 204)));
        this.add(idunitl);
        this.add(idunitt);
        ///textfields pentru inserare

        sterge = new JButton("Șterge");
        sterge.setBounds(1450, 200, 100, 50);
        sterge.setFont(new Font("Georgia", Font.BOLD, 12));
        sterge.setBackground(new Color(252, 242, 206));
        sterge.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 204)));
        sterge.setFocusPainted(false);
        this.add(sterge);

        searchl = new JLabel("Cautare ");
        searchl.setBounds(1440, 390, 80, 30);
        searchl.setFont(new Font("Georgia", Font.BOLD, 16));
        searchl.setBackground(new Color(252, 242, 206));
        searchl.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 204)));
        this.add(searchl);
        searcht = new JTextField("");
        searcht.setBounds(1400, 420, 170, 30);
        searcht.setFont(new Font("Georgia", Font.BOLD, 12));
        searcht.getDocument().addDocumentListener(new DocumentListener() {
            ////////////////////////////////////////////////////////////////////////////// casuta search tabel
            @Override
            public void insertUpdate(DocumentEvent e) {
                tab1.filter(searcht.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                tab1.filter(searcht.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                tab1.filter(searcht.getText());
            }
        });
        this.add(searcht);

        sterge.addActionListener(new ActionListener() {
            ////////////////////////////////////////////////////////////////////////////// sterge un utilizator din tabel
            public void actionPerformed(ActionEvent e) {

                selectedrow = tab1.t.getSelectedRow();
                date = ExecProc.getData(Model.c, "select u.*,a.id_unitate from utilizator u,angajat a where u.functie<>'administrator' and u.functie<>'super-administrator' and a.id=u.id;");
                header = ExecHeader.getHeader(Model.c, "select u.*,a.id_unitate from utilizator u,angajat a where u.functie<>'administrator' and u.functie<>'super-administrator' and a.id=u.id;");

                if (selectedrow >= 0) {
                    if (date.length > selectedrow) {
                        try {
                            selrow = Integer.parseInt(date[selectedrow][0]);
                            PreparedStatement s = c.prepareCall("{call stergeutilizator(?)}"); ///sterge un utilizator
                            s.setInt(1, selrow);
                            s.execute();
                            date = ExecProc.getData(Model.c, "select u.*,a.id_unitate from utilizator u,angajat a where u.functie<>'administrator' and u.functie<>'super-administrator' and a.id=u.id;");
                            header = ExecHeader.getHeader(Model.c, "select u.*,a.id_unitate from utilizator u,angajat a where u.functie<>'administrator' and u.functie<>'super-administrator' and a.id=u.id;");
                            ((DefaultTableModel) tab1.t.getModel()).setDataVector(date, header);
                            updateb.setVisible(false);
                        } catch (Exception sqe) {

                        }
                    } else if (tab1.t.getSelectedRow() >= 0) {
                        date = ExecProc.getData(Model.c, "select u.*,a.id_unitate from utilizator u,angajat a where u.functie<>'administrator' and u.functie<>'super-administrator' and a.id=u.id;");
                        header = ExecHeader.getHeader(Model.c, "select u.*,a.id_unitate from utilizator u,angajat a where u.functie<>'administrator' and u.functie<>'super-administrator' and a.id=u.id;");
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
            ////////////////////////////////////////////////////////////////////////////// modifica un utilizator in tabel
            public void actionPerformed(ActionEvent e) {
                selectedrow = tab1.t.getSelectedRow();

                try {
                    if (selectedrow >= 0) {
                        id = Integer.parseInt((tab1.t.getValueAt(selectedrow, 0)).toString());
                        cnp = (tab1.t.getValueAt(selectedrow, 1)).toString();
                        nume = (tab1.t.getValueAt(selectedrow, 2)).toString();
                        prenume = (tab1.t.getValueAt(selectedrow, 3)).toString();
                        nr_tel = (tab1.t.getValueAt(selectedrow, 4)).toString();
                        email = (tab1.t.getValueAt(selectedrow, 5)).toString();
                        parola = (tab1.t.getValueAt(selectedrow, 6)).toString();
                        iban = (tab1.t.getValueAt(selectedrow, 7)).toString();
                        nr_contr = (tab1.t.getValueAt(selectedrow, 8)).toString();
                        data_a = (tab1.t.getValueAt(selectedrow, 9)).toString();
                        functie = (tab1.t.getValueAt(selectedrow, 10)).toString();
                        idu = Integer.parseInt((tab1.t.getValueAt(selectedrow, 11)).toString());
                        CallableStatement s = c.prepareCall("{call updateutilizator(?,?,?,?,?,?,?,?,?,?,?,?)}");
                        s.setInt(1, id);
                        s.setString(2, cnp);
                        s.setString(3, nume);
                        s.setString(4, prenume);
                        s.setString(5, nr_tel);
                        s.setString(6, email);
                        s.setString(7, parola);
                        s.setString(8, iban);
                        s.setString(9, nr_contr);
                        s.setString(10, data_a);
                        s.setString(11, functie);
                        s.setInt(12, idu);
                        s.execute();
                        date = ExecProc.getData(Model.c, "select u.*,a.id_unitate from utilizator u,angajat a where u.functie<>'administrator' and u.functie<>'super-administrator' and a.id=u.id;");
                        header = ExecHeader.getHeader(Model.c, "select u.*,a.id_unitate from utilizator u,angajat a where u.functie<>'administrator' and u.functie<>'super-administrator' and a.id=u.id;");


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
        confirma.setBounds(1100, 760, 100, 50);
        confirma.setFont(new Font("Georgia", Font.BOLD, 12));
        confirma.setBackground(new Color(252, 242, 206));
        confirma.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 204)));
        confirma.setFocusPainted(false);
        confirma.addActionListener(new ActionListener() {
            ////////////////////////////////////////////////////////////////////////////// adauga un utilizator in tabel
            public void actionPerformed(ActionEvent e) {
                updateb.setVisible(false);
                try {
                    if (tab1.t.isEditing()) {
                        tab1.t.getCellEditor().stopCellEditing();
                    }

                    cnp = cnpt.getText();
                    nume = numet.getText();
                    prenume = prenumet.getText();
                    nr_tel = nr_telt.getText();
                    email = emailt.getText();
                    parola = parolat.getText();
                    iban = ibant.getText();
                    nr_contr = nr_contrt.getText();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    data_a = formatter.format(data_angajariit.getDate());
                    functie = functiet.getText();
                    idu = Integer.parseInt(idunitt.getText());
                    cnpt.setText("");
                    numet.setText("");
                    prenumet.setText("");
                    nr_telt.setText("");
                    emailt.setText("");
                    parolat.setText("");
                    ibant.setText("");
                    idunitt.setText("");
                    nr_contrt.setText("");
                    data_angajariit.setDate(null);
                    functiet.setText("");
                    if (functie.equals("administrator") || functie.equals("super-administrator"))
                        err.setVisible(true);
                    else {
                        CallableStatement s = c.prepareCall("{call adaugaInAngajat(?,?,?,?)}");

                        s.setString(1, nume);
                        s.setString(2, prenume);
                        s.setString(3, functie);
                        s.setInt(4, idu);
                        s.executeQuery();

                        PreparedStatement s2 = c.prepareStatement("select max(id) from angajat");
                        ResultSet rs2 = s2.executeQuery();
                        while (rs2.next())
                            id=rs2.getInt(1);

                        CallableStatement s1 = c.prepareCall("{call adaugaInUtiliz(?,?,?,?,?,?,?,?)}");
                        s1.setInt(1, id);
                        s1.setString(2, cnp);
                        s1.setString(3, nr_tel);
                        s1.setString(4, email);
                        s1.setString(5, parola);
                        s1.setString(6, iban);
                        s1.setString(7, nr_contr);
                        s1.setString(8, data_a);
                        s1.execute();
                        date = ExecProc.getData(Model.c, "select u.*,a.id_unitate from utilizator u,angajat a where u.functie<>'administrator' and u.functie<>'super-administrator' and a.id=u.id;");
                        header = ExecHeader.getHeader(Model.c, "select u.*,a.id_unitate from utilizator u,angajat a where u.functie<>'administrator' and u.functie<>'super-administrator' and a.id=u.id;");

                        ((DefaultTableModel) tab1.t.getModel()).setDataVector(date, header);
                    }

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
                date = ExecProc.getData(Model.c, "select u.*,a.id_unitate from utilizator u,angajat a where u.functie<>'administrator' and u.functie<>'super-administrator' and a.id=u.id;");
                header = ExecHeader.getHeader(Model.c, "select u.*,a.id_unitate from utilizator u,angajat a where u.functie<>'administrator' and u.functie<>'super-administrator' and a.id=u.id;");

                ((DefaultTableModel) tab1.t.getModel()).setDataVector(date, header);
            }
        });

        ers = new EroareStergere();
        ers.setBounds(960, 500, 300, 168);

        ers.continua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ers.setVisible(false);
                date = ExecProc.getData(Model.c, "select u.*,a.id_unitate from utilizator u,angajat a where u.functie<>'administrator' and u.functie<>'super-administrator' and a.id=u.id;");
                header = ExecHeader.getHeader(Model.c, "select u.*,a.id_unitate from utilizator u,angajat a where u.functie<>'administrator' and u.functie<>'super-administrator' and a.id=u.id;");


                ((DefaultTableModel) tab1.t.getModel()).setDataVector(date, header);
            }
        });

        logout = new JButton("Logout");
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
        adaugaprogram = new JButton("Adauga program angajat");
        adaugaprogram.setBounds(1350, 750, 220, 50);
        adaugaprogram.setFont(new Font("Georgia", Font.BOLD, 12));
        adaugaprogram.setBackground(new Color(252, 242, 206));
        adaugaprogram.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 204)));
        adaugaprogram.setFocusPainted(false);

        adaugau = new JButton("Adauga concediu");
        adaugau.setBounds(1350, 650, 220, 50);
        adaugau.setFont(new Font("Georgia", Font.BOLD, 12));
        adaugau.setBackground(new Color(252, 242, 206));
        adaugau.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 204)));
        adaugau.setFocusPainted(false);
        this.add(adaugau);
        this.add(adaugaprogram);
    }

}

