package admin;

import booking.*;
import search.*;
import user.*;

public class AdminModel {
	private int id;
	private int seats;
	private int price;
	private String depart;
	private String destination;
	private String departDate;
	private String arrivalDate;
	private String departTime;
	private String arrivalTime;
	
	// Constructor
	public AdminModel(int id, int seats, int price,
			String depart, String destination, String departDate,
			String arrivalDate, String departTime, String arrivalTime) {
		this.id = id;
		this.seats = seats;
		this.price = price;
		this.depart = depart;
		this.destination = destination;
		this.departDate = departDate;
		this.arrivalDate = arrivalDate;
		this.departTime = departTime;
		this.arrivalTime = arrivalTime;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public String getDepart() {
		return depart;
	}
	
	public void setDepart(String depart) {
		this.depart = depart;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public String getDepartDate() {
		return departDate;
	}
	
	public void setDepartDate(String departDate) {
		this.departDate = departDate;
	}
	
	public String getArrivalDate() {
		return arrivalDate;
	}
	
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	
	public String getDepartTime() {
		return departTime;
	}
	
	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}
	
	public String getArrivalTime() {
		return arrivalTime;
	}
	
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
}
