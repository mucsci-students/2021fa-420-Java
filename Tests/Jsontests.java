import org.junit.Test;
import static org.junit.Assert.*;

public class Jsontests {
    @Test 
	public void saveandLoadTestsBasic(){
	
			String s = "[{\"name\":\"a\",\"fields\":[],\"methods\":[{\"name\":\"b\",\"return_type\":\"int\",\"params\":[]}],\"relationships\":[]}]";
            JsonFile.load(s, UML.getCollection());

            assertEquals("Doesn't work", s,  JsonFile.save(UML.getCollection()));
	}
    @Test
    public void saveAndLoadTestsAdvanced(){

        String s = "[{\"name\":\"alpha\",\"fields\":[],\"methods\":[{\"name\":\"method1\",\"return_type\":\"string\",\"params\":[{\"name\":\"x\",\"type\":\"int\"}]}],\"relationships\":[{\"source\":\"alpha\",\"destination\":\"beta\",\"type\":\"aggregation\"},{\"source\":\"alpha\",\"destination\":\"delta\",\"type\":\"inheritance\"}]},{\"name\":\"beta\",\"fields\":[],\"methods\":[{\"name\":\"method2\",\"return_type\":\"int\",\"params\":[]}],\"relationships\":[]},{\"name\":\"delta\",\"fields\":[],\"methods\":[],\"relationships\":[]}]";
        JsonFile.load(s, UML.getCollection());
        
        assertEquals("Doesn't work", s,  JsonFile.save(UML.getCollection()));
    }
    
}