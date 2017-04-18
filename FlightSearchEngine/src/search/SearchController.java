package search;


import java.io.IOException;


public class SearchController {
	FlightManager flightManager = new FlightManager();
	private FlightModel[] flights;
	private FlightModel[] newFlights;
	
	// Constructor
	public SearchController() {
		
	}
	
	// Getting all flights
	public FlightModel[] getAllFlights() {
		flights = flightManager.getAllFlights();
		
		return flights;
	}
	
	// Getting flights by departure	
	public FlightModel[] getFlightsByDeparture(String depart) {
		depart = depart.toLowerCase();
		
		flights = flightManager.getFlightsByDeparture(depart);
		
		return flights;
	}
	
	// Getting fights by destination
	public FlightModel[] getFlightsByDestination(String dest) {
		dest = dest.toLowerCase();
		
		flights = flightManager.getFlightsByDestination(dest);
		
		return flights;
	}
	
	// Getting flights by date
	public FlightModel[] getFlightsByDate(String departime) {
		
		
		flights = flightManager.getFlightsByDate(departime);
		
		return flights;
	}
	
	// Getting flights by price range
	public FlightModel[] getFlightsByPriceRange(int lower, int higher) throws IOException {
		
		if (lower < 0 || lower > higher) throw new IOException("The value chosen for low is illeagal!");
		
		flights = flightManager.getFlightsByPriceRange(lower, higher);
		
		return flights;
	}
	
	public FlightModel pickFlight(int flightnumber) {
		return flightManager.pickFlight(flightnumber);
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
		
		// FlightModel[] flights = test.getFlightsByDestination("Rome");
		
		//String price = "30.02.2017";
		
		String dest = "London";
		
		FlightModel[] flights = test.getFlightsByDestination(dest);
		
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
