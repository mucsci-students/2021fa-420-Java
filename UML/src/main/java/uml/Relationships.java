package uml;


import javax.swing.JOptionPane;

public class Relationships {
	private String source;
	private String destination;
	private String type;

	public Relationships(UML source, UML destination, String type) {
		this.source = source.getClassName();
		this.destination = destination.getClassName();
		this.type = type;
	}

	public String getSource() {
		return source;
	}

	public void setSource(UML source) {
		this.source = source.getClassName();
	}

	public String getDestination() {
		return destination;
	}


	public void setDestination(UML destination) {
		this.destination = destination.getClassName();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		if(testType(type)) {
			this.type = type;
		}
		else {
			if(Driver.guiUp) {
				JOptionPane.showMessageDialog(View.frmUmlEditor, "Type must be aggregation, composition, inheritance, or realization.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				System.out.println("Type must be aggregation, composition, inheritance, or realization.");
			}
		}
	}

	public static boolean testType(String type) {
		//Makes sure relationship type is one that exists
		if(type.equals("aggregation") || type.equals("composition") || type.equals("inheritance") || type.equals("realization")) {
			return true;
		}
		return false;
	}

	public static void addRel(UML source, UML destination, String type) { //make String type into enum later
		if(Relationships.testType(type)) {
			boolean dupeRel = false;
			if(source != destination) {
				for(Relationships c : source.getRels()) {
					if(c.getDestination() == destination.getClassName()) {
						dupeRel = true;
						if(Driver.guiUp) {
							JOptionPane.showMessageDialog(View.frmUmlEditor, "A relationship from " + source.getClassName() + " to " + destination.getClassName() + " already exists!", "Error", JOptionPane.ERROR_MESSAGE);
						}
						else {
							System.out.println("A relationship from " + source.getClassName() + " to " + destination.getClassName() + " already exists!");
						}
					}
				}
				if(dupeRel == false) {
					Relationships r = new Relationships(source, destination, type);
					for(UML u : Model.getCollection()) {
						if(u.getClassName().equals(source.getClassName())) { // searches for the class name that we are adding a relationship to
							u.getRels().add(r);
							for(BoxObject src : Model.getJLabels()) {
								if(src.getJLabelName().equals(source.getClassName())) {
									for(BoxObject dest : Model.getJLabels()) {
										if(dest.getJLabelName().equals(destination.getClassName())) {
											Arrows arrow = new Arrows(src, dest, type);
											Model.getArrows().add(arrow);
											if(Driver.guiUp) {
												Arrows.drawArrow(arrow);
											}
										}
									}
								}
							}
							if(!Driver.guiUp) {
								System.out.println("Relationship Added!");
							}
							return;
						}
					}
				}
			}
			else {
				if(Driver.guiUp) {
					JOptionPane.showMessageDialog(View.frmUmlEditor, "Cannot add a relationship to the same class", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					System.out.println("Cannot add a relationship to the same class");
				}
			}
		}
		else {
			//Type entered was not one of the 4 for relationships
			if(Driver.guiUp) {

				JOptionPane.showMessageDialog(View.frmUmlEditor, "Type must be aggregation, composition, inheritance, or realization.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				System.out.println("Type must be aggregation, composition, inheritance, or realization.");
			}
		}
	}

	public static void delRel(String source, String destination) {
		if(Model.getNoClassDupes().contains(source)) {
			if(Model.getNoClassDupes().contains(destination)) {
				for(UML srcUml : Model.getCollection()) {
					if(srcUml.getClassName().equals(source)) { //finds uml
						for(UML destUml : Model.getCollection()) {
							if(destUml.getClassName().equals(destination)) {
								for(Relationships r : srcUml.getRels()) {
									if(r.getDestination().equals(destination)) { //Checks if a relationship in the relationship arraylist has the same name as the requested deletion destination 
										int x = srcUml.getRels().indexOf(r);// Needed to finds where the relationship is that we need to delete
										srcUml.getRels().remove(x);
										for(Arrows arrow : Model.getArrows()) {
											if(arrow.getSrc().getJLabelName().equals(source) && arrow.getDest().getJLabelName().equals(destination)) {
												Model.getArrows().remove(arrow);
												View.panel.repaint();
												Arrows.updateArrows();
												break;
											}
										}
										if(!Driver.guiUp) {
											System.out.println("Relationship Deleted!");
										}
										break;
									}
								}
								break;
							}
						}
						break;
					}
				}
			}
			else {
				if(Driver.guiUp) {
					JOptionPane.showMessageDialog(View.frmUmlEditor, "Destination class does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					System.out.println("Destination class does not exist!");
				}
			}
		}
		else {
			if(Driver.guiUp) {

				JOptionPane.showMessageDialog(View.frmUmlEditor, "Source class does not exist!", "Error", JOptionPane.ERROR_MESSAGE);

			}
			else {
				System.out.println("Source class does not exist!");
			}
		}
	}

	public static void changeRel(String srcName, String destName, String type) {
		if(Model.getNoClassDupes().contains(srcName)) {
			if(Model.getNoClassDupes().contains(destName)) {
				for(UML umlSrc : Model.getCollection()) {
					if(umlSrc.getClassName().equals(srcName)) {
						for(Relationships umlRel : umlSrc.getRels()) {
							if(umlRel.getDestination().equals(destName)) {
								umlRel.setType(type);
								for(Arrows arrow : Model.getArrows()) {
									if(arrow.getSrc().getJLabelName().equals(srcName) && arrow.getDest().getJLabelName().equals(destName)) {
										arrow.setType(type);
										View.panel.repaint();
										if(Driver.guiUp) {
											Arrows.updateArrows();
										}
										break;
									}
								}
								if(!Driver.guiUp) {
									System.out.println("Type changed to " + type);
								}
								return;
							}
						}
					}
				}
			}
			else {
				if(Driver.guiUp) {

					JOptionPane.showMessageDialog(View.frmUmlEditor, "Destination class does not exist!", "Error", JOptionPane.ERROR_MESSAGE);

				}
				else {
					System.out.println("Destination class does not exist!");
				}
			}
		}
		else {
			if(Driver.guiUp) {

				JOptionPane.showMessageDialog(View.frmUmlEditor, "Source class does not exist!", "Error", JOptionPane.ERROR_MESSAGE);

			}
			else {
				System.out.println("Source class does not exist!");
			}
		}
	}
}