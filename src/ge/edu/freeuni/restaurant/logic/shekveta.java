package ge.edu.freeuni.restaurant.logic;
import java.util.*;
public class shekveta {

	
	ArrayList<sameuli> arr;
	public shekveta(String name, int kerdzi_id, int quantity){
		arr = new ArrayList<shekveta.sameuli>();
		sameuli sam = new sameuli(name, kerdzi_id, quantity);
		arr.add(sam);
		
	}
	
	public void addShekveta(String name, int kerdzi_id, int quantity){
		sameuli sam = new sameuli(name, kerdzi_id, quantity);
		arr.add(sam);
	}
	
	private class sameuli{
		private String name;
		private int id;
		private int quantity;
		public sameuli(String name, int kerdzi_id, int quantity){
			this.name = name;
			this.id = kerdzi_id;
			this.quantity = quantity;
		}
		public String getName() { return this.name; }
		public int getId() { return this.id; }
		public int getQuantity() { return this.quantity; }
	}
}
