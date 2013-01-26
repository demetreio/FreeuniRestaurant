<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="ge.edu.freeuni.restaurant.logic.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FreeUni restaurant menu view</title>
</head>
<body>
<%! private boolean admin = false; private User usr;%>
<%if(session.getAttribute("user") != null){ 
	usr = (User)session.getAttribute("user");
	admin = usr.isAdmin();%>
<h3>Welcome <%=usr.getName() %>
<%if(admin)out.print("(admin)"); %>
</h3>
<%if(admin){ %>
<a href="UserManagement.jsp">user management</a>
<%} }%>

<form action="MenuDateChangeServlet" method="post">

<center>

<select name="day">

<% for(int count=1; count<=31; count++){ %>
    <option><%=count%></option>  
<%} %>

</select> 

<select name="month">

<% for(int count=1; count<=12; count++){ %>
    <option><%=count%></option>  
<%} %>

</select>

<select name="year">

<option>2012</option>
<option>2013</option>

</select>

<input type="submit" name=butt value="Show Menu">

</center>

</form>

<center>
<table border="1">
	<tr>
		<td align="center" rowspan="2">Kerdzis ID</td>
		<td align="center" rowspan="2">Name</td>
		<td align="center" rowspan="2">Price</td>
		<td align="center" rowspan="2">Saxeoba </td>
	</tr>
	<tr>

	</tr>
	<%
				Menu menu = new Menu();
					ArrayList<Kerdzi> kerdzebe = menu.getMenu();
					Kerdzi curKerdzi;
					for (int i = 0; i < kerdzebe.size(); i++) {
						curKerdzi = kerdzebe.get(i);
						out.print("<tr class=\"tr\" id=\"");
						out.print(curKerdzi.getId()+"\">");
						out.print("<td>");
						out.print(curKerdzi.getId());
						out.print("</td>");
						out.print("<td>");
						out.print(curKerdzi.getName());
						out.print("</td>");
						out.print("<td>");
						out.print(curKerdzi.getPrice());
						out.print("</td>");
						out.print("<td>");
						out.print(curKerdzi.getSaxeoba());
						out.print("</td>");
						out.print("</tr>");
				}
			%>
</table>

</center>
</body>
</html>