package ge.edu.freeuni.restaurant.logic;

import java.sql.SQLException;
import java.text.ParseException;

/**
 * Calls table reserve methods from database.
 *
 * @author Kote.
 *         Created Jan 10, 2013.
 */
public class TableReserveManager {
	private DBConnector dbc;
	
	public TableReserveManager(){
		dbc = DBConnector.getInstance();
	}
	
	public boolean reserveTable(int table_id, String timeIndex) throws SQLException{
		return dbc.reserveTable(table_id, timeIndex);
		
	}
	
	public void reserveForUser(String userId, int table_id, String timeIndex) throws SQLException, ParseException{
		dbc.reserveForUser(userId, table_id, timeIndex);
	}
	
	public void mailReminder(String username, String timeIndex) throws SQLException, ParseException{
		for(int i = 0;i<timeIndex.length();i++){
			if(timeIndex.charAt(i) == '2'){
				java.util.Date d = dbc.getDateBeforeTimeIndex(i);
				UserManager um = new UserManager();
				MyThread mt = new MyThread(d, username, um.getUser(username).getMail());
				mt.start();
			}
		}
	}
}
