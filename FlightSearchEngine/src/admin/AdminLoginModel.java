package admin;

import java.sql.*;
import admin.*;
import booking.*;
import user.*;
import java.util.*;
import search.*;

public class AdminLoginModel {
	private int idLogin;
	private String username;
	private int password;
	
	// Constructor
	public AdminLoginModel(int idLogin, String username,
			int password) {
		this.idLogin = idLogin;
		this.username = username;
		this.password = password;
	}
	
	public int getIdLogin() {
		return idLogin;
	}
	
	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
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
