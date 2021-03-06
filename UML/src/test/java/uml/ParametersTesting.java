package uml;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParametersTesting {
    @Test
	public void Constructor() {

		// Add the first Method
		Parameters p1= new Parameters("x", "int");
		assertNotNull(p1);
        assertEquals(p1.getParamName(), "x");
        assertEquals(p1.getParamType(), "int");

        p1.setParamName("y");
        p1.setParamType("String");

        assertEquals(p1.getParamName(), "y");
        assertEquals(p1.getParamType(), "String");
        Model.clearCollection();
        Model.getNoClassDupes().clear();
    }
    
    @Test
    public void addParamsAndFindParams() {
		// Create a class
		UML.addClass("class");
        Methods.addMethod("class", "a", "String");
		// Add the first Method
		Parameters p1= new Parameters("x", "int");
		Parameters.addParameter("class", "a" , "x", "int", null , true);

        //Testing Parameters find method, which finds the list of parameters
        ArrayList<Parameters> pList = Parameters.findMethod("class", "a");
        //Testing that given the method we can find the specific parameters
        Parameters p2 = Parameters.findParam("x", pList);

        assertEquals(p1.getParamName(), p2.getParamName());
        assertEquals(p1.getParamType(), p2.getParamType());
        Model.clearCollection();
        Model.getNoClassDupes().clear();
    }
    @Test
    public void addParamsAndFindParamsCLI() {
		// Create a class
		UML.addClass("class");
        Methods.addMethod("class", "a", "String");
		// Add the first Method
		Parameters p1= new Parameters("x", "int");
		ArrayList<String> a = new ArrayList<>();
		Parameters.addParameterCLI("class", "a" , "x", "int", null , true,a);

        //Testing Parameters find method, which finds the list of parameters
        ArrayList<Parameters> pList = Parameters.findMethod("class", "a");
        //Testing that given the method we can find the specific parameters
        Parameters p2 = Parameters.findParam("x", pList);

        assertEquals(p1.getParamName(), p2.getParamName());
        assertEquals(p1.getParamType(), p2.getParamType());
        Model.clearCollection();
        Model.getNoClassDupes().clear();
    }
    
    @Test
    public void addParamsAndFindParamsAdvanced(){
        //Advanced case
        UML.addClass("class");
        Methods.addMethod("class", "a", "String");

		Parameters p3= new Parameters("x1", "int");
        Parameters p4= new Parameters("x2", "String");
        Parameters p5= new Parameters("x3", "Object");
		Parameters.addParameter("class", "a" , "x1", "int", null , true);
        Parameters.addParameter("class", "a" , "x2", "String", null , true);
        Parameters.addParameter("class", "a" , "x3", "Object", null , true);
        ArrayList<Parameters> pList2 = Parameters.findMethod("class", "a");
        
        Parameters p6 = Parameters.findParam("x1", pList2);
        Parameters p7 = Parameters.findParam("x2", pList2);
        Parameters p8 = Parameters.findParam("x3", pList2);

        assertEquals(p3.getParamName(), p6.getParamName());
        assertEquals(p3.getParamType(), p6.getParamType());

        assertEquals(p4.getParamName(), p7.getParamName());
        assertEquals(p4.getParamType(), p7.getParamType());

        assertEquals(p5.getParamName(), p8.getParamName());
        assertEquals(p5.getParamType(), p8.getParamType());
        Model.clearCollection();
        Model.getNoClassDupes().clear();
    }
    
    @Test
    public void deleteParameterAndCompareParams(){
        UML.addClass("class");
        Methods.addMethod("class", "a", "String");

		Parameters p1= new Parameters("x1", "int");
        Parameters p2= new Parameters("x2", "String");
        Parameters p3= new Parameters("x3", "Object");

		Parameters.addParameter("class", "a" , "x1", "int", null , true);
        Parameters.addParameter("class", "a" , "x2", "String", null , true);
        Parameters.addParameter("class", "a" , "x3", "Object", null , true);

        ArrayList<Parameters> pList1 = Parameters.findMethod("class", "a");
        UML.addClass("class");
        Methods.addMethod("class", "b", "String");
        Parameters.addParameter("class", "b" , "x2", "String", null , true);
        Parameters.addParameter("class", "b" , "x3", "Object", null , true);
        
        Parameters.deleteParameter("class", "a", "x1", null , true);
        ArrayList<Parameters> pList2 = Parameters.findMethod("class", "b");
        assertTrue("Are the params the same?", MethodOverloading.compareParams(pList1, pList2, "Random String"));
       
        Model.clearCollection();
        Model.getNoClassDupes().clear();
    }
    
    @Test
    public void deleteParameterAndCompareParamsCLI(){
        UML.addClass("class");
        Methods.addMethod("class", "a", "String");

		Parameters p1= new Parameters("x1", "int");
        Parameters p2= new Parameters("x2", "String");
        Parameters p3= new Parameters("x3", "Object");

		Parameters.addParameter("class", "a" , "x1", "int", null , true);
        Parameters.addParameter("class", "a" , "x2", "String", null , true);
        Parameters.addParameter("class", "a" , "x3", "Object", null , true);

        ArrayList<Parameters> pList1 = Parameters.findMethod("class", "a");
        UML.addClass("class");
        Methods.addMethod("class", "b", "String");
        Parameters.addParameter("class", "b" , "x2", "String", null , true);
        Parameters.addParameter("class", "b" , "x3", "Object", null , true);
        
        ArrayList<String> a = new ArrayList<>();
        Parameters.deleteParameterCLI("class", "a", "x1", null , true, a);
        ArrayList<Parameters> pList2 = Parameters.findMethod("class", "b");
        assertTrue("Are the params the same?", MethodOverloading.compareParams(pList1, pList2, "Random String"));
       
        Model.clearCollection();
        Model.getNoClassDupes().clear();
    }
    
    @Test
    public void deleteAllParameters(){
        UML.addClass("class");
        Methods.addMethod("class", "a", "String");

		Parameters p1= new Parameters("x1", "int");
        Parameters p2= new Parameters("x2", "String");
        Parameters p3= new Parameters("x3", "Object");

		Parameters.addParameter("class", "a" , "x1", "int", null , true);
        Parameters.addParameter("class", "a" , "x2", "String", null , true);
        Parameters.addParameter("class", "a" , "x3", "Object", null , true);

        ArrayList<Parameters> pList1 = Parameters.findMethod("class", "a");
        UML.addClass("class");
        Methods.addMethod("class", "b", "String");
        
        Parameters.deleteAllParameters("class", "a", null , true);
        ArrayList<Parameters> pList2 = Parameters.findMethod("class", "b");
        assertTrue("Are the params the same?", MethodOverloading.compareParams(pList1, pList2, "Random String"));
       
        Model.clearCollection();
        Model.getNoClassDupes().clear();
    }
    @Test
    public void deleteAllParametersCLI(){
        UML.addClass("class");
        Methods.addMethod("class", "a", "String");

		Parameters p1= new Parameters("x1", "int");
        Parameters p2= new Parameters("x2", "String");
        Parameters p3= new Parameters("x3", "Object");

		Parameters.addParameter("class", "a" , "x1", "int", null , true);
        Parameters.addParameter("class", "a" , "x2", "String", null , true);
        Parameters.addParameter("class", "a" , "x3", "Object", null , true);

        ArrayList<Parameters> pList1 = Parameters.findMethod("class", "a");
        UML.addClass("class");
        Methods.addMethod("class", "b", "String");
        
        ArrayList<String> a = new ArrayList<>();
        Parameters.deleteAllParametersCLI("class", "a", null , true, a);
        ArrayList<Parameters> pList2 = Parameters.findMethod("class", "b");
        assertTrue("Are the params the same?", MethodOverloading.compareParams(pList1, pList2, "Random String"));
       
        Model.clearCollection();
        Model.getNoClassDupes().clear();
    }
    
    @Test
    public void changeParameters(){
        UML.addClass("class");
        Methods.addMethod("class", "a", "String");

		Parameters p1 = new Parameters("x1", "int");
         

		Parameters.addParameter("class", "a" , "x1", "int", null , true);
        Parameters.addParameter("class", "a" , "x2", "String", null , true);
        Parameters.addParameter("class", "a" , "x3", "Object", null , true);

        ArrayList<Parameters> pList1 = Parameters.findMethod("class", "a");
        
        Parameters.changeParameter("class", "a", "x1", "x4", "Object", null , true);
        ArrayList<Parameters> pList2 = Parameters.findMethod("class", "a");
        

        assertTrue("Parameters list should not be the same", MethodOverloading.compareParams(pList1, pList2, "Random String"));
        Parameters p2 = Parameters.findParam("x4", pList2);
        assertFalse(p1.getParamName().equals(p2.getParamName()));
        assertFalse(p1.getParamType().equals(p2.getParamType()));

        Model.clearCollection();
        Model.getNoClassDupes().clear();
    }

    @Test
    public void changeParametersCLI(){
        UML.addClass("class");
        Methods.addMethod("class", "a", "String");

		Parameters p1 = new Parameters("x1", "int");
         

		Parameters.addParameter("class", "a" , "x1", "int", null , true);
        Parameters.addParameter("class", "a" , "x2", "String", null , true);
        Parameters.addParameter("class", "a" , "x3", "Object", null , true);

        ArrayList<Parameters> pList1 = Parameters.findMethod("class", "a");
        
        ArrayList<String> a = new ArrayList<>();
        Parameters.changeParameterCLI("class", "a", "x1", "x4", "Object", null , true,a);
        ArrayList<Parameters> pList2 = Parameters.findMethod("class", "a");
        

        assertTrue("Parameters list should not be the same", MethodOverloading.compareParams(pList1, pList2, "Random String"));
        Parameters p2 = Parameters.findParam("x4", pList2);
        assertFalse(p1.getParamName().equals(p2.getParamName()));
        assertFalse(p1.getParamType().equals(p2.getParamType()));

        Model.clearCollection();
        Model.getNoClassDupes().clear();
    }

    @Test
    public void addParamsDNE() {
        // Create a class
		UML uml = UML.addClass("class");
        // Add a method
        Methods.addMethod("class", "a", "String");
		Parameters p1= new Parameters("x", "int");
		Parameters.addParameter("class", "a" , "x", "int", null , true);
        //Testing Parameters find method, which finds the list of parameters
        ArrayList<Parameters> pList = Parameters.findMethod("class", "a");
        //Testing that given the method we can find the specific parameters
        Parameters p2 = Parameters.findParam("x", pList);
        Parameters p3= new Parameters("x", "int");
		Parameters.addParameter("class", "a" , "x", "int", null , true);

        Model.clearCollection();
        Model.getNoClassDupes().clear();
    }
    
    @Test
    public void addParamsDNE1() {
        // Create a class
		UML uml = UML.addClass("class");
        // Add a method
        Methods.addMethod("class", "a", "String");
		Parameters p1= new Parameters("x", "int");
		ArrayList<String> a = new ArrayList<>();
		ArrayList<String> b = new ArrayList<>();
		Parameters.addParameterCLI("class", "a" , "x", "int", null , true,a);
        //Testing Parameters find method, which finds the list of parameters
        ArrayList<Parameters> pList = Parameters.findMethod("class", "a");
        //Testing that given the method we can find the specific parameters
        Parameters p2 = Parameters.findParam("x", pList);
        Parameters p3= new Parameters("x", "int");
		Parameters.addParameterCLI("class", "a" , "x", "int", null , true, b);

        Model.clearCollection();
        Model.getNoClassDupes().clear();
    }

    @Test
    public void deleteParamsDNE() {
        UML.addClass("class");
        Methods.addMethod("class", "a", "String");

		Parameters p1= new Parameters("x1", "int");
        Parameters p2= new Parameters("x2", "String");
        Parameters p3= new Parameters("x3", "Object");

		Parameters.addParameter("class", "a" , "x1", "int", null , true);
        Parameters.addParameter("class", "a" , "x2", "String", null , true);
        Parameters.addParameter("class", "a" , "x3", "Object", null , true);

        ArrayList<Parameters> pList1 = Parameters.findMethod("class", "a");
        UML.addClass("class");
        Methods.addMethod("class", "b", "String");
        Parameters.addParameter("class", "b" , "x2", "String", null , true);
        Parameters.addParameter("class", "b" , "x3", "Object", null , true);
        
        Parameters.deleteParameter("class", "a", "y1", null , true);
        ArrayList<Parameters> pList2 = Parameters.findMethod("class", "b");
        assertFalse("Are the params the same?", MethodOverloading.compareParams(pList1, pList2, "Random String"));
       
        Parameters.deleteParameter("class", "abc", "y1", pList2, false);
        
        Model.clearCollection();
        Model.getNoClassDupes().clear();
    }
    
    @Test
    public void deleteParamsDNE1() {
        UML.addClass("class");
        Methods.addMethod("class", "a", "String");

		Parameters p1= new Parameters("x1", "int");
        Parameters p2= new Parameters("x2", "String");
        Parameters p3= new Parameters("x3", "Object");

		Parameters.addParameter("class", "a" , "x1", "int", null , true);
        Parameters.addParameter("class", "a" , "x2", "String", null , true);
        Parameters.addParameter("class", "a" , "x3", "Object", null , true);

        ArrayList<Parameters> pList1 = Parameters.findMethod("class", "a");
        UML.addClass("class");
        Methods.addMethod("class", "b", "String");
        Parameters.addParameter("class", "b" , "x2", "String", null , true);
        Parameters.addParameter("class", "b" , "x3", "Object", null , true);
        
        ArrayList<String> b = new ArrayList<>();
        Parameters.deleteParameterCLI("class", "a", "y1", null , true,b);
        ArrayList<Parameters> pList2 = Parameters.findMethod("class", "b");
        assertFalse("Are the params the same?", MethodOverloading.compareParams(pList1, pList2, "Random String"));
       
        Parameters.deleteParameterCLI("class", "abc", "y1", pList2, false, b);
        
        
        Model.clearCollection();
        Model.getNoClassDupes().clear();
    }

    @Test
    public void deleteAllParamsDNE() {
        UML.addClass("class");
        Methods.addMethod("class", "a", "String");

        ArrayList<Parameters> pList1 = Parameters.findMethod("class", "a");        
        Parameters.deleteAllParameters("class", "a", null , true);
        
        assertFalse(Parameters.deleteAllParameters("class", "a", null , true));
       
        Model.clearCollection();
        Model.getNoClassDupes().clear();
    }
    
    @Test
    public void deleteAllParamsDNE1() {
        UML.addClass("class");
        Methods.addMethod("class", "a", "String");

        ArrayList<Parameters> pList1 = Parameters.findMethod("class", "a");        
        Parameters.deleteAllParameters("class", "a", null , true);
        ArrayList<String> b = new ArrayList<>();
        assertFalse(Parameters.deleteAllParametersCLI("class", "a", null , true,b));
       
        Model.clearCollection();
        Model.getNoClassDupes().clear();
    }
    @Test
    public void deleteAllParamsDNE2() {
        UML.addClass("class");
        Methods.addMethod("class", "a", "String");

                
        Parameters.deleteAllParameters("class", "a", null , true);
        ArrayList<String> b = new ArrayList<>();
        assertFalse(Parameters.deleteAllParametersCLI("class", "a", null , true,b));
       
        Model.clearCollection();
        Model.getNoClassDupes().clear();
    }
}
