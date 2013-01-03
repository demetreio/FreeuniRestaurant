package ge.edu.freeuni.restaurant.logic;


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
	
	public User getUser(String username){
		return dbc.getUser(username);
	}
}
