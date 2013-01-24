<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="ge.edu.freeuni.restaurant.logic.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FreeUni restaurant table view</title>
</head>
<body>
	<%! private boolean admin = false; private User usr;%>
	<%if(session.getAttribute("user") != null){ 
	usr = (User)session.getAttribute("user");
	admin = usr.isAdmin();%>
	<h3>Welcome <%=usr.getName() %><%if(admin)out.print("(admin)"); %></h3>
	<%if(admin){ %>
		<a href="UserManagement.jsp">user management</a>
		<a href="AdminMenuView.jsp">Change Restaurant Menu</a>
		<a href="UserHistoryView.jsp">View User Stai</a>
	<%} else {
		%><a href="MenuView.jsp">Restaurant Menu</a><% }}%>
	<center>
	
	<%-- achvenebs useris mier shekvetil menius --%>
	<% session.setAttribute("ordersByUser", usr.getUsername());%>
	<jsp:include page="PlacedOrderView.jsp" ></jsp:include>
	<br>
	<P></P>
		<table border="1">
			<tr>
				<td align="center" rowspan="2">Table ID</td>
				<td align="center" rowspan="2">Description</td>
				<td align="center" rowspan="2">Size</td>
				<td align="center" colspan="15">Today</td>
				<td align="center" colspan="15">Tomorrow</td>
			</tr>
			<tr>
				
				<%-- es nawili pasuxs agebs "dajavshnuli/ardajavshnulis" tavze saatebis gamotanaze --%>
				<jsp:include page="ReservedTableViewHeader.jsp" ></jsp:include>
				
				
			</tr>
			<%
			UserTableCheck utc = new UserTableCheck();
			utc.checkAndUpdateDatabase();
			
			TableInfo ti = new TableInfo();
			ArrayList<ge.edu.freeuni.restaurant.logic.Table> tables = ti.getAllTables();
			ge.edu.freeuni.restaurant.logic.Table curTable;
			for (int i = 0; i < tables.size(); i++) {
			curTable = tables.get(i);
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
			%>		<%-- es nawili pasuxs agebs "dajavshnuli/ardajavshnulis" chvenebaze --%>
					<jsp:include page="ReservedTableView.jsp" ><jsp:param name="tableId" value="<%=curTable.getId()%>" /></jsp:include>
			<%
					out.print("</tr>");
				}
			%>
		</table>
	</center>

	<form id="theForm" method="post" action="Book">  
		<input type="hidden" name="fieldi"/>  
	</form>
		<form action="javascript:forward()">
	<%if(admin){ %>
			<input type="text">
	<%} %>
			<input type="submit" value="save">
		</form>
	<center>
		<%if(admin){%><jsp:include page="RealtimeTableView.jsp" ></jsp:include><%}%>
	</center>
	<script>
		function getColor(elem){
		    var col = elem.style.backgroundColor;
		    if(col == "blue"){
		    	col = "green";
		    }<%if(admin){ %>else if(col == "red"){
		    	col = "green";
		    }<%} %>else if(col == "green"){
		    	col = "blue";
		    }
		    elem.style.backgroundColor = col;
		}
		
		function forward(){
			var val = document.getElementsByTagName("input")[1].value;
			if(val!=""){
				var tr = document.getElementsByClassName("tr");
				var person_name = "<%=usr.getUsername() %>";
				<%if(admin){ %>
				person_name = val;
				<%} %>
				var pass_param = ""+person_name;
				for(var i = 0; i < tr.length; i++){
					var id = tr[i]["id"];
					var td = tr[i].getElementsByTagName("td");
					pass_param += ","+id+",";
					for(var j = 3; j < td.length; j++){
						var col = td[j].style.backgroundColor;
						pass_param += (col=="red"?"1":col=="green"?0:2);
					}
				}
				submitForm(pass_param);
			}
		}
		
		function submitForm (a) { 
			var myForm = document.getElementById("theForm");  
			  
			myForm.fieldi.value = a;  
			myForm.submit(this);  
		}
	</script>
</body>
</html>