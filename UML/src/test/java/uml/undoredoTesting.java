package uml; import org.junit.Test;
import static org.junit.Assert.*;

public class undoredoTesting {
    // @Test
	// public void test01_undoClass() { // testing size after 1 undo
		
	// 	UML.addClass("a");
	// 	UML.addClass("b");
	// 	UML.addClass("c");

	// 	undoredo.undo();
	// 	System.out.println(Model.getCollection());
	// 	assertEquals("model size should be 2 but is not", 2, Model.getCollection().size());
	// 	Model.clearCollection();
	// 	Model.getNoClassDupes().clear();
	// 	}
	@Test 
	public void test02_undoClass(){ //tests size after a redo
		UML.addClass("a");
		UML.addClass("b");
		UML.addClass("c");

		undoredo.undo();
		undoredo.redo(); 

		assertEquals("model size should be 2 but is not", 3, Model.getCollection().size());
		Model.clearCollection();
		Model.getNoClassDupes().clear();
	}
	@Test
	public void test03_undoClass(){ //tests size after extra redo's
		UML.addClass("a");
		UML.addClass("b");
		UML.addClass("c");

		undoredo.undo();
		undoredo.redo(); 
		undoredo.redo(); 
		undoredo.redo(); 

		assertEquals("model size should be 3 but is not", 3, Model.getCollection().size());
		Model.clearCollection();
		Model.getNoClassDupes().clear();
	}
	// @Test
	// public void test04_undoClass(){ //tests excessive undos
	// 	UML.addClass("a");
	// 	UML.addClass("b");
	// 	UML.addClass("c");

	// 	undoredo.undo();
	// 	undoredo.undo();
	// 	undoredo.undo();
	// 	undoredo.undo();
	// 	undoredo.undo();

	// 	assertEquals("model size should be 0 but is not", 0, Model.getCollection().size());
	// 	Model.clearCollection();
	// 	Model.getNoClassDupes().clear();
	// }
	// @Test
	// public void test05_undoClass(){ //tests relationship removal
	// 	UML uml1 = UML.addClass("a");
	// 	UML uml2 = UML.addClass("b");
	// 	UML.addClass("c");

	// 	Relationships.addRel(uml1,uml2,"inheritance");

	// 	undoredo.undo();
	        
	// 	assertEquals("rels size is not 0", 0, uml1.getRels().size());
	// }
	@Test
	public void test06_undoClass(){ //tests relationship removal then readding
		UML uml1 = UML.addClass("a");
		UML uml2 = UML.addClass("b");
		UML.addClass("c");

		Relationships.addRel(uml1,uml2,"inheritance");

		undoredo.undo();
		undoredo.redo();

		assertEquals("rels size is not 1", 1, uml1.getRels().size());
	}
}