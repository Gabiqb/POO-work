package schimbvalutar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class XchangeView extends JFrame{
    String[] monede={"RON - Leul romanesc","EUR - EURO","USD - Dolarul SUA"};

    public Double[][] getValori() {
        return valori;
    }
    Double valori[][]=
    {
            {1.0,0.2052,0.2493},
            {0.20521,1.0,0.823180},
            {0.24930,0.823,1.0}
    };
    private JComboBox coinbox1=new JComboBox(monede);
    private JComboBox coinbox2=new JComboBox(monede);
    private JLabel currentcoin= new JLabel(" RON-Leul romanesc");
    private JLabel exchangecoin= new JLabel(" RON-Leul romanesc");
    private JTextField m_userInputValue = new JTextField(5);
    private JTextField m_exchangevalue = new JTextField(20);
    private JButton m_exchangeBtn = new JButton(">>");
    private JTextField m_defaultvalue= new JTextField("1.00000",20);
    private JTextField m_finalvalue = new JTextField("1.00000",20);
    private JButton m_addBtn = new JButton("Add");
    private JButton m_clearBtn = new JButton("Clear");
    JLabel unu=new JLabel("1");
    JLabel eg=new JLabel(" = ");
    JLabel suma=new JLabel("Suma"); ///textul "Suma"
    JLabel rez=new JLabel("Rezultat"); //textul "Rezultat"
    JLabel suma_moneda=new JLabel("RON - Leul romanesc");
    JLabel suma_moneda_final=new JLabel("RON - Leul romanesc");


    /** Constructor */
    public XchangeView( ) {

        JPanel content = new JPanel();
        content.setLayout(null);
        coinbox1.setBounds(15,50,200,30);
        content.add(coinbox1);
        m_exchangeBtn.setBounds(250,50,50,30);
        content.add(m_exchangeBtn);
        coinbox2.setBounds(330,50,200,30); ///box1 cu monede
        content.add(coinbox2);
        unu.setBounds(130,10,200,10);
        content.add(unu);
        currentcoin.setBounds(140,10,140,10); ///moneda de schimbat
        content.add(currentcoin);
        eg.setBounds(270,12,20,5); /// egal
        content.add(eg);
        m_defaultvalue.setBounds(290,6,70,20);
        exchangecoin.setBounds(370,8,150,20);
        content.add(exchangecoin);
        m_defaultvalue.setEditable(false);
        content.add(m_defaultvalue);  /// valoarea monedei raportata la 1 unitate
        m_exchangevalue.setBounds(230,100,100,20);
        content.add(m_exchangevalue);
        coinbox1.setSelectedIndex(0);
        suma.setBounds(190,100,100,20);
        content.add(suma);
        suma_moneda.setBounds(340,97,150,20);
        content.add(suma_moneda);

        rez.setBounds(180,130,100,20);
        content.add(rez);

        m_finalvalue.setBounds(230,130,100,20);
        content.add(m_finalvalue);
        suma_moneda_final.setBounds(340,130,150,20);
        content.add(suma_moneda_final);
        m_finalvalue.setEditable(false);

        this.setContentPane(content);
        this.pack();
        this.setTitle("Schimb Valutar");
        // The window closing event should probably be passed to the
        // Controller in a real program, but this is a short example.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(640,360);
    }
    String getUserInput() {
        return m_userInputValue.getText();
    }

    public JTextField getM_exchangevalue() {
        return m_exchangevalue;
    }

    public JButton getM_exchangeBtn() {
        return m_exchangeBtn;
    }

    public JTextField getM_defaultvalue() {
        return m_defaultvalue;
    }

    public JTextField getM_finalvalue() {
        return m_finalvalue;
    }
    public JComboBox getCoinbox1() {
        return coinbox1;
    }
    public JLabel getExchangecoin() {
        return exchangecoin;
    }
    public JComboBox getCoinbox2() {
        return coinbox2;
    }

    public JLabel getSuma_moneda() {
        return suma_moneda;
    }

    public JLabel getSuma_moneda_final() {
        return suma_moneda_final;
    }

    public JLabel getCurrentcoin() {
        return currentcoin;
    }

    public JTextField getM_userInputValue() {
        return m_userInputValue;
    }

    public JLabel getRez() {
        return rez;
    }

}
