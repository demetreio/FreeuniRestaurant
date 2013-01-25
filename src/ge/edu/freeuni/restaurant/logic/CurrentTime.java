package ge.edu.freeuni.restaurant.logic;
import ge.edu.freeuni.restaurant.logic.DBConnector;

public class CurrentTime {
	/**
	 * Passed parameter is a timeIndex for the table.
	 * @param timeIndex the timeIndex.
	 * @return whether the respective time is past with respect to the current time.
	 */
	public boolean timeIndexIsPast(int timeIndex){
		DBConnector db = DBConnector.getInstance();
		try{
			boolean isPast = db.timeIndexIsPast(timeIndex);
			return isPast;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	
}
