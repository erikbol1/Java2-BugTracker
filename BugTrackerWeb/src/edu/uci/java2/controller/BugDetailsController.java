package edu.uci.java2.controller;

import java.io.IOException;
import java.util.Date;

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
import edu.uci.java2.utils.WebDateUtil;

/**
 * Servlet implementation class BugDetailsController
 */
public class BugDetailsController extends HttpServlet {
	
	private static final long serialVersionUID = 3389767218329590376L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Bug bug;
	
	public static final String HIDDEN_BUG_ID = "hiddenBugID";
	public static final String SUMMARY = "summary";
	public static final String CREATED_DATE = "created";
	public static final String UPDATED_DATE = "updated";
	public static final String PRIORITY = "priority";
	public static final String STATUS = "status";
	public static final String ASSIGNED_USER = "assigned";
	public static final String DESCRIPTION = "description";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.request = request;
		this.response = response;
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		if(user == null){//redirect to login page
			RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/login");
			dispatcher.forward(request, response);
			return;
		}
		
		if(bugValidForInitialView()){
			setupDetailsUI();
			return;
		} else if (bugValidForUpdate()){
			updateBug();
		}

		RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/listofbugs");
		dispatcher.forward(this.request, this.response);
	}
	
	private boolean bugValidForInitialView() {
		
		return bugFound(request.getParameter("bugID"));
	}
	
	private boolean bugFound(String idString){
		
		if(idString == null)
			return false;
		
		try {
			int bugID = Integer.parseInt(idString);
			bug = DALFactory.getNewBugRepository().getBugByID(bugID);
		} catch (NumberFormatException | DalException e) {
			//Bug does not exist
			request.setAttribute("errorMessage", "Invalid bug number.");
			return false;
		}
		
		return true;
	}
	
	private void setupDetailsUI() throws ServletException, IOException{
		
		request.setAttribute(DropDownUtil.USERNAME_LIST, DropDownUtil.getUsernameList());
		request.setAttribute(DropDownUtil.PRIORITY_LIST, DropDownUtil.getPriorityList());
		request.setAttribute(DropDownUtil.STATUS_LIST, DropDownUtil.getStatusList());
		request.setAttribute("bug", bug);

		RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/details.jsp");
		dispatcher.forward(request, response);
	}
	
	private boolean bugValidForUpdate(){

		if(!bugFound(request.getParameter(HIDDEN_BUG_ID)))
			return false;
		
		Date createdDate = WebDateUtil.dateFromWebpage(request.getParameter(CREATED_DATE));
		if(!createdDate.equals(bug.getCreatedDate())){
			request.setAttribute("errorMessage", "Creation date does not match. " + createdDate.toString());
			return false;
		}
		
		Date updatedDate = WebDateUtil.dateFromWebpage(request.getParameter(UPDATED_DATE));
		if(!updatedDate.equals(bug.getLastUpdateDate())){
			request.setAttribute("errorMessage", "Update date does not match.");
			return false;
		}
		
		
		return true;
	}
	
	private void updateBug(){
		
		final String intro = "Bug #" + bug.getID();
		final String fail = intro + " did not update properly.  No changes have been saved.";
		
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
		bug.setAssignee(DropDownUtil.validateSelectedUser(request.getParameter(ASSIGNED_USER)));
		
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
		
		request.setAttribute("errorMessage", intro + " updated successfully.");
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
