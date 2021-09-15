package main;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("unused")
public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection c;
		DATA d=new DATA();
		///1.datele din tabela 
		try {
			
			c=DriverManager.getConnection(d.getURL()+d.getDB_NAME(), d.getUSER(), d.getPASSWORD());
			PreparedStatement s1= c.prepareStatement("select * from customer");
			ResultSet rez= s1.executeQuery();
			while (rez.next()) {
				System.out.println("Customer: " + rez.getString("CustomerName"));
				}
			
			System.out.println("");
			PreparedStatement s2= c.prepareStatement("select * from customer where customerid>5");
			ResultSet rez2= s2.executeQuery();
			while (rez2.next()) {
				System.out.println("Customer where id > 5: " + rez2.getString("CustomerName"));
				}	
			System.out.println("");
			PreparedStatement s3= c.prepareStatement("select username,password from ldetails ");
			ResultSet rez3= s3.executeQuery();
			System.out.println("Login successful");
			System.out.println("");
			while(rez3.next())
			{
				System.out.println("Login details: " + rez3.getString("username")+ " " +rez3.getString("password"));
			}
			PreparedStatement s4= c.prepareStatement("SELECT distinct customername from customer \n"
					+ "join orders o on(o.customerid=customer.customerid)\n"
					+ "where LEFT(customername,1)='A' or LEFT(customername,1)='a'; ");
			ResultSet rez4= s4.executeQuery();
			System.out.println("");
			while(rez4.next()) {
				System.out.println("The customer with first letter A is : " + rez4.getString("customername"));
			}
			System.out.println("");
			
			PreparedStatement s5= c.prepareStatement("call selectemployee()");
			ResultSet rez5= s5.executeQuery();
			while(rez5.next()) {
				System.out.println("The employee name is : " + rez5.getString("EmployeeName"));
			}
			System.out.println("");
			
			CallableStatement s6= c.prepareCall("{call insertemployee(?,?,?)}");
			
			ResultSet rez6= s6.executeQuery();
	        System.out.println("Employee inserted \n");
			PreparedStatement s7= c.prepareStatement("select employeename from employee where employeeid='E0010'");
			ResultSet rez7= s7.executeQuery();
			while(rez7.next()) {
				System.out.println("The employee " + rez7.getString("EmployeeName") + " was inserted ");
			}
			
			
		}
		
		catch (Exception e) {
			System.out.println("SQLException: " + e.getMessage());
		    System.out.println("SQLState: " + ((SQLException) e).getSQLState());
		    System.out.println("VendorError: " + ((SQLException) e).getErrorCode());
		}
		
		

	}
	
}
