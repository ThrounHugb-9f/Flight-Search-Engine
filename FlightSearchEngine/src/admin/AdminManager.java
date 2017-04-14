package admin;

import java.sql.*;
import booking.*;
import search.*;
import user.*;
import java.util.*;

public class AdminManager {
	
	// Attributes for SQL Connection
	Connection con = null;
	private final String url = "jdbc:postgresql://localhost:5432/fsdb";
	private final String driver = "org.postgresql.Driver";
	private final String userName = "gunnarmarhardarson";
	private final String password = "abcd1234";

	// Constructor
	public AdminManager() {
		
	}
	
	// Connection to Database
	public Connection Connect() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userName, password);
			if (con == null) {
				System.out.println("Connection cannot be established");
			}
			return con;
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return null;
	}
}
