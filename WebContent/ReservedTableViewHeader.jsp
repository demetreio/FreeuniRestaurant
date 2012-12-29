<%@ page import="ge.edu.freeuni.restaurant.logic.*"%>

<%
	for (double i = 0; i < 30; i+=1) {
		out.print("<td align=\"center\">" + (int)(i%15+9)+":"+ (i%1==0?"00":"30") + "</td>");
	}
%>