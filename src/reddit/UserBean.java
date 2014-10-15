package reddit;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;
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
	
	public String register() throws IOException {
		try {
			UserManager userManager = new UserManager();
			userManager.register(this);
			System.out.println("user " + getUsername() + " created.");
			System.out.println("password " + getPassword());
			return "index.xhtml";
			
		} catch (UserException e) {
			setUsername(null);
			setPassword(null);
			System.out.println("<p>At least one field is missing or incorrect.</p>");
		}
	return "";
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
