import ge.edu.freeuni.restaurant.logic.DBConnector;

import java.sql.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;





public class DBConnectorTests {

	DBConnector db;
	
	
	@Before
	public void setUp() throws ClassNotFoundException, SQLException{
		db = DBConnector.getInstance();
		db.setUpTables();
		
	}
	
	//shekveta cxrilshi insert operaciis da select operaciebis datestva
	@Test
	public void testOne() throws ClassNotFoundException, SQLException {
		db.insertIntoShekveta("dzamuka", 1, 3);
		ResultSet rs = db.selectFromShekvetaByUserName("dzamuka");
		while(rs.next()){
			String name = rs.getString("username");
			int kerdzi_id = Integer.parseInt(rs.getString("kerdzi_id"));
			int quantity = Integer.parseInt(rs.getString("quantity"));
			Assert.assertEquals(name, "dzamuka");
			Assert.assertEquals(kerdzi_id, 1);
			Assert.assertEquals(quantity, 3);
			
		}
		
		 db.insertIntoShekveta("nikusha", 5, 9);
		 rs = db.selectFromShekvetaByUserName("nikusha");
		while(rs.next()){
			String name = rs.getString("username");
			int kerdzi_id = Integer.parseInt(rs.getString("kerdzi_id"));
			int quantity = Integer.parseInt(rs.getString("quantity"));
			Assert.assertFalse(name.equals( "dzamuka"));
			Assert.assertTrue(name.equals( "nikusha"));
			Assert.assertEquals(kerdzi_id, 5);
			Assert.assertEquals(quantity, 9);
		
		}

		
	}
	
}
