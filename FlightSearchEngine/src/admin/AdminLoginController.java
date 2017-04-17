package admin;


public class AdminLoginController {
	AdminLoginManager adminLoginManager = new AdminLoginManager();

	public AdminLoginController() {
		
	}
	
	// Checking user and password
	public boolean checkUserAndPass(String usern, String passw) {
		
		if(adminLoginManager.checkUserAndPass(usern, passw) == true) {
			System.out.println("true");
			return true;
		}
		else {
			System.out.println("false");
			return false;
		}
	}
}
