package uml;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class addDeleteRenameTests {

	/**
	 * Make global variables attr, rels, noClassDupes, collection, and p public for
	 * using these tests
	 */

	@Test
	public void test01_Constructor() {
		UML uml = new UML("class", 0, 0);
		// True if constructor stored the correct name
		assertEquals("New class had wrong name.", "class", uml.getClassName());
		// True if attribute arraylist is empty on uml creation
		assertEquals("New class attribute arraylist had wrong size.", 0, uml.getField().size());
		// True if relationship arraylist is empty on uml creation
		assertEquals("New class relationship arraylist had wrong size.", 0, uml.getRels().size());
		Model.getNoClassDupes().clear();
		Model.getCollection().clear();
	}
	

	@Test
	public void test02_AddThreeClasses() {
		// Adding 1 class
		UML uml = UML.addClass("class");
		// If uml is not null, class was added
		assertNotNull(uml);
		// True if name is alphanumeric
		assertTrue(!UML.getPattern().matcher("class").find());
		// True if noClassDupes added uml name "class" and size is 1
		assertTrue(Model.getNoClassDupes().contains(uml.getClassName()));
		assertEquals("noClassDupes size is not 1", 1, Model.getNoClassDupes().size());
		// True if collection added uml and size is 1
		assertTrue(Model.getCollection().contains(uml));
		assertEquals("collection size is not 1", 1, Model.getCollection().size());
		// Adding a second class
		uml = UML.addClass("class1");
		// If uml is not null, class was added
		assertNotNull(uml);
		// True if name is alphanumeric
		assertTrue(!UML.getPattern().matcher("class1").find());
		// True if noClassDupes added uml name "class1" and size is 2
		assertTrue(Model.getNoClassDupes().contains("class1"));
		assertEquals("noClassDupes size is not 2", 2, Model.getNoClassDupes().size());
		// True if collection added uml and size is 2
		assertTrue(Model.getCollection().contains(uml));
		assertEquals("collection size is not 2", 2, Model.getCollection().size());
		// Adding a third class but as if the user added spaces
		String name = "this is a class";
		uml = UML.addClass(name.replaceAll("\\s", ""));
		// If uml is not null, class was added
		assertNotNull(uml);
		// True if name is alphanumeric
		assertTrue(!UML.getPattern().matcher("thisisaclass").find());
		// True if noClassDupes added uml name "thisisaclass" and size is 3
		assertTrue(Model.getNoClassDupes().contains("thisisaclass"));
		assertEquals("noClassDupes size is not 3", 3, Model.getNoClassDupes().size());
		// True if collection added uml and size is 3
		assertTrue(Model.getCollection().contains(uml));
		assertEquals("collection size is not 3", 3, Model.getCollection().size());
		Model.getNoClassDupes().clear();
		Model.getCollection().clear();
	}

	@Test
	public void test03_AddClassNotAlphaNum() {
		// Adding a class but it's non-alphanumeric
		UML uml = UML.addClass("this-is-a-class!");
		// If uml is null, class was not added
		assertNull(uml);
		// True if name is not alphanumeric
		assertTrue(UML.getPattern().matcher("this-is-a-class!").find());
		// True if noClassDupes did not add uml name "this-is-a-class!" and size is
		// still 0
		assertTrue(!Model.getNoClassDupes().contains("this is a class"));
		assertEquals("noClassDupes size is not 0", 0, Model.getNoClassDupes().size());
		// True if collection did not add uml and size is still 0
		assertTrue(!Model.getCollection().contains(uml));
		assertEquals("collection size is not 0", 0, Model.getCollection().size());
		Model.getNoClassDupes().clear();
		Model.getCollection().clear();
	}

	@Test
	public void test04_AddClassExists() {
		// Adding a class that already exists
		UML.addClass("class");
		UML uml = UML.addClass("class");
		// If uml is null, class was not added
		assertNull(uml);
		// False when add tries to add a name to noClassDupes that already exists
		assertFalse(Model.getNoClassDupes().add("class"));
		// True if size is still 1
		assertEquals("noClassDupes size is not 1", 1, Model.getNoClassDupes().size());
		// Counts to see if collection has duplicates of "class1"
		int i = 0;
		boolean bool = true;
		for (UML element : Model.getCollection()) {
			if (element.getClassName().equals("class1")) {
				i++;
				if (i == 2) {
					bool = false;
					break;
				}
			}
		}
		// True if addClass succeeded in not adding a duplicate class
		assertTrue(bool);
		// True if size is still 1
		assertEquals("collection size is not 1", 1, Model.getCollection().size());
		Model.getNoClassDupes().clear();
		Model.getCollection().clear();
	}

	@Test
	public void test05_DeleteClassExists() {
		UML.test = false;
		UML.addClass("class");
		UML.deleteClass("class");

		assertEquals("Collection size is not 0", 0, Model.getCollection().size());

		Model.getNoClassDupes().clear();
		Model.getCollection().clear();
		UML.test = true;
	}

	@Test
	public void test06_DeleteClassNotExists() {
		// Deleting a class that doesn't exist
		int size = Model.getCollection().size();
		UML uml = UML.deleteClass("name");
		// If uml is null, class failed to delete
		assertNull(uml);
		// True if noClassDupes doesn't have this class
		assertTrue(!Model.getNoClassDupes().contains("name"));
		// True if noClassDupes size did not change
		assertEquals("noClassDupes size is not " + size, Model.getNoClassDupes().size(), size);
		// Searches collection to see if "name" is inside
		boolean bool = true;
		for (UML element : Model.getCollection()) {
			if (element.getClassName().equals("name")) {
				bool = false;
				break;
			}
		}
		// True if there was no class to delete
		assertTrue(bool);
		// True if collection size did not change
		assertEquals("collection size is not " + size, Model.getCollection().size(), size);
		Model.getNoClassDupes().clear();
		Model.getCollection().clear();
	}

	@Test
	public void test07_RenameClassSuccess() {
		// Renaming class cat to dog succeeding
		UML.addClass("cat");
		int size = Model.getCollection().size();
		UML uml = UML.renameClass("cat", "dog");
		// If uml is not null, class was renamed
		assertNotNull(uml);
		// True if cat was removed
		assertTrue(!Model.getNoClassDupes().contains("cat"));
		// True if dog was added
		assertTrue(Model.getNoClassDupes().contains("dog"));
		// True if noClassDupes size did not change
		assertEquals("noClassDupes size is not " + size, Model.getNoClassDupes().size(), size);
		// Searches collection to see if "cat" is inside
		boolean bool = true;
		for (UML element : Model.getCollection()) {
			if (element.getClassName().equals("cat")) {
				bool = false;
				break;
			}
		}
		// True if cat is not in collection
		assertTrue(bool);
		// Searches collection to see if "dog" is inside
		bool = false;
		for (UML element : Model.getCollection()) {
			if (element.getClassName().equals("dog")) {
				bool = true;
				break;
			}
		}
		// True if dog is in collection
		assertTrue(bool);
		// True if collection size did not change
		assertEquals("collection size is not " + size, Model.getCollection().size(), size);
		Model.getNoClassDupes().clear();
		Model.getCollection().clear();
	}

	@Test
	public void test08_RenameClassNotExists() {
		// Renaming a class that doesn't exist
		int size = Model.getCollection().size();
		UML uml = UML.renameClass("cat", "dog");
		// If uml is null, class was not renamed
		assertNull(uml);
		// True if cat doesn't exist
		assertTrue(!Model.getNoClassDupes().contains("cat"));
		// True if dog doesn't exist
		assertTrue(!Model.getNoClassDupes().contains("dog"));
		// True if noClassDupes size did not change
		assertEquals("noClassDupes size is not " + size, Model.getNoClassDupes().size(), size);
		// Searches collection to see if "cat" is inside
		boolean bool = true;
		for (UML element : Model.getCollection()) {
			if (element.getClassName().equals("cat")) {
				bool = false;
				break;
			}
		}
		// True if cat is not in collection
		assertTrue(bool);
		// True if collection size did not change
		assertEquals("collection size is not " + size, Model.getCollection().size(), size);
		Model.getNoClassDupes().clear();
		Model.getCollection().clear();
	}

	// still need test for new name being taken and non-AN
	@Test
	public void test09_RenameClassExists() {
		// Renaming a class that doesn't exist
		UML.addClass("cat");
		UML.addClass("dog");
		int size = Model.getCollection().size();
		UML uml = UML.renameClass("cat", "dog");
		// If uml is null, class was not renamed
		assertNull(uml);
		// True if cat exists
		assertTrue(Model.getNoClassDupes().contains("cat"));
		// True if dog exists
		assertTrue(Model.getNoClassDupes().contains("dog"));
		// True if noClassDupes size did not change
		assertEquals("noClassDupes size is not " + size, Model.getNoClassDupes().size(), size);
		// Searches collection to see if "cat" is inside
		boolean bool = false;
		for (UML element : Model.getCollection()) {
			if (element.getClassName().equals("cat")) {
				bool = true;
				break;
			}
		}
		// True if cat is not in collection
		assertTrue(bool);
		// Searches collection to see if "dog" still exists
		bool = false;
		for (UML element : Model.getCollection()) {
			if (element.getClassName().equals("dog")) {
				bool = true;
				break;
			}
		}
		// True if dog is not in collection
		assertTrue(bool);
		// True if collection size did not change
		assertEquals("collection size is not " + size, Model.getCollection().size(), size);
		Model.getNoClassDupes().clear();
		Model.getCollection().clear();
	}

	@Test
	public void test10_RenameClassNotAlphaNum() {
		// Renaming class cat to non-alphanumeric name
		UML.addClass("cat");
		int size = Model.getCollection().size();
		UML uml = UML.renameClass("cat", "dog!");
		// If uml is null, class was not renamed
		assertNull(uml);

		// True if name is alphanumeric
		assertTrue(UML.getPattern().matcher("dog!").find());

		// True if cat still exists
		assertTrue(Model.getNoClassDupes().contains("cat"));
		// True if dog! was not added
		assertTrue(!Model.getNoClassDupes().contains("dog!"));
		// True if noClassDupes size did not change
		assertEquals("noClassDupes size is not " + size, Model.getNoClassDupes().size(), size);
		// Searches collection to see if "cat" is inside
		boolean bool = false;
		for (UML element : Model.getCollection()) {
			if (element.getClassName().equals("cat")) {
				bool = true;
				break;
			}
		}
		// True if cat is in collection
		assertTrue(bool);
		// Searches collection to see if "dog!" is not inside
		bool = true;
		for (UML element : Model.getCollection()) {
			if (element.getClassName().equals("dog!")) {
				bool = false;
				break;
			}
		}
		// True if dog! is not in collection
		assertTrue(bool);
		// True if collection size did not change
		assertEquals("collection size is not " + size, Model.getCollection().size(), size);
		Model.getNoClassDupes().clear();
		Model.getCollection().clear();
	}

	@Test
	public void test11_FindUMLObject() {
		UML uml = UML.addClass("class");
		assertEquals("UML Object does not match expected UML", uml, UML.findUMLOBJ("class"));
		UML uml1 = UML.findUMLOBJ("abc");
		assertEquals("UML Object does not match expected UML", uml1, null);
		Model.getNoClassDupes().clear();
		Model.clearCollection();
	}
	@Test
	public void test12t() {
		UML uml = UML.addClass("class");
		uml.setCoords(uml, 5, 10);

		assertEquals("UML Object does not match expected UML", uml.getposition_x(), 5);
		assertEquals("UML Object does not match expected UML", uml.getposition_y(), 10);
		Model.getNoClassDupes().clear();
		Model.clearCollection();
	}

}