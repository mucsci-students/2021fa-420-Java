import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class CLI {
	//Scanner for user input
	static Scanner scanner = new Scanner(System.in);
	public static boolean guiUp;

	// Adds a class to the UML
	public static void addClassCLI() {
		System.out.println("What would you like to name the new class?");
		//Class name to add, ignores white space
		String className = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
		UML.addClass(className);
	}

	// Deletes a class from the UML
	public static void deleteClassCLI() {
		System.out.println("What class would you like to remove?");
		//Class name to remove, ignores white space
		String deleteName = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
		UML.deleteClass(deleteName);
	}

	// Rename a class in the UML
	public static void renameClassCLI() {
		System.out.println("What class would you like to rename?");
		//Class name to replace, ignores white space
		String oldName = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
		System.out.println("What is the new name of the class?");
		//New class name, ignores white space
		String newName = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
		UML.renameClass(oldName, newName);
	}

	// Adds a field(s) to the UML
	public static void addFieldCLI() {
		System.out.println("What class are you adding to?");
		String classNameAdd = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
		//While the user wants more fields
		boolean moreFields = true;
		while(moreFields) {
			System.out.println("What would you like to name the new field?");
			String fieldNameAdd = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
			System.out.println("What type do you want the new field to have?");
			String fieldTypeAdd = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
			Fields.addField(classNameAdd, fieldNameAdd, fieldTypeAdd);
			System.out.println("Would you like to add another field? (yes / no)");
			String answer = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
			//While the user needs to input yes or no
			boolean response = true;
			while(response) {
				//Makes sure answer is yes or no
				if(!answer.equals("yes") && !answer.equals("no")) {
					System.out.println("Please respond with yes or no!");
					answer = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
				}
				//Stops if no
				else if(answer.equals("no")) {
					response = false;
					moreFields = false;
				}
				//Continues if yes
				else {
					response = false;
				}
			}
		}
	}

	// Delete a field(s) from the UML
	public static void deleteFieldCLI() {
		System.out.println("What class are you removing from?");
		String classNameRemove = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
		boolean moreFieldsRemove = true;
		while(moreFieldsRemove) {
			System.out.println("What field are you removing?");
			String deletefield = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
			Fields.removeField(classNameRemove, deletefield);
			System.out.println("Would you like to remove another field? (yes / no)");
			String removeResponse = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
			//While the user needs to input yes or no
			boolean response = true;
			while(response) {
				if(!removeResponse.equals("yes") && !removeResponse.equals("no")) {
					System.out.println("Please respond with yes or no!");
					removeResponse = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
				}
				//Stops if no
				else if(removeResponse.equals("no")) {
					response = false;
					moreFieldsRemove = false;
				}
				//Continues if yes
				else {
					response = false;
				}
			}
		}
	}

	// Rename a field in the UML
	public static void renameFieldCLI() {
		System.out.println("What class are you making modifications in?");
		String classNameRename = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
		System.out.println("What field are you renaming?");
		String oldField = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
		System.out.println("What would you like to rename the field to?");
		String newField = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
		Fields.renameField(classNameRename, oldField, newField);
	}

	// Add a method to the UML
	public static void addMethodCLI() {
		System.out.println("What class are you adding to?");
		String methodClassNameAdd = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
		System.out.println("What would you like to name the new method?");
		String methodNameAdd = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
		System.out.println("What return type do you want the new method to have?");
		String methodTypeAdd = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
		Methods.addMethod(methodClassNameAdd, methodNameAdd, methodTypeAdd);
	}

	// Delete a method from the UML
	public static void deleteMethodCLI() {
		System.out.println("What class are you removing from?");
		String methodClassNameRemove = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
		System.out.println("What method are you removing?");
		String deleteMethod = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
		Methods.removeMethod(methodClassNameRemove, deleteMethod);
	}

	// Delete all the methods from a given class in the UML
	public static void deleteAllMethodsCLI() {
		System.out.println("What class are you removing from?");
		String methodsClassNameRemove = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
		Methods.removeAllMethods(methodsClassNameRemove);
	}

	// Rename a method in the UML
	public static void renameMethodCLI() {
		System.out.println("What class are you making modifications in?");
		String methodClassNameRename = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
		System.out.println("What method are you renaming?");
		String oldMethod = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
		System.out.println("What would you like to rename the method to?");
		String newMethod = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
		Methods.renameMethod(methodClassNameRename, oldMethod, newMethod);
	}

	// Add a parameter to a method within the UML
	public static void addParameterCLI() {
		System.out.println("What class would you like to add a parameter to?");
		String UMLName = scanner.nextLine().toLowerCase().replaceAll("\\s","");
		System.out.println("What method would you like to add a parameter to?");
		String methodName = scanner.nextLine().toLowerCase().replaceAll("\\s","");
		System.out.println("What is the parameter name?");
		String paramName = scanner.nextLine().toLowerCase().replaceAll("\\s","");
		System.out.println("What is the parameter type?");
		String paramType = scanner.nextLine().toLowerCase().replaceAll("\\s","");
		Parameters.addParameter(UMLName, methodName, paramName,  paramType);
	}

	// Delete a parameter(s) from a method within the UML
	public static void deleteParameterCLI() {
		System.out.println("What class would you like to remove the parameter from?");
		String UMLName1 = scanner.nextLine().toLowerCase().replaceAll("\\s","");
		System.out.println("What method would you like to remove the parameter from?");
		String methodName1 = scanner.nextLine().toLowerCase().replaceAll("\\s","");
		boolean continueDelete = true;
		while(continueDelete){
			System.out.println("What is the parameter name?");
			String paramName1 = scanner.nextLine().toLowerCase().replaceAll("\\s","");
			// Deletion
			if(Parameters.deleteParameter(UMLName1, methodName1, paramName1)) {
				System.out.println("Would you like to continue deleting parameters in " + methodName1 + "? (Yes or No)");
				String response = scanner.nextLine().toLowerCase().replaceAll("\\s","");
				// If the user wants to stop adding parameters
				if(!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("yes")) {
					continueDelete = false;
				}
			}
			else {
				break;
			}
		}
	}

	// Delete all parameters from a given method within the UML
	public static void deleteAllParametersCLI() {
		System.out.println("What class would you like to remove the parameters from?");
		String UMLName2 = scanner.nextLine().toLowerCase().replaceAll("\\s","");
		System.out.println("What method would you like to remove the parameters from?");
		String methodName2 = scanner.nextLine().toLowerCase().replaceAll("\\s","");
		Parameters.deleteAllParameters(UMLName2, methodName2);
	}

	// Changes the parameter name from a given method within the UML
	public static void changeParameterCLI() {
		System.out.println("What class would you like to change a parameter in?");
		String UMLName4 = scanner.nextLine().toLowerCase().replaceAll("\\s","");
		System.out.println("What method would you like to change a parameter in?");
		String methodName4 = scanner.nextLine().toLowerCase().replaceAll("\\s","");
		System.out.println("What is the old parameter name?");
		String oldParamName = scanner.nextLine().toLowerCase().replaceAll("\\s","");
		System.out.println("What is the new parameter name?");
		String paramName5 = scanner.nextLine().toLowerCase().replaceAll("\\s","");
		System.out.println("What is the parameter type?");
		String paramType5 = scanner.nextLine().toLowerCase().replaceAll("\\s","");
		Parameters.changeParameter(UMLName4, methodName4, oldParamName, paramName5, paramType5);
	}

	// Changes all the parameter names from a given method within the UML
	public static void changeAllParametersCLI() {
		// Gets the parameter list to modify
		System.out.println("What class would you like to rename parameters in?");
		String UMLName3 = scanner.nextLine().toLowerCase();
		System.out.println("What method would you like to rename parameters in?");
		String methodName3 = scanner.nextLine().toLowerCase();
		HashSet<String> Dupes = new HashSet<String>();
		ArrayList<Parameters> pList = Parameters.findMethod(UMLName3, methodName3);
		//Makes sure there are parameters
		if(pList != null) {
			if(!pList.isEmpty()) {
				//Loops through all parameters
				for(int i = 0 ; i <= pList.size() - 1; i++) {
					System.out.println("Here is the parameter being changed:");
					System.out.println(pList.get(i).getParamType() + " " + pList.get(i).getParamName());
					System.out.println("What is the new name?");
					String pName = scanner.nextLine().toLowerCase().replaceAll("\\s","");
					//Makes sure no duplicates while renaming
					if(!Dupes.contains(pName)){
						Dupes.add(pName);
						System.out.println("What is the parameter type?");
						String pType = scanner.nextLine().toLowerCase().replaceAll("\\s","");
						pList.set(i, new Parameters(pName, pType));
					}
					else {
						System.out.println(pName + " already exists in " + methodName3);
					}
				}
			}
			else {
				System.out.println("There are no parameters to change!");
			}
		}
	}

	// Add a relationship between two classes in the UML
	public static void addRelationshipCLI() {
		System.out.println("What class would you like to be the source of the relation?");
		String cName = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
		System.out.println("What is the destination of the relation?");
		String relDest = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
		System.out.println("What is the type of the relation? Type must be aggregation, composition, inheritance, or realization.");
		String relType = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
		//Checks if source exists
		if(UML.getNoClassDupes().contains(cName)) {
			//Checks if destination exists
			if(UML.getNoClassDupes().contains(relDest)) {
				//Searches for destination
				for(UML umlDest : UML.getCollection()) {
					if(umlDest.getClassName().equals(relDest)) {
						//Searches for source
						for(UML umlSrc : UML.getCollection()) {
							if(umlSrc.getClassName().equals(cName)) {
								Relationships.addRel(umlSrc, umlDest, relType);
								break;
							}
						}
					}
				}
			}
			//Destination class does not exist
			else {
				if(Driver.guiUp) {
					View.outputLbl.setText("Destination class does not exist!");
				}
				else {
					System.out.println("Destination class does not exist!");
				}
			}
		}
		//Source class does not exist
		else {
			if(Driver.guiUp) {
				View.outputLbl.setText("Source class does not exist!");
			}
			else {
				System.out.println("Source class does not exist!");
			}
		}
	}

	// Deletes a relationship between two classes in the UML
	public static void deleteRelationshipCLI() {
		System.out.println("What class would you like to delete a relation from?");
		String clName = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
		System.out.println("What is the destination of the relation");
		String relDestination = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
		Relationships.delRel(clName, relDestination);
	}

	// Changes the relationship between two classes in the UML
	public static void changeRelationshipTypeCLI() {
		System.out.println("What is the source class of the relationship you would like to change?");
		String changeRelSource = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
		System.out.println("What is the destination class of the relationship you would like to change?");
		String changeRelDest = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
		System.out.println("What would you like to change the type to?");
		String newType = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
		Relationships.changeRel(changeRelSource, changeRelDest, newType);
	}

	// Lists all the classes in the UML
	public static void listClassesCLI() {
		if(!guiUp) {
			// Checks to see if collection contains any classes
			if (UML.getCollection().isEmpty()) {
				System.out.println("No classes exist!");
			}
			else {
				//Prints all classes in arrayList "collection"
				for(int i = 0; i < UML.getCollection().size(); i++) {
					System.out.println(UML.getCollection().get(i).getClassName());
				}
			}
		}
	}

	// Lists all the fields, methods, and parameters from a given class in the UML
	public static void listContentsCLI() {
		System.out.println("What class would you like to list the contents of?");
		//Scanner input (name of UML object)
		String toListContents = scanner.nextLine().toLowerCase().replaceAll("\\s","");
		if(UML.getNoClassDupes().contains(toListContents)) {
			for(UML uml : UML.getCollection()) {
				if(uml.getClassName().equals(toListContents)) {
					uml.listFields();
					uml.listMethods();
					break;
				}
			}
		}
		else {
			System.out.println("Class does not exist!");
		}
	}

	// Lists all the relationships a given class has within the UML
	public static void listRelationshipsCLI() {
		System.out.println("What class would you like to list the relationships of?");
		//Scanner input (name of UML object)
		String toListRelationships = scanner.nextLine().toLowerCase().replaceAll("\\s","");
		//Checks if class exists
		if(UML.getNoClassDupes().contains(toListRelationships)) {
			//Searches for class
			for(UML uml : UML.getCollection()) {
				if(uml.getClassName().equals(toListRelationships)) {
					uml.listRelationships();
					break;
				}
			}
		}
		else {
			System.out.println("Class does not exist!");
		}
	}
}
