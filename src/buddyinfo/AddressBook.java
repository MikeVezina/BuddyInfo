package buddyinfo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;


public class AddressBook
{

	public final static String FILE_NAME = "addressbook.txt";
	private DefaultListModel<BuddyInfo>	buddyInfoListModel;
	
	public AddressBook()
	{
		buddyInfoListModel = new DefaultListModel<>();
	}

	public void addBuddy(BuddyInfo bI)
	{
		if(buddyInfoListModel.contains(bI))
			return;
		
		buddyInfoListModel.addElement(bI);
	}
	
	
	public void exportAddressBook() throws IOException
	{
		BufferedWriter bW = new BufferedWriter(new FileWriter(FILE_NAME));
		
		for(int i = 0; i < buddyInfoListModel.size(); i++)
		{
			bW.write(buddyInfoListModel.getElementAt(i) + "\n");
			
		}
		
		bW.close();
	}

	public void importAddressBook() throws IOException
	{
		BufferedReader bR = new BufferedReader(new FileReader(FILE_NAME));
		while(bR.ready())
		{
			BuddyInfo newBuddy = BuddyInfo.importBuddy(bR.readLine());
			
			if(newBuddy != null)
			this.addBuddy(newBuddy);
			
		}
		
		bR.close();
	}
	
	public void removeBuddy(int index)
	{
		buddyInfoListModel.removeElementAt(index);
	}

	public DefaultListModel<BuddyInfo> getListModel()
	{
		return buddyInfoListModel;
	}
	
	public int size()
	{
		return buddyInfoListModel.size();
	}
	
	public void clear()
	{
		buddyInfoListModel.clear();
	}
	
	

}
