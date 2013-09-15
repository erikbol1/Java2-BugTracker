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
import edu.uci.java2.domain.Priority;
import edu.uci.java2.domain.Status;
import edu.uci.java2.domain.User;
import edu.uci.java2.utils.DropDownUtil;

/**
 * Servlet implementation class NewBugController
 */
public class NewBugController extends HttpServlet {
	
	private static final long serialVersionUID = 6281538972733116399L;
	public static final String SUMMARY = "summary";
	public static final String PRIORITY = "priority";
	public static final String STATUS = "status";
	public static final String ASSIGNED = "assigned";
	public static final String DESCRIPTION = "description";
	
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.request = request;
		this.response = response;
		
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("user");
		if(currentUser == null){//redirect to login page
			RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/login");
			dispatcher.forward(request, response);
			return;
		}
		
		if(request.getParameterMap().isEmpty()){
			setupNewBugUI();
			return;
		}
		else
			processNewBug();

		RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/listofbugs");
		dispatcher.forward(this.request, this.response);
	}
	
	private void setupNewBugUI() throws ServletException, IOException {

		request.setAttribute(DropDownUtil.USERNAME_LIST, DropDownUtil.getUsernameList());
		request.setAttribute(DropDownUtil.PRIORITY_LIST, DropDownUtil.getPriorityList());
		request.setAttribute(DropDownUtil.STATUS_LIST, DropDownUtil.getStatusList());
		
		RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/NewBug.jsp");
		dispatcher.forward(request, response);
	}
	
	private void processNewBug(){

		final String fail = "Server error.  No changes have been saved.";		
		Bug bug = new Bug();
		
		String summary = request.getParameter(SUMMARY);
		if(summary != null)
			bug.setSummary(summary);
		else {
			request.setAttribute("errorMessage", fail);
			return;
		}
		

		Priority updatedPriority = DropDownUtil.validatePriority(request.getParameter(PRIORITY));
		if (updatedPriority != null)
			bug.setPriority(updatedPriority);
		else {
			request.setAttribute("errorMessage", fail);
			return;
		}
			
		Status updatedStatus = DropDownUtil.validateStatus(request.getParameter(STATUS));
		if(updatedStatus != null)
			bug.setStatus(updatedStatus);
		else {
			request.setAttribute("errorMessage", fail);
			return;
		}

		//User can be null if no user is assigned
		bug.setAssignee(DropDownUtil.validateSelectedUser(request.getParameter(ASSIGNED)));
		
		String description = request.getParameter(DESCRIPTION);
		if(description != null)
			bug.setDescription(description);
		else {
			request.setAttribute("errorMessage", fail);
			return;
		}

		try {
			DALFactory.getNewBugRepository().SaveBug(bug);
		} catch (DalException e) {
			request.setAttribute("errorMessage", fail);
			return;
		}
		
		request.setAttribute("errorMessage", "Bug saved successfully.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
