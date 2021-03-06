package uml;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import static org.junit.Assert.*;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Jsontests {
	@Test 
	public void saveandLoadTestsBasic(){
		UML.addClass("a");
		Methods.addMethod("a", "b", "int");
		String s = "[{\"name\":\"a\",\"fields\":[],\"methods\":[{\"name\":\"b\",\"return_type\":\"int\",\"params\":[]}],\"relationships\":[],\"position_x\":0,\"position_y\":0}]";

		assertEquals("Doesn't work", s,  JsonFile.jsonString());
		Model.clearCollection();
		Model.getJLabels().clear();
		//Model.getNoClassDupes().clear();
	}public Jsontests() {
		// TODO Auto-generated constructor stub
	}
	@Test
	public void setCollection() {
		String loaded = "[{\"name\":\"a\",\"fields\":[],\"methods\":[{\"name\":\"b\",\"return_type\":\"int\",\"params\":[]}],\"relationships\":[],\"position_x\":0,\"position_y\":0}]";;
		
		Type type = new TypeToken<ArrayList<UML>>(){
		}.getType();
		
		ArrayList<UML> newCollection = new Gson().fromJson(loaded, type); 

		Model.setCollection(newCollection);
		
		Model.clearCollection();
		Model.getJLabels().clear();
		Model.getNoClassDupes().clear();
		Model.clearArrows();

	}

	// @Test
	// public void saveAndLoadTestsAdvanced(){

	//     String s = "[{\"name\":\"alpha\",\"fields\":[],\"methods\":[{\"name\":\"method1\",\"return_type\":\"string\",\"params\":[{\"name\":\"x\",\"type\":\"int\"}]}],\"relationships\":[{\"source\":\"alpha\",\"destination\":\"beta\",\"type\":\"aggregation\"},{\"source\":\"alpha\",\"destination\":\"delta\",\"type\":\"inheritance\"}]},{\"name\":\"beta\",\"fields\":[],\"methods\":[{\"name\":\"method2\",\"return_type\":\"int\",\"params\":[]}],\"relationships\":[]},{\"name\":\"delta\",\"fields\":[],\"methods\":[],\"relationships\":[]}]";
	//     JsonFile.load(s, Model.getCollection());

	//     assertEquals("Doesn't work", s,  JsonFile.save(Model.getCollection()));
	//     Model.clearCollection();
	//     Model.getJLabels().clear();
	// }

}