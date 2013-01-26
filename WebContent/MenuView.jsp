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
<%if(admin)out.print("(admin)");} %>
</h3>

<form action="MenuDateChangeServlet" method="post">

<%
String date = (String)session.getAttribute("date");
int year = Integer.parseInt(date.substring(0, 4));
int month;
if(date.charAt(5)=='0') month = Integer.parseInt(date.charAt(6) + "");
else month = Integer.parseInt(date.substring(5,7));
int day;
if(date.charAt(8)=='0') day = Integer.parseInt(date.charAt(9)+"");
else day = Integer.parseInt(date.substring(8,10));

%>

<center>

<select name="day">

<% for(int count=1; count<=31; count++){ %>
     <% if(count==day) {%>
    <option selected="selected"><%=count%></option>  
    <% } else { %>
    <option><%=count%></option>
    <% }%> 
<%} %>

</select> 

<select name="month">

<% for(int count=1; count<=12; count++){ %>
    <% if(count==month) {%>
    <option selected="selected"><%=count%></option>  
    <% } else { %>
    <option><%=count%></option>
    <% }%>  
<%} %>

</select>

<select name="year">

<% for(int count=2012; count<=2013; count++){ %>
    <% if(count==year) {%>
    <option selected="selected"><%=count%></option>  
    <% } else { %>
    <option><%=count%></option>
    <% }%>  
<%} %>

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
					ArrayList<Kerdzi> kerdzebe = menu.getMenuByDate(date);
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