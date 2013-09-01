package edu.uci.java2.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataProvider {
	
	
	//caching instances for performance
	private static InitialContext context;
	private static DataSource datasource;
	
	
	Mapper runSQL(String sqlStatement, Mapper mapper) throws NamingException, SQLException{
		ResultSet result = null;
		
		
		if(context ==null){
			initInitialContext();
		}
		if(datasource==null){
			initDataSource();
		}
		
		Connection connection = null;
		Statement statement = null;
		try {
			connection = datasource.getConnection();
			statement = connection.createStatement();
			statement.execute(sqlStatement);
			result = statement.getResultSet();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(mapper!=null){
			mapper.setResult(result);
		}
		try{
			result.close();
			statement.close();
			connection.close();
		}catch(Exception e){
			//Nothing can be done
		}finally{
			result = null;
			statement = null;
			connection = null;
		}
		return mapper;
	}
	
	private synchronized static void initInitialContext() throws NamingException{
		context = new InitialContext();
	}
	private synchronized static void initDataSource() throws NamingException{
		datasource = (DataSource)context.lookup("java:comp/env/jdbc/bugtracker");
	}

}
