package search;

import java.util.ArrayList;
import java.io.IOException;
import java.util.*;

import admin.*;
import booking.*;
import user.*;


public class SearchController {
	//SearchUI textValue = new SearchUI();
	FlightManager flightManager = new FlightManager();
	private FlightModel[] flights;
	private FlightModel[] newFlights;
	
	// Constructor
	public SearchController() {
		
	}
	
	// Getting flights by departure	
	public FlightModel[] getFlightsByDeparture(String depart) {
		flights = new FlightModel[10];
		
		flights = flightManager.getFlightsByDeparture(depart);
		
		return flights;
	}
	
	// Getting fights by destination
	public FlightModel[] getFlightsByDestination(String dest) {
		flights = new FlightModel[10];
		
		flights = flightManager.getFlightsByDeparture(dest);
		
		return flights;
	}
	
	public FlightModel[] getFlightsByDate(String departime) {
		flights = new FlightModel[10];
		
		flights = flightManager.getFlightsByDate(departime);
		
		return flights;
	}
	
	// Getting flights by price range
	public FlightModel[] getFlightsByPriceRange(int lower, int higher) throws IOException {
		flights = new FlightModel[10];
		
		if (lower < 0 || lower > higher) throw new IOException("The value chosen for low is illeagal!");
		
		flights = flightManager.getFlightsByPriceRange(lower, higher);
		
		return flights;
	}
	
	/*
	public FlightModel[] orderByPrice() {
		
		Collections.sort(flights, new Comparator<FlightModel>() {
			@Override public int compare(FlightModel p1, FlightModel p2) {
				return p1.getPrice() - p2.getPrice(); //Orders in ascending order
			}
		});
		
		return flights;
	}
	*/
	
	public static void main (String[] args) throws Exception {
		SearchController test = new SearchController();
		
		//FlightManager test = new FlightManager();
		
		// FlightModel[] flights = test.getFlightsByPriceRange(5500, 15000);
		
		//String price = "30.02.2017";
		
		String depart = "London";
		
		FlightModel[] flights = test.getFlightsByDeparture(depart);
		
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
