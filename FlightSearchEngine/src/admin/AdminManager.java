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
	
	// Testing main class
	public static void main (String[] args) throws Exception {
			
		AdminManager test = new AdminManager();
		
		test.addNewFlight(41, "Keflavik", "Tokyo", "03.04.2017", "16:30", ""
				+ "04.04.2017", "04:30", 123, 84890);
			
		//FlightModel[] flights = test.getFlightsByPriceRange(5500, 15000);
			
		//String date = "30.02.2017";
		
		/*
		AdminModel[] flights = test.getAllFlights();
			
		for (AdminModel i : flights) {
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
		*/
	}
}
