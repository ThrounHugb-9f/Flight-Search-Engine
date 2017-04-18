package booking;

import admin.*;
import search.*;
import user.*;

public class BookingController {
	BookingManager bookingManager = new BookingManager();
	
	BookingModel booking;

	public BookingController(FlightModel flight) {
		
	}
	
	public BookingController(BookingModel book) {
		this.booking = book;
	}
	
	public void addNewBooking() {
		bookingManager.addNewBooking(booking);
	}
	
	public static void main (String[] args) {
		
	}

}
