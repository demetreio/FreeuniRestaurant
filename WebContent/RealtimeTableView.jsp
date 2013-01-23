
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
		out.print("<form action=\"AdminServlet\" method=\"post\">");
		out.print("<input type=\"hidden\" name= \"hidden\" value = \"");
		out.print(curTable.getId());
		out.print("\">");
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
		if(curTable.isBusy()){
			out.print("<td>");
			out.print("<input type=\"submit\" name=butt value=\"Stand up\">");
			out.print("</td>");	
		}
		else{
			ArrayList <String> arr = User.getUsers();
			out.print("<td>");
			out.print("<input type=\"submit\" name=butt value=\"Order \">");
			out.print(" <select name = \"users\"> <option value=\"guest\" </option> ");
			for(int j = 0;j<arr.size();j++){
					out.print("<option> "+ arr.get(j) +"</option>");
			}
			out.print("</select>");
			out.print("</td>");		
		}
		
		out.print("</tr>");
		out.print("</form>");
	}
%>	
</table>


