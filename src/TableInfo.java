import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class TableInfo {
	
	
	public ArrayList<Table> getAllTables(){
		DBConnector dbc = DBConnector.getInstance();
		ResultSet rs = dbc.getTables();
		ArrayList<Table> list = new ArrayList<Table>();
		try {
			while(rs.next()){
				Table t = new Table(rs.getInt(1), rs.getInt(2), rs.getString(3));
				list.add(t);
			}
		} catch (SQLException e) {
			// TODO ??????
			e.printStackTrace();
		}
		return list;
	}
}
