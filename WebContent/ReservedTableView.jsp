 <%@ page import="ge.edu.freeuni.restaurant.logic.*"%>
<%@ page import="java.util.ArrayList;"%>

<%
	int id = Integer.parseInt(request.getParameter("tableId"));
	ReservedTablesInfo rti = new ReservedTablesInfo();
	UsersReservedTableInfo urti;
	boolean [] times = null;
	boolean click = false;
	ArrayList<Integer> table_id = null;
	if(session.getAttribute("user") != null){
		click = true;
		urti = new UsersReservedTableInfo ();
		times = urti.getUsersReservation((User)session.getAttribute("user"), id);
	}
	
	boolean[] b = rti.getReservation(id);
	CurrentTime curTime = new CurrentTime();
	for (int i = 0; i < b.length; i++) {
		if(curTime.timeIndexIsPast(i)){
			out.print("<td style=\"background-color: black\"></td>");
		}
		else if(times[i]){
			out.print("<td style=\"background-color: yellow\"></td>");
		}else{
			out.print("<td onClick=\"getColor(this)\" style=\"background-color:"+(b[i]?"red":"green")+"\"></td>");
		}
	}
%>