package edu.uci.java2.dal;

import java.util.List;

import edu.uci.java2.domain.Priority;

class PriorityContainer {
	
	private DataProvider<Priority> dataProvider;
	
	PriorityContainer(){
		dataProvider = new DataProvider<Priority>(Priority.class);
	}
	
	List<Priority> getListOfPriority() throws DalException{
		try {
			return dataProvider.getAll();
		} catch (ClassNotFoundException e) {
			throw new DalException(e);
		}
	}

}
