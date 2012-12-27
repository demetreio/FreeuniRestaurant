<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="ge.edu.freeuni.restaurant.model.*"%>
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
				<td align="center">Table ID</td>
				<td align="center">Description</td>
				<td align="center">Size</td>
			</tr>
			<%
				TableInfo ti = new TableInfo();
				ArrayList<Table> tables = ti.getAllTables();
				Table curTable;
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
					out.print("</tr>");
				}
			%>
		</table>
	</center>
</body>
