package uml;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	//Scanner for user input
	static Scanner scanner = new Scanner(System.in);

	public static boolean guiUp;

	/*
	 * Run command
	 */
	public static void main(String args[]) {
		runView();
	}


	// Runs the GUI (view) for the UML
	public static void runView() {
		View.runGUI();
		guiUp = true;
	}
	public static void runCLI() {
		//Boolean to run program until user exits
		boolean run = true;

		undoredo.stateKeeper();
		boolean state = false;
		while(run) {

			System.out.println("Enter a command or type exit if you wish to exit!");
			//This is the command the user has entered
			//It is converted to lowercase to allow for easier comparison and ignores white space
			String command = scanner.nextLine().toLowerCase().replaceAll("\\s", "");
			if (state == true && command.toLowerCase() != "undo" || command.toLowerCase() != "redo"){
				undoredo.memClear();
			}
			state = false;

			switch(command) {
          
			case "addclass": 
				CLI.addClassCLI();
				undoredo.stateKeeper();
				break;

			case "deleteclass":
				CLI.deleteClassCLI();
				undoredo.stateKeeper();
			
				break;

			case "renameclass":
				CLI.renameClassCLI();
				undoredo.stateKeeper();
				break;

			case "addfield":
				CLI.addFieldCLI();
				undoredo.stateKeeper();
				break;

			case "deletefield":
				CLI.deleteFieldCLI();
				undoredo.stateKeeper();
				break;

			case "renamefield":
				CLI.renameFieldCLI();
				undoredo.stateKeeper();
				break;

			case "addmethod":
				CLI.addMethodCLI();
				undoredo.stateKeeper();
				break;

			case "deletemethod":
				CLI.deleteMethodCLI();
				undoredo.stateKeeper();
				break;

			case "deleteallmethods":
				CLI.deleteAllMethodsCLI();
				undoredo.stateKeeper();
				break;

			case "renamemethod":
				CLI.renameMethodCLI();
				undoredo.stateKeeper();
				break;

			case "addparameter":
				CLI.addParameterCLI();
				undoredo.stateKeeper();
				break;

			case "deleteparameter":
				CLI.deleteParameterCLI();
				undoredo.stateKeeper();
				break;

			case "deleteallparameters":
				CLI.deleteAllParametersCLI();
				undoredo.stateKeeper();
				break;

			case "changeparameter":
				CLI.changeParameterCLI();
				undoredo.stateKeeper();
				break;

			case "changeallparameters":
				CLI.changeAllParametersCLI();
				undoredo.stateKeeper();
				break;

			case "addrelation":
				CLI.addRelationshipCLI();
				undoredo.stateKeeper();
				break;

			case "deleterelation":
				CLI.deleteRelationshipCLI();
				undoredo.stateKeeper();
				break;

			case "changerelationshiptype":
				CLI.changeRelationshipTypeCLI();
				undoredo.stateKeeper();
				break;

			case "listclasses":
				CLI.listClassesCLI();
				break;

			case "listcontents":
				CLI.listContentsCLI();
				break;

			case "listrelationships":
				CLI.listRelationshipsCLI();
				break;
			case "undo":
				undoredo.undo();
				state = true;
				break;
			case "redo":
				undoredo.redo();
				state = true;
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
						+ "\nchange all parameters - changes all the parameters in a method"
						+ "\nadd relation - creates a relationship between two classes"
						+ "\ndelete relation - deletes a relationship between two classes"
						+ "\nchange relationship type - changes a relationship type"
						+ "\nlist classes - lists all the classes made"
						+ "\nlist contents - lists the contents of a specific class"
						+ "\nlist relationships - lists relationships between all classes"
						+ "\nsave - saves current uml file"
						+ "\nload - loads a uml file"
						+ "\nhelp - provides a list of commands usable commands"
						+ "\nexit - exists the program"
						+ "\nGUI - opens the GUI");
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
		}
	}
}