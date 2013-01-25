package ge.edu.freeuni.restaurant.logic;
import java.sql.*;
import java.sql.Date;
import java.util.*;
public class shekveta {

	
	private ArrayList<ShekvetisErteuli> arr;
	private String name;
	public shekveta(String name){
		this.name = name;
		arr = new ArrayList<shekveta.ShekvetisErteuli>();		
	}
	
	public void addShekveta(int kerdzi_id, int quantity){
		if(quantity > 0){
			ShekvetisErteuli sam = new ShekvetisErteuli(name, kerdzi_id, quantity);
			arr.add(sam);
		}
	}
	
	public ArrayList<ShekvetisErteuli> getDishes(){
		return arr;
	}
	
	/**
	 * Returns the arraylist of usernames of all the users with at least one order.
	 * @return the arraylist of usernames
	 */
	public ArrayList<String> usersWithSomeOrders(){
		ArrayList<String> list = new ArrayList<String>();
		DBConnector db = DBConnector.getInstance();
		try{
			ArrayList<String> allusers = db.getAllUsers();
			for(int i=0; i<allusers.size(); i++) if(db.isAnythingOrderedByUser(allusers.get(i))) list.add(allusers.get(i));
		}
		catch(SQLException sqlex){
			sqlex.printStackTrace();
		}
		return list;
	}
	
	public static shekveta readAndCreate(String name) throws SQLException{
		System.out.println("aq vart ra");
		DBConnector db = DBConnector.getInstance();
		ResultSet rs = db.selectFromShekvetaByUserName(name);
		
		shekveta shek = new shekveta(name);
		
		while(rs.next()){
			
			int id = Integer.parseInt(rs.getString("kerdzi_id"));
			int quantity = Integer.parseInt(rs.getString("quantity"));
			shek.addShekveta(id, quantity);
		}
		return shek;
	}
	
	public int getSize(){
		return arr.size();
	}
	
	public int getOrderTableId() throws NumberFormatException, SQLException{
		DBConnector db = DBConnector.getInstance();
		ResultSet rs = db.selectFromShekvetaByUserName(name);
		int id = 0;
		while(rs.next()){
			
			id = Integer.parseInt(rs.getString("table_id"));
		}
		return id;
		
	}
	
	public String getOrderTime() throws NumberFormatException, SQLException{
		DBConnector db = DBConnector.getInstance();
		ResultSet rs = db.selectFromShekvetaByUserName(name);
		String time = "";
		while(rs.next()){
			
			time = rs.getString("reserve_time");
		}
		return time;
	}

	public void saveIntoDB(String tables, String times){
		if(getSize()>0){
			DBConnector db =  DBConnector.getInstance();
			String [] tbls = tables.split(",");
			String [] timePerTable = times.split("/");
			for(int m = 0; m < tbls.length; m++){
				int tableId = Integer.parseInt(tbls[m]);
				if(m >= timePerTable.length) break;
				if(timePerTable[m].isEmpty())continue;
				String [] resTimes = timePerTable[m].split(",");
				for(int n = 0; n < resTimes.length; n++){
					int t = Integer.parseInt(resTimes[n]);
					for (int i = 0; i < arr.size(); i++) {
						db.insertIntoShekveta(arr.get(i).getName(), tableId, t, arr.get(i).getId(), arr.get(i).getQuantity());		
					}
				}
			}
			
		}
	}
	
	public class ShekvetisErteuli{
		private String name;
		private int id;
		private int quantity;
		public ShekvetisErteuli(String name, int kerdzi_id, int quantity){
			this.name = name;
			this.id = kerdzi_id;
			this.quantity = quantity;
		}
		public String getName() { return this.name; }
		public int getId() { return this.id; }
		public int getQuantity() { return this.quantity; }
	}
}
