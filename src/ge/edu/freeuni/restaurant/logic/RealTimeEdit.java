package ge.edu.freeuni.restaurant.logic;

public class RealTimeEdit {
	
	/**
	 * bazidan washlis am magidas dakavebulebidan
	 */
	public void setTableFree(int id){
		DBConnector db=DBConnector.getInstance();
		db.removeFromOccupation(id);
	}
	/**
	 * gadmoecema okupantis id.
	 * bazashi chawers am magidas dakavebulad
	 */
	public void setTableBusy(int id, String name){
		DBConnector db=DBConnector.getInstance();
		db.addIntoOccupation(id, name);
	}
}
