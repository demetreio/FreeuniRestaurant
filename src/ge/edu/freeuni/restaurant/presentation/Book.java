package ge.edu.freeuni.restaurant.presentation;

import ge.edu.freeuni.restaurant.logic.DBConnector;
import ge.edu.freeuni.restaurant.logic.MailSender;
import ge.edu.freeuni.restaurant.logic.TableReserveManager;
import ge.edu.freeuni.restaurant.logic.UserManager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.RequestDispatcher;
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
		TableReserveManager trm = new TableReserveManager();
		String param = request.getParameter("fieldi");
		String[] res = param.split(",");
		String name = res[0];
		UserManager um = new UserManager();
		RequestDispatcher dispatch;
		if(um.userExists(name)){
			for (int i = 0; i <= res.length/2; i+=2) {
				int tableId = Integer.parseInt(res[i+1]);
				String resInfo = res[i+2];
				try {
					trm.reserveTable(tableId, resInfo);
					DBConnector db= DBConnector.getInstance();
					
					if(resInfo.contains("2")){
						trm.reserveForUser(name, tableId, resInfo);
						MailSender.sendTableReservationConfirmationrMail(name, db.getUser(name).getMail());
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (AddressException e) {
					e.printStackTrace();
				} catch (MessagingException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			dispatch = request.getRequestDispatcher("OrderingView.jsp");
		}else {
			dispatch = request.getRequestDispatcher("InvalidUsername.html");
		}
		dispatch.forward(request, response);
	}
}
