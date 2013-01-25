<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ge.edu.freeuni.restaurant.logic.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ordered Dishes</title>
</head>
<body>
		<%! 
		String userName;
		boolean isAdmin = false;
		User user = null;
		%>
		
		<%
		if(session.getAttribute("user") != null){ 
			user = (User)session.getAttribute("user");
			if(DBConnector.getInstance().isCorrectUsernameAndPassword(user.getUsername(), user.getPassword()) 
					&& DBConnector.getInstance().isAdmin(user.getUsername()) ){
				isAdmin = true;
			}
		}
		userName = user.getUsername();//("user");
		if(isAdmin){
			ArrayList<String> usersWithOrders = shekveta.usersWithSomeOrders();
			for(int i=0; i<usersWithOrders.size(); i++){
				userName = usersWithOrders.get(i);
		%>
			
		
			<h1 style="color: green;">Orders By <%= userName %></h1>
			<% session.setAttribute("ordersByUser", userName);%>
			
			
			<jsp:include page="PlacedOrderView.jsp"/>
			
			
			<form action="UserWasServed" method="post">
				<h1 style="color: green;">If user was served</h1>
				<p>
					<input type="hidden" value="<%= userName %>" name="user">
					Please push the button "already served", and the orders will be deleted
					<br>
					<input type="submit" value="Already served">
				</p>
			</form>
		<%
			}
		}else{ 
		out.print("	<h1>");
		out.print("	katis k chertiam sabachiam :)");
		out.print("	</h1>");
		}
		%>
</body>
</html>