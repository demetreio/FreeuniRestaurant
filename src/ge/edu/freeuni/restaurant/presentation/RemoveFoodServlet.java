package ge.edu.freeuni.restaurant.presentation;

import ge.edu.freeuni.restaurant.logic.EditMenu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveFoodServlet
 */
@WebServlet("/RemoveFoodServlet")
public class RemoveFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EditMenu em = new EditMenu();
		int foodId = Integer.parseInt(request.getParameter("id"));
		if(em.existFood(foodId)) {
			em.removeFromDbKerdzi(foodId);
		}
		RequestDispatcher dispatch = request.getRequestDispatcher("AdminMenuView.jsp");
		dispatch.forward(request, response);
	}

}
