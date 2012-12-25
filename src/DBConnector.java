import java.sql.*;
import java.util.*;

public class DBConnector{
	private static Object lock  = new Object();
	static String server = "localhost";
	static String password = "malibu";
	static String account = "root";
	static String database = "mysql";
	private static  Connection con;
	private static DBConnector db;
	
	public static DBConnector getInstance(){
		synchronized(lock){
			if(db==null) db = new DBConnector();
			return db;
		}
	}
	
	private DBConnector(){
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://" + server, account, password);
		}
		//es eqseption rom ar moxdes conector jar chaagdet web-inf_is lib foldershic
		catch (ClassNotFoundException e) {
			  e.printStackTrace();
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
	}
	
	public ResultSet getTables(){
		
	}
	
}