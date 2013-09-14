package edu.uci.java2.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.uci.java2.domain.User;
import edu.uci.java2.utils.DropDownUtil;

/**
 * Servlet implementation class NewBugController
 */
public class NewBugController extends HttpServlet {
	
	private static final long serialVersionUID = 6281538972733116399L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("user");
		RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/NewBug.jsp");

		if(currentUser == null){//redirect to login page
			dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/login");
			dispatcher.forward(request, response);
			return;
		}

		request.setAttribute(DropDownUtil.USERNAME_LIST, DropDownUtil.getUsernameList());
		request.setAttribute(DropDownUtil.PRIORITY_LIST, DropDownUtil.getPriorityList());
		request.setAttribute(DropDownUtil.STATUS_LIST, DropDownUtil.getStatusList());

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}