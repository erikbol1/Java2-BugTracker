package edu.uci.java2.dal;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import edu.uci.java2.domain.Bug;
import edu.uci.java2.domain.BugRepository;

class ConcreteBugRepository implements BugRepository {

	private DataProvider<Bug> dataProvider;
	
	ConcreteBugRepository(){
		this.dataProvider = new DataProvider<Bug>(Bug.class);
	}
	
	@Override
	public Bug getBugByID(int ID) throws DalException {
		try {
			return dataProvider.get(ID);
		} catch (ClassNotFoundException | NamingException e) {
			throw new DalException(e);
		}
	}

	@Override
	public List<Bug> getAllBugs() throws DalException {
		try {
			return dataProvider.getAll();
		} catch (ClassNotFoundException e) {
			throw new DalException(e);
		}
	}

	@Override
	public Bug SaveBug(Bug bug) throws DalException {
		try {
			return dataProvider.save(bug);
		} catch (ClassNotFoundException | NamingException | SQLException e) {
			throw new DalException(e);
		}
	}

}
