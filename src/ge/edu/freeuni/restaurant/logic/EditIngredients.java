package ge.edu.freeuni.restaurant.logic;

public class EditIngredients {
	
	public void deleteEngredient(int kerdzisId, String ingredientName){
		DBConnector db = DBConnector.getInstance();
		db.deleteFromIngredients(kerdzisId, ingredientName);
	}
	
	public void changeQuantity(int kerdzisId, String ingredientName, double newQuantity){
		DBConnector db = DBConnector.getInstance();
		db.changeQuantityIntoIngredients(kerdzisId, ingredientName, newQuantity);
	}
	
	public void addIngredient(int kerdzisId, String ingredientName, double quantity, String unit){
		DBConnector db = DBConnector.getInstance();
		db.insertIntoIngredients(kerdzisId, ingredientName, quantity, unit);
	}
	
}
