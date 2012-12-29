package ge.edu.freeuni.restaurant.model;


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
	private boolean isAdmin(String username){
		return dbc.isAdmin(username);
		
	}
}
