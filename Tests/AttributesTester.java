// import org.junit.Test;
// import static org.junit.Assert.*;

// import java.util.ArrayList;
// import java.util.HashSet;
// import java.util.regex.Pattern;

// /**
//  * Make noClassDupes, noAttributeDupes, collection, and p
//  * public instead of private for testing purposes.
//  */

// public class AttributesTester {

// 	@Test
// 	public void test01_AddAttributes() {
// 		// Create a class
// 		UML uml = UML.addClass("class");

// 		// Add the first attribute
// 		Attributes one = new Attributes("Hello");
// 		UML.addAttribute("class", one);
// 		// True if attribute was added
// 		assertNotNull(one);
// 		// True if one is alphanumeric
// 		assertTrue(!UML.p.matcher(one.getAttributeName()).find());
// 		// True if noAttributeDupes added one and is size 1
// 		assertTrue(UML.noAttributeDupes.contains("Hello"));
// 		assertEquals("noAttributeDupes size is not 1", 1, UML.noAttributeDupes.size());

// 		// Add a second attribute
// 		Attributes two = new Attributes("There");
// 		UML.addAttribute("class", two);
// 		// True if attribute was added
// 		assertNotNull(two);
// 		// True if one is alphanumeric
// 		assertTrue(!UML.p.matcher(two.getAttributeName()).find());
// 		// True if noAttributeDupes added two and is size 2
// 		assertTrue(UML.noAttributeDupes.contains("There"));
// 		assertEquals("noAttributeDupes size is not 2", 2, UML.noAttributeDupes.size());

// 		// Add a third attribute
// 		Attributes three = new Attributes("Dummy");
// 		UML.addAttribute("class", three);
// 		// True if attribute was added
// 		assertNotNull(three);
// 		// True if one is alphanumeric
// 		assertTrue(!UML.p.matcher(three.getAttributeName()).find());
// 		// True if noAttributeDupes added three and is size 3
// 		assertTrue(UML.noAttributeDupes.contains("Dummy"));
// 		assertEquals("noAttributeDupes size is not 3", 3, UML.noAttributeDupes.size());

// 		UML.noClassDupes.clear();
// 		UML.noAttributeDupes.clear();
// 		UML.collection.clear();
// 	}

// 	@Test
// 	public void test02_AddExistingAttributes() {
// 		// Creates class
// 		UML uml = UML.addClass("class");

// 		// Add the first attribute
// 		Attributes one = new Attributes("Hello");
// 		UML.addAttribute("class", one);
// 		// True if attribute was added
// 		assertNotNull(one);
// 		// True if one is alphanumeric
// 		assertTrue(!UML.p.matcher(one.getAttributeName()).find());
// 		// True if noAttributeDupes added one and is size 1
// 		assertTrue(UML.noAttributeDupes.contains("Hello"));
// 		assertEquals("noAttributeDupes size is not 1", 1, UML.noAttributeDupes.size());

// 		// Add the duplicate attribute
// 		Attributes two = new Attributes("Hello");
// 		UML.addAttribute("class", two);

// 		// False when add tries to add name to noAttributeDupes that already exists
// 		assertFalse(UML.noAttributeDupes.add("Hello"));
// 		// True if size is still equal to 1
// 		assertEquals("noAttributeDupes size is not 1", 1, UML.noAttributeDupes.size());

// 		UML.noClassDupes.clear();
// 		UML.noAttributeDupes.clear();
// 		UML.collection.clear();
// 	}

// 	@Test
// 	public void test03_AddNonAlphaAttributes() {
// 		// Creates class
// 		UML uml = UML.addClass("class");

// 		// Add the non-alphanumeric attribute
// 		Attributes one = new Attributes("$H311");
// 		UML.addAttribute("class", one);
// 		// True if one is not alphanumeric
// 		assertFalse(!UML.p.matcher(one.getAttributeName()).find());
// 		// True if noAttributesDupes did not add one and is size 0
// 		assertFalse(UML.noAttributeDupes.contains("$H311"));
// 		assertEquals("noAttributeDupes size is not 0", 0, UML.noAttributeDupes.size());

// 		UML.noClassDupes.clear();
// 		UML.noAttributeDupes.clear();
// 		UML.collection.clear();
// 	}

// 	@Test
// 	public void test04_AddAttributesNonExistingClass() {
// 		int size = UML.collection.size();
// 		// Add the first attribute
// 		Attributes one = new Attributes("Hello");
// 		UML.addAttribute("class", one);

// 		//True if noClassDupes doesn't have this class
// 		assertTrue(!UML.noClassDupes.contains("class"));
// 		//True if noClassDupes size did not change
// 		assertEquals("noClassDupes size is not " + size, UML.noClassDupes.size(), size);

// 		//Searches collection to see if "class" is inside
// 		boolean bool = true;
// 		for (UML element : UML.collection) {
// 			if(element.getName().equals("class")) {
// 				bool = false;
// 				break;
// 			}
// 		}

// 		//True if there was no class with the given name
// 		assertTrue(bool);
// 		//True if collection size did not change
// 		assertEquals("collection size is not " + size, UML.collection.size(), size);

// 		UML.noClassDupes.clear();
// 		UML.noAttributeDupes.clear();
// 		UML.collection.clear();
// 	}

// 	@Test
// 	public void test05_RemoveAttributes() {
// 		// Creates class
// 		UML uml = UML.addClass("class");

// 		// Add the first attribute
// 		Attributes one = new Attributes("Hello");
// 		UML.addAttribute("class", one);
// 		// True if attribute was added
// 		assertNotNull(one);
// 		// True if one is alphanumeric
// 		assertTrue(!UML.p.matcher(one.getAttributeName()).find());
// 		// True if noAttributeDupes added one and is size 1
// 		assertTrue(UML.noAttributeDupes.contains("Hello"));
// 		assertEquals("noAttributeDupes size is not 1", 1, UML.noAttributeDupes.size());

// 		// Remove the attribute
// 		UML.removeAttribute("class", one);
// 		// True if noAttributeDupes removed one and is size 0
// 		assertTrue(!UML.noAttributeDupes.contains("Hello"));
// 		assertEquals("noAttributeDupes size is not 0", 0, UML.noAttributeDupes.size());

// 		UML.noClassDupes.clear();
// 		UML.noAttributeDupes.clear();
// 		UML.collection.clear();
// 	}

// 	@Test
// 	public void test06_RemoveNonExistingAttributes() {
// 		// Creates class
// 		UML uml = UML.addClass("class");
// 		Attributes one = new Attributes("Hello");

// 		// Remove the attribute
// 		UML.removeAttribute("class", one);
// 		// True if noAttributeDupes does not contain one and size is 0
// 		assertTrue(!UML.noAttributeDupes.contains("Hello"));
// 		assertEquals("noAttributeDupes size is not 0", 0, UML.noAttributeDupes.size());

// 		UML.noClassDupes.clear();
// 		UML.noAttributeDupes.clear();
// 		UML.collection.clear();
// 	}

// 	@Test
// 	public void test07_RemoveAttributesNonExistingClass() {
// 		int size = UML.collection.size();
// 		// Add the first attribute
// 		Attributes one = new Attributes("Hello");
// 		UML.removeAttribute("class", one);

// 		//True if noClassDupes doesn't have this class
// 		assertTrue(!UML.noClassDupes.contains("class"));
// 		//True if noClassDupes size did not change
// 		assertEquals("noClassDupes size is not " + size, UML.noClassDupes.size(), size);

// 		//Searches collection to see if "class" is inside
// 		boolean bool = true;
// 		for (UML element : UML.collection) {
// 			if(element.getName().equals("class")) {
// 				bool = false;
// 				break;
// 			}
// 		}

// 		//True if there was no class with the given name
// 		assertTrue(bool);
// 		//True if collection size did not change
// 		assertEquals("collection size is not " + size, UML.collection.size(), size);

// 		UML.noClassDupes.clear();
// 		UML.noAttributeDupes.clear();
// 		UML.collection.clear();
// 	}

// 	@Test
// 	public void test08_RenameAttributes() {
// 		// Creates class
// 		UML uml = UML.addClass("class");
// 		Attributes one = new Attributes("Hello");
// 		Attributes two = new Attributes("There");
// 		UML.addAttribute("class", one);
// 		UML.renameAttribute("class", one, two);

// 		// True if noAttributeDupes added one, renamed it to two, and is size 1
// 		assertTrue(UML.noAttributeDupes.contains("There"));
// 		assertEquals("noAttributeDupes size is not 1", 1, UML.noAttributeDupes.size());

// 		UML.noClassDupes.clear();
// 		UML.noAttributeDupes.clear();
// 		UML.collection.clear();
// 	}

// 	@Test
// 	public void test09_RenameNonExistingAttributes() {
// 		// Creates class
// 		UML uml = UML.addClass("class");
// 		Attributes one = new Attributes("Hello");
// 		Attributes two = new Attributes("There");
// 		UML.renameAttribute("class", one, two);

// 		// True if noAttributeDupes does not contain one and size is 0
// 		assertTrue(!UML.noAttributeDupes.contains("Hello"));
// 		assertEquals("noAttributeDupes size is not 0", 0, UML.noAttributeDupes.size());

// 		UML.noClassDupes.clear();
// 		UML.noAttributeDupes.clear();
// 		UML.collection.clear();
// 	}

// 	@Test
// 	public void test10_RenameAttributesNonExistingClass() {
// 		int size = UML.collection.size();
// 		Attributes one = new Attributes("Hello");
// 		Attributes two = new Attributes("There");
// 		UML.addAttribute("class", one);
// 		UML.renameAttribute("class", one, two);

// 		//True if noClassDupes doesn't have this class
// 		assertTrue(!UML.noClassDupes.contains("class"));
// 		//True if noClassDupes size did not change
// 		assertEquals("noClassDupes size is not " + size, UML.noClassDupes.size(), size);

// 		//Searches collection to see if "class" is inside
// 		boolean bool = true;
// 		for (UML element : UML.collection) {
// 			if(element.getName().equals("class")) {
// 				bool = false;
// 				break;
// 			}
// 		}

// 		//True if there was no class with the given name
// 		assertTrue(bool);
// 		//True if collection size did not change
// 		assertEquals("collection size is not " + size, UML.collection.size(), size);

// 		UML.noClassDupes.clear();
// 		UML.noAttributeDupes.clear();
// 		UML.collection.clear();
// 	}
// }
