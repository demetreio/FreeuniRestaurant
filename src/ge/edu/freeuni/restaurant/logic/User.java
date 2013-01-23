package ge.edu.freeuni.restaurant.logic;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;

public class User {
	
	private String username;
	
	private String password;
	
	private String mail;
	
	private String name;
	
	private String surname;
	
	private String info;
	
	private boolean admin;
	
	private static DBConnector dbc;
	
	
	public User(String username, String password, String mail, String name, String surname, String info, boolean admin) {
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.name = name;
		this.surname = surname;
		this.info = info;
		this.admin = admin;
	}
	
	public static ArrayList<String> getUsers(){
		dbc = DBConnector.getInstance();
		ArrayList<String> usernames;
		try {
			usernames = dbc.getAllUsers();
			return usernames;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
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


	public String getMail() {
		return mail;
	}
	
	public void setMail(String newMail){
		this.mail = newMail;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public boolean isAdmin(){
		return admin;
	}


}
