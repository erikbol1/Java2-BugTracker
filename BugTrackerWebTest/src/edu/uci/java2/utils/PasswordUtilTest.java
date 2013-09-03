package edu.uci.java2.utils;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>PasswordUtilTest</code> contains tests for the class <code>{@link PasswordUtil}</code>.
 *
 * @generatedBy CodePro at 9/2/13 8:24 PM
 * @author dom
 * @version $Revision: 1.0 $
 */
public class PasswordUtilTest {
	/**
	 * Run the String getHash(char[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 9/2/13 8:24 PM
	 */
	@Test
	public void testGetHash_1()
		throws Exception {
		char[] password = "TEST".toCharArray();

		String result = PasswordUtil.getHash(password);

		// add additional test code here
		assertNotNull(result);
	}

	
	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 9/2/13 8:24 PM
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
	 * @generatedBy CodePro at 9/2/13 8:24 PM
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
	 * @generatedBy CodePro at 9/2/13 8:24 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(PasswordUtilTest.class);
	}
}