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
			Kerdzi k = new Kerdzi(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4));
			list.add(k);
		}
		return list;
	}
}
