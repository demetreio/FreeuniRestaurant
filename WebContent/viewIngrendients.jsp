<%@page import="ge.edu.freeuni.restaurant.logic.Ingredienti"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ge.edu.freeuni.restaurant.logic.Menu"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ingredients</title>
</head>
<body>

<table border="1">
<tr>
<th>Header 1</th>
<th>Header 2</th>
<th>header3 </th>
</tr>
<tr>
<td>row 1, cell 1</td>
<td>row 1, cell 2</td>
</tr>
<tr>
<td>row 2, cell 1</td>
<td>row 2, cell 2</td>
</tr>

<%
Menu dish = new Menu();
out.print(Integer.parseInt(request.getParameter("id")));
ArrayList <Ingredienti> ingred = dish.getIngredientsOf(Integer.parseInt(request.getParameter("id")));
Ingredienti curr;
for(int i = 0;i<ingred.size();i++){
	curr = ingred.get(i);
	out.print("<tr>");
	out.print("<td>");
	out.print(curr.getName());
	out.print("</td>");
	out.print("<td>");
	out.print(curr.getUnit());
	out.print("</td>");
	out.print("<td>");
	out.print(curr.getQuantity());
	out.print("</td>");
	out.print("</tr>");
}
%>
</table>
</body>
</html>