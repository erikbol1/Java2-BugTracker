package edu.uci.java2.contoller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.uci.java2.domain.User;
import edu.uci.java2.domain.UserService;
import edu.uci.java2.domain.exception.WrongLoginException;



public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1222373041963288377L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Default case
		RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/Login.jsp");
		User user = null;
		
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		
		if(username != null){
			
			String password = request.getParameter("password");
			UserService userService = new UserService();
			
			try {
				user = userService.validateUser(username, password.toCharArray());
				dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/listofbugs");
			} catch (WrongLoginException e) {
				request.setAttribute("errorMessage", e.getMessage());
			}
		}

		session.setAttribute("user", user);		
		dispatcher.forward(request, response);
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
