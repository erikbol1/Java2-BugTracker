package edu.uci.java2.domain;


import java.util.List;


import edu.uci.java2.dal.DALFactory;
import edu.uci.java2.dal.DalException;
import edu.uci.java2.domain.exception.BugTrackerException;

public class BugService {
	
	
	
	/**
	 * @return The list of available priorities
	 * @throws BugTrackerException
	 */
	public static List<Priority> getAllPriority() throws BugTrackerException{
		try {
			return DALFactory.getPriorities();
		} catch (DalException e) {
			throw new BugTrackerException();
		}
	}
	
	/**
	 * @return The list of available Status
	 * @throws BugTrackerException
	 */
	public static List<Status> getAllStatus() throws BugTrackerException{
		try {
			return DALFactory.getStatuses();
		} catch (DalException e) {
			throw new BugTrackerException();
		}
	}
	
	

}
