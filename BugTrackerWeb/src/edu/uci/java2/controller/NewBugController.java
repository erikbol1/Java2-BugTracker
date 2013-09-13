package edu.uci.java2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.uci.java2.dal.DALFactory;
import edu.uci.java2.dal.DalException;
import edu.uci.java2.domain.Priority;
import edu.uci.java2.domain.Status;
import edu.uci.java2.domain.User;

/**
 * Servlet implementation class NewBugController
 */
public class NewBugController extends HttpServlet {
	
	private static final long serialVersionUID = 6281538972733116399L;
	public static final String USERNAME_LIST = "usernameList";
	public static final String PRIORITY_LIST = "priorityList";
	public static final String STATUS_LIST = "statusList";

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

		request.setAttribute(USERNAME_LIST, getUsernameList());
		request.setAttribute(PRIORITY_LIST, getPriorityList());
		request.setAttribute(STATUS_LIST, getStatusList());

		dispatcher.forward(request, response);
	}

	private List<String> getUsernameList() {
		List<User> users = new ArrayList<User>();

		try {
			users = DALFactory.getNewUserRepository().getAllUsers();
		} catch (DalException e) {
			e.printStackTrace();
		}

		List<String> usernameList = new ArrayList<String>();
		usernameList.add("None");

		for (User user : users)
			usernameList.add(user.getUsername());

		return usernameList;
	}
	
	private List<String> getPriorityList() {
		List<Priority> priorities = new ArrayList<Priority>();
		
		try {
			priorities = DALFactory.getPriorities();
		} catch (DalException e) {
			e.printStackTrace();
		}
		
		List<String> priorityList = new ArrayList<String>();
		
		for(Priority priority: priorities)
			priorityList.add(priority.getPriority());
		
		return priorityList;
	}
	
	private List<String> getStatusList(){
		List<Status> statuses = new ArrayList<Status>();
		
		try {
			statuses = DALFactory.getStatuses();
		} catch (DalException e) {
			e.printStackTrace();
		}
		
		List<String> statusList = new ArrayList<String>();
		
		for(Status status: statuses)
			statusList.add(status.getStatus());
		
		return statusList;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
