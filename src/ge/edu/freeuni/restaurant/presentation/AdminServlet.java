
package ge.edu.freeuni.restaurant.presentation;

import ge.edu.freeuni.restaurant.logic.DBConnector;
import ge.edu.freeuni.restaurant.logic.RealTimeEdit;
import ge.edu.freeuni.restaurant.logic.User;
import ge.edu.freeuni.restaurant.logic.UserHistory;
import ge.edu.freeuni.restaurant.logic.UserTableCheck;

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
		String username = request.getParameter("users");
		int table_id = Integer.parseInt(request.getParameter("table"));
		if (act.equals("Stand up")) {
			username = request.getParameter("user");
		    //stand up button was pressed
			real.setTableFree(Integer.parseInt(request.getParameter("hidden")));
			dispatch = request.getRequestDispatcher("TableView.jsp");
			String moneySpent = request.getParameter("money");
//			System.out.println("spent money: "+moneySpent);
			try{
				double spent = Double.parseDouble(moneySpent);
				UserHistory uh = new UserHistory();
				int isBooked = new UserTableCheck().isBookedByUserOnCurrentTime(username, table_id)? 1: 0;
				uh.changeUserHistory(username, isBooked, 1, spent);
			}
			catch(NumberFormatException nfex){
			//	System.out.println("daerxa bandas");
			}
		} 
		else{
			UserTableCheck utc = new UserTableCheck();
			boolean isBooked = utc.isBookedByUserOnCurrentTime(username, table_id);
//			System.out.println("booked: "+isBooked);
			if(isBooked){
				utc.markCameUser(username, table_id);
			}
			real.setTableBusy(Integer.parseInt(request.getParameter("hidden")),request.getParameter("users"));
			dispatch = request.getRequestDispatcher("TableView.jsp");
		}
		dispatch.forward(request,response);
	}
}

