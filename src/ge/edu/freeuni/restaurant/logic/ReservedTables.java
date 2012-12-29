package ge.edu.freeuni.restaurant.logic;
import java.sql.SQLException;


public interface ReservedTables {
	boolean[] getReservation(Table table) throws SQLException;
	// sxvebs gauqra es paili
}
