package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InspectorResurse extends JFrame
{
    String[][] date;
    String[] header;
    JButton sterge;
    public InspectorResurse(Connection c)
    {
        this.setTitle("Inspector");
        this.setDefaultCloseOperation(firstFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.pack();
        this.setSize(800, 601);
        this.setBounds(160,100,1600,900);
        ImageIcon img= new ImageIcon("icon.png");
        this.setIconImage(img.getImage());
        date=ExtragereDate.getData(c,"utilizator");
        header=ExtragereAntet.getHeader(c,"utilizator");
        Table tab1=new Table(date,header);
       // t.setSize(1000,300);
        tab1.setBounds(100,100,1000,500);
        this.add(tab1);
        Font font2 = new Font("Georgia", Font.BOLD, 30);
        sterge=new JButton("Șterge");
        sterge.setBounds(1200,200,100,50);
        this.add(sterge);
        sterge.addMouseListener(new MouseListener()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(tab1.t.getSelectedRowCount()==1) {
                    int selrow=Integer.parseInt(date[tab1.t.getSelectedRow()][0]);
                    System.out.println(date[tab1.t.getSelectedRow()][0]);
                    try {
                        PreparedStatement s = c.prepareCall("{call stergeutilizator(?)}");
                        s.setInt(1,selrow);
                        s.execute();
                        ((DefaultTableModel) tab1.t.getModel()).removeRow(tab1.t.getSelectedRow());
                    }
                    catch(Exception sqe)
                    {
                        System.out.println("SQLException: " + sqe.getMessage());
                        System.out.println("SQLState: " + ((SQLException) sqe).getSQLState());
                        System.out.println("VendorError: " + ((SQLException) sqe).getErrorCode());
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
    }

}
