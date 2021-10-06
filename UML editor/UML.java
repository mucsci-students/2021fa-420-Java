import java.util.*;
import java.util.regex.Pattern;

public class UML {
	//Class name
	private String name;
	//List containing all the fields in a UML object
	private ArrayList<Fields> field;
	//List containing all the fields in a UML object
	private ArrayList<Methods> method;
	//List containing all the relations between UML objects
	private ArrayList<Relationships> rels;
	//This set is to make sure there are no classes with the same name.
	private static HashSet<String> noClassDupes = new HashSet<String>();
	//This set is to make sure there are no fields with the same name.
	private static HashSet<String> noFieldDupes = new HashSet<String>();
	//This set is to make sure there are no method with the same name.
	private static HashSet<String> noMethodDupes = new HashSet<String>();
	//This is the Array list that should hold all the objects
	private static ArrayList<UML> collection = new ArrayList<UML>();
	//Regex for determining if string is alphanumeric
	private static Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");

	public UML(String name) {
		this.name = name;
		this.field = new ArrayList<Fields>();
		this.method = new ArrayList<Methods>();
		this.rels = new ArrayList<Relationships>();
	}

	public String getClassName() {
		//Returns name of class
		return name;
	}

	public void setClassName(String newName) {
		//Sets class name to new name
		name = newName;
	}

	public ArrayList<Fields> getField() {
		return field;
	}

	public ArrayList<Methods> getMethod() {
		return method;
	}

	public ArrayList<Relationships> getRels() {
		return rels;
	}

	public static ArrayList<UML> getCollection() {
		return collection;
	}

	public static void setCollection(ArrayList<UML> newCollection){
		collection = newCollection;
	}

	public static void clearCollection(){
		collection.clear();
	}

	public static HashSet<String> getNoClassDupes() {
		return noClassDupes;
	}

	public static HashSet<String> getNoFieldDupes() {
		return noFieldDupes;
	}

	public static HashSet<String> getNoMethodDupes() {
		return noMethodDupes;
	}

	public static Pattern getPattern() {
		return pattern;
	}

	public static UML addClass(String className) {
		//If class doesn't exist and is alphanumeric
		if(!noClassDupes.contains(className) && !pattern.matcher(className).find()) {
			//Creates the class
			UML uml = new UML(className);
			noClassDupes.add(className);
			collection.add(uml);
			System.out.println("Class Created!");
			return uml;
		}
		//When the inputted name is not alphanumeric
		else if(pattern.matcher(className).find()) {
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
				if(uml.getClassName().equals(deleteName)) {
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
		if(noClassDupes.contains(oldName) && !noClassDupes.contains(newName) && !pattern.matcher(newName).find()) {
			//Iterates through the collection
			for(UML uml : collection) {
				//Renames old class when found
				if(uml.getClassName().equals(oldName)) {
					noClassDupes.remove(oldName);
					noClassDupes.add(newName);
					uml.setClassName(newName);
					System.out.println("Class Renamed!");
					return uml;
				}
			}
		}
		//When the new name is not alphanumeric
		else if(pattern.matcher(newName).find()) {
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

	//Will list all of UMLs fields.
	public void listFields() {
		System.out.println("Class: " + name);
		//Checks if there are any fields.
		if(field.isEmpty()) {
			System.out.println("This class has no fields");
		} 
		else {
			System.out.println("Fields:");
			//Prints all fields in arrayList "field"
			for(int i = 0; i < field.size(); i++) 
				System.out.println("name: " + field.get(i).getFieldName() + " type: " + field.get(i).getFieldType());
		}
	}

	//Will list all of UMLs methods.
	public void listMethods() {
		//Checks if there are any methods.
		if(method.isEmpty()) {
			System.out.println("This class has no methods");
		}
		else {
			System.out.println("Methods:");
			//Prints all methods in arrayList "method"
			for(Methods method : method) {
				System.out.println("name: " + method.getMethodName() + " return type: " + method.getMethodType());
				//Prints all parameters in arrayList "param"
				for(Parameters param : method.getParams()) {
					System.out.println("Parameters:\nname: " + param.getParamName() + " type: " + param.getParamType());
				}
			}
		}
	}

	//Will list all of UMLs relationships.
	public void listRelationships (){
		//Checks if there are any relationships.
		if (rels.isEmpty()) {
			System.out.println("Error:No relationships exist");
		} else {
			//Prints all relationships in arrayList "rels" for this UML object.
			for(int i = 0; i < rels.size(); i++) {
				System.out.print(rels.get(i).getSource() + " has a "); 
				System.out.print(rels.get(i).getType() + " relationship with ");
				System.out.println(rels.get(i).getDestination());
			}
		}
	}
}