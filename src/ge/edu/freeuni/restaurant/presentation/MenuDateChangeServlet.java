package ge.edu.freeuni.restaurant.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuDateChangeServlet
 */
@WebServlet("/MenuDateChangeServlet")
public class MenuDateChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuDateChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date = "";
		int day = Integer.parseInt(request.getParameter("day"));
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		
		date+=year + "";
		if(month<10) date+= "0"+month;
		else date+=""+month;
		if(day<10) date+= "0"+day;
		else date+=""+day;
		
		request.getSession().removeAttribute("date");
		request.getSession().setAttribute("date", date);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("MenuView.jsp");
		dispatch.forward(request, response);
	}

}
