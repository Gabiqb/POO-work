package com.company;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.InsetsUIResource;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ExpertFinanciar extends JFrame {
    public JLabel photo;
    public JPanel datePersonale;
    public JPanel calcul;
    public JPanel istoric;
    public JTabbedPane tabbedPane;
    public JLabel tabel;
    public JLabel tabel2;
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
    public JLabel salariu;
    public JLabel idunitatel;
    public JLabel cautas;
    public JTextField saltrecut;
    public JButton cautass;
    public JTextField lunas;
    public JTextField ans;
    public JLabel lunasl;
    public JLabel ansl;


    public Table tab1;
    public Table tab2;
    public Table tab3;
    public Table tab4;
    public String[][] date = {{""}};
    public String[] header = {""};
    public String[] header2 = {""};
    public JLabel id;
    public JTextField idtxt;
    public JLabel data;
    public JMonthChooser cal;
    public JYearChooser ycs;
    public JLabel idu;
    public JTextField idutxt;
    public EroareInsert err;

    public JButton succes;
    public JButton confirm;
    public JButton confirm2;
    public JButton succes2;
    public JButton logout;

    public ExpertFinanciar() {
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

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Expert Financiar");
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

        titlu = new JLabel("Meniu Expert Financiar");
        titlu.setFont(font);
        titlu.setBounds(550, 10, 600, 80);
        this.add(titlu);

        tabbedPane = new JTabbedPane();
        err = new EroareInsert();
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

        tab1 = new Table(date, header);
        JScrollPane x1 = new JScrollPane(tab1.t);
        x1.setBounds(800, 50, 600, 300);

        tab1.t.setFont(font2);
        tab1.t.getTableHeader().setFont(font2);
        tab1.t.setBounds(800, 60, 600, 290);
        tab1.t.getTableHeader().setBackground(new Color(92, 143, 243));
        tab1.t.getTableHeader().setReorderingAllowed(false);
        tab1.t.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        datePersonale.add(x1);


        tab2 = new Table(date, header);
        JScrollPane x2 = new JScrollPane(tab2.t);
        x2.setBounds(800, 400, 600, 300);
        tab2.t.setBounds(800, 60, 600, 290);
        tab2.t.setFont(font2);
        tab2.t.getTableHeader().setFont(font2);
        tab2.t.getTableHeader().setBackground(new Color(92, 143, 243));
        tab2.t.getTableHeader().setReorderingAllowed(false);
        tab2.t.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        datePersonale.add(x2);

        calcul = new JPanel();
        calcul.setLayout(null);

        istoric = new JPanel();
        istoric.setLayout(null);
        istoric.setBackground(new Color(0, 77, 61));

        tabel = new JLabel("Calcul salariu");
        tabel.setForeground(Color.BLACK);
        tabel.setBounds(590, 20, 700, 100);
        tabel.setFont(font);
        calcul.add(tabel);
        calcul.setBackground(new Color(0, 77, 61));

        tabel2 = new JLabel("Istoric");
        tabel2.setForeground(Color.BLACK);
        tabel2.setBounds(590, 20, 700, 100);
        tabel2.setFont(font);

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

        dataangajare = new JLabel("Data Angajarii:");
        dataangajare.setFont(font3);
        dataangajare.setForeground(Color.BLACK);
        dataangajare.setBounds(20, 301, 800, 50);
        datePersonale.add(dataangajare);


        salariu = new JLabel("Salariu:");
        salariu.setFont(font3);
        salariu.setForeground(Color.BLACK);
        salariu.setBounds(20, 344, 800, 50);
        datePersonale.add(salariu);

        nrOre = new JLabel("Numar ore:");
        nrOre.setFont(font3);
        nrOre.setForeground(Color.BLACK);
        nrOre.setBounds(20, 387, 800, 50);
        datePersonale.add(nrOre);

        idunitatel = new JLabel("ID unitate:");
        idunitatel.setFont(font3);
        idunitatel.setForeground(Color.BLACK);
        idunitatel.setBounds(20, 430, 800, 50);
        datePersonale.add(idunitatel);


        date = ExtragereDate.getData(Model.c, "angajat");
        header = ExtragereAntet.getHeader(Model.c, "angajat");
        tab3 = new Table(date, header);
        tab3.t.setModel(new DefaultTableModel(date, header) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        });
        JScrollPane x3 = new JScrollPane(tab3.t);
        x3.setBounds(500, 200, 1000, 400);

        tab3.t.setFont(font2);
        tab3.t.getTableHeader().setFont(font2);
        tab3.t.setBounds(800, 60, 600, 290);
        tab3.t.getTableHeader().setBackground(new Color(92, 143, 243));
        tab3.t.getTableHeader().setReorderingAllowed(false);
        tab3.t.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tab3.t.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                idtxt.setText(tab3.t.getValueAt(tab3.t.getSelectedRow(), 0).toString());
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
        calcul.add(x3);


        id = new JLabel("ID angajat");
        id.setFont(font5);
        id.setForeground(Color.BLACK);
        id.setBounds(100, 250, 200, 50);

        idtxt = new JTextField();
        idtxt.setBounds(100, 300, 150, 30);
        idtxt.setBackground(new Color(119, 161, 160));
        idtxt.setForeground(Color.BLACK);
        idtxt.setFont(font4);


        confirm = new JButton("Confirma");
        confirm.setFont(font3);
        confirm.setBounds(70, 350, 250, 50);
        confirm.setForeground(Color.BLACK);
        confirm.setBackground(new Color(252, 242, 206));
        confirm.setFocusPainted(false);
        confirm.setBorderPainted(false);
        confirm.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try {
                    CallableStatement s = Model.c.prepareCall("{call calculsalariu(?,?)}");
                    s.setInt(1, Integer.parseInt(idtxt.getText()));
                    s.setInt(2, 0);
                    s.execute();
                    succes.setVisible(true);
                    Model.erlg.setVisible(false);
                    date = ExtragereDate.getData(Model.c, "angajat");
                    header = ExtragereAntet.getHeader(Model.c, "angajat");
                    ((DefaultTableModel) tab3.t.getModel()).setDataVector(date, header);

                } catch (Exception see) {
                    date = ExtragereDate.getData(Model.c, "angajat");
                    header = ExtragereAntet.getHeader(Model.c, "angajat");
                    ((DefaultTableModel) tab3.t.getModel()).setDataVector(date, header);

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
        succes.setBounds(30, 450, 200, 200);
        succes.setIcon(new ImageIcon("succes.png"));
        succes.add(suctext);
        succes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                succes.setVisible(false);
                date = ExtragereDate.getData(Model.c, "angajat");
                header = ExtragereAntet.getHeader(Model.c, "angajat");
                ((DefaultTableModel) tab3.t.getModel()).setDataVector(date, header);
            }
        });
        calcul.add(succes);
        calcul.add(confirm);
        calcul.add(id);
        calcul.add(idtxt);

        idu = new JLabel("ID unitate");
        idu.setFont(font5);
        idu.setForeground(Color.BLACK);
        idu.setBounds(100, 150, 200, 50);
        idutxt = new JTextField();
        idutxt.setBounds(100, 200, 150, 30);
        idutxt.setBackground(new Color(119, 161, 160));
        idutxt.setForeground(Color.BLACK);
        idutxt.setFont(font4);

        data = new JLabel("Luna ");
        data.setFont(font5);
        data.setForeground(Color.BLACK);
        data.setBounds(100, 250, 200, 50);

        cal = new JMonthChooser();
        cal.setBounds(100, 300, 150, 30);
        cal.setBackground(new Color(119, 161, 160));
        cal.setForeground(Color.BLACK);
        cal.setFont(font4);


        JLabel data2 = new JLabel("An");
        data2.setFont(font5);
        data2.setForeground(Color.BLACK);
        data2.setBounds(320, 250, 200, 50);

        ycs = new JYearChooser();
        ycs.setBounds(320, 300, 150, 30);
        ycs.setBackground(new Color(119, 161, 160));
        ycs.setForeground(Color.BLACK);
        ycs.setFont(font4);



        date = ExtragereDate.getData(Model.c, "istoric");
        header2 = ExtragereAntet.getHeader(Model.c, "istoric");
        tab4 = new Table(date, header2);
        tab4.t.setModel(new DefaultTableModel(date, header2) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        });
        JScrollPane x4 = new JScrollPane(tab4.t);
        x4.setBounds(500, 200, 1000, 400);

        tab4.t.setFont(font2);
        tab4.t.getTableHeader().setFont(font2);
        tab4.t.setBounds(800, 60, 600, 290);
        tab4.t.getTableHeader().setBackground(new Color(92, 143, 243));
        tab4.t.getTableHeader().setReorderingAllowed(false);
        tab4.t.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));


        confirm2 = new JButton("Confirma");
        confirm2.setFont(font3);
        confirm2.setBounds(70, 350, 250, 50);
        confirm2.setForeground(Color.BLACK);
        confirm2.setBackground(new Color(252, 242, 206));
        confirm2.setFocusPainted(false);
        confirm2.setBorderPainted(false);
        confirm2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try {
                    err.setVisible(false);
                    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM");
                    int l =cal.getMonth()+1;
                    int an=ycs.getYear();
                    CallableStatement s = Model.c.prepareCall("{call insertistoric(?,?,?)}");
                    s.setInt(1, Integer.parseInt(idutxt.getText()));
                    s.setInt(2, an);
                    s.setInt(3, l);
                    s.execute();
                    succes.setVisible(true);
                    Model.erlg.setVisible(false);
                    date = ExtragereDate.getData(Model.c, "istoric");
                    ((DefaultTableModel) tab4.t.getModel()).setDataVector(date, header2);
                    succes2.setVisible(true);

                } catch (Exception see) {
                    err.setVisible(true);
                    date = ExtragereDate.getData(Model.c, "istoric");
                    ((DefaultTableModel) tab4.t.getModel()).setDataVector(date, header2);

                }
            }
        });
        err.continua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                err.setVisible(false);
            }
        });
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
        succes2.setBounds(30, 450, 200, 200);
        succes2.setIcon(new ImageIcon("succes.png"));
        succes2.add(suctext2);
        succes2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                succes2.setVisible(false);
                date = ExtragereDate.getData(Model.c, "istoric");
                ((DefaultTableModel) tab4.t.getModel()).setDataVector(date, header2);
            }
        });
        istoric.add(ycs);
        istoric.add(data2);
        istoric.add(idu);
        istoric.add(idutxt);
        istoric.add(succes2);
        istoric.add(confirm2);
        istoric.add(cal);
        istoric.add(data);
        istoric.add(tabel2);
        istoric.add(x4);
        tabbedPane.setBounds(0, 80, 1600, 820);
        tabbedPane.setFont(font4);
        tabbedPane.setBackground(new Color(252, 242, 206));
        tabbedPane.add("Date personale", datePersonale);
        tabbedPane.add("Calcul salariu", calcul);
        tabbedPane.add("Vizualizare istoric", istoric);
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

        logout = new JButton("Logout");
        logout.setBounds(1450, 20, 100, 50);
        logout.setFont(new Font("Georgia", Font.BOLD, 13));
        logout.setBackground(new Color(216, 0, 55));
        logout.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 204)));
        logout.setFocusPainted(false);
        this.add(logout);
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
                    addText(rs.getString(11), idunitatel);
                else
                    addText(" ", idunitatel);
                Model.erlg.setVisible(false);
            }
        } catch (SQLException sqe) {
            Model.erlg.setVisible(true);
        }
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
