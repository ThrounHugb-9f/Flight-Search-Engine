package search;

import java.sql.*;
import admin.*;
import booking.*;
import user.*;
import java.util.*;

import javax.swing.JOptionPane;

public class FlightManager {
	
	// Attributes for SQL Connection
	Connection con = null;
	private final String url = "jdbc:postgresql://localhost:5432/fsdb";
	private final String driver = "org.postgresql.Driver";
	private final String userName = "postgres";
	private final String password = "maggadora7";
	String deptext;
	
	
	// Constructor
	public FlightManager() {
	}
	
	SearchUI textValue = new SearchUI();
	
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
	// Build query, execute and keep in ResultSet rs		
		
		
		public FlightModel[] getFlightByDestination() {
		
		ArrayList<FlightModel> flights = new ArrayList<FlightModel>();
		
		try {
		
		Connection con = DriverManager.getConnection(url, userName, password);
		
		SearchUI textValue = new SearchUI();
		deptext = textValue.getTextfieldText();
	
		String sql = "SELECT * FROM flightdata WHERE (departure=?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, deptext);
		
	  
		ResultSet rs = st.executeQuery();
		
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
	
}


	
		

