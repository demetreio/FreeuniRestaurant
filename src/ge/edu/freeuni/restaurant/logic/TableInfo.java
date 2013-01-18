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
		int rowcount = 0;
		if (rs.last()) {
		  rowcount = rs.getRow();
		  rs.beforeFirst();
		}
		
		if(rowcount == 0){
			rs = dbc.getTables();
			while(rs.next()){
				int tableId = rs.getInt(1);
				int tableSize = rs.getInt(2);
				String description = rs.getString(3);
				boolean b = false;
				Table t = new Table(tableId, tableSize, description, b, "");
				list.add(t);
			}
		}else {
		
			// joinis gaormageba rom ar chaiyaros xcrilshi, masivis daxmarebit
			// mxolod ertxel chavardeba magida
			int[] arr = new int[1000];
			while(rs.next()){
				int tableId = rs.getInt(1);
				if(arr[tableId]!=1){
					arr[tableId] = 1;
				}else continue;
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
		}
		return list;
	}
}