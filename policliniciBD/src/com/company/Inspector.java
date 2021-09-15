package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.InsetsUIResource;
import javax.swing.table.DefaultTableModel;

public class Inspector extends JFrame {

    public JPanel datepers;
    public JPanel cautaang;
    public JPanel nujce;
    public JLabel firstLabel;
    public JTabbedPane tabbedPane;
    JLabel insp = new JLabel("Inspector");
    public JLabel nume1;
    public JLabel prenume1;
    public JLabel functie1;
    public JLabel cauta;
    public JLabel id;
    public JLabel nume;
    public JLabel prenume;
    public JLabel salariu;
    public JLabel nrore;
    public JLabel idunit;
    public JLabel cnp;
    public JLabel nrtel;
    public JLabel email;
    public JLabel parola;
    public JLabel iban;
    public JLabel nr_contract;
    public JLabel dataang;
    public JTextField numee;
    public JTextField prenumee;
    public JTextField functiee;
    public JButton cautare;
    public JButton cautare2;
    public JLabel cautaorar;
    public JLabel orar;
    public JLabel concediu;
    public JButton logout;
    public JLabel numeo;
    public JLabel prenumeo;
    public JLabel ido;
    public JTextField idxt;
    public JTextField numetx;
    public JTextField prenumetx;
    public JLabel cautas;
    public JTextField saltrecut;
    public JButton cautass;
    public JTextField lunas;
    public JTextField ans;
    public JLabel lunasl;
    public JLabel ansl;
    Table tab1;
    String[][] date = {{""}};
    String[] header = {""};

    Table tab2;
    String[][] date2 = {{""}};
    String[] header2 = {""};

    Table tab3;
    String[][] date3 = {{""}};
    String[] header3 = {""};

    public Inspector() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); initializare();
    }

    public void addText(String text, JLabel label) {
        String text2 =label.getText().substring(0,label.getText().indexOf(':'));
        text2=text2+": "+ text;
        label.setText(text2);
    }


    public void adaugadate(Connection c) {
        try {
            CallableStatement ps = c.prepareCall("call getInspector(?)");
            ps.setString(1, Model.email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (!(rs.getString(1) == null))
                    addText(rs.getString(1), id);
                else
                    addText(" ", id);
                if (!(rs.getString(2) == null))
                    addText(rs.getString(2), nume);
                else
                    addText(" ", nume);
                if (!(rs.getString(3) == null))
                    addText(rs.getString(3), prenume);
                else
                    addText(" ", prenume);
                if (!(rs.getString(4) == null))
                    addText(rs.getString(4), cnp);
                else
                    addText(" ", cnp);
                if (!(rs.getString(5) == null))
                    addText(rs.getString(5), nrtel);
                else
                    addText(" ", nrtel);
                if (!(rs.getString(6) == null))
                    addText(rs.getString(6), email);
                else
                    addText(" ", email);
                if (!(rs.getString(7) == null))
                    addText(rs.getString(7), parola);
                else
                    addText(" ", parola);
                if (!(rs.getString(8) == null))
                    addText(rs.getString(8), iban);
                else
                    addText(" ", iban);
                if (!(rs.getString(9) == null))
                    addText(rs.getString(9), nr_contract);
                else
                    addText(" ", nr_contract);
                if (!(rs.getString(10) == null))
                    addText(rs.getString(10), dataang);
                else
                    addText(" ", dataang);
                if (!(rs.getString(11) == null))
                    addText(rs.getString(11), salariu);
                else
                    addText(" ", salariu);
                if (!(rs.getString(12) == null))
                    addText(rs.getString(12), nrore);
                else
                    addText(" ", nrore);
                if (!(rs.getString(13) == null))
                    addText(rs.getString(13), idunit);
                else
                    addText(" ", idunit);

                Model.erlg.setVisible(false);
            }
        } catch (SQLException sqe) {
            Model.erlg.setVisible(true);
        }
    }


    public void initializare() {

        Font font1 = new Font("Georgia", Font.BOLD, 40);
        Font font2 = new Font("Georgia", Font.BOLD, 12);
        Font font3 = new Font("Georgia", Font.BOLD, 28);
        Font font4 = new Font("Georgia", Font.BOLD, 14);
        Font font5 = new Font("Georgia", Font.BOLD, 25);
        datepers = new JPanel();
        cautas=new JLabel("Cauta salariu ");
        cautas.setFont(font3);
        cautas.setForeground(Color.BLACK);
        cautas.setBounds(700, 550, 800, 50);
        datepers.add(cautas);
        firstLabel = new JLabel();
        firstLabel.setBounds(850, 0, 700, 700);
        ImageIcon img12 = new ImageIcon("inspector.png");
        Image resized2 = img12.getImage();
        Image newimg2 = resized2.getScaledInstance(700, 700, Image.SCALE_SMOOTH);
        ImageIcon newicon2 = new ImageIcon(newimg2);
        firstLabel.setIcon(newicon2);
        datepers.add(firstLabel);

        ans=new JTextField("");
        ans.setFont(font3);
        ans.setForeground(Color.BLACK);
        ans.setBounds(650, 600, 100, 30);
        datepers.add(ans);
        ansl=new JLabel("An");
        ansl.setFont(font3);
        ansl.setForeground(Color.BLACK);
        ansl.setBounds(600, 600, 50, 30);
        datepers.add(ansl);

        lunas=new JTextField("");
        lunas.setFont(font3);
        lunas.setForeground(Color.BLACK);
        lunas.setBounds(870, 600, 120, 30);
        datepers.add(lunas);
        lunasl=new JLabel("Luna");
        lunasl.setFont(font3);
        lunasl.setForeground(Color.BLACK);
        lunasl.setBounds(790, 600, 80, 30);
        datepers.add(lunasl);

        saltrecut=new JTextField("");
        saltrecut.setFont(font3);
        saltrecut.setEditable(false);
        saltrecut.setForeground(Color.BLACK);
        saltrecut.setBounds(750, 640, 150, 30);
        datepers.add(saltrecut);


        cautass = new JButton("Cauta");
        cautass.setBounds(800, 690, 60, 50);
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
        datepers.add(cautass);

        cautaang = new JPanel();
        nujce = new JPanel();
        ImageIcon img = new ImageIcon("icon.png");

        header = ExtragereAntet.getHeader(Model.c, "angajat");
        tab1 = new Table(date, header);
        tab1.t.setModel(new DefaultTableModel(date,header){
            @Override
            public boolean isCellEditable(int row,int col)
            {
                return false;
            }
        });
        tab1.setBounds(150, 400, 1290, 45);

        JScrollPane x = new JScrollPane(tab1.t);
        x.setBounds(150, 400, 1325, 40);

        tab1.t.setPreferredScrollableViewportSize(new Dimension(1277, 17));
        cautaang.add(x);


        header= ExecHeader.getHeader(Model.c, "select b.id,b.nume,b.prenume,a.zi_lucru,a.ora_inceput,a.ora_final,a.locatie,a.concediu from program_angajat a,angajat b;");
        tab2 = new Table(date, header);
        tab2.t.setModel(new DefaultTableModel(date,header){
            @Override
            public boolean isCellEditable(int row,int col)
            {
                return false;
            }
        });
        tab2.setBounds(150, 300, 1290, 20);

        JScrollPane x2 = new JScrollPane(tab2.t);
        x2.setBounds(150, 280, 1325, 180);
        nujce.add(x2);
        tab2.t.setPreferredScrollableViewportSize(new Dimension(1325, 17));

        header = ExecHeader.getHeader(Model.c, "select b.id,b.nume,b.prenume,a.data_incepere_concediu,a.data_finalizare_concediu from concedii a,angajat b;");
        tab3 = new Table(date, header);
       tab3.t.setModel(new DefaultTableModel(date,header){
            @Override
            public boolean isCellEditable(int row,int col)
            {
                return false;
            }
        });
        tab3.setBounds(150, 550, 1290, 20);
        JScrollPane x3 = new JScrollPane(tab3.t);
        x3.setBounds(150, 550, 1325, 150);
        nujce.add(x3);
        tab3.t.setPreferredScrollableViewportSize(new Dimension(1277, 17));
        ido = new JLabel("ID angajat: ");


        ido.setFont(font5);
        ido.setForeground(Color.BLACK);
        ido.setBounds(300, 140, 800, 50);
        nujce.add(ido);


        idxt = new JTextField();
        idxt.setBounds(450, 150, 150, 30);
        idxt.setBackground(new Color(119, 161, 160));
        idxt.setForeground(Color.BLACK);
        idxt.setFont(font4);
        nujce.add(idxt);

        tab1.t.setFont(font2);
        tab1.t.getTableHeader().setFont(font2);
        tab1.t.getTableHeader().setBackground(new Color(92, 143, 243));
        tab1.t.getTableHeader().setReorderingAllowed(false);
        tab1.t.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        tab2.t.setFont(font2);
        tab2.t.getTableHeader().setFont(font2);
        tab2.t.getTableHeader().setBackground(new Color(92, 143, 243));
        tab2.t.getTableHeader().setReorderingAllowed(false);
        tab2.t.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        nujce.add(tab2);

        tab3.t.setFont(font2);
        tab3.t.getTableHeader().setFont(font2);
        tab3.t.getTableHeader().setBackground(new Color(92, 143, 243));
        tab3.t.getTableHeader().setReorderingAllowed(false);
        tab3.t.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        nujce.add(tab3);

        cautaorar = new JLabel("Cauta orar angajat:");
        cautaorar.setFont(font3);
        cautaorar.setForeground(Color.BLACK);
        cautaorar.setBounds(200, 50, 800, 50);
        nujce.add(cautaorar);


        orar = new JLabel("Orar angajat:");
        orar.setFont(font3);
        orar.setForeground(Color.BLACK);
        orar.setBounds(200, 220, 800, 50);
        nujce.add(orar);

        concediu = new JLabel("Concedii angajat:");
        concediu.setFont(font3);
        concediu.setForeground(Color.BLACK);
        concediu.setBounds(200, 485, 800, 50);
        nujce.add(concediu);

        cautare = new JButton("Cauta");
        cautare.setBounds(800, 200, 120, 60);
        cautare.setFocusPainted(false);
        cautaang.add(cautare);

        cautare2 = new JButton("Cauta");
        cautare2.setBounds(800, 140, 120, 60);
        cautare2.setFocusPainted(false);
        nujce.add(cautare2);


        nume1 = new JLabel("Nume: ");
        prenume1 = new JLabel("Prenume: ");
        functie1 = new JLabel("Functie: ");

        nume1.setFont(font5);
        nume1.setForeground(Color.BLACK);
        nume1.setBounds(300, 150, 800, 50);
        cautaang.add(nume1);

        numee = new JTextField();
        numee.setBounds(400, 160, 150, 30);
        numee.setBackground(new Color(119, 161, 160));
        numee.setForeground(Color.BLACK);
        numee.setFont(font4);
        cautaang.add(numee);

        prenume1.setFont(font5);
        prenume1.setForeground(Color.BLACK);
        prenume1.setBounds(300, 210, 800, 50);
        cautaang.add(prenume1);

        prenumee = new JTextField();
        prenumee.setBounds(440, 220, 150, 30);
        prenumee.setBackground(new Color(119, 161, 160));
        prenumee.setForeground(Color.BLACK);
        prenumee.setFont(font4);
        cautaang.add(prenumee);

        functie1.setFont(font5);
        functie1.setForeground(Color.BLACK);
        functie1.setBounds(300, 270, 800, 50);
        cautaang.add(functie1);

        functiee = new JTextField();
        functiee.setBounds(415, 280, 150, 30);
        functiee.setBackground(new Color(119, 161, 160));
        functiee.setForeground(Color.BLACK);
        functiee.setFont(font4);
        cautaang.add(functiee);

        ClockPane c1 = new ClockPane();
        c1.setBounds(0, 0, 300, 50);
        c1.setOpaque(false);
        this.add(c1);

        insp.setFont(font1);
        insp.setBounds(700, 25, 300, 100);

        this.setTitle("Inspector");
        this.setLayout(null);
        this.setBounds(0, 0, 1600, 900);


        this.getContentPane().setBackground(new Color(0, 134, 179));
        this.setIconImage(img.getImage());

        cauta = new JLabel("Cauta angajat:");
        cauta.setFont(font3);
        cauta.setForeground(Color.BLACK);
        cauta.setBounds(200, 50, 800, 50);
        cautaang.add(cauta);

        datepers.setBackground(new Color(128, 51, 0));
        datepers.setLayout(null);

        cautaang.setBackground(new Color(128, 51, 0));
        cautaang.setLayout(null);

        nujce.setBackground(new Color(128, 51, 0));
        nujce.setLayout(null);

        id = new JLabel("ID:");
        id.setFont(font3);
        id.setForeground(Color.BLACK);
        id.setBounds(30, 50, 800, 50);
        datepers.add(id);

        nume = new JLabel("Nume:");
        nume.setFont(font3);
        nume.setForeground(Color.BLACK);
        nume.setBounds(30, 100, 800, 50);
        datepers.add(nume);

        prenume = new JLabel("Prenume:");
        prenume.setFont(font3);
        prenume.setForeground(Color.BLACK);
        prenume.setBounds(30, 150, 800, 50);
        datepers.add(prenume);

        cnp = new JLabel("CNP:");
        cnp.setFont(font3);
        cnp.setForeground(Color.BLACK);
        cnp.setBounds(30, 200, 800, 50);
        datepers.add(cnp);

        nrtel = new JLabel("Nr. telefon:");
        nrtel.setFont(font3);
        nrtel.setForeground(Color.BLACK);
        nrtel.setBounds(30, 250, 800, 50);
        datepers.add(nrtel);

        email = new JLabel("Email:");
        email.setFont(font3);
        email.setForeground(Color.BLACK);
        email.setBounds(30, 300, 800, 50);
        datepers.add(email);

        parola = new JLabel("Parola:");
        parola.setFont(font3);
        parola.setForeground(Color.BLACK);
        parola.setBounds(30, 350, 800, 50);
        datepers.add(parola);

        iban = new JLabel("Iban:");
        iban.setFont(font3);
        iban.setForeground(Color.BLACK);
        iban.setBounds(30, 400, 800, 50);
        datepers.add(iban);

        nr_contract = new JLabel("Nr. contract:");
        nr_contract.setFont(font3);
        nr_contract.setForeground(Color.BLACK);
        nr_contract.setBounds(30, 450, 800, 50);
        datepers.add(nr_contract);

        dataang = new JLabel("Data angajarii:");
        dataang.setFont(font3);
        dataang.setForeground(Color.BLACK);
        dataang.setBounds(30, 500, 800, 50);
        datepers.add(dataang);

        salariu = new JLabel("Salariu:");
        salariu.setFont(font3);
        salariu.setForeground(Color.BLACK);
        salariu.setBounds(30, 550, 800, 50);
        datepers.add(salariu);

        nrore = new JLabel("Nr. ore:");
        nrore.setFont(font3);
        nrore.setForeground(Color.BLACK);
        nrore.setBounds(30, 600, 800, 50);
        datepers.add(nrore);

        idunit = new JLabel("ID unitate:");
        idunit.setFont(font3);
        idunit.setForeground(Color.BLACK);
        idunit.setBounds(30, 650, 800, 50);
        datepers.add(idunit);

        cautare.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try {

                    String[][] matr=ExecProc.getData(Model.c, "call cautaAngajat('"+numee.getText()+"','"+prenumee.getText()+"','"+functiee.getText()+"')");

                    numee.setText("");
                    prenumee.setText("");
                    functiee.setText("");

                    String vect[] = ExtragereAntet.getHeader(Model.c, "angajat");

                    ((DefaultTableModel) tab1.t.getModel()).setDataVector(matr, vect);
                } catch (Exception sqe) {
                    Model.erlg.setVisible(true);
                }
            }
        });


        cautare2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try {
                    date = ExecProc.getData(Model.c, "select b.id,b.nume,b.prenume,a.zi_lucru,a.ora_inceput,a.ora_final,a.locatie,a.concediu from program_angajat a,angajat b where a.ID_angajat=b.id and b.id=" + Integer.parseInt(idxt.getText()) + " and a.id_angajat=" + Integer.parseInt(idxt.getText()));
                    header= ExecHeader.getHeader(Model.c, "select b.id,b.nume,b.prenume,a.zi_lucru,a.ora_inceput,a.ora_final,a.locatie,a.concediu from program_angajat a,angajat b where a.ID_angajat=b.id and b.id=" + Integer.parseInt(idxt.getText()) + " and a.id_angajat=" + Integer.parseInt(idxt.getText()));
                    ((DefaultTableModel) tab2.t.getModel()).setDataVector(date, header);

                    date = ExecProc.getData(Model.c, "	select b.id,b.nume,b.prenume,a.data_incepere_concediu,a.data_finalizare_concediu from concedii a,angajat b where a.id=b.id and b.id=" + Integer.parseInt(idxt.getText()) + " and a.id=" + Integer.parseInt(idxt.getText()));
                    header = ExecHeader.getHeader(Model.c, "select b.id,b.nume,b.prenume,a.data_incepere_concediu,a.data_finalizare_concediu from concedii a,angajat b where a.id=b.id and b.id=" + Integer.parseInt(idxt.getText()) + " and a.id=" + Integer.parseInt(idxt.getText()));
                    ((DefaultTableModel) tab3.t.getModel()).setDataVector(date, header);

                } catch (Exception sqe) {
                    Model.erlg.setVisible(true);
                }
            }
        });
        logout = new JButton("Logout");
        logout.setBounds(1450, 20, 100, 50);
        logout.setFont(new Font("Georgia", Font.BOLD, 13));
        logout.setBackground(new Color(216, 0, 55));
        logout.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 204)));
        logout.setFocusPainted(false);
        this.add(logout);

        tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(-10, 80, 1600, 820);
        tabbedPane.setFont(font4);
        tabbedPane.setBackground(new Color(252, 242, 206));
        tabbedPane.add("Date personale", datepers);
        tabbedPane.add("Cautare", cautaang);
        tabbedPane.add("Informatii angajati", nujce);
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

        this.add(insp);
    }
}
