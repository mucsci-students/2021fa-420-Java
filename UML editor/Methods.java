import java.util.ArrayList;

public class Methods {
	private String name;
	private String retType;
	private ArrayList<Parameters> param;

	public Methods(String name, String type) {
		this.name = name;
		this.retType = type;
		this.param = new ArrayList<Parameters>();
	}

	public String getMethodName() {
		return name;
	}

	public void setMethodName(String newName) {
		name = newName;
	}

	public String getMethodType() {
		return retType;
	}

	public void setMethodType(String newType) {
		retType = newType;
	}

	public ArrayList<Parameters> getParams() {
		return param;
	}

	// Adds an method to the given class
	public static void addMethod(String className, String methodName, String retType) {
		// Given class exists
		if(UML.getNoClassDupes().contains(className)) {
			// Given method does not exist, and the name is alphanumeric
			if(!UML.getNoMethodDupes().contains(methodName) && !UML.getPattern().matcher(methodName).find()) {
				UML.getNoMethodDupes().add(methodName);
				for(UML uml : UML.getCollection()) {
					if(uml.getClassName().equals(className)) {
						uml.getMethod().add(new Methods(methodName, retType));
						break;
					}
				}
				System.out.println("Method Created!");
			}
			// Given method name is not alphanumeric
			else if (UML.getPattern().matcher(methodName).find()) {
				System.out.println("A method name must only contain numbers and letters");
			}
			// Given method exists
			else {
				System.out.println("That method ALREADY exist!");
			}
		}
		// Given class does not exist
		else {
			System.out.println("That class does NOT exist!");
		}
	}

	// Remove an method from the given class
	public static void removeMethod(String className, String methodName) {
		// Given class exists
		if(UML.getNoClassDupes().contains(className)) {
			// Given method exists
			if(UML.getNoMethodDupes().contains(methodName)) {
				for(UML uml : UML.getCollection()) {
					if(uml.getClassName().equals(className)) {
						for(Methods method : uml.getMethod()){
							if(method.getMethodName().equals(methodName)){
								int remove = uml.getMethod().indexOf(method);
								uml.getMethod().remove(remove);
								UML.getNoMethodDupes().remove(methodName);
								break;
							}
						}
						break;
					}
				}
				System.out.println("Method Removed!");
			}
			// Given method does not exist
			else {
				System.out.println("That method does not exist!");
			}
		}
		// Given class does not exists
		else {
			System.out.println("That class does not exist!");
		}
	}

	// Renames an already existing method in a given class
	public static void renameMethod(String className, String oldName, String newName) {
		// Given class exist
		if(UML.getNoClassDupes().contains(className)) {
			// Given method does not exist, and the name is alphanumeric
			if(UML.getNoMethodDupes().contains(oldName) && !UML.getNoMethodDupes().contains(newName) && !UML.getPattern().matcher(newName).find()) {
				for(UML uml : UML.getCollection()) {
					if(uml.getClassName().equals(className)) {
						UML.getNoMethodDupes().remove(oldName);
						UML.getNoMethodDupes().add(newName);
						for(Methods method : uml.getMethod()) {
							method.setMethodName(newName);
						}
						break;
					}
				}
				System.out.println("Method Renamed!");
			}
			// Given method must be alphanumeric
			else if (UML.getPattern().matcher(newName).find()) {
				System.out.println("A method name must only contain numbers and letters");
			}
			// New method name already exists
			else if(UML.getNoMethodDupes().contains(newName)) {
				System.out.println("That method already exists!");
			}
			// Given method does not exist
			else {
				System.out.println("That method does not exist!");
			}
		}
		// Given class does not exist
		else {
			System.out.println("That class does not exist!");
		}
	}
}
