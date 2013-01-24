import static org.junit.Assert.*;
import ge.edu.freeuni.restaurant.logic.DBConnector;
import ge.edu.freeuni.restaurant.logic.shekveta;

import java.sql.*;
import java.util.*;
import org.junit.*;

public class shekvetaTest {
	DBConnector db;
	
	
	@Before
	public void setUp() throws ClassNotFoundException, SQLException{
		db = DBConnector.getInstance();
		db.setUpTables();
		
	}
	
	@Test
	public void getSizeTest(){
		shekveta sh = new shekveta("nikusha");
		sh.addShekveta(1, 2);
		sh.addShekveta(2, 3);
		sh.addShekveta(3, 1);
		assertTrue(sh.getSize() == 3);
		
		shekveta second = new shekveta("giorgi");
		
		assertTrue(second.getSize() == 0);
		
		sh.addShekveta(4, 30);
		
		assertTrue(sh.getSize() == 4);
		
	}
	
	@Test
	public void shekvetisErteuliTest(){
		
		shekveta sh = new shekveta("shota");
		sh.addShekveta(1, 2);
		sh.addShekveta(2, 3);
		sh.addShekveta(3, 1);
		ArrayList<shekveta.ShekvetisErteuli> arr = sh.getDishes();
		assertTrue(arr.get(0).getId() == 1);
		assertFalse(arr.get(0).getId() == 2);
		assertTrue(arr.get(0).getQuantity() == 2);
		assertTrue(arr.get(1).getId() == 2);
		assertTrue(arr.get(1).getQuantity() == 3);
		assertTrue(arr.get(2).getId() == 3);
		assertTrue(arr.get(2).getQuantity() == 1);
		
		
	}
	//saveIntoDbs vamowmeb daakvirdit rom bazidan xelit vigeb ragaceebs da ar viyeneb readAndCreate metods
	//radgan 1 metodi meoreze rom ar iyos damokidebuli testis dros
	@Test
	public void saveIntoDbTests() throws NumberFormatException, SQLException{
		db.setUpTables();
		shekveta sh = new shekveta("shota");
		sh.addShekveta(1, 2);
		sh.saveIntoDB();
		ResultSet rs = db.selectFromShekvetaByUserName("shota");
		while(rs.next()){
			String name = rs.getString("username");
			int kerdzi_id = Integer.parseInt(rs.getString("kerdzi_id"));
			int quantity = Integer.parseInt(rs.getString("quantity"));
			Assert.assertEquals(name, "shota");
			Assert.assertEquals(kerdzi_id, 1);
			Assert.assertEquals(quantity, 2);
			
		}
		
		shekveta shekv = new shekveta("nikusha");
		 shekv.addShekveta(10, 11);
		 shekv.saveIntoDB();
		 rs = db.selectFromShekvetaByUserName("nikusha");
		while(rs.next()){
			String name = rs.getString("username");
			int kerdzi_id = Integer.parseInt(rs.getString("kerdzi_id"));
			int quantity = Integer.parseInt(rs.getString("quantity"));
			Assert.assertFalse(name.equals( "dzamuka"));
			Assert.assertTrue(name.equals( "nikusha"));
			Assert.assertEquals(kerdzi_id, 10);
			Assert.assertEquals(quantity, 11);
		
		}
	}
	
	//aqac daakvirdit rom insertis dros ar viyeneb shekveta klasshi daweril gamzadebul (rac zemot davteste) saveIntoDb metods
	//rom ertmanetze ar iyos damokidebuli
	@Test
	public void readAndCreateTest() throws SQLException{
		db.insertIntoShekveta("pavle", 1, 1);
		db.insertIntoShekveta("pavle", 2, 2);
		db.insertIntoShekveta("pavle", 3, 3);
		db.insertIntoShekveta("pavle", 4, 4);
		db.insertIntoShekveta("pavle", 5, 5);
		
		shekveta sh = shekveta.readAndCreate("pavle");
		
		assertTrue(sh.getSize() == 5);
		
		ArrayList<shekveta.ShekvetisErteuli> arr = sh.getDishes();
		
		assertTrue(arr.get(0).getId() == 1);
		assertTrue(arr.get(0).getQuantity() == 1);
		assertTrue(arr.get(1).getId() == 2);
		assertTrue(arr.get(1).getQuantity() == 2);
		assertTrue(arr.get(2).getId() == 3);
		assertTrue(arr.get(2).getQuantity() == 3);
		assertTrue(arr.get(3).getId() == 4);
		assertTrue(arr.get(3).getQuantity() == 4);
		assertTrue(arr.get(4).getId() == 5);
		assertTrue(arr.get(4).getQuantity() == 5);
		
	}
}
