package edu.uci.java2.dal;

import java.util.List;
import edu.uci.java2.domain.Bug;
import edu.uci.java2.domain.BugRepository;
import edu.uci.java2.domain.BugService;
import edu.uci.java2.domain.BugTrackerException;
import edu.uci.java2.domain.Priority;
import edu.uci.java2.domain.Status;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>ConcreateBugRepositoryTest</code> contains tests for the class <code>{@link ConcreateBugRepository}</code>.
 *
 * @generatedBy CodePro at 9/2/13 10:49 AM
 * @author dom
 * @version $Revision: 1.0 $
 */
public class ConcreateBugRepositoryTest {
	/**
	 * Run the Bug SaveBug(Bug) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/2/13 10:49 AM
	 */
	@Test
	public void testSaveBug_1()
		throws Exception {
		BugRepository fixture = DALFactory.getNewBugRepository();
		Bug bug = getTestBug();
		
		Bug result = fixture.SaveBug(bug);

		
		assertNotNull(result);
	}
	
	/**
	 * Run the Bug SaveBug(Bug) method test for update.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/2/13 10:49 AM
	 */
	@Test
	public void testSaveBug_2()
		throws Exception {
		BugRepository fixture = DALFactory.getNewBugRepository();
		Bug bug = getTestBug();
		String newSummary = "BOUGABOUGA";
		Bug result = fixture.SaveBug(bug);
		int id1 = result.getID();
		result.setSummary(newSummary);
		Bug updatedResult = fixture.SaveBug(result);
		int id2 = updatedResult.getID();
		
		assertEquals(id1, id2);
	}


	/**
	 * Run the List<Bug> getAllBugs() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/2/13 10:49 AM
	 */
	@Test
	public void testGetAllBugs_1()
		throws Exception {
		BugRepository fixture = DALFactory.getNewBugRepository();
		Bug bug = getTestBug();
		
		Bug result = fixture.SaveBug(bug);


		List<Bug> resultList = fixture.getAllBugs();

		// add additional test code here
		assertNotNull(resultList.contains(result));
	}

	/**
	 * Run the Bug getBugByID(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/2/13 10:49 AM
	 */
	@Test
	public void testGetBugByID_1()
		throws Exception {
		
		BugRepository fixture = DALFactory.getNewBugRepository();
		Bug bug = getTestBug();
		
		Bug result = fixture.SaveBug(bug);
		Bug newResult = fixture.getBugByID(result.getID());

		
		assertEquals(result.getID(), newResult.getID());
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 9/2/13 10:49 AM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 9/2/13 10:49 AM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 9/2/13 10:49 AM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ConcreateBugRepositoryTest.class);
	}
	
	private static Bug getTestBug() throws BugTrackerException{
		Bug bug = new Bug();
		bug.setSummary("TOTOTOTO");
		bug.setDescription("jahdfjkahf;akdhf;ajf");
		List<Priority> priorities = BugService.getAllPriority();
		bug.setPriority(priorities.get(0));
		List<Status> statuses = BugService.getAllStatus();
		bug.setStatus(statuses.get(0));
		return bug;
	}
}