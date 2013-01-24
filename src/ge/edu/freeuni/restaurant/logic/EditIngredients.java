package ge.edu.freeuni.restaurant.logic;

import java.sql.SQLException;

public class EditIngredients {
	
	public void deleteEngredient(int kerdzisId, String ingredientName) throws SQLException{
		DBConnector db = DBConnector.getInstance();
		db.deleteFromIngredients(kerdzisId, ingredientName);
	}
	
	public void changeQuantity(int kerdzisId, String ingredientName, double newQuantity) throws SQLException {
		DBConnector db = DBConnector.getInstance();
		db.changeQuantityIntoIngredients(kerdzisId, ingredientName, newQuantity);
	}
	
	public void addIngredient(int kerdzisId, String ingredientName, double quantity, String unit) throws SQLException {
		DBConnector db = DBConnector.getInstance();
		db.insertIntoIngredients(kerdzisId, ingredientName, quantity, unit);
	}
	
}
