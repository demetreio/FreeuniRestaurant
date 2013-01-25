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
	
	public ArrayList<Ingredienti> getIngredientsOf(int id) throws SQLException{
		DBConnector db = DBConnector.getInstance();
		ResultSet rs = db.selectFromIngredients(id);
		ArrayList<Ingredienti> list = new ArrayList<Ingredienti>();
		if(rs != null){
			while(rs.next()){
				Ingredienti i = new Ingredienti(id, rs.getString(1), rs.getDouble(2), rs.getString(3));
				list.add(i);
			}
		}
		return list;
	}
}
