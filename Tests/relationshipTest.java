// import org.junit.Test;
// import static org.junit.Assert.*;
// public class relationshipTest {

// @Test 
// public void test01_addRelation(){

// 		UML uml = UML.addClass("one");
//         UML uml2 = UML.addClass("two");
//         addrel(uml,uml2);
        
// 		assertEquals("rels size is not 1", 1, UML.collection.rels.size());; //tests that relation is added
// }

// @Test 
// public void test02_addRelation(){ //both tests that the add works and when that is verified it attempts to delete and verifies if that is true

// 		UML uml = UML.addClass("one");
//         UML uml2 = UML.addClass("two");
//         addrel(uml,uml2);
    
// 		assertEquals("rels size is not 1", 1, UML.collection.rels.size());; //tests that relation is added

//         delRel(uml,uml2);

//         assertEquals("rels size is not 0", 0, UML.collection.rels.size());; //tests relation is removed from arraylist and that delete works
// }

// public void test03_addmultRelation(){ // verifies the correct amount of relations are being added

//     UML uml = UML.addClass("one");
//     UML uml2 = UML.addClass("two");
//     UML uml3 = UML.addClass("three");
//     UML uml4 = UML.addClass("four");

//     addrel(uml,uml2);
//     addrel(uml2,uml3);
//     addrel(uml3,uml4);

//     assertEquals("rels size is not 3", 3, UML.collection.rels.size()); //tests that all relations are added and size is correct

// }

// public void test03_delmultRelation(){ // verifies the correct amount of relations are being added and remains correct after a few removals

//     UML uml = UML.addClass("one");
//     UML uml2 = UML.addClass("two");
//     UML uml3 = UML.addClass("three");
//     UML uml4 = UML.addClass("four");

//     addrel(uml,uml2);
//     addrel(uml2,uml3);
//     addrel(uml3,uml4);

//     assertEquals("rels size is not 3", 3, UML.collection.rels.size()); //tests that all relations are added and size is correct

//     delrel(uml,uml2);

//     assertEquals("rels size is not 2", 2, UML.collection.rels.size()); //tests that all relations are added and size is correct after removal

//     delrel(uml2,uml3);

//     assertEquals("rels size is not 1", 1, UML.collection.rels.size()); //tests that all relations are added and size is correct after 2nd removal
// }
// }