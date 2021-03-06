package uml;

import java.util.*;
import javax.swing.JOptionPane;

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

	// Adds parameters to a method
	public static boolean addParameter(String UMLName, String methodName, String parameterName, String type,
			ArrayList<Parameters> pList, boolean dupeMethods) {
		if (!Driver.guiUp || !dupeMethods) {
			// Does a check to see if the method is overloaded. Also finds the correct
			// method
			pList = MethodOverloading.locatingParameters(UMLName, methodName, "");
			// Case where the method doesn't exist
			if (pList == null) {
				Driver.throwingError("This method or class does not exist!");
				return false;
			}
		}

		// Inserted Parameter
		Parameters parameter = new Parameters(parameterName, type);
		// Gets the UML object that the parameter is being inserted into
		UML UMLOBJ = UML.findUMLOBJ(UMLName);

		// Makes sure there aren't any methods with duplicate signatures being created
		// with the addition of a new parameter
		if (MethodOverloading.containsSameSignatureAdding(UMLOBJ, pList, parameter, methodName)) {
			Driver.throwingError("A method with that signature already exists!");
			return false;
		}

		// Duplicate checking
		HashSet<String> noDuplicates = new HashSet<String>();

		// Copying Param names to noDuplicates
		for (Parameters p : pList) {
			noDuplicates.add(p.getParamName());
		}

		if (!noDuplicates.contains(parameterName)) {
			noDuplicates.add(parameterName);

			// Addition of a new parameter
			pList.add(parameter);
			undoredo.stateKeeper();

			// Updates GUI boxes
			BoxObject.find(UMLName);

			if (!Driver.guiUp) {
				System.out.println("Parameter Created!");
			}
			return true;
		} else {
			Driver.throwingError("That parameter already exists!");
		}
		return false;

	}

	// Removes a parameter that matches the specified credentials at the index
	public static boolean deleteParameter(String UMLName, String methodsName, String pName, ArrayList<Parameters> pList,
			boolean dupeMethods) {
		if (!Driver.guiUp || !dupeMethods) {
			// Does a check to see if the method is overloaded. Also finds the correct
			// method
			pList = MethodOverloading.locatingParameters(UMLName, methodsName, "");
			// Case where the method doesn't exist
			if (pList == null) {
				Driver.throwingError("This method or class does not exist!");
				return false;
			}
		}
		// Gets the UML object that the parameter is being removed from
		UML UMLOBJ = UML.findUMLOBJ(UMLName);
		// Finds the specific parameter that is getting deleted
		Parameters p = findParam(pName, pList);

		// Makes sure there aren't any methods with duplicate sinatures being created
		// with the deletion of a new parameter
		if (MethodOverloading.containsSameSignatureDeleting(UMLOBJ, pList, p, methodsName)) {
			Driver.throwingError("A method with that signature already exists!");
			return false;
		}
		int index = -1;

		// Finds the parameter to be removed
		for (Parameters param : pList) {
			if (param.getParamName().equalsIgnoreCase(pName)) {
				// index of the parameter
				index = pList.indexOf(param);
				break;
			}
		}
		// Removes the parameter at the index if found
		if (index != -1) {
			pList.remove(index);
			undoredo.stateKeeper();

			// Updates GUI boxes
			BoxObject.find(UMLName);

			if (!Driver.guiUp) {
				System.out.println("Parameter Removed!");
			}
			return true;
		} else {
			Driver.throwingError("That parameter does not exist!");
			return false;
		}
	}

	// Empties the Parameters of a given method
	public static boolean deleteAllParameters(String UMLName, String methodsName, ArrayList<Parameters> pList,
			boolean dupeMethods) {
		if (!Driver.guiUp || !dupeMethods) {
			// Does a check to see if the method is overloaded. Also finds the correct
			// method
			pList = MethodOverloading.locatingParameters(UMLName, methodsName, "");
			// Case where method doesn't exist
			if (pList == null) {
				Driver.throwingError("This method or class does not exist!");
				return false;
			}
		}
		// Gets the UML object that the parameters are being removed from
		UML UMLOBJ = UML.findUMLOBJ(UMLName);

		// Makes sure there aren't any methods with duplicate sinatures being created
		// with the deletion of parameters
		if (MethodOverloading.containsSameSignatureDeletingAll(UMLOBJ, pList, methodsName)) {
			Driver.throwingError("A method with that signature already exists!");
			return false;
		}

		if (pList.isEmpty()) {
			Driver.throwingError("There are no parameters to remove.");
			return false;
		}
		// deletes parameters
		pList.clear();
		undoredo.stateKeeper();

		BoxObject.find(UMLName);

		if (!Driver.guiUp) {
			System.out.println("Parameters Removed!");
		}
		return true;
	}

	// Changes a single parameter in a method
	public static boolean changeParameter(String UMLName, String methodsName, String oldpName, String newpName,
			String newpType, ArrayList<Parameters> pList, boolean dupeMethods) {
		if (!Driver.guiUp || !dupeMethods) {
			// Does a check to see if the method is overloaded. Also finds the correct
			// method
			pList = MethodOverloading.locatingParameters(UMLName, methodsName, "");
			// Case where method doesn't exist
			if (pList == null) {
				Driver.throwingError("This method or class does not exist!");
				return false;
			}
		}
		// Gets the UML object that the parameters are being changed from
		UML UMLOBJ = UML.findUMLOBJ(UMLName);
		// Makes sure there aren't any methods with duplicate sinatures being created
		// with the changing of parameters
		if (MethodOverloading.containsSameSignatureChanging(UMLOBJ, pList, methodsName, oldpName, newpName, newpType)) {
			Driver.throwingError("A method with that signature already exists!");
			return false;
		}
		// Duplicate checking
		HashSet<String> noDuplicates = new HashSet<String>();
		for (Parameters p : pList) {
			noDuplicates.add(p.getParamName());
		}
		// Used to locate the parameter to be modified
		int index = -1;

		// Finds the index of the parameter to be modified
		for (Parameters param : pList) {
			if (param.getParamName().equalsIgnoreCase(oldpName)) {
				index = pList.indexOf(param);
				break;
			}
		}

		// If the parameter is found
		if (index != -1) {
			Parameters p = new Parameters(newpName, newpType);
			// Replaces the parameter at that index with the new one
			if (!noDuplicates.contains(newpName)) {
				pList.set(index, p);
				undoredo.stateKeeper();

				BoxObject.find(UMLName);

				if (!Driver.guiUp) {
					System.out.println("Parameter Changed!");
				}
				return true;
			} else {
				Driver.throwingError("That parameter already exists!");
				return false;
			}
		} else {
			Driver.throwingError("That parameter does not exist!");
			return false;
		}

	}

	// Helper method used to get the Parameter ArrayList of a given method
	public static ArrayList<Parameters> findMethod(String umlName, String methods) {
		// Set to null in order to use for comparisons later

		UML foundUML = null;

		// Finds the UML object if it exists
		for (UML u : Model.getCollection()) {
			if (umlName.equals(u.getClassName())) {
				foundUML = u;
				break;
			}
		}
		// If the UML object exists, this traverses the methods of the UML object and
		// returns the Parameter list of the correct method
		if (foundUML != null) {
			boolean foundMethod = false;
			// Used to find method and return the parameter ArrayList if exists
			for (Methods m : foundUML.getMethod()) {
				if (methods.equals(m.getMethodName())) {
					foundMethod = true;
					return m.getParams();
				}
			}
			if (Driver.guiUp && foundMethod) {
				Driver.throwingError("That method does not exist!");
			}
			return null;
		}
		if (Driver.guiUp && foundUML == null) {
			JOptionPane.showMessageDialog(View.frmUmlEditor, "That class does not exist!", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else if (!Driver.guiUp && foundUML == null) {
			System.out.println("That class does not exist!");
		}
		return null;
	}

	// Finds a specific parameter in a given parameter list
	public static Parameters findParam(String name, ArrayList<Parameters> list) {
		for (Parameters p : list) {
			if (p.getParamName().equals(name)) {
				return p;
			}
		}
		return null;
	}

	// *****************************************************************************************************************
	/*
	 * CLI method overloading
	 **********************************************************************************************************************/
	public static boolean addParameterCLI(String UMLName, String methodName, String parameterName, String type,
			ArrayList<Parameters> pList, boolean dupeMethods, ArrayList<String> a) {
		if (!Driver.guiUp || !dupeMethods) {
			// Does a check to see if the method is overloaded. Also finds the correct
			// method
			pList = MethodOverloading.locatingParametersCLI(UMLName, methodName, a);
			// Case where the method doesn't exist
			if (pList == null) {
				Driver.throwingError("This method or class does not exist!");
				return false;
			}
		}

		// Inserted Parameter
		Parameters parameter = new Parameters(parameterName, type);

		// Duplicate checking
		HashSet<String> noDuplicates = new HashSet<String>();

		// Gets the UML object that the parameter is being inserted into
		UML UMLOBJ = UML.findUMLOBJ(UMLName);

		// Makes sure there aren't any methods with duplicate signatures being created
		// with the addition of a new parameter
		if (MethodOverloading.containsSameSignatureAdding(UMLOBJ, pList, parameter, methodName)) {
			System.out.println("A method with that signature already exists!");
			return false;
		}

		// Copying Param names to noDuplicates
		for (Parameters p : pList) {
			noDuplicates.add(p.getParamName());
		}

		if (!noDuplicates.contains(parameterName)) {
			noDuplicates.add(parameterName);

			// Addition of a new parameter
			pList.add(parameter);
			undoredo.stateKeeper();

			// Updates GUI boxes
			BoxObject.find(UMLName);
			System.out.println("Parameter Created!");
			return true;
		} else {
			System.out.println("That parameter already exists!");
		}
		return false;

	}

	// Removes a parameter that matches the specified credentials at the index
	public static boolean deleteParameterCLI(String UMLName, String methodsName, String pName,
			ArrayList<Parameters> pList,
			boolean dupeMethods, ArrayList<String> a) {
		if (!Driver.guiUp || !dupeMethods) {
			// Does a check to see if the method is overloaded. Also finds the correct
			// method
			pList = MethodOverloading.locatingParametersCLI(UMLName, methodsName, a);
			// Case where the method doesn't exist
			if (pList == null) {
				Driver.throwingError("This method or class does not exist!");
				return false;
			}
		}
		UML UMLOBJ = UML.findUMLOBJ(UMLName);
		// Finds the specific parameter that is getting deleted
		Parameters p = findParam(pName, pList);
		if (MethodOverloading.containsSameSignatureDeleting(UMLOBJ, pList, p, methodsName)) {
			System.out.println("A method with that signature already exists!");
			return false;
		}

		int index = -1;

		// Finds the parameter to be removed
		for (Parameters param : pList) {
			if (param.getParamName().equalsIgnoreCase(pName)) {
				// index of the parameter
				index = pList.indexOf(param);
				break;
			}
		}
		// Removes the parameter at the index if found
		if (index != -1) {
			pList.remove(index);
			undoredo.stateKeeper();

			// Updates GUI boxes
			BoxObject.find(UMLName);

			System.out.println("Parameter Removed!");
			return true;
		} else {
			System.out.println("That parameter does not exist!");
			return false;
		}
	}

	public static boolean deleteAllParametersCLI(String UMLName, String methodsName, ArrayList<Parameters> pList,
			boolean dupeMethods, ArrayList<String> a) {
		if (!Driver.guiUp || !dupeMethods) {
			// Does a check to see if the method is overloaded. Also finds the correct
			// method
			pList = MethodOverloading.locatingParametersCLI(UMLName, methodsName, a);
			// Case where method doesn't exist
			if (pList == null) {
				Driver.throwingError("This method or class does not exist!");
				return false;
			}
		}
		// Gets the UML object that the parameters are being removed from
		UML UMLOBJ = UML.findUMLOBJ(UMLName);

		// Makes sure there aren't any methods with duplicate sinatures being created
		// with the deletion of parameters
		if (MethodOverloading.containsSameSignatureDeletingAll(UMLOBJ, pList, methodsName)) {
			System.out.println("A method with that signature already exists!");
			return false;
		}

		if (pList.isEmpty()) {
			System.out.println("There are no parameters to remove.");
			return false;
		}
		// deletes parameters
		pList.clear();
		undoredo.stateKeeper();

		BoxObject.find(UMLName);

		System.out.println("Parameters Removed!");
		return true;
	}

	public static boolean changeParameterCLI(String UMLName, String methodsName, String oldpName, String newpName,
			String newpType, ArrayList<Parameters> pList, boolean dupeMethods, ArrayList<String> a) {
		if (!Driver.guiUp || !dupeMethods) {
			// Does a check to see if the method is overloaded. Also finds the correct
			// method
			pList = MethodOverloading.locatingParametersCLI(UMLName, methodsName, a);
			// Case where method doesn't exist
			if (pList == null) {
				Driver.throwingError("This method or class does not exist!");
				return false;
			}
		}
		// Gets the UML object that the parameters are being changed from
		UML UMLOBJ = UML.findUMLOBJ(UMLName);
		// Makes sure there aren't any methods with duplicate sinatures being created
		// with the changing of parameters
		if (MethodOverloading.containsSameSignatureChanging(UMLOBJ, pList, methodsName, oldpName, newpName, newpType)) {
			System.out.println("A method with that signature already exists!");
			return false;
		}
		// Duplicate checking
		HashSet<String> noDuplicates = new HashSet<String>();
		for (Parameters p : pList) {
			noDuplicates.add(p.getParamName());
		}
		// Used to locate the parameter to be modified
		int index = -1;

		// Finds the index of the parameter to be modified
		for (Parameters param : pList) {
			if (param.getParamName().equalsIgnoreCase(oldpName)) {
				index = pList.indexOf(param);
				break;
			}
		}

		// If the parameter is found
		if (index != -1) {
			Parameters p = new Parameters(newpName, newpType);
			// Replaces the parameter at that index with the new one
			if (!noDuplicates.contains(newpName)) {
				pList.set(index, p);
				undoredo.stateKeeper();

				BoxObject.find(UMLName);

				if (!Driver.guiUp) {
					System.out.println("Parameter Changed!");
				}
				return true;
			} else {

				System.out.println("That parameter already exists!");
				return false;
			}
		} else {
			System.out.println("That parameter does not exist!");
			return false;
		}

	}

}