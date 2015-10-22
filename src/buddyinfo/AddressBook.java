package buddyinfo;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.util.*;

import javax.swing.*;

public class AddressBook extends JFrame implements ActionListener
{

	// GUI FUNCTIONS

	private List<BuddyInfo>	buddyInfoList;
	private AddressBook		addressBook;

	private JMenuItem		createAddressBookButton;
	private JMenuItem		saveAddressBookButton;
	private JMenuItem		displayAddressBookButton;
	private JMenuItem		addBuddyButton;

	private JMenuBar		mainMenuBar;

	private JMenu			addressBookMenu;
	private JMenu			buddyInfoMenu;

	private JTextArea		textArea;

	public AddressBook()
	{
		super("Address Book Manager");

		this.setSize(new Dimension(500, 500));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new FlowLayout());

		InitializeComponents();
	}

	private void InitializeComponents()
	{
		mainMenuBar = new JMenuBar();

		addressBookMenu = new JMenu("Address Book");
		buddyInfoMenu = new JMenu("Buddy Info");

		createAddressBookButton = new JMenuItem("Create");
		createAddressBookButton.setSize(10, 10);
		createAddressBookButton.addActionListener(this);
		addressBookMenu.add(createAddressBookButton);

		saveAddressBookButton = new JMenuItem("Save");
		saveAddressBookButton.setSize(10, 10);
		saveAddressBookButton.addActionListener(this);
		saveAddressBookButton.setEnabled(false);
		addressBookMenu.add(saveAddressBookButton);

		displayAddressBookButton = new JMenuItem("Display All Buddy Information");
		displayAddressBookButton.setSize(10, 10);
		displayAddressBookButton.addActionListener(this);
		displayAddressBookButton.setEnabled(false);
		addressBookMenu.add(displayAddressBookButton);

		addBuddyButton = new JMenuItem("Add Buddy");
		addBuddyButton.setSize(10, 10);
		addBuddyButton.addActionListener(this);
		addBuddyButton.setEnabled(false);
		buddyInfoMenu.add(addBuddyButton);

		mainMenuBar.add(addressBookMenu);
		mainMenuBar.add(buddyInfoMenu);

		this.add(mainMenuBar);

		textArea = new JTextArea();

		this.add(textArea);

		textArea.setPreferredSize(new Dimension(500, 250));

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource().equals(createAddressBookButton))
		{
			CreateAddressBook();
			
			saveAddressBookButton.setEnabled(true);
			displayAddressBookButton.setEnabled(true);
			addBuddyButton.setEnabled(true);
		}
		else if (e.getSource().equals(saveAddressBookButton))
		{
			try
			{
				SaveAddressBook();
			}
			catch (Exception exc)
			{

			}
		}
		else if (e.getSource().equals(displayAddressBookButton))
		{
			DisplayAddressBook();
		}
		else if (e.getSource().equals(addBuddyButton))
		{
			String buddyName = (String) JOptionPane.showInputDialog("Please Enter the name of the buddy:");
			String homeAddress = (String) JOptionPane.showInputDialog("Please Enter the Home Address of the buddy:");
			String phoneNumber = (String) JOptionPane.showInputDialog("Please Enter the Phone Number of the buddy:");
			buddyInfoList.add(new BuddyInfo(buddyName, homeAddress, phoneNumber));
			textArea.append("Created BuddyInfo: " + buddyName + "\n");
		}
	}

	private void CreateAddressBook()
	{
		this.buddyInfoList = new ArrayList<>();
		
		textArea.setText(textArea.getText() + "Created Address Book\n");


	}

	private void SaveAddressBook() throws IOException
	{
		FileWriter fW = new FileWriter("/Users/MVezina/Desktop/AddrBook.txt");

		for (BuddyInfo bI : buddyInfoList)
		{
			fW.write(bI.toString());
		}

		fW.close();
		textArea.append("Saved Address Book\n");
	}

	private void DisplayAddressBook()
	{
		textArea.setText("");
		textArea.append("Address Book Contents:\n\n");
		if(buddyInfoList.size() == 0)
		{
			textArea.append("No Buddies Found!\n");
		}
		
		for (BuddyInfo bI : buddyInfoList)
		{
			textArea.append(bI.toString() + "\n\n");
		}
	}

	// END GUI FUNCTIONS

	public void addBuddy(BuddyInfo bI)
	{
		if (bI != null)
			this.buddyInfoList.add(bI);
	}

	public BuddyInfo removeBuddy(int index)
	{
		if (index >= 0 && index < this.buddyInfoList.size())
			return this.buddyInfoList.remove(index);

		return null;
	}

	public static void main(String[] args)
	{
		new AddressBook();

	}

}
