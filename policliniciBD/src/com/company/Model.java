package com.company;


import java.sql.Connection;

public class Model {
    final static String URL = "jdbc:mysql://localhost/policlinici?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    final static String DB_NAME = "policlinici";
    final static String USER = "root";
    final static String PASSWORD = "Dumbass132!";
    public static String email;
    public static String pass;
    public static Connection c;
    public static String[][] date;
    public static String[] header;
    public static firstFrame login;
    public static MeniuPrincipal meniu;
    public static EroareLogare erlg;
    public static Administrator adm;
    public static SuperAdmin sadm;
    public static Medic med;
    public static ExpertFinanciar exp;
    public static Receptionist rec;
    public static Inspector ins;
    public static Asistent as;
    public static Program pg;
    public static ProgramUnitate pgu;
    public static AdaugaUnitate adu;
    public static AdaugareConcediu adc;
    public Model() {

    }
}
