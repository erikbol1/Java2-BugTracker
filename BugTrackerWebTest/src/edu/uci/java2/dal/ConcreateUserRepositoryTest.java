package edu.uci.java2.dal;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.*;


import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

import edu.uci.java2.domain.User;
import edu.uci.java2.domain.UserRepository;
import static org.junit.Assert.*;

/**
 * The class <code>ConcreateUserRepositoryTest</code> contains tests for the class <code>{@link ConcreateUserRepository}</code>.
 *
 * @generatedBy CodePro at 01/09/13 11:19 AM
 * @author dom
 * @version $Revision: 1.0 $
 */
public class ConcreateUserRepositoryTest {
	/**
	 * Run the ConcreateUserRepository() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 01/09/13 11:19 AM
	 */
	@Test
	public void testUserRepository_1()
		throws Exception {

		UserRepository result = DALFactory.getNewUserRepository();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the void SaveUser(User) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 01/09/13 11:19 AM
	 */
	@Test
	public void testSaveUser_1()
		throws Exception {
		UserRepository fixture = DALFactory.getNewUserRepository();
		
		User user = new User();
		user.setEmail("TEST");
		user.setPasswordHash("TEST");
		user.setUsername("testSaveUser_1");

		fixture.SaveUser(user);

		// add additional test code here
	}

	/**
	 * Run the User getUSerByUserID(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 01/09/13 11:19 AM
	 */
	@Test
	public void testGetUSerByUserID_1()
		throws Exception {
		UserRepository fixture = DALFactory.getNewUserRepository();
		int ID = 1;

		User result = fixture.getUSerByUserID(ID);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the User getUserByUserName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 01/09/13 11:19 AM
	 */
	@Test
	public void testGetUserByUserName_1()
		throws Exception {
		UserRepository fixture = DALFactory.getNewUserRepository();

		String userName = "testGetUserByUserName_1";
		User user = new User();
		user.setEmail("TEST");
		user.setPasswordHash("TEST");
		user.setUsername(userName);

		fixture.SaveUser(user);

		
		
		

		User result = fixture.getUserByUserName(userName);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the User getUserByUserName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 01/09/13 11:19 AM
	 */
	@Test(expected = edu.uci.java2.dal.DalException.class)
	public void testGetUserByUserName_2()
		throws Exception {
		UserRepository fixture = DALFactory.getNewUserRepository();
		String userName = "";

		User result = fixture.getUserByUserName(userName);

		// add additional test code here
		assertNotNull(result);
	}
	
	/**
	 * TestCase set-up
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 01/09/13 11:19 AM
	 */
	@BeforeClass
	public static void setUpClass()
		throws Exception {
		// Code copied from https://blogs.oracle.com/randystuph/entry/injecting_jndi_datasources_for_junit
		// Code has been modified to fit environment
		// rcarver - setup the jndi context and the datasource
        try {
            // Create initial context
            System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
                "org.apache.naming.java.javaURLContextFactory");
            System.setProperty(Context.URL_PKG_PREFIXES, 
                "org.apache.naming");            
            InitialContext ic = new InitialContext();

            ic.createSubcontext("java:");
            ic.createSubcontext("java:comp");
            ic.createSubcontext("java:comp/env");
            ic.createSubcontext("java:comp/env/jdbc");
           
            // Construct DataSource
            MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();
            ds.setURL("jdbc:mysql://localhost:3306/bugtracker");
            ds.setPort(3306);
            ds.setServerName("localhost");
            ds.setDatabaseName("bugtracker");
            ds.setUser("bugtracker");
            ds.setPassword("bugtracker");
            
            ic.bind("java:comp/env/jdbc/bugtracker", ds);
        } catch (NamingException ex) {
            Logger.getLogger(ConcreateUserRepositoryTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        //END COPIED CODE
        
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 01/09/13 11:19 AM
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
	 * @generatedBy CodePro at 01/09/13 11:19 AM
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
	 * @generatedBy CodePro at 01/09/13 11:19 AM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ConcreateUserRepositoryTest.class);
	}
}