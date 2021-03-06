package uml;

import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class UML {
	// Class name
	private String name;
	// List containing all the fields in a UML object
	private ArrayList<Fields> fields;
	// List containing all the fields in a UML object
	private ArrayList<Methods> methods;
	// List containing all the relations between UML objects
	private ArrayList<Relationships> relationships;
	// X position of class box
	private int position_x;
	// Y position of class box
	private int position_y;

	//this is for testing purposes only
	public static boolean test = true;

	// This set is to make sure there are no classes with the same name.
	// This is the Array list that keeps tracks of the relationship arrows
	private static ArrayList<Arrows> arrows = new ArrayList<Arrows>();

	// Regex for determining if string is alphanumeric
	private static Pattern pattern = Pattern.compile("[^a-zA-Z0-9_]");

	public UML(String name, int position_x, int position_y) {
		this.name = name;
		this.fields = new ArrayList<Fields>();
		this.methods = new ArrayList<Methods>();
		this.relationships = new ArrayList<Relationships>();
		this.position_x = position_x;
		this.position_y = position_y;
	}

	public String getClassName() {
		// Returns name of class
		return name;
	}

	public void setClassName(String newName) {
		// Sets class name to new name
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

	public int getposition_x() {
		return position_x;
	}

	public void setposition_x(int x) {
		position_x = x;
	}

	public int getposition_y() {
		return position_y;
	}

	public void setposition_y(int y) {
		position_y = y;
	}

	public static void setCoords(UML u, int x, int y){
		u.setposition_x(x);
		u.setposition_y(y);
		undoredo.stateKeeper();
	}

	public static ArrayList<Arrows> getArrows() {
		return arrows;
	}

	public static Pattern getPattern() {
		return pattern;
	}

	public static UML addClass(String className) {
		// If class doesn't exist and is alphanumeric
		if (!Model.getNoClassDupes().contains(className) && !pattern.matcher(className).find()) {
			// Creates the class
			UML uml = new UML(className, 0, 0);
			Model.getNoClassDupes().add(className);
			Model.getCollection().add(uml);
			undoredo.stateKeeper();
			if (!Driver.guiUp) {
				System.out.println("Class Created!");
			}
			return uml;
		}
		// When the inputted name is not alphanumeric
		else if (pattern.matcher(className).find()) {
			Driver.throwingError("A class name must only contain numbers and letters!");
		}
		// When the class already exists
		else {
			Driver.throwingError("That class already exists!");
		}
		return null;
	}

	public static UML deleteClass(String deleteName) {
		// Check if the class exists
		if (Model.getNoClassDupes().contains(deleteName)) {
			// Iterates through the collection
			for (UML uml : Model.getCollection()) {
				// Deletes class when found
				if (uml.getClassName().equals(deleteName)) {
					Model.getNoClassDupes().remove(deleteName);
					Model.getCollection().remove(Model.getCollection().indexOf(uml));

					BoxObject.delete(uml.getClassName());
					if (!StartUp.CLIstart && test ){
						View.panel.repaint();
					}

					if (!Driver.guiUp) {
						System.out.println("Class Deleted!");
					}
					undoredo.stateKeeper();
					return uml;
				}
			}
		}
		// When the class doesn't exist
		else {
			Driver.throwingError("That class does not exist!");
		}
		return null;
	}

	public static UML renameClass(String oldName, String newName) {
		// Check if the old class exists and new name is alphanumeric
		if (Model.getNoClassDupes().contains(oldName) && !Model.getNoClassDupes().contains(newName)
				&& !pattern.matcher(newName).find()) {
			// Iterates through the collection
			for (UML uml : Model.getCollection()) {
				// Renames old class when found
				if (uml.getClassName().equals(oldName)) {
					Model.getNoClassDupes().remove(oldName);
					Model.getNoClassDupes().add(newName);
					uml.setClassName(newName);
					undoredo.stateKeeper();

					BoxObject.find(oldName, newName);

					if (!Driver.guiUp) {
						System.out.println("Class Renamed!");
					}
					return uml;
				}
			}
		}
		// When the new name is not alphanumeric
		else if (pattern.matcher(newName).find()) {
			Driver.throwingError("A class name must only contain numbers and letters");
		}
		// When the new class already exists
		else if (Model.getNoClassDupes().contains(newName)) {
			Driver.throwingError("That class already exists!");
		}
		// When the old class doesn't exist
		else {
			Driver.throwingError("That class does not exist!");
		}
		return null;
	}

	// Will list all of UMLs fields.
	public boolean listFields() {

		System.out.println("Class: " + name);
		// Checks if there are any fields.
		if (fields.isEmpty()) {

			System.out.println("This class has no fields");
		} else {
			System.out.println("Fields:");
			// Prints all fields in arrayList "field"
			for (int i = 0; i < fields.size(); i++) {
				System.out.println(fields.get(i).getFieldType() + " " + fields.get(i).getFieldName());
			}
		}

		return true;
	}

	// Will list all of UMLs methods.
	public boolean listMethods() {
		// Checks if there are any methods.
		if (methods.isEmpty()) {
			Driver.throwingError("This class has no methods");
		} else {

			// Prints all methods in arrayList "method"
			System.out.println("Methods:");
			for (Methods method : methods) {
				System.out.print(method.getMethodType() + " " + method.getMethodName() + "(");
				// Prints all parameters in arrayList "param"
				if (method.getParams().size() >= 1) {
					System.out.print(method.getParams().get(0).getParamType() + " "
							+ method.getParams().get(0).getParamName());
				}
				for (int i = 1; i < method.getParams().size(); i++) {
					System.out.print(", " + method.getParams().get(i).getParamType() + " "
							+ method.getParams().get(i).getParamName());
				}
				System.out.println(")");
			}
		}
		return true;
	}

	// Will list all of UMLs relationships.
	public boolean listRelationships() {
		// Checks if there are any relationships.
		if (relationships.isEmpty()) {
			Driver.throwingError("No relationships exist!");
		} else {

			// Prints all relationships in arrayList "rels" for this UML object.
			helper();
		}
		return true;
	}

	public static UML findUMLOBJ(String name) {
		UML foundUML = null;

		// Finds the UML object if it exists
		for (UML u : Model.getCollection()) {
			if (name.equals(u.getClassName())) {
				foundUML = u;
				break;
			}
		}
		// If the UML object exists, this traverses the methods of the UML object and
		// returns the Parameter list of the correct method
		if (foundUML != null) {
			return foundUML;
		}
		return null;
	}

	// public static UML findClass(String name) {
	// 	for (UML uml : Model.getCollection()) {
	// 		if (uml.getClassName().equals(name)) {
	// 			return uml;
	// 		}
	// 	}
	// 	return null;
	// }
	public void helper() {
		for (int i = 0; i < relationships.size(); i++) {
			System.out.print(relationships.get(i).getSource() + " has a ");
			System.out.print(relationships.get(i).getType() + " relationship with ");
			System.out.println(relationships.get(i).getDestination());
		}
	}
}