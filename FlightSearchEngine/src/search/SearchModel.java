package search;


public class SearchModel {
	private int maxPrice;
	private String destination;
	private String departDate;
	private String arrivalDate;
	private boolean roundTrip;
	
	public SearchModel(int maxPrice, String destination, String departDate, String arrivalDate, boolean roundTrip) {
		this.maxPrice = maxPrice;
		this.destination = destination;
		this.departDate = departDate;
		this.arrivalDate = arrivalDate;
		this.roundTrip = roundTrip;
	}
	
	public int getMaxPrice() {
		return maxPrice;
	}
	
	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
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
	
	public boolean getRoundTrip() {
		return roundTrip;
	}
	
	public void setRoundTrip(boolean roundTrip) {
		this.roundTrip = roundTrip;
	}
}
