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
	
	<table border="1">
		<tr>
			<th>Username</th>
			<th>Visits</th>
			<th>Bookings</th>
			<th>Not Come</th>
			<th>Attending Percentage</th>
			<th>Average Spent Money</th>
		</tr>
		<%
			UserHistory uh = new UserHistory();
			ArrayList<History> list = uh.getAllUsersHistory();
			if(list!=null){
				for(int i=0; i<list.size(); i++){
					out.print(" <tr> ");
					out.print("<td> "+list.get(i).getName()+" </td> ");
					out.print("<td> "+list.get(i).getNumberOfVisits()+" </td> ");
					out.print("<td> "+list.get(i).getNumberOfBookings()+" </td> ");
					out.print("<td> "+list.get(i).comingPersentage()+" </td> ");
					out.print("<td> "+list.get(i).averageMoneySpent()+" </td> ");
					out.print("</tr>");
				}
			}
		%>
		
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















<%--
out.print("<tr class=\"tr\" id=\"");
						out.print(curTable.getId()+"\">");
						out.print("<td>");
						out.print(curTable.getId());
						out.print("</td>");
						out.print("<td>");
						out.print(curTable.getDescription());
						out.print("</td>");
						out.print("<td>");
						out.print(curTable.getSize());
						out.print("</td>");
--%>						
						