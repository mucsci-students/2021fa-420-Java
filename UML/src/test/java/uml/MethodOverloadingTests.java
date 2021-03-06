package uml;
import static org.junit.Assert.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MethodOverloadingTests {
	
	
    @Test
    public void findingCorrectMethodsAndCompareParams() {
		// Create a class
		UML.addClass("class");
        Methods.addMethod("class", "a", "String");
		Parameters.addParameter("class", "a" , "x", "int", null , true);
        Methods.addMethod("class", "a", "String");
        ArrayList<String> params= new ArrayList<>();
        params.add("int");

        //Testing Parameters find method, which finds the list of parameters
        ArrayList<Parameters> pList1 = MethodOverloading.findMethod("class", "a", params);
        Methods.addMethod("class", "b", "String");
        Parameters.addParameter("class", "b" , "x", "int", null , true);
        ArrayList<Parameters> pList2 = Parameters.findMethod("class", "b");

        assertTrue("Found correct list", MethodOverloading.compareParams(pList1, pList2, "Useless String"));
        Model.clearCollection();
        Model.getNoClassDupes().clear();
    }
    @Test
    public void containsDuplicateMethods(){
        UML.addClass("class");
        Methods.addMethod("class", "a", "String");
		Parameters.addParameter("class", "a" , "x", "int", null , true);
        Methods.addMethod("class", "a", "String");

        HashSet<String> s = MethodOverloading.containsDuplicateMethods("class");
        assertTrue("Duplicates were found", !(s.isEmpty()));
        Model.clearCollection();
        Model.getNoClassDupes().clear();


    }
    @Test
      public void containsSameSignatureAdding(){
        UML.addClass("class");
        Methods.addMethod("class", "a", "String");
		Parameters.addParameter("class", "a" , "x", "int", null , true);
        Methods.addMethod("class", "a", "String");
        UML OBJ = UML.findUMLOBJ("class");

        ArrayList<Parameters> p= new ArrayList<>();
        Parameters p1 = new Parameters("z", "int");
    
        boolean val = MethodOverloading.containsSameSignatureAdding(OBJ, p, p1, "a");

        assertTrue("The arraylist with added parameter will create a duplicate", val);
        Model.clearCollection();
        Model.getNoClassDupes().clear();

    }
    @Test
      public void containsSameSignatureDeleting(){
        UML.addClass("class");
        Methods.addMethod("class", "a", "String");
		Parameters.addParameter("class", "a" , "x", "int", null , true);
        Methods.addMethod("class", "a", "String");
        UML OBJ = UML.findUMLOBJ("class");

        ArrayList<Parameters> p= new ArrayList<>();
        
        Parameters p1 = new Parameters("x", "int");
        p.add(p1);

        boolean val = MethodOverloading.containsSameSignatureDeleting(OBJ, p, p1, "a");

        assertTrue("The arraylist with added parameter will create a duplicate", val);
        Model.clearCollection();
        Model.getNoClassDupes().clear();

    }
    @Test
      public void containsSameSignatureDeletingAll(){
        UML.addClass("class");
        Methods.addMethod("class", "a", "String");
		Parameters.addParameter("class", "a" , "x", "int", null , true);
        Methods.addMethod("class", "a", "String");
        UML OBJ = UML.findUMLOBJ("class");

        ArrayList<Parameters> p= new ArrayList<>();
        Parameters p1 = new Parameters("z", "int");
        Parameters p2 = new Parameters("x", "Object");
        p.add(p1);
        p.add(p2);
    
        boolean val = MethodOverloading.containsSameSignatureDeletingAll(OBJ, p, "a");

        assertTrue("The arraylist with added parameter will create a duplicate", val);
        Model.clearCollection();
        Model.getNoClassDupes().clear();

    }
    @Test
      public void containsSameSignatureChanging(){
        UML.addClass("class");
        Methods.addMethod("class", "a", "String");
        Methods.addMethod("class", "a", "String");
        Parameters.addParameter("class", "a" , "y", "String", null , true);
        UML OBJ = UML.findUMLOBJ("class");

        ArrayList<Parameters> p= new ArrayList<>();
        Parameters p1 = new Parameters("x", "int");
        p.add(p1);
    
        boolean val = MethodOverloading.containsSameSignatureChanging(OBJ, p, "a", "x", "z", "String");

        assertTrue("The arraylist with added parameter will create a duplicate", val);
        Model.clearCollection();
        Model.getNoClassDupes().clear();

    }
    @Test
      public void containsSameSignatureChangingAll(){
        UML.addClass("class");
        Methods.addMethod("class", "a", "String");
        Methods.addMethod("class", "a", "String");
        Parameters.addParameter("class", "a" , "y", "String", null , true);
        Parameters.addParameter("class", "a" , "z", "String", null , true);
        UML OBJ = UML.findUMLOBJ("class");

        ArrayList<Parameters> p= new ArrayList<>();
        Parameters p1 = new Parameters("abc", "String");
        Parameters p2 = new Parameters("dce", "String");
        p.add(p1);
        p.add(p2);
    
        boolean val = MethodOverloading.containsSameSignatureChangingAll(OBJ, p, p2, "a");

        assertTrue("The arraylist with added parameter will create a duplicate", val);
        Model.clearCollection();
        Model.getNoClassDupes().clear();


    }
    
    @Test
      public void locatingParameters(){
    	
        UML uml = UML.addClass("class");
        Methods.addMethod("class", "a", "String");
        Parameters.addParameter("class", "a" , "x", "String", null , true);
        Methods.addMethod("class", "a", "String");
        	//Replicates user input 
	        String userInput = String.format("String");
		    ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
		    System.setIn(in);
		    ByteArrayOutputStream out = new ByteArrayOutputStream();
		    PrintStream printStream = new PrintStream(out);
		    System.setOut(printStream);
		    //End of replicating user input
        Parameters.addParameter("class", "a" , "y", "int", null , true);
        Parameters.addParameter("dasdasd", "a" , "y", "int", null , true);
        
        
        Model.clearCollection();
        Model.getNoClassDupes().clear();
    }  
    
    @Test
    public void locatingParametersCLI(){
    	ArrayList<String> a = new ArrayList<String>();
      UML uml = UML.addClass("class");
      Methods.addMethod("class", "a", "String");
      Parameters.addParameterCLI("class", "a" , "x", "String", null , true,a );
      Methods.addMethod("class", "a", "String");
      	//Replicates user input 
	        String userInput = String.format("String");
		    ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
		    System.setIn(in);
		    ByteArrayOutputStream out = new ByteArrayOutputStream();
		    PrintStream printStream = new PrintStream(out);
		    System.setOut(printStream);
		    //End of replicating user input
      Parameters.addParameterCLI("class", "a" , "y", "int", null , true, a);
      Parameters.addParameterCLI("dasdasd", "a" , "y", "int", null , true, a);
      
      
      
      Model.clearCollection();
      Model.getNoClassDupes().clear();
  }  
    
//    @Test
//    public void locatingParametersCLI(){
//  	
//      UML uml = UML.addClass("class");
//      Methods.addMethod("class", "a", "String");
//      Parameters.addParameter("class", "a" , "x", "String", null , true);
//      ArrayList<String> list = new ArrayList<String>();
//      list.add("x");
//      ArrayList<Parameters> p = MethodOverloading.locatingParametersCLI("class","a",list);
//      assertEquals("","x",p.get(0).getParamType());
//      Model.clearCollection();
//      Model.getNoClassDupes().clear();
//  }  
    
}
