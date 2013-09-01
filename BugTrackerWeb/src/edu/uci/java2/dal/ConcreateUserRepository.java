package edu.uci.java2.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.naming.NamingException;

import edu.uci.java2.domain.User;
import edu.uci.java2.domain.UserRepository;

class ConcreateUserRepository implements UserRepository {

	private static final String SELECTUSERBYUSERNAME = "SELECT * FROM users WHERE username = ";
	private static final String SELECTUSER = "SELECT * FROM users ";
	private static final String CREATEUSER = "INSERT INTO users (";
	private static final String VALUES = ") VALUES (";
	private static final String UPDATEUSER = "UPDATE users SET ";
	private static final String WHEREID = " WHERE ID = ";
	
	private DataProvider dataProvider;
	
	ConcreateUserRepository(){
		dataProvider =  new DataProvider();
	}
	
	@Override
	public User getUserByUserName(String userName) throws DalException {
		String sqlString = SELECTUSERBYUSERNAME + "'" + userName + "'";
		return getUser(sqlString);
	}

	@Override
	public User getUSerByUserID(int ID) throws DalException {
		String sqlString = SELECTUSER + WHEREID + ID;
		return getUser(sqlString);
	}
	
	private User getUser(String sqlString) throws DalException{
		UserDataMapper dataMapper = new UserDataMapper();
		try {
			dataMapper = (UserDataMapper) dataProvider.runSQL(sqlString, dataMapper);
		} catch (NamingException e) {
			throw new DalException(e);
		} catch (SQLException e) {
			throw new DalException(e);
		}
		return dataMapper.getUser();
	}

	@Override
	public void SaveUser(User user) throws DalException {
		UserDataMapper dataMapper = new UserDataMapper(user);
		Map<String, String> userMap = dataMapper.getUserMap();
		StringBuilder sqlQuerry = new StringBuilder();
		if(user.getID()==-1){
			StringBuilder collumnName = new StringBuilder();
			StringBuilder collumnValue = new StringBuilder();
			for(String collumn : userMap.keySet()){
				collumnName.append(collumn);
				collumnName.append(",");
				collumnValue.append("'");
				collumnValue.append(userMap.get(collumn));
				collumnValue.append("',");
			}
			collumnName.deleteCharAt(collumnName.length()-1);
			collumnValue.deleteCharAt(collumnValue.length()-1);
			sqlQuerry.append(CREATEUSER);
			sqlQuerry.append(collumnName.toString());
			sqlQuerry.append(VALUES);
			sqlQuerry.append(collumnValue.toString());
			sqlQuerry.append(")");
		}else{
			sqlQuerry.append(UPDATEUSER);
			for(String collumn : userMap.keySet()){
				sqlQuerry.append(collumn);
				sqlQuerry.append("=");
				sqlQuerry.append(userMap.get(collumn));
				sqlQuerry.append(",");
			}
			sqlQuerry.deleteCharAt(sqlQuerry.length()-1);
			sqlQuerry.append(WHEREID);
			sqlQuerry.append(user.getID());
		}
		try {
			dataProvider.runSQL(sqlQuerry.toString(),null);
		} catch (NamingException e) {
			throw new DalException(e);
		} catch (SQLException e) {
			throw new DalException(e);
		}
	}

}
