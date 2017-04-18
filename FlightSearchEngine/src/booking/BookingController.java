package booking;

import admin.*;
import search.*;
import user.*;

public class BookingController {
	BookingManager bookingManager = new BookingManager();
	private FlightModel pickedFlight;

	public BookingController(FlightModel flight) {
		this.pickedFlight = flight;
	}
	
	public static void main (String[] args) {

	}

}
