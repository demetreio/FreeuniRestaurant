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
	<script type='text/javascript'>
		
	<%
	    boolean redirect = true;
	    if(session.getAttribute("user") != null){ 
			User usr = (User)session.getAttribute("user");
			redirect = !usr.isAdmin();
	    }
	    if(redirect){
		%>
		window.location.replace("TableView.jsp");
	<%} %>
		
	</script>
	<form action="FilterUsers" method="post">
		<input type="text" name="fieldi" placeholder="name/surname"> <input
			type="submit" value="search">
	</form>
	<%if(session.getAttribute("filteredUsers") == null){
		out.println("<h1>Search for users</h1>");	
	}else{
		ArrayList<User> list = (ArrayList<User>)session.getAttribute("filteredUsers");
		if(list.size()==0){
			out.println("<h1>Your search returned no result</h1>");
		}else{
			out.println("<table border=\"1\">");
			out.println("<tr><th>Username</th><th>Name</th><th>Surname</th><th>Mail</th><th>Info</th><th>See Ordered Food</th><th>delete</th></tr>");
			for(User a:list){
				out.println("<tr><td>"+a.getUsername()+"</td><td>"+a.getName()+"</td><td>"+a.getSurname()+"</td><td>"+a.getMail()+"</td><td>"+a.getInfo()+"</td>");
				out.println("<td>");
				%>
				<form action="AdminOrdersView.jsp" method="post">
					<input type="hidden" name="user" value="<%=a.getUsername()%>">
					<input type="submit" value="see Orders">
				</form>	
				<%
				out.println("</td>");
				out.println("<td id=\""+a.getUsername()+"\" style=\"background: red;\" class=\"deleteCell\"></td>");
				out.println("</tr>");
			}
			out.println("</table>");
		}
	}
	session.removeAttribute("filteredUsers");%>
	
	<a href="TableView.jsp">go home</a>
	<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
	<script>
		$(document).ready(function() {
			$(".deleteCell").click(function(event) {
				var id = $(this).attr("id");
				$(this).parent().slideUp();
				$.ajax({
					type : "POST",
					url : "DeleteUser",
					data : "id=" + id,
					success : function() {
						alert("waishala " + id);
					}
				});
			});
		});
	</script>
</body>
</html>