package ge.edu.freeuni.restaurant.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Menu {
	
	public ArrayList<Kerdzi> getMenu() throws SQLException{
		DBConnector db = DBConnector.getInstance();
		ResultSet rs = db.selectFromMenu();
		ArrayList<Kerdzi> list = new ArrayList<Kerdzi>();
		while(rs.next()){
			Kerdzi k = new Kerdzi(rs.getString(1), rs.getDouble(2), rs.getString(3));
			list.add(k);
		}
		return list;
	}
}
