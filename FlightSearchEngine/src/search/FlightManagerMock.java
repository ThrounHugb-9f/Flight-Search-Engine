package search;

import java.util.ArrayList;

public class FlightManagerMock {
	ArrayList<FlightModel> flights;
	
	
	public FlightManagerMock() {
		flights = new ArrayList<FlightModel>();
		FlightModel flight = new FlightModel(1, "Keflavik", "London", "13.03.2017", "10:00", "13.03.2017", "12:00", 123, 5000);
		flights.add(flight);
		flight = new FlightModel(2, "Gautaborg", "Keflavik", "02.04.2017", "11:00", "02.04.2017", "13:30", 140, 4000);
		flights.add(flight);
		flight = new FlightModel(3, "Belfast", "Keflavik", "25.03.2017", "09:00", "25.03.2017", "11:00", 232, 2000);
		flights.add(flight);
		flight = new FlightModel(4, "Keflavik", "London", "04.04.2017", "11:00", "04.04.2017", "14:00", 312, 15000);
		flights.add(flight);
		flight = new FlightModel(5, "Keflavik", "Boston", "21.03.2017", "08:00", "21.03.2017", "12:00", 324, 12000);
		flights.add(flight);
		flight = new FlightModel(6, "London", "Keflavik", "14.04.2017", "19:30", "14.04.2017", "21:30", 524, 17000);
		flights.add(flight);
		flight = new FlightModel(7, "Boston", "Keflavik", "04.04.2017", "09:00", "04.04.2017", "13:00", 214, 16000);
		flights.add(flight);
		flight = new FlightModel(8, "Amsterdam", "Keflavik", "18.04.2017", "15:10", "18.04.2017", "19:00", 156, 1000);
		flights.add(flight);
		flight = new FlightModel(9, "Keflavik", "Gautaborg", "18.03.2017", "10:00", "18.03.2017", "12:30", 521, 3000);
		flights.add(flight);
		flight = new FlightModel(10, "Reykjavik", "Akureyri", "19.02.2017", "08:10", "19.02.2017", "09:00", 111, 10000);
		flights.add(flight);
		flight = new FlightModel(11, "Akureyri", "Reykjavik", "28.02.2017", "12:10", "28.02.2017", "13:00", 90, 6000);
		flights.add(flight);
		flight = new FlightModel(12, "Gautaborg", "Keflavik", "03.04.2017", "16:00", "03.04.2017", "18:30", 412, 9000);
		flights.add(flight);
		flight = new FlightModel(13, "Keflavik", "Florida", "29.02.2017", "12:00", "29.02.2017", "18:00", 123, 13000);
		flights.add(flight);
		flight = new FlightModel(14, "Keflavik", "London", "05.04.2017", "17:00", "05.04.2017", "19:30", 123, 18000);
		flights.add(flight);
		flight = new FlightModel(15, "Keflavik", "Rome", "10.03.2017", "17:30", "10.03.2017", "21:30", 423, 7000);
		flights.add(flight);
		flight = new FlightModel(16, "Florida", "Keflavik", "14.03.2017", "22:00", "15.02.2017", "04:00", 215, 8000);
		flights.add(flight);
		flight = new FlightModel(17, "Keflavik", "Rome", "08.03.2017", "16:30", "08.03.2017", "20:30", 315, 11000);
		flights.add(flight);
		flight = new FlightModel(18, "Rome", "Keflavik", "18.03.2017", "06:20", "18.03.2017", "09:30", 124, 11000);
		flights.add(flight);
		flight = new FlightModel(19, "London", "Keflavik", "16.04.2017", "20:00", "16.04.2017", "22:30", 412, 19000);
		flights.add(flight);
		flight = new FlightModel(20, "Reykjavik", "Akureyri", "17.02.2017", "11:00", "17.02.2017", "12:00", 214, 20000);
		flights.add(flight);
		
	}
		
	public ArrayList<FlightModel> getFlightsByPriceRange(int lower, int higher) {
		ArrayList<FlightModel> results = new ArrayList<FlightModel>();
		
		for(int i = 0; i < flights.size(); i++) {
			int price = flights.get(i).getPrice();
			if(price >= lower && price <= higher) {
				results.add(flights.get(i));
			}
		}
		return results;
	}
}
