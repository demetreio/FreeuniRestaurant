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
	
	public void changeUserHistory(String userName, int isbooked, int came, double moneySpent){
		DBConnector db = DBConnector.getInstance();
		int notCome = 0;
		if(isbooked == 1 && came == 0) notCome = 1;
		db.updateResultsInUserHistory(userName, came, isbooked, notCome, moneySpent);
	}
}
