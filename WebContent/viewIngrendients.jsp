<%@page import="ge.edu.freeuni.restaurant.logic.Menu"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ingredients</title>
</head>
<body>
<%
//Menu dish = new Menu();
out.print(Integer.parseInt(request.getParameter("id")));
//dish.getIngredientsOf(Integer.parseInt(request.getParameter("id")));
%>
</body>
</html>