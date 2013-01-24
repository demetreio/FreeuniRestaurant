package ge.edu.freeuni.restaurant.logic;

public class Ingredienti {
	
	private int kerdzisId;
	private String name;
	private double quantity;
	private String unit;
	
	
	public Ingredienti(int kerdzisId, String name, double quantity, String unit){
		this.kerdzisId = kerdzisId;
		this.name = name;
		this.quantity = quantity;
		this.unit = unit;
	}
	
	public int getKerdzisId(){
		return kerdzisId;
	}
	
	public String getName(){
		return name;
	}
	
	public double getQuantity(){
		return quantity;
	}
	
	public String getUnit(){
		return unit;
	}
	
}
