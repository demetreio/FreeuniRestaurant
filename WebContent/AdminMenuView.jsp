<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="ge.edu.freeuni.restaurant.logic.*"%>
<%@ page import="ge.edu.freeuni.restaurant.presentation.*"%>
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
<center>
<form action="UpdatePriceServlet" method="post">


<select name="day">

<option>1</option>
<option>2</option>
<option>3</option>
<option>4</option>
<option>5</option>
<option>6</option>
<option>7</option>
<option>8</option>
<option>9</option>
<option>10</option>
<option>11</option>
<option>12</option>
<option>13</option>
<option>14</option>
<option>15</option>
<option>16</option>
<option>17</option>
<option>18</option>
<option>19</option>
<option>20</option>
<option>21</option>
<option>22</option>
<option>23</option>
<option>24</option>
<option>25</option>
<option>26</option>
<option>27</option>
<option>28</option>
<option>29</option>
<option>30</option>
<option>31</option>

</select>

<select name="month">

<option>January</option>
<option>February</option>
<option>March</option>
<option>April</option>
<option>May</option>
<option>June</option>
<option>July</option>
<option>August</option>
<option>September</option>
<option>October</option>
<option>November</option>
<option>December</option>

</select>

<select name="year">

<option>2012</option>
<option>2013</option>

</select>

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
						out.print("<form action=\"AdminServlet\" method=\"post\">");
						out.print("<input type=\"hidden\" name= \"hidden\" value = \"");
						out.print(curKerdzi.getId());
						out.print("\">");
						out.print("<tr class=\"tr\" id=\"");
						out.print(curKerdzi.getId()+"\">");
						out.print("<td>");
						out.print(curKerdzi.getId());
						out.print("</td>");
						out.print("<td>");
						out.print(curKerdzi.getName());
						out.print("</td>");
						out.print("<td><input type=\"text\" name=\"price" + curKerdzi.getId()+ "\" value=\"" + curKerdzi.getPrice() + "\"");
						out.print("</td>");
						out.print("<td>" + curKerdzi.getSaxeoba());
						out.print("</td>");
						out.print("<td>");
						out.print("<input type=\"submit\" name=butt value=\"View \">");
						out.print("</td>");
						out.print("</tr>");
						out.print("</form>");
				}
			%>
</table>
			<input type="submit" name="update" value="Update Menu">
</form>
<form action="AddFoodServlet" method="post">
		Food Name: <input type="text" name="name"  />
		Price: <input type="text" name="price"   />
		Food type: <input type="text" name="saxeoba"   />
		
		<input type="submit" name=butt value="Add Food">
</form>
<form action="RemoveFoodServlet" method="post">
		Food ID you want to remove: <input type="text" name="id"  />
		<input type="submit" name=butt value="Remove Food">
</form>
</center>
</body>
</html>