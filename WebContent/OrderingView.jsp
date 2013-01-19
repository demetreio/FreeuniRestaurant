<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ge.edu.freeuni.restaurant.logic.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PLACING ORDER</title>
</head>
<body>

	<%! 
	private User usr;
	private String usrname;
	private Menu menu;
	private ArrayList<Kerdzi> mu;
	%>
	<%
	menu = new Menu();
	mu = menu.getMenu();
	if(session.getAttribute("user") != null)
		usr = (User)session.getAttribute("user");
		usrname = usr.getUsername();
	%>
	<center>
	<form action="PlaceOrderServlet" method="post">
		<h1 style="color: green;">Place your  please:</h1>
		
		<input type="hidden" name=username  value="<%= usrname %>"/>
		<input type="hidden" name=menuSize  value="<%= mu.size() %>"/>

		<table border="1">
			<tr>
				<th>Dish name</th>
				<th>price</th>
				<th>kind</th>
				<th>amount</th>
			</tr>
			<%
			for(Kerdzi k : mu){
				out.print("<tr>");
				out.print("<td>"+k.getName()+"</td>");
				out.print("<td>"+k.getPrice()+"</td>");
				out.print("<td>"+k.getSaxeoba()+"</td>");
				out.print("<td><input type=\"number\" name=\"dish#"+ k.getId() +"\" min=\"0\" max=\"50\" value=\"0\"></td>");
				out.print("</tr>");
			}
			%>
		</table>
		<input type="submit" value="Place Order">
		
	</form>
	</center>
</body>
</html>