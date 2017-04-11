package search;

import java.sql.*;
import admin.*;
import booking.*;
import user.*;
import java.util.*;

import javax.swing.table.DefaultTableModel;


public class FlightManager {
	
	// Attributes for SQL Connection
	Connection con;
	private final String url = "jdbc:postgresql://localhost:5432/fsdb";
	private final String driver = "org.postgresql.Driver";
	private final String userName = "gunnarmarhardarson";
	private final String password = "abcd1234";
	
	
	//Attributes
	Statement st;
	ArrayList<FlightModel> flights;
	
	// Constructor
	public FlightManager() {
		
    }
	
	// Connection to Database
	public Connection Connect() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userName, password);
			if (con == null) {
				System.out.println("Connection cannot be established");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return con;
	}
		
	public ArrayList<FlightModel> getFlightsByPriceRange(int lower, int higher) throws SQLException {
		ArrayList<FlightModel> results = new ArrayList<FlightModel>();
		
		try {
			String sql = "SELECT * FROM flightdata WHERE price BETWEEN ? AND ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, lower);
			ps.setInt(2, higher);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int flightnumber = rs.getInt(1);
				String departure = rs.getString(2);
				String arrival = rs.getString(3);
				String departuredate = rs.getString(4);
				String departuretime = rs.getString(5);
				String arrivaldate = rs.getString(6);
				String arrivaltime = rs.getString(7);
				int seats = rs.getInt(8);
				int price = rs.getInt(9);
				FlightModel flightmodel = new FlightModel(flightnumber, departure, arrival, departuredate, departuretime, arrivaldate, arrivaltime, seats, price);
				results.add(flightmodel);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return results;
	}	
	
	
	public static void main(String[] args) throws SQLException {
		FlightManager test = new FlightManager();
		
		
		ArrayList<FlightModel> flights = test.getFlightsByPriceRange(20000, 55000);
		
		for (FlightModel i : flights) {
			System.out.println(i.getPrice());
		}
	}
}









