import java.util.*;
import java.util.regex.Pattern;

public class UML {
	//Class name
	private String name;
	//List containing all the variables in a UML object
	private ArrayList<Attributes> attr;
	//MAKE ARRAY LIST OF TYPE RELATIONSHIP ONCE JAVA RELATIONSHIP CLASS IS CREATED
	private ArrayList<Relationships> rels;
	// This set is to make sure there are no classes with the same name.
	private static HashSet<String> noClassDupes = new HashSet<String>();
	//This is the Array list that should hold all the objects
	private static ArrayList<UML> collection = new ArrayList<UML>();
	//Regex for determining if string is alphanumeric
	private static Pattern p = Pattern.compile("[^a-zA-Z0-9]");

	public UML (String name) {
		this.name = name;
		this.attr = new ArrayList<Attributes>();
		this.rels = new ArrayList<Relationships>();
	}

	public String getName() {
		//Returns name of class
		return name;
	}

	public void setName(String newName) {
		//Sets class name to new name
		name = newName;
	}

	public static UML addClass(String className) {
		//If class doesn't exist and is alphanumeric
		if(!noClassDupes.contains(className) && !p.matcher(className).find()) {
			//Creates the class
			UML uml = new UML(className);
			noClassDupes.add(className);
			collection.add(uml);
			System.out.println("Class Created!");
			return uml;
		}
		//When the inputted name is not alphanumeric
		else if(p.matcher(className).find()) {
			System.out.println("A class name must only contain numbers and letters.");
		}
		//When the class already exists
		else {
			System.out.println("That class already exists.");
		}
		return null;
	}

	public static UML deleteClass(String deleteName) {
		//Check if the class exists
		if(noClassDupes.contains(deleteName)) {
			//Iterates through the collection
			for(UML uml : collection) {
				//Deletes class when found
				if(uml.getName().equals(deleteName)) {
					noClassDupes.remove(deleteName);
					collection.remove(collection.indexOf(uml));
					System.out.println("Class Deleted!");
					return uml;
				}
			}
		}
		//When the class doesn't exist
		else {
			System.out.println("That class does not exist.");
		}
		return null;
	}

	public static UML renameClass(String oldName, String newName) {
		//Check if the old class exists and new name is alphanumeric
		if(noClassDupes.contains(oldName) && !noClassDupes.contains(newName) && !p.matcher(newName).find()) {
			//Iterates through the collection
			for(UML uml : collection) {
				//Renames old class when found
				if(uml.getName().equals(oldName)) {
					noClassDupes.remove(oldName);
					noClassDupes.add(newName);
					uml.setName(newName);
					System.out.println("Class Renamed!");
					return uml;
				}
			}
		}
		//When the new name is not alphanumeric
		else if(p.matcher(newName).find()) {
			System.out.println("A class name must only contain numbers and letters");
		}
		//When the new class already exists
		else if(noClassDupes.contains(newName)) {
			System.out.println("That class already exists.");
		}
		//When the old class doesn't exist
		else {
			System.out.println("That class does not exist.");
		}
		return null;
	}

	/*
	 * Run command
	 */
	public static void main(String args[]) {

		//Scanner for user input
		Scanner scanner = new Scanner(System.in);
		//Boolean to run program until user exits
		boolean run = true;

		while(run) {

			System.out.println("Enter a command or type exit if you wish to exit!");
			//This is the command the user has entered
			//It is converted to lowercase to allow for easier comparison and ignores white space
			String command = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

			switch(command) {
			case "addclass": 
				System.out.println("What would you like to name the new class?");
				//Class name to add, ignores white space
				String className = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				addClass(className);

				break;

			case "deleteclass":
				System.out.println("What class would you like to remove?");
				//Class name to remove, ignores white space
				String deleteName = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				deleteClass(deleteName);

				break;

			case "renameclass":
				System.out.println("What class would you like to rename?");
				//Class name to replace, ignores white space
				String oldName = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				System.out.println("What is the new name of the class?");
				//New class name, ignores white space
				String newName = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				renameClass(oldName, newName);

				break;
				
			case "help":
				System.out.println("add class\ndelete class\nrename class\nhelp\nexit");
				break;

			case "exit":
				System.out.println("Exiting the application.");
				run = false;
				break;

			default:
				System.out.println("Command not recognized. Type help for valid commands");
			}	
		}
		scanner.close();
	}
}
