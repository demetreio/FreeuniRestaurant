package ge.edu.freeuni.restaurant.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsersReservedTableInfo implements UsersReservedTable{
	
	public UsersReservedTableInfo(){
		//test
	}
	
	/**
	 * Return boolean array. Each index of array represents
	 * one hour period. Value 'true' on index i means that 
	 * the table is reserved after the i-th hour after
	 * the restaurant is opened
	 * @throws SQLException 
	 */
	@Override
	public boolean[] getUsersReservation(User user, int table_id) throws SQLException {
		String username = user.getUsername();
		return getUsersReservationInfo(username, table_id);
		
		//Testing
//		boolean [] arr = new boolean[30];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = (Math.random()>0.5)?true:false;
//		}
//		return arr;
	}
	
	public boolean[] getUsersReservation(String username, int table_id) throws SQLException {
		return getUsersReservationInfo(username, table_id);
		
		//Testing
//		boolean [] arr = new boolean[30];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = (Math.random()>0.5)?true:false;
//		}
//		return arr;
	}

	/**
	 * Connect to db and obtain User's reservation data
	 * @param id Table id
	 * @return
	 * @throws SQLException 
	 */
	private boolean[] getUsersReservationInfo(String username, int table_id) throws SQLException{
		DBConnector dbc = DBConnector.getInstance();
		ResultSet rs = null;
		try {
			rs = dbc.getUsersReservedInfo(username, table_id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String res = "";
		try {
			// Schedule represented as bitstring
			if(rs != null){
				res = rs.getString(3);
			}else{
				return getFreeArray(res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getArray(res);
	}

	/**
	 * Convert table data into boolean array
	 * @param res result from db
	 * @return boolean array
	 */
	private boolean[] getArray(String res) {
		boolean[] arr = new boolean[res.length()];
		for (int i = 0; i < res.length(); i++) {
			arr[i] = res.charAt(i)=='2'? true : false; 
		}
		return arr;
	}
	
	/**
	 * when rs is null
	 * @param res
	 * @return
	 */
	private boolean [] getFreeArray(String res){
		boolean[] arr = new boolean[30];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = false; 
		}
		return arr;
	}

	
}
