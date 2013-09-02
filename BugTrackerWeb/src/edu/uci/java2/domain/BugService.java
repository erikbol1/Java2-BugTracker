package edu.uci.java2.domain;


import java.util.List;


import edu.uci.java2.dal.DALFactory;
import edu.uci.java2.dal.DalException;

public class BugService {
	
	
	
	public static List<Priority> getAllPriority() throws BugTrackerException{
		try {
			return DALFactory.getPriorities();
		} catch (DalException e) {
			throw new BugTrackerException();
		}
	}
	
	public static List<Status> getAllStatus() throws BugTrackerException{
		try {
			return DALFactory.getStatuses();
		} catch (DalException e) {
			throw new BugTrackerException();
		}
	}
	
	

}
