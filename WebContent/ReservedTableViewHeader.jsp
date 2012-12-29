<%@ page import="ge.edu.freeuni.restaurant.model.*"%>

<%
	for (double i = 9; i < 24.5; i+=1) {
		out.print("<td align=\"center\">" + (int)i+":"+ (i%1==0?"00":"30") + "</td>");
	}
%>