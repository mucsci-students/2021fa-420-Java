import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;

public class Driver {
	public static boolean guiUp;

	/*
	 * Run command
	 */
	public static void main(String args[]) {
		runView();
	}

	public static void runView() {
		View.runGUI();
		guiUp = true;
	}

	public static void runCLI() {
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

				UML.addClass(className);

				break;

			case "deleteclass":
				System.out.println("What class would you like to remove?");
				//Class name to remove, ignores white space
				String deleteName = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				UML.deleteClass(deleteName);

				break;

			case "renameclass":
				System.out.println("What class would you like to rename?");
				//Class name to replace, ignores white space
				String oldName = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				System.out.println("What is the new name of the class?");
				//New class name, ignores white space
				String newName = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				UML.renameClass(oldName, newName);

				break;

			case "addfield":
				System.out.println("What class are you adding to?");
				String classNameAdd = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				boolean moreFields = true;
				while(moreFields) {
					System.out.println("What would you like to name the new field?");
					String fieldNameAdd = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

					System.out.println("What type do you want the new field to have?");
					String fieldTypeAdd = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

					Fields.addField(classNameAdd, fieldNameAdd, fieldTypeAdd);

					System.out.println("Would you like to add another field? (yes / no)");
					String answer = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

					boolean response = true;
					while(response) {
						if(!answer.equals("yes") && !answer.equals("no")) {
							System.out.println("Please respond with yes or no!");
							answer = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
						}
						else if(answer.equals("no")) {
							response = false;
							moreFields = false;
						}
						else {
							response = false;
						}
					}
				}

				break;

			case "deletefield":
				System.out.println("What class are you removing from?");
				String classNameRemove = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				boolean moreFieldsRemove = true;

				while(moreFieldsRemove) {
					System.out.println("What field are you removing?");
					String deletefield = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

					Fields.removeField(classNameRemove, deletefield);

					System.out.println("Would you like to remove another field? (yes / no)");
					String removeResponse = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

					boolean response = true;
					while(response) {
						if(!removeResponse.equals("yes") && !removeResponse.equals("no")) {
							System.out.println("Please respond with yes or no!");
							removeResponse = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
						}
						else if(removeResponse.equals("no")) {
							response = false;
							moreFieldsRemove = false;
						}
						else {
							response = false;
						}
					}
				}

				break;

			case "renamefield":
				System.out.println("What class are you making modifications in?");
				String classNameRename = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				System.out.println("What field are you renaming?");
				String oldField = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				System.out.println("What would you like to rename the field to?");
				String newField = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				Fields.renameField(classNameRename, oldField, newField);

				break;

			case "addmethod":
				System.out.println("What class are you adding to?");
				String methodClassNameAdd = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				System.out.println("What would you like to name the new method?");
				String methodNameAdd = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				System.out.println("What return type do you want the new method to have?");
				String methodTypeAdd = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				Methods.addMethod(methodClassNameAdd, methodNameAdd, methodTypeAdd);

				break;

			case "deletemethod":
				System.out.println("What class are you removing from?");
				String methodClassNameRemove = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				System.out.println("What method are you removing?");
				String deleteMethod = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				Methods.removeMethod(methodClassNameRemove, deleteMethod);

				break;

			case "deleteallmethods":
				System.out.println("What class are you removing from?");
				String methodsClassNameRemove = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				Methods.removeAllMethods(methodsClassNameRemove);

				break;

			case "renamemethod":
				System.out.println("What class are you making modifications in?");
				String methodClassNameRename = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				System.out.println("What method are you renaming?");
				String oldMethod = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				System.out.println("What would you like to rename the method to?");
				String newMethod = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				Methods.renameMethod(methodClassNameRename, oldMethod, newMethod);

				break;

			case "addrelation":
				System.out.println("What class would you like to be the source of the relation?");
				String cName = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				System.out.println("What is the destination of the relation?");
				String relDest = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				System.out.println("What is the type of the relation? Type must be aggregation, composition, inheritance, or realization.");
				String relType = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				if(UML.getNoClassDupes().contains(cName)) {
					if(UML.getNoClassDupes().contains(relDest)) {
						for(UML umlDest : UML.getCollection()) {
							if(umlDest.getClassName().equals(relDest)) {
								for(UML umlSrc : UML.getCollection()) {
									if(umlSrc.getClassName().equals(cName)) {
										Relationships.addRel(umlSrc, umlDest, relType);
										break;
									}
								}
							}
						}
					}
					else {
						System.out.println("Destination class does not exist!");
					}
				}
				else {
					System.out.println("Source class does not exist!");
				}

				break;

			case "deleterelation":
				System.out.println("What class would you like to delete a relation from?");
				String clName = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				System.out.println("What is the destination of the relation");
				String relDestination = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
				
				Relationships.delRel(clName, relDestination);

				break;

			case "changerelationshiptype":
				System.out.println("What is the source class of the relationship you would like to change?");
				String changeRelSource = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				System.out.println("What is the destination class of the relationship you would like to change?");
				String changeRelDest = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				System.out.println("What would you like to change the type to?");
				String newType = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				Relationships.changeRel(changeRelSource, changeRelDest, newType);

				break;

			case "listclasses":
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
				break;

			case "listcontents":
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
				break;

			case "listrelationships":
				System.out.println("What class would you like to list the relationships of?");
				//Scanner input (name of UML object)
				String toListRelationships = scanner.nextLine().toLowerCase().replaceAll("\\s","");

				if(UML.getNoClassDupes().contains(toListRelationships)) {
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
				break;

			case "help":
				System.out.println("add class - creates a new unique class * the name must be alphanumeric and not already exist."
						+ "\ndelete class - deletes a preexisting class * the class must already exist to delete it."
						+ "\nrename class - takes a class and provides a new name * the name must not already exist as another class and it's new name must be alphanumeric."
						+ "\nadd method - creates a new method for a class"
						+ "\ndelete method - deletes a method from a class"
						+ "\ndelete all methods - Deletes all methods in a given UML Class."
						+ "\nrename method - renames a method in a class"
						+ "\nadd field - creates a new field for a class"
						+ "\ndelete field - deletes a field from a class"
						+ "\nrename field - renames a field from a class"
						+ "\nadd parameter - creates a parameter in a method for a class"
						+ "\ndelete parameter - deletes a parameter from a method in a class"
						+ "\ndelete all parameters - deletes all the paramaters in a given method"
						+ "\nchange parameter - changes a parameter in a method in a class"
						+ "\nchange all parameters - changes all the parameters in a method."
						+ "\nadd relation - creates a relationship between two classes"
						+ "\ndelete relation - deletes a relationship between two classes"
						+ "\nchange relationship type - changes a relationship type"
						+ "\nlist classes - lists all the classes made"
						+ "\nlist contents - lists the contents of a specific class"
						+ "\nlist relationships - lists relationships between all classes"
						+ "\nsave - saves current uml file"
						+ "\nload - loads a uml file"
						+ "\nhelp - provides a list of commands usable commands."
						+ "\nexit - exists the program."
						+ "\nGUI - opens the GUI.");

				break;

			case "exit":
				System.out.println("Exiting the application.");
				run = false;
				scanner.close();
				break;

			case "save":
				ArrayList<UML> collection = UML.getCollection();
				String saveFile = JsonFile.save(collection);
				System.out.println("File saved!");
				System.out.println(saveFile);
				break;

			case "load":
				System.out.println("Any unsaved changes will be deleted. Do you wish to proceed? (Yes or No)");
				String confirm = scanner.nextLine().toLowerCase().replaceAll("\\s","");

				//Safeguard so the user doesn't accidentally delete files
				if(confirm.equals("yes")) {
					System.out.println("Enter the file you would like to load");
					String loadFile = scanner.nextLine().toLowerCase().replaceAll("\\s","");

					if(JsonFile.load(loadFile, UML.getCollection())){
					System.out.println("File loaded!");
					}
				}

				break;

				case "addparameter":
				// Check if the user wants to keep adding parameters 
				boolean continueAddingParams = true;
				
				// Gets UML name and Method name
				System.out.println("What class would you like to add a parameter to?");
				String UMLName = scanner.nextLine().toLowerCase();
				System.out.println("What method would you like to add a parameter to?");
				String methodName = scanner.nextLine().toLowerCase();

				// Param list init
				
				// If the user wants to add multiple parameters
				while(continueAddingParams){
					
				System.out.println("What is the parameter name!");
				String paramName = scanner.nextLine().toLowerCase();

				System.out.println("What is the parameter type!");

				String paramType = scanner.nextLine().toLowerCase();
				
				if(Parameters.addParameter(UMLName, methodName, paramName, paramType)){
				
				System.out.println("Would you like to continue adding parameters to "+methodName+"? (Y or N)");
				String response = scanner.nextLine().toLowerCase();
				if (!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("yes")){
					continueAddingParams = false;
					}
				} else{
					break;
				}
				// If the user wants to stop adding parameters
				

				}

				break;

			case "deleteparameter":
				boolean continueDelete = true;
				// Gets the UML name, method name, and parameter name to delete
				System.out.println("What class would you like to remove the parameter from?");
				String UMLName1 = scanner.nextLine().toLowerCase();
				System.out.println("What method would you like to remove the parameter from?");
				String methodName1 = scanner.nextLine().toLowerCase();

				while(continueDelete){
				System.out.println("What is the parameter name!");
				String paramName1 = scanner.nextLine().toLowerCase();

				// Deletion
				if(Parameters.deleteParameter(UMLName1, methodName1, paramName1)){
					System.out.println("Would you like to continue deleting parameters in "+methodName1+"? (Yes or No)");
					String response = scanner.nextLine().toLowerCase();

				// If the user wants to stop adding parameters
				if (!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("yes")){
					continueDelete = false;
				}
			} else {
				break;
			}
				
				}
				break;

			case "deleteallparameters":
				// Gets the UML name and method name to clear the paramater arraylist
				System.out.println("What class would you like to remove the parameters from?");
				String UMLName2 = scanner.nextLine().toLowerCase();
				System.out.println("What method would you like to remove the parameters from?");
				String methodName2 = scanner.nextLine().toLowerCase();

				// Deletion
				Parameters.deleteAllParameters(UMLName2, methodName2);
				
				
				break;

			case "changeallparameters":
				// Gets the parameter list to modify
				System.out.println("What class would you like to rename parameters in?");
				String UMLName3 = scanner.nextLine().toLowerCase();

				System.out.println("What method would you like to rename parameters in?");
				String methodName3 = scanner.nextLine().toLowerCase();
				HashSet<String> Dupes = new HashSet<>();

				ArrayList<Parameters> pList = Parameters.findMethod(UMLName3, methodName3);

				if (pList.isEmpty()){
					System.out.println("There are no parameters are in " + methodName3);
					break;
				}

				int count = 0;
				if (pList != null){
				for(Parameters p : pList){
					System.out.println("Here is the parameter being changed:");
					System.out.println("Name: "+ p.getParamName() +" Type: " + p.getParamType());

					System.out.println("What is the new name?");
					String pName = scanner.nextLine().toLowerCase().replaceAll("\\s","");

					if(!Dupes.contains(pName)){
					Dupes.add(pName);

					System.out.println("What is the parameter type?");
					String pType = scanner.nextLine().toLowerCase().replaceAll("\\s","");
					
					pList.set(count, new Parameters(pName, pType));
					++count;
					} else {
						System.out.println(pName+" already exists in " + methodName3);
					}
				}
			}
				break;

			case "changeparameter":
				boolean continueChanging = true;

				
				// Gets the UML name and method name to find the parameter list 
				System.out.println("What class would you like to change a parameter in?");
				String UMLName4 = scanner.nextLine().toLowerCase();
				System.out.println("What method would you like to change a parameter in?");
				String methodName4 = scanner.nextLine().toLowerCase();

				// If the user wants to continue renaming
				while(continueChanging){
				// Gets the old parameter name in order to find the parameter
				System.out.println("What is the old Parameter name!");
				String oldParamName = scanner.nextLine().toLowerCase();

				//Gets the new parameter credentials
				System.out.println("What is the new parameter's name?");
				String paramName5 = scanner.nextLine().toLowerCase();
				System.out.println("What is the parameter type!");
				String paramType5 = scanner.nextLine().toLowerCase();

				// Changes parameter if it doesn't already exist
				if(Parameters.changeParameter(UMLName4, methodName4, oldParamName, paramName5, paramType5)){

				System.out.println("Would you like to continue renaming parameters in "+methodName4+"? (Yes or No)");
				String response = scanner.nextLine().toLowerCase();

				// If the user wants to stop renaming parameters
					if (!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("yes")){
						continueChanging = false;
						}
					} else { 
						break;
					}
				}
				break;

			case "gui":
				guiUp = true;
				View.runGUI();
				run = false;
				break;

			default:
				System.out.println("Command not recognized. Type help for valid commands");
			}	
		}
	}
}
