package ge.edu.freeuni.restaurant.logic;

import java.util.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UserWithTableInfo {
	public static void main(String[] args) throws ParseException, SQLException {
	//	 DBConnector db = DBConnector.getInstance();
	//	 String d = db.getCurrentDate();
	//	 Date date = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss", Locale.ENGLISH).parse(d);
	//	 System.out.println(date);
	//	 Date d1 = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss", Locale.ENGLISH).parse("2013-01-23 15:00:00");
	//	 int x = date.compareTo(d1);
	//	 System.out.println(x);
	}
	
	
	public UserWithTableInfo(String username, int table_id, String reserveInfo) throws SQLException, ParseException{
		this.username = username;
		this.table_id = table_id;
		this.reserveInfo = reserveInfo;
		DBConnector db = DBConnector.getInstance();
		curdate = db.getCurrentDate();
		sysdate = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss", Locale.ENGLISH).parse(curdate);
	}
	
	public void updateUsersBookedTablesIfLate() throws SQLException, ParseException {
		DBConnector db = DBConnector.getInstance();
		for(int i=0; i<reserveInfo.length()/2; i++){
			if(reserveInfo.charAt(i)=='2' && !db.isOccupiedTable(table_id)){
				Date date = dateForIndex(i, curdate);
				updateIfLate(i, date);
			}
		}
	}
	
	private String getYearMonthAndDay(String d){
		StringTokenizer st = new StringTokenizer(d);
	//	String ymd = st.nextToken();
	//	String year = ymd.substring(0, 4), month = ymd.substring(5, 7), day = ymd.substring(8, 9);
		return st.nextToken();
	}
	
	private Date dateForIndex(int i, String curdate) throws ParseException {
		int hour = 10 + i;
		String hh = formatToTwoDigit(hour);
		String dateStr = getYearMonthAndDay(curdate)+" "+hh+":"+"00:00";
		if(hour==24) dateStr = getYearMonthAndDay(curdate)+" "+23+":"+"59:59";
		return new SimpleDateFormat("yyyy-mm-dd hh:mm:ss", Locale.ENGLISH).parse(dateStr);
	}
	
	private String formatToTwoDigit(int x){
		return x>=10? (""+x): ("0"+x);
	}
	
	private void updateIfLate(int timeIndex, Date date) throws ParseException, SQLException {
		if(sysdate.compareTo(dateForIndex(timeIndex, curdate))>=0){ // user is late
			DBConnector db = DBConnector.getInstance();
			db.deleteReservation(table_id, timeIndex, username);
			db.deleteReservationFromReservedTables(table_id, timeIndex);
			UserHistory uh = new UserHistory();
			uh.changeUserHistory(username, 1, 0, 0);
		}
	}
	
	public String getUserName(){
		return username;
	}
	
	public int getTableId(){
		return table_id;
	}
	
	private String username;
	
	private Date sysdate;
	
	private String reserveInfo;
	
	private String curdate;
	
	private int table_id;
	
}