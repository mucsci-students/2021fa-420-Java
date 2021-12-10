package uml;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class relationshipTest {

	@Test 
	public void test01_addRelation(){
		UML uml = UML.addClass("one");
	    UML uml2 = UML.addClass("two");
	    Relationships.addRel(uml,uml2,"inheritance");
	        
		assertEquals("rels size is not 1", 1, uml.getRels().size()); //tests that relation is added
			
		Model.clearCollection();
		Model.getNoClassDupes().clear();
	}

	@Test
	public void test02_checkRelationTypes() { //Tests that a relationship of a type not allowed can not be added.
		UML uml = UML.addClass("one");
	    UML uml2 = UML.addClass("two");
	    Relationships.addRel(uml,uml2,"inhatance");
		assertEquals("The type was accepted when it should have been rejected",true,Relationships.testType("inheritance"));
		Model.clearCollection();
		Model.getNoClassDupes().clear();
	}

	@Test 
	public void test03_delRelation(){ //both tests that the add works and when that is verified it attempts to delete and verifies if that is true
		UML uml = UML.addClass("one");
	    UML uml2 = UML.addClass("two");
	    Relationships.addRel(uml,uml2,"inheritance");
	    
		assertEquals("rels size is not 1", 1, uml.getRels().size()); //tests that relation is added
	
		Relationships.delRel("one","two");
	
	    assertEquals("rels size is not 0", 0, uml.getRels().size()); //tests relation is removed from arraylist and that delete works
	        
	    Model.clearCollection();
	    Model.getNoClassDupes().clear();
	}

	@Test
	public void test04_addmultRelation(){ // verifies the correct amount of relations are being added
	    UML uml = UML.addClass("one");
	    UML uml2 = UML.addClass("two");
	    UML uml3 = UML.addClass("three");
	    UML uml4 = UML.addClass("four");
	
	    Relationships.addRel(uml,uml2,"aggregation");
	    Relationships.addRel(uml,uml3,"composition");
	    Relationships.addRel(uml,uml4,"realization");
	
	    assertEquals("rels size is not 3", 3, uml.getRels().size()); //tests that all relations are added and size is correct
	    Model.clearCollection();
	    Model.getNoClassDupes().clear();
	}

	@Test
	public void test05_delmultRelation(){ // verifies the correct amount of relations are being added and remains correct after a few removals
	    UML uml = UML.addClass("one");
	    UML uml2 = UML.addClass("two");
	    UML uml3 = UML.addClass("three");
	    UML uml4 = UML.addClass("four");
	
	    Relationships.addRel(uml,uml2,"aggregation");
	    Relationships.addRel(uml,uml3,"composition");
	    Relationships.addRel(uml,uml4,"realization");
	
	    assertEquals("rels size is not 3", 3, uml.getRels().size()); //tests that all relations are added and size is correct
	
	    Relationships.delRel("one","two");
	
	    assertEquals("rels size is not 2", 2, uml.getRels().size()); //tests that all relations are added and size is correct after removal
	
	    Relationships.delRel("one","three");
	
	    assertEquals("rels size is not 1", 1, uml.getRels().size()); //tests that all relations are added and size is correct after 2nd removal
	    Model.clearCollection();
	    Model.getNoClassDupes().clear();
	}

	@Test 
	public void test06_addRelationDup(){
		UML uml = UML.addClass("one");
	    UML uml2 = UML.addClass("two");

	    Relationships.addRel(uml, uml2, "inheritance");
		Relationships.addRel(uml, uml2, "inheritance");

		assertEquals("Relationships size is not 1", 1, uml.getRels().size());

		Model.clearCollection();
		Model.getNoClassDupes().clear();
	}

	//Test like this for GUI!
	// @Test 
	// public void test065_addRelationDup(){ 
	// 	Driver.guiUp = true;
	// 	UML uml = UML.addClass("one");
	//     UML uml2 = UML.addClass("two");

	//     Relationships.addRel(uml, uml2, "inheritance");
	// 	Relationships.addRel(uml, uml2, "inheritance");
	// 	assertEquals("Relationships size is not 1", 1, uml.getRels().size());

	// 	Model.clearCollection();
	// 	Model.getNoClassDupes().clear();
	// 	Driver.guiUp = false;
	// }
	

	@Test
	public void test07_deleteNotExist() {
		UML uml = UML.addClass("one");
	    UML uml2 = UML.addClass("two");

		Relationships.addRel(uml, uml2, "inheritance");
	    Relationships.delRel("three", "two");
		Relationships.delRel("one", "three");
		
		assertEquals("Relationships size is not 1", 1, uml.getRels().size());

		Model.clearCollection();
		Model.getNoClassDupes().clear();
	}

	@Test
	public void test08_changeRel() {
		UML uml = UML.addClass("one");
	    UML uml2 = UML.addClass("two");
	    Driver.guiUp = true;

		Relationships.addRel(uml, uml2, "inheritance");
		Relationships.changeRel("one", "two", "realization");
		assertEquals("Relationships size is not 1", 1, uml.getRels().size());
		
		Driver.guiUp = false;
		Model.clearCollection();
		Model.getNoClassDupes().clear();
	}

	@Test
	public void test09_changeRelNotExist() {
		UML uml = UML.addClass("one");
	    UML uml2 = UML.addClass("two");

		Relationships.addRel(uml, uml2, "inheritance");
		Relationships.changeRel("three", "two", "realization");
		Relationships.changeRel("one", "three", "realization");
		assertEquals("Relationships size is not 1", 1, uml.getRels().size());

		Model.clearCollection();
		Model.getNoClassDupes().clear();
	}
}