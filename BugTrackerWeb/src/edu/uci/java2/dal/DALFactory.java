package edu.uci.java2.dal;

import java.util.List;

import edu.uci.java2.domain.BugRepository;
import edu.uci.java2.domain.Priority;
import edu.uci.java2.domain.Status;
import edu.uci.java2.domain.UserRepository;

/**
 * @author dom
 * Public Factory that provides access to data providing interface
 */
public class DALFactory {
	
	/**
	 * @return UserRepository to access and save User
	 */
	public static UserRepository getNewUserRepository(){
		return new ConcreteUserRepository();
	}
	
	/**
	 * @return Return a BugRepository to access and save Bugs
	 */
	public static BugRepository getNewBugRepository(){
		return new ConcreteBugRepository();
	}
	
	/**
	 * @return The list of available Priority Value
	 * @throws DalException
	 */
	public static List<Priority> getPriorities() throws DalException{
		PriorityContainer container = new PriorityContainer();
		return container.getListOfPriority();
	}

	/**
	 * @return The List of available Status Value
	 * @throws DalException
	 */
	public static List<Status> getStatuses() throws DalException {
		StatusContainer container = new StatusContainer();
		return container.getListOfStatus();
	}

}
