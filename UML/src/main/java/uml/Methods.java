package uml;

import java.util.ArrayList;


import javax.swing.JOptionPane;

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

	//Adds an method to the given class
	public static void addMethod(String className, String methodName, String retType) {
		//Given class exists
		if(UML.getNoClassDupes().contains(className)) {
			//Searches for class
			for(UML uml : UML.getCollection()) {
				if(uml.getClassName().equals(className)) {
					//Given method is alphanumeric
					if(!UML.getPattern().matcher(methodName).find()) {
						for(int i = 0; i <= uml.getMethod().size(); i++) {
							//Given method does not exist
							if(i == uml.getMethod().size()) {
								uml.getMethod().add(new Methods(methodName, retType));

								for(BoxObject obj : UML.getJLabels()) {
									if(obj.getJLabelName().equals(uml.getClassName())) {
										View.updateBox(obj);
									}
								}

								if(!Driver.guiUp) {
									System.out.println("Method Created!");
								}
								return;
							}
							//Given method exists
							else if(uml.getMethod().get(i).getMethodName().equals(methodName) && (uml.getMethod().get(i).getParams().isEmpty())) {
								if(Driver.guiUp) {
									JOptionPane.showMessageDialog(View.frmUmlEditor, "That method already exists!", "Error", JOptionPane.ERROR_MESSAGE);
								}
								else {
									System.out.println("That method already exists!");
								}
								return;
							}
						}
					}
					//Given method name is not alphanumeric
					else {
						if(Driver.guiUp) {
							JOptionPane.showMessageDialog(View.frmUmlEditor, "A method name must only contain numbers and letters", "Error", JOptionPane.ERROR_MESSAGE);
						}
						else {
							System.out.println("A method name must only contain numbers and letters");
						}
					}
				}
			}
		}
		//Given class does not exist
		else {
			if(Driver.guiUp) {
				JOptionPane.showMessageDialog(View.frmUmlEditor, "That class already exists.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				System.out.println("That class does not exist!");
			}
		}
	}

	//Remove an method from the given class
	public static void removeMethod(String className, String methodName) {
		//Given class exists
		if(UML.getNoClassDupes().contains(className)) {
			//Searches for class
			for(UML uml : UML.getCollection()) {
				if(uml.getClassName().equals(className)) {
					//Checks if there are methods to remove
					if(!uml.getMethod().isEmpty()) {
						for(int i = 0; i <= uml.getMethod().size(); i++) {
							//Given method exists
							if(i < uml.getMethod().size() && uml.getMethod().get(i).getMethodName().equals(methodName)) {
								uml.getMethod().remove(i);

								for(BoxObject obj : UML.getJLabels()) {
									if(obj.getJLabelName().equals(uml.getClassName())) {
										View.updateBox(obj);
									}
								}

								if(Driver.guiUp) {
									System.out.println("Method Removed!");
								}
								return;
							}
							//Given method does not exist
							else if(i == uml.getMethod().size()) {
								if(Driver.guiUp) {

									JOptionPane.showMessageDialog(View.frmUmlEditor, "That method does not exist!", "Error", JOptionPane.ERROR_MESSAGE);

								}
								else {
									System.out.println("That method does not exist!");
								}
							}
						}
						return;
					}
					//No methods to remove
					else {
						if(Driver.guiUp) {
							JOptionPane.showMessageDialog(View.frmUmlEditor, "This class has no methods!", "Error", JOptionPane.ERROR_MESSAGE);

						}
						else {
							System.out.println("This class has no methods!");
						}
					}
				}
			}
		}
		//Given class does not exists
		else {
			if(Driver.guiUp) {
				JOptionPane.showMessageDialog(View.frmUmlEditor, "That class does not exist!", "Error", JOptionPane.ERROR_MESSAGE);

			}
			else {
				System.out.println("That class does not exist!");
			}
		}
	}
	//Remove all methods from the given class
	public static void removeAllMethods(String className) {
		//Given class exists
		if(UML.getNoClassDupes().contains(className)) {
			//Searches for class
			for(UML uml : UML.getCollection()) {
				if(uml.getClassName().equals(className)) {
					//If there are no methods
					if(uml.getMethod().isEmpty()) {
						if(Driver.guiUp) {
							JOptionPane.showMessageDialog(View.frmUmlEditor, "There are no methods to remove.", "Error", JOptionPane.ERROR_MESSAGE);
						}
						else {
							System.out.println("There are no methods to remove.");
						}
					}
					//If there are methods
					else {
						//Deletes all methods
						uml.getMethod().clear();

						for(BoxObject obj : UML.getJLabels()) {
							if(obj.getJLabelName().equals(uml.getClassName())) {
								View.updateBox(obj);
							}
						}

						if(!Driver.guiUp) {
							System.out.println("All methods have been deleted!");
						}
						return;
					}
				}
			}
		}
		//Given class does not exist
		else {
			if(Driver.guiUp) {
				JOptionPane.showMessageDialog(View.frmUmlEditor, "That class does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				System.out.println("That class does not exist!");
			}
		}
	}

	//Renames an already existing method in a given class
	public static void renameMethod(String className, String oldName, String newName) {

		ArrayList<Parameters> oldParameters = MethodOverloading.locatingParameters(className, newName);
		//Given class exists
		if(UML.getNoClassDupes().contains(className)) {
			//Searches for class
			for(UML uml : UML.getCollection()) {
				if(uml.getClassName().equals(className)) {
					//Given method name is alphanumeric
					if(!UML.getPattern().matcher(newName).find()) {
						//Searches if old method exists
						for(int i = 0; i <= uml.getMethod().size(); i++) {
							//Old method exists
							if(i < uml.getMethod().size() && uml.getMethod().get(i).getMethodName().equals(oldName)) {
								//Searches if new method does not exist
								for(int j = 0; j <= uml.getMethod().size(); j++) {
									//New method does not exist
									if(j == uml.getMethod().size()) {
										uml.getMethod().get(i).setMethodName(newName);

										for(BoxObject obj : UML.getJLabels()) {
											if(obj.getJLabelName().equals(uml.getClassName())) {
												View.updateBox(obj);
											}
										}

										if(!Driver.guiUp) {

											System.out.println("Method Renamed!");
										}
										return;
									}
									//New method already exists
									else if(j < uml.getMethod().size() && uml.getMethod().get(j).getMethodName().equals(newName) && (MethodOverloading.compareParams(uml.getMethod().get(j).getParams(),oldParameters, "hi"))) {
										if(Driver.guiUp) {
											JOptionPane.showMessageDialog(View.frmUmlEditor, "That method with that signature already exists!", "Error", JOptionPane.ERROR_MESSAGE);
										}
										else {
											System.out.println("That method already exists!");
										}
										return;
									}
								}
							}
							//Old method does not exist
							else {
								if(Driver.guiUp) {
									JOptionPane.showMessageDialog(View.frmUmlEditor, "That method does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
								}
								else {
									System.out.println("That method does not exist!");
								}
								return;
							}
						}
					}
					//New method must be alphanumeric
					else {
						if(Driver.guiUp) {
							JOptionPane.showMessageDialog(View.frmUmlEditor, "A method name must only contain numbers and letters", "Error", JOptionPane.ERROR_MESSAGE);
						}
						else {
							System.out.println("A method name must only contain numbers and letters");
						}
					}
				}
			}
		}
		//Given class does not exist
		else {
			if(Driver.guiUp) {
				JOptionPane.showMessageDialog(View.frmUmlEditor, "That class does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				System.out.println("That class does not exist!");
			}
		}
	}
}