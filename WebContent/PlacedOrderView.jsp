<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ge.edu.freeuni.restaurant.logic.*"%>
<%@ page import="java.util.*"%>
    <h1 style="color: green;">Your order:</h1>
    
    <%! 
	private User usr;
	private String usrname;
	private shekveta sh;
	%>
	<%
	if(session.getAttribute("user") != null)
		usr = (User)session.getAttribute("user");
		usrname = usr.getUsername();
		sh = null;
	%>
	
	<table border="1">
		<tr>
			<th>Dish name</th>
			<th>amount</th>
		</tr>
		<%--
		for(){
			out.print("<tr>");
			out.print("<td>"+k.getName()+"</td>");
			out.print("<td>"+k.getPrice()+"</td>");
			out.print("<td>"+k.getSaxeoba()+"</td>");
			out.print("<td><input type=\"number\" name=\"dish#"+ k.getId() +"\" min=\"0\" max=\"50\" value=\"0\"></td>");
			out.print("</tr>");
		}
		--%>
	</center>