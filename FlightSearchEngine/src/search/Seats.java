package search;

import admin.*;
import booking.*;
import user.*;

public class Seats {
	private int avalibleSeats;
	private int firstClass;
	private int economyClass;

	
	public Seats(int numSeats) {
		this.avalibleSeats = numSeats;
		this.firstClass = 20;
		this.economyClass = numSeats - 20;
	}
	
	public int getAvalible() {
		return this.avalibleSeats;
	}
	
	public int getFirstClass() {
		return this.firstClass;
	}
	
	public void updateFirstClass(int numSeats) {
		this.avalibleSeats = this.avalibleSeats - numSeats;
		this.firstClass = this.firstClass - numSeats;
	}
	
	public int getEconomyClass() {
		return this.economyClass;
	}
	
	public void updateEconomyClass(int numSeats) {
		this.avalibleSeats = this.avalibleSeats - numSeats;
		this.economyClass = this.economyClass - numSeats;
	}

}
