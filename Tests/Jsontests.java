import org.junit.Test;
import static org.junit.Assert.*;


public class Jsontests {
    @Test 
	public void saveandLoadTestsBasic(){
	
			String s = "[{\"name\":\"a\",\"field\":[],\"method\":[{\"name\":\"b\",\"return_type\":\"int\",\"params\":[]}],\"rels\":[]}]";
            JsonFile.load(s, UML.getCollection());

            assertEquals("Doesn't work", s,  JsonFile.save(UML.getCollection()));
	}
    @Test
    public void saveAndLoadTestsAdvanced(){

        
        String s = "[{\"name\":\"alpha\",\"field\":[],\"method\":[{\"name\":\"method1\",\"return_type\":\"string\",\"params\":[{\"name\":\"x\",\"type\":\"int\"}]}],\"rels\":[{\"source\":\"alpha\",\"destination\":\"beta\",\"type\":\"aggregation\"},{\"source\":\"alpha\",\"destination\":\"delta\",\"type\":\"inheritance\"}]},{\"name\":\"beta\",\"field\":[],\"method\":[{\"name\":\"method2\",\"return_type\":\"int\",\"params\":[]}],\"rels\":[]},{\"name\":\"delta\",\"field\":[],\"method\":[],\"rels\":[]}]";
        JsonFile.load(s, UML.getCollection());
        assertEquals("Doesn't work", s,  JsonFile.save(UML.getCollection()));
    }
    
}
