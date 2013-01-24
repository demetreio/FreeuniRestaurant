package ge.edu.freeuni.restaurant.presentation;

import ge.edu.freeuni.restaurant.logic.DBConnector;
import ge.edu.freeuni.restaurant.logic.TableReserveManager;
import ge.edu.freeuni.restaurant.logic.User;
import ge.edu.freeuni.restaurant.logic.UserManager;
import ge.edu.freeuni.restaurant.logic.shekveta;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PlaceOrderServlet
 */
@WebServlet("/UserWasServed")
public class UserWasServed extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserWasServed() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("user");
		Boolean isAdmin = false;
		User user;

		if(request.getSession().getAttribute("user") != null){ 
			user = (User)request.getSession().getAttribute("user");
			if(DBConnector.getInstance().isCorrectUsernameAndPassword(user.getUsername(), user.getPassword()) 
					&& DBConnector.getInstance().isAdmin(user.getUsername()) ){
				isAdmin = true;
			}
		}
		
		if(isAdmin){
			try {
				DBConnector.getInstance().removeFromShekvetaByName(username);
			} catch (SQLException e) {
				System.out.println("WTF?! doPost:UserWasServed. Couldn't remove orders");
				e.printStackTrace();
			}
		}
		RequestDispatcher dispatch = request.getRequestDispatcher("TableView.jsp");
		dispatch.forward(request, response);
	}
}
