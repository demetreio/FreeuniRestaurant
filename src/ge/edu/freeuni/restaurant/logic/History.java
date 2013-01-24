package ge.edu.freeuni.restaurant.logic;

import java.text.DecimalFormat;

public class History {
	private String userName;
	private int visits;
	private int bookings;
	private int notCome;
	private double totalMoneySpent;
	
	public History(String userName, int numberOfVisits, int numberOfBookings, int notCome, double totalMoneySpent){
		this.userName = userName;
		visits = numberOfVisits;
		bookings = numberOfBookings;
		this.notCome = notCome;
		this.totalMoneySpent = totalMoneySpent;
	}
	
	public String getName(){
		return userName;
	}
	
	public int getNumberOfVisits(){
		return visits;
	}
	
	public int getNumberOfBookings(){
		return bookings;
	}
	
	public double comingPersentage(){
		if(bookings==0) return -1;
		double d = ((double)bookings - notCome)/bookings;
		DecimalFormat df = new DecimalFormat("#.##");
		return Double.parseDouble(df.format(d))*100;
	}
	
	public double averageMoneySpent(){
		if(visits==0) return -1;
		double d = ((double) totalMoneySpent)/visits;
		DecimalFormat df = new DecimalFormat("#.##");
		return Double.parseDouble(df.format(d));
	}
}
