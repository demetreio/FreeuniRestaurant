import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservedTablesInfo implements ReservedTebles {

	public ReservedTablesInfo(){
		
	}
	
	/**
	 * Return boolean array. Each index of array represents
	 * one hour period. Value 'true' on index i means that 
	 * the table is reserved after the i-th hour after
	 * the restaurant is opened
	 */
	@Override
	public boolean[] getReservation(Table table) {
		int id = table.getId();
		return getReservationInfo(id);
	}

	/**
	 * Connect to db and obtain reservation data
	 * @param id Table id
	 * @return
	 */
	private boolean[] getReservationInfo(int id){
		DBConnector dbc = DBConnector.getInstance();
		ResultSet rs = dbc.getResInfo(id);
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
			arr[i] = res.charAt(i)==1? true : false;
		}
		return arr;
	}
}
