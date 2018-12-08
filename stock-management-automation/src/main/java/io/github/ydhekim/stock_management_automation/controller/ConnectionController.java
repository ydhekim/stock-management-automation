package io.github.ydhekim.stock_management_automation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionController {

	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:~/stock-management-automation";

	static final String USER = "sa";
	static final String PASS = "";
	
	public Statement stmt;
	public Connection conn;

	public boolean Connect() {
		
	      try { 
	         // STEP 1: Register JDBC driver 
	         Class.forName(JDBC_DRIVER); 
	             
	         //STEP 2: Open a connection 
	         System.out.println("Connecting to database..."); 
	         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
	         System.out.println("Can");
	       
	         //TEST ETMEK ICIN KULLANDIM.
	         //STEP 3: Execute a query 
	         //System.out.println("Creating table in given database..."); 
	         //stmt = conn.createStatement(); 
	         //String sql =  "CREATE TABLE   REGISTRATION3 " + 
	           // "(id INTEGER not NULL, " + 
	            //" first VARCHAR(255), " +  
	            //" last VARCHAR(255), " +  
	            //" age INTEGER, " +  
	            //" PRIMARY KEY ( id ))";  
	         //stmt.executeUpdate(sql);
	         //System.out.println("Created table in given database..."); 
	         
	         // STEP 4: Clean-up environment 
	         //stmt.close(); 
	         //conn.close(); 
	         //TEST SONU
	         
	         return true;
	         
	      } catch(SQLException se) { 
	         //Handle errors for JDBC 
	         se.printStackTrace(); 
	         return false;
	      } catch(Exception e) { 
	         //Handle errors for Class.forName 
	         e.printStackTrace(); 
	         return false;
	      } 
	}
}
