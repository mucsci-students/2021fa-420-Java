import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Scanner;

public class Controller implements ActionListener {
	
	private String command;
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Enter")) {
			Scanner input = new Scanner(View.textField.getText().toLowerCase());
			if(command.equals("Add Class")) {
				if(input.hasNext()) {
					String className = input.next();
					if(!UML.getNoClassDupes().contains(className)) {
						UML.addClass(className);
						View.outputLbl.setText("Class Created!");
						View.panel_2.setVisible(false);
						View.textField.setText("");
					}
					else {
						View.outputLbl.setText("That class already exists.");
					}
				}
			}
			else if(command.equals("Remove Class")) {
				if(input.hasNext()) {
					String className = input.next();
					if(UML.getNoClassDupes().contains(className)) {
						UML.deleteClass(className);
						View.outputLbl.setText("Class Deleted!");
						View.panel_2.setVisible(false);
						View.textField.setText("");
					}
					else {
						View.outputLbl.setText("That class does not exist.");
					}
				}
				else {
					View.outputLbl.setText("Error: invalid input");
				}
			}
			else if(command.equals("Rename Class")) {
				if(input.hasNext()) {
					String oldName = input.next();
					if(input.hasNext()) {
						String newName = input.next();
						if(UML.getNoClassDupes().contains(oldName) && !UML.getNoClassDupes().contains(newName)) {
							UML.renameClass(oldName, newName);
							View.outputLbl.setText("Class Renamed!");
							View.panel_2.setVisible(false);
							View.textField.setText("");
						}
						else if(!UML.getNoClassDupes().contains(oldName)) {
							View.outputLbl.setText("That class does not exist.");
						}
						else {
							View.outputLbl.setText("That class already exists.");
						}
					}
					else {
						View.outputLbl.setText("Error: invalid input");
					}
				}
				else {
					View.outputLbl.setText("Error: invalid input");
				}
			}
			else if(command.equals("List Contents")) {
				if(input.hasNext()) {
					String toListContents = input.next();
					if(UML.getNoClassDupes().contains(toListContents)) {
						for(UML uml : UML.getCollection()) {
							if(uml.getClassName().equals(toListContents)) {
								uml.listFields();
								uml.listMethods();
								View.outputLbl.setText(View.outputText);
								View.panel_2.setVisible(false);
								View.textField.setText("");
								break;
							}
						}
					}
					else {
						View.outputLbl.setText("Error: class does not exist");
					}
				}
				else {
					View.outputLbl.setText("Error: invalid input");
				}
			}
			else if(command.equals("List Relationships")) {
				if(input.hasNext()) {
					String toListRels = input.next();
					if(UML.getNoClassDupes().contains(toListRels)) {
						for(UML uml : UML.getCollection()) {
							if(uml.getClassName().equals(toListRels)) {
								uml.listRelationships();
								View.outputLbl.setText(View.outputText);
								View.panel_2.setVisible(false);
								View.textField.setText("");
								break;
							}
						}
					}
					else {
						View.outputLbl.setText("Error: class does not exist");
					}
				}
				else {
					View.outputLbl.setText("Error: invalid input");
				}
			}
			input.close();
		}

		else if(e.getActionCommand().equals("Add Class")) {
			command = "Add Class";
			View.inputLbl.setText("<html><div style='text-align:center'>What would you<br>like to name the<br>new class?</div></html>");
			View.panel_2.setVisible(true);
		}

		else if(e.getActionCommand().equals("Remove Class")) {
			command = "Remove Class";
			View.inputLbl.setText("<html><div style='text-align:center'>What class would<br>you like to remove?</div></html>");
			View.panel_2.setVisible(true);
		}

		else if(e.getActionCommand().equals("Rename Class")) {
			command = "Rename Class";
			View.inputLbl.setText("<html><div style='text-align:center'>What class would<br>you like to rename and what<br>is the new name?</div></html>");
			View.panel_2.setVisible(true);
		}

		else if(e.getActionCommand().equals("Add Method")) {
			command = "Add Method";
			View.inputLbl.setText("<html><div style='text-align:center'>What class would<br>you like to rename and what<br>is the new name?</div></html>");
			View.panel_2.setVisible(true);
		}

		else if(e.getActionCommand().equals("Remove Method")) {
			command = "Remove Method";
		}

		else if(e.getActionCommand().equals("Rename Method")) {
			command = "Rename Method";
		}

		else if(e.getActionCommand().equals("Add Parameter")) {
			command = "Add Parameter";
		}

		else if(e.getActionCommand().equals("Remove Parameter")) {
			command = "Remove Parameter";
		}

		else if(e.getActionCommand().equals("Rename Parameter")) {
			command = "Rename Parameter";
		}

		else if(e.getActionCommand().equals("Add Field")) {
			command = "Add Field";
		}

		else if(e.getActionCommand().equals("Remove Field")) {
			command = "Remove Field";
		}

		else if(e.getActionCommand().equals("Rename Field")) {
			command = "Rename Field";
		}

		else if(e.getActionCommand().equals("Add Relationship")) {
			command = "Add Relationship";
		}

		else if(e.getActionCommand().equals("Remove Relationship")) {
			command = "Remove Relationship";
		}

		else if(e.getActionCommand().equals("List Classes")) {
			String text = "No classes exist.";
			if(UML.getCollection().size() >= 1) {
				text = "<html>Classes:<br>" + UML.getCollection().get(0).getClassName();
				for(int i = 1; i < UML.getCollection().size(); i++) {
					text = text + "<br>" + UML.getCollection().get(i).getClassName();
				}
			}
			View.outputLbl.setText(text);
		}

		else if(e.getActionCommand().equals("List Contents")) {
			command = "List Contents";
			View.inputLbl.setText("<html><div style='text-align:center'>What class would<br>you like to list the<br>contents of?</div></html>");
			View.panel_2.setVisible(true);
		}

		else if(e.getActionCommand().equals("List Relationships")) {
			command = "List Relationships";
			View.inputLbl.setText("<html><div style='text-align:center'>What class would<br>you like to list the<br>relationships of?</div></html>");
			View.panel_2.setVisible(true);
		}

		else if(e.getActionCommand().equals("Save")) {
			
		}

		else if(e.getActionCommand().equals("Load")) {
			command = "Load";
		}

		else if(e.getActionCommand().equals("Help")) {
			View.outputLbl.setText("<html>For commands with multiple inputs, put them in order separated with a space"
					+ "<br>add class - creates a new class"
					+ "<br>delete class - deletes a class"
					+ "<br>rename class - renames a class"
					+ "<br>add method - creates a new method for a class"
					+ "<br>delete method - deletes a method from a class"
					+ "<br>rename method - renames a method in a class"
					+ "<br>add field - creates a new field for a class"
					+ "<br>delete field - deletes a field from a class"
					+ "<br>rename field - renames a field from a class"
					+ "<br>add parameter - creates a parameter in a method for a class"
					+ "<br>delete parameter - deletes a parameter from a method in a class"
					+ "<br>change parameter - renames a parameter in a method in a class"
					+ "<br>add relation - creates a relationship between two classes"
					+ "<br>delete relation - deletes a relationship between two classes"
					+ "<br>change relationship type - changes a relationship type"
					+ "<br>list classes - lists all the classes made"
					+ "<br>list contents - lists the contents of a specific class"
					+ "<br>list relationships - lists relationships between all classes"
					+ "<br>save - saves current uml file"
					+ "<br>load - loads a uml file"
					+ "<br>help - provides a list of commands usable commands."
					+ "<br>exit - exists the program.");
		}

		else if(e.getActionCommand().equals("CLI")) {
			Driver.guiUp = false;
			View.closeGUI();
			Driver.runCLI();
		}
	}
}
