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
<th>Ingredient name</th>
<th>Unit</th>
<th>Quantity</th>
</tr>

<%
/* if(request.getAttribute(arg0)){
	
}
else{
	int prod_id =Integer.parseInt(request.getParameter("id")); 	
} */
int prod_id =Integer.parseInt(request.getParameter("id")); 
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
	out.print("<td>");
	out.print("	<input type=\"submit\" name=butt value=\"delete\">");
	out.print("</td>");
	out.print("</tr>");
}
%>
</table>

	<form action="AddingIngredientsServlet" method="post">
		<p></p>
		<input type="text" name=ingredient_name  placeholder="Ingredient name" />
		<br>
		<input type="text" name=unit   placeholder="Unit" />
		<br>
		<input type="text" name=quantity   placeholder="Quontity" />
		<br>
		<input type="submit" name=butt value="Add">
		<br>
		<%
		out.print("<input type =\"hidden\" name =\"hidden\" value=\""); 
		out.print(prod_id);
		out.print("\">");
		%>
		
	</form>

</body>
</html>