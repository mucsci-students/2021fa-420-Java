// package uml;
// import static org.junit.Assert.*;
// import org.junit.FixMethodOrder;
// import org.junit.Test;
// import org.junit.runners.MethodSorters;

// @FixMethodOrder(MethodSorters.NAME_ASCENDING)
// public class FieldTester {

// 	@Test
// 	public void test01_AddField() {
// 		// Create a class
// 		UML uml = UML.addClass("class");

// 		// Add the first Field
// 		Fields one = new Fields("Hello", "String");
// 		Fields.addField("class", "Hello", "String");
// 		// True if Field was added
// 		assertNotNull(one);
// 		// True if one is alphanumeric
// 		assertTrue(!UML.getPattern().matcher(one.getFieldName()).find());
// 		// True if Fields added one and is size 1
// 		for (Fields field : uml.getField()) {
// 			if (field.getFieldName().equals("Hello")) {
// 				assertTrue(field.getFieldName().contains("Hello"));
// 			}
// 		}
// 		assertEquals("Fields size is not 1", 1, uml.getField().size());

// 		// Add a second Field
// 		Fields two = new Fields("There", "String");
// 		Fields.addField("class", "There", "String");
// 		// True if Field was added
// 		assertNotNull(two);
// 		// True if one is alphanumeric
// 		assertTrue(!UML.getPattern().matcher(two.getFieldName()).find());
// 		// True if Fields added two and is size 2
// 		for (Fields field : uml.getField()) {
// 			if (field.getFieldName().equals("There")) {
// 				assertTrue(field.getFieldName().contains("There"));
// 			}
// 		}
// 		assertEquals("Fields size is not 2", 2, uml.getField().size());

// 		// Add a third Field
// 		Fields three = new Fields("Dummy", "String");
// 		Fields.addField("class", "Dummy", "String");
// 		// True if Field was added
// 		assertNotNull(three);
// 		// True if one is alphanumeric
// 		assertTrue(!UML.getPattern().matcher(three.getFieldName()).find());
// 		// True if Fields added three and is size 3
// 		for (Fields field : uml.getField()) {
// 			if (field.getFieldName().equals("Dummy")) {
// 				assertTrue(field.getFieldName().contains("Dummy"));
// 			}
// 		}
// 		assertEquals("Fields size is not 3", 3, uml.getField().size());

// 		UML.getNoClassDupes().clear();
// 		UML.clearCollection();
// 	}

// 	@Test
// 	public void test02_AddExistingField() {
// 		// Creates class
// 		UML uml = UML.addClass("class");

// 		// Add the first Field
// 		Fields one = new Fields("Hello", "String");
// 		Fields.addField("class", "Hello", "String");
// 		// True if Field was added
// 		assertNotNull(one);
// 		// True if one is alphanumeric
// 		assertTrue(!UML.getPattern().matcher(one.getFieldName()).find());
// 		// True if Fields added one and is size 1
// 		for (Fields field : uml.getField()) {
// 			if (field.getFieldName().equals("Hello")) {
// 				assertTrue(field.getFieldName().contains("Hello"));
// 			}
// 		}
// 		assertEquals("Fields size is not 1", 1, uml.getField().size());

// 		// Add the duplicate Field
// 		Fields.addField("class", "Hello", "String");

// 		// False when add tries to add name to Fields that already exists
// 		for (Fields field : uml.getField()) {
// 			if (field.getFieldName().equals("Hello")) {
// 				assertFalse(!field.getFieldName().contains("Hello"));
// 			}
// 		}
// 		// True if size is still equal to 1
// 		assertEquals("Fields size is not 1", 1, uml.getField().size());

// 		UML.getNoClassDupes().clear();
// 		UML.clearCollection();
// 	}

// 	@Test
// 	public void test03_AddNonAlphaField() {
// 		// Creates class
// 		UML uml = UML.addClass("class");

// 		// Add the non-alphanumeric Field
// 		Fields one = new Fields("$H311", "String");
// 		Fields.addField("class", "$H311", "String");
// 		// True if one is not alphanumeric
// 		assertFalse(!UML.getPattern().matcher(one.getFieldName()).find());
// 		// True if noFieldsDupes did not add one and is size 0
// 		for (Fields field : uml.getField()) {
// 			if (!field.getFieldName().equals("$H311")) {
// 				assertFalse(field.getFieldName().contains("$H311"));
// 			}
// 		}
// 		assertEquals("Fields size is not 0", 0, uml.getField().size());

// 		UML.getNoClassDupes().clear();
// 		UML.clearCollection();
// 	}

// 	@Test
// 	public void test04_AddFieldNonExistingClass() {
// 		int size = UML.getCollection().size();
// 		// Add the first Field
// 		Fields.addField("class", "Hello", "String");

// 		//True if noClassDupes doesn't have this class
// 		assertTrue(!UML.getNoClassDupes().contains("class"));
// 		//True if noClassDupes size did not change
// 		assertEquals("noClassDupes size is not " + size, UML.getNoClassDupes().size(), size);

// 		//Searches collection to see if "class" is inside
// 		boolean bool = true;
// 		for (UML element : UML.getCollection()) {
// 			if(element.getClassName().equals("class")) {
// 				bool = false;
// 				break;
// 			}
// 		}

// 		//True if there was no class with the given name
// 		assertTrue(bool);
// 		//True if collection size did not change
// 		assertEquals("collection size is not " + size, UML.getCollection().size(), size);

// 		UML.getNoClassDupes().clear();
// 		UML.clearCollection();
// 	}

// 	@Test
// 	public void test05_RemoveField() {
// 		// Creates class
// 		UML uml = UML.addClass("class");

// 		// Add the first Field
// 		Fields one = new Fields("Hello", "String");
// 		Fields.addField("class", "Hello", "String");
// 		// True if Field was added
// 		assertNotNull(one);
// 		// True if one is alphanumeric
// 		assertTrue(!UML.getPattern().matcher(one.getFieldName()).find());
// 		// True if Fields added one and is size 1
// 		for (Fields field : uml.getField()) {
// 			if (field.getFieldName().equals("Hello")) {
// 				assertTrue(field.getFieldName().contains("Hello"));
// 			}
// 		}
// 		assertEquals("Fields size is not 1", 1, uml.getField().size());

// 		// Remove the Field
// 		Fields.removeField("class", "Hello");
// 		// True if Fields removed one and is size 0
// 		for (Fields field : uml.getField()) {
// 			if (!field.getFieldName().equals("Hello")) {
// 				assertTrue(!field.getFieldName().contains("Hello"));
// 			}
// 		}
// 		assertEquals("Fields size is not 0", 0, uml.getField().size());

// 		UML.getNoClassDupes().clear();
// 		UML.clearCollection();
// 	}

// 	@Test
// 	public void test06_RemoveNonExistingField() {
// 		// Creates class
// 		UML uml = UML.addClass("class");

// 		// Remove the Field
// 		Fields.removeField("class", "Hello");
// 		// True if Fields does not contain one and size is 0
// 		for (Fields field : uml.getField()) {
// 			if (!field.getFieldName().equals("Hello")) {
// 				assertTrue(!field.getFieldName().contains("Hello"));
// 			}
// 		}
// 		assertEquals("Fields size is not 0", 0, uml.getField().size());

// 		UML.getNoClassDupes().clear();
// 		UML.clearCollection();
// 	}

// 	@Test
// 	public void test07_RemoveFieldNonExistingClass() {
// 		int size = UML.getCollection().size();
// 		// Add the first Field
// 		Fields.removeField("class", "Hello");

// 		//True if noClassDupes doesn't have this class
// 		assertTrue(!UML.getNoClassDupes().contains("class"));
// 		//True if noClassDupes size did not change
// 		assertEquals("noClassDupes size is not " + size, UML.getNoClassDupes().size(), size);

// 		//Searches collection to see if "class" is inside
// 		boolean bool = true;
// 		for (UML element : UML.getCollection()) {
// 			if(element.getClassName().equals("class")) {
// 				bool = false;
// 				break;
// 			}
// 		}

// 		//True if there was no class with the given name
// 		assertTrue(bool);
// 		//True if collection size did not change
// 		assertEquals("collection size is not " + size, UML.getCollection().size(), size);

// 		UML.getNoClassDupes().clear();
// 		UML.clearCollection();
// 	}

// 	@Test
// 	public void test08_RenameField() {
// 		// Creates class
// 		UML uml = UML.addClass("class");
// 		Fields.addField("class", "Hello", "String");
// 		Fields.renameField("class", "Hello", "There");

// 		// True if Fields added one, renamed it to two, and is size 1
// 		for (Fields field : uml.getField()) {
// 			if (field.getFieldName().equals("There")) {
// 				assertTrue(field.getFieldName().contains("There"));
// 			}
// 		}
// 		assertEquals("Fields size is not 1", 1, uml.getField().size());

// 		UML.getNoClassDupes().clear();
// 		UML.clearCollection();
// 	}

// 	@Test
// 	public void test09_RenameNonExistingField() {
// 		// Creates class
// 		UML uml = UML.addClass("class");
// 		Fields.renameField("class", "Hello", "There");

// 		// True if Fields does not contain one and size is 0
// 		for (Fields field : uml.getField()) {
// 			if (!field.getFieldName().equals("Hello")) {
// 				assertTrue(!field.getFieldName().contains("Hello"));
// 			}
// 		}
// 		assertEquals("Fields size is not 0", 0, uml.getField().size());

// 		UML.getNoClassDupes().clear();
// 		UML.clearCollection();
// 	}

// 	@Test
// 	public void test10_RenameFieldNonExistingClass() {
// 		int size = UML.getCollection().size();
// 		Fields.addField("class", "Hello", "String");
// 		Fields.renameField("class", "Hello", "There");

// 		//True if noClassDupes doesn't have this class
// 		assertTrue(!UML.getNoClassDupes().contains("class"));
// 		//True if noClassDupes size did not change
// 		assertEquals("noClassDupes size is not " + size, UML.getNoClassDupes().size(), size);

// 		//Searches collection to see if "class" is inside
// 		boolean bool = true;
// 		for (UML element : UML.getCollection()) {
// 			if(element.getClassName().equals("class")) {
// 				bool = false;
// 				break;
// 			}
// 		}

// 		//True if there was no class with the given name
// 		assertTrue(bool);
// 		//True if collection size did not change
// 		assertEquals("collection size is not " + size, UML.getCollection().size(), size);

// 		UML.getNoClassDupes().clear();
// 		UML.clearCollection();
// 	}
// }
