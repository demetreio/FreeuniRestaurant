package ge.edu.freeuni.restaurant.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserHistory {
	
	public ArrayList<History> getAllUsersHistory() throws SQLException{
		ArrayList<History> list = new ArrayList<History>();
		DBConnector db = DBConnector.getInstance();
		ResultSet rs = db.selectFromUserHistory();
		while(rs.next()){
			History h = new History(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDouble(5));
			list.add(h);
		}
		return list;
	}
}
