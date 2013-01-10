package ge.edu.freeuni.restaurant.logic;

public class Kerdzi {
	
	private int id; 
	private String name;
	private double price;
	private String saxeoba;
	
	public Kerdzi(int id, String name, double price, String saxeoba){
		this.id = id;
		this.name = name; 
		this.price = price;
		this.saxeoba = saxeoba;
		
	}
	
	public int getId(){
		
		return this.id;
	}
	
	public String getName(){
		
		return this.name;
	}
	
	public double getPrice(){
		
		return this.price;
	}
	
	public String getSaxeoba(){
		
		return this.saxeoba;
	}
	
	public void setId(int id){
		
		this.id = id;
	}
	
	public void setName(String name){
		
		this.name = name;
	}
	
	public void setPrice(double price){
		
		this.price = price;
	}
	
	public void setSaxeoba(String saxeoba){
		
		this.saxeoba = saxeoba;
	}
	
}
