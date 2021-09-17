
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
	public String getName() {
		return name;
	}

  // Adds an attribute to the given class
  // Exception if:
  // - class does NOT exist
  // - attribute name is not alphanumeric
  // - attribute already exists in class
  public static void addAttribute (String className, Attributes name) {
		// Given class exists and is alphanumeric
    if (noClassDupes.contains(className) && !p.matcher(className).find()) {
			// Given attribute does not exist, but the name is alphanumeric
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
		// Given class name is not alphanumeric
		else if (p.matcher(className).find()) {
			System.out.println("A class name must only contain numbers and letters");
		}
		// Given class does not exist
		else {
			System.out.println("That class does NOT exist!");
		}
  }

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
  }

  // Renames an already existing attribute in a given class
  // Exception if:
  // - class does NOT exist
  // - attribute does NOT
  // - attribute's new name is not alphanumeric
  public static void renameAttribute (String className, Attributes oldName, Attributes newName) {
		if (noClassDupes.contains(className)) {
			if (noAttributeDupes.contains(oldName.getAttributeName())) {
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
			else {
				System.out.println("That attribute does not exist!");
			}
		}
		else {
			System.out.println("That class does not exist!");
		}
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
					String className1 = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

					System.out.println("What would you like to name the new attribute?");
					Attributes addAttribute = new Attributes(scanner.nextLine().toLowerCase().replaceAll("\\s", ""));

					addAttribute(className1, addAttribute);

					break;

				case "deleteattribute":
					System.out.println("What class are you removing from?");
					String className2 = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

					System.out.println("What attribute are you removing?");
					Attributes deleteAttribute = new Attributes(scanner.nextLine().toLowerCase().replaceAll("\\s", ""));

					removeAttribute(className2, deleteAttribute);

					break;

				case "renameattribute":
					System.out.println("What class are you making modifications in?");
					String className3 = s.nextLine().toLowerCase().replaceAll("\\s", "");

					System.out.println("What attribute are you renaming?");
					Attributes oldAttribute = new Attributes(scanner.nextLine().toLowerCase().replaceAll("\\s", ""));

					System.out.println("What would you like to rename the attribute to?");
					Attributes newAttribute = new Attributes(scanner.nextLine().toLowerCase().replaceAll("\\s", ""));

					renameAttribute(className3, oldAttribute, newAttribute);

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
