package admin;

import booking.*;
import search.*;
import user.*;

public class AdminModel {
	private int id;
	private String username;
	private int password;
	
	public AdminModel(int id, String username, int password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getPassword() {
		return password;
	}
	
	public void setPassword(int password) {
		this.password = password;
	}
}
