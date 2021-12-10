package uml;

import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class IntegrationTests {
	
    @Test
	public void test01_Constructor() {
		UML uml = UML.addClass("car");
		assertEquals("The UML is called", "car", uml.getClassName());
		assertEquals("The UML's x position is", 0, uml.getposition_x());
		assertEquals("The UML's y position is", 0, uml.getposition_y());
	    Model.getNoClassDupes().clear();
		Model.clearCollection();
	}
	
    @Test
	public void test02_ChangeClass() {
		UML uml = UML.addClass("computer");
		assertEquals("The UML is called", "computer", uml.getClassName());
		assertEquals("The UML's x position is", 0, uml.getposition_x());
		assertEquals("The UML's y position is", 0, uml.getposition_y());
		assertTrue("There are no fields in the UML", uml.getField().isEmpty());
		assertTrue("There are no methods in the UML", uml.getMethod().isEmpty());
		assertTrue("There are no relationships in the UML", uml.getRels().isEmpty());
		
		Fields.addField("computer", "CPU", "String");
 		Fields.addField("computer", "GPU", "String");
 		Fields.addField("computer", "SSD", "String");
 		Fields.addField("computer", "RAM", "String");
		assertEquals("Successfully added fields to the UML", 4, uml.getField().size());
		
		Methods system = new Methods("system", "string");
		Methods.addMethod(uml.getClassName(), system.getMethodName(), system.getMethodType());
		assertEquals("Successfully added method to the UML", 1, uml.getMethod().size());
		
		UML.renameClass("computer", "phone");
		assertEquals("Successfully renamed the UML", "phone", uml.getClassName());
		
		Model.getNoClassDupes().clear();
		Model.clearCollection();
	}
	
	@Test
	public void test03_ChangeField() {
		UML uml = UML.addClass("computer");
		assertEquals("The UML is called", "computer", uml.getClassName());
		assertEquals("The UML's x position is", 0, uml.getposition_x());
		assertEquals("The UML's y position is", 0, uml.getposition_y());
		assertTrue("There are no fields in the UML", uml.getField().isEmpty());
		assertTrue("There are no methods in the UML", uml.getMethod().isEmpty());
		assertTrue("There are no relationships in the UML", uml.getRels().isEmpty());
		
		Fields.addField("computer", "CPU", "String");
 		Fields.addField("computer", "GPU", "String");
 		Fields.addField("computer", "SSD", "String");
 		Fields.addField("computer", "RAM", "String");
		assertEquals("Successfully added fields to the UML", 4, uml.getField().size());
		
		Methods system = new Methods("System", "String");
		Methods.addMethod(uml.getClassName(), system.getMethodName(), system.getMethodType());
		assertEquals("Successfully added method to the UML", 1, uml.getMethod().size());
		
		Fields.removeField("computer", "SSD");
		assertEquals("Successfully removed field from the UML", 3, uml.getField().size());
		
		Model.getNoClassDupes().clear();
		Model.clearCollection();
	}
	
	@Test
	public void test04_ChangeMethod() {
		UML uml = UML.addClass("computer");
		assertEquals("The UML is called", "computer", uml.getClassName());
		assertEquals("The UML's x position is", 0, uml.getposition_x());
		assertEquals("The UML's y position is", 0, uml.getposition_y());
		assertTrue("There are no fields in the UML", uml.getField().isEmpty());
		assertTrue("There are no methods in the UML", uml.getMethod().isEmpty());
		assertTrue("There are no relationships in the UML", uml.getRels().isEmpty());
		
		Fields.addField("computer", "CPU", "String");
 		Fields.addField("computer", "GPU", "String");
 		Fields.addField("computer", "SSD", "String");
 		Fields.addField("computer", "RAM", "String");
		assertEquals("Successfully added fields to the UML", 4, uml.getField().size());
		
		Methods.addMethod("computer", "System", "String");
		assertEquals("Successfully added method to the UML", 1, uml.getMethod().size());
		
		Methods.removeMethod("computer", "System");
		assertEquals("Successfully removed method from the UML", 0, uml.getMethod().size());
		
		Model.getNoClassDupes().clear();
		Model.clearCollection();
	}
	
	@Test
	public void test05_ChangeParameter() {
		UML uml = UML.addClass("computer");
		assertEquals("The UML is called", "computer", uml.getClassName());
		assertEquals("The UML's x position is", 0, uml.getposition_x());
		assertEquals("The UML's y position is", 0, uml.getposition_y());
		assertTrue("There are no fields in the UML", uml.getField().isEmpty());
		assertTrue("There are no methods in the UML", uml.getMethod().isEmpty());
		assertTrue("There are no relationships in the UML", uml.getRels().isEmpty());
		
		Fields.addField("computer", "CPU", "String");
 		Fields.addField("computer", "GPU", "String");
 		Fields.addField("computer", "SSD", "String");
 		Fields.addField("computer", "RAM", "String");
		assertEquals("Successfully added fields to the UML", 4, uml.getField().size());
		
		Methods.addMethod("computer", "System", "String");
		assertEquals("Successfully added method to the UML", 1, uml.getMethod().size());
		
		Parameters.addParameter("computer", "System", "Linux", "int", null, true);
		Parameters.addParameter("computer", "System", "Windows", "int", null, true);
		Parameters.addParameter("computer", "System", "macOS", "int", null, true);		
		Parameters.deleteParameter("computer", "System", "Windows", null, true);
		
		Model.getNoClassDupes().clear();
		Model.clearCollection();
	}
	
	@Test
	public void test06_ChangeRelationship() {
		UML uml = UML.addClass("computer");
		assertEquals("The UML is called", "computer", uml.getClassName());
		assertEquals("The UML's x position is", 0, uml.getposition_x());
		assertEquals("The UML's y position is", 0, uml.getposition_y());
		assertTrue("There are no fields in the UML", uml.getField().isEmpty());
		assertTrue("There are no methods in the UML", uml.getMethod().isEmpty());
		assertTrue("There are no relationships in the UML", uml.getRels().isEmpty());
		
		Fields.addField("computer", "CPU", "String");
 		Fields.addField("computer", "GPU", "String");
 		Fields.addField("computer", "SSD", "String");
 		Fields.addField("computer", "RAM", "String");
		assertEquals("Successfully added fields to the UML", 4, uml.getField().size());
		
		Methods.addMethod("computer", "System", "String");
		assertEquals("Successfully added method to the UML", 1, uml.getMethod().size());
		
		Parameters.addParameter("computer", "System", "Linux", "int", null, true);
		Parameters.addParameter("computer", "System", "Windows", "int", null, true);
		Parameters.addParameter("computer", "System", "macOS", "int", null, true);
		
		
		UML uml2 = UML.addClass("phone");
		assertEquals("The UML is called", "phone", uml2.getClassName());
		assertEquals("The UML's x position is", 0, uml2.getposition_x());
		assertEquals("The UML's y position is", 0, uml2.getposition_y());
		assertTrue("There are no fields in the UML", uml2.getField().isEmpty());
		assertTrue("There are no methods in the UML", uml2.getMethod().isEmpty());
		assertTrue("There are no relationships in the UML", uml2.getRels().isEmpty());
		
		Fields.addField("phone", "CPU", "String");
 		Fields.addField("phone", "RAM", "String");
 		assertEquals("Successfully added fields to the UML", 2, uml2.getField().size());
 		
 		Methods.addMethod("phone", "System2", "String");
		assertEquals("Successfully added method to the UML", 1, uml.getMethod().size());
		
		Parameters.addParameter("phone", "System2", "iOS", "int", null, true);
		Parameters.addParameter("phone", "System2", "Android", "int", null, true);
		
		Relationships.addRel(uml, uml2, "inheritance");
		Relationships.changeRel("computer", "phone", "realization");
		
		Model.getNoClassDupes().clear();
		Model.clearCollection();
	}
}