package uml;

import java.util.*;
import javax.swing.JOptionPane;
import java.util.Arrays;

public class MethodOverloading {

	// Special instance of the findMethod defined
	public static ArrayList<Parameters> findMethod(String umlName, String methods, ArrayList<String> params) {
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
				// Finds the method and looks for the parameters to match
				if (methods.equals(m.getMethodName()) && compareParams(m.getParams(), params)) {
					foundMethod = true;
					return m.getParams();
				}
			}
			
			Driver.throwingError("That method does not exist!", foundMethod);
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

	// Compares 2 parameters to see if they are the same of Paramaters array list
	// and string array list
	public static boolean compareParams(ArrayList<Parameters> list1, ArrayList<String> list2) {
		if (list1.size() == list2.size()) {
			for (int i = 0; i <= list1.size() - 1; ++i) {
				// compares the types
				if (!(list1.get(i).getParamType().equals(list2.get(i)))) {
					return false;

				}
			}
			return true;
		}
		return false;

	}

	// Compares 2 parameters to see if they are the same of Paramaters array list
	// and parameters array list
	public static boolean compareParams(ArrayList<Parameters> list1, ArrayList<Parameters> list2, String x) {
		if (list1.size() == list2.size()) {
			for (int i = 0; i <= list1.size() - 1; ++i) {
				// compares the types
				if (!(list1.get(i).getParamType().equals(list2.get(i).getParamType()))) {
					return false;

				}
			}
			// If they are the same
			return true;
		}
		return false;

	}

	// Checks to see if there are any duplicate methods. If there are it returns the
	// list of methods as a set of strings
	public static HashSet<String> containsDuplicateMethods(String UMLname) {
		HashSet<String> setOfMethodNames = new HashSet<>();
		HashSet<String> duplicates = new HashSet<>();

		UML foundUML = null;
		// Finds UML class name
		for (UML u : Model.getCollection()) {
			if (UMLname.equals(u.getClassName())) {
				foundUML = u;
				break;
			}
		}
		if (foundUML == null){return null;}
		// Finds any duplicate methods
		for (Methods m : foundUML.getMethod()) {
			if (setOfMethodNames.contains(m.getMethodName())) {
				// Adds as a duplicate
				duplicates.add(m.getMethodName());
			}
			setOfMethodNames.add(m.getMethodName());
		}
		// returns duplicates
		return duplicates;

	}

	// **************************************************************************************************************************************
	/*
	 * Checking signatures of methods
	 *****************************************************************************************************************************************/
	// Checks to see that if a parameter is added that it won't create a method of
	// the same signature
	public static boolean containsSameSignatureAdding(UML UMLname, ArrayList<Parameters> addend,
			Parameters latestAddition, String mName) {
		@SuppressWarnings("unchecked")
		// need a clone so we can check what it'll look like with an insertions
		ArrayList<Parameters> origin = (ArrayList<Parameters>) addend.clone();
		origin.add(latestAddition);
		// checks to see if a method of the signature exists
		for (Methods m : UMLname.getMethod()) {
			if (m.getMethodName().equals(mName) && compareParams(m.getParams(), origin, "Hello fellow coder")) {
				return true;
			}
		}
		return false;
	}

	// Checks to see that if a parameter is removed that it won't create a method of
	// the same signature
	public static boolean containsSameSignatureDeleting(UML UMLname, ArrayList<Parameters> addend,
			Parameters latestAddition, String mName) {
		@SuppressWarnings("unchecked")
		// need a clone so we can check what it'll look like with an insertions
		ArrayList<Parameters> origin = (ArrayList<Parameters>) addend.clone();
		origin.remove(latestAddition);
		// checks to see if a method of the signature exists
		for (Methods m : UMLname.getMethod()) {
			if (m.getMethodName().equals(mName) && compareParams(m.getParams(), origin, "Hello fellow coder")) {
				return true;
			}
		}
		return false;
	}

	// Checks to see that if all parameters are removed that it won't create a
	// method of the same signature
	public static boolean containsSameSignatureDeletingAll(UML UMLname, ArrayList<Parameters> addend, String mName) {

		ArrayList<Parameters> origin = new ArrayList<Parameters>();
		// checks to see if a method of the signature exists
		for (Methods m : UMLname.getMethod()) {
			if (m.getMethodName().equals(mName) && compareParams(m.getParams(), origin, "Hello fellow coder")) {
				return true;
			}
		}
		return false;
	}

	// Checks to see that if a parameter is changed that it won't create a method of
	// the same signature
	public static boolean containsSameSignatureChanging(UML UMLname, ArrayList<Parameters> addend, String mName,
			String oldPName, String newPName, String newPType) {
		@SuppressWarnings("unchecked")
		// need a clone so we can check what it'll look like with a change
		ArrayList<Parameters> origin = (ArrayList<Parameters>) addend.clone();
		Parameters p1 = Parameters.findParam(oldPName, addend);
		if(p1 == null){
		
			return false;
		}
		Parameters p2 = new Parameters(newPName, newPType);
		// replace old parameter with new
		int index = origin.indexOf(p1);
		origin.set(index, p2);
		// checks to see if a method of the signature exists
		for (Methods m : UMLname.getMethod()) {
			if (m.getMethodName().equals(mName) && compareParams(m.getParams(), origin, "Hello fellow coder")) {
				return true;
			}
		}
		return false;
	}

	// Checks to see that if all parameters are changed that it won't create a
	// method of the same signature
	public static boolean containsSameSignatureChangingAll(UML UMLname, ArrayList<Parameters> addend,
			Parameters latestAddition, String mName) {
		@SuppressWarnings("unchecked")
		// need a clone so we can check what it'll look like with a change
		ArrayList<Parameters> origin = (ArrayList<Parameters>) addend.clone();
		// checks the last parameter because the rest are allowed to be same type except
		// the last
		origin.set(addend.size() - 1, latestAddition);
		// checks to see if a method of the signature exists
		for (Methods m : UMLname.getMethod()) {
			if (m.getMethodName().equals(mName) && compareParams(m.getParams(), origin, "Hello fellow coder")) {
				return true;
			}
		}
		return false;
	}

	// ************************************************************************************************************************************
	// */
	// Gets the correct parameter list of any method
	public static ArrayList<Parameters> locatingParameters(String UML, String method, String scanInput) {
		ArrayList<Parameters> pList = null;
		// boolean to check if there is method overloading. False if there is. True if
		// there isn't
		boolean validate = true;
		// Exit case
		try {
			if (MethodOverloading.containsDuplicateMethods(UML).contains(method)) {

				validate = false;
				ArrayList<String> comparison = new ArrayList<>();
				Scanner s = new Scanner(scanInput);
				

				while (s.hasNext()) {
					comparison.add(s.next());
				}

				// Specific parameter list if the method is overloaded
				pList = MethodOverloading.findMethod(UML, method, comparison);
			}

		} catch (NullPointerException e) {
			System.out.println("Class name not found");
			return null;
		}

		if (validate) {
			// If no method overloading exists
			pList = Parameters.findMethod(UML, method);
		}
		return pList;
	}

	public static ArrayList<Parameters> locatingParametersCLI(String UML, String method, ArrayList<String> a) {
		ArrayList<Parameters> pList = null;
		// boolean to check if there is method overloading. False if there is. True if
		// there isn't

		boolean validate = true;
		// Exit case
		try {
			if (MethodOverloading.containsDuplicateMethods(UML).contains(method)) {

				validate = false;
				// Specific parameter list if the method is overloaded
				pList = MethodOverloading.findMethod(UML, method, a);
			}

		} catch (NullPointerException e) {
			System.out.println("Class name not found");
			return null;
		}

		if (validate) {
			// If no method overloading exists
			pList = Parameters.findMethod(UML, method);
		}
		return pList;
	}

}