
package ge.edu.freeuni.restaurant.presentation;

import ge.edu.freeuni.restaurant.logic.RealTimeEdit;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
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
		String act = request.getParameter("butt");
		RealTimeEdit real = new RealTimeEdit();
		RequestDispatcher dispatch;
		if (act.equals("Stand up")) {
		    //stand up button was pressed
			real.setTableFree(Integer.parseInt(request.getParameter("hidden")));
			dispatch = request.getRequestDispatcher("TableView.jsp");

		} 
		else{
			real.setTableBusy(Integer.parseInt(request.getParameter("hidden")),request.getParameter("users"));
			dispatch = request.getRequestDispatcher("TableView.jsp");
		}
		dispatch.forward(request,response);
	}
}

