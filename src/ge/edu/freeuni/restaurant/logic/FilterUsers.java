package ge.edu.freeuni.restaurant.logic;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FilterUsers
 */
@WebServlet("/FilterUsers")
public class FilterUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilterUsers() {
        super();
        // TODO Auto-generated constructor stub
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
		DBConnector dbc = DBConnector.getInstance();
		String param = request.getParameter("fieldi");
		ArrayList<User> list = dbc.filterUsers(param);
		
		request.getSession().setAttribute("filteredUsers", list);
		RequestDispatcher dispatch = request.getRequestDispatcher("/UserManagement.jsp");
		dispatch.forward(request, response);
	}

}
