package ge.edu.freeuni.restaurant.logic;

import java.sql.SQLException;


public class Table {
	
	private int id;
	private int size;
	private String description;
	private boolean busy;
	private String occupantName;
	
	public Table(int id, int size, String description, boolean busy, String occupantName){
		this.id = id;
		this.size = size;
		this.description = description;
		this.busy = busy;
		this.occupantName = occupantName;
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
	
	public boolean isBusy(){
		return busy;
	}
	
	public String getOccupantName(){
		return occupantName;
	}
	
	/**
	 * magidas monishnavs, rom araa dakavebuli, aseve okupantis saxels washlis.
	 */
	public void setTableFree(){
		this.busy = false;
		this.occupantName = "";
		DBConnector db=DBConnector.getInstance();
		db.removeFromOccupation(id);
		db.addIntoOccupation(id, "");
	}
	/**
	 * gadmoecema okupantis id.
	 * magidas monishnavs dakavebulad da chawers okupants
	 * @param id: okupantis id
	 */
	public void setTableBusy(String name){
		this.occupantName = name;
		this.busy = true;
		DBConnector db=DBConnector.getInstance();
		db.removeFromOccupation(id);
		db.addIntoOccupation(id, occupantName);
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
