package edu.uci.java2.domain;

import edu.uci.java2.dal.DalException;

/**
 * @author dom
 * UserRepository interface that allows to retrieve and save Users
 * @link{DALFactory.class}
 */
public interface UserRepository {
	
	/**
	 * @param userName
	 * @return The user corresponding to the username
	 * @throws DalException
	 */
	public User getUserByUserName(String userName) throws DalException;
	
	/**
	 * @param ID
	 * @return The user corresponding to the ID
	 * @throws DalException
	 */
	public User getUSerByUserID(int ID) throws DalException;
	
	/**
	 * @param user
	 * @return Returns the saved User
	 * @throws DalException
	 */
	public User SaveUser(User user) throws DalException;

}
