package edu.uci.java2.domain;

import java.util.List;

import edu.uci.java2.dal.DalException;

public interface BugRepository {

	public Bug getBugByID(int ID) throws DalException;
	
	public List<Bug> getAllBugs() throws DalException;
	
	public Bug SaveBug(Bug bug) throws DalException;
}
