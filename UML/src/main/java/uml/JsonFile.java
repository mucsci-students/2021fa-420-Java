package uml;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JsonFile {

	// Saves the ArrayList of UML objects into a json string format
	public static void save(ArrayList<UML> collection) {
		// JFileChooser points to user's default directory
		JFileChooser j = new JFileChooser();
		// Only allows jpg/jpeg files to show
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Json File", "json");
		j.setFileFilter(filter);
		// Open the save dialog
		int response = j.showSaveDialog(null);
		// User saved image
		if (response == JFileChooser.APPROVE_OPTION) {
			File file;
			String name = j.getSelectedFile().getName();
			// Prevents new files being created when they already exist
			if (name.contains(".json")) {
				int i = name.lastIndexOf('.');
				name = name.substring(0, i);
			}
			file = new File(j.getSelectedFile().getParent(), name + ".json");

			try {
				// File does not exist and is created
				if (file.createNewFile()) {
					if (Driver.guiUp) {
						JOptionPane.showMessageDialog(View.frmUmlEditor, "File Created!", "File",
								JOptionPane.PLAIN_MESSAGE);
					} else {
						System.out.println("File Created!");
					}
				}
				// File exists and is overwritten
				else {
					if (Driver.guiUp) {
						JOptionPane.showMessageDialog(View.frmUmlEditor, "This file exists, it was overwritten!",
								"File", JOptionPane.PLAIN_MESSAGE);
					} else {
						System.out.println("This file exists, it was overwritten!");
					}
				}
				Gson gson = new Gson();
				// Converts the list to JSON
				String saveFile = "{\"classes\":"+gson.toJson(collection) +"}";
				FileWriter writer = new FileWriter(file);
				writer.write(saveFile);
				writer.close();

			} catch (IOException e) {
				if (Driver.guiUp) {
					JOptionPane.showMessageDialog(View.frmUmlEditor, e.getMessage(), "File Error!",
							JOptionPane.ERROR_MESSAGE);
				} else {
					System.out.println(e.getMessage());
				}
			}
		}
		// User cancelled save
		else {
			if (!Driver.guiUp) {
				System.out.println("File save operation was cancelled!");
			}
		}
	}

	// Loads a String with a JSON format and turns it into an ArrayList of UML
	// objects
	public static boolean load(String loaded, ArrayList<UML> collection) {
		try {
			// Tells the Gson converter that we want an ArrayList of UML objects
			Type type = new TypeToken<ArrayList<UML>>() {
			}.getType();
			// Puts the JSON string and determines the type of list needed and makes a new
			// ArrayList with this information
			ArrayList<UML> newCollection = new Gson().fromJson(loaded, type);

			// Empties the current ArrayList
			for (BoxObject obj : Model.getJLabels()) {
				View.panel.remove(obj.getLabel());
			}
			Model.getJLabels().clear();
			if (!StartUp.CLIstart){
			View.panel.repaint();
			}
			Model.clearCollection();
			Model.clearArrows();

			// Need to remove the current no dupes and replace it with the loaded dupes
			HashSet<String> noDupes = Model.getNoClassDupes();
			noDupes.clear();

			// Inserts class names into no dupes
			for (UML u : newCollection) {
				noDupes.add(u.getClassName());
			}

			// System.out.println(save(newCollection));
			Model.setCollection(newCollection);

			// Creates JLabels for gui
			for (UML uml : Model.getCollection()) {
				BoxObject.createBox(uml);
			}
			for (UML uml : Model.getCollection()) {
				for (Relationships rel : uml.getRels()) {
					Model.getArrows().add(new Arrows(BoxObject.findLabel(rel.getSource()),
							BoxObject.findLabel(rel.getDestination()), rel.getType()));
				}
			}
			if (!StartUp.CLIstart){
			View.panel.repaint();
			}
			BoxObject.updateBoxes();
			if (!StartUp.CLIstart){
			Arrows.updateArrows(View.panel.getGraphics());
			}

		} catch (com.google.gson.JsonSyntaxException e) {
			System.out.println("Not a valid Json file!");
			return false;
		}
		return true;
	}

	public static boolean load() {
		// JFileChooser points to user's default directory
		JFileChooser j = new JFileChooser();
		// Only allows jpg/jpeg files to show
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Json File", "json");
		j.setFileFilter(filter);
		// Open the save dialog
		int response = j.showOpenDialog(null);
		// User saved image
		if (response == JFileChooser.APPROVE_OPTION) {
			File file;
			String name = j.getSelectedFile().getName();
			// Prevents new files being created when they already exist
			if (name.contains(".json")) {
				int i = name.lastIndexOf('.');
				name = name.substring(0, i);
			}
			file = new File(j.getSelectedFile().getParent(), name + ".json");

			try {
				FileReader reader = new FileReader(file);
				Scanner scanner = new Scanner(reader);
				String json = scanner.nextLine();
				json = json.substring(11, json.length() -1);
				System.out.println(json);
				
				scanner.close();
				return load(json, Model.getCollection());

			} catch (IOException e) {
				if (Driver.guiUp) {
					JOptionPane.showMessageDialog(View.frmUmlEditor, e.getMessage(), "File Error!",
							JOptionPane.ERROR_MESSAGE);
				} else {
					System.out.println(e.getMessage());
				}
			}
		}
		// User cancelled save
		else {
			if (!Driver.guiUp) {
				System.out.println("File save operation was cancelled!");
			}
		}
		return false;
	}

	public static String jsonString() {
		Gson gson = new Gson();
		// Converts the list to JSON
		String saveFile = gson.toJson(Model.getCollection());
		return saveFile;
	}
}
