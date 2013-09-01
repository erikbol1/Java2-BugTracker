package edu.uci.java2.dal;

import edu.uci.java2.domain.UserRepository;

public class DALFactory {
	
	public static UserRepository getNewUserRepository(){
		return new ConcreateUserRepository();
	}

}
