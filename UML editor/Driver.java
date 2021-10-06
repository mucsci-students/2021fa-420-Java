import java.util.Scanner;

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

				System.out.println("What would you like to name the new field?");
				String fieldNameAdd = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				System.out.println("What type do you want the new field to have?");
				String fieldTypeAdd = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				Fields addfield = new Fields(fieldNameAdd, fieldTypeAdd);

				Fields.addField(classNameAdd, addfield);

				break;

			case "deletefield":
				System.out.println("What class are you removing from?");
				String classNameRemove = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				System.out.println("What field are you removing?");
				String deleteField = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				Fields.removeField(classNameRemove, deleteField);

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
				System.out.println("What class would you like to add a relation to?");
				String cName = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				System.out.println("What is the destination of the relation");
				String relDest = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
				
				for(UML uml : UML.getCollection()) {
					if(uml.getClassName().toLowerCase().equals(relDest)) {
						UML.addRel(cName,uml);
						break;
					}
				}

				break;

			case "deleterelation":
				System.out.println("What class would you like to delete a relation from?");
				String clName = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

				System.out.println("What is the destination of the relation");
				String relDestination = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
				
				for(UML uml : UML.getCollection()){
					if( uml.getClassName().toLowerCase().equals(relDestination)){
						UML.delRel(clName, uml);
						break;
					}
				}

				break;

			case "listclasses":
				// Checks to see if collection contains any classes
				if (UML.getCollection().isEmpty()) {
					System.out.println("Error: No classes exist");
				}
				else {
					//Prints all classes in arrayList "collection"
					for(int i = 0; i < UML.getCollection().size(); i++) {
						System.out.println(UML.getCollection().get(i).getClassName());
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
					System.out.println("Error: class does not exist");
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
					System.out.println("Error: class does not exist");
				}
				break;

			case "help":
				System.out.println("add class - creates a new unique class * the name must be alphanumeric and not already exist."
						+ "\ndelete class - deletes a preexisting class * the class must already exist to delete it."
						+ "\nrename class - takes a class and provides a new name * the name must not already exist as another class and it's new name must be alphanumeric."
						+ "\nadd method - creates a new method for a class"
						+ "\ndelete method - deletes a method from a class"
						+ "\nrename method - renames a method in a class"
						+ "\nadd field - creates a new field for a class"
						+ "\ndelete field - deletes a field from a class"
						+ "\nrename field - renames a field from a class"
						+ "\nadd parameter - creates a parameter in a method for a class"
						+ "\ndelete parameter - deletes a parameter from a method in a class"
						+ "\nchange parameter - renames a parameter in a method in a class"
						+ "\nadd relation - creates a relationship between two classes"
						+ "\ndelete relation - deletes a relationship between two classes"
						+ "\nchange relationship type - changes a relationship type"
						+ "\nlist classes - lists all the classes made"
						+ "\nlist contents - lists the contents of a specific class"
						+ "\nlist relationships - lists relationships between all classes"
						+ "\nsave - saves current uml file"
						+ "\nload - loads a uml file"
						+ "\nhelp - provides a list of commands usable commands."
						+ "\nexit - exists the program.");
				break;

			case "exit":
				System.out.println("Exiting the application.");
				run = false;
				scanner.close();
				break;

			case "save":
				String saveFile = UML.save();
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
				
			case "gui":
				View.runGUI();
				guiUp = false;
				run = false;
				break;

			default:
				System.out.println("Command not recognized. Type help for valid commands");
			}	
		}
	}
}
