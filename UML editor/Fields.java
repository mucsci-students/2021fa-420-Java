
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
		public static void addField (String className, Fields name) {
			// Given class exists
			if (UML.getNoClassDupes().contains(className)) {
				// Given field does not exist, and the name is alphanumeric
				if (!UML.getNoFieldDupes().contains(name.getFieldName()) && !UML.getPattern().matcher(name.getFieldName()).find()) {
					UML.getNoFieldDupes().add(name.getFieldName());
					for (UML uml : UML.getCollection()) {
						if (uml.getClassName().equals(className)) {
							uml.getField().add(name);
							break;
						}
					}
					System.out.println("Field Created!");
				}
				// Given field name is not alphanumeric
				else if (UML.getPattern().matcher(name.getFieldName()).find()) {
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
									return;
								}
							}

							break;
						}
					}
					System.out.println("Field Removed!");
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
		

		// Renames an already existing field in a given class
		public static void renameField(String className, String oldName, String newName) {
			// Given class exist
			if(UML.getNoClassDupes().contains(className)) {
				// Given field does not exist, and the name is alphanumeric
				if(UML.getNoFieldDupes().contains(oldName) && !UML.getPattern().matcher(newName).find()) {
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
