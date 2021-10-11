import java.util.*;
import java.util.regex.Pattern;

public class UML {
	//Class name
	private String name;
	//List containing all the fields in a UML object
	private ArrayList<Fields> fields;
	//List containing all the fields in a UML object
	private ArrayList<Methods> methods;
	//List containing all the relations between UML objects
	private ArrayList<Relationships> relationships;
	//This set is to make sure there are no classes with the same name.
	private static HashSet<String> noClassDupes = new HashSet<String>();
	//This is the Array list that should hold all the objects
	private static ArrayList<UML> collection = new ArrayList<UML>();
	//Regex for determining if string is alphanumeric
	private static Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");

	public UML(String name) {
		this.name = name;
		this.fields = new ArrayList<Fields>();
		this.methods = new ArrayList<Methods>();
		this.relationships = new ArrayList<Relationships>();
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
		return fields;
	}

	public ArrayList<Methods> getMethod() {
		return methods;
	}

	public ArrayList<Relationships> getRels() {
		return relationships;
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
			if(Driver.guiUp) {
				View.outputLbl.setText("Class Created!");
			}
			else {
				System.out.println("Class Created!");
			}
			return uml;
		}
		//When the inputted name is not alphanumeric
		else if(pattern.matcher(className).find()) {
			if(Driver.guiUp) {
				View.outputLbl.setText("A class name must only contain numbers and letters!");
			}
			else {
				System.out.println("A class name must only contain numbers and letters!");
			}
		}
		//When the class already exists
		else {
			if(Driver.guiUp) {
				View.outputLbl.setText("That class already exists!");
			}
			else {
				System.out.println("That class already exists!");
			}
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
					if(Driver.guiUp) {
						View.outputLbl.setText("Class Deleted!");
					}
					else {
						System.out.println("Class Deleted!");
					}
					return uml;
				}
			}
		}
		//When the class doesn't exist
		else {
			if(Driver.guiUp) {
				View.outputLbl.setText("That class does not exist!");
			}
			else {
				System.out.println("That class does not exist!");
			}
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
					if(Driver.guiUp) {
						View.outputLbl.setText("Class Renamed!");
					}
					else {
						System.out.println("Class Renamed!");
					}
					return uml;
				}
			}
		}
		//When the new name is not alphanumeric
		else if(pattern.matcher(newName).find()) {
			if(Driver.guiUp) {
				View.outputLbl.setText("A class name must only contain numbers and letters");
			}
			else {
				System.out.println("A class name must only contain numbers and letters");
			}
		}
		//When the new class already exists
		else if(noClassDupes.contains(newName)) {
			if(Driver.guiUp) {
				View.outputLbl.setText("That class already exists!");
			}
			else {
				System.out.println("That class already exists!");
			}
		}
		//When the old class doesn't exist
		else {
			if(Driver.guiUp) {
				View.outputLbl.setText("That class does not exist!");
			}
			else {
				System.out.println("That class does not exist!");
			}
		}
		return null;
	}

	//Will list all of UMLs fields.
	public void listFields() {
		if(Driver.guiUp) {
			View.outputText = "<html>Class: " + name;
		}
		else {
			System.out.println("Class: " + name);
		}
		//Checks if there are any fields.
		if(fields.isEmpty()) {
			if(Driver.guiUp) {
				View.outputText += "<br>This class has no fields";
			}
			else {
				System.out.println("This class has no fields");
			}
		}
		else {
			if(Driver.guiUp) {
				View.outputText += "<br>Fields:";
				//Prints all fields in arrayList "field"
				for(int i = 0; i < fields.size(); i++) {
					View.outputText += "<br>" + fields.get(i).getFieldType() + " " + fields.get(i).getFieldName();
				}
			}
			else {
				System.out.println("Fields:");
				//Prints all fields in arrayList "field"
				for(int i = 0; i < fields.size(); i++) {
					System.out.println(fields.get(i).getFieldType() + " " + fields.get(i).getFieldName());
				}
			}
		}
	}

	//Will list all of UMLs methods.
	public void listMethods() {
		//Checks if there are any methods.
		if(methods.isEmpty()) {
			if(Driver.guiUp) {
				View.outputText += "<br>This class has no methods";
			}
			else {
				System.out.println("This class has no methods");
			}
		}
		else {
			if(Driver.guiUp) {
				//Prints all methods in arrayList "method"
				View.outputText += "<br>Methods:";
				for(Methods method : methods) {
					View.outputText += "<br>" + method.getMethodType() + " " + method.getMethodName() + "(";
					//Prints all parameters in arrayList "param"
					if(method.getParams().size() >= 1) {
						View.outputText += method.getParams().get(0).getParamType() + " " + method.getParams().get(0).getParamName();
					}
					for(int i = 1; i < method.getParams().size(); i++) {
						View.outputText += ", " + method.getParams().get(i).getParamType() + " " + method.getParams().get(i).getParamName();
					}
					View.outputText += ")";
				}
			}
			else {
				//Prints all methods in arrayList "method"
				System.out.println("Methods:");
				for(Methods method : methods) {
					System.out.print(method.getMethodType() + " " + method.getMethodName() + "(");
					//Prints all parameters in arrayList "param"
					if(method.getParams().size() >= 1) {
						System.out.print(method.getParams().get(0).getParamType() + " " + method.getParams().get(0).getParamName());
					}
					for(int i = 1; i < method.getParams().size(); i++) {
						System.out.print(", " + method.getParams().get(i).getParamType() + " " + method.getParams().get(i).getParamName());
					}
					System.out.println(")");
				}
			}
		}
	}

	//Will list all of UMLs relationships.
	public void listRelationships() {
		//Checks if there are any relationships.
		if(relationships.isEmpty()) {
			if(Driver.guiUp) {
				View.outputText = ("No relationships exist!");
			}
			else {
				System.out.println("No relationships exist!");
			}
		}
		else {
			if(Driver.guiUp) {
				View.outputText = "<html>";
				//Prints all relationships in arrayList "rels" for this UML object.
				for(int i = 0; i < relationships.size(); i++) {
					View.outputText += relationships.get(i).getSource() + " has a " + relationships.get(i).getType() + " relationship with " + relationships.get(i).getDestination() + "<br>";
				}
			}
			else {
				//Prints all relationships in arrayList "rels" for this UML object.
				for(int i = 0; i < relationships.size(); i++) {
					System.out.print(relationships.get(i).getSource() + " has a "); 
					System.out.print(relationships.get(i).getType() + " relationship with ");
					System.out.println(relationships.get(i).getDestination());
				}
			}
		}
	}
}