package com.company;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.InsetsUIResource;
import javax.swing.table.DefaultTableModel;

public class Asistent extends JFrame {

    public JPanel datepers;
    public JPanel rapoarte;
    public JTabbedPane tabbedPane;
    public JLabel asist;
    public JLabel nume;
    public JLabel prenume;
    public JLabel email;
    public JLabel iban;
    public JLabel cnp;
    public JLabel parola;
    public JLabel id;
    public JLabel nr_contract;
    public JLabel dataang;
    public JLabel nrtel;
    public JLabel salariu;
    public JLabel nrore;
    public JLabel idunit;
    public JLabel tip;
    public JLabel grad;
    public JLabel orarl;
    public JLabel concediil;
    public JLabel rapoartel;
    public JLabel cautas;
    public JTextField saltrecut;
    public JButton cautass;
    public JTextField lunas;
    public JTextField ans;
    public JLabel lunasl;
    public JLabel ansl;
    public JButton updateb;
    public String[][] date;
    public EroareInsert err;
    public JLabel searchl;
    public JTextField searcht;

    public int selectedrow = 0;


    public Table tab1;
    public String[][] date1 = {{""}};
    public String[] header1 = {""};

    public Table tab2;
    public String[][] date2 = {{""}};
    public String[] header2 = {""};
    public Table tab3;
    public String[][] date3 = {{""}};
    public String[] header3 = {""};
    public JButton logout;

    public Asistent() {
               initializare();
    }

    public void addText(String text, JLabel label) {
        String text2 =label.getText().substring(0,label.getText().indexOf(':'));
        text2=text2+": "+ text;
        label.setText(text2);
    }

    ////////////////////////////////////////////////////////////////////////////// adauga date personale
    public void adaugadate(Connection c) {
        try {
            CallableStatement ps = c.prepareCall("call getAsistent(?)");
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
                    addText(" ", tip);
                if (!(rs.getString(11) == null))
                    addText(rs.getString(11), tip);
                else
                    addText(" ", tip);
                if (!(rs.getString(12) == null))
                    addText(rs.getString(12), grad);
                else
                    addText(" ", grad);
                if (!(rs.getString(13) == null))
                    addText(rs.getString(13), salariu);
                else
                    addText(" ", salariu);
                if (!(rs.getString(14) == null))
                    addText(rs.getString(14), nrore);
                else
                    addText(" ", nrore);
                if (!(rs.getString(15) == null))
                    addText(rs.getString(15), idunit);
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
        Font font3 = new Font("Georgia", Font.BOLD, 23);
        Font font4 = new Font("Georgia", Font.BOLD, 14);
        Font font5 = new Font("Georgia", Font.BOLD, 25);
        Font font6 = new Font("Georgia", Font.BOLD, 30);
        ////////////////////////////////////////////////////////////////////////////// initializare frame

        this.setLayout(null);
        this.setBounds(100, 100, 1600, 900);
        this.getContentPane().setBackground(new Color(179, 255, 217));
        this.setTitle("Asistent medical");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        datepers = new JPanel();
        datepers.setLayout(null);
        datepers.setBackground(new Color(74, 149, 150));

        rapoarte = new JPanel();
        rapoarte.setLayout(null);
        rapoarte.setBackground(new Color(74, 149, 150));

        ImageIcon img = new ImageIcon("icon.png");
        this.setIconImage(img.getImage());


        tab2 = new Table(date2, header2);
        tab2.t.setBounds(150, 300, 1290, 20);

        JScrollPane x2 = new JScrollPane(tab2.t);
        x2.setBounds(550, 150, 1000, 180);
        tab2.t.setPreferredScrollableViewportSize(new Dimension(1325, 170));
        datepers.add(x2);
        tab2.t.setModel(new DefaultTableModel(date2, header2) {

            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }
        });


        tab3 = new Table(date3, header3);
        tab3.setBounds(550, 250, 1000, 20);

        JScrollPane x3 = new JScrollPane(tab3.t);
        x3.setBounds(550, 450, 1000, 180);
        datepers.add(x3);
        tab3.t.setPreferredScrollableViewportSize(new Dimension(1277, 17));
        tab3.t.setModel(new DefaultTableModel(date3, header3) {

            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }
        });

        header1 = ExtragereAntet.getHeader(Model.c, "raport");
        date1 = ExtragereDate.getData(Model.c, "raport");
        tab1 = new Table(date1, header1);
        tab1.t.setModel(new DefaultTableModel()
        {

            @Override
            public boolean isCellEditable(int row, int column) {

                return column != 0 && column != 8 && column!=13 && column!=14 && column!=15 && column !=16;
            }
        });

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
        tab1.t.setModel(new DefaultTableModel(date1, header1) {

            @Override
            public boolean isCellEditable(int row, int column) {

                return column != 0 && column != 8 && column!=13 && column!=14 && column!=15 && column !=16;
            }
        });
        ////////////////////////////////////////////////////////////////////////////// initializare frame

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
        tab2.t.setFont(font2);
        tab2.t.getTableHeader().setFont(font2);
        tab2.t.getTableHeader().setBackground(new Color(92, 143, 243));
        tab2.t.getTableHeader().setReorderingAllowed(false);
        tab2.t.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        datepers.add(tab2);

        tab3.t.setFont(font2);
        tab3.t.getTableHeader().setFont(font2);
        tab3.t.getTableHeader().setBackground(new Color(92, 143, 243));
        tab3.t.getTableHeader().setReorderingAllowed(false);
        tab3.t.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        datepers.add(tab3);

        ClockPane c1 = new ClockPane();
        c1.setBounds(0, 0, 300, 50);
        c1.setOpaque(false);
        this.add(c1);

        orarl = new JLabel("Orar:");
        orarl.setFont(font6);
        orarl.setForeground(Color.BLACK);
        orarl.setBounds(570, 80, 800, 50);
        datepers.add(orarl);

        concediil = new JLabel("Concedii:");
        concediil.setFont(font6);
        concediil.setForeground(Color.BLACK);
        concediil.setBounds(570, 380, 800, 50);
        datepers.add(concediil);

        rapoartel = new JLabel("Rapoarte medicale:");
        rapoartel.setFont(font6);
        rapoartel.setForeground(Color.BLACK);
        rapoartel.setBounds(90, 280, 800, 50);
        rapoarte.add(rapoartel);

        asist = new JLabel("Asistent medical");
        asist.setFont(font1);
        asist.setBounds(600, 20, 500, 100);
        this.add(asist);

        id = new JLabel("ID:");
        id.setFont(font3);
        id.setForeground(Color.BLACK);
        id.setBounds(30, 20, 800, 50);
        datepers.add(id);

        nume = new JLabel("Nume:");
        nume.setFont(font3);
        nume.setForeground(Color.BLACK);
        nume.setBounds(30, 60, 800, 50);
        datepers.add(nume);

        prenume = new JLabel("Prenume:");
        prenume.setFont(font3);
        prenume.setForeground(Color.BLACK);
        prenume.setBounds(30, 100, 800, 50);
        datepers.add(prenume);

        cnp = new JLabel("CNP:");
        cnp.setFont(font3);
        cnp.setForeground(Color.BLACK);
        cnp.setBounds(30, 140, 800, 50);
        datepers.add(cnp);

        nrtel = new JLabel("Nr. telefon:");
        nrtel.setFont(font3);
        nrtel.setForeground(Color.BLACK);
        nrtel.setBounds(30, 180, 800, 50);
        datepers.add(nrtel);

        email = new JLabel("Email:");
        email.setFont(font3);
        email.setForeground(Color.BLACK);
        email.setBounds(30, 220, 800, 50);
        datepers.add(email);

        parola = new JLabel("Parola:");
        parola.setFont(font3);
        parola.setForeground(Color.BLACK);
        parola.setBounds(30, 260, 800, 50);
        datepers.add(parola);

        iban = new JLabel("Iban:");
        iban.setFont(font3);
        iban.setForeground(Color.BLACK);
        iban.setBounds(30, 300, 800, 50);
        datepers.add(iban);

        nr_contract = new JLabel("Nr. contract:");
        nr_contract.setFont(font3);
        nr_contract.setForeground(Color.BLACK);
        nr_contract.setBounds(30, 340, 800, 50);
        datepers.add(nr_contract);

        dataang = new JLabel("Data angajarii:");
        dataang.setFont(font3);
        dataang.setForeground(Color.BLACK);
        dataang.setBounds(30, 380, 800, 50);
        datepers.add(dataang);

        tip = new JLabel("Tipul:");
        tip.setFont(font3);
        tip.setForeground(Color.BLACK);
        tip.setBounds(30, 420, 800, 50);
        datepers.add(tip);

        grad = new JLabel("Gradul:");
        grad.setFont(font3);
        grad.setForeground(Color.BLACK);
        grad.setBounds(30, 460, 800, 50);
        datepers.add(grad);

        salariu = new JLabel("Salariu:");
        salariu.setFont(font3);
        salariu.setForeground(Color.BLACK);
        salariu.setBounds(30, 500, 800, 50);
        datepers.add(salariu);

        nrore = new JLabel("Nr. ore stabilit:");
        nrore.setFont(font3);
        nrore.setForeground(Color.BLACK);
        nrore.setBounds(30, 540, 800, 50);
        datepers.add(nrore);

        idunit = new JLabel("ID unitate:");
        idunit.setFont(font3);
        idunit.setForeground(Color.BLACK);
        idunit.setBounds(30, 580, 800, 50);
        datepers.add(idunit);

        cautas=new JLabel("Cauta salariu ");
        cautas.setFont(font3);
        cautas.setForeground(Color.BLACK);
        cautas.setBounds(300, 600, 800, 50);
        datepers.add(cautas);

        ans=new JTextField("");
        ans.setFont(font3);
        ans.setForeground(Color.BLACK);
        ans.setBounds(200, 640, 100, 30);
        datepers.add(ans);
        ansl=new JLabel("An");
        ansl.setFont(font3);
        ansl.setForeground(Color.BLACK);
        ansl.setBounds(150, 640, 50, 30);
        datepers.add(ansl);

        lunas=new JTextField("");
        lunas.setFont(font3);
        lunas.setForeground(Color.BLACK);
        lunas.setBounds(400, 640, 100, 30);
        datepers.add(lunas);
        lunasl=new JLabel("Luna");
        lunasl.setFont(font3);
        lunasl.setForeground(Color.BLACK);
        lunasl.setBounds(310, 640, 70, 30);
        datepers.add(lunasl);

        saltrecut=new JTextField("");
        saltrecut.setFont(font3);
        saltrecut.setEditable(false);
        saltrecut.setForeground(Color.BLACK);
        saltrecut.setBounds(400, 680, 150, 30);
        datepers.add(saltrecut);


        cautass = new JButton("Cauta");
        cautass.setBounds(300, 680, 60, 50);
        cautass.setFont(new Font("Georgia", Font.BOLD, 12));
        cautass.setBackground(new Color(252, 242, 206));
        cautass.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 204)));
        cautass.setFocusPainted(false);
        cautass.addActionListener(new ActionListener() {
            ////////////////////////////////////////////////////////////////////////////// cauta salariu precedent

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

        updateb = new JButton("Confirmi modificarea?");
        updateb.setBounds(100, 100, 160, 50);
        updateb.setFont(new Font("Georgia", Font.BOLD, 12));
        updateb.setBackground(new Color(252, 242, 206));
        updateb.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 204)));
        updateb.setFocusPainted(false);
        updateb.addActionListener(new ActionListener() {
            ////////////////////////////////////////////////////////////////////////////// modifica raport existent

            public void actionPerformed(ActionEvent e) {
                selectedrow = tab1.t.getSelectedRow();

                String nume_pac, prenume_pac, cnp_pac, nume_m, prenume_m, nume_asis, prenume_asis,  simp, diag, tip_serv, reteta;
                int id=0;
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
                        tab1.t.setModel(new DefaultTableModel(date, header1) {

                            @Override
                            public boolean isCellEditable(int row, int column) {

                                return column != 0 && column != 8 && column!=13 && column!=14 && column!=15 && column !=16;
                            }
                        });

                    }
                } catch (Exception sqe) {
                    err.setVisible(true);
                }
                updateb.setVisible(false);
            }

        });
        updateb.setVisible(false);
        rapoarte.add(updateb);

        err = new EroareInsert();
        err.setBounds(960, 500, 300, 168);
        err.continua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                err.setVisible(false);
                date = ExecProc.getData(Model.c, "select * from raport;");
                header1 = ExtragereAntet.getHeader(Model.c, "raport");
                tab1.t.setModel(new DefaultTableModel(date, header1) {

                    @Override
                    public boolean isCellEditable(int row, int column) {

                        return column != 0 && column != 8 && column!=13 && column!=14 && column!=15 && column !=16;
                    }
                });
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
        tabbedPane.add("Rapoarte medicale", rapoarte);
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
    public int getId()
     {
         int id=0;
         try{
             PreparedStatement st=Model.c.prepareStatement("select id from utilizator where email='"+Model.email+"';");
             ResultSet rsr=st.executeQuery();
             while(rsr.next())
             {
                 id=rsr.getInt(1);
             }
         }
         catch(Exception sss)
         {

         }
         return id;
     }

}
