public class Fields {
	private String name;
	private String type;

	public Fields(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public String getFieldName() {
		return name;
	}

	public void setFieldName(String newName) {
		name = newName;
	}

	public String getFieldType() {
		return type;
	}

	public void setFieldType(String newType) {
		type = newType;
	}

	//Adds an field to the given class
	public static void addField(String className, String name, String type) {
		//Given class exists
		if(UML.getNoClassDupes().contains(className)) {
			//Searches for class
			for(UML uml : UML.getCollection()) {
				if(uml.getClassName().equals(className)) {
					//Given field is alphanumeric
					if(!UML.getPattern().matcher(name).find()) {
						for(int i = 0; i <= uml.getField().size(); i++) {
							//Given field does not exist
							if(i == uml.getField().size()) {
								uml.getField().add(new Fields(name, type));
								if(Driver.guiUp) {
									View.outputLbl.setText("Field Created!");
								}
								else {
									System.out.println("Field Created!");
								}
								return;
							}
							//Given field exists
							else if(uml.getField().get(i).getFieldName().equals(name)) {
								if(Driver.guiUp) {
									View.outputLbl.setText("That field already exists!");
								}
								else {
									System.out.println("That field already exists!");
								}
								return;
							}
						}
					}
					//Given field name is not alphanumeric
					else {
						if(Driver.guiUp) {
							View.outputLbl.setText("A field name must only contain numbers and letters");
						}
						else {
							System.out.println("A field name must only contain numbers and letters");
						}
					}
				}
			}
		}
		//Given class does not exist
		else {
			if(Driver.guiUp) {
				View.outputLbl.setText("That class does not exist!");
			}
			else {
				System.out.println("That class does not exist!");
			}
		}
	}

	//Remove an field from the given class
	public static void removeField(String className, String name) {
		//Given class exists
		if(UML.getNoClassDupes().contains(className)) {
			//Searches for class
			for(UML uml : UML.getCollection()) {
				if(uml.getClassName().equals(className)) {
					//Checks if there are fields to remove
					if(!uml.getField().isEmpty()) {
						for(int i = 0; i <= uml.getField().size(); i++) {
							//Given field exists
							if(i < uml.getField().size() && uml.getField().get(i).getFieldName().equals(name)) {
								uml.getField().remove(i);
								if(Driver.guiUp) {
									View.outputLbl.setText("Field Removed!");
								}
								else {
									System.out.println("Field Removed!");
								}
								return;
							}
							//Given field does not exist
							else if(i == uml.getField().size()) {
								if(Driver.guiUp) {
									View.outputLbl.setText("That field does not exist!");
								}
								else {
									System.out.println("That field does not exist!");
								}
							}
						}
						return;
					}
					//No fields to remove
					else {
						if(Driver.guiUp) {
							View.outputLbl.setText("This class has no fields!");
						}
						else {
							System.out.println("This class has no fields!");
						}
					}
				}
			}
		}
		//Given class does not exists
		else {
			if(Driver.guiUp) {
				View.outputLbl.setText("That class does not exist!");
			}
			else {
				System.out.println("That class does not exist!");
			}
		}
	}

	//Renames an already existing field in a given class
	public static void renameField(String className, String oldName, String newName) {
		//Given class exist
		if(UML.getNoClassDupes().contains(className)) {
			//Searches for class
			for(UML uml : UML.getCollection()) {
				if(uml.getClassName().equals(className)) {
					//Given field name is alphanumeric
					if(!UML.getPattern().matcher(newName).find()) {
						//Searches if old field exists
						for(int i = 0; i <= uml.getField().size(); i++) {
							//Old field exists
							if(i < uml.getField().size() && uml.getField().get(i).getFieldName().equals(oldName)) {
								//Searches if new field does not exist
								for(int j = 0; j <= uml.getField().size(); j++) {
									//New field does not exist
									if(j == uml.getField().size()) {
										uml.getField().get(i).setFieldName(newName);
										if(Driver.guiUp) {
											View.outputLbl.setText("Field Renamed!");
										}
										else {
											System.out.println("Field Renamed!");
										}
										return;
									}
									//New field already exists
									else if(j < uml.getField().size() && uml.getField().get(j).getFieldName().equals(newName)) {
										if(Driver.guiUp) {
											View.outputLbl.setText("That field already exists!");
										}
										else {
											System.out.println("That field already exists!");
										}
										return;
									}
								}
							}
							//Old field does not exist
							else {
								if(Driver.guiUp) {
									View.outputLbl.setText("That field does not exist!");
								}
								else {
									System.out.println("That field does not exist!");
								}
								return;
							}
						}
					}
					//New field must be alphanumeric
					else {
						if(Driver.guiUp) {
							View.outputLbl.setText("A field name must only contain numbers and letters");
						}
						else {
							System.out.println("A field name must only contain numbers and letters");
						}
					}
				}
			}
		}
		//Given class does not exist
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