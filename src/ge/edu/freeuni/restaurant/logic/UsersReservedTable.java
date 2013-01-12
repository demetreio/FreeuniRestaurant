package ge.edu.freeuni.restaurant.logic;

import java.sql.SQLException;

public interface UsersReservedTable {
	boolean [] getUsersReservation (User user, int table_id) throws SQLException;
}
