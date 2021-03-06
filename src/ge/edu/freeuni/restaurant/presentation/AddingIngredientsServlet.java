package ge.edu.freeuni.restaurant.presentation;

import ge.edu.freeuni.restaurant.logic.EditIngredients;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddingIngredientsServlet
 */
@WebServlet("/AddingIngredientsServlet")
public class AddingIngredientsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddingIngredientsServlet() {
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
		RequestDispatcher dispatch;
		String butt = request.getParameter("butt");
		int prod_id;
		if(butt.equals("Delete")){
			String name = request.getParameter("hiddel");
			prod_id = Integer.parseInt(request.getParameter("hidid"));
			EditIngredients ingr = new EditIngredients();
			ingr.deleteEngredient(prod_id, name);
		}
		else{
			double quant = Double.parseDouble(request.getParameter("quantity"));
			String unit = request.getParameter("unit");
			String name = request.getParameter("ingredient_name");
			prod_id = Integer.parseInt(request.getParameter("hidden"));
			EditIngredients ingr = new EditIngredients();
			ingr.addIngredient(prod_id, name, quant, unit);
		}
		HttpSession session = request.getSession();
		session.setAttribute("id",prod_id);
		dispatch = request.getRequestDispatcher("viewIngrendients.jsp");
		dispatch.forward(request,response);
	}

}


