import ge.edu.freeuni.restaurant.logic.DBConnector;

import java.sql.*;

import org.junit.Before;
import org.junit.Test;





public class DBConnectorTests {

	DBConnector db;
	
	
	@Before
	public void setUp() throws ClassNotFoundException, SQLException{
		db = DBConnector.getInstance();
		
		
	}
	
	//shekveta cxrilshi insert operaciis da select operaciebis datestva
	@Test
	public void testOne() throws ClassNotFoundException, SQLException {
		db.insertIntoShekveta("dzamuka", 1, 3);
		ResultSet rs = db.selectFromShekvetaByUserName("dzamuka");
		
		
	}
	
}
