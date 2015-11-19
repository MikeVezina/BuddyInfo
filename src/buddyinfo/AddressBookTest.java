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
public class AddressBookTest
{

	AddressBook addressBook;
	BuddyInfo michael;
	BuddyInfo johnCena;
	BuddyInfo buddy;
	
	
	/**
	 * @throws java.lang.Exception
	 * @author MVezina
	 */
	@Before
	public void setUp() throws Exception
	{
		addressBook = new AddressBook();
		michael = new BuddyInfo("Michael", "address", "phone", "greeting", 20);
		johnCena = new BuddyInfo("John Cena", "address", "phone", "greeting", 20);
		buddy = new BuddyInfo("Buddy", "address", "phone", "greeting", 20);
		addressBook.addBuddy(michael);
		addressBook.addBuddy(johnCena);
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
	 * Test method for {@link buddyinfo.AddressBook#addBuddy(buddyinfo.BuddyInfo)}.
	 */
	@Test
	public void testAddBuddy()
	{
		
		assertEquals(2, addressBook.size());
	}

	/**
	 * Test method for {@link buddyinfo.AddressBook#removeBuddy(int)}.
	 */
	@Test
	public void testRemoveBuddy()
	{
		addressBook.removeBuddy(0);
		assertEquals(1, addressBook.size());
	}

	/**
	 * Test method for {@link buddyinfo.AddressBook#size()}.
	 */
	@Test
	public void testSize()
	{
		assertEquals(2, addressBook.size());
	}

	/**
	 * Test method for {@link buddyinfo.AddressBook#clear()}.
	 */
	@Test
	public void testClear()
	{
		addressBook.clear();
		assertEquals(0, addressBook.size());
	}

}
