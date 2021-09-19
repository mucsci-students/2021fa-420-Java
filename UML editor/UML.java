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
	// This set is to make sure there are no attributes with the same name.
	private static HashSet<String> noAttributeDupes = new HashSet<String>();
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

	// Adds an attribute to the given class
	public static void addAttribute (String className, Attributes name) {
		// Given class exists
		if (noClassDupes.contains(className)) {
			// Given attribute does not exist, and the name is alphanumeric
			if (!noAttributeDupes.contains(name.getAttributeName()) && !p.matcher(name.getAttributeName()).find()) {
				noAttributeDupes.add(name.getAttributeName());
				for (UML uml : collection) {
					if (uml.getName().equals(className)) {
						uml.attr.add(name);
						break;
					}
				}
				System.out.println("Attribute Created!");
			}
			// Given attribute name is not alphanumeric
			else if (p.matcher(name.getAttributeName()).find()) {
				System.out.println("A attribute name must only contain numbers and letters");
			}
			// Given attribute exists
			else {
				System.out.println("That attribute ALREADY exist!");
			}
		}
		// Given class does not exist
		else {
			System.out.println("That class does NOT exist!");
		}
	}

	// Remove an attribute from the given class
	public static void removeAttribute (String className, Attributes name) {
		// Given class exists
		if (noClassDupes.contains(className)) {
			// Given attribute exists
			if (noAttributeDupes.contains(name.getAttributeName())) {
				for (UML uml : collection) {
					if (uml.getName().equals(className)) {
						noAttributeDupes.remove(name.getAttributeName());
						uml.attr.remove(name);
						break;
					}
				}
				System.out.println("Attribute Removed!");
			}
			// Given attribute does not exist
			else {
				System.out.println("That attribute does not exist!");
			}
		}
		// Given class does not exists
		else {
			System.out.println("That class does not exist!");
		}
	}

	// Renames an already existing attribute in a given class
	public static void renameAttribute (String className, Attributes oldName, Attributes newName) {
		// Given class exist
		if (noClassDupes.contains(className)) {
			// Given attribute does not exist, and the name is alphanumeric
			if (noAttributeDupes.contains(oldName.getAttributeName()) && !p.matcher(newName.getAttributeName()).find()) {
				for (UML uml : collection) {
					if (uml.getName().equals(className)) {
						noAttributeDupes.remove(oldName.getAttributeName());
						noAttributeDupes.add(newName.getAttributeName());
						uml.attr.set(uml.attr.indexOf(oldName), newName);
						break;
					}
				}
				System.out.println("Attribute Renamed!");
			}
			// Given attribute must be alphanumeric
			else if (p.matcher(newName.getAttributeName()).find()) {
				System.out.println("A attribute name must only contain numbers and letters");
			}
			// Given attribute does not exist
			else {
				System.out.println("That attribute does not exist!");
			}
		}
		// Given class does not exist
		else {
			System.out.println("That class does not exist!");
		}
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

			case "addattribute":
				System.out.println("What class are you adding to?");
				String classNameAdd = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				System.out.println("What would you like to name the new attribute?");
				Attributes addAttribute = new Attributes(scanner.nextLine().toLowerCase().replaceAll("\\s", ""));

				addAttribute(classNameAdd, addAttribute);

				break;

			case "deleteattribute":
				System.out.println("What class are you removing from?");
				String classNameRemove = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				System.out.println("What attribute are you removing?");
				Attributes deleteAttribute = new Attributes(scanner.nextLine().toLowerCase().replaceAll("\\s", ""));

				removeAttribute(classNameRemove, deleteAttribute);

				break;

			case "renameattribute":
				System.out.println("What class are you making modifications in?");
				String classNameRename = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				System.out.println("What attribute are you renaming?");
				Attributes oldAttribute = new Attributes(scanner.nextLine().toLowerCase().replaceAll("\\s", ""));

				System.out.println("What would you like to rename the attribute to?");
				Attributes newAttribute = new Attributes(scanner.nextLine().toLowerCase().replaceAll("\\s", ""));

				renameAttribute(classNameRename, oldAttribute, newAttribute);

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
