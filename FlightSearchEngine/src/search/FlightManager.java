package search;

import java.sql.*;
import admin.*;
import booking.*;
import user.*;
import java.util.*;

import javax.swing.JOptionPane;

public class FlightManager {
	
	// Attributes for SQL Connection
	Connection con;
	private final String url = "jdbc:postgresql://localhost:5432/fsdb";
	private final String driver = "org.postgresql.Driver";
	private final String userName = "postgres";
	private final String password = "villijons";
	
	// Constructor
	public FlightManager() {
		
    }
	
	// Connection to Database
	public Connection connect() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userName, password);
			if (con == null) {
				System.out.println("Connection cannot be established");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	public FlightModel[] getFlightsByPriceRange(int lower, int higher) {
		ArrayList<FlightModel> flights = new ArrayList<FlightModel>();
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			// String sql = ;
			PreparedStatement ps = con.prepareStatement("SELECT * FROM flightdata WHERE price BETWEEN ? AND ?");
			ps.setInt(1, lower);
			ps.setInt(2, higher);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				FlightModel tmp = new FlightModel(rs.getInt("flightnumber"),
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
		
		FlightModel[] results = new FlightModel[flights.size()];
		
		for(int i = 0; i < flights.size(); i++) {
			results[i] = flights.get(i);
		}
		
		return results;
	}
	
	
	public static void main (String[] args) throws Exception {
		
		FlightManager test = new FlightManager();
		
		FlightModel[] flights = test.getFlightsByPriceRange(55000, 100000);
		
		for (FlightModel i : flights) {
			System.out.print(i.getFlightnumber() + " ");
			System.out.print(i.getDeparture() + " ");
			System.out.print(i.getArrival() + " ");
			System.out.print(i.getDeparturedate() + " ");
			System.out.print(i.getDeparturetime() + " ");
			System.out.print(i.getArrivaldate() + " ");
			System.out.print(i.getArrivaltime() + " ");
			System.out.print(i.getSeats() + " ");
			System.out.println(i.getPrice());
			System.out.println();
		}
	}
}
