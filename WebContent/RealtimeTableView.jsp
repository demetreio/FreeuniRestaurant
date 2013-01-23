<%@page import="java.util.ArrayList"%>
<%@ page import="ge.edu.freeuni.restaurant.logic.*"%>
<table border="1">
			<tr>
				<td align="center" rowspan="2">Table ID</td>
				<td align="center" rowspan="2">Status</td>
				<td align="center" rowspan="2">Occupant</td>
			</tr>
<%
	out.print("<tr></tr>");
	TableInfo ti = new TableInfo();
	ArrayList<Table> tables = ti.getAllTables();
	Table curTable;
	for (int i = 0; i < tables.size(); i++) {
		curTable = tables.get(i);
		out.print("<tr id=\"");
		out.print(curTable.getId()+"\">");
		out.print("<td>");
		out.print(curTable.getId());
		out.print("</td>");
		out.print("<td>");
		if(curTable.isBusy())out.print("Busy");
		else out.print("Free");
		out.print("</td>");
		out.print("<td>");
		if(curTable.isBusy())out.print(curTable.getOccupantName());
		out.print("</td>");
		out.print("</tr>");
	}
%>	
</table>

