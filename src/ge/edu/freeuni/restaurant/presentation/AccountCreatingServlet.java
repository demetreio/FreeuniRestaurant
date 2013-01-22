package ge.edu.freeuni.restaurant.presentation;

import ge.edu.freeuni.restaurant.logic.DBConnector;
import ge.edu.freeuni.restaurant.logic.MailSender;
import ge.edu.freeuni.restaurant.logic.User;
import ge.edu.freeuni.restaurant.logic.UserManager;
import java.io.IOException;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AccountCreatingServlet
 */
@WebServlet("/AccountCreatingServlet")
public class AccountCreatingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountCreatingServlet() {
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
		String	username = request.getParameter("username");
		String	pass = request.getParameter("myPass");
		String mail = request.getParameter("mail");
		String	info = request.getParameter("info");
		String 	name = request.getParameter("name");
		String	surname =request.getParameter("surname");
		
		
		if(username.equals("") || pass.equals("") || info.equals("") || name.equals("") || surname.equals("") ){
			RequestDispatcher dispatch = request.getRequestDispatcher("FillFields.html");
			dispatch.forward(request, response);
		} else {
			User user = new User(username, pass, mail, name, surname, info, false);
			UserManager um = new UserManager();
			boolean reg = um.registerNewUser(user);
			if(reg){
				try {
					MailSender.sendConfirmationrMail(user.getName(),user.getMail());
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				RequestDispatcher dispatch = request.getRequestDispatcher("AccountCreated.jsp");
				dispatch.forward(request, response);
			} else {
				RequestDispatcher dispatch = request.getRequestDispatcher("username-in-use.jsp");
				dispatch.forward(request, response);
			}
			
		}
		
	}

}
