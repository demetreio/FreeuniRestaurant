<%@ page import="ge.edu.freeuni.restaurant.logic.*"%>

<%
	int id = Integer.parseInt(request.getParameter("tableId"));
	ReservedTablesInfo rti = new ReservedTablesInfo();
	boolean click = false;
	if(session.getAttribute("user") != null){
		click = true;
	}
	
	boolean[] b = rti.getReservation(id);
	for (int i = 0; i < b.length; i++) {
		out.print("<td onClick=\"getColor(this)\" style=\"background-color:"+(b[i]?"red":"green")+"\"></td>");
	}
%>