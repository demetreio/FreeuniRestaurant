<%@ page import="ge.edu.freeuni.restaurant.model.*"%>

<%
	int id = Integer.parseInt(request.getParameter("tableId"));
	ReservedTablesInfo rti = new ReservedTablesInfo();

	boolean[] b = rti.getReservation(id);
	for (int i = 0; i < b.length; i++) {
		out.print("<td style=\"background-color:"+(b[i]?"red":"green")+"\"></td>");
	}
%>