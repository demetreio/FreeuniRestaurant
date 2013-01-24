package ge.edu.freeuni.restaurant.logic;

import java.sql.SQLException;


/**
 * TODO Put here a description of what this class does.
 *
 * @author Kote.
 *         Created Dec 29, 2012.
 */
public class UserManager {
	private DBConnector dbc;

	public UserManager() {
		dbc = DBConnector.getInstance();
	}
	
	public boolean isCorrectUsernameAndPassword(String username, String password){
		return dbc.isCorrectUsernameAndPassword(username, password);
	}
	public boolean registerNewUser(User user){
		return dbc.registerNewUser(user);
	}
	public boolean isAdmin(String username){
		return dbc.isAdmin(username);
	}
	
	public void insertIntoUserHistoryTable(String username) throws SQLException {
		dbc.initializeUserHistoryTable(username);
	}
	
	public User getUser(String username){
		return dbc.getUser(username);
	}
	
	public void deleteUser(String username){
		dbc.deleteUser(username);
	}
	
	/**
	 * momxmarebeli tu ar arsebobs, dbc.getUser(username) sheqmnis
	 * User obieqts, romelic null aris da ar gauketebs inicializebas.
	 * @param username
	 * @return
	 */
	public boolean userExists(String username){
		User usr = dbc.getUser(username);
		if(usr == null){
			return false;
		}
		return true;
	}
}
