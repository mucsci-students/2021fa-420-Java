
import java.io.*;
import java.util.*;

public class UML {
	//Size
	private int size;
	
	//Class name
	private String name;
	
	//Set containing all the methods in a UML object
	private HashSet<String> methods;
	
	//Set containing all the variables in a UML object
	private Hashtable<String, String> variables;
	
	//MAKE ARRAY LIST OF TYPE RELATIONSHIP ONCE JAVA RELATIONSHIP CLASS IS CREATED

	public UML (String name) {
		this.name = name;
		this.size = 0;
		this.methods = new HashSet<String>();
		this.variables = new Hashtable<String, String>();
	//this.relationships = PUT THE ARRAY LIST OF TYPE RELATIONSHIP ONCE JAVA RELATIONSHIP CLASS IS CREATED
		
	}
	
	/*
	 * Creates a class
	 */
	public static UML createClass (String name) {
		
		UML x = new UML(name);
		return x;
	}
	
	/*
	 * Amount of elements in the class
	 */
	public int size() {
		return size;
	}
	
	/*
	 * returns the name of the class
	 */
	public String getName() {
		return name;
	}

	/*
	 * Uses an iterator to traverse through the methods set and 
	 * writes them out 
	 */
	public void checkMethods () {
		@SuppressWarnings("rawtypes")
		Iterator itr = methods.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	
	/*
	 * Adds methods to the methods HashSet 
	 */
	public void addMethods (String newMethod) {
		this.methods.add(newMethod);
		++size;
		
	}
	
	/*
	 * Run command
	 */
	public static void main(String args[]) {
		

		boolean run = true;
		// This set is to make sure there are no classes with the same name.
		HashSet<String> noClassDupes = new HashSet<String>();
		//This is the Array list that should hold all the objects
		ArrayList<UML> collection = new ArrayList<UML>();  		
		//Placeholder value for what the scanner input is
		String value;
		//The current UML document that is being edited
		UML current = null;
		
		
		while(run) {
			
			System.out.println("Enter a command or type exit if you wish to exit!");
			Scanner s = new Scanner(System.in);
			//This is the command the user has entered. It is converted to lowercase to allow for easier comparison
			String command = s.nextLine().toLowerCase();
			
			
			switch(command){
				case "add class": 
					System.out.println("What would you like to name the new class?");
					s = new Scanner(System.in);
					
					//Scanner input (name of UML object)
					value = s.nextLine();
					
					//Creating the UML object using the input value for the name of the UML object 
					current = createClass(value);
					
					//When implementing add class, make sure you check if the name is in the noClassDupes HashSet first to prevent classes with the same name
					//After created, store the current in the collection ArrayList
					
					System.out.println("Class Created!");
					break;
					
				case "add method":
                //NEED TO FIND THE CLASS THEY ARE ASKING FOR FROM THE ARRAY LIST, MAKE IT EQUAL TO CURRENT, THEN INSERT THE METHOD INTO THAT CLASS (2 SCANNERS IN TOTAL)
					System.out.println("What method you like to the class?");
					s = new Scanner(System.in);
					value = s.nextLine().toLowerCase();
					current.addMethods(value);
					break;
					
				case "check methods":
                //NEED TO FIND THE CLASS THEY ARE ASKING FOR FROM THE ARRAY LIST AND MAKE THAT EQUAL TO CURRENT
					current.checkMethods();
					break;
					
				case "exit":
					run = false;
					break;
					
				default:
					System.out.println("Command not recognized. Type help for valid commands");
						
			}	
			
		}
		
	}
		
}
