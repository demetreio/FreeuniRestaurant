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
	
	public void removeFromDbKerdzi(int id){
		DBConnector db = DBConnector.getInstance();
		db.removeFromMenuByName(id);
	}
	
	public void changePrice(int id, double price){
		DBConnector db = DBConnector.getInstance();
		db.updatePrice(id, price);
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param foodId
	 * @return
	 */
	public boolean existFood(int foodId) {
		DBConnector db = DBConnector.getInstance();
		return db.existFood(foodId);
	}
}

