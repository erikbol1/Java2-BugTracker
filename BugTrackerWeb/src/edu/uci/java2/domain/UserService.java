package edu.uci.java2.domain;

import edu.uci.java2.dal.DALFactory;
import edu.uci.java2.dal.DalException;
import edu.uci.java2.domain.exception.BugTrackerException;
import edu.uci.java2.domain.exception.WrongLoginException;
import edu.uci.java2.utils.PasswordUtil;

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
	
	public User validateUser(String userName, char[] password) throws WrongLoginException{
		User user = null;
		try {
			user = userRepository.getUserByUserName(userName);
		} catch (DalException e) {
			throw new WrongLoginException("Invalid username");
		}
		String passwordHash = PasswordUtil.getHash(password);
		if(!user.getPasswordHash().equalsIgnoreCase(passwordHash)){
			throw new WrongLoginException("Wrong Password");
		}
		return user;
	}
	
	public User getUserByUserName(String userName) throws BugTrackerException{
		User user = null;
		try{
			user = userRepository.getUserByUserName(userName);
		}catch(DalException e){
			throw new BugTrackerException("User: " + userName + " cannot be retrieved");
		}
		return user;
	}

	public User createNewUser(String username, char[] password, String email) throws BugTrackerException {
		String passwordhash = PasswordUtil.getHash(password);
		User user = new User();
		user.setEmail(email);
		user.setPasswordHash(passwordhash);
		user.setUsername(username);
		try {
			user = userRepository.SaveUser(user);
		} catch (DalException e) {
			throw new BugTrackerException(e);
		}
		return user;
	}

}
