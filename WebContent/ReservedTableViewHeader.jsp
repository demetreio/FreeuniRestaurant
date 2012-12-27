<%@ page import="ge.edu.freeuni.restaurant.model.*"%>

<%
	for (double i = 8; i < 24.5; i+=0.5) {
		out.print("<td align=\"center\">" + (int)i+":"+ (i%1==0?"00":"30") + "</td>");
	}
%>