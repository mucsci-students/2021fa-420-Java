import java.util.*;
import java.util.regex.Pattern;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

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
			if (!noAttributeDupes.contains(name.getName()) && !p.matcher(name.getName()).find()) {
				noAttributeDupes.add(name.getName());
				for (UML uml : collection) {
					if (uml.getName().equals(className)) {
						uml.attr.add(name);
						break;
					}
				}
				System.out.println("Attribute Created!");
			}
			// Given attribute name is not alphanumeric
			else if (p.matcher(name.getName()).find()) {
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
	public static void removeAttribute (String className, String name) {
		// Given class exists
		if (noClassDupes.contains(className)) {
			// Given attribute exists
			if (noAttributeDupes.contains(name)) {
				for (UML uml : collection) {
					if (uml.getName().equals(className)) {
						for (Attributes a : uml.attr){
							if(a.getName().equals(name)){
								int remove = uml.attr.indexOf(a);
								uml.attr.remove(remove);
								return;
							}
						}

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
			if (noAttributeDupes.contains(oldName.getName()) && !p.matcher(newName.getName()).find()) {
				for (UML uml : collection) {
					if (uml.getName().equals(className)) {
						noAttributeDupes.remove(oldName.getName());
						noAttributeDupes.add(newName.getName());
						uml.attr.set(uml.attr.indexOf(oldName), newName);
						break;
					}
				}
				System.out.println("Attribute Renamed!");
			}
			// Given attribute must be alphanumeric
			else if (p.matcher(newName.getName()).find()) {
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

	public static void addRel(String className, UML destination){ //make String type into enum later
		boolean foundDest = false;
		for (UML c: collection){
			if (c.getName().equals(destination.getName())){ // Need to see if the destination file exists
				foundDest = true;
				break; 
			}
		}
		if(foundDest){
			Relationships r = new Relationships(destination);
			for(UML u : collection){
				if( u.getName().toLowerCase().equals(className.toLowerCase())){ // searches for the class name that we are adding a relationship to
					u.rels.add(r); 
					System.out.println("Relationship added!");

					return;
				}
			}
			System.out.println(className + " does not exist");
		} else{
			System.out.println(destination + " does not exist");
		}
	}
	public static void delRel(String className, UML destination){
		for(UML u : collection){
			if (u.getName().toLowerCase().equals(className.toLowerCase())){ //finds uml
				for (Relationships r : u.rels){
					if (r.getDestination().getName().equals(destination.getName()) ){ //Checks if a relationship in the relationship arraylist has the same name as the requested deletion destination 
						int x = u.rels.indexOf(r);	// Needed to finds where the relationship is that we need to delete
						u.rels.remove(x);
						System.out.println("Relationship deleted!");
						return;
					}

				}
				System.out.println(destination + " does not exist");
			}
		}
		System.out.println(className + " does not exist");
	}

	//Will list all of UMLs attributes.
	public void listAttributes (){
		//Checks if there are any attributes.
		if (attr.isEmpty()) {
			System.out.println("This class has no attributes");
		} else {
			System.out.println("Class:" + name + "\nAttributes");
			//Prints all attributes in arrayList "attr"
			for(int i = 0; i < attr.size(); i++) 
				System.out.println(" " + attr.get(i).getName());
		}
	}	

	//Will list all of UMLs relationships.
	public void listRelationships (){
		//Checks if there are any relationships.
		if (rels.isEmpty()) {
			System.out.println("Error:No relationships exist");
		} else {
			System.out.println(name + " relationships:");
			//Prints all relationships in arrayList "rels"
			for(int i = 0; i < rels.size(); i++) 
				System.out.println(" " + rels.get(i).getDestination().getName());
		}
	}
	// Saves the ArrayList of UML objects into a json string format
	public static String save (){
		Gson gson = new Gson();
		// Converts the list to JSON
		String saveFile = gson.toJson(collection);
		return saveFile;

	}

	// Loads a String with a JSON format and turns it into an ArrayList of UML objects
	// CAN'T CATCH ERRORS YET BECAUSE OUR 420 CLASS DIDN'T DECIDE ON A JSON FORMAT
	public static void load (String loaded){ 
		
		// Tells the Gson converter that we want an ArrayList of UML objects
		Type type = new TypeToken<ArrayList<UML>>(){}.getType();
		// Puts the JSON string and determines the type of list needed and makes a new ArrayList with this information
		ArrayList<UML> newCollection = new Gson().fromJson(loaded, type);
		// Empties the current ArrayList
		collection.clear();
		// The new collection of the loaded UML object
		collection.addAll(newCollection);
		
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
				String deleteAttribute = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

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

			case "addrelation":
				System.out.println("What class would you like to add a relation to?");

				String cName = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				System.out.println("What is the destination of the relation");

				String relDest = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
				for(UML u : collection){
					if( u.getName().toLowerCase().equals(relDest)){
						addRel(cName,u);
						break;
					}
				}

				break;

			case "deleterelation":
				System.out.println("What class would you like to delete a relation from?");
				
				String clName = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				System.out.println("What is the destination of the relation");

				String relDestination = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
				for(UML u : collection){
					if( u.getName().toLowerCase().equals(relDestination)){
						delRel(clName,u);
						
						break;
					}
				}
				
				break;

			case "listclasses":
				// Checks to see if collection contains any classes
				if (collection.isEmpty()) {
					System.out.println("Error:No classes exist");
				} else {
					//Prints all classes in arrayList "collection"
					for(int i = 0; i < collection.size(); i++) 
						System.out.println(collection.get(i).getName());
				}
				break;

			case "listcontents":
				System.out.println("What class would you like to list the contents of?");
				//Scanner input (name of UML object)
				String toListContents = scanner.nextLine().toLowerCase().replaceAll("\\s","");
				if (noClassDupes.contains(toListContents)){
					for (UML uml:collection) {
						if (uml.getName().equals(toListContents)) {
							uml.listAttributes();
							break;
						}
					}
				} else {
					System.out.println("Error: class does not exist");
				}
				break;

			case "listrelationships":
				System.out.println("What class would you like to list the relationships of?");
				//Scanner input (name of UML object)
				String toListRelationships = scanner.nextLine().toLowerCase().replaceAll("\\s","");
				if (noClassDupes.contains(toListRelationships)){
					for (UML uml:collection) {
						if (uml.getName().equals(toListRelationships)) {
							uml.listRelationships();
							break;
						}
					}
				} else {
					System.out.println("Error: class does not exist");
				}
				break;

			case "help":
				System.out.println("add class - creates a new unique class * the name must be alphanumeric and not already exist."
						+ "\ndelete class - deletes a preexisting class * the class must already exist to delete it."
						+ "\nrename class - takes a class and provides a new name * the name must not already exist as another class and it's new name must be alphanumeric."
						+ "\nhelp - provides a list of commands usable commands."
						+ "\nexit - exists the program.");
				break;

			case "exit":
				System.out.println("Exiting the application.");
				run = false;
				break;

			case "save":
				String saveFile = save();
				System.out.println("File saved!");
				System.out.println(saveFile);
				break;

			case "load":
			System.out.println("Any unsaved changes will be deleted. Do you wish to proceed? (Yes or No)");
			String confirm = scanner.nextLine().toLowerCase().replaceAll("\\s","");

			//Safeguard so the user doesn't accidentally delete files
			if(confirm.equals("yes")){
				System.out.println("Enter the file you would like to load");
				String loadFile = scanner.nextLine().toLowerCase().replaceAll("\\s","");
				load(loadFile);
				System.out.println("File loaded!");
			}
			break;
				

			default:
				System.out.println("Command not recognized. Type help for valid commands");
			}	
		}
		scanner.close();
	}
}
