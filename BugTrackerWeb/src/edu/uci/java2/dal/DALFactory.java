package edu.uci.java2.dal;

import java.util.List;

import edu.uci.java2.domain.BugRepository;
import edu.uci.java2.domain.Priority;
import edu.uci.java2.domain.Status;
import edu.uci.java2.domain.UserRepository;

public class DALFactory {
	
	public static UserRepository getNewUserRepository(){
		return new ConcreateUserRepository();
	}
	
	public static BugRepository getNewBugRepository(){
		return new ConcreateBugRepository();
	}
	
	public static List<Priority> getPriorities() throws DalException{
		PriorityContainer container = new PriorityContainer();
		return container.getListOfPriority();
	}

	public static List<Status> getStatuses() throws DalException {
		StatusContainer container = new StatusContainer();
		return container.getListOfStatus();
	}

}
