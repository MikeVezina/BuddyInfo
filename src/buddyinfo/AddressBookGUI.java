/**
 * 
 */
package buddyinfo;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author MVezina
 *
 */
public class AddressBookGUI extends JFrame
{

	// GUI FUNCTIONS
		private AddressBook					addressBook;
		private JMenuItem					createAddressBookButton;
		private JMenuItem					importAddressBookButton;
		private JMenuItem					exportAddressBookButton;
		private JMenuItem					addBuddyButton;
		private JMenuItem					editBuddyButton;
		private JMenuItem					remBuddyButton;

		private JMenuBar					mainMenuBar;

		private JMenu						addressBookMenu;
		private JMenu						buddyInfoMenu;
		private DefaultListModel<BuddyInfo>	listModel;
		private JList<BuddyInfo>			buddyJList;
		

		private boolean compMoved = false;
	
public AddressBookGUI()
{
	super("Address Book Manager");
	addressBook = new AddressBook();
	
	this.setResizable(false);
	this.setSize(new Dimension(275, 60));
	this.setLocationRelativeTo(null);
	

	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.getContentPane().setLayout(new FlowLayout());

	InitializeComponents();
}

private void InitializeComponents()
{
	
	this.addComponentListener(new ComponentAdapter()
	{
		@Override
		public void componentResized(ComponentEvent e)
		{
			if(!compMoved)
				((JFrame)e.getSource()).setLocationRelativeTo(null);
			
			
		}
		
		@Override
		public void componentMoved(ComponentEvent e)
		{
			if(((JFrame)e.getSource()).isVisible())
				compMoved = true;
			
			return;
			
		}
	});
	mainMenuBar = new JMenuBar();

	addressBookMenu = new JMenu("Address Book");
	buddyInfoMenu = new JMenu("Buddy Info");
	this.listModel = addressBook.getListModel();
	
	
	buddyJList = new JList<>(listModel);
	// Handles when an item is selected
	buddyJList.addListSelectionListener(new ListSelectionListener()
	{

		@Override
		public void valueChanged(ListSelectionEvent e)
		{
			if (((JList<?>) e.getSource()).getSelectedIndex() < 0)
			{
				editBuddyButton.setEnabled(true);
				remBuddyButton.setEnabled(true);
				return;
			}
			editBuddyButton.setEnabled(true);
			remBuddyButton.setEnabled(true);

		}
	});

	buddyJList.setPreferredSize(new Dimension(300, 300));

	createAddressBookButton = new JMenuItem("Create");
	createAddressBookButton.setSize(10, 10);
	createAddressBookButton.addActionListener(ae -> createButton_Clicked());

	addressBookMenu.add(createAddressBookButton);

	importAddressBookButton = new JMenuItem("Import");
	importAddressBookButton.addActionListener(al -> importButton_Clicked());
	importAddressBookButton.setEnabled(true);
	addressBookMenu.add(importAddressBookButton);
	
	exportAddressBookButton = new JMenuItem("Export");
	exportAddressBookButton.setSize(10, 10);
	exportAddressBookButton.addActionListener(al -> this.saveAddressBook());
	exportAddressBookButton.setEnabled(false);
	addressBookMenu.add(exportAddressBookButton);
	

	addressBookMenu.add(exportAddressBookButton);

	addBuddyButton = new JMenuItem("Add Buddy");
	addBuddyButton.setSize(10, 10);

	// Set up the action listener for the add buddy button
	addBuddyButton.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String buddyName = (String) JOptionPane.showInputDialog("Please Enter the name of the buddy:");
			String homeAddress = (String) JOptionPane.showInputDialog("Please Enter the Home Address of the buddy:");
			String phoneNumber = (String) JOptionPane.showInputDialog("Please Enter the Phone Number of the buddy:");
			String greeting = (String) JOptionPane.showInputDialog("Please Enter the Greeting of the buddy:");
			int age = Integer.parseInt( JOptionPane.showInputDialog("Please Enter the Age of the buddy:"));
			addBuddy(new BuddyInfo(buddyName, homeAddress, phoneNumber, greeting, age));

		}
	});

	addBuddyButton.setEnabled(false);
	buddyInfoMenu.add(addBuddyButton);
	
	editBuddyButton = new JMenuItem("Edit Buddy");
	editBuddyButton.setSize(10, 10);

	// Set up the action listener for the add buddy button
	editBuddyButton.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// Ensure the selected index is valid
			if (buddyJList.getSelectedIndex() < 0)
				return;
			
			// Edit the selected buddy
			BuddyInfo selectedBuddy = buddyJList.getSelectedValue();
			selectedBuddy.setName((String) JOptionPane.showInputDialog("Please Enter the name of the buddy:", selectedBuddy.getName()));
			selectedBuddy.setHomeAddress((String) JOptionPane.showInputDialog("Please Enter the Home Address of the buddy:", selectedBuddy.getHomeAddress()));
			selectedBuddy.setPhoneNumber((String) JOptionPane.showInputDialog("Please Enter the Phone Number of the buddy:", selectedBuddy.getPhoneNumber()));
		}
	});

	editBuddyButton.setEnabled(false);
	buddyInfoMenu.add(editBuddyButton);

	remBuddyButton = new JMenuItem("Remove Buddy");
	remBuddyButton.setSize(10, 10);

	// Set up the action listener for the add buddy button
	remBuddyButton.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(buddyJList.getSelectedIndex() < 0)
				return;
			addressBook.removeBuddy(buddyJList.getSelectedIndex());

		}
	});

	remBuddyButton.setEnabled(false);
	buddyInfoMenu.add(remBuddyButton);

	// Add components to menu bar
	mainMenuBar.add(addressBookMenu);
	mainMenuBar.add(buddyInfoMenu);

	// Add menu bar and list to frame
	this.add(mainMenuBar);
	//this.add(buddyJList);

	// Set visible
	this.setVisible(true);
}

private void importButton_Clicked() {
	
	if(!createAddressBook())
		return;
		
	try
	{
		addressBook.importAddressBook();
	}
	catch(IOException ioe)
	{
		ioe.printStackTrace();
	}
}


private void createButton_Clicked()
{
	createAddressBook();
	
	this.setSize(new Dimension(320, 365));
	this.add(buddyJList);
	buddyJList.setVisible(true);
	
}
private boolean createAddressBook()
{
	if(buddyJList.getModel().getSize() > 0)
	{
		if(JOptionPane.showConfirmDialog(this, "You have pending buddies. Would you like to discard them?", "Warning!", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
		{
			return false;
		}
	}
	
	
	listModel.clear();
	
	exportAddressBookButton.setEnabled(true);
	addBuddyButton.setEnabled(true);
	createAddressBookButton.setEnabled(false);
	
	
	return true;

}

private void saveAddressBook()
{
	try
	{
		addressBook.exportAddressBook();
	}
	catch(IOException ioe)
	{
		ioe.printStackTrace();
	}
	
}


private void addBuddy(BuddyInfo bI)
{
	this.addressBook.addBuddy(bI);
}

public static void main(String[] args)
{
	
	new AddressBookGUI();
}
		
		
}
