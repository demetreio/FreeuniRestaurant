package ge.edu.freeuni.restaurant.model;

import java.sql.SQLException;


public class Table {
	
	private int id;
	private int size;
	private String description;
	
	public Table(int id, int size, String description){
		this.id = id;
		this.size = size;
		this.description = description;
	}
	
	public int getId(){
		return id;
		
	}
	
	public int getSize(){
		return size;
	}
	
	public String getDescription(){
		return description;
	}
	
	/**
	 * reserves this table for the user. method is sincronised
	 * so it's impossible for two users to reserve
	 * one table
	 * @param  timeIndex index of the time, it's bit string with length = 30;
	 *  first 0-14 bits are for the first day reservation
	 * and 15 - 29 are for second day. 
	 * the restaurant works from 9:00 t 0 24:00 so 9:00 is index 0, 10:00 is 1 and so on.
	 * @return false if cannot reserve, true if reservation was succesful
	 * @throws SQLException 
	 */
	public synchronized boolean reserveTable(int timeIndex) throws SQLException{
		DBConnector db=DBConnector.getInstance();
		return db.reserveTable(this.id, timeIndex);
	}
}