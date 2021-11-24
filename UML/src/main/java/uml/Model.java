package uml;

import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;

public class Model {

	// This set is to make sure there are no classes with the same name.
	private static HashSet<String> noClassDupes = new HashSet<String>();
	// This is the Array list that should hold all the objects
	private static ArrayList<UML> collection = new ArrayList<UML>();
	// This is the Array list that holds all the JLabels
	private static ArrayList<BoxObject> jlabels = new ArrayList<BoxObject>();
	// This is the Array list that keeps tracks of the relationship arrows
	private static ArrayList<Arrows> arrows = new ArrayList<Arrows>();

	public static ArrayList<UML> getCollection() {
		return collection;
	}

	public static void setCollection(ArrayList<UML> newCollection) {
		collection = newCollection;
	}

	public static void clearCollection() {
		collection.clear();
	}

	public static HashSet<String> getNoClassDupes() {
		return noClassDupes;
	}

	public static ArrayList<BoxObject> getJLabels() {
		return jlabels;
	}

	public static ArrayList<Arrows> getArrows() {
		return arrows;
	}

	public static void clearArrows() {
		arrows.clear();
	}

	public static void throwingError(String s){
		if (Driver.guiUp) {
			JOptionPane.showMessageDialog(View.frmUmlEditor, s,
					"Error", JOptionPane.ERROR_MESSAGE);
		} else {
			System.out.println(s);
		}
	}
}
