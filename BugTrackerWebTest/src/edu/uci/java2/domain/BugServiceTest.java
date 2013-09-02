package edu.uci.java2.domain;

import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>BugServiceTest</code> contains tests for the class <code>{@link BugService}</code>.
 *
 * @generatedBy CodePro at 9/2/13 12:35 PM
 * @author dom
 * @version $Revision: 1.0 $
 */
public class BugServiceTest {
	/**
	 * Run the List<Priority> getAllPriority() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/2/13 12:35 PM
	 */
	@Test
	public void testGetAllPriority_1()
		throws Exception {

		List<Priority> result = BugService.getAllPriority();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<Priority> getAllPriority() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/2/13 12:35 PM
	 */
	@Test
	public void testGetAllPriority_2()
		throws Exception {

		List<Priority> result = BugService.getAllPriority();

		// add additional test code here
		assertTrue(result.size()>1);
	}

	/**
	 * Run the List<Status> getAllStatus() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/2/13 12:35 PM
	 */
	@Test
	public void testGetAllStatus_1()
		throws Exception {

		List<Status> result = BugService.getAllStatus();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<Status> getAllStatus() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/2/13 12:35 PM
	 */
	@Test
	public void testGetAllStatus_2()
		throws Exception {

		List<Status> result = BugService.getAllStatus();

		// add additional test code here
		assertTrue(result.size()>1);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 9/2/13 12:35 PM
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
	 * @generatedBy CodePro at 9/2/13 12:35 PM
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
	 * @generatedBy CodePro at 9/2/13 12:35 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(BugServiceTest.class);
	}
}