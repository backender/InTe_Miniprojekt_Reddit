package reddit;

import java.io.*;
import java.util.*;

public class UserManager {
	protected Hashtable<String, UserBean> users = new Hashtable<String, UserBean>();

	protected String userFilename = "/Users/Marc/tmp/users.ser"; // auf Windows "c:\\temp\\users.ser"

	protected File userFile;

	@SuppressWarnings("unchecked")
	public UserManager() {
		userFile = new File(userFilename);
		if (userFile.exists()) {
			try {
				FileInputStream fileIn = new FileInputStream(userFile);
				ObjectInputStream objectIn = new ObjectInputStream(fileIn);
				users = (Hashtable<String, UserBean>) objectIn.readObject();
				objectIn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public boolean register(UserBean user) throws UserException {
		if (users.get(user.getUsername()) != null) { // User existiert bereits
			throw new UserException();
		}
		
		if (user.checkEntries()) { // wirft UserException bei Fehler
			users.put(user.getUsername(), user);
			save();
			return true;
		}
		return false;
	}

	public UserBean login(String login, String password) throws UserException {
		if ((login == null && password == null)
				|| (login == "" && password == "")) {
			return null;
		}
		UserBean user = users.get(login);
		if (user != null && user.checkPassword(password)) {
			return user;
		}
		throw new UserException();
	}

	public void save() {
		try {
			FileOutputStream fileOut = new FileOutputStream(userFile);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(users);
			objectOut.flush();
			objectOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
