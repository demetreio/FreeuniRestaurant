<%@page import="java.util.ArrayList"%>
<%@ page import="ge.edu.freeuni.restaurant.logic.*"%>
<table border="1">
			<tr>
				<td align="center" rowspan="2">Table ID</td>
				<td align="center" rowspan="10">Status</td>
				<td align="center" rowspan="10">Occupant</td>
			</tr>
<%
	//<%if(admin){<jsp:include page="RealtimeTableView.jsp" ></jsp:include><%} 
	System.out.println("asdddddddddddddddddddddddddddddddddddddddd");
	TableInfo ti = new TableInfo();
	ArrayList<Table> tables = ti.getAllTables();
	Table curTable;
	for (int i = 0; i < tables.size(); i++) {
		curTable = tables.get(i);
		out.print("<tr class=\"tr\" id=\"");
		out.print(curTable.getId()+"\">");
		out.print("<td>");
		out.print(curTable.getId());
		out.print("</td>");
		out.print("<td>");
		out.print(curTable.isBusy());
		out.print("</td>");
		out.print("<td>");
		out.print(curTable.getOccupantName());
		out.print("</td>");
		out.print("</tr>");
	}
%>	
</table>

