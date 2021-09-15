package com.company;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Controller {
    public Controller() {
        Model m = new Model();
        try {
            m.c = DriverManager.getConnection(m.URL, m.USER, m.PASSWORD);
            m.meniu = new MeniuPrincipal(); //prima fereastra
            m.login = new firstFrame(); //fereastra login
            m.erlg = new EroareLogare(); //fereastra eroare parola
            m.pg=new Program();
            m.pgu=new ProgramUnitate();
            m.adu=new AdaugaUnitate();
            m.rec=new Receptionist();
            m.as=new Asistent();
            m.med=new Medic();
            m.ins=new Inspector();
            m.adm = new Administrator(m.c);
            m.sadm = new SuperAdmin(m.c);
            m.exp=new ExpertFinanciar();
            m.adc=new AdaugareConcediu();
        } catch (Exception e) {

        }
        m.login.getButton().addActionListener(new ActionListener() //buton logare
                                              {
                                                  @Override
                                                  public void actionPerformed(ActionEvent e) {
                                                      m.email = m.login.getEmail().getText();
                                                      m.pass = String.valueOf(m.login.getPassword().getPassword());
                                                      String functie = " ";

                                                      try {

                                                          CallableStatement lg = m.c.prepareCall("{ call getdata(?,?,?,?)}");
                                                          int ok = 0;
                                                          lg.setString(1, m.email);
                                                          lg.setString(2, m.pass);
                                                          lg.setInt(3, ok);
                                                          lg.setString(4, " ");
                                                          lg.execute();
                                                          ok = lg.getInt(3);
                                                          functie = "";
                                                          functie = lg.getString(4);
                                                          if (ok == 1) {
                                                              m.erlg.setVisible(false);
                                                              m.login.setVisible(false);
                                                              if (functie.equals("medic")) {

                                                                  m.med.adaugadate(m.c);

                                                                  try {
                                                                      String id = "";
                                                                      CallableStatement s = Model.c.prepareCall("call selectraportid();");
                                                                      ResultSet rs = s.executeQuery();
                                                                      while (rs.next()) {
                                                                          id = rs.getString(1);
                                                                      }
                                                                      if(id==null)
                                                                          m.med.tabel.setText("Raport medical #" + "1");
                                                                      else
                                                                          m.med.tabel.setText("Raport medical #" + id);

                                                                  } catch (Exception ex) {

                                                                  }
                                                                  int idm=m.med.getId();
                                                                  m.med.header = ExtragereAntet.getHeader(Model.c, "program_angajat");
                                                                  m.med.date=ExecProc.getData(Model.c,"select * from program_angajat where id_angajat="+idm);
                                                                  ((DefaultTableModel)m.med.tab3.t.getModel()).setDataVector(m.med.date,m.med.header);

                                                                  m.med.header = ExtragereAntet.getHeader(Model.c, "concedii");
                                                                  m.med.date=ExecProc.getData(Model.c,"select * from concedii where id="+idm);
                                                                  ((DefaultTableModel)m.med.tab4.t.getModel()).setDataVector(m.med.date,m.med.header);

                                                                  m.med.setVisible(true);
                                                              } else if (functie.equals("asistent medical")) {

                                                                  m.as.adaugadate(m.c);
                                                                  int idas=m.as.getId();
                                                                  m.as.header2 = ExtragereAntet.getHeader(Model.c, "program_angajat");
                                                                  m.as.date2=ExecProc.getData(Model.c,"select * from program_angajat where id_angajat="+idas);
                                                                  ((DefaultTableModel)m.as.tab2.t.getModel()).setDataVector(m.as.date2,m.as.header2);

                                                                  m.as.header3 = ExtragereAntet.getHeader(Model.c, "concedii");
                                                                  m.as.date3=ExecProc.getData(Model.c,"select * from concedii where id="+idas);
                                                                  ((DefaultTableModel)m.as.tab3.t.getModel()).setDataVector(m.as.date3,m.as.header3);
                                                                  m.as.setVisible(true);
                                                              }
                                                              else if (functie.equals("inspector resurse"))
                                                              {

                                                                  m.ins.adaugadate(m.c);
                                                                  m.ins.setVisible(true);
                                                              }
                                                              else if (functie.equals("super-administrator")) {
                                                                  m.sadm.date = ExecProc.getData(Model.c, "select u.*,a.id_unitate from utilizator u,angajat a where a.id=u.id;");
                                                                  m.sadm.header= ExecHeader.getHeader(Model.c, "select u.*,a.id_unitate from utilizator u,angajat a where a.id=u.id;");
                                                                  ((DefaultTableModel) m.sadm.tab1.t.getModel()).setDataVector(m.sadm.date,m.sadm.header);
                                                                  m.sadm.setVisible(true);

                                                              } else if (functie.equals("administrator")) {


                                                                  m.adm.header = ExecHeader.getHeader(Model.c, "select u.*,a.id_unitate from utilizator u,angajat a where u.functie<>'administrator' and u.functie<>'super-administrator' and a.id=u.id;");
                                                                  m.adm.date = ExecProc.getData(Model.c, "select u.*,a.id_unitate from utilizator u,angajat a where u.functie<>'administrator' and u.functie<>'super-administrator' and a.id=u.id;");
                                                                  ((DefaultTableModel)m.adm.tab1.t.getModel()).setDataVector(m.adm.date,m.adm.header);
                                                                  m.adm.setVisible(true);
                                                              } else if (functie.equals("receptionist")) {

                                                                  m.rec.adaugadate(m.c);
                                                                  int idp=m.rec.getId();
                                                                  m.rec.date=ExecProc.getData(Model.c,"select * from program_angajat where id_angajat="+idp);
                                                                  m.rec.header=ExecHeader.getHeader(Model.c,"select * from program_angajat where id_angajat="+idp);
                                                                  ((DefaultTableModel)m.rec.tab3.t.getModel()).setDataVector(m.rec.date,m.rec.header);

                                                                  m.rec.date=ExecProc.getData(Model.c,"select * from concedii where id="+idp);
                                                                  m.rec.header=ExecHeader.getHeader(Model.c,"select * from concedii where id="+idp);
                                                                  ((DefaultTableModel)m.rec.tab4.t.getModel()).setDataVector(m.rec.date,m.rec.header);

                                                                  try {
                                                                      String id = "";
                                                                      CallableStatement s = Model.c.prepareCall("call selectprogramareid();");
                                                                      ResultSet rs = s.executeQuery();
                                                                      while (rs.next()) {
                                                                          id = rs.getString(1);
                                                                      }
                                                                      if(id==null)
                                                                          m.rec.tabel.setText("Programare #" + "1");
                                                                      else
                                                                          m.rec.tabel.setText("Programare #" + id);

                                                                      id = "";
                                                                      s = Model.c.prepareCall("call selectchitantaid();");
                                                                      rs = s.executeQuery();
                                                                      while (rs.next()) {
                                                                          id = rs.getString(1);
                                                                      }
                                                                      if(id==null)
                                                                          m.rec.chit.setText("Chitanta #" + "1");
                                                                      else
                                                                          m.rec.chit.setText("Chitanta  #" + id);

                                                                      CallableStatement s1 = Model.c.prepareCall("select a.id_unitate from angajat a,utilizator u where a.id=u.id and u.email='" + Model.email + "';");
                                                                      rs = s1.executeQuery();
                                                                      int idu =0;
                                                                      while (rs.next()) {
                                                                          idu = rs.getInt(1);
                                                                      }

                                                                      String si=m.rec.tipServiciutxt2.getSelectedItem().toString();
                                                                      PreparedStatement s2=Model.c.prepareStatement("select pret from servicii_medicale where tip_serviciu='"+si+"' and id_unitate="+idu+";");
                                                                      rs=s2.executeQuery();
                                                                      while(rs.next())
                                                                      {
                                                                          m.rec.pretstxt.setText(rs.getString(1));
                                                                      }
                                                                      m.rec.header = ExecHeader.getHeader(Model.c, "select id,nume_pacient,prenume_pacient,cnp_pacient,tip_serviciu,id_programare,id_unitate from raport");
                                                                      m.rec.date = ExecProc.getData(Model.c, "select id,nume_pacient,prenume_pacient,cnp_pacient,tip_serviciu,id_programare,id_unitate from raport");
                                                                      ((DefaultTableModel)m.rec.tabr.t.getModel()).setDataVector(m.rec.date,m.rec.header);

                                                                      m.rec.header = ExecHeader.getHeader(Model.c, "select a.nume,a.prenume,p.zi_lucru,p.ora_inceput,p.ora_final,p.locatie,m.specialitate,m.grad,p.concediu from program_angajat p,angajat a,medic m where (m.id=a.id and m.id=p.id_angajat) or (p.id_angajat=a.id)");
                                                                      m.rec.date = ExecProc.getData(Model.c, "select a.nume,a.prenume,p.zi_lucru,p.ora_inceput,p.ora_final,p.locatie,m.specialitate,m.grad,p.concediu from program_angajat p,angajat a,medic m where (m.id=a.id and m.id=p.id_angajat) or (p.id_angajat=a.id)");
                                                                      ((DefaultTableModel)m.rec.tab2.t.getModel()).setDataVector(m.rec.date,m.rec.header);
                                                                  } catch (Exception ex) {

                                                                  }
                                                                  m.rec.setVisible(true);
                                                              }

                                                              else if (functie.equals("expert financiar")) {

                                                                  int idp=m.exp.getId();
                                                                  m.exp.date=ExecProc.getData(Model.c,"select * from program_angajat where id_angajat="+idp);
                                                                  m.exp.header=ExecHeader.getHeader(Model.c,"select * from program_angajat where id_angajat="+idp);
                                                                  ((DefaultTableModel)m.exp.tab1.t.getModel()).setDataVector(m.exp.date,m.exp.header);

                                                                  m.exp.date=ExecProc.getData(Model.c,"select * from concedii where id="+idp);
                                                                  m.exp.header=ExecHeader.getHeader(Model.c,"select * from concedii where id="+idp);
                                                                  ((DefaultTableModel)m.exp.tab2.t.getModel()).setDataVector(m.exp.date,m.exp.header);
                                                                  m.exp.adaugadate(m.c);
                                                                  m.exp.setVisible(true);
                                                              }
                                                          } else {
                                                              m.erlg.setVisible(true);
                                                          }
                                                      } catch (SQLException se) {
                                                          System.out.println("SQLException: " + se.getMessage());
                                                          System.out.println("SQLState: " + ((SQLException) se).getSQLState());
                                                          System.out.println("VendorError: " + ((SQLException) se).getErrorCode());
                                                      }


                                                  }
                                              }
        );

        m.meniu.getButton().addActionListener(new ActionListener() //buton prima fereastra
                                              {
                                                  @Override
                                                  public void actionPerformed(ActionEvent e) {
                                                      m.meniu.setVisible(false);
                                                      m.login.setVisible(true);
                                                  }
                                              }
        );
        m.adm.logout.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                m.adm.setVisible(false);
                m.login.getEmail().setText("");
                m.login.getPassword().setText("");
                m.meniu.setVisible(true);
                m.adm.header = ExecHeader.getHeader(Model.c, "select u.*,a.id_unitate from utilizator u,angajat a where u.functie<>'administrator' and u.functie<>'super-administrator' and a.id=u.id;");
                m.adm.date = ExecProc.getData(Model.c, "select u.*,a.id_unitate from utilizator u,angajat a where u.functie<>'administrator' and u.functie<>'super-administrator' and a.id=u.id;");
            }
        });
        m.sadm.logout.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                m.sadm.setVisible(false);
                m.login.getEmail().setText("");
                m.login.getPassword().setText("");
                m.meniu.setVisible(true);
                m.sadm.date = ExecProc.getData(Model.c, "select u.*,a.id_unitate from utilizator u,angajat a where a.id=u.id;");
                m.sadm.header= ExecHeader.getHeader(Model.c, "select u.*,a.id_unitate from utilizator u,angajat a where a.id=u.id;");
                ((DefaultTableModel) m.sadm.tab1.t.getModel()).setDataVector(m.sadm.date,m.sadm.header);
            }
        });

        m.adm.adaugaprogram.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    m.pg.setVisible(true);
                    m.adm.setVisible(false);
            }
        });
        m.adm.adaugau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.adc.setVisible(true);
                m.adm.setVisible(false);
            }
        });
        m.pg.logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.pg.setVisible(false);
                m.adm.setVisible(true);
            }
        });
        m.sadm.adaugaprogram.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.pgu.setVisible(true);
                m.sadm.setVisible(false);
            }
        });
        m.pgu.logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.pgu.date = ExecProc.getData(Model.c, "select * from program_unitate");
                m.pgu.header = ExecHeader.getHeader(Model.c, "select * from program_unitate");
                ((DefaultTableModel) m.pgu.tab1.t.getModel()).setDataVector(m.pgu.date, m.pgu.header);
                m.pgu.setVisible(false);
                m.sadm.setVisible(true);
            }
        });
        m.sadm.adaugau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                m.sadm.setVisible(false);
                m.adu.setVisible(true);
            }
        });
        m.adu.logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.adu.setVisible(false);
                m.sadm.setVisible(true);

            }
        });
        m.adc.logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.adc.setVisible(false);
                m.adm.setVisible(true);
            }
        });
        m.exp.logout.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                m.exp.setVisible(false);
                m.login.getEmail().setText("");
                m.login.getPassword().setText("");
                m.meniu.setVisible(true);

            }
        });
        m.rec.logout.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                m.rec.setVisible(false);
                m.login.getEmail().setText("");
                m.login.getPassword().setText("");
                m.meniu.setVisible(true);
                m.rec.header = ExecHeader.getHeader(Model.c, "select id,id_unitate as 'id_unit',Nume_Pacient as 'Nume_p' ,Prenume_pacient as 'Prenume_p',cnp as 'CNP_p', Nume_medic as 'Nume_m',Prenume_medic as 'Pren_m',data_programarii as 'data_prog',interval_orar as 'i_orar',tip_serviciu as 'serviciu' from programari");
                m.rec.date = ExecProc.getData(Model.c, "select id,id_unitate as 'id_unit',Nume_Pacient as 'Nume_p' ,Prenume_pacient as 'Prenume_p',cnp as 'CNP_p', Nume_medic as 'Nume_m',Prenume_medic as 'Pren_m',data_programarii as 'data_prog',interval_orar as 'i_orar',tip_serviciu as 'serviciu' from programari");
                ((DefaultTableModel)m.rec.tab1.t.getModel()).setDataVector(m.rec.date,m.rec.header);

                m.rec.header = ExecHeader.getHeader(Model.c, "select a.nume,a.prenume,p.ora_inceput,p.ora_final,p.locatie,m.specialitate,m.grad from program_angajat p,angajat a,medic m");
                m.rec.date = ExecProc.getData(Model.c, "select a.nume,a.prenume,p.ora_inceput,p.ora_final,p.locatie,m.specialitate,m.grad from program_angajat p,angajat a,medic m");
                ((DefaultTableModel)m.rec.tab2.t.getModel()).setDataVector(m.rec.date,m.rec.header);
            }
        });

        m.ins.logout.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                m.ins.setVisible(false);
                m.login.getEmail().setText("");
                m.login.getPassword().setText("");
                m.meniu.setVisible(true);
                m.rec.header = ExecHeader.getHeader(Model.c, "select id,id_unitate as 'id_unit',Nume_Pacient as 'Nume_p' ,Prenume_pacient as 'Prenume_p',cnp as 'CNP_p', Nume_medic as 'Nume_m',Prenume_medic as 'Pren_m',data_programarii as 'data_prog',interval_orar as 'i_orar',tip_serviciu as 'serviciu' from programari");
                m.rec.date = ExecProc.getData(Model.c, "select id,id_unitate as 'id_unit',Nume_Pacient as 'Nume_p' ,Prenume_pacient as 'Prenume_p',cnp as 'CNP_p', Nume_medic as 'Nume_m',Prenume_medic as 'Pren_m',data_programarii as 'data_prog',interval_orar as 'i_orar',tip_serviciu as 'serviciu' from programari");
                ((DefaultTableModel)m.rec.tab1.t.getModel()).setDataVector(m.rec.date,m.rec.header);

                m.rec.header = ExecHeader.getHeader(Model.c, "select a.nume,a.prenume,p.ora_inceput,p.ora_final,p.locatie,m.specialitate,m.grad from program_angajat p,angajat a,medic m");
                m.rec.date = ExecProc.getData(Model.c, "select a.nume,a.prenume,p.ora_inceput,p.ora_final,p.locatie,m.specialitate,m.grad from program_angajat p,angajat a,medic m");
                ((DefaultTableModel)m.rec.tab2.t.getModel()).setDataVector(m.rec.date,m.rec.header);
            }
        });
        m.med.logout.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                m.med.setVisible(false);
                m.login.getEmail().setText("");
                m.login.getPassword().setText("");
                m.meniu.setVisible(true);
                         }
        });
        m.as.logout.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                m.as.setVisible(false);
                m.login.getEmail().setText("");
                m.login.getPassword().setText("");
                m.meniu.setVisible(true);
                m.as.date = ExecProc.getData(Model.c, "select * from raport");
                ((DefaultTableModel)m.as.tab1.t.getModel()).setDataVector(m.as.date,m.as.header1);
            }
        });
        m.meniu.setVisible(true);
    }
}
