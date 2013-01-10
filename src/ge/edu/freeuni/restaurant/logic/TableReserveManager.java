package ge.edu.freeuni.restaurant.logic;

import java.sql.SQLException;

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
	
	public void reserveForUser(String userId, int table_id, String timeIndex) throws SQLException{
		dbc.reserveForUser(userId, table_id, timeIndex);
	}
}
