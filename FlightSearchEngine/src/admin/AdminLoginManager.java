/*
package admin;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.*;
import admin.*;
import booking.*;
import user.*;
import java.util.*;

import javax.swing.JOptionPane;

import search.*;

public class AdminLoginManager {
	
	// Attributes for SQL Connection
	Connection con;
	private final String url = "jdbc:postgresql://localhost:5432/fsdb";
	private final String driver = "org.postgresql.Driver";
	private final String userName = "gunnarmarhardarson";
	private final String password = "abcd1234";
	
	// 	Constructor
	public AdminLoginManager() {
		
	}
	
	// Connection to Database
	public Connection connect() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userName, password);
			if (con == null) {
				System.out.println("Connection cannot be established");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public boolean checkUsernAndPassw(String usern, String passw) {
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			con = DriverManager.getConnection(url, userName, password);
			ps = con.prepareStatement("SELECT * FROM adminlogin WHERE 'username' = ? AND 'password' = ?");
			ps.setString(1, usern);
			ps.setString(2, passw);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				//JOptionPane.showMessageDialog(null, "Connection Successful");
				return true;
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid username or password");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
}
*/