<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ge.edu.freeuni.restaurant.logic.*"%>
<%@ page import="java.util.*"%>
    <center><h1 style="color: green;">Here Are All The Users' Statistics</h1> </center>
    
    <%! 
	private User usr;
	private String usrname;
	private shekveta sh;
	%>
	
	<center>
	<table border="1">
		<tr>
			<th>Username</th>
			<th>Visits</th>
			<th>Bookings</th>
			<th>Attending Percentage</th>
			<th>Average Spent Money</th>
		</tr> 
		<%
			UserHistory uh = new UserHistory();
			ArrayList<History> list = uh.getAllUsersHistory();
			if(list!=null){
				for(int i=0; i<list.size(); i++){
					out.print("<tr> ");
					out.print("<td> "+list.get(i).getName()+" </td> ");
					out.print("<td> "+list.get(i).getNumberOfVisits()+" </td> ");
					out.print("<td> "+list.get(i).getNumberOfBookings()+" </td> ");
					String perc = list.get(i).comingPersentage()==-1? "NA": ""+list.get(i).comingPersentage()+"%";
					out.print("<td> "+(perc)+" </td> ");
					String avg = list.get(i).averageMoneySpent()==-1? "NA": ""+list.get(i).averageMoneySpent();
					out.print("<td> "+avg+" </td> ");					out.print("</tr>");
				}
			}
		%>
		</center>
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

						