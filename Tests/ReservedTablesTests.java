import ge.edu.freeuni.restaurant.model.DBConnector;
import ge.edu.freeuni.restaurant.model.ReservedTablesInfo;
import ge.edu.freeuni.restaurant.model.Table;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.easymock.EasyMock;

public class ReservedTablesTests {
	@Test
	public void test1(){
		DBConnector dbMock = EasyMock.createMock(DBConnector.class);
		ReservedTablesInfo inf = new ReservedTablesInfo(dbMock);
		Table tableMock = EasyMock.createMock(Table.class);
		EasyMock.expect(tableMock.getId()).andReturn(0);
		EasyMock.expect(dbMock.getInstance()).andReturn((DBConnector) EasyMock.anyObject());
		
		ResultSet set = EasyMock.createMock(ResultSet.class);
		try {
			EasyMock.expect(set.getString(2)).andStubReturn("1000101101");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		EasyMock.expect(dbMock.getResInfo(0)).andReturn(set);
		
		EasyMock.replay(tableMock,dbMock,set);
		
		inf.getReservation(tableMock);
	}
}
