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

	// Adds an field to the given class
	public static void addField(String className, String name, String type) {
		// Given class exists
		if(UML.getNoClassDupes().contains(className)) {
			for(UML uml : UML.getCollection()) {
				if(uml.getClassName().equals(className)) {
					if(!UML.getPattern().matcher(name).find()) {
						for(int i = 0; i <= uml.getField().size(); i++) {
							// Given field does not exist, and the name is alphanumeric
							if(i + 1 > uml.getField().size()) {
								uml.getField().add(new Fields(name, type));
								System.out.println("Field Created!");
								return;
							}
							// Given field exists
							else if(i < uml.getField().size() && uml.getField().get(i).getFieldName().equals(name)) {
								System.out.println("That field already exists!");
								return;
							}
						}
					}
					// Given field name is not alphanumeric
					else {
						System.out.println("A field name must only contain numbers and letters");
					}
				}
			}
		}
		// Given class does not exist
		else {
			System.out.println("That class does not exist!");
		}
	}

	// Remove an field from the given class
	public static void removeField(String className, String name) {
		// Given class exists
		if(UML.getNoClassDupes().contains(className)) {
			for(UML uml : UML.getCollection()) {
				if(uml.getClassName().equals(className)) {
					for(int i = 0; i <= uml.getField().size(); i++) {
						// Given field exists
						if(i < uml.getField().size() && uml.getField().get(i).getFieldName().equals(name)) {
							uml.getField().remove(i);
							System.out.println("Field Removed!");
							return;
						}
						// Given field does not exist
						else if(i == uml.getField().size()) {
							System.out.println("That field does not exist!");
						}
					}
					return;
				}
			}
		}
		// Given class does not exists
		else {
			System.out.println("That class does not exist!");
		}
	}

	// Renames an already existing field in a given class
	public static void renameField(String className, String oldName, String newName) {
		// Given class exist
		if(UML.getNoClassDupes().contains(className)) {
			for(UML uml : UML.getCollection()) {
				if(uml.getClassName().equals(className)) {
					// Given field name is alphanumeric
					if(!UML.getPattern().matcher(newName).find()) {
						for(int i = 0; i <= uml.getField().size(); i++) {
							if(i < uml.getField().size() && uml.getField().get(i).getFieldName().equals(oldName)) {
								for(int j = 0; j <= uml.getField().size(); j++) {
									if(i == uml.getField().size()) {
										uml.getField().get(i).setFieldName(newName);
										System.out.println("Field Renamed!");
										return;
									}
									// Given field already exists
									else if(j < uml.getField().size() && uml.getField().get(j).getFieldName().equals(newName)) {
										System.out.println("That field already exists!");
										return;
									}
								}
							}
							// Given field does not exist
							else {
								System.out.println("That field does not exist!");
								return;
							}
						}
					}
					// Given field must be alphanumeric
					else {
						System.out.println("A field name must only contain numbers and letters");
					}
				}
			}
		}
		// Given class does not exist
		else {
			System.out.println("That class does not exist!");
		}
	}
}