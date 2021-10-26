package uml;

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

	public static boolean addParameter(String UMLName, String methodName, String parameterName, String type){
		ArrayList<Parameters> pList;
		// Makes sure the method of insertion exists or if the user exited

		pList = Parameters.findMethod(UMLName, methodName);
		if(pList == null){ 
			return false;
		}

		// Duplicate checking
		HashSet<String> noDuplicates = new HashSet<String>(); 

		// Copying Param names to noDuplicates
		for(Parameters p : pList){
			noDuplicates.add(p.getParamName());
		}

		if(!noDuplicates.contains(parameterName)) {
			noDuplicates.add(parameterName);
			Parameters parameter = new Parameters(parameterName, type);
			// Addition of a new parameter
			pList.add(parameter);
			if(Driver.guiUp) {
				View.outputLbl.setText("Parameter Created!");
			}
			else {
				System.out.println("Parameter Created!");
			}
			return true;
		}
		else {
			if(Driver.guiUp) {
				View.outputLbl.setText("That parameter already exists!");
			}
			else {
				System.out.println("That parameter already exists!");
			}
		}
		return false;

	}

	// Removes a parameter that matches the specified credentials at the index
	public static boolean deleteParameter(String UMLName, String methodsName, String pName) {
		// The ArrayList of Parameters in a given method
		ArrayList<Parameters> mList;
		// Exit case
		mList = Parameters.findMethod(UMLName, methodsName);
		if(mList == null){ 
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
		if(index != -1) {
			mList.remove(index);
			if(Driver.guiUp) {
				View.outputLbl.setText("Parameter deleted!");
			}
			else {
				System.out.println("Parameter deleted!");
			}
			return true;
		}
		else {
			if(Driver.guiUp) {
				View.outputLbl.setText("That parameter does not exist!");
			}
			else {
				System.out.println("That parameter does not exist!");
			}
			return false;
		}
	}


	// Empties the Parameters of a given method
	public static boolean deleteAllParameters (String UMLName, String methodsName){
		// The ArrayList of Parameters in a given method
		ArrayList<Parameters> mList;
		// Exit case
		mList = Parameters.findMethod(UMLName, methodsName);
		if(mList == null) {
			return false;
		}
		if(mList.isEmpty()) {
			if(Driver.guiUp) {
				View.outputLbl.setText("There are no parameters to remove.");
			}
			else {
				System.out.println("There are no parameters to remove.");
			}
			return false;
		}
		mList.clear();
		if(Driver.guiUp) {
			View.outputLbl.setText("Parameters deleted!");
		}
		else {
			System.out.println("Parameters deleted!");
		}
		return true;
	}

	// Changes a single parameter in a method
	public static boolean changeParameter(String UMLName, String methodsName, String oldpName, String newpName, String newpType ) {
		// The ArrayList of Parameters in a given method
		ArrayList<Parameters> mList;
		// Exit case
		mList = Parameters.findMethod(UMLName, methodsName);
		if(mList == null){ 
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
				if(Driver.guiUp) {
					View.outputLbl.setText("Parameter changed!");
				}
				else {
					System.out.println("Parameter changed!");
				}
				return true;
			}
			else {
				if(Driver.guiUp) {
					View.outputLbl.setText("That parameter already exists!");
				}
				else {
					System.out.println("That parameter already exists!");
				}
				return false;
			}
		}
		else {
			if(Driver.guiUp) {
				View.outputLbl.setText("That parameter does not exist!");
			}
			else {
				System.out.println("That parameter does not exist!");
			}
			return false;
		}

	}

	// Helper method used to get the Parameter ArrayList of a given method
	// Doesn't work if I close the Scanners
	public static ArrayList<Parameters> findMethod(String umlName, String methods ){
		// Set to null in order to use for comparisons later

		UML foundUML = null;

		// Finds the UML object if it exists
		for(UML u : UML.getCollection()) {
			if(umlName.equals(u.getClassName())) {
				foundUML = u;
				break;
			}
		}
		// If the UML object exists, this traverses the methods of the UML object and returns the Parameter list of the correct method
		if(foundUML != null) {
			// Used to find method and return the parameter ArrayList if exists
			for(Methods m : foundUML.getMethod()) {
				if(methods.equals(m.getMethodName())) {
					return m.getParams();
				}
			}
			if(Driver.guiUp) {
				View.outputLbl.setText("That method does not exist!");
			}
			else {
				System.out.println("That method does not exist!");
			}
			return null;
		}
		if(Driver.guiUp) {
			View.outputLbl.setText("That class does not exist!");
		}
		else {
			System.out.println("That class does not exist!");
		}
		return null;
	}
}