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
		public static void addField (String className, String name, String type) {
			// Given class exists
			if (UML.getNoClassDupes().contains(className)) {
				// Given field does not exist, and the name is alphanumeric
				if (!UML.getNoFieldDupes().contains(name) && !UML.getPattern().matcher(name).find()) {
					UML.getNoFieldDupes().add(name);
					for (UML uml : UML.getCollection()) {
						if (uml.getClassName().equals(className)) {
							uml.getField().add(new Fields(name, type));
							break;
						}
					}
					System.out.println("Field Created!");
				}
				// Given field name is not alphanumeric
				else if (UML.getPattern().matcher(name).find()) {
					System.out.println("A field name must only contain numbers and letters");
				}
				// Given field exists
				else {
					System.out.println("That field ALREADY exist!");
				}
			}
			// Given class does not exist
			else {
				System.out.println("That class does NOT exist!");
			}
		}

		// Remove an field from the given class
		public static void removeField(String className, String name) {
			// Given class exists
			if (UML.getNoClassDupes().contains(className)) {
				// Given field exists
				if (UML.getNoFieldDupes().contains(name)) {
					for (UML uml : UML.getCollection()) {
						if (uml.getClassName().equals(className)) {
							for(Fields field : uml.getField()){
								if(field.getFieldName().equals(name)){
									int remove = uml.getField().indexOf(field);
									uml.getField().remove(remove);
									UML.getNoFieldDupes().remove(name);
									System.out.println("Field Removed!");
									return;
								}
							}
							break;
						}
					}
				}
				// Given field does not exist
				else {
					System.out.println("That field does not exist!");
				}
			}
			// Given class does not exists
			else {
				System.out.println("That class does not exist!");
			}
		}
		
		// Remove all the fields in the UML
		public static void removeAllFields() {
			// The UML is empty
			if (UML.getCollection().isEmpty()) {
				System.out.println("The UML is empty!");
			}
			// The UML has no fields
			else if (UML.getNoFieldDupes().isEmpty()) {
				System.out.println("There are no fields to remove.");
			}
			// Go through each class in the UML and remove every field
			else {
				UML.getNoFieldDupes().clear();
				for (UML uml : UML.getCollection()) {
					uml.getField().clear();
				}
				System.out.println("All fields have been deleted!");
			}
		}
		

		// Renames an already existing field in a given class
		public static void renameField(String className, String oldName, String newName) {
			// Given class exist
			if(UML.getNoClassDupes().contains(className)) {
				// Given new field does not exist, the old field does exist, and the new name is alphanumeric
				if(UML.getNoFieldDupes().contains(oldName) && !UML.getNoFieldDupes().contains(newName) && !UML.getPattern().matcher(newName).find()) {
					for(int i = 0; i < UML.getCollection().size(); i++) {
						UML uml = UML.getCollection().get(i);
						if(uml.getClassName().equals(className)) {
							UML.getNoFieldDupes().remove(oldName);
							UML.getNoFieldDupes().add(newName);
							for(Fields field : uml.getField()) {
								field.setFieldName(newName);
							}
							break;
						}
					}
					System.out.println("Field Renamed!");
				}
				// Given field must be alphanumeric
				else if (UML.getPattern().matcher(newName).find()) {
					System.out.println("A field name must only contain numbers and letters");
				}
				// Given newName already exists as a field
				else if (UML.getNoFieldDupes().contains(newName)) {
					System.out.println("That name is already taken by another field in the class!");
				}
				// Given field does not exist
				else {
					System.out.println("That field does not exist!");
				}
			}
			// Given class does not exist
			else {
				System.out.println("That class does not exist!");
			}
		}
}
