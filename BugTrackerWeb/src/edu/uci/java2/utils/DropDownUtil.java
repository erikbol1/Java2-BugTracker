package edu.uci.java2.utils;

import java.util.ArrayList;
import java.util.List;

import edu.uci.java2.dal.DALFactory;
import edu.uci.java2.dal.DalException;
import edu.uci.java2.domain.Priority;
import edu.uci.java2.domain.Status;
import edu.uci.java2.domain.User;

public class DropDownUtil {
	
	private DropDownUtil() {} //Prevent instantiation
	
	public static final String USERNAME_LIST = "usernameList";
	public static final String PRIORITY_LIST = "priorityList";
	public static final String STATUS_LIST = "statusList";

	public static List<String> getUsernameList() {
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
	
	public static User validateSelectedUser(String username){
		
		List<User> userList = new ArrayList<User>();
		try {
			userList = DALFactory.getNewUserRepository().getAllUsers();
		} catch (DalException e) {
			//Ignore
		}
		
		User updatedUser = null;
		
		for(User user : userList)
			if(username.equals(user.getUsername())) {
				updatedUser = user;
				break;
			}
		
		return updatedUser;
	}

	public static List<String> getPriorityList() {
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
	
	public static Priority validatePriority(String priorityName) {

		List<Priority> priorityList = new ArrayList<Priority>();
		try {
			 priorityList = DALFactory.getPriorities();
		} catch (DalException e) {
			//Ignore
		}
		
		Priority updatedPriority = null;
		
		for(Priority priority : priorityList)
			if(priorityName.equals(priority.getPriority())) {
				updatedPriority = priority;
				break;
			}
		
		return updatedPriority;
	}
	
	public static List<String> getStatusList(){
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

	public static Status validateStatus(String statusName) {

		List<Status> statusList = new ArrayList<Status>();
		try {
			statusList = DALFactory.getStatuses();
		} catch (DalException e){
			//Ignore
		}
		
		Status updatedStatus = null;
		
		for(Status status : statusList)
			if(statusName.equals(status.getStatus())){
				updatedStatus = status;
				break;
			}
		
		return updatedStatus;
	}
}
