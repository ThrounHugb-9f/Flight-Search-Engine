package booking;


public class BookingModel {
	private int id;
	private String name;
	private int kennitala;
	private String email;
	private int phonenumber;
	private int seatsreserved;
	private int flightnumber;
	
	public BookingModel(int id, String name,
			int kennitala, String email, int phonenumber,
			int seatsreserved, int flightnumber) {
		this.id = id;
		this.name = name;
		this.kennitala = kennitala;
		this.email = email;
		this.phonenumber = phonenumber;
		this.seatsreserved = seatsreserved;
		this.flightnumber = flightnumber;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getKennitala() {
		return kennitala;
	}
	
	public void setKennitala(int kennitala) {
		this.kennitala = kennitala;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getPhonenumber() {
		return phonenumber;
	}
	
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	public int getSeatsreserved() {
		return seatsreserved;
	}
	
	public void setSeatsreserved(int seatsreserved) {
		this.seatsreserved = seatsreserved;
	}
	
	public int getFlightnumber() {
		return flightnumber;
	}
	
	public void setFlightnumber(int flightnumber) {
		this.flightnumber = flightnumber;
	}

}
