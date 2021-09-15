package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.InsetsUIResource;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Medic extends JFrame {
    public JLabel photo;
    public JPanel datePersonale;
    public JPanel raport;
    public JPanel rapoarte;
    public JTabbedPane tabbedPane;
    public JLabel tabel;
    public JLabel titlu;
    public JLabel nume;
    public JLabel prenume;
    public JLabel telefon;
    public JLabel email;
    public JLabel iban;
    public JLabel dataangajare;
    public JLabel cnp;
    public JLabel parola;
    public JLabel specialitate;
    public JLabel grad;
    public JLabel parafa;
    public JLabel competente;
    public JLabel titluStiintific;
    public JLabel postDidactic;
    public JLabel procent;
    public JLabel nrOre;
    public JLabel salariu;
    public JLabel idunitatem;

    public JLabel cautas;
    public JTextField saltrecut;
    public JButton cautass;
    public JTextField lunas;
    public JTextField ans;
    public JLabel lunasl;
    public JLabel ansl;


    public JLabel id;
    public JTextField idtxt;
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
    public JLabel numeAsistent;
    public JTextField numeAsistenttxt;
    public JLabel prenumeAsistent;
    public JTextField prenumeAsistenttxt;
    public JLabel dataEliberare;
    public JTextField dataEliberaretxt;
    public JLabel tipServiciu;
    public JComboBox tipServiciutxt;
    public JLabel codParafa;
    public JTextField codParafatxt;
    public JLabel simptome;
    public JTextArea simptometxt;
    public JLabel diagnostic;
    public JTextArea diagnostictxt;
    public JLabel reteta;
    public JTextArea retetatxt;
    public JButton succes;
    public JButton confirm;
    public Table tab4;
    public Table tab3;
    public Table tab1;
    public JLabel searchl;
    public JTextField searcht;
    public JLabel orarl;
    public JLabel concediil;
    public String[][] date = {{""}};
    public String[] header = {""};
    public String[][] date1 = {{""}};
    public String[] header1 = {""};
    public JButton logout;
    public JButton updateb;
    public EroareInsert err;

    public Medic() {
        initComponents();

    }


    public void addText(String text, JLabel label) {
        String text2 =label.getText().substring(0,label.getText().indexOf(':'));
        text2=text2+": "+ text;
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
        //this.add(photo);
        err = new EroareInsert();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Medic");
        this.getContentPane().setBackground(new Color(119, 161, 160));
        this.setLayout(null);
        this.pack();
        this.setSize(800, 601);
        this.setBounds(160, 100, 1600, 950);

        ClockPane c1 = new ClockPane();
        c1.setBounds(0, 0, 300, 50);
        c1.setOpaque(false);
        this.add(c1);

        ImageIcon img = new ImageIcon("icon.png");
        this.setIconImage(img.getImage());

        titlu = new JLabel("Meniu Medic");
        titlu.setFont(font);
        titlu.setBounds(600, 10, 400, 80);
        this.add(titlu);

        tabbedPane = new JTabbedPane();
        rapoarte = new JPanel();
        rapoarte.setBackground(new Color(0, 77, 61));
        rapoarte.setLayout(null);
        datePersonale = new JPanel();
        datePersonale.setBackground(new Color(0, 77, 61));
        datePersonale.setLayout(null);
        raport = new JPanel();
        raport.setLayout(null);


        cautas=new JLabel("Cauta salariu ");
        cautas.setFont(font3);
        cautas.setForeground(Color.BLACK);
        cautas.setBounds(380, 570, 800, 50);
        datePersonale.add(cautas);

        ans=new JTextField("");
        ans.setFont(font3);
        ans.setForeground(Color.BLACK);
        ans.setBounds(360, 620, 100, 30);
        datePersonale.add(ans);
        ansl=new JLabel("An");
        ansl.setFont(font3);
        ansl.setForeground(Color.BLACK);
        ansl.setBounds(300, 620, 50, 30);
        datePersonale.add(ansl);

        lunas=new JTextField("");
        lunas.setFont(font3);
        lunas.setForeground(Color.BLACK);
        lunas.setBounds(570, 620, 120, 30);
        datePersonale.add(lunas);
        lunasl=new JLabel("Luna");
        lunasl.setFont(font3);
        lunasl.setForeground(Color.BLACK);
        lunasl.setBounds(480, 620, 80, 30);
        datePersonale.add(lunasl);

        saltrecut=new JTextField("");
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
                try{
                    CallableStatement s=Model.c.prepareCall("{call verifsalariu(?,?,?,?)}");
                    s.setString(1,Model.email);
                    s.setInt(2,Integer.parseInt(lunas.getText()));
                    s.setInt(3,Integer.parseInt(ans.getText()));
                    s.execute();
                    if(s.getString(4)==null)
                        saltrecut.setText("0 LEI");
                    else
                        saltrecut.setText(s.getString(4)+" LEI");

                }
                catch(Exception se)
                {

                }
            }

        });
        datePersonale.add(cautass);
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


        tabel = new JLabel("Raport medical");
        tabel.setForeground(Color.BLACK);
        tabel.setBounds(590, 20, 700, 100);
        tabel.setFont(font);
        raport.add(tabel);
        raport.setBackground(new Color(0, 77, 61));

        nume = new JLabel("Nume:");
        nume.setFont(font3);
        nume.setForeground(Color.BLACK);
        nume.setBounds(20, 0, 800, 50);
        datePersonale.add(nume);

        prenume = new JLabel("Prenume:");
        prenume.setFont(font3);
        prenume.setForeground(Color.BLACK);
        prenume.setBounds(20, 43, 800, 50);
        datePersonale.add(prenume);

        cnp = new JLabel("CNP:");
        cnp.setFont(font3);
        cnp.setForeground(Color.BLACK);
        cnp.setBounds(20, 86, 800, 50);
        datePersonale.add(cnp);

        telefon = new JLabel("Telefon:");
        telefon.setFont(font3);
        telefon.setForeground(Color.BLACK);
        telefon.setBounds(20, 129, 800, 50);
        datePersonale.add(telefon);

        email = new JLabel("Email:");
        email.setFont(font3);
        email.setForeground(Color.BLACK);
        email.setBounds(20, 172, 800, 50);
        datePersonale.add(email);

        parola = new JLabel("Parola:");
        parola.setFont(font3);
        parola.setForeground(Color.BLACK);
        parola.setBounds(20, 215, 800, 50);
        datePersonale.add(parola);

        iban = new JLabel("IBAN:");
        iban.setFont(font3);
        iban.setForeground(Color.BLACK);
        iban.setBounds(20, 258, 800, 50);
        datePersonale.add(iban);

        specialitate = new JLabel("Specialitate:");
        specialitate.setFont(font3);
        specialitate.setForeground(Color.BLACK);
        specialitate.setBounds(20, 301, 800, 50);
        datePersonale.add(specialitate);

        dataangajare = new JLabel("Data Angajarii:");
        dataangajare.setFont(font3);
        dataangajare.setForeground(Color.BLACK);
        dataangajare.setBounds(20, 344, 800, 50);
        datePersonale.add(dataangajare);

        grad = new JLabel("Grad:");
        grad.setFont(font3);
        grad.setForeground(Color.BLACK);
        grad.setBounds(20, 387, 800, 50);
        datePersonale.add(grad);

        parafa = new JLabel("Cod parafa:");
        parafa.setFont(font3);
        parafa.setForeground(Color.BLACK);
        parafa.setBounds(20, 430, 800, 50);
        datePersonale.add(parafa);

        competente = new JLabel("Competente:");
        competente.setFont(font3);
        competente.setForeground(Color.BLACK);
        competente.setBounds(20, 473, 800, 50);
        datePersonale.add(competente);

        titluStiintific = new JLabel("Titlu stiintific:");
        titluStiintific.setFont(font3);
        titluStiintific.setForeground(Color.BLACK);
        titluStiintific.setBounds(20, 516, 800, 50);
        datePersonale.add(titluStiintific);

        postDidactic = new JLabel("Post didactic:");
        postDidactic.setFont(font3);
        postDidactic.setForeground(Color.BLACK);
        postDidactic.setBounds(20, 559, 800, 50);
        datePersonale.add(postDidactic);

        salariu = new JLabel("Salariu:");
        salariu.setFont(font3);
        salariu.setForeground(Color.BLACK);
        salariu.setBounds(20, 602, 800, 50);
        datePersonale.add(salariu);

        procent = new JLabel("Procent:");
        procent.setFont(font3);
        procent.setForeground(Color.BLACK);
        procent.setBounds(20, 645, 800, 50);
        datePersonale.add(procent);

        nrOre = new JLabel("Numar ore:");
        nrOre.setFont(font3);
        nrOre.setForeground(Color.BLACK);
        nrOre.setBounds(20, 688, 800, 50);
        datePersonale.add(nrOre);

        idunitatem = new JLabel("ID unitate:");
        idunitatem.setFont(font3);
        idunitatem.setForeground(Color.BLACK);
        idunitatem.setBounds(20, 731, 800, 50);
        datePersonale.add(idunitatem);

        id = new JLabel("ID pacient");
        id.setFont(font5);
        id.setForeground(Color.BLACK);
        id.setBounds(100, 250, 200, 50);

        idtxt = new JTextField();
        idtxt.setBounds(100, 300, 150, 30);
        idtxt.setBackground(new Color(119, 161, 160));
        idtxt.setForeground(Color.BLACK);
        idtxt.setFont(font4);

        numePacient = new JLabel("Nume pacient");
        numePacient.setFont(font5);
        numePacient.setForeground(Color.BLACK);
        numePacient.setBounds(100, 250, 200, 50);

        numePacienttxt = new JTextField();
        numePacienttxt.setBounds(100, 300, 150, 30);
        numePacienttxt.setBackground(new Color(119, 161, 160));
        numePacienttxt.setForeground(Color.BLACK);
        numePacienttxt.setFont(font4);

        prenumePacient = new JLabel("Prenume pacient");
        prenumePacient.setFont(font5);
        prenumePacient.setForeground(Color.BLACK);
        prenumePacient.setBounds(100, 350, 200, 50);

        prenumePacienttxt = new JTextField();
        prenumePacienttxt.setBounds(100, 400, 150, 30);
        prenumePacienttxt.setBackground(new Color(119, 161, 160));
        prenumePacienttxt.setForeground(Color.BLACK);
        prenumePacienttxt.setFont(font4);

        cnpPacient = new JLabel("CNP pacient");
        cnpPacient.setFont(font5);
        cnpPacient.setForeground(Color.BLACK);
        cnpPacient.setBounds(100, 450, 200, 50);

        cnpPacienttxt = new JTextField();
        cnpPacienttxt.setBounds(100, 500, 150, 30);
        cnpPacienttxt.setBackground(new Color(119, 161, 160));
        cnpPacienttxt.setForeground(Color.BLACK);
        cnpPacienttxt.setFont(font4);

        numeMedic = new JLabel("Nume medic");
        numeMedic.setFont(font5);
        numeMedic.setForeground(Color.BLACK);
        numeMedic.setBounds(100, 550, 200, 50);

        numeMedictxt = new JTextField();
        numeMedictxt.setBounds(100, 600, 150, 30);
        numeMedictxt.setBackground(new Color(119, 161, 160));
        numeMedictxt.setForeground(Color.BLACK);
        numeMedictxt.setFont(font4);

        prenumeMedic = new JLabel("Prenume medic");
        prenumeMedic.setFont(font5);
        prenumeMedic.setForeground(Color.BLACK);
        prenumeMedic.setBounds(400, 250, 200, 50);

        prenumeMedictxt = new JTextField();
        prenumeMedictxt.setBounds(400, 300, 150, 30);
        prenumeMedictxt.setBackground(new Color(119, 161, 160));
        prenumeMedictxt.setForeground(Color.BLACK);
        prenumeMedictxt.setFont(font4);

        numeAsistent = new JLabel("Nume asistent");
        numeAsistent.setFont(font5);
        numeAsistent.setForeground(Color.BLACK);
        numeAsistent.setBounds(400, 350, 200, 50);

        numeAsistenttxt = new JTextField();
        numeAsistenttxt.setBounds(400, 400, 150, 30);
        numeAsistenttxt.setBackground(new Color(119, 161, 160));
        numeAsistenttxt.setForeground(Color.BLACK);
        numeAsistenttxt.setFont(font4);

        prenumeAsistent = new JLabel("Prenume asistent");
        prenumeAsistent.setFont(font5);
        prenumeAsistent.setForeground(Color.BLACK);
        prenumeAsistent.setBounds(400, 450, 200, 50);

        prenumeAsistenttxt = new JTextField();
        prenumeAsistenttxt.setBounds(400, 500, 150, 30);
        prenumeAsistenttxt.setBackground(new Color(119, 161, 160));
        prenumeAsistenttxt.setForeground(Color.BLACK);
        prenumeAsistenttxt.setFont(font4);

        dataEliberare = new JLabel("Data eliberare");
        dataEliberare.setFont(font5);
        dataEliberare.setForeground(Color.BLACK);
        dataEliberare.setBounds(400, 550, 200, 50);

        dataEliberaretxt = new JTextField();
        dataEliberaretxt.setBounds(400, 600, 200, 30);
        dataEliberaretxt.setBackground(new Color(119, 161, 160));
        dataEliberaretxt.setForeground(Color.BLACK);
        dataEliberaretxt.setFont(font4);
        dataEliberaretxt.setEditable(false);
        dataEliberaretxt.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                dataEliberaretxt.setText(formatter.format(calendar.getTime()).toString());
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


        tipServiciu = new JLabel("Tip serviciu");
        tipServiciu.setFont(font5);
        tipServiciu.setForeground(Color.BLACK);
        tipServiciu.setBounds(700, 350, 200, 50);

        tipServiciutxt = new JComboBox(extragereServicii());
        JScrollPane ts = new JScrollPane(tipServiciutxt, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        ts.setBounds(700, 400, 180, 30);
        tipServiciutxt.setBounds(230, 270, 180, 30);
        tipServiciutxt.setBounds(700, 400, 150, 30);
        tipServiciutxt.setBackground(new Color(119, 161, 160));
        tipServiciutxt.setForeground(Color.BLACK);
        tipServiciutxt.setFont(font4);

        codParafa = new JLabel("Cod parafa");
        codParafa.setFont(font5);
        codParafa.setForeground(Color.BLACK);
        codParafa.setBounds(700, 250, 200, 50);

        codParafatxt = new JTextField();
        codParafatxt.setBounds(700, 300, 150, 30);
        codParafatxt.setBackground(new Color(119, 161, 160));
        codParafatxt.setForeground(Color.BLACK);
        codParafatxt.setEditable(false);
        codParafatxt.setFont(font4);
        codParafatxt.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    CallableStatement s = Model.c.prepareCall("{call extrpar(?,?)}");
                    s.setString(1, numeMedictxt.getText());
                    s.setString(2, prenumeMedictxt.getText());
                    ResultSet rs = s.executeQuery();

                    while (rs.next()) {
                        codParafatxt.setText(rs.getString(1));
                    }
                } catch (Exception cex) {

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

        simptome = new JLabel("Simptome");
        simptome.setFont(font5);
        simptome.setForeground(Color.BLACK);
        simptome.setBounds(700, 450, 200, 50);

        simptometxt = new JTextArea();
        simptometxt.setBounds(700, 500, 150, 30);
        simptometxt.setBackground(new Color(119, 161, 160));
        simptometxt.setForeground(Color.BLACK);
        simptometxt.setFont(font4);
        simptometxt.setLineWrap(true);
        JScrollPane p = new JScrollPane(simptometxt);
        p.setBounds(700, 500, 250, 200);

        diagnostic = new JLabel("Diagnostic");
        diagnostic.setFont(font5);
        diagnostic.setForeground(Color.BLACK);
        diagnostic.setBounds(1000, 250, 200, 50);

        diagnostictxt = new JTextArea();
        diagnostictxt.setBounds(1000, 300, 400, 200);
        diagnostictxt.setBackground(new Color(119, 161, 160));
        diagnostictxt.setForeground(Color.BLACK);
        diagnostictxt.setFont(font4);
        diagnostictxt.setLineWrap(true);
        JScrollPane p2 = new JScrollPane(diagnostictxt);
        p2.setBounds(1000, 300, 400, 200);

        reteta = new JLabel("Reteta");
        reteta.setFont(font5);
        reteta.setForeground(Color.BLACK);
        reteta.setBounds(1000, 500, 200, 50);

        retetatxt = new JTextArea();
        retetatxt.setBounds(1000, 450, 400, 200);
        retetatxt.setBackground(new Color(119, 161, 160));
        retetatxt.setForeground(Color.BLACK);
        retetatxt.setFont(font4);
        retetatxt.setLineWrap(true);
        JScrollPane p3 = new JScrollPane(retetatxt);
        p3.setBounds(1000, 545, 400, 200);

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

                    CallableStatement s = Model.c.prepareCall("{call insertraport(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                    s.setString(1, numePacienttxt.getText());
                    s.setString(2, prenumePacienttxt.getText());
                    s.setString(3, cnpPacienttxt.getText());
                    s.setString(4, numeMedictxt.getText());
                    s.setString(5, prenumeMedictxt.getText());
                    s.setString(6, numeAsistenttxt.getText());
                    s.setString(7, prenumeAsistenttxt.getText());
                    s.setString(8, dataEliberaretxt.getText());
                    s.setString(9, tipServiciutxt.getSelectedItem().toString());
                    s.setString(10, simptometxt.getText());
                    s.setString(11, diagnostictxt.getText());
                    s.setString(12, retetatxt.getText());
                    s.setString(13, codParafatxt.getText());//
                    s.execute();
                    numePacienttxt.setText("");
                    prenumePacienttxt.setText("");
                    cnpPacienttxt.setText("");
                    numeMedictxt.setText("");
                    prenumeMedictxt.setText("");
                    numeAsistenttxt.setText("");
                    prenumeAsistenttxt.setText("");
                    dataEliberaretxt.setText("");

                    codParafatxt.setText("");
                    simptometxt.setText("");
                    diagnostictxt.setText("");
                    retetatxt.setText("");
                    succes.setVisible(true);
                    Model.erlg.setVisible(false);
                    date = ExecProc.getData(Model.c, "select * from raport");
                    tab1.t.setModel(new DefaultTableModel(date, header1));
                } catch (Exception sqe) {
                    Model.erlg.setVisible(true);
                    try {
                        try {
                            String id = "";
                            CallableStatement s = Model.c.prepareCall("call selectraportid();");
                            ResultSet rs = s.executeQuery();
                            while (rs.next()) {
                                id = rs.getString(1);
                            }
                            if (id == null)
                                tabel.setText("Raport medical #" + "1");
                            else
                                tabel.setText("Raport medical #" + id);

                        } catch (Exception ex) {

                        }
                        CallableStatement s2 = Model.c.prepareCall("call deleteraport();");
                        s2.executeQuery();
                    } catch (Exception ersc) {

                    }
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
                    CallableStatement s = Model.c.prepareCall("call selectraportid();");
                    ResultSet rs = s.executeQuery();
                    while (rs.next()) {
                        id = rs.getString(1);
                    }
                    if (id == null)
                        tabel.setText("Raport medical #" + "1");
                    else
                        tabel.setText("Raport medical #" + id);

                    date = ExecProc.getData(Model.c, "select * from raport");
                    tab1.t.setModel(new DefaultTableModel(date, header1));
                } catch (Exception ex) {

                }
            }
        });
        raport.add(succes);
        raport.add(confirm);
        raport.add(numePacienttxt);
        raport.add(numePacient);
        raport.add(prenumePacienttxt);
        raport.add(prenumePacient);
        raport.add(cnpPacienttxt);
        raport.add(cnpPacient);
        raport.add(numeMedictxt);
        raport.add(numeMedic);
        raport.add(prenumeMedictxt);
        raport.add(prenumeMedic);
        raport.add(numeAsistenttxt);
        raport.add(numeAsistent);
        raport.add(prenumeAsistenttxt);
        raport.add(prenumeAsistent);
        raport.add(dataEliberare);
        raport.add(dataEliberaretxt);
        raport.add(tipServiciu);
        raport.add(ts);
        raport.add(codParafa);
        raport.add(codParafatxt);
        raport.add(simptome);
        raport.add(p);
        raport.add(diagnostic);
        raport.add(p2);
        raport.add(reteta);
        raport.add(p3);

        updateb = new JButton("Confirmi modificarea?");
        updateb.setBounds(100, 100, 160, 50);
        updateb.setFont(new Font("Georgia", Font.BOLD, 12));
        updateb.setBackground(new Color(252, 242, 206));
        updateb.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 204)));
        updateb.setFocusPainted(false);
        updateb.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int selectedrow = tab1.t.getSelectedRow();

                String nume_pac, prenume_pac, cnp_pac, nume_m, prenume_m, nume_asis, prenume_asis, simp, diag, tip_serv, reteta;
                int id = 0;
                try {
                    if (selectedrow >= 0) {
                        id = Integer.parseInt((tab1.t.getValueAt(selectedrow, 0)).toString());
                        nume_pac = (tab1.t.getValueAt(selectedrow, 1)).toString();
                        prenume_pac = (tab1.t.getValueAt(selectedrow, 2)).toString();
                        cnp_pac = (tab1.t.getValueAt(selectedrow, 3)).toString();
                        nume_m = (tab1.t.getValueAt(selectedrow, 4)).toString();
                        prenume_m = (tab1.t.getValueAt(selectedrow, 5)).toString();
                        nume_asis = (tab1.t.getValueAt(selectedrow, 6)).toString();
                        prenume_asis = (tab1.t.getValueAt(selectedrow, 7)).toString();
                        simp = (tab1.t.getValueAt(selectedrow, 9)).toString();
                        diag = (tab1.t.getValueAt(selectedrow, 10)).toString();
                        tip_serv = (tab1.t.getValueAt(selectedrow, 11)).toString();
                        reteta = (tab1.t.getValueAt(selectedrow, 12)).toString();

                        CallableStatement s = Model.c.prepareCall("{call updateraport(?,?,?,?,?,?,?,?,?,?,?,?)}");

                        s.setInt(1, id);
                        s.setString(2, nume_pac);
                        s.setString(3, prenume_pac);
                        s.setString(4, cnp_pac);
                        s.setString(5, nume_m);
                        s.setString(6, prenume_m);
                        s.setString(7, nume_asis);
                        s.setString(8, prenume_asis);
                        s.setString(9, simp);
                        s.setString(10, diag);
                        s.setString(11, tip_serv);
                        s.setString(12, reteta);
                        s.execute();
                        date = ExecProc.getData(Model.c, "select * from raport");
                        tab1.t.setModel(new DefaultTableModel(date, header1));

                    }
                } catch (Exception sqe) {
                    err.setVisible(true);
                }
                updateb.setVisible(false);
            }

        });
        updateb.setVisible(false);
        rapoarte.add(updateb);


        header1 = ExtragereAntet.getHeader(Model.c, "raport");
        date1 = ExtragereDate.getData(Model.c, "raport");
        tab1 = new Table(date1, header1);

        tab1.setBounds(550, 250, 1000, 20);

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
        rapoarte.addMouseMotionListener(new MouseMotionListener() {
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
        JScrollPane x1 = new JScrollPane(tab1.t);
        x1.setBounds(50, 350, 1500, 300);
        rapoarte.add(x1);
        tab1.t.setPreferredScrollableViewportSize(new Dimension(1277, 17));
        tab1.t.setModel(new DefaultTableModel(date1, header1));

        tab1.t.setFont(font2);
        tab1.t.getTableHeader().setFont(font2);
        tab1.t.getTableHeader().setBackground(new Color(92, 143, 243));
        tab1.t.getTableHeader().setReorderingAllowed(false);
        tab1.t.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        searchl = new JLabel("Cautare raport ");
        searchl.setBounds(950, 250, 170, 30);
        searchl.setOpaque(true);
        searchl.setFont(new Font("Georgia", Font.BOLD, 16));
        searchl.setBackground(new Color(252, 242, 206));
        searchl.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 204)));
        searcht = new JTextField("");
        searcht.setBounds(950, 300, 170, 30);
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
        rapoarte.add(searchl);
        rapoarte.add(searcht);

        logout = new JButton("Logout");
        logout.setBounds(1450, 20, 100, 50);
        logout.setFont(new Font("Georgia", Font.BOLD, 13));
        logout.setBackground(new Color(216, 0, 55));
        logout.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 204)));
        logout.setFocusPainted(false);
        this.add(logout);
        tabbedPane.setBounds(0, 80, 1600, 820);
        tabbedPane.setFont(font4);
        tabbedPane.setBackground(new Color(252, 242, 206));
        tabbedPane.add("Date personale", datePersonale);
        tabbedPane.add("Raport", raport);
        tabbedPane.add("Rapoarte existente", rapoarte);
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
        tabbedPane.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tabbedPane.getSelectedIndex() == 1) {
                    try {
                        String id = "";
                        CallableStatement s = Model.c.prepareCall("call selectraportid();");
                        ResultSet rs = s.executeQuery();
                        while (rs.next()) {
                            id = rs.getString(1);
                        }
                        if (id == null)
                            tabel.setText("Raport medical #" + "1");
                        else
                            tabel.setText("Raport medical #" + id);

                    } catch (Exception ex) {

                    }
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
        this.add(tabbedPane);


    }

    public void adaugadate(Connection c) {
        try {
            CallableStatement ps = c.prepareCall("call getMedic(?)");
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
                    addText(rs.getString(8), specialitate);
                else
                    addText(" ", specialitate);
                if (!(rs.getString(9) == null))
                    addText(rs.getString(9), dataangajare);
                else
                    addText(" ", dataangajare);
                if (!(rs.getString(10) == null))
                    addText(rs.getString(10), grad);
                else
                    addText(" ", grad);
                if (!(rs.getString(11) == null))
                    addText(rs.getString(11), parafa);
                else
                    addText(" ", parafa);
                if (!(rs.getString(12) == null))
                    addText(rs.getString(12), competente);
                else
                    addText(" ", competente);
                if (!(rs.getString(13) == null))
                    addText(rs.getString(13), titluStiintific);
                else
                    addText(" ", titluStiintific);
                if (!(rs.getString(14) == null))
                    addText(rs.getString(14), postDidactic);
                else
                    addText(" ", postDidactic);
                if (!(rs.getString(15) == null))
                    addText(rs.getString(15), salariu);
                else
                    addText(" ", salariu);
                if (!(rs.getString(16) == null))
                    addText(rs.getString(16), procent);
                else
                    addText(" ", procent);
                if (!(rs.getString(17) == null))
                    addText(rs.getString(17), nrOre);
                else
                    addText(" ", idunitatem);
                if (!(rs.getString(18) == null))
                    addText(rs.getString(18), idunitatem);
                else
                    addText(" ", idunitatem);
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
