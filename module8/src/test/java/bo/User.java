package bo;

public class User {
	
	private String login;
	private String password;

	public User(String login, String password) {
		this.setLogin(login);
		this.setPassword(password);
	}
// the same note about the constructor as for Email
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + "]";
	}
	
	

}
