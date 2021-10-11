import org.junit.Test;
import static org.junit.Assert.*;
public class relationshipTest {

	@Test 
	public void test01_addRelation(){
	
			UML uml = UML.addClass("one");
	        UML uml2 = UML.addClass("two");
	        Relationships.addRel(uml,uml2,"inheritance");
	        
			assertEquals("rels size is not 1", 1, uml.getRels().size());; //tests that relation is added
			
			UML.clearCollection();
			UML.getNoClassDupes().clear();
	}

	@Test
	public void test02_checkRelationTypes() { //Tests that a relationship of a type not allowed can not be added.
			assertEquals("The type was accepted when it should have been rejected",false,Relationships.testType("inharitance"));
	}

	@Test 
	public void test03_delRelation(){ //both tests that the add works and when that is verified it attempts to delete and verifies if that is true
	
			UML uml = UML.addClass("one");
	        UML uml2 = UML.addClass("two");
	        Relationships.addRel(uml,uml2,"inheritance");
	    
			assertEquals("rels size is not 1", 1, uml.getRels().size());; //tests that relation is added
	
			Relationships.delRel("one","two");
	
	        assertEquals("rels size is not 0", 0, uml.getRels().size());; //tests relation is removed from arraylist and that delete works
	        
	        UML.clearCollection();
	        UML.getNoClassDupes().clear();
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
	    UML.clearCollection();
	    UML.getNoClassDupes().clear();
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
	    UML.clearCollection();
	    UML.getNoClassDupes().clear();
	}

}