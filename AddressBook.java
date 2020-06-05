import java.util.Scanner;
class Book
{Scanner s = new Scanner(System.in);
	class Entry
 	{
		private String FirstName;
	        private String LastName;
       		private String address;
        	private String city;
		private String state;
		private String zip;
		private String PhoneNumber;

		Entry(String FirstName, String LastName, String address, String city, String state, String zip, String PhoneNumber)
		{
            		this.FirstName = FirstName;
            		this.LastName = LastName;
            		this.address = address;
            		this.city = city;
	    		this.state = state;
	    		this.zip = zip;
	    		this.PhoneNumber = PhoneNumber;
        	}

		Entry()
		{
            		FirstName = "";
            		LastName = "";
            		address = "";
            		city = "";
			state = "";
			zip = "";
			PhoneNumber = "";
        	}

		public void readEntry()
		{
            		System.out.println("First Name  : "+FirstName );
            		System.out.println("Last Name   : "+LastName );
            		System.out.println("Address     : "+address );
            		System.out.println("City        : "+city );
			System.out.println("State       : "+state );
			System.out.println("Zip         : "+zip );
			System.out.println("PhoneNumber : "+PhoneNumber );
        	}
    	}


private int entries = 0;
Entry[] contents;

public void initEntries(int e)
{
	contents = new Entry[e];
    	for(int i=0;i<contents.length;i++)
	{
    	contents[i] = new Entry();
    	}
}

public int getEntries()
{
	return contents.length;
}

public void add(String FirstName, String LastName, String address, String city, String state, String zip, String PhoneNumber)
{
	if (entries<contents.length)
	{
	    	contents[entries] = new Entry(FirstName, LastName, address, city, state, zip, PhoneNumber);
        	entries++;
	}
    	else
		System.out.println("Error: book is full");
}

public void remove(int entry)
{
	if (entries>0)
	{
    		contents[entry] = new Entry();
        	for (int i = 0;i<entries-entry;i++)
		{
        		if (entry+1==entries)
				contents[entry] = new Entry();
			else
				{
                    			Entry temp = contents[entry+i];
                    			contents[entry+i] = contents[entry+i+1];
                    			contents[entry+i+1] = temp;
                		}
        	}
            entries--;
	}
        else
		System.out.println("Error: book is empty.");
}

public void edit(String FirstName, String LastName, String address, String city, String state, String zip, String PhoneNumber, int selection)
{
	contents[selection].FirstName = FirstName;
   	contents[selection].LastName = LastName;
	contents[selection].address = address;
 	contents[selection].city = city;
	contents[selection].state = state;
	contents[selection].zip = zip;
	contents[selection].PhoneNumber = PhoneNumber;
}

public void sort(int n)
{
	for(int i = 0;i<contents.length;i++)
	{
    		for (int j = 0;j<contents.length;j++)
		{
        		switch(n)
			{
            			case 1:
                			if (contents[i].FirstName.compareTo(contents[j].FirstName)<0)
					{
                    				Entry temp = contents[i];
                        			contents[i] = contents[j];
                       				contents[j] = temp;
                    			}
                    			break;
				case 2:
 		             		if (contents[i].LastName.compareTo(contents[j].LastName)<0)
					{
                			    	Entry temp = contents[i];
                        			contents[i] = contents[j];
                        			contents[j] = temp;
                    			}
                    			break;
                		case 3:
                    			if (contents[i].zip.compareTo(contents[j].zip)<0)
					{
        			            	Entry temp = contents[i];
                			        contents[i] = contents[j];
                			        contents[j] = temp;
                    			}
                    			break;
				default:
                    			System.out.println("Error: invalid field");
                   			break;
			}
		}
	}
}

}
public class AddressBook
{
    public static void main(String[] args)
	{
        	Scanner s = new Scanner(System.in);
		System.out.println("********** Address Book Entries ***********");
		int howManyEntries;

		Book[] books = new Book[0];

		int no_of_books=1;
		books= new Book[no_of_books];

		for (int i=0;i<books.length;i++)
		{
			books[i] = new Book();

            		while(true)
				{
                			System.out.print("How many entries in book ? ");
                			howManyEntries = s.nextInt();

			   		if (howManyEntries>0)
					{
                    				books[i].initEntries(howManyEntries);
                    				break;
                			}
                			else
						System.out.println("You must create at least 1 Entry.");
				}
		}

int selection;
boolean task_completed=false;
int select=0;
while(task_completed==false)
{
for (int i=0;i<books[select].getEntries();i++)
	{
	System.out.println("===========Entry "+(i+1)+" ===========");
	books[select].contents[i].readEntry();
    	System.out.println("================================");
	}


{
	System.out.println("Select an option!");
	System.out.println("1. Add an entry");
	System.out.println("2. Remove an entry");
	System.out.println("3. Edit an entry");
	System.out.println("4. Sort all entries in this book");
	System.out.println("5. Exit");
	System.out.print("----> ");
	selection = s.nextInt();
	String FirstName, LastName, address, city, state, zip, PhoneNumber;

switch(selection)
{
	case 1:
	    	System.out.print("First name : ? ");
        	FirstName = s.next();
       		System.out.print("Last name : ? ");
        	LastName = s.next();
        	System.out.print("Address : ? ");
        	address = s.next();
        	System.out.print("City : ? ");
        	city = s.next();
		System.out.print("State : ? ");
        	state = s.next();
		System.out.print("Zip : ? ");
        	zip = s.next();
		System.out.print("Phone Number : ? ");
        	PhoneNumber = s.next();

		books[select].add(FirstName, LastName, address, city, state, zip, PhoneNumber);
        	break;

	case 2:
        	System.out.print("Remove which entry? ");
        	int entry = s.nextInt();
        	books[select].remove(entry);
        	break;

	case 3:
        	System.out.print("Edit which entry?");
        	int whichEntry = s.nextInt();
        	System.out.print("First name : ?");
        	FirstName = s.next();
        	System.out.print("Last name : ? ");
        	LastName = s.next();
        	System.out.print("Address : ? ");
        	address = s.next();
        	System.out.print("City : ? ");
        	city = s.next();
		System.out.print("State : ? ");
        	state = s.next();
		System.out.print("Zip : ? ");
        	zip = s.next();
		System.out.print("Phone Number : ? ");
        	PhoneNumber = s.next();

		books[select].edit(FirstName, LastName, address, city, state, zip, PhoneNumber, whichEntry);
        	break;

	case 4:
        	System.out.println("Sort alphabetically by which field?");
       		System.out.println("1. Sort by first name");
        	System.out.println("2. Sort by last name");
        	System.out.println("3. Sort by zip");
        	books[select].sort(s.nextInt());
       		break;
	case 5:
		task_completed=true;
		break;
	default:
        	System.out.print("Please choose a valid menu number");

}
}
}
}
}


