package uml;

import java.util.*;
import javax.swing.JOptionPane;


public class MethodOverloading {


    public static ArrayList<Parameters> findMethod(String umlName, String methods, ArrayList<String> params ){
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
				if(methods.equals(m.getMethodName()) && compareParams(m.getParams(), params)) {
					return m.getParams();
				}
			}
			if(Driver.guiUp) {
				JOptionPane.showMessageDialog(View.frmUmlEditor, "That method does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				System.out.println("That method does not exist!");
			}
			return null;
		}
		if(Driver.guiUp) {
			JOptionPane.showMessageDialog(View.frmUmlEditor, "That class does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else {
			System.out.println("That class does not exist!");
		}
		return null;
	}

	public static boolean compareParams(ArrayList<Parameters> list1, ArrayList<String> list2 ){
		if (list1.size() == list2.size()){
			for(int i = 0; i <= list1.size() - 1; ++i){
				if (!(list1.get(i).getParamType().equals(list2.get(i)))){
					System.out.println("not same");
					return false;
					
				}
			}
			return true;
		}
		return false;

	}
	public static boolean compareParams(ArrayList<Parameters> list1, ArrayList<Parameters> list2, String x){
		if (list1.size() == list2.size()){
			for(int i = 0; i <= list1.size() - 1; ++i){
				if (!(list1.get(i).getParamType().equals(list2.get(i).getParamType()))){
					return false;
					
				}
			}
			return true;
		}
		return false;

	}
	// NEED TO MAKE SURE UML CLASS AND METHOD EXISTS
	// OTHERWISE WORKS
	public static HashSet<String> containsDuplicateMethods(String UMLname){
		HashSet<String> setOfMethodNames = new HashSet<>();
		HashSet<String> duplicates = new HashSet<>();

		UML foundUML = null;
			for (UML u : UML.getCollection()) {
				if (UMLname.equals(u.getClassName())) {
					foundUML = u;
					break;
				}
			}
		

		for(Methods m : foundUML.getMethod()) {
			if(setOfMethodNames.contains(m.getMethodName())){
				duplicates.add(m.getMethodName());
			}
			setOfMethodNames.add(m.getMethodName());
		}
		return duplicates;
	
	}

	//**************************************************************************************************************************************
	/* Checking signatures of methods
	*****************************************************************************************************************************************/
	public static boolean containsSameSignatureAdding(UML UMLname, ArrayList<Parameters> addend, Parameters latestAddition, String mName){
		@SuppressWarnings("unchecked")
		ArrayList<Parameters> origin = (ArrayList<Parameters>) addend.clone();
		origin.add(latestAddition);

			for(Methods m : UMLname.getMethod()) {
				if(m.getMethodName().equals(mName) && compareParams(m.getParams(), origin, "Hello fellow coder")) {
					return true;
				}
			}
		return false;
	}
	public static boolean containsSameSignatureDeleting(UML UMLname,  ArrayList<Parameters> addend, Parameters latestAddition, String mName){
		@SuppressWarnings("unchecked")
		ArrayList<Parameters> origin = (ArrayList<Parameters>) addend.clone();
		origin.remove(latestAddition);

		for(Methods m : UMLname.getMethod()) {
			if(m.getMethodName().equals(mName) && compareParams(m.getParams(), origin, "Hello fellow coder")) {
				return true;
			}
		}
	return false;
	}
	public static boolean containsSameSignatureDeletingAll(UML UMLname,  ArrayList<Parameters> addend, String mName){
		
		ArrayList<Parameters> origin = new ArrayList<Parameters>();

		for(Methods m : UMLname.getMethod()) {
			if(m.getMethodName().equals(mName) && compareParams(m.getParams(), origin, "Hello fellow coder")) {
				return true;
			}
		}
	return false;
	}
	public static boolean containsSameSignatureChanging(UML UMLname,  ArrayList<Parameters> addend, String mName, String oldPName, String newPName){
		@SuppressWarnings("unchecked")
		ArrayList<Parameters> origin = (ArrayList<Parameters>) addend.clone();
		Parameters p1 = Parameters.findParam(oldPName, addend);
		Parameters p2 = Parameters.findParam(oldPName, addend);
		int index = origin.indexOf(p1);
		origin.set(index, p2);

		for(Methods m : UMLname.getMethod()) {
			if(m.getMethodName().equals(mName) && compareParams(m.getParams(), origin, "Hello fellow coder")) {
				return true;
			}
		}
	return false;
	}
	public static boolean containsSameSignatureChangingAll(UML UMLname, ArrayList<Parameters> addend, Parameters latestAddition, String mName){
		@SuppressWarnings("unchecked")
		ArrayList<Parameters> origin = (ArrayList<Parameters>) addend.clone();
		origin.set(addend.size()-1, latestAddition);

			for(Methods m : UMLname.getMethod()) {
				if(m.getMethodName().equals(mName) && compareParams(m.getParams(), origin, "Hello fellow coder")) {
					return true;
				}
			}
		return false;
	}
	
//************************************************************************************************************************************ */
    public static ArrayList<Parameters> locatingParameters(String UML, String method){
        ArrayList<Parameters> pList = null;
		boolean validate = true;
		// Exit case
		try {
			if(MethodOverloading.containsDuplicateMethods(UML).contains(method)){
				validate = false;
				String dif = "nd";
				int num = 1;
				ArrayList<String> comparison = new ArrayList<>();
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter the "+num+"st parameter type or type -1 if you are done!");
				String s = scanner.nextLine().toLowerCase();
				while(!(s.equals("-1"))){
					comparison.add(s);
					++num;
					if(dif.equals("rd")){
						dif = "th";
					}
					System.out.println("Enter "+num + dif+" parameter type or type -1 if you are done!");
					s = scanner.nextLine().toLowerCase();
					if (dif.equals("nd")){
						dif = "rd";
					}
					
					
	
				}
				
				pList = MethodOverloading.findMethod(UML, method, comparison);
			}
	
		} catch (NullPointerException e) {
			System.out.println(" Class name not found");
			return null;
		}
		


		if (validate){
		// Makes sure the method of insertion exists or if the user exited
		pList = Parameters.findMethod(UML, method);
		}
        return pList;
    }




}