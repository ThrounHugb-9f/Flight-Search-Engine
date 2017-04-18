package admin;

import java.sql.*;

public class AdminLoginManager {
	
	// Attributes for SQL Connection
	private final String url = "jdbc:postgresql://localhost:5432/fsdb";
	private final String driver = "org.postgresql.Driver";
	private final String userName = "postgres";
	private final String password = "villijons";
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
		
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
	
	public boolean checkUserAndPass(String usern, String passw) {
		try {
			con = DriverManager.getConnection(url, userName, password);
			ps = con.prepareStatement("SELECT password FROM adminlogin WHERE username = ?");
			ps.setString(1, usern);
			rs = ps.executeQuery();
			while(rs.next()) {
				if (rs.getString(1).equals(passw)) {
					con.close();
					return true;
				}
			}
			con.close();
			return false;
			
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
			return false;
		}
	}
}

