package edu.uci.java2.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.uci.java2.dal.DALFactory;
import edu.uci.java2.dal.DalException;
import edu.uci.java2.domain.Bug;
import edu.uci.java2.domain.BugRepository;
import edu.uci.java2.domain.User;


public class ListOfBugController extends HttpServlet {

	private static final long serialVersionUID = -3923554021598480269L;


	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/ListOfBugs.jsp");
		
		if(user == null){//redirect to login page
			dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/login");
			dispatcher.forward(request, response);
			return;
		}
		
			request.setAttribute("username", user.getUsername());
			
			BugRepository bugRepository = DALFactory.getNewBugRepository();
			List<Bug> bugList = Collections.emptyList();
			try {
				bugList = bugRepository.getAllBugs();
			} catch (DalException e) {
				e.printStackTrace();
			}
			request.setAttribute("buglist", bugList);
			dispatcher.forward(request, response);
	}
	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}

}
