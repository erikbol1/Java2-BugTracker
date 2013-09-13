package edu.uci.java2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.uci.java2.domain.User;
import edu.uci.java2.domain.UserService;
import edu.uci.java2.domain.exception.BugTrackerException;
import edu.uci.java2.utils.PasswordUtil;

public class RegisterController extends HttpServlet {
	
	private static final long serialVersionUID = 8441533788559152354L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();
		
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		String email = (String) request.getParameter("email");
		//If the field are null forward to Register View
		if(username==null){
			dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/Register.jsp");
		}else{//Proceed with registration process
			UserService service = new UserService();
			User user=null;
			boolean hasPassedValidation = true;
			try{
				user = service.getUserByUserName(username);
			}catch(BugTrackerException e){
				//Do nothing, this is the proper state for user registration
			}
			if(user!=null){
				request.setAttribute("UserNameError", "This username is invalid or already in use");
				hasPassedValidation = false;
			}
			if(!PasswordUtil.passWordValidation(password.toCharArray())){
				request.setAttribute("PassWordError", "The Password is invalid");
				hasPassedValidation = false;
			}
			if(hasPassedValidation){
				try {
					User newuser = service.createNewUser(username, password.toCharArray(), email);
					session.setAttribute("user", newuser);
				} catch (BugTrackerException e) {
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
					out.print(MessageUtil.getAlertMessate("Error creating user"));
				}
			}
		}
		
		
		User sessionUser = (User)session.getAttribute("user");
		if(sessionUser==null){
			dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/RegisterUser.jsp");
		}else{
			dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/listofbugs");
		}
		
		
		dispatcher.forward(request, response);
	}
	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	
	


}
