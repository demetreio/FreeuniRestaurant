<%@page import="javax.mail.Session"%>
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
HttpSession ses = request.getSession();
int prod_id;
if(ses.getAttribute("id")==null){
	System.out.println("aq var");
	prod_id =Integer.parseInt(request.getParameter("id"));
}
else{
	Object obj = ses.getAttribute("id");
	prod_id = (Integer)obj;
} 
Menu dish = new Menu();
ArrayList <Ingredienti> ingred = dish.getIngredientsOf(prod_id);
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
	out.print("<form action=\"AddingIngredientsServlet\" method=\"post\">");
	out.print("<input type=\"submit\" name=butt value=\"Delete\">");
	out.print("<input type=\"hidden\" name= \"hiddel\" value = \"");
	out.print(curr.getName());
	out.print("\">");
	out.print("<input type=\"hidden\" name= \"hidid\" value = \"");
	out.print(curr.getKerdzisId());
	out.print("\">");
	out.print("</form>");
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
	<form action="BackServlet" method="post">
	<input type="submit" name=back value="back">
	
	</form>
	

</body>
</html>