package ge.edu.freeuni.restaurant.logic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Book
 */
@WebServlet("/Book")
public class Book extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Book() {
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
		DBConnector dbc = DBConnector.getInstance();
		String param = request.getParameter("fieldi");
		String[] res = param.split(",");
		String name = res[0];
		for (int i = 0; i <= res.length/2; i+=2) {
			int tableId = Integer.parseInt(res[i+1]);
			String resInfo = res[i+2];
			try {
				dbc.reserveTable(tableId, resInfo);
				if(resInfo.contains("2"))dbc.reserveForUser(name, tableId, resInfo);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
