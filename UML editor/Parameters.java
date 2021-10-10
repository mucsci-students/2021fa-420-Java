import java.util.*;


public class Parameters {
	private String name;
	private String type;
	
	// Constructor
	public Parameters(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public String getParamName() {
		return name;
	}

	public void setParamName(String newName) {
		name = newName;
	}
	
	public String getParamType() {
		return type;
	}

	public void setParamType(String newType) {
		type = newType;
	}

	// Removes a parameter that matches the specified credentials at the index
	public static boolean deleteParameter (String UMLName, String methodsName, String pName){
		// The ArrayList of Parameters in a given method
		ArrayList<Parameters> mList;
		// Exit case
		try {
			mList = findMethod(UMLName, methodsName);
		} catch (IllegalStateException e) {
			return false;
		}
		int index = -1;

		// Finds the parameter to be removed
		for(Parameters param : mList){
			if(param.getParamName().equalsIgnoreCase(pName)){
			// index of the parameter
			index = mList.indexOf(param);
			break;
			}
		}
		// Removes the parameter at the index if found
		if(index != -1){
			mList.remove(index);
			return true;
		}
		else {
		System.out.println("Parameter not found!");
		return false;
		}
	}


	// Empties the Parameters of a given method
	public static boolean deleteAllParameters (String UMLName, String methodsName){
		// The ArrayList of Parameters in a given method
		ArrayList<Parameters> mList;
		// Exit case
		try {
			mList = findMethod(UMLName, methodsName);
		} catch (IllegalStateException e) {
			return false;
		}
		mList.clear();
		return true;
	}

	// Changes a single parameter in a method
	public static boolean changeParameter(String UMLName, String methodsName, String oldpName, String newpName, String newpType ){

		// The ArrayList of Parameters in a given method
		ArrayList<Parameters> mList;
		// Exit case
		try {
			mList = findMethod(UMLName, methodsName);
		} catch (IllegalStateException e) {
			return false;
		}
		//Duplicate checking
		HashSet<String> noDuplicates = new HashSet<String>(); 
		for(Parameters p : mList){
			noDuplicates.add(p.getParamName());
		}
		// Used to locate the parameter to be modified
		int index = -1;

		// Finds the index of the parameter to be modified
		for(Parameters param : mList){
			if(param.getParamName().equalsIgnoreCase(oldpName)){
			index = mList.indexOf(param);
			break;
			}
		}

		// If the parameter is found
		if(index != -1){
	
			Parameters p = new Parameters(newpName, newpType);
			// Replaces the parameter at that index with the new one
			if(!noDuplicates.contains(newpName)){
			mList.set(index, p);
			return true;
			} else{
				System.out.println(newpName +" is a duplicate. Choose another name");
				return false;
			}
		} else {
		
			System.out.println("Parameter not found!");
			return false;
		}

	}

	// Changes all the parameters of a given method
	// Doesn't work if scanner is closed
	public static boolean changeAllParameters(String UMLName, String methodsName){

		Scanner scanner = new Scanner(System.in);
		// The ArrayList of Parameters in a given method
		ArrayList<Parameters> mList;
		// Exit case
		try {
			mList = findMethod(UMLName, methodsName);
		} catch (IllegalStateException e) {
			return false;
		}
		// Used to check if the method already exists
		HashSet<String> noDuplicates = new HashSet<String>(); 

		// finds the element to be replaced and replaces the name and type for every element in the ArrayList
		for (int index = 0; index <= mList.size() -1; ++index ){
			
			System.out.println("Below is the parameter being changed:");
			System.out.println("Name "+ mList.get(index).getParamName() +" Type: " + mList.get(index).getParamType());

			System.out.println("What is the new name?");
			String pName = scanner.nextLine().toLowerCase().replaceAll("\\s","");

			// Makes sure that the new name of a parameter isn't a duplicate
			while(noDuplicates.contains(pName)){
				System.out.println("Parameter "+ pName + " already exists in this method. Choose another name.");
				pName = scanner.nextLine().toLowerCase().replaceAll("\\s","");
			}

			// Adds new name to Duplicate set, so the name cant be repeated
			noDuplicates.add(pName);
			System.out.println("What is " + pName + "'s type");
			String pType = scanner.nextLine().toLowerCase().replaceAll("\\s","");

			// Replaces the element at given index with the new element
			mList.set(index, new Parameters(pName, pType));
			
		}
		return true;
	}

	// Helper method used to get the Parameter ArrayList of a given method
	// Doesn't work if I close the Scanners
	public static ArrayList<Parameters> findMethod(String umlName, String methods ){
		// Set to null in order to use for comparisons later
		UML foundUML = null;

		// Finds the UML object if it exists
		for(UML u : UML.getCollection()){
			if(umlName.equals(u.getClassName())){
				foundUML = u;
				break;
			}
		}
		// If the UML object exists, this traverses the methods of the UML object and returns the Parameter list of the correct method
		if(foundUML != null){
			// Used to find method and return the parameter ArrayList if exists
			for (Methods m : foundUML.getMethod()){
				if(methods.equals(m.getMethodName())){

					return m.getParams();
				}
			}
			System.out.println("Method " + methods +" was not found");
			throw new IllegalStateException();
		}
		System.out.println("Class " + umlName +" was not found");
		throw new IllegalStateException();
	
	}	
}		
	
