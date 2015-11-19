package buddyinfo;


public class BuddyInfo
{
	private String	name;
	private String	homeAddress;
	private String	phoneNumber;
	private String greeting;
	private int buddyAge;
	
	private final static String DELIMITER = "$";

	

	public BuddyInfo(BuddyInfo buddyInfo)
	{
		this.name = buddyInfo.name;
		this.homeAddress = buddyInfo.homeAddress;
		this.phoneNumber = buddyInfo.phoneNumber;
		this.greeting = buddyInfo.greeting;
		this.buddyAge = buddyInfo.buddyAge;
	}
	
	public int getBuddyAge()
	{
		return buddyAge;
	}
	
	public boolean isOver18()
	{
		return (buddyAge > 18);
	}

	public void setBuddyAge(int buddyAge)
	{
		if(buddyAge < 0)
			return;
		this.buddyAge = buddyAge;
	}

	public BuddyInfo(String name, String address, String phoneNumber, String greeting, int age)
	{
		// Ensure name is not null
		if(name == null)
			this.name = "";
		else
			this.name = name;
		
		// Ensure address is not null
		if (address == null)
			this.homeAddress = "";
		else
			this.homeAddress = address;
		
		// Ensure phone number is not null
		if (phoneNumber == null)
			this.phoneNumber = "";
		else
			this.phoneNumber = phoneNumber;
		
		if(greeting == null)
			this.greeting = "";
		else
			this.greeting = greeting;
		
		if(age < 0)
			this.buddyAge = 0;
		else
			this.buddyAge = age;
	}

	public String getGreeting()
	{
		return greeting;
	}

	public void setGreeting(String greeting)
	{
		if(greeting == null)
			return;
		
		this.greeting = greeting;
	}
	
	public String getName()
	{
		return this.name;
	}

	public void setName(String newName)
	{
		if (newName == null)
			return;

		this.name = newName;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		if (phoneNumber == null)
			return;

		this.phoneNumber = phoneNumber;
	}

	public String getHomeAddress()
	{
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress)
	{
		if (homeAddress == null)
			return;

		this.homeAddress = homeAddress;
	}

	public static BuddyInfo importBuddy(String buddyInfo)
	{
		
		String[] info = buddyInfo.split("\\" + DELIMITER);
	
		
		if(info.length != 5 || !info[4].matches("[0-9]+"))
		{
			System.out.println("Error: Failed to import buddy info.");
			return null;
		}
		
		return new BuddyInfo(info[0], info[1], info[2], info[3], Integer.parseInt(info[4]));
	}
	
	@Override
	public String toString()
	{
		
		return name + DELIMITER + this.homeAddress + DELIMITER + this.phoneNumber + DELIMITER + this.greeting + DELIMITER + this.buddyAge ;
	}

}
