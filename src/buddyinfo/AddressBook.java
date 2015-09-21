package buddyinfo;

import java.util.*;


public class AddressBook
{
		private List<BuddyInfo> buddyInfo;
		
		public AddressBook()
		{
			this.buddyInfo = new ArrayList<>();
		}
		
		public void addBuddy(BuddyInfo bI)
		{
			if(bI != null)
				this.buddyInfo.add(bI);
		}
		
		public BuddyInfo removeBuddy(int index)
		{
			if(index >= 0 && index < this.buddyInfo.size())
				return this.buddyInfo.remove(index);
			
			return null;
		}
		
		
		public static void main(String[] args)
		{
			BuddyInfo buddy = new BuddyInfo("Tom", "Carleton", 1234);
		}
	
}
