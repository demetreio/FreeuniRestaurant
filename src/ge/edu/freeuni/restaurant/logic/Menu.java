package ge.edu.freeuni.restaurant.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Menu {
	
	public ArrayList<Kerdzi> getMenu() throws SQLException{
		DBConnector db = DBConnector.getInstance();
		ResultSet rs = db.selectFromMenu();
		ArrayList<Kerdzi> list = new ArrayList<Kerdzi>();
		if(rs!=null) {
			while(rs.next()){
				Kerdzi k = new Kerdzi(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4));
				list.add(k);
			}
		}
//		Kerdzi shNigvzit = new Kerdzi(1, "shaurma nigvzit", 6, "shaurma");
//		Kerdzi shSokoti = new Kerdzi(2, "shaurma sokoti", 5, "samarxvo");
//		Kerdzi shPitnit = new Kerdzi(3, "shaurma pitnit", 3, "shaurma");
//		ArrayList<Kerdzi> list = new ArrayList<Kerdzi>();
//		list.add(shNigvzit);
//		list.add(shSokoti);
//		list.add(shPitnit);
		return list;
	}
	
	public String getName(int id) throws SQLException{
		DBConnector db = DBConnector.getInstance();
		ResultSet rs = db.selectNameByIdFromMenu(id);
		String str = "";
		if(rs.next()){
			str = rs.getString(1);
		}
		return str;
	}
	
	public ArrayList<Ingredienti> getIngredientsOf(int id){
		return null;
	}
}
