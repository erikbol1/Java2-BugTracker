package edu.uci.java2.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import edu.uci.java2.domain.User;

class UserDataMapper implements Mapper {
	
	private User user;
	
	UserDataMapper(User user){
		this.user = user;
	}
	public UserDataMapper() {
	}
	
	/* (non-Javadoc)
	 * @see edu.uci.java2.dal.Mapper#setResult(java.sql.ResultSet)
	 */
	@Override
	public void setResult(ResultSet resultSet) throws SQLException{
		this.user = new User();
		resultSet.next();
		user.setEmail(resultSet.getString(UserMapEnum.EMAIL.toString()));
		user.setID(resultSet.getInt("ID"));
		user.setPasswordHash(resultSet.getString(UserMapEnum.PASSWORDHASH.toString()));
		user.setUsername(resultSet.getString(UserMapEnum.USERNAME.toString()));
	}
	
	public Map<String, String> getUserMap(){
		Map<String, String> userMap = new HashMap<String, String>();
		userMap.put(UserMapEnum.EMAIL.toString(), user.getEmail());
		userMap.put(UserMapEnum.PASSWORDHASH.toString(), user.getPasswordHash());
		userMap.put(UserMapEnum.USERNAME.toString(), user.getUsername());
		return userMap;
	}
	
	public User getUser(){
		return user;
	}

}
