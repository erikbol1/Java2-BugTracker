package edu.uci.java2.domain;

import java.util.List;

import edu.uci.java2.dal.DalException;

/**
 * @author dom
 * BugRepository Interface that allows to access Bug data
 * @link{DALFactory.class} 
 */
public interface BugRepository {

	/**
	 * @param ID
	 * @return The bug corresponding to the ID
	 * @throws DalException
	 */
	public Bug getBugByID(int ID) throws DalException;
	
	/**
	 * @return The list of all Bugs
	 * @throws DalException
	 */
	public List<Bug> getAllBugs() throws DalException;
	
	/**
	 * @param bug the bug to Save
	 * @return the new Bug saved
	 * @throws DalException
	 */
	public Bug SaveBug(Bug bug) throws DalException;
}
