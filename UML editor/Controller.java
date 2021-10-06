import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class Controller implements ActionListener, MouseMotionListener, MouseListener {
	
	public String command;

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Enter")) {
			
		}

		else if(e.getActionCommand().equals("Add Class")) {
			command = "addclass";
		}

		else if(e.getActionCommand().equals("Remove Class")) {
			command = "removeclass";
		}

		else if(e.getActionCommand().equals("Rename Class")) {
			command = "renameclass";
		}

		else if(e.getActionCommand().equals("Add Method")) {
			command = "addmethod";
		}

		else if(e.getActionCommand().equals("Remove Method")) {
			command = "removemethod";
		}

		else if(e.getActionCommand().equals("Rename Method")) {
			command = "renamemethod";
		}

		else if(e.getActionCommand().equals("Add Parameter")) {
			command = "addparameter";
		}

		else if(e.getActionCommand().equals("Remove Parameter")) {
			command = "removeparameter";
		}

		else if(e.getActionCommand().equals("Rename Parameter")) {
			command = "renameparameter";
		}

		else if(e.getActionCommand().equals("Add Field")) {
			command = "addfield";
		}

		else if(e.getActionCommand().equals("Remove Field")) {
			command = "removefield";
		}

		else if(e.getActionCommand().equals("Rename Field")) {
			command = "renamefield";
		}

		else if(e.getActionCommand().equals("Add Relationship")) {
			command = "addrelationship";
		}

		else if(e.getActionCommand().equals("Remove Relationship")) {
			command = "removerelationship";
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
			command = "listcontents";
		}

		else if(e.getActionCommand().equals("List Relationships")) {
			
		}

		else if(e.getActionCommand().equals("Save")) {
			
		}

		else if(e.getActionCommand().equals("Load")) {
			
		}

		else if(e.getActionCommand().equals("Help")) {
			View.outputLbl.setText("<html>add class - creates a new unique class * the name must be alphanumeric and not already exist."
					+ "<br>delete class - deletes a preexisting class * the class must already exist to delete it."
					+ "<br>rename class - takes a class and provides a new name * the name must not already exist as another class and it's new name must be alphanumeric."
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
			View.closeGUI();
			Driver.runCLI();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
