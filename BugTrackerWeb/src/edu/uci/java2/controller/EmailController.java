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
import edu.uci.java2.utils.EmailUtil;

public class EmailController extends HttpServlet {
	
	public static final String BUG_ID = "currentBugID";
	public static final String USERNAME = "username";
	public static final String SUBJECT_INTRO = "subjectIntro";
	public static final String SUBJECT = "subject";
	public static final String BODY = "body";
	
	private static final long serialVersionUID = -3286677822836120069L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private int bugID = -1;
	private String sendTo = "";
	private String emailBody = "";

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
		
		if(bugValidForInitialView()) {
			setupUI();
			return;
		} else if (validEmailRequest()){
			emailBugReport();
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
		
		Bug bug = new Bug();
		try {
			int bugID = Integer.parseInt(idString);
			bug = DALFactory.getNewBugRepository().getBugByID(bugID);
		} catch (NumberFormatException | DalException e) {
			//Bug does not exist
			request.setAttribute("errorMessage", "Invalid bug number.");
			return false;
		}
		bugID = bug.getID();
		
		return true;
	}
	
	private void setupUI() throws ServletException, IOException {

		request.setAttribute(DropDownUtil.USERNAME_LIST, DropDownUtil.getUsernameList());
		request.setAttribute(BUG_ID, bugID);
		request.setAttribute(SUBJECT_INTRO, getIntro());

		RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/Email.jsp");
		dispatcher.forward(request, response);
	}
	
	private String getIntro(){
		return "Bug #" + bugID + " - ";
	}
	
	private boolean validEmailRequest() {
		
		if(!bugFound(request.getParameter(BUG_ID)))			
			return false;
				
		if(!validEmailAddressAvailable())
			return false;
		
		String body = request.getParameter(BODY);
		if(body != null && !body.isEmpty())
			emailBody = body;
		else {
			request.setAttribute("errorMessage", "You must enter a message in the email body.");
			return false;
		}
		
		return true;
	}
	
	private boolean validEmailAddressAvailable() {
		User user = null;
		try {
			user = DALFactory.getNewUserRepository().getUserByUserName(request.getParameter(USERNAME));
		} catch (DalException e) {
			// ignore
		}
		if(user != null)
			sendTo = user.getEmail();
		else {
			request.setAttribute("errorMessage", "Invalid username");
			return false;
		}
		
		return true;
	}
	
	private void emailBugReport() {
		String subject = request.getParameter(SUBJECT);
		if (subject != null)
			subject = getIntro() + subject;
		else
			subject = getIntro();
		
		EmailUtil.sendEmail(sendTo, subject, emailBody);
		
		request.setAttribute("errorMessage", "Email sent successfully.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
