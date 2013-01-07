package ge.edu.freeuni.restaurant.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TableInfo {

	public ArrayList<Table> getAllTables() throws SQLException {
		DBConnector dbc = DBConnector.getInstance();
		ResultSet rs = null;
		rs = dbc.TableJoinOccupation();
		ArrayList<Table> list = new ArrayList<Table>();
		
		while(rs.next()){
			int tableId = rs.getInt(1);
			int tableSize = rs.getInt(2);
			String description = rs.getString(3);
			int tableId1 = rs.getInt(4);
			String occupantId = rs.getString(5);
			boolean b = false;
			if(tableId == tableId1){
				b = true;
			}
			Table t = new Table(tableId, tableSize, description, b, occupantId);
			list.add(t);
		}
//		try {
//			while (rs.next()) {
//				ResultSet rs2 = null;
//				try {
//					rs2 = dbc.getOccupiedBy(rs.getInt(1));
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				boolean b = false;
//				String occupant = "";
//				try {
//					if (rs2.next()) {
//						b = true;
//						occupant = rs2.getString(2);
//					}
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				Table t = new Table(rs.getInt(1), rs.getInt(2),
//						rs.getString(3), b, occupant);
//				list.add(t);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println(list.size());
		return list;
	}
}