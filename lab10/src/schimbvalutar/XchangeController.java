package schimbvalutar;

import com.company.CalcController;
import com.company.CalcModel;
import com.company.CalcView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XchangeController {
    private XchangeModel m_model;
    private XchangeView m_view;
    private String sumaf = "1";

    XchangeController(XchangeModel model, XchangeView view) {
        m_model = model;
        m_view = view;

        view.getCoinbox1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstval = (String) m_view.getCoinbox1().getSelectedItem();
                Double a[][] = m_view.getValori();
                String secondval = (String) m_view.getCoinbox2().getSelectedItem();
                m_view.getCurrentcoin().setText(firstval);
                m_view.getSuma_moneda().setText(firstval);
                String defaultval;
                defaultval = String.format("%.5f", m_model.getDefaultValue(a, firstval, secondval));
                m_view.getM_defaultvalue().setText(defaultval);

            }
        });
        view.getCoinbox2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstval = (String) m_view.getCoinbox1().getSelectedItem();
                Double a[][] = m_view.getValori();
                String secondval = (String) m_view.getCoinbox2().getSelectedItem();
                String defaultval;
                defaultval = String.format("%.5f", m_model.getDefaultValue(a, firstval, secondval));
                m_view.getM_defaultvalue().setText(defaultval);
                m_view.getExchangecoin().setText(secondval);
                m_view.getSuma_moneda_final().setText(secondval);
            }
        });
        view.getM_exchangeBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstval = (String) m_view.getCoinbox1().getSelectedItem();
                Double a[][] = m_view.getValori();
                String secondval = (String) m_view.getCoinbox2().getSelectedItem();
                sumaf = (String) m_view.getM_exchangevalue().getText();
                Double sum = Double.parseDouble(sumaf);
                sum = m_model.getValue(sum, a);
                sumaf = String.format("%.5f", sum);
                m_view.getM_finalvalue().setText(sumaf);

                System.out.println(sumaf);
            }
        });

    }
}
