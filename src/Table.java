
public class Table {
	
	private int id;
	private int size;
	private String description;
	
	public Table(int id, int size, String description){
		this.id = id;
		this.size = size;
		this.description = description;
	}
	
	public int getId(){
		return id;
		
	}
	
	public int getSize(){
		return size;
	}
	
	public String getDescription(){
		return description;
		
	}
}
