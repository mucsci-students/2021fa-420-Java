import java.util.ArrayList;

public class Methods {
	private String name;
	private String return_type;
	private ArrayList<Parameters> params;

	public Methods(String name, String type) {
		this.name = name;
		this.return_type = type;
		this.params = new ArrayList<Parameters>();
	}

	public String getMethodName() {
		return name;
	}

	public void setMethodName(String newName) {
		name = newName;
	}

	public String getMethodType() {
		return return_type;
	}

	public void setMethodType(String newType) {
		return_type = newType;
	}

	public ArrayList<Parameters> getParams() {
		return params;
	}

	// Adds an method to the given class
	public static void addMethod(String className, String methodName, String retType) {
		// Given class exists
		if(UML.getNoClassDupes().contains(className)) {
			for(UML uml : UML.getCollection()) {
				if(uml.getClassName().equals(className)) {
					if(!UML.getPattern().matcher(methodName).find()) {
						for(int i = 0; i <= uml.getMethod().size(); i++) {
							// Given method does not exist, and the name is alphanumeric
							if(i == uml.getMethod().size()) {
								uml.getMethod().add(new Methods(methodName, retType));
								if(Driver.guiUp) {
									View.outputLbl.setText("Method Created!");
								}
								else {
									System.out.println("Method Created!");
								}
								return;
							}
							// Given method exists
							else if(uml.getMethod().get(i).getMethodName().equals(methodName)) {
								if(Driver.guiUp) {
									View.outputLbl.setText("That method already exists!");
								}
								else {
									System.out.println("That method already exists!");
								}
								return;
							}
						}
					}
					// Given method name is not alphanumeric
					else {
						if(Driver.guiUp) {
							View.outputLbl.setText("A method name must only contain numbers and letters");
						}
						else {
							System.out.println("A method name must only contain numbers and letters");
						}
					}
				}
			}
		}
		// Given class does not exist
		else {
			if(Driver.guiUp) {
				View.outputLbl.setText("That class already exists.");
			}
			else {
				System.out.println("That class does not exist!");
			}
		}
	}

	// Remove an method from the given class
	public static void removeMethod(String className, String methodName) {
		// Given class exists
		if(UML.getNoClassDupes().contains(className)) {
			for(UML uml : UML.getCollection()) {
				if(uml.getClassName().equals(className)) {
					if(!uml.getMethod().isEmpty()) {
						for(int i = 0; i <= uml.getMethod().size(); i++) {
							// Given method exists
							if(i < uml.getMethod().size() && uml.getMethod().get(i).getMethodName().equals(methodName)) {
								uml.getMethod().remove(i);
								if(Driver.guiUp) {
									View.outputLbl.setText("Method Removed!");
								}
								else {
									System.out.println("Method Removed!");
								}
								return;
							}
							// Given method does not exist
							else if(i == uml.getMethod().size()) {
								if(Driver.guiUp) {
									View.outputLbl.setText("That method does not exist!");
								}
								else {
									System.out.println("That method does not exist!");
								}
							}
						}
						return;
					}
					else {
						if(Driver.guiUp) {
							View.outputLbl.setText("This class has no methods!");
						}
						else {
							System.out.println("This class has no methods!");
						}
					}
					return;
				}
			}
		}
		// Given class does not exists
		else {
			if(Driver.guiUp) {
				View.outputLbl.setText("That class does not exist!");
			}
			else {
				System.out.println("That class does not exist!");
			}
		}
	}
	// Remove all methods from the given class
	public static void removeAllMethods(String className) {
		// Given class exists
		if(UML.getNoClassDupes().contains(className)) {
			for(UML uml : UML.getCollection()) {
				if(uml.getClassName().equals(className)) {
					if(uml.getMethod().isEmpty()) {
						if(Driver.guiUp) {
							View.outputLbl.setText("There are no methods to remove.");
						}
						else {
							System.out.println("There are no methods to remove.");
						}
					}
					else {
						uml.getMethod().clear();
						if(Driver.guiUp) {
							View.outputLbl.setText("All methods have been deleted!");
						}
						else {
							System.out.println("All methods have been deleted!");
						}
						return;
					}
				}
			}
		}
		else {
			if(Driver.guiUp) {
				View.outputLbl.setText("That class does not exist!");
			}
			else {
				System.out.println("That class does not exist!");
			}
		}
	}
	// Renames an already existing method in a given class
	public static void renameMethod(String className, String oldName, String newName) {
		// Given class exists
		if(UML.getNoClassDupes().contains(className)) {
			for(UML uml : UML.getCollection()) {
				if(uml.getClassName().equals(className)) {
					// Given method name is alphanumeric
					if(!UML.getPattern().matcher(newName).find()) {
						for(int i = 0; i <= uml.getMethod().size(); i++) {
							if(i < uml.getMethod().size() && uml.getMethod().get(i).getMethodName().equals(oldName)) {
								for(int j = 0; j <= uml.getMethod().size(); j++) {
									if(j == uml.getMethod().size()) {
										uml.getMethod().get(i).setMethodName(newName);
										if(Driver.guiUp) {
											View.outputLbl.setText("Method Renamed!");
										}
										else {
											System.out.println("Method Renamed!");
										}
										return;
									}
									// Given method already exists
									else if(j < uml.getMethod().size() && uml.getMethod().get(j).getMethodName().equals(newName)) {
										if(Driver.guiUp) {
											View.outputLbl.setText("That method already exists!");
										}
										else {
											System.out.println("That method already exists!");
										}
										return;
									}
								}
							}
							// Given method does not exist
							else {
								if(Driver.guiUp) {
									View.outputLbl.setText("That method does not exist!");
								}
								else {
									System.out.println("That method does not exist!");
								}
								return;
							}
						}
					}
					// Given method must be alphanumeric
					else {
						if(Driver.guiUp) {
							View.outputLbl.setText("A method name must only contain numbers and letters");
						}
						else {
							System.out.println("A method name must only contain numbers and letters");
						}
					}
				}
			}
		}
		// Given class does not exist
		else {
			if(Driver.guiUp) {
				View.outputLbl.setText("That class does not exist!");
			}
			else {
				System.out.println("That class does not exist!");
			}
		}
	}
}
