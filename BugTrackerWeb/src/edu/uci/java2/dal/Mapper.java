package edu.uci.java2.dal;

import java.sql.ResultSet;
import java.sql.SQLException;

interface Mapper {

	public abstract void setResult(ResultSet resultSet) throws SQLException;

}