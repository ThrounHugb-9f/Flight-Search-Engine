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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	
	
	
	public static void main (String[] args) throws Exception {
		
		BookingManager test = new BookingManager();
		
		/*
		FlightModel[] flights = test.getFlightsByPriceRange(5500, 15000);
		
		String date = "30.02.2017";
		
		
		FlightModel[] flights = test.getFlightsByDate(date);
		
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
		*/
	}
	
	// Add a booking to the database
	public void addNewBooking(BookingModel booking) {
		
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement("INSERT INTO bookings VALUES("
					+ "?, ?, ?, ?, ?, ?, ?)");
			
			ps.setInt(1, booking.getId());
			ps.setString(2, booking.getName());
			ps.setInt(3, booking.getKennitala());
			ps.setString(4, booking.getEmail());
			ps.setInt(5, booking.getPhonenumber());
			ps.setInt(6, booking.getSeatsreserved());
			ps.setInt(7, booking.getFlightnumber());
			
			// execute the prepared statement insert
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int checkId() {
		
		return 0;
	}
}
