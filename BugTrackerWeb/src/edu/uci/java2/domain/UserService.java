package edu.uci.java2.domain;

import edu.uci.java2.dal.DALFactory;
import edu.uci.java2.dal.DalException;

public class UserService {
	
	private UserRepository userRepository;
	
	public UserService(){
		this.userRepository = DALFactory.getNewUserRepository();
	}
	
	public User getUserByID(int ID) throws BugTrackerException{
		try {
			return userRepository.getUSerByUserID(ID);
		} catch (DalException e) {
			throw new BugTrackerException("Unable to get User by ID", e);
		}
	}

}
