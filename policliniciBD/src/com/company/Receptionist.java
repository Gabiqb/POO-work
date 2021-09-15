package com.company;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.InsetsUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Receptionist extends JFrame {
    public JLabel photo;
    public JLabel orarl;
    public JLabel concediil;
    public JPanel datePersonale;
    public JPanel programarel;
    public JPanel chitanta;
    public JTabbedPane tabbedPane;
    public JLabel tabel;
    public JLabel chit;
    public JLabel titlu;
    public JLabel nume;
    public JLabel prenume;
    public JLabel telefon;
    public JLabel email;
    public JLabel iban;
    public JLabel dataangajare;
    public JLabel cnp;
    public JLabel parola;
    public JLabel nrOre;
    public JLabel idunita;
    public JLabel salariu;
    public JDateChooser cl;
    public JLabel tabrap;

    public JLabel cautas;
    public JTextField saltrecut;
    public JButton cautass;
    public JTextField lunas;
    public JTextField ans;
    public JLabel lunasl;
    public JLabel ansl;

    public JLabel numePacient;
    public JTextField numePacienttxt;
    public JLabel prenumePacient;
    public JTextField prenumePacienttxt;
    public JLabel cnpPacient;
    public JTextField cnpPacienttxt;
    public JLabel numeMedic;
    public JTextField numeMedictxt;
    public JLabel prenumeMedic;
    public JTextField prenumeMedictxt;
    public JLabel dataProgramarii;
    public JTextField dataProgramariitxt;
    public JLabel tipServiciu;
    public JComboBox tipServiciutxt;
    public JLabel tipServiciu2;
    public JComboBox tipServiciutxt2;
    public JLabel prets;
    public JTextField pretstxt;

    public JLabel intervalorar;
    public JTextField intervalorartxt;

    public JLabel datael;
    public JTextField dataeltxt;
    public JLabel idunit;
    public JTextField idunittxt;
    public JLabel idrap2;
    public JTextField idrap2txt;

    public JButton succes2;
    public JButton succes;
    public JButton confirm;
    public JButton sterge;
    public JButton emitere;
    public JButton logout;

    public Table tab1;
    public Table tab2;
    public Table tabr;
    public String[][] date = {{""}};
    public String[] header = {""};
    public JLabel searchl;
    public JTextField searcht;
    public JLabel searchl2;
    public JTextField searcht2;
    public JTextField searchtr;

    public Table tab4;
    public Table tab3;


    public Receptionist() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();

    }


    public void addText(String text, JLabel label) {
        String text2 = label.getText().substring(0, label.getText().indexOf(':'));
        text2 = text2 + ": " + text;
        label.setText(text2);
    }


    public void initComponents() {
        Font font2 = new Font("Georgia", Font.BOLD, 12);
        Font font = new Font("Georgia", Font.BOLD, 48);
        Font font3 = new Font("Georgia", Font.BOLD, 28);
        Font font4 = new Font("Georgia", Font.BOLD, 14);
        Font font5 = new Font("Georgia", Font.BOLD, 20);

        photo = new JLabel();
        ImageIcon img2 = new ImageIcon("medic.png");
        Image resized = img2.getImage();
        Image newimg = resized.getScaledInstance(75, 80, Image.SCALE_SMOOTH);
        ImageIcon newicon = new ImageIcon(newimg);
        photo.setIcon(newicon);
        photo.setBounds(1200, 10, 80, 80);


        this.setTitle("Receptionist");
        this.getContentPane().setBackground(new Color(119, 161, 160));
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

        titlu = new JLabel("Meniu Receptionist");
        titlu.setFont(font);
        titlu.setBounds(550, 10, 600, 80);
        this.add(titlu);

        tabbedPane = new JTabbedPane();
        datePersonale = new JPanel();
        datePersonale.setBackground(new Color(0, 77, 61));
        datePersonale.setLayout(null);

        cautas = new JLabel("Cauta salariu ");
        cautas.setFont(font3);
        cautas.setForeground(Color.BLACK);
        cautas.setBounds(380, 570, 800, 50);
        datePersonale.add(cautas);

        ans = new JTextField("");
        ans.setFont(font3);
        ans.setForeground(Color.BLACK);
        ans.setBounds(360, 620, 100, 30);
        datePersonale.add(ans);
        ansl = new JLabel("An");
        ansl.setFont(font3);
        ansl.setForeground(Color.BLACK);
        ansl.setBounds(300, 620, 50, 30);
        datePersonale.add(ansl);

        lunas = new JTextField("");
        lunas.setFont(font3);
        lunas.setForeground(Color.BLACK);
        lunas.setBounds(570, 620, 120, 30);
        datePersonale.add(lunas);
        lunasl = new JLabel("Luna");
        lunasl.setFont(font3);
        lunasl.setForeground(Color.BLACK);
        lunasl.setBounds(480, 620, 80, 30);
        datePersonale.add(lunasl);

        saltrecut = new JTextField("");
        saltrecut.setFont(font3);
        saltrecut.setEditable(false);
        saltrecut.setForeground(Color.BLACK);
        saltrecut.setBounds(450, 660, 150, 30);
        datePersonale.add(saltrecut);


        cautass = new JButton("Cauta");
        cautass.setBounds(460, 700, 60, 50);
        cautass.setFont(new Font("Georgia", Font.BOLD, 12));
        cautass.setBackground(new Color(252, 242, 206));
        cautass.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 204)));
        cautass.setFocusPainted(false);
        cautass.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    CallableStatement s = Model.c.prepareCall("{call verifsalariu(?,?,?,?)}");
                    s.setString(1, Model.email);
                    s.setInt(2, Integer.parseInt(lunas.getText()));
                    s.setInt(3, Integer.parseInt(ans.getText()));
                    s.execute();
                    if(s.getString(4)==null)
                        saltrecut.setText("0 LEI");
                    else
                        saltrecut.setText(s.getString(4)+" LEI");

                } catch (Exception se) {

                }
            }

        });
        datePersonale.add(cautass);
        programarel = new JPanel();
        programarel.setLayout(null);
        programarel.setBackground(new Color(0, 77, 61));
        tabel = new JLabel("Programare ");
        tabel.setForeground(Color.BLACK);
        tabel.setBounds(620, 20, 700, 100);
        tabel.setFont(font);
        programarel.add(tabel);

        chitanta = new JPanel();
        chitanta.setLayout(null);
        chitanta.setBackground(new Color(0, 77, 61));

        nume = new JLabel("Nume:");
        nume.setFont(font3);
        nume.setForeground(Color.BLACK);
        nume.setBounds(35, 50, 800, 50);
        datePersonale.add(nume);

        prenume = new JLabel("Prenume:");
        prenume.setFont(font3);
        prenume.setForeground(Color.BLACK);
        prenume.setBounds(35, 100, 800, 50);
        datePersonale.add(prenume);

        cnp = new JLabel("CNP:");
        cnp.setFont(font3);
        cnp.setForeground(Color.BLACK);
        cnp.setBounds(35, 150, 800, 50);
        datePersonale.add(cnp);

        telefon = new JLabel("Telefon:");
        telefon.setFont(font3);
        telefon.setForeground(Color.BLACK);
        telefon.setBounds(35, 200, 800, 50);
        datePersonale.add(telefon);

        email = new JLabel("Email:");
        email.setFont(font3);
        email.setForeground(Color.BLACK);
        email.setBounds(35, 250, 800, 50);
        datePersonale.add(email);

        parola = new JLabel("Parola:");
        parola.setFont(font3);
        parola.setForeground(Color.BLACK);
        parola.setBounds(35, 300, 800, 50);
        datePersonale.add(parola);

        iban = new JLabel("IBAN:");
        iban.setFont(font3);
        iban.setForeground(Color.BLACK);
        iban.setBounds(35, 350, 800, 50);
        datePersonale.add(iban);

        dataangajare = new JLabel("Data Angajarii:");
        dataangajare.setFont(font3);
        dataangajare.setForeground(Color.BLACK);
        dataangajare.setBounds(35, 400, 800, 50);
        datePersonale.add(dataangajare);

        salariu = new JLabel("Salariu:");
        salariu.setFont(font3);
        salariu.setForeground(Color.BLACK);
        salariu.setBounds(35, 450, 800, 50);
        datePersonale.add(salariu);

        nrOre = new JLabel("Numar ore:");
        nrOre.setFont(font3);
        nrOre.setForeground(Color.BLACK);
        nrOre.setBounds(35, 500, 800, 50);
        datePersonale.add(nrOre);

        idunita = new JLabel("ID unitate:");
        idunita.setFont(font3);
        idunita.setForeground(Color.BLACK);
        idunita.setBounds(35, 550, 800, 50);
        datePersonale.add(idunita);

        numePacient = new JLabel("Nume pacient");
        numePacient.setFont(font5);
        numePacient.setForeground(Color.BLACK);
        numePacient.setBounds(50, 20, 200, 50);

        numePacienttxt = new JTextField();
        numePacienttxt.setBounds(50, 70, 150, 30);
        numePacienttxt.setBackground(new Color(119, 161, 160));
        numePacienttxt.setForeground(Color.BLACK);
        numePacienttxt.setFont(font4);

        prenumePacient = new JLabel("Prenume pacient");
        prenumePacient.setFont(font5);
        prenumePacient.setForeground(Color.BLACK);
        prenumePacient.setBounds(50, 120, 200, 50);

        prenumePacienttxt = new JTextField();
        prenumePacienttxt.setBounds(50, 170, 150, 30);
        prenumePacienttxt.setBackground(new Color(119, 161, 160));
        prenumePacienttxt.setForeground(Color.BLACK);
        prenumePacienttxt.setFont(font4);

        cnpPacient = new JLabel("CNP pacient");
        cnpPacient.setFont(font5);
        cnpPacient.setForeground(Color.BLACK);
        cnpPacient.setBounds(50, 220, 200, 50);

        cnpPacienttxt = new JTextField();
        cnpPacienttxt.setBounds(50, 270, 150, 30);
        cnpPacienttxt.setBackground(new Color(119, 161, 160));
        cnpPacienttxt.setForeground(Color.BLACK);
        cnpPacienttxt.setFont(font4);

        numeMedic = new JLabel("Nume medic");
        numeMedic.setFont(font5);
        numeMedic.setForeground(Color.BLACK);
        numeMedic.setBounds(50, 320, 200, 50);

        numeMedictxt = new JTextField();
        numeMedictxt.setBounds(50, 370, 150, 30);
        numeMedictxt.setBackground(new Color(119, 161, 160));
        numeMedictxt.setForeground(Color.BLACK);
        numeMedictxt.setFont(font4);

        prenumeMedic = new JLabel("Prenume medic");
        prenumeMedic.setFont(font5);
        prenumeMedic.setForeground(Color.BLACK);
        prenumeMedic.setBounds(50, 420, 200, 50);

        prenumeMedictxt = new JTextField();
        prenumeMedictxt.setBounds(50, 470, 150, 30);
        prenumeMedictxt.setBackground(new Color(119, 161, 160));
        prenumeMedictxt.setForeground(Color.BLACK);
        prenumeMedictxt.setFont(font4);

        dataProgramarii = new JLabel("Data programarii");
        dataProgramarii.setFont(font5);
        dataProgramarii.setForeground(Color.BLACK);
        dataProgramarii.setBounds(250, 20, 200, 50);

        cl = new JDateChooser();
        cl.setBounds(250, 70, 150, 30);
        cl.setOpaque(true);
        cl.setBackground(new Color(119, 161, 160));
        cl.setForeground(Color.BLACK);
        cl.setFont(font4);
        programarel.add(cl);

        intervalorar = new JLabel("Interval orar");
        intervalorar.setFont(font5);
        intervalorar.setForeground(Color.BLACK);
        intervalorar.setBounds(250, 120, 200, 50);

        intervalorartxt = new JTextField();
        intervalorartxt.setBounds(250, 170, 150, 30);
        intervalorartxt.setBackground(new Color(119, 161, 160));
        intervalorartxt.setForeground(Color.BLACK);
        intervalorartxt.setFont(font4);

        tipServiciu = new JLabel("Tip serviciu");
        tipServiciu.setFont(font5);
        tipServiciu.setForeground(Color.BLACK);
        tipServiciu.setBounds(250, 220, 200, 50);

        String[] serv1 = extragereServicii();

        tipServiciutxt = new JComboBox(serv1);
        JScrollPane ts = new JScrollPane(tipServiciutxt, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        ts.setBounds(230, 270, 180, 30);

        tipServiciutxt.setBounds(230, 220, 180, 30);
        tipServiciutxt.setVisible(true);
        tipServiciutxt.setBackground(new Color(119, 161, 160));
        tipServiciutxt.setForeground(Color.BLACK);
        tipServiciutxt.setFont(font4);

        programarel.add(tipServiciu);
        programarel.add(ts);


        confirm = new JButton("Confirma");
        confirm.setFont(font3);
        confirm.setBounds(650, 150, 250, 50);
        confirm.setForeground(Color.BLACK);
        confirm.setBackground(new Color(252, 242, 206));
        confirm.setFocusPainted(false);
        confirm.setBorderPainted(false);
        confirm.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try {
                    CallableStatement s1 = Model.c.prepareCall("select a.id_unitate from angajat a,utilizator u where a.id=u.id and u.email='" + Model.email + "';");
                    ResultSet rs = s1.executeQuery();
                    String idu = "";
                    while (rs.next()) {
                        idu = rs.getString(1);
                    }
                    CallableStatement s = Model.c.prepareCall("{call insertprogramare(?,?,?,?,?,?,?,?,?)}");
                    s.setString(1, numePacienttxt.getText());
                    s.setString(2, prenumePacienttxt.getText());
                    s.setString(3, cnpPacienttxt.getText());
                    s.setString(4, numeMedictxt.getText());
                    s.setString(5, prenumeMedictxt.getText());
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    s.setString(6, format.format(cl.getDate()));
                    s.setString(7, intervalorartxt.getText());
                    s.setString(8, tipServiciutxt.getSelectedItem().toString());
                    s.setString(9, idu);
                    s.execute();
                    numePacienttxt.setText("");
                    prenumePacienttxt.setText("");
                    cnpPacienttxt.setText("");
                    numeMedictxt.setText("");
                    prenumeMedictxt.setText("");
                    tipServiciutxt.setSelectedIndex(1);
                    cl.setDate(null);
                    intervalorartxt.setText("");
                    succes.setVisible(true);
                    header = ExecHeader.getHeader(Model.c, "select id,id_unitate as 'id_unit',Nume_Pacient as 'Nume_p' ,Prenume_pacient as 'Prenume_p',cnp as 'CNP_p', Nume_medic as 'Nume_m',Prenume_medic as 'Pren_m',data_programarii as 'data_prog',interval_orar as 'i_orar',tip_serviciu as 'serviciu' from programari");
                    date = ExecProc.getData(Model.c, "select id,id_unitate as 'id_unit',Nume_Pacient as 'Nume_p' ,Prenume_pacient as 'Prenume_p',cnp as 'CNP_p', Nume_medic as 'Nume_m',Prenume_medic as 'Pren_m',data_programarii as 'data_prog',interval_orar as 'i_orar',tip_serviciu as 'serviciu' from programari");
                    ((DefaultTableModel) tab1.t.getModel()).setDataVector(date, header);
                    Model.erlg.setVisible(false);
                } catch (Exception sqe) {
                    Model.erlg.setVisible(true);

                }
            }
        });
        succes = new JButton();
        succes.setLayout(null);
        JLabel suctext = new JLabel("<html>&ensp;&ensp;&ensp;Date introduse.<br>&ensp;&ensp;Click pentru a continua");
        suctext.setFont(new Font("Georgia", Font.BOLD, 15));
        suctext.setBounds(0, 160, 200, 40);
        suctext.setBackground(new Color(234, 224, 119));
        suctext.setOpaque(true);
        succes.setVisible(false);
        succes.setOpaque(false);
        succes.setBorderPainted(true);
        succes.setFocusPainted(false);
        succes.setContentAreaFilled(false);
        succes.setBounds(1100, 30, 200, 200);
        succes.setIcon(new ImageIcon("succes.png"));
        succes.add(suctext);
        succes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                succes.setVisible(false);
                try {
                    String id = "";
                    CallableStatement s = Model.c.prepareCall("call selectprogramareid();");
                    ResultSet rs = s.executeQuery();
                    while (rs.next()) {
                        id = rs.getString(1);
                    }
                    if (id == null)
                        tabel.setText("Programare #" + "1");
                    else
                        tabel.setText("Programare #" + id);

                } catch (Exception ex) {

                }
            }
        });
        header = ExecHeader.getHeader(Model.c, "select id,id_unitate as 'id_unit',Nume_Pacient as 'Nume_p' ,Prenume_pacient as 'Prenume_p',cnp as 'CNP_p', Nume_medic as 'Nume_m',Prenume_medic as 'Pren_m',data_programarii as 'data_prog',interval_orar as 'i_orar',tip_serviciu as 'serviciu' from programari");
        date = ExecProc.getData(Model.c, "select id,id_unitate as 'id_unit',Nume_Pacient as 'Nume_p' ,Prenume_pacient as 'Prenume_p',cnp as 'CNP_p', Nume_medic as 'Nume_m',Prenume_medic as 'Pren_m',data_programarii as 'data_prog',interval_orar as 'i_orar',tip_serviciu as 'serviciu' from programari");
        tab1 = new Table(date, header);
        tab1.t.setModel(new DefaultTableModel(date, header) {
            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }
        });
        tab1.setBounds(230, 380, 660, 320);
        tab1.t.setPreferredScrollableViewportSize(new Dimension(600, 290));
        JScrollPane x = new JScrollPane(tab1.t);
        x.setBounds(240, 390, 640, 300);
        searchl = new JLabel("Cautare programare ");
        searchl.setBounds(455, 300, 178, 30);
        searchl.setOpaque(true);
        searchl.setFont(new Font("Georgia", Font.BOLD, 16));
        searchl.setBackground(new Color(252, 242, 206));
        searchl.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 153, 204)));
        programarel.add(searchl);
        searcht = new JTextField("");
        searcht.setBounds(460, 340, 170, 30);
        searcht.setBackground(new Color(119, 161, 160));

        searcht.setFont(new Font("Georgia", Font.BOLD, 12));
        searcht.getDocument().addDocumentListener(new DocumentListener() {

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
        sterge = new JButton("Șterge");
        sterge.setBounds(700, 300, 100, 50);
        sterge.setFont(new Font("Georgia", Font.BOLD, 15));
        sterge.setBackground(new Color(252, 242, 206));
        sterge.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 153, 204)));
        sterge.setFocusPainted(false);
        sterge.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                int selectedrow = tab1.t.getSelectedRow();
                date = ExecProc.getData(Model.c, "select id,id_unitate as 'id_unit',Nume_Pacient as 'Nume_p' ,Prenume_pacient as 'Nume_p',cnp as 'CNP_p', Nume_medic as 'Nume_m',Prenume_medic as 'Prenume_m',data_programarii as 'data_prog',interval_orar as 'i_orar',tip_serviciu as 'serviciu' from programari");
                if (selectedrow >= 0) {
                    if (date.length > selectedrow) {
                        try {
                            int id = 1;
                            int selrow = Integer.parseInt(date[selectedrow][0]);
                            PreparedStatement s = Model.c.prepareCall("{call stergeprog(?)}"); ///sterge un utilizator
                            s.setInt(1, selrow);
                            ResultSet rs = s.executeQuery();
                            while (rs.next()) {
                                id = rs.getInt(1);
                            }
                            if (id == 1)
                                tabel.setText("Programare # 1");
                            else {

                                tabel.setText(String.format("Programare #%d", id));
                            }

                            date = ExecProc.getData(Model.c, "select id,id_unitate as 'id_unit',Nume_Pacient as 'Nume_p' ,Prenume_pacient as 'Prenume_p',cnp as 'CNP_p', Nume_medic as 'Nume_m',Prenume_medic as 'Pren_m',data_programarii as 'data_prog',interval_orar as 'i_orar',tip_serviciu as 'serviciu' from programari");
                            ((DefaultTableModel) tab1.t.getModel()).setDataVector(date, header);

                        } catch (Exception sqe) {

                        }
                    } else if (tab1.t.getSelectedRow() >= 0) {

                        date = ExecProc.getData(Model.c, "select id,id_unitate as 'id_unit',Nume_Pacient as 'Nume_p' ,Prenume_pacient as 'Prenume_p',cnp as 'CNP_p', Nume_medic as 'Nume_m',Prenume_medic as 'Pren_m',data_programarii as 'data_prog',interval_orar as 'i_orar',tip_serviciu as 'serviciu' from programari");
                        ((DefaultTableModel) tab1.t.getModel()).setDataVector(date, header);
                    }
                }
            }

        });

        header = ExecHeader.getHeader(Model.c, "select a.nume,a.prenume,p.zi_lucru,p.ora_inceput,p.ora_final,p.locatie,m.specialitate,m.grad,p.concediu from program_angajat p,angajat a,medic m where (m.id=a.id and m.id=p.id_angajat) or (p.id_angajat=a.id)");
        date = ExecProc.getData(Model.c, "select a.nume,a.prenume,p.zi_lucru,p.ora_inceput,p.ora_final,p.locatie,m.specialitate,m.grad,p.concediu from program_angajat p,angajat a,medic m where (m.id=a.id and m.id=p.id_angajat) or (p.id_angajat=a.id)");
        tab2 = new Table(date, header);
        tab2.setBounds(900, 380, 660, 320);
        tab2.t.setModel(new DefaultTableModel(date, header) {
            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }
        });
        JScrollPane x1 = new JScrollPane(tab2.t);
        x1.setBounds(910, 390, 640, 300);
        searchl2 = new JLabel("Cautare program");
        searchl2.setBounds(1170, 300, 150, 30);
        searchl2.setOpaque(true);
        searchl2.setFont(new Font("Georgia", Font.BOLD, 16));
        searchl2.setBackground(new Color(252, 242, 206));
        searchl2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 153, 204)));
        searcht2 = new JTextField("");
        searcht2.setBounds(1160, 340, 170, 30);
        searcht2.setBackground(new Color(119, 161, 160));
        searcht2.setFont(new Font("Georgia", Font.BOLD, 12));
        searcht2.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                tab2.filter(searcht2.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                tab2.filter(searcht2.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                tab2.filter(searcht2.getText());
            }
        });
        programarel.add(sterge);
        programarel.add(searcht);
        programarel.add(x);
        programarel.add(tab1);
        programarel.add(searchl2);
        programarel.add(searcht2);
        programarel.add(x1);
        programarel.add(tab2);
        tab2.t.setPreferredScrollableViewportSize(new Dimension(640, 290));

        programarel.add(succes);
        programarel.add(confirm);
        programarel.add(numePacienttxt);
        programarel.add(numePacient);
        programarel.add(prenumePacienttxt);
        programarel.add(prenumePacient);
        programarel.add(cnpPacienttxt);
        programarel.add(cnpPacient);
        programarel.add(numeMedictxt);
        programarel.add(numeMedic);
        programarel.add(prenumeMedictxt);
        programarel.add(prenumeMedic);
        programarel.add(intervalorar);
        programarel.add(intervalorartxt);
        programarel.add(dataProgramarii);


        tab3 = new Table(date, header);
        JScrollPane x3 = new JScrollPane(tab3.t);
        x3.setBounds(800, 50, 600, 300);

        tab3.t.setFont(font2);
        tab3.t.getTableHeader().setFont(font2);
        tab3.t.setBounds(800, 60, 600, 290);
        tab3.t.getTableHeader().setBackground(new Color(92, 143, 243));
        tab3.t.getTableHeader().setReorderingAllowed(false);
        tab3.t.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        datePersonale.add(x3);


        tab4 = new Table(date, header);
        JScrollPane x4 = new JScrollPane(tab4.t);
        x4.setBounds(800, 400, 600, 300);
        tab4.t.setBounds(800, 60, 600, 290);
        tab4.t.setFont(font2);
        tab4.t.getTableHeader().setFont(font2);
        tab4.t.getTableHeader().setBackground(new Color(92, 143, 243));
        tab4.t.getTableHeader().setReorderingAllowed(false);
        tab4.t.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        datePersonale.add(x4);

        orarl = new JLabel("Orar");
        orarl.setFont(new Font("Georgia", Font.BOLD, 30));
        orarl.setForeground(Color.BLACK);
        orarl.setBounds(1050, 0, 800, 50);
        datePersonale.add(orarl);

        concediil = new JLabel("Concedii");
        concediil.setFont(new Font("Georgia", Font.BOLD, 30));
        concediil.setForeground(Color.BLACK);
        concediil.setBounds(1030, 350, 800, 50);
        datePersonale.add(concediil);


        header = ExecHeader.getHeader(Model.c, "select id,nume_pacient,prenume_pacient,cnp_pacient,tip_serviciu,id_programare,id_unitate from raport");
        date = ExecProc.getData(Model.c, "select id,nume_pacient,prenume_pacient,cnp_pacient,tip_serviciu,id_programare,id_unitate from raport");
        tabr = new Table(date, header);
        tabr.setBounds(850, 420, 720, 320);
        tabr.t.setPreferredScrollableViewportSize(new Dimension(700, 290));

        tabr.t.setModel(new DefaultTableModel(date, header) {
            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }
        });
        JScrollPane xr = new JScrollPane(tabr.t);
        xr.setBounds(860, 430, 690, 300);


        tabr.t.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                idrap2txt.setText(tabr.t.getValueAt(tabr.t.getSelectedRow(), 0).toString());
                idunittxt.setText(tabr.t.getValueAt(tabr.t.getSelectedRow(),6).toString());
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


        emitere = new JButton("Emitere");
        emitere.setFont(font3);
        emitere.setBounds(650, 150, 250, 50);
        emitere.setForeground(Color.BLACK);
        emitere.setBackground(new Color(252, 242, 206));
        emitere.setFocusPainted(false);
        emitere.setBorderPainted(false);

        tabrap = new JLabel("Cautare raport");
        tabrap.setBounds(1129, 320, 130, 30);
        tabrap.setOpaque(true);
        tabrap.setFont(new Font("Georgia", Font.BOLD, 16));
        tabrap.setBackground(new Color(252, 242, 206));
        tabrap.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 153, 204)));
        searchtr = new JTextField("");
        searchtr.setBounds(1110, 370, 170, 30);
        searchtr.setFont(new Font("Georgia", Font.BOLD, 12));
        searchtr.setBackground(new Color(119, 161, 160));


        searchtr.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                tabr.filter(searchtr.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                tabr.filter(searchtr.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                tabr.filter(searchtr.getText());
            }
        });
        chit = new JLabel("Chitanta ");
        chit.setForeground(Color.BLACK);
        chit.setBounds(620, 20, 700, 100);
        chit.setFont(font);


        tipServiciu2 = new JLabel("Tip serviciu");
        tipServiciu2.setFont(font5);
        tipServiciu2.setForeground(Color.BLACK);
        tipServiciu2.setBounds(100, 220, 200, 50);

        tipServiciutxt2 = new JComboBox(serv1);

        JScrollPane ts2 = new JScrollPane(tipServiciutxt2, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        ts2.setBounds(100, 270, 180, 30);
        tipServiciutxt2.setBounds(100, 270, 180, 30);
        tipServiciutxt2.setBackground(new Color(119, 161, 160));
        tipServiciutxt2.setForeground(Color.BLACK);
        tipServiciutxt2.setFont(font4);
        tipServiciutxt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CallableStatement s1 = Model.c.prepareCall("select a.id_unitate from angajat a,utilizator u where a.id=u.id and u.email='" + Model.email + "';");
                    ResultSet rs = s1.executeQuery();
                    int idu = 0;
                    while (rs.next()) {
                        idu = rs.getInt(1);
                    }

                    String si = tipServiciutxt2.getSelectedItem().toString();
                    PreparedStatement s2 = Model.c.prepareStatement("select pret from servicii_medicale where tip_serviciu='" + si + "' and id_unitate=" + idu + ";");
                    rs = s2.executeQuery();
                    while (rs.next()) {
                        pretstxt.setText(rs.getString(1));
                    }

                } catch (Exception sq) {

                }
            }
        });


        datael = new JLabel("Data eliberare");
        datael.setFont(font5);
        datael.setForeground(Color.BLACK);
        datael.setBounds(100, 100, 200, 50);

        dataeltxt = new JTextField();
        dataeltxt.setBounds(100, 150, 200, 30);
        dataeltxt.setBackground(new Color(119, 161, 160));
        dataeltxt.setForeground(Color.BLACK);
        dataeltxt.setFont(font4);
        dataeltxt.setEditable(false);
        dataeltxt.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                dataeltxt.setText(formatter.format(calendar.getTime()).toString());
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
        idunit = new JLabel("ID unitate");
        idunit.setFont(font5);
        idunit.setForeground(Color.BLACK);
        idunit.setBounds(100, 320, 200, 50);

        idunittxt = new JTextField();
        idunittxt.setBounds(100, 370, 200, 30);
        idunittxt.setBackground(new Color(119, 161, 160));
        idunittxt.setForeground(Color.BLACK);
        idunittxt.setFont(font4);
        idunittxt.setEditable(false);



        prets = new JLabel("Pret");
        prets.setFont(font5);
        prets.setForeground(Color.BLACK);
        prets.setBounds(100, 420, 200, 50);

        pretstxt = new JTextField();
        pretstxt.setBounds(100, 470, 200, 30);
        pretstxt.setBackground(new Color(119, 161, 160));
        pretstxt.setForeground(Color.BLACK);
        pretstxt.setFont(font4);
        pretstxt.setEditable(false);

        idrap2 = new JLabel("ID raport");
        idrap2.setFont(font5);
        idrap2.setForeground(Color.BLACK);
        idrap2.setBounds(100, 520, 200, 50);

        idrap2txt = new JTextField();
        idrap2txt.setBounds(100, 570, 200, 30);
        idrap2txt.setBackground(new Color(119, 161, 160));
        idrap2txt.setForeground(Color.BLACK);
        idrap2txt.setFont(font4);
        idrap2txt.setEditable(false);

        succes2 = new JButton();
        succes2.setLayout(null);
        JLabel suctext2 = new JLabel("<html>&ensp;&ensp;&ensp;Date introduse.<br>&ensp;&ensp;Click pentru a continua");
        suctext2.setFont(new Font("Georgia", Font.BOLD, 15));
        suctext2.setBounds(0, 160, 200, 40);
        suctext2.setBackground(new Color(234, 224, 119));
        suctext2.setOpaque(true);
        succes2.setVisible(false);
        succes2.setOpaque(false);
        succes2.setBorderPainted(true);
        succes2.setFocusPainted(false);
        succes2.setContentAreaFilled(false);
        succes2.setBounds(1100, 30, 200, 200);
        succes2.setIcon(new ImageIcon("succes.png"));
        succes2.add(suctext);
        succes2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                succes2.setVisible(false);
                try {
                    String id = "";
                    CallableStatement s = Model.c.prepareCall("call selectchitantaid();");
                    ResultSet rs = s.executeQuery();
                    while (rs.next()) {
                        id = rs.getString(1);
                    }
                    if (id == null)
                        chit.setText("Chitanta #" + "1");
                    else
                        chit.setText("Chitanta  #" + id);
                }
                catch(Exception se)
                {

                }
            }
        });

        emitere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idc = 0;
                    PreparedStatement s1 = Model.c.prepareStatement("select id_chitanta from raport where id=" + Integer.parseInt(idrap2txt.getText()));
                    ResultSet rs = s1.executeQuery();
                    while (rs.next()) {
                        idc = rs.getInt(1);
                    }
                    CallableStatement s = Model.c.prepareCall("{call insertchitanta(?,?,?,?,?,?)}");
                    s.setInt(1, idc);
                    s.setString(2, dataeltxt.getText());
                    s.setString(3, tipServiciutxt2.getSelectedItem().toString());
                    s.setInt(4, Integer.parseInt(idunittxt.getText()));
                    s.setInt(5, Integer.parseInt(pretstxt.getText()));
                    s.setInt(6, Integer.parseInt(idrap2txt.getText()));
                    s.execute();
                    dataeltxt.setText("");
                    tipServiciutxt2.setSelectedItem(1);
                    idunittxt.setText("");
                    pretstxt.setText("");
                    idrap2txt.setText("");
                    header = ExecHeader.getHeader(Model.c, "select id,nume_pacient,prenume_pacient,cnp_pacient,tip_serviciu,id_programare,id_unitate from raport");
                    date = ExecProc.getData(Model.c, "select id,nume_pacient,prenume_pacient,cnp_pacient,tip_serviciu,id_programare,id_unitate from raport");
                    ((DefaultTableModel) tabr.t.getModel()).setDataVector(date, header);
                    Model.erlg.setVisible(false);
                    succes.setVisible(true);
                    String id = "";
                    s = Model.c.prepareCall("call selectchitantaid();");
                    rs = s.executeQuery();
                    succes2.setVisible(true);
                    while (rs.next()) {
                        id = rs.getString(1);
                    }
                    if(id==null)
                        chit.setText("Chitanta #" + "1");
                    else
                        chit.setText("Chitanta  #" + id);
                } catch (Exception sqe) {
                    Model.erlg.setVisible(true);

                }
            }
        });

        chitanta.add(succes2);
        chitanta.add(idrap2);
        chitanta.add(idrap2txt);
        chitanta.add(prets);
        chitanta.add(pretstxt);
        chitanta.add(idunit);
        chitanta.add(idunittxt);
        chitanta.add(datael);
        chitanta.add(dataeltxt);
        chitanta.add(tipServiciu2);
        chitanta.add(ts2);
        chitanta.add(chit);
        chitanta.add(xr);
        chitanta.add(tabr);
        chitanta.add(emitere);
        chitanta.add(tabrap);
        chitanta.add(searchtr);
        tabbedPane.setBounds(0, 80, 1600, 820);
        tabbedPane.setFont(font4);
        tabbedPane.setBackground(new Color(252, 242, 206));
        tabbedPane.add("Date personale", datePersonale);
        tabbedPane.add("Programare", programarel);
        tabbedPane.add("Emitere chitanta", chitanta);
        logout = new JButton("Logout");
        logout.setBounds(1450, 20, 100, 50);
        logout.setFont(new Font("Georgia", Font.BOLD, 13));
        logout.setBackground(new Color(216, 0, 55));
        logout.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 204)));
        logout.setFocusPainted(false);
        this.add(logout);
        UIManager.put("TabbedPane.contentBorderInsets", new InsetsUIResource(2, 0, 0, 0));
        UIManager.put("TabbedPane.focus", new ColorUIResource(new Color(252, 242, 206)));
        UIManager.put("TabbedPane.selected", new ColorUIResource(new Color(252, 242, 206)));
        UIManager.put("TabbedPane.darkShadow", new ColorUIResource(Color.BLACK));
        UIManager.put("TabbedPane.borderHightlightColor", new ColorUIResource(Color.BLACK));
        UIManager.put("TabbedPane.light", new ColorUIResource(Color.WHITE));
        UIManager.put("TabbedPane.tabAreaBackground", new ColorUIResource(Color.BLUE));
        UIManager.put("ToolTip.background", Color.BLUE);
        UIManager.put("ToolTip.border", new BorderUIResource(new LineBorder(Color.BLACK)));
        tabbedPane.updateUI();

        this.add(tabbedPane);


    }

    public void adaugadate(Connection c) {
        try {
            CallableStatement ps = c.prepareCall("call getExp(?)");
            ps.setString(1, Model.email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (!(rs.getString(1) == null))
                    addText(rs.getString(1), nume);
                else
                    addText(" ", nume);
                if (!(rs.getString(2) == null))
                    addText(rs.getString(2), prenume);
                else
                    addText(" ", prenume);
                if (!(rs.getString(3) == null))
                    addText(rs.getString(3), cnp);
                else
                    addText(" ", cnp);
                if (!(rs.getString(4) == null))
                    addText(rs.getString(4), telefon);
                else
                    addText(" ", telefon);
                if (!(rs.getString(5) == null))
                    addText(rs.getString(5), email);
                else
                    addText(" ", email);
                if (!(rs.getString(6) == null))
                    addText(rs.getString(6), parola);
                else
                    addText(" ", parola);
                if (!(rs.getString(7) == null))
                    addText(rs.getString(7), iban);
                else
                    addText(" ", iban);

                if (!(rs.getString(8) == null))
                    addText(rs.getString(8), dataangajare);
                else
                    addText(" ", dataangajare);
                if (!(rs.getString(9) == null))
                    addText(rs.getString(9), salariu);
                else
                    addText(" ", salariu);
                if (!(rs.getString(10) == null))
                    addText(rs.getString(10), nrOre);
                else
                    addText(" ", nrOre);
                if (!(rs.getString(11) == null))
                    addText(rs.getString(11), idunita);
                else
                    addText(" ", idunita);
                Model.erlg.setVisible(false);
            }
        } catch (SQLException sqe) {
            Model.erlg.setVisible(true);
        }
    }

    public String[] extragereServicii() {

        try {
            PreparedStatement s = Model.c.prepareStatement("Select tip_serviciu from servicii_medicale;");
            ResultSet rs = s.executeQuery();
            int nrc = 0;
            while (rs.next()) {
                nrc++;
            }
            String a[] = new String[nrc];
            rs.close();
            rs = s.executeQuery();
            int i = 0;
            while (rs.next()) {
                a[i] = rs.getString(1);
                i++;
            }
            return a;
        } catch (Exception sqe) {

        }
        return null;
    }

    public int getId() {
        int id = 0;
        try {
            PreparedStatement st = Model.c.prepareStatement("select id from utilizator where email='" + Model.email + "';");
            ResultSet rsr = st.executeQuery();
            while (rsr.next()) {
                id = rsr.getInt(1);
            }
        } catch (Exception sss) {

        }
        return id;
    }
}
