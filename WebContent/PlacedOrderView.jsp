<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ge.edu.freeuni.restaurant.logic.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.*"%>

<center>
<div border="1">
    <h1 style="color: green;">Placed orders:</h1>
    
    <%!
		private String usrname;
    	private ArrayList<shekveta.ShekvetisErteuli> dishes;
    	private shekveta sh;
	%>
	<%
		if(session.getAttribute("ordersByUser") != null){ 
			usrname = (String)session.getAttribute("ordersByUser");
			
			sh = shekveta.readAndCreate(usrname);
			dishes = sh.getDishes();
	
		}
	%>
	
	<table border="1">
		<tr>
		
			<th>Table ID</th>
			<th>Dish name</th>
			<th>Amount</th>
			<th>Order Time</th>
		</tr>
		<%
			ArrayList<String> times = sh.getOrderTime();
			ArrayList<Integer> ids = sh.getOrderTableId();
			int i = 0;
			for(shekveta.ShekvetisErteuli dish : dishes){
				out.print("<tr>");
				out.print("<td>"+ ids.get(i) + "</td>");
				out.print("<td>"+ (new Menu()).getName(dish.getId()) +"</td>");
				out.print("<td>"+dish.getQuantity()+"</td>");
				out.print("<td>"+ times.get(i) + "</td>");
				out.print("</tr>");
				i++;
			}
		%>
	</table>
</div>
</center>