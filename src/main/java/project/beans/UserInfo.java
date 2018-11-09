package project.beans;

public class UserInfo {
	
	private String userName;
	private String password;
	
	// empty constructor 
	public UserInfo() {
	}

	// getters and setters
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}
}
