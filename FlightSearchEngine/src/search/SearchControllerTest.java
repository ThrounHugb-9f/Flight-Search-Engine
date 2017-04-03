package search;

import java.util.*;

public class SearchControllerTest {

	public static void main(String[] args) throws Exception {
		SearchController test = new SearchController();
		
		int low = 1000;
		int high = 5500;
		
		ArrayList<FlightModel> flights = new ArrayList<FlightModel>();;
		flights = test.getFlightsByPriceRange(low, high);
		
		System.out.println("The value of low = " + low + " and the value of high = " + high);
		for (FlightModel i : flights) {
			System.out.println(i.getPrice());
		}
		
		low = 7000;
		flights = test.getFlightsByPriceRange(low, high);
	}
}
