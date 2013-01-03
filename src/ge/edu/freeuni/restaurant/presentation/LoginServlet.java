package ge.edu.freeuni.restaurant.presentation;

import ge.edu.freeuni.restaurant.logic.DBConnector;
import ge.edu.freeuni.restaurant.logic.User;
import ge.edu.freeuni.restaurant.logic.UserManager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String username = request.getParameter("username");
		String pass = request.getParameter("pass");
		RequestDispatcher dispatch;
		if(username.equals("") || pass.equals("")){
			dispatch = request.getRequestDispatcher("FillFields.html");
		}else{
			UserManager um = new UserManager();
			if(um.isCorrectUsernameAndPassword(username, pass)){
				User usr =  um.getUser(username);
				request.getSession().setAttribute("user", usr);
				dispatch = request.getRequestDispatcher("TableView.jsp");
			} else {
				dispatch = request.getRequestDispatcher("Register.html");
			}
		}
		dispatch.forward(request, response);
	}
}
