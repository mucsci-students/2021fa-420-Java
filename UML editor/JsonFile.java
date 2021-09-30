import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.*;

public class JsonFile {

    // Saves the ArrayList of UML objects into a json string format
	public static String save(ArrayList<UML> collection) {
		Gson gson = new Gson();
		// Converts the list to JSON
		String saveFile = gson.toJson(collection);
		return saveFile;

	}

	// Loads a String with a JSON format and turns it into an ArrayList of UML objects
	// CAN'T CATCH ERRORS YET BECAUSE OUR 420 CLASS DIDN'T DECIDE ON A JSON FORMAT
	public static void load(String loaded, ArrayList<UML> collection) {
		// Tells the Gson converter that we want an ArrayList of UML objects
		Type type = new TypeToken<ArrayList<UML>>(){}.getType();
		// Puts the JSON string and determines the type of list needed and makes a new ArrayList with this information
		ArrayList<UML> newCollection = new Gson().fromJson(loaded, type);
		// Empties the current ArrayList
		UML.clearCollection();

		//Need to remove the current no dupes and replace it with the loaded dupes
		HashSet<String> noDupes = UML.getNoClassDupes();
		noDupes.clear();

		//Inserts class names into no dupes
		for(UML u: newCollection){
			noDupes.add(u.getClassName());
		}
		// The new collection of the loaded UML object
		UML.setCollection(newCollection);

	}
}
