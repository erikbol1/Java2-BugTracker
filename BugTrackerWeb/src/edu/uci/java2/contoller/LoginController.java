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
	
	
	
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		UserService service = new UserService();
		User user = null;
		if(username!=null){
			try {
				user = service.validateUser(username, password.toCharArray());
			} catch (WrongLoginException e) {
				String message = e.getMessage();
				session.setAttribute("LoginError", message);
			}
			session.setAttribute("user", user);
		}
		
		User sessionUser = (User)session.getAttribute("user");
		if(sessionUser==null){
			dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/Login.jsp");
		}else{
			dispatcher = getServletConfig().getServletContext().getRequestDispatcher("main");
		}
		
		
		dispatcher.forward(request, response);
	}
	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	
	
	

}
