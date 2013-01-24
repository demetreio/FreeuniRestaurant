<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ge.edu.freeuni.restaurant.logic.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ordered Dishes</title>
</head>
<body>
		<%! 
		String userName;
		Boolean isAdmin = false;
		User user;
		%>
		<%
		if(session.getAttribute("user") != null){ 
			user = (User)session.getAttribute("user");
			if(DBConnector.getInstance().isCorrectUsernameAndPassword(user.getUsername(), user.getPassword()) 
					&& DBConnector.getInstance().isAdmin(user.getUsername()) ){
				isAdmin = true;
			}
		}
		userName = request.getParameter("user");
		if(isAdmin){
		%>
		<h1 style="color: green;">Orders By <%= userName%>></h1>
		<% session.setAttribute("ordersByUser", userName);%>
		<jsp:include page="PlacedOrderView.jsp" ></jsp:include>
		<%}else{ %>
		<h1>
		katis k chertiam sabachiam :)
		</h1>
		<%}%>
</body>
</html>