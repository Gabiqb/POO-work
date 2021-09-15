package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.TableView;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Table extends JPanel
{
    JTable t;
    DefaultTableModel tm;
    TableRowSorter tr;

    int nrrows;
    public Table(String[][] date,String[] header) {


        tm=new DefaultTableModel(date,header){

            @Override
            public boolean isCellEditable(int row, int column)
            {

                return column != 0;
            }
        };

        t=new JTable(tm){
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column){
               JComponent returnComp = (JComponent) super.prepareRenderer(renderer, row, column);
                Color alternateColor = new Color(252,242,206);
                Color whiteColor = Color.WHITE;
                if (!returnComp.getBackground().equals(getSelectionBackground())){
                    Color bg = (row % 2 == 0 ? alternateColor : whiteColor);
                    returnComp .setBackground(bg);

                }

                return returnComp;
        }};

        nrrows=t.getRowCount();


        JScrollPane scrollPane = new JScrollPane(t);


        t.setPreferredScrollableViewportSize(new Dimension(1150,500));
        this.add(scrollPane);
        this.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 153, 204)));



    }
    public void filter(String filterText)
    {
        DefaultTableModel Model = (DefaultTableModel)t.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(Model);
        t.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(filterText.trim()));

    }
}
