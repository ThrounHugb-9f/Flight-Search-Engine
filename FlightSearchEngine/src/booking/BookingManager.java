package booking;

import java.sql.*;
import admin.*;
import search.*;
import user.*;

public class BookingManager {
	
	// Attributes for SQL Connection
	Connection con = null;
	private final String url = "jdbc:postgresql://localhost:5432/fsdb";
	private final String driver = "org.postgresql.Driver";
	private final String userName = "gunnarmarhardarson";
	private final String password = "abcd1234";

	// Constructor
	public BookingManager() {
	
	}
	
	// Connection to Database
	public Connection connect() {
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
