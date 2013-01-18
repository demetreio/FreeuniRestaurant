import ge.edu.freeuni.restaurant.logic.DBConnector;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;





public class DBConnectorTests {

	DBConnector db;
	
	
	@Before
	public void setUp() throws ClassNotFoundException, SQLException{
		db = DBConnector.getInstance();
		
		
	}
	
	
	@Test
	public void testOne() throws ClassNotFoundException, SQLException {
		
		
	}
	
}
