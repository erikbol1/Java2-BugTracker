package edu.uci.java2.domain;

import edu.uci.java2.dal.DalException;

public interface UserRepository {
	
	public User getUserByUserName(String userName) throws DalException;
	
	public User getUSerByUserID(int ID) throws DalException;
	
	public User SaveUser(User user) throws DalException;
	
	

}
