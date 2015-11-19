/**
 * 
 */
package buddyinfo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author MVezina
 *
 */
public class BuddyInfoTest
{
	private String		testName;
	private String		testAddress;
	private String		testPhone;
	private String 		testGreeting;
	private int		testAge;

	private BuddyInfo	buddyInfo;

	/**
	 * @throws java.lang.Exception
	 * @author MVezina
	 */
	@Before
	public void setUp() throws Exception
	{
		testName = "TestName";
		testAddress = "TestAddress";
		testPhone = "555-5555";
		testGreeting = "Hello.";
		testAge = 59;
		buddyInfo = new BuddyInfo(testName, testAddress, testPhone, testGreeting, testAge);

	}

	/**
	 * @throws java.lang.Exception
	 * @author MVezina
	 */
	@After
	public void tearDown() throws Exception
	{
	}

	/**
	 * Test method for
	 * {@link buddyinfo.BuddyInfo#BuddyInfo(java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testBuddyInfo()
	{	
		assertEquals(testName, buddyInfo.getName());
		assertEquals(testAddress, buddyInfo.getHomeAddress());
		assertEquals(testPhone, buddyInfo.getPhoneNumber());
		assertEquals(testGreeting, buddyInfo.getGreeting());
		assertEquals(testAge, buddyInfo.getBuddyAge());
		
		buddyInfo = new BuddyInfo(null, null, null,null,0);
		assertNotNull(buddyInfo.getName());
		assertNotNull(buddyInfo.getHomeAddress());
		assertNotNull(buddyInfo.getPhoneNumber());
		assertNotNull(buddyInfo.getGreeting());
	}

	/**
	 * Test method for {@link buddyinfo.BuddyInfo#getName()}.
	 */
	@Test
	public void testGetName()
	{
		assertEquals(testName, buddyInfo.getName());
	}

	/**
	 * Test method for {@link buddyinfo.BuddyInfo#setName(java.lang.String)}.
	 */
	@Test
	public void testSetName()
	{
		String newName = "newTestName";
		buddyInfo.setName(newName);
		assertEquals(newName, buddyInfo.getName());

		// Make sure that passing a null object in does not set the name
		buddyInfo.setName(null);
		assertNotNull(buddyInfo.getName());

	}

	/**
	 * Test method for {@link buddyinfo.BuddyInfo#getPhoneNumber()}.
	 */
	@Test
	public void testGetPhoneNumber()
	{
		assertEquals(testPhone, buddyInfo.getPhoneNumber());
	}

	/**
	 * Test method for
	 * {@link buddyinfo.BuddyInfo#setPhoneNumber(java.lang.String)}.
	 */
	@Test
	public void testSetPhoneNumber()
	{
		String newPhone = "newTestPhone";
		buddyInfo.setPhoneNumber(newPhone);
		assertEquals(newPhone, buddyInfo.getPhoneNumber());

		// Make sure that passing a null object in does not set the name
		buddyInfo.setPhoneNumber(null);
		assertNotNull(buddyInfo.getPhoneNumber());
	}

	/**
	 * Test method for {@link buddyinfo.BuddyInfo#getHomeAddress()}.
	 */
	@Test
	public void testGetHomeAddress()
	{
		assertEquals(testAddress, buddyInfo.getHomeAddress());
	}

	/**
	 * Test method for
	 * {@link buddyinfo.BuddyInfo#setHomeAddress(java.lang.String)}.
	 */
	@Test
	public void testSetHomeAddress()
	{
		String newAddress = "newTestAddress";
		buddyInfo.setHomeAddress(newAddress);
		assertEquals(newAddress, buddyInfo.getHomeAddress());

		// Make sure that passing a null object in does not set the name
		buddyInfo.setHomeAddress(null);
		assertNotNull(buddyInfo.getHomeAddress());
	}

	@Test
	public void testCopyConstructor()
	{
		BuddyInfo copyInfo = new BuddyInfo(this.buddyInfo);
		assertEquals(testName, copyInfo.getName());
		assertEquals(testAddress, copyInfo.getHomeAddress());
		assertEquals(testPhone, copyInfo.getPhoneNumber());
		assertEquals(testGreeting, copyInfo.getGreeting());
		assertEquals(testAge, copyInfo.getBuddyAge());
	}
	
	@Test
	public void testGetGreeting()
	{
		assertEquals(testGreeting, buddyInfo.getGreeting());
	}
	
	@Test
	public void testSetGreeting()
	{
		String greeting = "New Greeting";
		buddyInfo.setGreeting(greeting);
		assertEquals(greeting, buddyInfo.getGreeting());
	}
	
	@Test
	public void testGetAge()
	{
		assertEquals(testAge, buddyInfo.getBuddyAge());
	}
	
	@Test
	public void testSetAge()
	{
		int[] testValues = {-5, 0, 10230, 9999, -999999, 6969};
		
		for(int i = 0; i < testValues.length; i++)
		{
			buddyInfo.setBuddyAge(testValues[i]);
			if(testValues[i] >= 0)
				assertEquals(testValues[i], buddyInfo.getBuddyAge());
			else
				assertTrue(! (buddyInfo.getBuddyAge() < 0));
		}
		
	}
	
	@Test
	public void testIsOver18()
	{
		assertEquals(true, buddyInfo.isOver18());
		
		buddyInfo.setBuddyAge(0);
		assertEquals(false, buddyInfo.isOver18());
		
	}
	
	/**
	 * Test method for {@link buddyinfo.BuddyInfo#toString()}.
	 */
	@Test
	public void testToString()
	{
		assertEquals(testName, buddyInfo.toString());
	}

}
