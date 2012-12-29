package ge.edu.freeuni.restaurant.model;

import com.mysql.jdbc.MySQLConnection;
import com.mysql.jdbc.ResultSetImpl;
import com.mysql.jdbc.StatementImpl;

public abstract class AbstractResultSet extends ResultSetImpl{

	public AbstractResultSet(long updateCount, long updateID,
			MySQLConnection conn, StatementImpl creatorStmt) {
		super(updateCount, updateID, conn, creatorStmt);
		// TODO Auto-generated constructor stub
	}

}
