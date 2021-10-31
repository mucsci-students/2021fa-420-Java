package uml;
import java.util.ArrayList;
import java.util.HashSet;

public class Model {
    
	//This set is to make sure there are no classes with the same name.
	private static HashSet<String> noClassDupes = new HashSet<String>();
	//This is the Array list that should hold all the objects
	private static ArrayList<UML> collection = new ArrayList<UML>();
	//This is the Array list that holds all the JLabels
	private static ArrayList<BoxObject> jlabels = new ArrayList<BoxObject>();

    public static ArrayList<UML> getCollection() {
		return collection;
	}

	public static void setCollection(ArrayList<UML> newCollection){
		collection = newCollection;
	}

	public static void clearCollection(){
		collection.clear();
	}

	public static HashSet<String> getNoClassDupes() {
		return noClassDupes;
	}

	public static ArrayList<BoxObject> getJLabels() {
		return jlabels;
	}

}
