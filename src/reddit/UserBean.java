package reddit;

import java.io.IOException;

public class UserBean {

	private String username;
	private String password;
	
	
	public void login(){
		UserManager userManager = new UserManager();
		UserBean user;
		try {
			user = userManager.login(getUsername(), getPassword());
			if (!(user instanceof UserBean)) {
				setUsername(null);
				setPassword(null);
			}
		} catch (UserException e) {
			setUsername(null);
			setPassword(null);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("user " + getUsername() + " successfully logged in.");
	}
	
	public boolean isLoggedIn(){
		return (getUsername() != null);
	}
	
	public void logout(){
		setUsername(null);
		setPassword(null);
	}
	
	public void register() throws IOException {
		try {
			UserManager userManager = new UserManager();
			userManager.register(this);
			System.out.println("user " + getUsername() + " created.");
			System.out.println("password " + getPassword());
				
		} catch (UserException e) {
			setUsername(null);
			setPassword(null);
			System.out.println("<p>At least one field is missing or incorrect.</p>");
		}
		
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean checkPassword(String password) {
		if (this.password.equals(password)) {
			return true;
		}
		return false;
	}

	public boolean checkEntries() throws UserException {
		if (username == null && password == null)
			return false;
		if (username == null || username.equals(""))
			throw new UserException();
		if (password == null || password.equals(""))
			throw new UserException();
		if (username == null || username.equals(""))
			throw new UserException();
		
		return true;
	}
}
