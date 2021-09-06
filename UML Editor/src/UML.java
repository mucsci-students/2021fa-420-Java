
import java.io.*;
import java.util.*;

public class UML {
	private int size;
	private String name;

	private HashSet<String> methods;

	private Hashtable<String, String> variables;

	public UML (String name) {
		this.name = name;
		this.size = 0;
		this.methods = new HashSet<String>();
		this.variables = new Hashtable<String, String>();
		
	}
	
	public static UML createClass (String name) {
		
		
		UML x = new UML(name);

		return x;
	}
	public int size() {
		return size;
	}
	
	public String getName() {
		return name;
	}

	
	public void checkMethods () {
		@SuppressWarnings("rawtypes")
		Iterator itr = methods.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	public void addMethods (String newMethod) {
		this.methods.add(newMethod);
		++size;
		
	}
	
	public static void main(String args[]) {
		boolean run = true;
		HashSet<UML> UML_Classes = new HashSet<UML>();
		String value;
		UML current = null;
		
		
		while(run) {
			
			System.out.println("Enter a command or type -1 if you wish to exit!");
			Scanner s = new Scanner(System.in);
			String command = s.nextLine().toLowerCase();
			System.out.println(command);
			
			
			
			switch(command){
				case "add class": 
					System.out.println("What would you like to name the new class?");
					s = new Scanner(System.in);
					value = s.nextLine().toLowerCase();
					
					current = createClass(value);
					//Change name of current and store current in hashset and retrieve every time you want to edit
					
					System.out.println("Class Created!");
					break;
					
				case "add methods":
					System.out.println("What method you like to the class?");
					s = new Scanner(System.in);
					value = s.nextLine().toLowerCase();
					current.addMethods(value);
					break;
					
				case "check methods":
					current.checkMethods();
					break;
					
				case "-1":
					run = false;
					break;
					
				default:
					System.out.println("Command not recognized. Type help for valid commands");
						
			}	
			
		}
		
	}
		
}
