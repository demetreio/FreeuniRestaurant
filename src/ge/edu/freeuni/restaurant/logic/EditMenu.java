package ge.edu.freeuni.restaurant.logic;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EditMenu {
	
	public Kerdzi getObjectOfKerdzi(String name) throws SQLException{
		Kerdzi k = null;
		DBConnector db = DBConnector.getInstance();
		ResultSet rs = db.selectFromMenuByName(name);
		if(rs.next()){
			k = new Kerdzi(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4));
		}
		return k;
	}
	
	public void saveInDbKerdzi(String name, double price, String category){
		DBConnector db = DBConnector.getInstance();
		db.insertIntoMenu(name, price, category);
	}
	
	public void removeFromDbKerdzi(String name){
		DBConnector db = DBConnector.getInstance();
		db.removeFromMenuByName(name);
	}
}
