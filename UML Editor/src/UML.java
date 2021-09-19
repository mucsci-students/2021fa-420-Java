
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
/*
 * imports: gradle, json thingy, other classes
 *
 */
public class UML {
	//Class name
	private String name;
	//List containing all the methods in a UML object
	private ArrayList<Methods> met;
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
	// Checks name to see if it is alphanumeric
	private static Pattern p = Pattern.compile("[^a-zA-Z0-9]");

	public UML (String name) {
		this.name = name;
		this.met = new ArrayList<Methods>();
		this.attr = new ArrayList<Attributes>();
		this.rels = new ArrayList<Relationships>();

	}

<<<<<<< HEAD
	/*
	 * Creates a class
	 */
	public static UML createClass (String name) {

		UML x = new UML(name);
		return x;
	}

	/*
	 * returns the name of the class
	 */
=======
>>>>>>> class
	public String getName() {
		return name;
	}

<<<<<<< HEAD
	// Adds an attribute to the given class
	// Exception if:
	// - class does NOT exist
	// - attribute name is not alphanumeric
	// - attribute already exists in class
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
=======
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
>>>>>>> class
		}
		// Given class does not exist
		else {
			System.out.println("That class does NOT exist!");
		}
		return null;
	}

<<<<<<< HEAD
	// Remove an attribute from the given class
	// Exception if:
	// - class does NOT exist
	// - attribute does NOT exist
	public static void removeAttribute (String className, Attributes name) {
		if (noClassDupes.contains(className)) {
			if (noAttributeDupes.contains(name.getAttributeName())) {
				for (UML uml : collection) {
					if (uml.getName().equals(className)) {
						uml.attr.remove(name);
						break;
					}
=======
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
>>>>>>> class
				}
				System.out.println("Attribute Removed!");
			}
			else {
				System.out.println("That attribute does not exist!");
			}
		}
		else {
			System.out.println("That class does not exist!");
		}
		return null;
	}

<<<<<<< HEAD
	// Renames an already existing attribute in a given class
	// Exception if:
	// - class does NOT exist
	// - attribute does NOT
	// - attribute's new name is not alphanumeric
	public static void renameAttribute (String className, Attributes oldName, Attributes newName) {
		if (noClassDupes.contains(className)) {
			if (noAttributeDupes.contains(oldName.getAttributeName()) && !p.matcher(newName.getAttributeName()).find()) {
				for (UML uml : collection) {
					if (uml.getName().equals(className)) {
						noAttributeDupes.remove(oldName.getAttributeName());
						noAttributeDupes.add(newName.getAttributeName());
						uml.attr.set(uml.attr.indexOf(oldName), newName);
						break;
					}
=======
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
>>>>>>> class
				}
				System.out.println("Attribute Renamed!");
			}
			else if (p.matcher(newName.getAttributeName()).find()) {
				System.out.println("A attribute name must only contain numbers and letters");
			}
			else {
				System.out.println("That attribute does not exist!");
			}
		}
<<<<<<< HEAD
=======
		//When the new name is not alphanumeric
		else if(p.matcher(newName).find()) {
			System.out.println("A class name must only contain numbers and letters");
		}
		//When the new class already exists
		else if(noClassDupes.contains(newName)) {
			System.out.println("That class already exists.");
		}
		//When the old class doesn't exist
>>>>>>> class
		else {
			System.out.println("That class does not exist!");
		}
		return null;
	}

	/*
	 * Run command
	 */
	public static void main(String args[]) {


		boolean run = true;
		//Placeholder value for what the scanner input is
		Object value;
		//The current UML document that is being edited
		UML current = null;


		while(run) {

			System.out.println("Enter a command or type exit if you wish to exit!");
			Scanner scanner = new Scanner(System.in);
			//This is the command the user has entered. It is converted to lowercase to allow for easier comparison
			String command = scanner.nextLine().toLowerCase().replaceAll("\\s", "");


			switch(command){
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
				String classNameRename = s.nextLine().toLowerCase().replaceAll("\\s", "");

				System.out.println("What attribute are you renaming?");
				Attributes oldAttribute = new Attributes(scanner.nextLine().toLowerCase().replaceAll("\\s", ""));

				System.out.println("What would you like to rename the attribute to?");
				Attributes newAttribute = new Attributes(scanner.nextLine().toLowerCase().replaceAll("\\s", ""));

				renameAttribute(classNameRename, oldAttribute, newAttribute);

				break;

			case "exit":
				run = false;
				break;

			default:
				System.out.println("Command not recognized. Type help for valid commands");

			}

		}

	}

}
