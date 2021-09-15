package com.company;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.InsetsUIResource;
import java.awt.*;

public class Expert extends JFrame {

    JLabel orarl;
    JLabel concediil;
    String[][] date;
    String[] header;
    String[][] date2;
    String[] header2;
    String[][] date3;
    String[] header3;
    JLabel titlu;
    JTabbedPane tabbedPane;
    JPanel datePersonale;
    JLabel firstLabel;
    JLabel thirdLabel;
    JPanel profit;
    JLabel secondLabel;
    JLabel tabel;
    JLabel tabel2;
    JLabel nume;
    JLabel prenume;
    JLabel cnp;
    JLabel id;
    JLabel parola;
    JLabel contract;
    JLabel telefon;
    JLabel email;
    JLabel iban;
    JLabel idUnit;
    JLabel nrOre_c;
    JLabel salariu;
    JLabel nrOre;
    JLabel dataangajare;
    JPanel calcSalarii;
    Table tab1;
    Table tab2;
    Table tab3;

    public Expert() {
        initComponent();
    }

    private void initComponent() {
        Font font2 = new Font("Georgia", Font.BOLD, 12);
        Font font = new Font("Georgia", Font.BOLD, 48);
        Font font3 = new Font("Georgia", Font.BOLD, 28);
        Font font4 = new Font("Georgia", Font.BOLD, 14);
        Font font5 = new Font("Georgia", Font.BOLD, 20);

        this.setTitle("Expert financiar");
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
        titlu.setBounds(500, 10, 800, 80);
        this.add(titlu);

        tabbedPane = new JTabbedPane();

        datePersonale = new JPanel();
        firstLabel = new JLabel();
        firstLabel.setBounds(850, 0, 700, 800);
        datePersonale.add(firstLabel);
        datePersonale.setBackground(new Color(0, 77, 61));
        datePersonale.setLayout(null);

        profit = new JPanel();
        profit.setLayout(null);
        secondLabel = new JLabel();
        secondLabel.setBounds(0, 0, 100, 100);
        profit.add(secondLabel);

        tabel = new JLabel("Profit ultima luna");
        tabel.setForeground(Color.BLACK);
        tabel.setBounds(570, 20, 500, 100);
        tabel.setFont(font);
        profit.add(tabel);
        profit.setBackground(new Color(0, 77, 61));

        calcSalarii = new JPanel();
        calcSalarii.setLayout(null);
        thirdLabel = new JLabel();
        thirdLabel.setBounds(0, 0, 100, 100);
        calcSalarii.add(thirdLabel);

        tabel2 = new JLabel("Calcul salarii");
        tabel2.setForeground(Color.BLACK);
        tabel2.setBounds(630, 20, 500, 100);
        tabel2.setFont(font);
        calcSalarii.add(tabel2);
        calcSalarii.setBackground(new Color(0, 77, 61));

        nume = new JLabel("Nume:");
        nume.setFont(font3);
        nume.setForeground(Color.BLACK);
        nume.setBounds(20, 0, 800, 50);
        datePersonale.add(nume);

        prenume = new JLabel("Prenume:");
        prenume.setFont(font3);
        prenume.setForeground(Color.BLACK);
        prenume.setBounds(20, 50, 800, 50);
        datePersonale.add(prenume);

        cnp = new JLabel("CNP:");
        cnp.setFont(font3);
        cnp.setForeground(Color.BLACK);
        cnp.setBounds(20, 100, 800, 50);
        datePersonale.add(cnp);

        telefon = new JLabel("Telefon:");
        telefon.setFont(font3);
        telefon.setForeground(Color.BLACK);
        telefon.setBounds(20, 150, 800, 50);
        datePersonale.add(telefon);

        email = new JLabel("Email:");
        email.setFont(font3);
        email.setForeground(Color.BLACK);
        email.setBounds(20, 200, 800, 50);
        datePersonale.add(email);

        parola = new JLabel("Parola:");
        parola.setFont(font3);
        parola.setForeground(Color.BLACK);
        parola.setBounds(20, 250, 800, 50);
        datePersonale.add(parola);

        iban = new JLabel("IBAN:");
        iban.setFont(font3);
        iban.setForeground(Color.BLACK);
        iban.setBounds(20, 300, 800, 50);
        datePersonale.add(iban);

        salariu = new JLabel("Salariu:");
        salariu.setFont(font3);
        salariu.setForeground(Color.BLACK);
        salariu.setBounds(20, 350, 800, 50);
        datePersonale.add(salariu);

        dataangajare = new JLabel("Data Angajarii:");
        dataangajare.setFont(font3);
        dataangajare.setForeground(Color.BLACK);
        dataangajare.setBounds(20, 400, 800, 50);
        datePersonale.add(dataangajare);


        contract = new JLabel("Numar contract:");
        contract.setFont(font3);
        contract.setForeground(Color.BLACK);
        contract.setBounds(20, 450, 800, 50);
        datePersonale.add(contract);


        id = new JLabel("ID:");
        id.setFont(font3);
        id.setForeground(Color.BLACK);
        id.setBounds(20, 500, 800, 50);
        datePersonale.add(id);


        idUnit = new JLabel("ID unitate:");
        idUnit.setFont(font3);
        idUnit.setForeground(Color.BLACK);
        idUnit.setBounds(20, 550, 800, 50);
        datePersonale.add(idUnit);

        nrOre_c = new JLabel("Numar ore calculate:");
        nrOre_c.setFont(font3);
        nrOre_c.setForeground(Color.BLACK);
        nrOre_c.setBounds(20, 600, 800, 50);
        datePersonale.add(nrOre_c);

        nrOre = new JLabel("Numar ore:");
        nrOre.setFont(font3);
        nrOre.setForeground(Color.BLACK);
        nrOre.setBounds(20, 650, 800, 50);
        datePersonale.add(nrOre);

        tabbedPane.setBounds(-10, 80, 1600, 820);
        tabbedPane.setFont(font4);
        tabbedPane.setBackground(new Color(252, 242, 206));
        tabbedPane.add("Date personale", datePersonale);
        tabbedPane.add("Istoric profit", profit);
        tabbedPane.add("Calcul salarii", calcSalarii);
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

        tab1 = new Table(date, header);
        profit.add(tab1);
        tab1.setBounds(200, 150, 1200, 550);
        tab1.t.setFont(font2);
        tab1.t.getTableHeader().setFont(font2);
        tab1.t.getTableHeader().setBackground(new Color(92, 143, 243));
        tab1.t.getTableHeader().setReorderingAllowed(false);
        tab1.t.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        tab2 = new Table(date2, header2);
        datePersonale.add(tab2);
        tab2.setBounds(800, 50, 600, 300);
        tab2.t.setFont(font2);
        tab2.t.getTableHeader().setFont(font2);
        tab2.t.setBounds(800, 60, 600, 290);
        tab2.t.getTableHeader().setBackground(new Color(92, 143, 243));
        tab2.t.getTableHeader().setReorderingAllowed(false);
        tab2.t.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        datePersonale.add(tab2.t);

        tab3 = new Table(date3, header3);
        datePersonale.add(tab3);
        tab3.setBounds(800, 400, 600, 300);
        tab3.t.setBounds(800, 60, 600, 290);
        tab3.t.setFont(font2);
        tab3.t.getTableHeader().setFont(font2);
        tab3.t.getTableHeader().setBackground(new Color(92, 143, 243));
        tab3.t.getTableHeader().setReorderingAllowed(false);
        tab3.t.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        datePersonale.add(tab3.t);

        orarl=new JLabel("Orar");
        orarl.setFont(new Font("Georgia", Font.BOLD, 30));
        orarl.setForeground(Color.BLACK);
        orarl.setBounds(1050, 0, 800, 50);
        datePersonale.add(orarl);

        concediil=new JLabel("Concedii");
        concediil.setFont(new Font("Georgia", Font.BOLD, 30));
        concediil.setForeground(Color.BLACK);
        concediil.setBounds(1030,350, 800, 50);
        datePersonale.add(concediil);


        this.add(tabbedPane);

        this.setVisible(true);
    }

}
