package search;

import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

import admin.*;
import booking.*;
import user.*;


public class SearchController {
	FlightManagerMock flightManager = new FlightManagerMock();
	ArrayList<FlightModel> flights;
	
	private int maxPrice;
	private String departure;
	private String destination;
	private String departDate;
	private String arrivalDate;
	private boolean roundTrip;
	
	// Constructor
	public SearchController() {
		
	}
	
	public ArrayList<FlightModel> getFlightsByPriceRange(int lower, int higher) throws IOException {
		flights = new ArrayList<FlightModel>();
		
		if (lower < 0 || lower > higher) throw new IOException("The value chosen for low is illeagal!");
		
		flights = flightManager.getFlightsByPriceRange(lower, higher);
		
		return flights;
	}
	
	public ArrayList<FlightModel> orderByPrice() {
		
		Collections.sort(flights, new Comparator<FlightModel>() {
			@Override public int compare(FlightModel p1, FlightModel p2) {
				return p1.getPrice() - p2.getPrice(); //Orders in ascending order
			}
		});
		
		return flights;
	}
	
	public ArrayList<FlightModel> getFlightsByDeparture(String depart) {
		ArrayList<FlightModel> flug = new ArrayList<FlightModel>();
		
		for (FlightModel i : flights) {
			if (i.getDeparture().equalsIgnoreCase(depart)) {
				flug.add(i);
			}
		}
		return flug;
	}
	
	public ArrayList<FlightModel> getFlightsByDestination(String destination, ArrayList<FlightModel> flug) {		
		ArrayList<FlightModel> temp = new ArrayList<FlightModel>();
		for (FlightModel i : flug) {
			if (i.getArrival().equalsIgnoreCase(destination)) {
				temp.add(i);
			}
		}
		return temp;
	}
	
	public ArrayList<FlightModel> getFlightsByDate(String date, ArrayList<FlightModel> flug) {
		ArrayList<FlightModel> temp = new ArrayList<FlightModel>();
		
		for (FlightModel i : flug) {
			if (i.getDeparturedate().equalsIgnoreCase(date)) {
				temp.add(i);
			}
		}
			
		return temp;
	}
	
	public static void main (String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		SearchController test = new SearchController();
		
		ArrayList<FlightModel> flug = test.getFlightsByPriceRange(1000, 15000);
		
		flug = test.orderByPrice();
		
		for (FlightModel i : flug) {
			System.out.println(i.getDeparture() + " - " + i.getArrival() + " - " + i.getPrice());
		}
		
		System.out.println("----------------------------------------------------------");
		flug = test.getFlightsByDeparture("Keflavik");
		
		for (FlightModel i : flug) {
			System.out.println(i.getDeparture() + " - " + i.getArrival() + " - " + i.getPrice());
		}
		
		System.out.println("----------------------------------------------------------");
		flug = test.getFlightsByDestination("London", flug);
		
		for (FlightModel i : flug) {
			System.out.println(i.getDeparture() + " - " + i.getArrival() + " - " + i.getPrice());
		}
		
		System.out.println("----------------------------------------------------------");
		flug = test.getFlightsByDate("13.03.2017", flug);
		
		for (FlightModel i: flug) {
			System.out.println(i.getDeparture() + " - " + i.getArrival() + " - " + i.getPrice());
		}
		
		
		scan.close();
	}
	
}
