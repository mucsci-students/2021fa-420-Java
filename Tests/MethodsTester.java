import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MethodsTester {

	@Test
	public void test01_AddMethod() {
		// Create a class
		UML uml = UML.addClass("class");

		// Add the first Method
		Methods one = new Methods("Hello", "String");
		Methods.addMethod("class", "Hello", "String");
		// True if Method was added
		assertNotNull(one);
		// True if one is alphanumeric
		assertTrue(!UML.getPattern().matcher(one.getMethodName()).find());
		// True if Methods added one and is size 1
		for (Methods Method : uml.getMethod()) {
			if (Method.getMethodName().equals("Hello")) {
				assertTrue(Method.getMethodName().contains("Hello"));
			}
		}
		assertEquals("Methods size is not 1", 1, uml.getMethod().size());

		// Add a second Method
		Methods two = new Methods("There", "String");
		Methods.addMethod("class", "There", "String");
		// True if Method was added
		assertNotNull(two);
		// True if one is alphanumeric
		assertTrue(!UML.getPattern().matcher(two.getMethodName()).find());
		// True if Methods added two and is size 2
		for (Methods Method : uml.getMethod()) {
			if (Method.getMethodName().equals("There")) {
				assertTrue(Method.getMethodName().contains("There"));
			}
		}
		assertEquals("Methods size is not 2", 2, uml.getMethod().size());

		// Add a third Method
		Methods three = new Methods("Dummy", "String");
		Methods.addMethod("class", "Dummy", "String");
		// True if Method was added
		assertNotNull(three);
		// True if one is alphanumeric
		assertTrue(!UML.getPattern().matcher(three.getMethodName()).find());
		// True if Methods added three and is size 3
		for (Methods Method : uml.getMethod()) {
			if (Method.getMethodName().equals("Dummy")) {
				assertTrue(Method.getMethodName().contains("Dummy"));
			}
		}
		assertEquals("Methods size is not 3", 3, uml.getMethod().size());

		UML.getNoClassDupes().clear();
		UML.clearCollection();
	}

	@Test
	public void test02_AddExistingMethod() {
		// Creates class
		UML uml = UML.addClass("class");

		// Add the first Method
		Methods one = new Methods("Hello", "String");
		Methods.addMethod("class", "Hello", "String");
		// True if Method was added
		assertNotNull(one);
		// True if one is alphanumeric
		assertTrue(!UML.getPattern().matcher(one.getMethodName()).find());
		// True if Methods added one and is size 1
		for (Methods Method : uml.getMethod()) {
			if (Method.getMethodName().equals("Hello")) {
				assertTrue(Method.getMethodName().contains("Hello"));
			}
		}
		assertEquals("Methods size is not 1", 1, uml.getMethod().size());

		// Add the duplicate Method
		Methods.addMethod("class", "Hello", "String");

		// False when add tries to add name to Methods that already exists
		for (Methods Method : uml.getMethod()) {
			if (Method.getMethodName().equals("Hello")) {
				assertFalse(!Method.getMethodName().contains("Hello"));
			}
		}
		// True if size is still equal to 1
		assertEquals("Methods size is not 1", 1, uml.getMethod().size());

		UML.getNoClassDupes().clear();
		UML.clearCollection();
	}

	@Test
	public void test03_AddNonAlphaMethod() {
		// Creates class
		UML uml = UML.addClass("class");

		// Add the non-alphanumeric Method
		Methods one = new Methods("$H311", "String");
		Methods.addMethod("class", "$H311", "String");
		// True if one is not alphanumeric
		assertFalse(!UML.getPattern().matcher(one.getMethodName()).find());
		// True if noMethodsDupes did not add one and is size 0
		for (Methods Method : uml.getMethod()) {
			if (!Method.getMethodName().equals("$H311")) {
				assertFalse(Method.getMethodName().contains("$H311"));
			}
		}
		assertEquals("Methods size is not 0", 0, uml.getMethod().size());

		UML.getNoClassDupes().clear();
		UML.clearCollection();
	}

	@Test
	public void test04_AddMethodNonExistingClass() {
		int size = UML.getCollection().size();
		// Add the first Method
		Methods.addMethod("class", "Hello", "String");

		//True if noClassDupes doesn't have this class
		assertTrue(!UML.getNoClassDupes().contains("class"));
		//True if noClassDupes size did not change
		assertEquals("noClassDupes size is not " + size, UML.getNoClassDupes().size(), size);

		//Searches collection to see if "class" is inside
		boolean bool = true;
		for (UML element : UML.getCollection()) {
			if(element.getClassName().equals("class")) {
				bool = false;
				break;
			}
		}

		//True if there was no class with the given name
		assertTrue(bool);
		//True if collection size did not change
		assertEquals("collection size is not " + size, UML.getCollection().size(), size);

		UML.getNoClassDupes().clear();
		UML.clearCollection();
	}

	@Test
	public void test05_RemoveMethod() {
		// Creates class
		UML uml = UML.addClass("class");

		// Add the first Method
		Methods one = new Methods("Hello", "String");
		Methods.addMethod("class", "Hello", "String");
		// True if Method was added
		assertNotNull(one);
		// True if one is alphanumeric
		assertTrue(!UML.getPattern().matcher(one.getMethodName()).find());
		// True if Methods added one and is size 1
		for (Methods Method : uml.getMethod()) {
			if (Method.getMethodName().equals("Hello")) {
				assertTrue(Method.getMethodName().contains("Hello"));
			}
		}
		assertEquals("Methods size is not 1", 1, uml.getMethod().size());

		// Remove the Method
		Methods.removeMethod("class", "Hello");
		// True if Methods removed one and is size 0
		for (Methods Method : uml.getMethod()) {
			if (!Method.getMethodName().equals("Hello")) {
				assertTrue(!Method.getMethodName().contains("Hello"));
			}
		}
		assertEquals("Methods size is not 0", 0, uml.getMethod().size());

		UML.getNoClassDupes().clear();
		UML.clearCollection();
	}

	@Test
	public void test06_RemoveNonExistingMethod() {
		// Creates class
		UML uml = UML.addClass("class");

		// Remove the Method
		Methods.removeMethod("class", "Hello");
		// True if Methods does not contain one and size is 0
		for (Methods Method : uml.getMethod()) {
			if (!Method.getMethodName().equals("Hello")) {
				assertTrue(!Method.getMethodName().contains("Hello"));
			}
		}
		assertEquals("Methods size is not 0", 0, uml.getMethod().size());

		UML.getNoClassDupes().clear();
		UML.clearCollection();
	}

	@Test
	public void test07_RemoveMethodNonExistingClass() {
		int size = UML.getCollection().size();
		// Add the first Method
		Methods.removeMethod("class", "Hello");

		//True if noClassDupes doesn't have this class
		assertTrue(!UML.getNoClassDupes().contains("class"));
		//True if noClassDupes size did not change
		assertEquals("noClassDupes size is not " + size, UML.getNoClassDupes().size(), size);

		//Searches collection to see if "class" is inside
		boolean bool = true;
		for (UML element : UML.getCollection()) {
			if(element.getClassName().equals("class")) {
				bool = false;
				break;
			}
		}

		//True if there was no class with the given name
		assertTrue(bool);
		//True if collection size did not change
		assertEquals("collection size is not " + size, UML.getCollection().size(), size);

		UML.getNoClassDupes().clear();
		UML.clearCollection();
	}

	@Test
	public void test08_RenameMethod() {
		// Creates class
		UML uml = UML.addClass("class");
		Methods.addMethod("class", "Hello", "String");
		Methods.renameMethod("class", "Hello", "There");

		// True if Methods added one, renamed it to two, and is size 1
		for (Methods Method : uml.getMethod()) {
			if (Method.getMethodName().equals("There")) {
				assertTrue(Method.getMethodName().contains("There"));
			}
		}
		assertEquals("Methods size is not 1", 1, uml.getMethod().size());

		UML.getNoClassDupes().clear();
		UML.clearCollection();
	}

	@Test
	public void test09_RenameNonExistingMethod() {
		// Creates class
		UML uml = UML.addClass("class");
		Methods.renameMethod("class", "Hello", "There");

		// True if Methods does not contain one and size is 0
		for (Methods Method : uml.getMethod()) {
			if (!Method.getMethodName().equals("Hello")) {
				assertTrue(!Method.getMethodName().contains("Hello"));
			}
		}
		assertEquals("Methods size is not 0", 0, uml.getMethod().size());

		UML.getNoClassDupes().clear();
		UML.clearCollection();
	}

	@Test
	public void test10_RenameMethodNonExistingClass() {
		int size = UML.getCollection().size();
		Methods.addMethod("class", "Hello", "String");
		Methods.renameMethod("class", "Hello", "There");

		//True if noClassDupes doesn't have this class
		assertTrue(!UML.getNoClassDupes().contains("class"));
		//True if noClassDupes size did not change
		assertEquals("noClassDupes size is not " + size, UML.getNoClassDupes().size(), size);

		//Searches collection to see if "class" is inside
		boolean bool = true;
		for (UML element : UML.getCollection()) {
			if(element.getClassName().equals("class")) {
				bool = false;
				break;
			}
		}

		//True if there was no class with the given name
		assertTrue(bool);
		//True if collection size did not change
		assertEquals("collection size is not " + size, UML.getCollection().size(), size);

		UML.getNoClassDupes().clear();
		UML.clearCollection();
	}

	@Test
	public void test11_RemoveAllMethods() {
		// Creates class
		UML uml = UML.addClass("class");

		// Add the first Method
		Methods one = new Methods("Hello", "String");
		Methods.addMethod("class", "Hello", "String");
		// True if Method was added
		assertNotNull(one);
		// True if one is alphanumeric
		assertTrue(!UML.getPattern().matcher(one.getMethodName()).find());
		// True if Methods added one and is size 1
		for (Methods Method : uml.getMethod()) {
			if (Method.getMethodName().equals("Hello")) {
				assertTrue(Method.getMethodName().contains("Hello"));
			}
		}
		assertEquals("Methods size is not 1", 1, uml.getMethod().size());

		// Remove the Method
		Methods.removeAllMethods("class");
		assertEquals("Methods size is not 0", 0, uml.getMethod().size());

		UML.getNoClassDupes().clear();
		UML.clearCollection();
	}
}