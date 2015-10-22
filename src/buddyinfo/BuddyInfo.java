package buddyinfo;

public class BuddyInfo
{
	private String name;
	private String homeAddress;
	private String phoneNumber;
	
	public BuddyInfo(String name, String address, String phoneNumber)
	{
		this.name = name;
		this.setHomeAddress(address);
		this.setPhoneNumber(phoneNumber);
	}

	public String getName()
	{
		return this.name;
	}
	
	public void setName(String newName)
	{
		this.name = newName;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public String getHomeAddress()
	{
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress)
	{
		this.homeAddress = homeAddress;
	}
	
	@Override
	public String toString()
	{
		return "Buddy Name: " + name + "\nHome Address: " + homeAddress + "\nPhone Number: " + phoneNumber;
	}
	

}
