<%@page import="java.util.ArrayList"%>
<%@ page import="ge.edu.freeuni.restaurant.logic.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Management</title>
</head>
<body>
	<form action="FilterUsers" method="post">
		<input type="text" name="fieldi" placeholder="name/surname">
		<input type="submit" value="search">
	</form>
	<%if(session.getAttribute("filteredUsers") == null){
		out.println("<h1>Search for users</h1>");	
	}else{
		ArrayList<User> list = (ArrayList<User>)session.getAttribute("filteredUsers");
		if(list.size()==0){
			out.println("<h1>Your search returned no result</h1>");
		}else{
			out.println("<table border=\"1\">");
			out.println("<tr><th>Name</th><th>Surname</th><th>Info</th></tr>");
			for(User a:list){
				out.println("<tr id=\""+a.getUsername()+"\"><td>"+a.getName()+"</td><td>"+a.getSurname()+"</td><td>"+a.getInfo()+"</td></tr>");
			}
			out.println("</table>");
		}
	}
	session.removeAttribute("filteredUsers");%>
	<a href="TableView.jsp">go home</a>
	<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
	<script>
		$(document).ready(function () {
		     $("tr").click(function (event) {
				var id = $(this).attr("id");
				$(this).slideUp();
				$.ajax({  
				  type: "POST",  
				  url: "DeleteUser",
				  data: "id="+id,
				  success: function() {  
				  	alert("waishala "+id);
				  }  
				});
		     });
		 });
	</script>
</body>
</html>