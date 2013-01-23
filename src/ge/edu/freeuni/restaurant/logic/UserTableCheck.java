package ge.edu.freeuni.restaurant.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class UserTableCheck {
	public void checkAndUpdateDatabase(){
		DBConnector db = DBConnector.getInstance();
		try{
			ResultSet rset = db.getAllRowsFromUserTable();
			while(rset.next()){
				String userName = rset.getString("username");
				int tableId = Integer.parseInt(rset.getString("id"));
				String reserveInfo = rset.getString("reserveInfo");
				UserWithTableInfo userInfo = new UserWithTableInfo(userName, tableId, reserveInfo);
				userInfo.updateUsersBookedTablesIfLate();
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		catch(ParseException ex){
			ex.printStackTrace();
		}
	}
}
