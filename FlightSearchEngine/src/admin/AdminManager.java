package admin;

import java.sql.*;
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
	
	// Get all information on flights
	public AdminModel[] getAllFlights() {
		ArrayList<AdminModel> flights = new ArrayList<AdminModel>();
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement("SELECT * FROM flightdata");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				AdminModel tmp = new AdminModel(rs.getInt("flightnumber"),
						  						  rs.getString("departure"),
						  						  rs.getString("arrival"),
						  						  rs.getString("departuredate"),
						  						  rs.getString("departuretime"),
						  						  rs.getString("arrivaldate"),
						  						  rs.getString("arrivaltime"),
						  						  rs.getInt("seats"),
						  						  rs.getInt("price"));
				flights.add(tmp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		AdminModel[] results = new AdminModel[flights.size()];
		
		for(int i = 0; i < flights.size(); i++) {
			results[i] = flights.get(i);
		}
		
		return results;
	}
	
	// Adding a new flight into the database
	public AdminModel[] addNewFlight(int flightnumber, String departure, String arrival,
			String departDate, String departTime, String arrivalDate, String arrivalTime,
			int seats, int price) {
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement("INSERT INTO flightdata VALUES("
														+ "?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, flightnumber);
			ps.setString(2, departure);
			ps.setString(3, arrival);
			ps.setString(4, departDate);
			ps.setString(5, departTime);
			ps.setString(6, arrivalDate);
			ps.setString(7, arrivalTime);
			ps.setInt(8, seats);
			ps.setInt(9, price);
			
			// execute the prepared statement insert
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	// Deleting a flight from database
	public AdminModel[] deleteFlight(int flightnumber) {
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement("DELETE FROM flightdata WHERE flightnumber = ?");
			
			ps.setInt(1, flightnumber);
			
			// execute the prepared statement delete
			ps.executeUpdate();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	// Update flights in database
	public AdminModel[] updateFlight(String departure, String arrival,
			String departDate, String departTime, String arrivalDate, String arrivalTime,
			int seats, int price, int flightnumber) {
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement("UPDATE flightdata SET departure = ?,"
					+ "arrival = ?, departuredate = ?, departuretime = ?, arrivaldate = ?,"
					+ "arrivaltime = ?, seats = ?, price = ? WHERE flightnumber = ?");
			ps.setString(1, departure);
			ps.setString(2, arrival);
			ps.setString(3, departDate);
			ps.setString(4, departTime);
			ps.setString(5, arrivalDate);
			ps.setString(6, arrivalTime);
			ps.setInt(7, seats);
			ps.setInt(8, price);
			ps.setInt(9, flightnumber);
			
			// execute the prepared statement update
			ps.executeUpdate();
			ps.close();
			
		} catch (Exception e) {
			e.getMessage();
		}
 		
		return null;
	}
}
