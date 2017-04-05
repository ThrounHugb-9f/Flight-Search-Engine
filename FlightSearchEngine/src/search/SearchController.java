package search;

import java.util.ArrayList;
import java.io.IOException;
import java.util.*;

import admin.*;
import booking.*;
import user.*;


public class SearchController {
	FlightManagerMock flightManager = new FlightManagerMock();
	ArrayList<FlightModel> flights;
	
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
	
	public static void main (String[] args) throws Exception {
		SearchController test = new SearchController();
		
		ArrayList<FlightModel> flug = test.getFlightsByPriceRange(1000, 12000);
		
		flug = test.orderByPrice();
		
		for (FlightModel i : flug) {
			System.out.println(i.getPrice());
		}
	}
	
}
