package ge.edu.freeuni.restaurant.logic;
import java.sql.*;
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
	
	public static shekveta readAndCreate(String name) throws SQLException{
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
	
	public void saveIntoDB(String tables, String times){
		if(getSize()>0){
			DBConnector db =  DBConnector.getInstance();
			System.out.println(tables+"   ----   "+times);
			String [] tbls = tables.split(",");
			System.out.println(tbls.length+" --- tbls.length");
			String [] timePerTable = times.split("/");
			for(int m = 0; m < tbls.length; m++){
				int tableId = Integer.parseInt(tbls[m]);
				if(m >= timePerTable.length) break;
				if(timePerTable[m].isEmpty())continue;
				String [] resTimes = timePerTable[m].split(",");
				for(int n = 0; n < resTimes.length; n++){
					System.out.println(resTimes[n]+"  ---- resTimes[n]");
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
