package search;


import java.sql.*;
import java.util.*;

import admin.AdminModel;
import booking.BookingController;


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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	// Get all information on flights
		public FlightModel[] getAllFlights() {
			ArrayList<FlightModel> flights = new ArrayList<FlightModel>();
			try {
				Connection con = DriverManager.getConnection(url, userName, password);
				PreparedStatement ps = con.prepareStatement("SELECT * FROM flightdata");
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

	// Getting all data for flights where departing from
	public FlightModel[] getFlightsByDeparture(String depart) {
		ArrayList<FlightModel> flights = new ArrayList<FlightModel>();
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement("SELECT * FROM flightdata WHERE departure = ?");
			ps.setString(1, depart);
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

	// Getting all data for flights where arriving at
	public FlightModel[] getFlightsByDestination(String dest) {
		ArrayList<FlightModel> flights = new ArrayList<FlightModel>();
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement("SELECT * FROM flightdata WHERE arrival = ?");
			ps.setString(1, dest);
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

	// Getting all data for flights by date
	public FlightModel[] getFlightsByDate(String departime) {
		ArrayList<FlightModel> flights = new ArrayList<FlightModel>();
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement("SELECT * FROM flightdata WHERE departuredate = ?");
			ps.setString(1, departime);
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

	// Getting all data for flights by price range
	public FlightModel[] getFlightsByPriceRange(int lower, int higher) {
		ArrayList<FlightModel> flights = new ArrayList<FlightModel>();
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
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

	// Picking a flight and moving user to booking interface
	public FlightModel pickFlight(int flightNumber) {
		FlightModel pickedFlight = null;
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement("SELECT * FROM flightdata WHERE flightnumber = ?");
			ps.setLong(1, flightNumber);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				FlightModel temp = new FlightModel(rs.getInt("flightnumber"),
						rs.getString("departure"),
						rs.getString("arrival"),
						rs.getString("departuredate"),
						rs.getString("departuretime"),
						rs.getString("arrivaldate"),
						rs.getString("arrivaltime"),
						rs.getInt("seats"),
						rs.getInt("price"));
				pickedFlight = temp;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pickedFlight;
	}
}
