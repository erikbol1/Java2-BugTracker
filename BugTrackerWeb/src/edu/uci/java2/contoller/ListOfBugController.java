package edu.uci.java2.contoller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.uci.java2.domain.User;


public class ListOfBugController extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user==null){
			dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/login");
		}else{
			dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/ListOfBugs.jsp");
		}
		dispatcher.forward(request, response);
	}
	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}

}
