package ge.edu.freeuni.restaurant.presentation;

import ge.edu.freeuni.restaurant.logic.EditMenu;
import ge.edu.freeuni.restaurant.logic.Kerdzi;
import ge.edu.freeuni.restaurant.logic.Menu;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateMenuServlet
 */
@WebServlet("/UpdatePriceServlet")
public class UpdatePriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePriceServlet() {
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
		Menu menu = new Menu();
		ArrayList<Kerdzi> kerdzebe = null;
		try {
			kerdzebe = menu.getMenu();
		} catch (SQLException exception) {
			// TODO Auto-generated catch-block stub.
			exception.printStackTrace();
		}
		Kerdzi curKerdzi;
		for (int i = 0; i < kerdzebe.size(); i++) {
			curKerdzi = kerdzebe.get(i);
			String param = "price"+ curKerdzi.getId();
			em.changePrice(curKerdzi.getId(), Double.parseDouble(request.getParameter(param)));
			
		}
		RequestDispatcher dispatch = request.getRequestDispatcher("AdminMenuView.jsp");
		dispatch.forward(request, response);
	}

}
