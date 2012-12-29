package ge.edu.freeuni.restaurant.model;
/**
 * The class that connects to the database. It's a synchronized singleton class. It has several methods that update or select
 * information from the database.
 */

import java.sql.*;

public class DBConnector{
	private static Object lock  = new Object();
	static String server = "localhost";
	static String password = ""; //<---------
	static String account = "root";
	static String database = "test"; //<---------
	private static  Connection con;
	private static DBConnector db;
	
	/**
	 * This method returns the DBManager object, initialized AT MOST once.
	 */
	public static DBConnector getInstance(){
		synchronized(lock){
			if(db==null) db = new DBConnector();
			return db;
		}
	}
	
	/**
	 * The constructor of this class.
	 */
	private DBConnector(){
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://" + server, account, password);
		}
		catch (ClassNotFoundException e) {
			  e.printStackTrace();
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
	}
	
	/**
	 * @return the information about all the tables the restaurant from the database. (Note: It's not a SQL table,
	 * but ordinary one :) Ex: I am a table.).
	 * @throws SQLException
	 */
	public ResultSet getTables() throws SQLException{
		ResultSet rset;
		Statement stmt = con.createStatement();
		stmt.executeQuery("use 	" + database);
		rset = stmt.executeQuery("select * from tables");
		return rset;

	}
	
	/**
	 * @param table_id the id of a table we are interested in.
	 * @return the information about the reservation times of the table.
	 */
	public ResultSet getReservedInfo(int table_id) throws SQLException{
		ResultSet rset;
		Statement stmt = con.createStatement();
		stmt.executeQuery("use " + database);
		rset = stmt.executeQuery("select * from ReservedTables where id = "+table_id);
		return rset;
		
	}
	
	/**
	 * @param table_id the id of a table we are interested in.
	 * @param timeIndex index of the time, it's bit string with length = 30; first 0-14 bits are for the first day reservation
	 * and 15 - 29 are for second day. the restaurant works from 9:00 t 0 24:00 so 9:00 is index 0, 10:00 is 1 and so on.
	 * @return true if the table reserved succesfully and false if it is allready reserved.
	 */
	
	public boolean reserveTable(int table_id, int timeIndex) throws SQLException{
		ResultSet rset;
		Statement stmt = con.createStatement();
		stmt.executeQuery("use " + database);
		rset = stmt.executeQuery("select * from ReservedTables where id = "+table_id);

		String str =  rset.getString("reserveInfo");
		if(str.charAt(timeIndex) == '1') return false;
		char[] arr = str.toCharArray();
		arr[timeIndex] = 1;
		String newOne = new String(arr);
		stmt.executeUpdate("update ReservedTables set reserveInfo = '" + newOne + "' where id =" +table_id);
		
		return true;
	}
	
	
	public boolean isCorrectUsernameAndPassword(String username, String password){
		try {
			ResultSet rset;
			Statement stmt = con.createStatement();
			stmt.executeQuery("use " + database);
			rset = stmt.executeQuery("select * from User where username = '"+username + "' and password = '" + password + "'");
			rset.last();
			return rset.getRow() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * writes user in database. returns true if user is not in database, false otherwise
	 * @param user
	 * @return
	 */
	public boolean registerNewUser(User user){
		if(isUsernameInUse(user.getUsername())){
			return false;
		}
		try {
			Statement stmt = con.createStatement();
			stmt.executeQuery("use " + database);
			stmt.executeUpdate("insert into User values('"+user.getUsername()+"', '" +
							user.getPassword() + "', '" + user.getName() +"', '" +user.getSurname()+"', '"+
							user.getInfo() + "')");	
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean isUsernameInUse(String username){
		try {
			ResultSet rset;
			Statement stmt = con.createStatement();
			stmt.executeQuery("use " + database);
			rset = stmt.executeQuery("select * from User where username = '"+username + "'");
			rset.last();
			return rset.getRow() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	/**
	 * retrieve admin column from user table and check for admin flag
	 * @param username
	 * @return true if the user is admin
	 */
	private boolean isAdmin(String username){
		ResultSet rset;
		boolean res = false;
		try {
			Statement stmt = con.createStatement();
			stmt.executeQuery("use " + database);
			rset = stmt.executeQuery("select admin from User where username = '"+username + "'");
			if(rset.next()){
				res = rset.getBoolean(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
}