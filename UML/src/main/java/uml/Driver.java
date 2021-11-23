package uml;

import java.util.Scanner;

import org.jline.terminal.TerminalBuilder;
import org.jline.terminal.*;
import org.jline.reader.*;
import org.jline.reader.impl.completer.AggregateCompleter;
import java.util.ArrayList;
import javax.swing.UIManager;

public class Driver {
	// Scanner for user input
	static Scanner scanner = new Scanner(System.in);

	public static boolean guiUp;
	private static ArrayList<String> parser;
	private static LineReader lineScan;
	
	/*
	 * Run command
	 */
	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		undoredo.stateKeeper();
		View.initializePanel();
		runView();
		try {
			Terminal terminal = TerminalBuilder.builder().system(true).build();
			AggregateCompleter completer = TabCompletion.compose();
			lineScan = LineReaderBuilder.builder().terminal(terminal).completer(completer).build();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Runs the GUI (view) for the UML
	public static void runView() {
		View.runGUI();
		guiUp = true;
	}

	public static void runCLI() {
		
		// Boolean to run program until user exits
		boolean run = true;
		

		
		boolean state = false;
		while (run) {
			System.out.println("Enter a command or type exit if you wish to exit!");
			// This is the command the user has entered
			// It is converted to lowercase to allow for easier comparison and ignores white
			// space
			
			
			String command = lineScan.readLine(">>> ").toLowerCase();
			String switchy = Commands.compare(command);
			String matcher = Commands.match(switchy);

			parser = Commands.parse(command);


			if ((state && !(matcher.equals("undo")) && !(matcher.equals("redo")) && !(matcher.equals("save")))) {
				undoredo.memClear();
			}

			state = false;

			int paramNums = 0;

			switch (matcher) {

			case "addclass":
				paramNums = 1;
				if (parser.size() != (paramNums + 1)){
					System.out.println("incorrect number of parameters");
					break;
				}
				String className = parser.get(1);
				UML uml = UML.addClass(className);
				BoxObject.createBox(uml);
				break;

			case "deleteclass":
				paramNums = 1;
				if (parser.size() != (paramNums + 1)){
					System.out.println("incorrect number of parameters");
					break;
				}
				String deleteName = parser.get(1);
				UML.deleteClass(deleteName);
				break;

			case "renameclass":
				paramNums = 2;
				if (parser.size() != (paramNums + 1)){
					System.out.println("incorrect number of parameters");
					break;
				}
				String oldName = parser.get(1);
				String newName = parser.get(2);
				UML.renameClass(oldName, newName);
				break;

			case "addfield":
				paramNums = 3;
				if (parser.size() != (paramNums + 1)){
					System.out.println("incorrect number of parameters");
					break;
				}
				String classNameAdd = parser.get(1);
				String fieldNameAdd = parser.get(2);
				String fieldTypeAdd = parser.get(3);
				Fields.addField(classNameAdd, fieldNameAdd, fieldTypeAdd);
				break;

			case "deletefield":
				paramNums = 2;
				if (parser.size() != (paramNums + 1)){
					System.out.println("incorrect number of parameters");
					break;
				}
				String classNameRemove = parser.get(1);
				String deletefield = parser.get(2);
				Fields.removeField(classNameRemove, deletefield);
				break;

			case "renamefield":
				paramNums = 3;
				if (parser.size() != (paramNums + 1)){
					System.out.println("incorrect number of parameters");
					break;
				}
				String classNameRename = parser.get(1);
				String oldField = parser.get(2);
				String newField = parser.get(3);
				Fields.renameField(classNameRename, oldField, newField);
				break;

			case "addmethod":
				paramNums = 3;
				if (parser.size() != (paramNums + 1)){
					System.out.println("incorrect number of parameters");
					break;
				}
				String methodClassNameAdd = parser.get(1);
				String methodNameAdd = parser.get(2);
				String methodTypeAdd = parser.get(3);
				Methods.addMethod(methodClassNameAdd, methodNameAdd, methodTypeAdd);
				break;

			case "deletemethod":
				paramNums = 2;
				if (parser.size() != (paramNums + 1)){
					System.out.println("incorrect number of parameters");
					break;
				}
				String methodClassNameRemove = parser.get(1);
				String deleteMethod = parser.get(2);
				Methods.removeMethod(methodClassNameRemove, deleteMethod);
				break;

			case "deleteallmethods":
				paramNums = 1;
				if (parser.size() != (paramNums + 1)){
					System.out.println("incorrect number of parameters");
					break;
				}
				String methodsClassNameRemove = parser.get(1);
				Methods.removeAllMethods(methodsClassNameRemove);
				break;

			case "renamemethod":
				paramNums = 3;
				if (parser.size() != (paramNums + 1)){
					System.out.println("incorrect number of parameters");
					break;
				}
				String methodClassNameRename = parser.get(1);
				String oldMethod = parser.get(2);
				String newMethod = parser.get(3);
				Methods.renameMethod(methodClassNameRename, oldMethod, newMethod);
				break;

			case "addparameter":
				paramNums = 4;
				if (parser.size() != (paramNums + 1)){
					System.out.println("incorrect number of parameters");
					break;
				}
				String UMLName = parser.get(1);
				String methodName = parser.get(2);
				String paramName = parser.get(3);
				String paramType = parser.get(4);
				if(MethodOverloading.containsDuplicateMethods(UMLName).contains(methodName)){
					System.out.println("There is more than one method that uses the name " + methodName);
					System.out.println("Enter all the parameter types for the method you are editing");
					String s = lineScan.readLine(">>> ").toLowerCase();
					ArrayList<String> a = Commands.storeArray(s);
					Parameters.addParameterCLI(UMLName, methodName, paramName, paramType, null, true, a);
					break;
				}
				Parameters.addParameter(UMLName, methodName, paramName, paramType, null, true);
				break;

			case "deleteparameter":
				paramNums = 3;
				if (parser.size() != (paramNums + 1)){
					System.out.println("incorrect number of parameters");
					break;
				}
				String UMLName1 = parser.get(1);
				String methodName1 = parser.get(2);
				String paramName1 = parser.get(3);
				if(MethodOverloading.containsDuplicateMethods(UMLName1).contains(methodName1)){
					System.out.println("There is more than one method that uses the name " + methodName1);
					System.out.println("Enter all the parameter types for the method you are editing");
					String s = lineScan.readLine(">>> ").toLowerCase();
					ArrayList<String> a = Commands.storeArray(s);
					Parameters.deleteParameterCLI(UMLName1, methodName1, paramName1, null, true, a);
					break;
				}
				Parameters.deleteParameter(UMLName1, methodName1, paramName1, null, true);
				break;

			case "deleteallparameters":
				paramNums = 2;
				if (parser.size() != (paramNums + 1)){
					System.out.println("incorrect number of parameters");
					break;
				}
				String UMLName2 = parser.get(1);
				String methodName2 = parser.get(2);
				if(MethodOverloading.containsDuplicateMethods(UMLName2).contains(methodName2)){
					System.out.println("There is more than one method that uses the name " + methodName2);
					System.out.println("Enter all the parameter types for the method you are editing");
					String s = lineScan.readLine(">>> ").toLowerCase();
					ArrayList<String> a = Commands.storeArray(s);
					Parameters.deleteAllParametersCLI(UMLName2, methodName2, null, true, a);
					break;
				}
				Parameters.deleteAllParameters(UMLName2, methodName2, null, true);
				break;

			case "changeparameter":
			paramNums = 5;
			if (parser.size() != (paramNums + 1)){
					System.out.println("incorrect number of parameters");
					break;
				}
			String UMLName4 = parser.get(1);
			String methodName4 = parser.get(2);
			String oldParamName = parser.get(3);
			String paramName5 = parser.get(4);
			String paramType5 = parser.get(5);
			if(MethodOverloading.containsDuplicateMethods(UMLName4).contains(methodName4)){
				System.out.println("There is more than one method that uses the name " + methodName4);
				System.out.println("Enter all the parameter types for the method you are editing");
				String s = lineScan.readLine(">>> ").toLowerCase();
				ArrayList<String> a = Commands.storeArray(s);
				Parameters.changeParameterCLI(UMLName4, methodName4, oldParamName, paramName5, paramType5, null, true, a);
				break;
			}
			Parameters.changeParameter(UMLName4, methodName4, oldParamName, paramName5, paramType5, null, true);
				break;

			case "addrelation":
				paramNums = 3;
				if (parser.size() != (paramNums + 1)){
					System.out.println("incorrect number of parameters");
					break;
				}
				if(Model.getNoClassDupes().contains(parser.get(1)) && Model.getNoClassDupes().contains(parser.get(2))){
					Relationships.addRel(UML.findUMLOBJ(parser.get(1)), UML.findUMLOBJ(parser.get(2)), parser.get(3));
					break;
				}
				
				System.out.println("Source or destination does not exist");
				break;

			case "deleterelation":
				paramNums = 2;
				if (parser.size() != (paramNums + 1)){
					System.out.println("incorrect number of parameters");
					break;
				}
				Relationships.delRel(parser.get(1), parser.get(2));
				break;

			case "changerelationshiptype":
			paramNums = 3;
			if (parser.size() != (paramNums + 1)){
					System.out.println("incorrect number of parameters");
					break;
				}
			String changeRelSource = parser.get(1);
			String changeRelDest = parser.get(2);
			String newType = parser.get(3);
			Relationships.changeRel(changeRelSource, changeRelDest, newType);
				break;

			case "listclasses":
				paramNums = 0;
				if (parser.size() != (paramNums + 1)){
					System.out.println("incorrect number of parameters");
					break;
				}
				if (Model.getCollection().isEmpty()) {
					System.out.println("No classes exist!");
				} else {
					// Prints all classes in arrayList "collection"
					for (int i = 0; i < Model.getCollection().size(); i++) {
						System.out.println(Model.getCollection().get(i).getClassName());
					}
				}
				break;

			case "listcontents":
			paramNums = 1;
			if (parser.size() != (paramNums + 1)){
					System.out.println("incorrect number of parameters");
					break;
				}
			System.out.println("What class would you like to list the contents of?");
			// Scanner input (name of UML object)
			String toListContents = parser.get(1);
			if (Model.getNoClassDupes().contains(toListContents)) {
				for (UML uml1 : Model.getCollection()) {
					if (uml1.getClassName().equals(toListContents)) {
						uml1.listFields();
						uml1.listMethods();
						break;
					}
				}
			} else {
				System.out.println("Class does not exist!");
			}
				break;

			case "listrelationships":
			paramNums = 1;
			if (parser.size() != (paramNums + 1)){
					System.out.println("incorrect number of parameters");
					break;
				}
			// Scanner input (name of UML object)
			String toListRelationships = parser.get(1);
			// Checks if class exists
			if (Model.getNoClassDupes().contains(toListRelationships)) {
				// Searches for class
				for (UML uml2 : Model.getCollection()) {
					if (uml2.getClassName().equals(toListRelationships)) {
						uml2.listRelationships();
						break;
					}
				}
			} else {
				System.out.println("Class does not exist!");
			}
				break;
			case "undo":
				undoredo.undo();
				state = true;
				break;
			case "redo":
				undoredo.redo();
				state = true;
				break;

			case "screenshot":
				Screenshot.screenshot();
				break;
			case "setposition":
				paramNums = 3;
				if (parser.size() != (paramNums + 1)){
					System.out.println("incorrect number of parameters");
					break;
				}
				String move1 = parser.get(1);
				UML u = UML.findUMLOBJ(move1);
				String move2 = parser.get(2);
				String move3 = parser.get(3);
				UML.setCoords(u, Integer.valueOf(move2), Integer.valueOf(move3));
				break;

			case "help":
				System.out.println(
						"add class - creates a new unique class * the name must be alphanumeric and not already exist."
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
								+ "\nchange all parameters - changes all the parameters in a method"
								+ "\nadd relation - creates a relationship between two classes"
								+ "\ndelete relation - deletes a relationship between two classes"
								+ "\nchange relationship type - changes a relationship type"
								+ "\nlist classes - lists all the classes made"
								+ "\nlist contents - lists the contents of a specific class"
								+ "\nlist relationships - lists relationships between all classes"
								+ "\nsave - saves current uml file" + "\nload - loads a uml file"
								+ "\nhelp - provides a list of commands usable commands" + "\nexit - exists the program"
								+ "\nGUI - opens the GUI");
				break;

			case "save":
				JsonFile.save(Model.getCollection());
				break;

			case "load":
				System.out.println("Any unsaved changes will be deleted. Do you wish to proceed? (Yes or No)");
				String confirm = lineScan.readLine(">>> ").toLowerCase().replaceAll("\\s", "");;

				// Safeguard so the user doesn't accidentally delete files
				if (confirm.equals("yes")) {
					System.out.println("Enter the file you would like to load");
					String loadFile = lineScan.readLine("").toLowerCase().replaceAll("\\s", "");;

					if (JsonFile.load(loadFile, Model.getCollection())) {

						System.out.println("File loaded!");
						undoredo.loadClear();
					}
				}

				break;

			case "gui":
				guiUp = true;
				View.runGUI();
				run = false;
				break;

			case "exit":
				System.out.println("Exiting the application.");
				run = false;
				scanner.close();
				break;

			default:
				System.out.println("Command not recognized. Type help for valid commands");
			}
			parser.clear();
		}
	}


}