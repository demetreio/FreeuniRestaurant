<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="ge.edu.freeuni.restaurant.logic.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FreeUni restaurant table view</title>
</head>
<body>
	<center>
		<table border="1">
			<tr>
				<td align="center" rowspan="2">Table ID</td>
				<td align="center" rowspan="2">Description</td>
				<td align="center" rowspan="2">Size</td>
				<td align="center" colspan="15">Today</td>
				<td align="center" colspan="15">Tomorrow</td>
			</tr>
			<tr>
				
				<%-- es nawili pasuxs agebs "dajavshnuli/ardajavshnulis" tavze saatebis gamotanaze --%>
				<jsp:include page="ReservedTableViewHeader.jsp" ></jsp:include>
				
				
			</tr>
			<%
				TableInfo ti = new TableInfo();
					ArrayList<ge.edu.freeuni.restaurant.logic.Table> tables = ti.getAllTables();
					ge.edu.freeuni.restaurant.logic.Table curTable;
					for (int i = 0; i < tables.size(); i++) {
						curTable = tables.get(i);
						out.print("<tr>");
						out.print("<td>");
						out.print(curTable.getId());
						out.print("</td>");
						out.print("<td>");
						out.print(curTable.getDescription());
						out.print("</td>");
						out.print("<td>");
						out.print(curTable.getSize());
						out.print("</td>");
			%>		<%-- es nawili pasuxs agebs "dajavshnuli/ardajavshnulis" chvenebaze --%>
					<jsp:include page="ReservedTableView.jsp" ><jsp:param name="tableId" value="<%=curTable.getId()%>" /></jsp:include>
			<%
					out.print("</tr>");
				}
			%>
		</table>
	</center>
</body>