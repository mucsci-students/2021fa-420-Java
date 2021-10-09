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
					UML.addClass(className);
					View.inputPanel.setVisible(false);
					View.textField.setText("");
				}
				else {
					View.outputLbl.setText("Invalid input");
				}
			}

			else if(command.equals("Remove Class")) {
				if(input.hasNext()) {
					String className = input.next();
					UML.deleteClass(className);
					View.inputPanel.setVisible(false);
					View.textField.setText("");
				}
				else {
					View.outputLbl.setText("Invalid input");
				}
			}

			else if(command.equals("Rename Class")) {
				if(input.hasNext()) {
					String oldName = input.next();
					if(input.hasNext()) {
						String newName = input.next();
						UML.renameClass(oldName, newName);
						View.inputPanel.setVisible(false);
						View.textField.setText("");
					}
					else {
						View.outputLbl.setText("Invalid input");
					}
				}
				else {
					View.outputLbl.setText("Invalid input");
				}
			}

			else if(command.equals("Add Method")) {
				if(input.hasNext()) {
					String className = input.next();
					if(input.hasNext()) {
						String methodName = input.next();
						if(input.hasNext()) {
							String retType = input.next();
							Methods.addMethod(className, methodName, retType);
							View.inputPanel.setVisible(false);
							View.textField.setText("");
						}
						else {
							View.outputLbl.setText("Invalid input");
						}
					}
					else {
						View.outputLbl.setText("Invalid input");
					}
				}
				else {
					View.outputLbl.setText("Invalid input");
				}
			}

			else if(command.equals("Remove Method")) {
				if(input.hasNext()) {
					String className = input.next();
					if(input.hasNext()) {
						String methodName = input.next();
						Methods.removeMethod(className, methodName);
						View.inputPanel.setVisible(false);
						View.textField.setText("");
					}
					else {
						View.outputLbl.setText("Invalid input");
					}
				}
				else {
					View.outputLbl.setText("Invalid input");
				}
			}

			else if(command.equals("Remove All Methods")) {
				if(input.hasNext()) {
					String className = input.next();
					Methods.removeAllMethods(className);
					View.inputPanel.setVisible(false);
					View.textField.setText("");
				}
				else {
					View.outputLbl.setText("Invalid input");
				}
			}

			else if(command.equals("Rename Method")) {
				if(input.hasNext()) {
					String className = input.next();
					if(input.hasNext()) {
						String oldName = input.next();
						if(input.hasNext()) {
							String newName = input.next();
							Methods.renameMethod(className, oldName, newName);
							View.inputPanel.setVisible(false);
							View.textField.setText("");
						}
						else {
							View.outputLbl.setText("Invalid input");
						}
					}
					else {
						View.outputLbl.setText("Invalid input");
					}
				}
				else {
					View.outputLbl.setText("Invalid input");
				}
			}

			else if(command.equals("Add Parameter")) {
				if(input.hasNext()) {
					String className = input.next();
					if(input.hasNext()) {
						String methodName = input.next();
						if(input.hasNext()) {
							String paramName = input.next();
							if(input.hasNext()) {
								String type = input.next();
								Parameters.addParameter(className, methodName, paramName, type);
								View.inputPanel.setVisible(false);
								View.textField.setText("");
							}
							else {
								View.outputLbl.setText("Invalid input");
							}
						}
						else {
							View.outputLbl.setText("Invalid input");
						}
					}
					else {
						View.outputLbl.setText("Invalid input");
					}
				}
				else {
					View.outputLbl.setText("Invalid input");
				}
			}

			else if(command.equals("Remove Parameter")) {

			}

			else if(command.equals("Remove All Parameters")) {

			}

			else if(command.equals("Rename Parameter")) {

			}

			else if(command.equals("Change All Parameters")) {

			}

			else if(command.equals("Add Field")) {
				if(input.hasNext()) {
					String className = input.next();
					if(input.hasNext()) {
						String fieldName = input.next();
						if(input.hasNext()) {
							String type = input.next();
							Fields.addField(className, fieldName, type);
							View.textField.setText("");
							View.inputLbl.setText("<html><div style='text-align:center'>Would you like to add<br>another field? (yes / no)</div></html>");
							command = "Response Add Field";
						}
						else {
							View.outputLbl.setText("Invalid input");
						}
					}
					else {
						View.outputLbl.setText("Invalid input");
					}
				}
				else {
					View.outputLbl.setText("Invalid input");
				}
			}

			else if(command.equals("Response Add Field")) {
				if(input.hasNext()) {
					String answer = input.next();
					if(!answer.equals("yes") && !answer.equals("no")) {
						View.inputLbl.setText("<html><div style='text-align:center'>Please respond with<br>yes or no!</div></html>");
					}
					else if(answer.equals("yes")) {
						View.inputLbl.setText("<html><div style='text-align:center'>What class are<br>you adding to?<br><br>What would you like to<br>name the new field?<br><br>What type do you want<br>the new field to have?<br><div></html>");
						command = "Add Field";
						View.textField.setText("");
					}
					else if(answer.equals("no")) {
						View.inputPanel.setVisible(false);
						View.textField.setText("");
					}
				}
				else {
					View.outputLbl.setText("Invalid input");
				}
			}

			else if(command.equals("Remove Field")) {
				if(input.hasNext()) {
					String className = input.next();
					if(input.hasNext()) {
						String fieldName = input.next();
						Fields.removeField(className, fieldName);
						View.textField.setText("");
						View.inputLbl.setText("<html><div style='text-align:center'>Would you like to remove<br>another field? (yes / no)</div></html>");
						command = "Response Remove Field";
					}
					else {
						View.outputLbl.setText("Invalid input");
					}
				}
				else {
					View.outputLbl.setText("Invalid input");
				}
			}

			else if(command.equals("Response Remove Field")) {
				if(input.hasNext()) {
					String answer = input.next();
					if(!answer.equals("yes") && !answer.equals("no")) {
						View.inputLbl.setText("<html><div style='text-align:center'>Please respond with<br>yes or no!</div></html>");
					}
					else if(answer.equals("yes")) {
						View.inputLbl.setText("<html><div style='text-align:center'>What class are<br>you removing from?<br><br>What field are<br>you removing?<div></html>");
						command = "Remove Field";
						View.textField.setText("");
					}
					else if(answer.equals("no")) {
						View.inputPanel.setVisible(false);
						View.textField.setText("");
					}
				}
				else {
					View.outputLbl.setText("Invalid input");
				}
			}

			else if(command.equals("Rename Field")) {
				if(input.hasNext()) {
					String className = input.next();
					if(input.hasNext()) {
						String oldName = input.next();
						if(input.hasNext()) {
							String newName = input.next();
							Fields.renameField(className, oldName, newName);
							View.inputPanel.setVisible(false);
							View.textField.setText("");
						}
						else {
							View.outputLbl.setText("Invalid input");
						}
					}
					else {
						View.outputLbl.setText("Invalid input");
					}
				}
				else {
					View.outputLbl.setText("Invalid input");
				}
			}

			else if(command.equals("Add Relationship")) {
				if(input.hasNext()) {
					String sourceName = input.next();
					if(input.hasNext()) {
						String destName = input.next();
						if(input.hasNext()) {
							String type = input.next();
							if(Relationships.testType(type)) {

								if(UML.getNoClassDupes().contains(sourceName)) {
									if(UML.getNoClassDupes().contains(destName)) {
										for(UML umlDest : UML.getCollection()) {
											if(umlDest.getClassName().equals(destName)) {
												for(UML umlSrc : UML.getCollection()) {
													if(umlSrc.getClassName().equals(sourceName)) {
														Relationships.addRel(umlSrc, umlDest, type);
														View.inputPanel.setVisible(false);
														View.textField.setText("");
														break;
													}
												}
											}
										}
									}
									else {
										View.outputLbl.setText("Destination class does not exist!");
									}
								}
								else {
									View.outputLbl.setText("Source class does not exist!");
								}
							}
							else {
								if(Driver.guiUp) {
									View.outputLbl.setText("Type must be aggregation, composition, inheritance, or realization.");
								}
								else {
									System.out.println("Type must be aggregation, composition, inheritance, or realization.");
								}
							}
						}
						else {
							View.outputLbl.setText("Invalid input");
						}
					}
					else {
						View.outputLbl.setText("Invalid input");
					}
				}
				else {
					View.outputLbl.setText("Invalid input");
				}
			}

			else if(command.equals("Remove Relationship")) {
				if(input.hasNext()) {
					String srcName = input.next();
					if(input.hasNext()) {
						String destName = input.next();
						Relationships.delRel(srcName, destName);
						View.inputPanel.setVisible(false);
						View.textField.setText("");
					}
					else {
						View.outputLbl.setText("Invalid input");
					}
				}
				else {
					View.outputLbl.setText("Invalid input");
				}
			}

			else if(command.equals("Change Relationship")) {
				if(input.hasNext()) {
					String srcName = input.next();
					if(input.hasNext()) {
						String destName = input.next();
						if(input.hasNext()) {
							String type = input.next();
							Relationships.changeRel(srcName, destName, type);
							View.inputPanel.setVisible(false);
							View.textField.setText("");
						}
						else {
							View.outputLbl.setText("Invalid input");
						}
					}
					else {
						View.outputLbl.setText("Invalid input");
					}
				}
				else {
					View.outputLbl.setText("Invalid input");
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
								View.inputPanel.setVisible(false);
								View.textField.setText("");
								break;
							}
						}
					}
					else {
						View.outputLbl.setText("That class does not exist!");
					}
				}
				else {
					View.outputLbl.setText("Invalid input");
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
								View.inputPanel.setVisible(false);
								View.textField.setText("");
								break;
							}
						}
					}
					else {
						View.outputLbl.setText("That class does not exist");
					}
				}
				else {
					View.outputLbl.setText("Invalid input");
				}
			}

			else if(command.equals("Load")) {
				if(input.hasNext()) {
					JsonFile.load(input.next(), UML.getCollection());
					View.outputLbl.setText("File Loaded!");
					View.inputPanel.setVisible(false);
					View.textField.setText("");
				}
			}
			input.close();
		}

		else if(e.getActionCommand().equals("Add Class")) {
			command = "Add Class";
			View.inputLbl.setText("<html><div style='text-align:center'>What would you like<br>to name the new class?</div></html>");
			View.inputPanel.setVisible(true);
		}

		else if(e.getActionCommand().equals("Remove Class")) {
			command = "Remove Class";
			View.inputLbl.setText("<html><div style='text-align:center'>What class would<br>you like to remove?</div></html>");
			View.inputPanel.setVisible(true);
		}

		else if(e.getActionCommand().equals("Rename Class")) {
			command = "Rename Class";
			View.inputLbl.setText("<html><div style='text-align:center'>What class would you<br>like to rename?<br><br>What is the new<br>class name?</div></html>");
			View.inputPanel.setVisible(true);
		}

		else if(e.getActionCommand().equals("Add Method")) {
			command = "Add Method";
			View.inputLbl.setText("<html><div style='text-align:center'>What class are you<br>adding to?<br><br>What is the name of<br>the new method?<br><br>What is the method's<br>return type?</div></html>");
			View.inputPanel.setVisible(true);
		}

		else if(e.getActionCommand().equals("Remove Method")) {
			command = "Remove Method";
			View.inputLbl.setText("<html><div style='text-align:center'>What class are you<br>removing from?<br><br>What method are you<br>removing?</div></html>");
			View.inputPanel.setVisible(true);
		}

		else if(e.getActionCommand().equals("Remove All Methods")) {
			command = "Remove All Methods";
			View.inputLbl.setText("<html><div style='text-align:center'>What class are you<br>removing all methods<br>from?</div></html>");
			View.inputPanel.setVisible(true);
		}

		else if(e.getActionCommand().equals("Rename Method")) {
			command = "Rename Method";
			View.inputLbl.setText("<html><div style='text-align:center'>What class are you<br>making modifications in?<br><br>What method are<br>you renaming?<br><br>What would you like to<br>rename the method to?</div></html>");
			View.inputPanel.setVisible(true);
		}

		else if(e.getActionCommand().equals("Add Parameter")) {
			command = "Add Parameter";
			View.inputLbl.setText("<html><div style='text-align:center'>What class would you<br>like to add a parameter to?<br><br>What method would you<br>like to add a parameter to?<br><br>What is the<br>parameter name?<br><br>What is the<br>parameter type?</div></html>");
			View.inputPanel.setVisible(true);
		}

		else if(e.getActionCommand().equals("Remove Parameter")) {
			command = "Remove Parameter";
		}

		else if(e.getActionCommand().equals("Remove Parameter")) {
			command = "Remove All Parameters";
		}

		else if(e.getActionCommand().equals("Rename Parameter")) {
			command = "Rename Parameter";
		}

		else if(e.getActionCommand().equals("Change All Parameters")) {
			command = "Change All Parameters";
		}

		else if(e.getActionCommand().equals("Add Field")) {
			command = "Add Field";
			View.inputLbl.setText("<html><div style='text-align:center'>What class are<br>you adding to?<br><br>What would you like to<br>name the new field?<br><br>What type do you want<br>the new field to have?<div></html>");
			View.inputPanel.setVisible(true);
		}

		else if(e.getActionCommand().equals("Remove Field")) {
			command = "Remove Field";
			View.inputLbl.setText("<html><div style='text-align:center'>What class are<br>you removing from?<br><br>What field are<br>you removing?<div></html>");
			View.inputPanel.setVisible(true);
		}

		else if(e.getActionCommand().equals("Rename Field")) {
			command = "Rename Field";
			View.inputLbl.setText("<html><div style='text-align:center'>What class are you<br>making modifications in?<br><br>What field are<br>you renaming?<br><br>What would you like to<br>rename the field to?<div></html>");
			View.inputPanel.setVisible(true);
		}

		else if(e.getActionCommand().equals("Add Relationship")) {
			command = "Add Relationship";
			View.inputLbl.setText("<html><div style='text-align:center'>What class would you<br>like to be the source<br>of the relation?<br><br>What is the destination<br>of the relation?<br><br>What is the type of the<br>relation? Type must be<br>aggregation, composition,<br>inheritance, or realization.<div></html>");
			View.inputPanel.setVisible(true);
		}

		else if(e.getActionCommand().equals("Remove Relationship")) {
			command = "Remove Relationship";
			View.inputLbl.setText("<html><div style='text-align:center'>What class would you like<br>to delete a relation from?<br><br>What is the destination<br>of the relation?<div></html>");
			View.inputPanel.setVisible(true);
		}

		else if(e.getActionCommand().equals("Change Relationship")) {
			command = "Change Relationship";
			View.inputLbl.setText("<html><div style='text-align:center'>What is the source<br>class of the relationship<br>you would like to change?<br><br>What is the destination<br>class of the relationship<br>you would like to change?<br><br>What would you like<br>to change the type to?<div></html>");
			View.inputPanel.setVisible(true);
		}

		else if(e.getActionCommand().equals("List Classes")) {
			String text = "No classes exist!";
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
			View.inputPanel.setVisible(true);
		}

		else if(e.getActionCommand().equals("List Relationships")) {
			command = "List Relationships";
			View.inputLbl.setText("<html><div style='text-align:center'>What class would<br>you like to list the<br>relationships of?</div></html>");
			View.inputPanel.setVisible(true);
		}

		else if(e.getActionCommand().equals("Save")) {
			View.textFieldJSON.setText(JsonFile.save(UML.getCollection()));
			View.outputLbl.setText("File Saved!");
		}

		else if(e.getActionCommand().equals("Load")) {
			command = "Load";
			View.inputLbl.setText("<html><div style='text-align:center'>Insert json string<br>you want to load.<br>By clicking enter, you<br>agree all unsaved work<br>will be deleted.</div></html>");
			View.inputPanel.setVisible(true);
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
