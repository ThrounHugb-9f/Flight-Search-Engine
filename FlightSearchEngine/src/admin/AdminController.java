package admin;

import booking.*;
import search.*;
import user.*;

public class AdminController {
	AdminManager adminManager = new AdminManager();
	AdminModel[] flights;

	// Constructor
	public AdminController() {
		
	}
	
	// Getting all information on flights
	public AdminModel[] getAllFlights() {
		flights = adminManager.getAllFlights();
		
		return flights;
	}
	
	public AdminModel[] addNewFlight(int flightnumber, String departure, String arrival,
			String departDate, String departTime, String arrivalDate, String arrivalTime,
			int seats, int price) {
		
		
		return null;
	}
	
	public static void main (String[] args) throws Exception {
		AdminController test = new AdminController();
		
		//FlightManager test = new FlightManager();
		
		// FlightModel[] flights = test.getFlightsByPriceRange(5500, 15000);
		
		//String price = "30.02.2017";
		
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
	}
}
