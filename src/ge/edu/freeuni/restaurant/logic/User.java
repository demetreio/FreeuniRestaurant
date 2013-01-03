package ge.edu.freeuni.restaurant.logic;

public class User {
	
	private String username;
	
	private String password;
	
	private String name;
	
	private String surname;
	
	private String info;
	
	private boolean admin;
	
	
	public User(String username, String password, String name, String surname, String info, boolean admin) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.info = info;
		this.admin = admin;
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}

	public boolean isAdmin(){
		return admin;
	}
}
