package search;


import java.util.Comparator;


public class FlightModel implements Comparator{
	private int flightnumber;
	private String departure;
	private String arrival;
	private String departuredate;
	private String departuretime;
	private String arrivaldate;
	private String arrivaltime;
	private int seats;
	private int price;

	private int avalibleSeats;
	private int firstClass;
	private int economyClass;

	public FlightModel(int flightnumber, String departure,
			String arrival, String departuredate, String departuretime,
			String arrivaldate, String arrivaltime, int seats, int price) {
		this.flightnumber = flightnumber;
		this.departure = departure;
		this.arrival = arrival;
		this.departuredate = departuredate;
		this.departuretime = departuretime;
		this.arrivaldate = arrivaldate;
		this.arrivaltime = arrivaltime;
		this.seats = seats;
		this.price = price;

		this.avalibleSeats = seats;
		this.firstClass = 20;
		this.economyClass = this.avalibleSeats - this.firstClass;
	}

	public int getFlightnumber() {
		return flightnumber;
	}

	public void setFlightnumber(int flightnumber) {
		this.flightnumber = flightnumber;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getDeparturedate() {
		return departuredate;
	}

	public void setDeparturedate(String departuredate) {
		this.departuredate = departuredate;
	}

	public String getDeparturetime() {
		return departuretime;
	}

	public void setDeparturetime(String departuretime) {
		this.departuretime = departuretime;
	}

	public String getArrivaldate() {
		return arrivaldate;
	}

	public void setArrivaldate(String arrivaldate) {
		this.arrivaldate = arrivaldate;
	}

	public String getArrivaltime() {
		return arrivaltime;
	}

	public void setArrivaltime(String arrivaltime) {
		this.arrivaltime = arrivaltime;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAvalible() {
		return this.avalibleSeats;
	}

	public int getFirstClass() {
		return this.firstClass;
	}

	public void updateFirstClass(int numSeats) {
		if (firstClass - numSeats < 0) {
			throw new IllegalArgumentException("No more First Class seats are avalible");
		} else {
			this.firstClass = this.firstClass - numSeats;
			this.avalibleSeats = this.avalibleSeats - numSeats;
		}
	}

	public int getEconomyClass() {
		return this.economyClass;
	}

	public void updateEconomyClass(int numSeats) {
		if (economyClass - numSeats < 0) {
			throw new IllegalArgumentException("No more Economy Class seats are avalible");
		} else {
			this.economyClass = this.economyClass - numSeats;
			this.avalibleSeats = this.avalibleSeats - numSeats;
		}
	}

	@Override
	public int compare(Object o1, Object o2) {

		return 0;
	}
}
