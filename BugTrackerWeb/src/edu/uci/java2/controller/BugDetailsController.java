package edu.uci.java2.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.uci.java2.dal.DALFactory;
import edu.uci.java2.dal.DalException;
import edu.uci.java2.domain.Bug;
import edu.uci.java2.domain.User;
import edu.uci.java2.utils.DropDownUtil;

/**
 * Servlet implementation class BugDetailsController
 */
public class BugDetailsController extends HttpServlet {
	
	private static final long serialVersionUID = 3389767218329590376L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/details.jsp");
		
		if(user == null){//redirect to login page
			dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/login");
			dispatcher.forward(request, response);
			return;
		}

		request.setAttribute(DropDownUtil.USERNAME_LIST, DropDownUtil.getUsernameList());
		request.setAttribute(DropDownUtil.PRIORITY_LIST, DropDownUtil.getPriorityList());
		request.setAttribute(DropDownUtil.STATUS_LIST, DropDownUtil.getStatusList());

		Bug bug = null;
		try {
			int bugID = Integer.parseInt(request.getParameter("bugID"));
			bug = DALFactory.getNewBugRepository().getBugByID(bugID);
		} catch (NumberFormatException | DalException e) {
			request.setAttribute("errorMessage", e.getMessage());
		}
		
		request.setAttribute("bug", bug);

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
