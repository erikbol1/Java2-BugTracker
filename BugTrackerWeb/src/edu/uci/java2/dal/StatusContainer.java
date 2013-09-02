package edu.uci.java2.dal;

import java.util.List;

import edu.uci.java2.domain.Status;

class StatusContainer {
	
	private DataProvider<Status> dataProvider;
	StatusContainer(){
		this.dataProvider = new DataProvider<>(Status.class);
	}
	
	List<Status> getListOfStatus() throws DalException{
		try {
			return this.dataProvider.getAll();
		} catch (ClassNotFoundException e) {
			throw new DalException(e);
		}
	}

}
