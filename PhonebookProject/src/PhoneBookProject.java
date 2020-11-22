import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;




/**
 * This is a phone book application that will display a menu allowing a user 
 * to select a task. tasks include adding and removing phone book entries and 
 * searching for entries
 * @author Yurie Fernand
 *
 */
public class PhoneBookProject {
	/**
	 * Main function which controls the user interface with the phone book objects
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<Address> list1 = new LinkedList<Address>(); // set up storage for entries
		Scanner scnr = new Scanner(System.in);// establish the scanner function
		String fname;
		String lname;
		String input;
		int choice = 0;   // initiate needed variables choice for menu selection 
		boolean run = true; // while loop that controls main menu will run while run is true
		
		System.out.println("Welcome to the Phonebook! \nwhat would you like to do?"); // user intro
		
		while(run) {// run until user selects menu item 5
			System.out.println("\nEnter the number for the desired task:"); // display menu items
			System.out.println("1. Add a new record");
			System.out.println("2. Delete a record");
			System.out.println("3. Edit record");
			System.out.println("4. Search record");
			System.out.println("5. Show list sorted by Phone Number asending");
			System.out.println("6: Exit Phonebook");
	
			choice = scnr.nextInt();// read in user selection
			
			
			switch(choice) {// switch with user input as argument to perform desired function
			case 1: // add a new record
				System.out.println("\nEnter the entry as follows: Frist name Last name, street address, city, state arbbrev, zip, phone # (0123456789)");
				String data = scnr.next();
				String data1 = scnr.nextLine();
				String info[] = data1.split(",");
		
				 list1.add(new Address(data, info[0].trim(), info[1].trim(), info[2].trim(), info[3].trim(), info[4],info[5]));
				break;
			case 2: // delete a record
				System.out.println("\nEnter the Phone number of the entry to delete:");
				input = scnr.next();
				
				for(int i = 0; i < list1.size(); i++) {
					if((input.equals(list1.get(i).getNumber().trim()))){
						System.out.println("\nInformation of Deleted Record:");
						list1.get(i).displayEntry();
						list1.remove(i);
					}
				}
				break;
			case 3: // edit a record
				boolean run1 = true;
				System.out.println("\nEnter the phone number of the record you would like to edit:");
				
				input = scnr.next();
				
				while(run1) {// this for loop is to allow user to change multiple items without having to go through main menu every time exit on case 7
					for(int i = 0; i < list1.size(); i++) {
						if((input.equals(list1.get(i).getNumber()))){
							list1.get(i).displayEntry();
						}
							System.out.println("\nWhat would you like to edit?");
							System.out.println("1: Name");
							System.out.println("2: Street address");
							System.out.println("3: City");
							System.out.println("4: State");
							System.out.println("5: Zip code");
							System.out.println("6: Phone number");
							System.out.println("7: Main Menu");
							
							choice = scnr.nextInt();
							
							switch(choice) {
							case 1:// edit name
								System.out.println("\nEnter the new First and Last name:");
								
								fname = scnr.next().trim();
							 	lname = scnr.next().trim();
								
								list1.get(i).setFirstName(fname);
								list1.get(i).setLastName(lname);
								list1.get(i).displayEntry();
								break;
							case 2: // edit street address
								System.out.println("\nEnter the new Street address:");
								
								String street = scnr.nextLine().trim();
								
								list1.get(i).setStreet(street);
								list1.get(i).displayEntry();
								break;
							case 3: // edit city
								System.out.println("\nEnter the new city:");
								
								String city = scnr.nextLine().trim();
								
								list1.get(i).setCity(city);
								list1.get(i).displayEntry();
								break;
							case 4: // edit state
								System.out.println("\nEnter the new State abbreviation");
								
								String state = scnr.next().trim();
								
								list1.get(i).setState(state);
								list1.get(i).displayEntry();
								break;
							case 5:// edit zip code
								System.out.println("\nEnter the new zip code:");
								
								String zip = scnr.next().trim();
								
								list1.get(i).setZip(zip);
								list1.get(i).displayEntry();	
								break;
							case 6: //  edit phone number
								System.out.println("\nEnter the new Phone Number:");
								
								String number = scnr.next().trim();
								
								list1.get(i).setPhone(number);
								list1.get(i).displayEntry();
								
								break;
							case 7:
								run1 = false;
								break;
							}
						}
					
				}
				
				break;
			case 4: // search a record
				boolean run2 = true;
				int counter = 1;
				while(run2) {
				System.out.println("\nWhat would you like to search by:");
				System.out.println("1: First name");
				System.out.println("2: Last name");
				System.out.println("3: Full name");
				System.out.println("4: Phone number");
				System.out.println("5: City");
				System.out.println("6: State");
				System.out.println("7: Main menu");
				
				choice = scnr.nextInt();
				switch(choice) {
				case 1: // search by first name 
					System.out.println("\nEnter the First name of the record to be searched:");
					
					input = scnr.next().trim();
					
					 counter = 1;
					for(int i =0; i < list1.size(); i ++) {
						if(input.equals(list1.get(i).getFirstName())) {
							System.out.println("\nRecord " + counter + ":");
							list1.get(i).displayEntry();
							counter++;
						}
					}
					break;
				case 2: // search by last name
					System.out.println("\nEnter the Last name of the record to be searched:");
					
					input = scnr.next().trim();
					
					counter = 1;
					for(int i =0; i < list1.size(); i ++) {
						if(input.equals(list1.get(i).getLastName())) {
							System.out.println("\nRecord " + counter + ":");
							list1.get(i).displayEntry();
							counter++;
						}
					}
					break;
				case 3: // search by full name
					System.out.println("\nEnter the First and Last name of the record to be searched:");
					
					input = scnr.next().trim();
					lname = scnr.next().trim();
					 counter = 1;
					for(int i =0; i < list1.size(); i ++) {
						if(input.equals(list1.get(i).getFirstName()) && (lname.equals(list1.get(i).getLastName()))) {
							System.out.println("\nRecord " + counter + ":");
							list1.get(i).displayEntry();
							counter++;
						}
					}
					break;
				case 4: //search by phone
					System.out.println("\nEnter the Phone number of the record to be searched:");
					input = scnr.next();
					
					 counter = 1;
					for(int i =0; i < list1.size(); i ++) {
						if(input.equals(list1.get(i).getNumber().trim())) {
							System.out.println("\nRecord " + counter + ":");
							list1.get(i).displayEntry();
							counter++;
						}
					}
					break;
				case 5: // search by city
					System.out.println("\nEnter the City of the record to be searched:");
					scnr.nextLine();
					input = scnr.nextLine();
					
					counter = 1;
					for(int i =0; i < list1.size(); i ++) {
						if(input.equals(list1.get(i).getCity())) {
							System.out.println("\nRecord " + counter + ":");
							list1.get(i).displayEntry();
							counter++;
						}
					}
					break;
				case 6: // search by state
					System.out.println("\nEnter the State of the record to be searched:");
					scnr.nextLine();
					input = scnr.next();
					
					counter = 1;
					for(int i =0; i < list1.size(); i ++) {
						if(input.equals(list1.get(i).getState().trim())) {
							System.out.println("\nRecord " + counter + ":");
							list1.get(i).displayEntry();
							counter++;
						}
					}
					break;
				case 7: // main menu
					run2 = false;
					break;
				}

				}
				
				break;
			case 5: // show sorted list
				Collections.sort(list1, new Comp());
				for(int a = 0; a < list1.size();a++) {
					System.out.println();
					list1.get(a).displayEntry();
				}
				break;
			case 6: // exit program
				run = false;
				scnr.close();
				break;
			
			}
		}
		
	}	

}
