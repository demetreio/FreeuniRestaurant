<%@ page import="ge.edu.freeuni.restaurant.model.*"%>

<%
	int id = Integer.parseInt(request.getParameter("tableId"));
	ReservedTablesInfo rti = new ReservedTablesInfo();

	boolean[] b = rti.getReservationInfo(id);
	for (int i = 0; i < 33 && i < b.length; i++) {
		out.print("<td style=\"background-color:"+(b[i]?"red":"green")+"\"></td>");
	}
%>