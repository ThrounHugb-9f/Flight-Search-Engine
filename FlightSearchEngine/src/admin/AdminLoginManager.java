package admin;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.*;
import admin.*;
import booking.*;
import user.*;
import java.util.*;
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
	
	public AdminLoginModel[] checkUsernAndPassw(String usern, String passw) {
		Connection con;
		PreparedStatement ps;
		
		try {
			con = DriverManager.getConnection(url, userName, password);
			ps = con.prepareStatement("SELECT 'username', 'password' FROM adminlogin"
									  + "WHERE 'username'  = ? AND 'password' = ?");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
