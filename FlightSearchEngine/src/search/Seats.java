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
		if (avalibleSeats - numSeats < 0) {
			throw new IllegalArgumentException("No more seats are avalible");
		} else {
			this.avalibleSeats = this.avalibleSeats - numSeats;
		}
		
		if (firstClass - numSeats < 0) {
			throw new IllegalArgumentException("No more First Class seats are avalible");
		} else {
			this.firstClass = this.firstClass - numSeats;
		}
	}
	
	public int getEconomyClass() {
		return this.economyClass;
	}
	
	public void updateEconomyClass(int numSeats) {
		if (avalibleSeats - numSeats < 0) {
			throw new IllegalArgumentException("No more seats are avalible");
		} else {
			this.avalibleSeats = this.avalibleSeats - numSeats;
		}
		
		if (economyClass - numSeats < 0) {
			throw new IllegalArgumentException("No more Economy Class seats are avalible");
		} else {
			this.economyClass = this.economyClass - numSeats;
		}
	}
}
