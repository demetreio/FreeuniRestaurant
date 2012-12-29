package ge.edu.freeuni.restaurant.logic;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservedTablesInfo implements ReservedTables {

	public ReservedTablesInfo(){
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
	public boolean[] getReservation(Table table) throws SQLException {
		int id = table.getId();
//		return getReservationInfo(id);
		
		//Testing
		boolean [] arr = new boolean[30];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (Math.random()>0.5)?true:false;
		}
		return arr;
	}
	
	public boolean[] getReservation(int id) throws SQLException {
//		return getReservationInfo(id);
		
		//Testing
		boolean [] arr = new boolean[30];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (Math.random()>0.5)?true:false;
		}
		return arr;
	}

	/**
	 * Connect to db and obtain reservation data
	 * @param id Table id
	 * @return
	 * @throws SQLException 
	 */
	private boolean[] getReservationInfo(int id) throws SQLException{
		DBConnector dbc = DBConnector.getInstance();
		ResultSet rs = null;
		try {
			rs = dbc.getReservedInfo(id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String res = "";
		try {
			// Schedule represented as bitstring
			res = rs.getString(2);
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
			arr[i] = res.charAt(i)=='1'? true : false; //ertians garshemo char-is brchyalebi aklda
		}
		return arr;
	}
}
