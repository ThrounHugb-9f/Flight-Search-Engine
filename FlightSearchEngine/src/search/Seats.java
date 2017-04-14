package search;

import admin.*;
import booking.*;
import user.*;

public class Seats {
	private int seatCount;
	private int firstClass;
	private int economyClass;

	public Seats(int numSeats) {
		this.seatCount = numSeats;
		this.firstClass = 20;
		this.economyClass = numSeats - firstClass;
	}

}
