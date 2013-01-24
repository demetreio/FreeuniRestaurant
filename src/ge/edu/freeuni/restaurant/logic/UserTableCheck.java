package ge.edu.freeuni.restaurant.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

public class UserTableCheck {
	public void getLists(ArrayList<String> usernames, ArrayList<Integer> ids, ArrayList<String> reserveInfos) throws SQLException{
		DBConnector db = DBConnector.getInstance();
		ResultSet rset = db.getAllRowsFromUserTable();
		while(rset.next()){
			String userName = rset.getString("username");
			usernames.add(userName);
			int tableId = Integer.parseInt(rset.getString("id"));
			ids.add(tableId);
			String reserveInfo = rset.getString("reserveInfo");
			reserveInfos.add(reserveInfo);
		}
	}
	
	public void markCameUser(String username, int table_id){
		DBConnector db = DBConnector.getInstance();
		try{
			db.markCameUser(username, table_id);
		}
		catch(SQLException ex){
			
		}
		catch(ParseException ex){
			
		}
	}
	
	public boolean isBookedByUserOnCurrentTime(String username, int table_id){
		DBConnector db = DBConnector.getInstance();
		try{
			return db.isBookedByUserOnCurrentTime(username, table_id);
		}
		catch(SQLException ex){
			ex.printStackTrace();
			return false;
		}
		catch(ParseException ex){
			ex.printStackTrace();
			return false;
		}
	}
	
	public void checkAndUpdateDatabase() throws SQLException, ParseException {
		ArrayList<String> usernames = new ArrayList<String>(), reserveInfos = new ArrayList<String>();
		ArrayList<Integer> ids = new ArrayList<Integer>();
		getLists(usernames, ids, reserveInfos);
		doChangesInCycle(usernames, ids, reserveInfos);
	}
	
	public void doChangesInCycle(ArrayList<String> usernames, ArrayList<Integer> ids, ArrayList<String> reserveInfos) throws
	SQLException, ParseException{
		for(int i=0; i<usernames.size(); i++){
			doUpdates(usernames, ids, reserveInfos, i);
		}
	}
	
	private void doUpdates(ArrayList<String> userNames, ArrayList<Integer> ids, ArrayList<String> reservedInfos, int ind) throws ParseException, SQLException{
		String userName = userNames.get(ind), reserveInfo = reservedInfos.get(ind);
		int tableId = ids.get(ind);
		//System.out.println("daerxa "+userName+" "+tableId+" "+reserveInfo);
		UserWithTableInfo userInfo = new UserWithTableInfo(userName, tableId, reserveInfo);
		userInfo.updateUsersBookedTablesIfLate();
	}
	
}
