import java.util.Scanner;

public class Driver {
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
					String response = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
					if (response.equals("no")) {
						moreFields = false;
					}
				}

				break;

			case "deletefield":
				System.out.println("What class are you removing from?");
				String classNameRemove = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				System.out.println("What field are you removing?");
				String deleteField = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				Fields.removeField(classNameRemove, deleteField);

				break;

			case "deleteallfields":
				Fields.removeAllFields();

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
				for(UML umlDest : UML.getCollection()) {
					if(umlDest.getClassName().toLowerCase().equals(relDest)) {
						for(UML umlSrc : UML.getCollection()) {
							if(umlSrc.getClassName().toLowerCase().equals(cName)) {
								Relationships.addRel(umlSrc,umlDest,relType);
								break;
							}
						}
					}
				}

				break;

			case "deleterelation":
				System.out.println("What class would you like to delete a relation from?");

				String clName = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				System.out.println("What is the destination of the relation");

				String relDestination = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
				for(UML u : UML.getCollection()){
					if( u.getClassName().toLowerCase().equals(relDestination)){
						Relationships.delRel(clName,u);

						break;
					}
				}

				break;
				
			case "changerelationshiptype":
				System.out.println("What is the source class of the relationship you would like to change?");
				String changeRelSource = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				System.out.println("What is the destination class of the relationship you would like to change?");
				String changeRelDest = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				System.out.println("What would you like to change the type to?");
				String newType = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
				
				for(UML umlSrc : UML.getCollection()) {
					if(umlSrc.getClassName().toLowerCase().equals(changeRelSource)) {
						for(Relationships umlRel : umlSrc.getRels()) {
							if(umlRel.getDestination().getClassName().toLowerCase().equals(changeRelDest)) {
								umlRel.setType(newType);
								System.out.println("Type changed to " + newType);
								break;
							}
						}
					}
				}
				

				break;

			case "listclasses":
				// Checks to see if collection contains any classes
				if (UML.getCollection().isEmpty()) {
					System.out.println("Error:No classes exist");
				} else {
					//Prints all classes in arrayList "collection"
					for(int i = 0; i < UML.getCollection().size(); i++)
						System.out.println(UML.getCollection().get(i).getClassName());
				}
				

			case "listcontents":
				System.out.println("What class would you like to list the contents of?");
				//Scanner input (name of UML object)
				String toListContents = scanner.nextLine().toLowerCase().replaceAll("\\s","");
				if (UML.getNoClassDupes().contains(toListContents)){
					for (UML uml : UML.getCollection()) {
						if (uml.getClassName().equals(toListContents)) {
							uml.listFields();
							uml.listMethods();
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
				if (UML.getNoClassDupes().contains(toListRelationships)){
					for (UML uml : UML.getCollection()) {
						if (uml.getClassName().equals(toListRelationships)) {
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
					UML.load(loadFile);
					System.out.println("File loaded!");
				}

				break;

			case "addparameter":
				System.out.println("What class would you like to add a parameter to?");
				String UMLName = scanner.nextLine().toLowerCase();
				System.out.println("What method would you like to add a parameter to?");
				String methodName = scanner.nextLine().toLowerCase();
				System.out.println("What is the Parameter name!");
				String paramName = scanner.nextLine().toLowerCase();
				System.out.println("What is the parameter type!");
				String paramType = scanner.nextLine().toLowerCase();
				System.out.println("File loaded!");
				Parameters.addParameter(UMLName, methodName, paramName,  paramType);
				System.out.println("Parameter Created!");
				break;

			case "deleteparameter":
				System.out.println("What class would you like to add a parameter to?");
				String UMLName1 = scanner.nextLine().toLowerCase();
				System.out.println("What method would you like to add a parameter to?");
				String methodName1 = scanner.nextLine().toLowerCase();
				System.out.println("What is the Parameter name!");
				String paramName1 = scanner.nextLine().toLowerCase();
				System.out.println("What is the parameter type!");
				String paramType1 = scanner.nextLine().toLowerCase();
				System.out.println("File loaded!");
				deleteParameter(UMLName1, methodName1, paramName1,  paramType1);
				break;

			case "deleteallparameters":
				System.out.println("What class would you like to add a parameter to?");
				String UMLName2 = scanner.nextLine().toLowerCase();
				System.out.println("What method would you like to add a parameter to?");
				String methodName2 = scanner.nextLine().toLowerCase();

				deleteAllParameters(UMLName2, methodName2);
				break;

			case "changeallparameters":
				System.out.println("What class would you like to add a parameter to?");
				String UMLName3 = scanner.nextLine().toLowerCase();
				System.out.println("What method would you like to add a parameter to?");
				String methodName3 = scanner.nextLine().toLowerCase();

				changeAllParameters(UMLName3, methodName3);
				break;

			case "changeparameter":
				System.out.println("What class would you like to add a parameter to?");
				String UMLName4 = scanner.nextLine().toLowerCase();
				System.out.println("What method would you like to add a parameter to?");
				String methodName4 = scanner.nextLine().toLowerCase();

				changeParameter(UMLName4, methodName4);
				break;

			case "listParameters":
				System.out.println("What class would you like to add a parameter to?");
				String UMLName5 = scanner.nextLine().toLowerCase();
				System.out.println("What method would you like to add a parameter to?");
				String methodName5 = scanner.nextLine().toLowerCase();

				listParameters(UMLName5, methodName5);
				break;

			default:
				System.out.println("Command not recognized. Type help for valid commands");
			}
		}
		scanner.close();
	}
}
