package uml;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Controller implements ActionListener, MouseListener, MouseMotionListener {

	//Lets enter button know what command is running
	private String command;

//For changing all parameters
private HashSet<String> dupes;
private ArrayList<Parameters> pList;
private int counter = 0;
private String classNameCAP;

//For method overloading
private String classNameMO;
private String methodNameMO;
private String oldParamNameMO;
private String paramNameMO;
private String typeMO;

private boolean start = true;
private boolean state = false;

	public void actionPerformed(ActionEvent e) {
		if (start){
			undoredo.stateKeeper();
			start = false;
		}
		if ((state && !(e.getActionCommand().equals("Undo")) && !(e.getActionCommand().equals("Redo")))){
			undoredo.memClear();
		}

		state = false;
		//If enter button is clicked
		if(e.getActionCommand().equals("Enter")) {

			
			//Grabs input from textfield
			Scanner input = new Scanner(View.textField.getText().toLowerCase());
			//If user wanted to add a class
			if(command.equals("Add Class")) {
				//If user inputs info correctly
				if(input.hasNext()) {
					String className = input.next();
					//Takes info and calls addClass
					UML uml = UML.addClass(className);
					BoxObject.createBox(uml);
					View.inputPanel.setVisible(false);
					View.textField.setText("");
					undoredo.stateKeeper();
				}
				else {
					JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);

				}
			}

			//If user wanted to remove a class
			else if(command.equals("Remove Class")) {
				//If user inputs info correctly
				if(input.hasNext()) {
					String className = input.next();
					//Takes info and calls removeClass
					UML.deleteClass(className);
					View.inputPanel.setVisible(false);
					View.textField.setText("");
					undoredo.stateKeeper();
				}
				else {
					JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);

				}
			}

			//If user wanted to rename a class
			else if(command.equals("Rename Class")) {
				//If user inputs info correctly
				if(input.hasNext()) {
					String oldName = input.next();
					if(input.hasNext()) {
						String newName = input.next();
						//Takes info and calls renameClass
						UML.renameClass(oldName, newName);
						View.inputPanel.setVisible(false);
						View.textField.setText("");
						undoredo.stateKeeper();
					}
					else {
						JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);

				}
			}

			//If user wanted to add a method
			else if(command.equals("Add Method")) {
				//If user inputs info correctly
				if(input.hasNext()) {
					String className = input.next();
					if(input.hasNext()) {
						String methodName = input.next();
						if(input.hasNext()) {
							String retType = input.next();
							//Takes info and calls addMethod
							Methods.addMethod(className, methodName, retType);
							View.inputPanel.setVisible(false);
							View.textField.setText("");
							undoredo.stateKeeper();
						}
						else {
							JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);

				}
			}

			//If user wanted to remove a method
			else if(command.equals("Remove Method")) {
				//If user inputs info correctly
				if(input.hasNext()) {
					String className = input.next();
					if(input.hasNext()) {
						String methodName = input.next();
						//Takes info and calls removeMethod
						Methods.removeMethod(className, methodName);
						View.inputPanel.setVisible(false);
						View.textField.setText("");
						undoredo.stateKeeper();
					}
					else {
						JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);

				}
			}

			//If user wanted to remove all methods
			else if(command.equals("Remove All Methods")) {
				//If user inputs info correctly
				if(input.hasNext()) {
					String className = input.next();
					//Takes info and calls removeAllMethods
					Methods.removeAllMethods(className);
					View.inputPanel.setVisible(false);
					View.textField.setText("");
					undoredo.stateKeeper();
				}
				else {
					JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);

				}
			}

			//If user wanted to rename a method
			else if(command.equals("Rename Method")) {
				//If user inputs info correctly
				if(input.hasNext()) {
					String className = input.next();
					if(input.hasNext()) {
						String oldName = input.next();
						if(input.hasNext()) {
							String newName = input.next();
							//Takes info and calls renameMethod
							Methods.renameMethod(className, oldName, newName);
							View.inputPanel.setVisible(false);
							View.textField.setText("");
							undoredo.stateKeeper();
						}
						else {

							JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

			//If user wanted to add a parameter
			else if(command.equals("Add Parameter")) {
				//If user inputs info correctly
				if(input.hasNext()) {
					classNameMO = input.next();
					if(input.hasNext()) {
						methodNameMO = input.next();
						if(input.hasNext()) {
							paramNameMO = input.next();
							if(input.hasNext()) {
								typeMO = input.next();
								//Takes info and calls addParameter
								HashSet<String> dupes = MethodOverloading.containsDuplicateMethods(classNameMO);
                                if(!dupes.contains(methodNameMO)) {
                                	Parameters.addParameter(classNameMO, methodNameMO, paramNameMO, typeMO, null, false);
        							View.inputPanel.setVisible(false);
                                	View.textField.setText("");
									undoredo.stateKeeper();
                                }
                                else {
                                	View.textField.setText("");
    								View.inputLbl.setText("<html><div style='text-align:center'>There is more than<br>one method that<br>uses the name " + methodNameMO + "<br>Enter all the parameter<br>types for the method<br>you are editing<div></html>");
    								command = "Method Overloading Add Cont";
                                }
							}
							else {

								JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
							}
						}
						else {
							JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);

				}
			}
			
			else if(command.equals("Method Overloading Add Cont")) {
				ArrayList<Parameters> pList;
				if(input.hasNextLine()) {
					pList = MethodOverloading.locatingParameters(classNameMO, methodNameMO, input.nextLine());
				}
				else {
					pList = MethodOverloading.locatingParameters(classNameMO, methodNameMO, "");
				}
            	Parameters.addParameter(classNameMO, methodNameMO, paramNameMO, typeMO, pList, true);
				undoredo.stateKeeper();
            	View.inputPanel.setVisible(false);
            	View.textField.setText("");
			}

			//If user wanted to remove a parameter
			else if(command.equals("Remove Parameter")) {
				//If user inputs info correctly
				if(input.hasNext()) {
					classNameMO = input.next();
					if(input.hasNext()) {
						methodNameMO = input.next();
						if(input.hasNext()) {
							paramNameMO = input.next();
							//Takes info and calls deleteParameter
							HashSet<String> dupes = MethodOverloading.containsDuplicateMethods(classNameMO);
                            if(!dupes.contains(methodNameMO)) {
                            	Parameters.deleteParameter(classNameMO, methodNameMO, paramNameMO, null, false);
    							View.inputPanel.setVisible(false);
                            	View.textField.setText("");
								undoredo.stateKeeper();
                            }
                            else {
                            	View.textField.setText("");
								View.inputLbl.setText("<html><div style='text-align:center'>There is more than<br>one method that<br>uses the name " + methodNameMO + "<br>Enter all the parameter<br>types for the method<br>you are editing<div></html>");
								command = "Method Overloading Remove Cont";
                            }
						}
						else {
							JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			else if(command.equals("Method Overloading Remove Cont")) {
				ArrayList<Parameters> pList;
				if(input.hasNextLine()) {
					pList = MethodOverloading.locatingParameters(classNameMO, methodNameMO, input.nextLine());
				}
				else {
					pList = MethodOverloading.locatingParameters(classNameMO, methodNameMO, "");
				}
            	Parameters.deleteParameter(classNameMO, methodNameMO, paramNameMO, pList, true);
				undoredo.stateKeeper();
            	View.inputPanel.setVisible(false);
            	View.textField.setText("");
			}

			//If user wanted to remove all parameters
			else if(command.equals("Remove All Parameters")) {
				//If user inputs info correctly
				if(input.hasNext()) {
					classNameMO = input.next();
					if(input.hasNext()) {
						methodNameMO = input.next();
						//Takes info and calls deleteAllParameters
						HashSet<String> dupes = MethodOverloading.containsDuplicateMethods(classNameMO);
                        if(!dupes.contains(methodNameMO)) {
                        	Parameters.deleteAllParameters(classNameMO, methodNameMO, null, false);
							undoredo.stateKeeper();
							View.inputPanel.setVisible(false);
                        	View.textField.setText("");
                        }
                        else {
                        	View.textField.setText("");
							View.inputLbl.setText("<html><div style='text-align:center'>There is more than<br>one method that<br>uses the name " + methodNameMO + "<br>Enter all the parameter<br>types for the method<br>you are editing<div></html>");
							command = "Method Overloading Remove All Param Cont";
                        }
					}
					else {
						JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			else if(command.equals("Method Overloading Remove All Param Cont")) {
				ArrayList<Parameters> pList;
				if(input.hasNextLine()) {
					pList = MethodOverloading.locatingParameters(classNameMO, methodNameMO, input.nextLine());
				}
				else {
					pList = MethodOverloading.locatingParameters(classNameMO, methodNameMO, "");
				}
            	Parameters.deleteAllParameters(classNameMO, methodNameMO, pList, true);
				undoredo.stateKeeper();
            	View.inputPanel.setVisible(false);
            	View.textField.setText("");
			}

			//If user wanted to change a parameter
			else if(command.equals("Change Parameter")) {
				//If user inputs info correctly
				if(input.hasNext()) {
					classNameMO = input.next();
					if(input.hasNext()) {
						methodNameMO = input.next();
						if(input.hasNext()) {
							oldParamNameMO = input.next();
							if(input.hasNext()) {
								paramNameMO = input.next();
								if(input.hasNext()) {
									typeMO = input.next();
									//Takes info and calls changeParameter
									HashSet<String> dupes = MethodOverloading.containsDuplicateMethods(classNameMO);
	                                if(!dupes.contains(methodNameMO)) {
	                                	Parameters.changeParameter(classNameMO, methodNameMO, oldParamNameMO, paramNameMO, typeMO, null, false);
	        							View.inputPanel.setVisible(false);
	                                	View.textField.setText("");
										undoredo.stateKeeper();
	                                }
	                                else {
	                                	View.textField.setText("");
	    								View.inputLbl.setText("<html><div style='text-align:center'>There is more than<br>one method that<br>uses the name " + methodNameMO + "<br>Enter all the parameter<br>types for the method<br>you are editing<div></html>");
	    								command = "Method Overloading Add Cont";
	                                }
								}
								else {
									JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
							else {
								JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
							}
						}
						else {
							JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			else if(command.equals("Method Overloading Change Param Cont")) {
				ArrayList<Parameters> pList;
				if(input.hasNextLine()) {
					pList = MethodOverloading.locatingParameters(classNameMO, methodNameMO, input.nextLine());
				}
				else {
					pList = MethodOverloading.locatingParameters(classNameMO, methodNameMO, "");
				}
            	Parameters.changeParameter(classNameMO, methodNameMO, oldParamNameMO, paramNameMO, typeMO, pList, true);
				undoredo.stateKeeper();
            	View.inputPanel.setVisible(false);
            	View.textField.setText("");
			}

			//If user wanted to change all parameters
			else if(command.equals("Change All Parameters")) {
				//If user inputs info correctly
				if(input.hasNext()) {
					String className = input.next();
					if(input.hasNext()) {
						String methodName = input.next();
						View.textField.setText("");
						//For looping through parameters and making sure there are no dupes
						dupes = new HashSet<String>();
						dupes.clear();
						counter = 0;
						//Takes info and calls findMethod
						pList = Parameters.findMethod(className, methodName);
						if(pList != null) {
							//Makes sure there are parameters
							if(!pList.isEmpty()) {
								View.inputLbl.setText("<html><div style='text-align:center'>Here is the parameter<br>being changed:<br>" + pList.get(0).getParamType() + " " + pList.get(0).getParamName() + "<br><br>What is the new name?<br><br>What is the new type?</div></html>");
							}
							//There were no parameters to change
							else {
								JOptionPane.showMessageDialog(View.frmUmlEditor, "There are no parameters to change!", "Error", JOptionPane.ERROR_MESSAGE);
								View.inputPanel.setVisible(false);
								View.textField.setText("");
							}
						}
						command = "Change All Params Continued";
						this.classNameCAP = className;
					}
					else {
						JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

			//To continue changing parameters
			else if(command.equals("Change All Params Continued")) {
				//If user inputs info correctly
				if(input.hasNext()) {
					String paramName = input.next();
					if(input.hasNext()) {
						String type = input.next();
						//Makes sure there are no duplicates
						if(!dupes.contains(paramName)){
							//Changes the values
							dupes.add(paramName);
							pList.set(counter, new Parameters(paramName, type));
							counter++;
							//If there are more parameters to loop through
							if(counter < pList.size()) {
								View.inputLbl.setText("<html><div style='text-align:center'>Here is the parameter<br>being changed:<br>" + pList.get(counter).getParamType() + " " + pList.get(counter).getParamName() + "<br><br>What is the new name?<br><br>What is the new type?</div></html>");
								View.textField.setText("");
							}
							//No more parameters to loop through
							else {
								for(BoxObject obj : Model.getJLabels()) {
									if(obj.getJLabelName().equals(classNameCAP)) {
										BoxObject.updateBox(obj);
									}
								}

								View.inputPanel.setVisible(false);
								View.textField.setText("");
							}
						}
						//If a parameter entered already exists
						else {
							JOptionPane.showMessageDialog(View.frmUmlEditor, "That parameter already exists!", "Error", JOptionPane.ERROR_MESSAGE);

							View.inputPanel.setVisible(false);
							View.textField.setText("");
						}
					}
					else {
						JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

			//If user wanted to add a field
			else if(command.equals("Add Field")) {
				//If user inputs info correctly
				if(input.hasNext()) {
					String className = input.next();
					if(input.hasNext()) {
						String fieldName = input.next();
						if(input.hasNext()) {
							String type = input.next();
							//Takes info and calls addField
							Fields.addField(className, fieldName, type);
							View.textField.setText("");
							//Prompts user if they want to add another field
							View.inputLbl.setText("<html><div style='text-align:center'>Would you like to add<br>another field? (yes / no)</div></html>");
							command = "Response Add Field";
							undoredo.stateKeeper();
						}
						else {
							JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

			//If user wanted to add more fields
			else if(command.equals("Response Add Field")) {
				//If user inputs info correctly
				if(input.hasNext()) {
					String answer = input.next();
					//Checks to see if user inputted yes or no to add another field
					if(!answer.equals("yes") && !answer.equals("no")) {
						//Reprompts if answer was not yes or no
						View.inputLbl.setText("<html><div style='text-align:center'>Please respond with<br>yes or no!</div></html>");
					}
					else if(answer.equals("yes")) {
						//Asks for add field information
						View.inputLbl.setText("<html><div style='text-align:center'>What class are<br>you adding to?<br><br>What would you like to<br>name the new field?<br><br>What type do you want<br>the new field to have?<br><div></html>");
						command = "Add Field";
						View.textField.setText("");
					}
					else if(answer.equals("no")) {
						//Cancels add field prompt
						View.inputPanel.setVisible(false);
						View.textField.setText("");
					}
				}
				else {
					JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

			//If user wanted to remove a field
			else if(command.equals("Remove Field")) {
				//If user inputs info correctly
				if(input.hasNext()) {
					String className = input.next();
					if(input.hasNext()) {
						String fieldName = input.next();
						//Takes info and calls removeField
						Fields.removeField(className, fieldName);
						View.textField.setText("");
						//Prompts user if they want to remove another field
						View.inputLbl.setText("<html><div style='text-align:center'>Would you like to remove<br>another field? (yes / no)</div></html>");
						command = "Response Remove Field";
						undoredo.stateKeeper();
					}
					else {
						JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

			//If user wanted to remove more fields
			else if(command.equals("Response Remove Field")) {
				//If user inputs info correctly
				if(input.hasNext()) {
					String answer = input.next();
					//Checks to see if user inputted yes or no to remove another field
					if(!answer.equals("yes") && !answer.equals("no")) {
						//Reprompts if answer was not yes or no
						View.inputLbl.setText("<html><div style='text-align:center'>Please respond with<br>yes or no!</div></html>");
					}
					else if(answer.equals("yes")) {
						//Asks for remove field information
						View.inputLbl.setText("<html><div style='text-align:center'>What class are<br>you removing from?<br><br>What field are<br>you removing?<div></html>");
						command = "Remove Field";
						View.textField.setText("");
					}
					else if(answer.equals("no")) {
						//Cancels remove field prompt
						View.inputPanel.setVisible(false);
						View.textField.setText("");
					}
				}
				else {
					JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

			//If user wanted to rename a field
			else if(command.equals("Rename Field")) {
				//If user inputs info correctly
				if(input.hasNext()) {
					String className = input.next();
					if(input.hasNext()) {
						String oldName = input.next();
						if(input.hasNext()) {
							String newName = input.next();
							//Takes info and calls renameField
							Fields.renameField(className, oldName, newName);
							View.inputPanel.setVisible(false);
							View.textField.setText("");
							undoredo.stateKeeper();
						}
						else {
							JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

			//If user wanted to add a relationship
			else if(command.equals("Add Relationship")) {
				//If user inputs info correctly
				if(input.hasNext()) {
					String sourceName = input.next();
					if(input.hasNext()) {
						String destName = input.next();
						if(input.hasNext()) {
							String type = input.next();
							//Checks if source class exists
							if(Model.getNoClassDupes().contains(sourceName)) {
								//Checks if destination class exists
								if(Model.getNoClassDupes().contains(destName)) {
									//Searches for destination class
									for(UML umlDest : Model.getCollection()) {
										if(umlDest.getClassName().equals(destName)) {
											//Searches for source class
											for(UML umlSrc : Model.getCollection()) {
												if(umlSrc.getClassName().equals(sourceName)) {
													//Takes info and calls addRel
													Relationships.addRel(umlSrc, umlDest, type);
													View.inputPanel.setVisible(false);
													View.textField.setText("");
													undoredo.stateKeeper();
													break;
												}
											}
										}
									}
								}
								//Destination class does not exist
								else {
									JOptionPane.showMessageDialog(View.frmUmlEditor, "Destination class does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
							//Source class does not exist
							else {
								JOptionPane.showMessageDialog(View.frmUmlEditor, "Source class does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
							}
						}
						else {
							JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

			//If user wanted to remove a relationship
			else if(command.equals("Remove Relationship")) {
				//If user inputs info correctly
				if(input.hasNext()) {
					String srcName = input.next();
					if(input.hasNext()) {
						String destName = input.next();
						//Takes info and calls delRel
						Relationships.delRel(srcName, destName);
						View.inputPanel.setVisible(false);
						View.textField.setText("");
						undoredo.stateKeeper();
					}
					else {
						JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

			//If user wanted to change a relationship
			else if(command.equals("Change Relationship")) {
				//If user inputs info correctly
				if(input.hasNext()) {
					String srcName = input.next();
					if(input.hasNext()) {
						String destName = input.next();
						if(input.hasNext()) {
							String type = input.next();
							//Takes info and calls changeRel
							Relationships.changeRel(srcName, destName, type);
							View.inputPanel.setVisible(false);
							View.textField.setText("");
							undoredo.stateKeeper();
						}
						else {
							JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(View.frmUmlEditor, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}


			//If user wanted to load a JSON string
			else if(command.equals("Load")) {
				//If user inputs info correctly
				if(input.hasNext()) {
					JsonFile.load(input.next(), Model.getCollection());
					//					View.outputLbl.setText("File Loaded!");
					View.inputPanel.setVisible(false);
					View.textField.setText("");
					undoredo.loadClear();
				}
			}
			input.close();
		}

		//If add class button is clicked
		else if(e.getActionCommand().equals("Add Class")) {
			command = "Add Class";
			View.inputLbl.setText("<html><div style='text-align:center'>What would you like<br>to name the new class?</div></html>");
			View.inputPanel.setVisible(true);
		}

		//If remove class button is clicked
		else if(e.getActionCommand().equals("Remove Class")) {
			command = "Remove Class";
			View.inputLbl.setText("<html><div style='text-align:center'>What class would<br>you like to remove?</div></html>");
			View.inputPanel.setVisible(true);
		}

		//If rename class button is clicked
		else if(e.getActionCommand().equals("Rename Class")) {
			command = "Rename Class";
			View.inputLbl.setText("<html><div style='text-align:center'>What class would you<br>like to rename?<br><br>What is the new<br>class name?</div></html>");
			View.inputPanel.setVisible(true);
		}

		//If add method button is clicked
		else if(e.getActionCommand().equals("Add Method")) {
			command = "Add Method";
			View.inputLbl.setText("<html><div style='text-align:center'>What class are you<br>adding to?<br><br>What is the name of<br>the new method?<br><br>What is the method's<br>return type?</div></html>");
			View.inputPanel.setVisible(true);
		}

		//If remove method button is clicked
		else if(e.getActionCommand().equals("Remove Method")) {
			command = "Remove Method";
			View.inputLbl.setText("<html><div style='text-align:center'>What class are you<br>removing from?<br><br>What method are you<br>removing?</div></html>");
			View.inputPanel.setVisible(true);
		}

		//If remove all methods button is clicked
		else if(e.getActionCommand().equals("Remove All Methods")) {
			command = "Remove All Methods";
			View.inputLbl.setText("<html><div style='text-align:center'>What class are you<br>removing all methods<br>from?</div></html>");
			View.inputPanel.setVisible(true);
		}

		//If rename method button is clicked
		else if(e.getActionCommand().equals("Rename Method")) {
			command = "Rename Method";
			View.inputLbl.setText("<html><div style='text-align:center'>What class are you<br>making modifications in?<br><br>What method are<br>you renaming?<br><br>What would you like to<br>rename the method to?</div></html>");
			View.inputPanel.setVisible(true);
		}

		//If add parameter button is clicked
		else if(e.getActionCommand().equals("Add Parameter")) {
			command = "Add Parameter";
			View.inputLbl.setText("<html><div style='text-align:center'>What class would you<br>like to add a parameter to?<br><br>What method would you<br>like to add a parameter to?<br><br>What is the<br>parameter name?<br><br>What is the<br>parameter type?</div></html>");
			View.inputPanel.setVisible(true);
		}

		//If remove parameter button is clicked
		else if(e.getActionCommand().equals("Remove Parameter")) {
			command = "Remove Parameter";
			View.inputLbl.setText("<html><div style='text-align:center'>What class would you<br>like to remove the<br>parameter from?<br><br>What method would you<br>like to remove the<br>parameter from?<br><br>What is the<br>parameter name?</div></html>");
			View.inputPanel.setVisible(true);
		}

		//If remove all parameters button is clicked
		else if(e.getActionCommand().equals("Remove All Parameters")) {
			command = "Remove All Parameters";
			View.inputLbl.setText("<html><div style='text-align:center'>What class would you<br>like to remove the<br>parameters from?<br><br>What method would you<br>like to remove the<br>parameters from?</div></html>");
			View.inputPanel.setVisible(true);
		}

		//If change parameter button is clicked
		else if(e.getActionCommand().equals("Change Parameter")) {
			command = "Change Parameter";
			View.inputLbl.setText("<html><div style='text-align:center'>What class would you<br>like to change<br>a parameter in?<br><br>What method would you<br>like to change<br>a parameter in?<br><br>What is the old<br>parameter name?<br><br>What is the new<br>parameter name?<br><br>What is the<br>parameter type?</div></html>");
			View.inputPanel.setVisible(true);
		}

		//If change all parameters button is clicked
		else if(e.getActionCommand().equals("Change All Parameters")) {
			command = "Change All Parameters";
			View.inputLbl.setText("<html><div style='text-align:center'>What class would you<br>like to rename<br>parameters in?<br><br>What method would you<br>like to rename<br>parameters in?</div></html>");
			View.inputPanel.setVisible(true);
		}

		//If add field button is clicked
		else if(e.getActionCommand().equals("Add Field")) {
			command = "Add Field";
			View.inputLbl.setText("<html><div style='text-align:center'>What class are<br>you adding to?<br><br>What would you like to<br>name the new field?<br><br>What type do you want<br>the new field to have?<div></html>");
			View.inputPanel.setVisible(true);
		}

		//If remove field button is clicked
		else if(e.getActionCommand().equals("Remove Field")) {
			command = "Remove Field";
			View.inputLbl.setText("<html><div style='text-align:center'>What class are<br>you removing from?<br><br>What field are<br>you removing?<div></html>");
			View.inputPanel.setVisible(true);
		}

		//If rename field button is clicked
		else if(e.getActionCommand().equals("Rename Field")) {
			command = "Rename Field";
			View.inputLbl.setText("<html><div style='text-align:center'>What class are you<br>making modifications in?<br><br>What field are<br>you renaming?<br><br>What would you like to<br>rename the field to?<div></html>");
			View.inputPanel.setVisible(true);
		}

		//If add relationship button is clicked
		else if(e.getActionCommand().equals("Add Relationship")) {
			command = "Add Relationship";
			View.inputLbl.setText("<html><div style='text-align:center'>What class would you<br>like to be the source<br>of the relation?<br><br>What is the destination<br>of the relation?<br><br>What is the type of the<br>relation? Type must be<br>aggregation, composition,<br>inheritance, or realization.<div></html>");
			View.inputPanel.setVisible(true);
		}

		//If remove relationship button is clicked
		else if(e.getActionCommand().equals("Remove Relationship")) {
			command = "Remove Relationship";
			View.inputLbl.setText("<html><div style='text-align:center'>What class would you like<br>to delete a relation from?<br><br>What is the destination<br>of the relation?<div></html>");
			View.inputPanel.setVisible(true);
		}

		//If change relationship button is clicked
		else if(e.getActionCommand().equals("Change Relationship")) {
			command = "Change Relationship";
			View.inputLbl.setText("<html><div style='text-align:center'>What is the source<br>class of the relationship<br>you would like to change?<br><br>What is the destination<br>class of the relationship<br>you would like to change?<br><br>What would you like<br>to change the type to?<div></html>");
			View.inputPanel.setVisible(true);
		}


		else if(e.getActionCommand().equals("Undo")) {
			undoredo.undo();
			View.panel.repaint();

		}
		else if(e.getActionCommand().equals("Redo")) {
			undoredo.redo();
			View.panel.repaint();

		}

		//If save button is clicked
		else if(e.getActionCommand().equals("Save")) {
			View.textFieldJSON.setText(JsonFile.save(Model.getCollection()));

		}

		//If load button is clicked
		else if(e.getActionCommand().equals("Load")) {
			command = "Load";
			View.inputLbl.setText("<html><div style='text-align:center'>Insert json string<br>you want to load.<br>By clicking enter, you<br>agree all unsaved work<br>will be deleted.</div></html>");
			View.inputPanel.setVisible(true);
		}

		//If help button is clicked
		else if(e.getActionCommand().equals("Help")) {
			JOptionPane.showMessageDialog(View.frmUmlEditor,
					"<html>For commands with multiple inputs, put them in order separated with a space"
							+ "<br>add class - creates a new class"
							+ "<br>delete class - deletes a class"
							+ "<br>rename class - renames a class"
							+ "<br>add method - creates a new method for a class"
							+ "<br>delete method - deletes a method from a class"
							+ "<br>delete all methods - deletes all methods from a class"
							+ "<br>rename method - renames a method in a class"
							+ "<br>add field - creates a new field for a class"
							+ "<br>delete field - deletes a field from a class"
							+ "<br>rename field - renames a field from a class"
							+ "<br>add parameter - creates a parameter in a method for a class"
							+ "<br>delete parameter - deletes a parameter from a method in a class"
							+ "<br>delete all parameters - deletes all parameters in a method in a class"
							+ "<br>change parameter - changes a parameter in a method in a class"
							+ "<br>change all parameters - changes all parameters in a method in a class"
							+ "<br>add relation - creates a relationship between two classes"
							+ "<br>delete relation - deletes a relationship between two classes"
							+ "<br>change relationship type - changes a relationship type"
							+ "<br>undo - undos a change made"
							+ "<br>redo - redos an undo made"
							+ "<br>save - saves current uml file"
							+ "<br>load - loads a uml file"
							+ "<br>help - provides a list of commands usable commands"
							+ "<br>switch to cli - exists the gui, runs cli",
							"Help", JOptionPane.INFORMATION_MESSAGE);
		}

		//If switch to cli button is clicked
		else if(e.getActionCommand().equals("CLI")) {
			Driver.guiUp = false;
			View.closeGUI();
			Driver.runCLI();
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		e.getComponent().setLocation(e.getXOnScreen() - 378, e.getYOnScreen() - 34);

		if(e.getComponent().getX() < 0) {
			e.getComponent().setLocation(0, e.getComponent().getY());
		}
		if(e.getComponent().getX() > 844 - e.getComponent().getWidth()) {
			e.getComponent().setLocation(844 - e.getComponent().getWidth(), e.getComponent().getY());
		}
		if(e.getComponent().getY() < 0) {
			e.getComponent().setLocation(e.getComponent().getX(), 0);
		}
		if(e.getComponent().getY() > 679 - e.getComponent().getHeight()) {
			e.getComponent().setLocation(e.getComponent().getX(), 679 - e.getComponent().getHeight());
		}
		View.panel.repaint();
		Arrows.updateArrows();
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		for(BoxObject obj : Model.getJLabels()) {
			if(obj.getLabel() == e.getComponent()) {
				for(UML uml : Model.getCollection()) {
					if(obj.getJLabelName().equals(uml.getClassName())) {
						uml.setposition_x(e.getComponent().getX());
						uml.setposition_y(e.getComponent().getY());
					}
				}
			}
		}
		Arrows.updateArrows();
	}
}
