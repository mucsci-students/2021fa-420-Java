package uml;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;

import javax.swing.border.LineBorder;
import javax.swing.JTextField;

public class View {
	//Window
	public static JFrame frmUmlEditor;

	//For user input
	public static JPanel inputPanel;
	public static JLabel inputLbl;
	public static JTextField textField;
	public static String outputText;

	//JSON string output
	public static JPanel savePanel;
	public static JTextField textFieldJSON;

	//Controller object to run commands
	public static Controller controller = new Controller();
	
	public static JLabel lbl;
	public static JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void runGUI() {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					View window = new View();
					window.frmUmlEditor.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Creates window
		frmUmlEditor = new JFrame();
		frmUmlEditor.setTitle("UML Editor");
		frmUmlEditor.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmUmlEditor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUmlEditor.getContentPane().setLayout(null);
		frmUmlEditor.getContentPane().setPreferredSize(new Dimension(1360, 700));
		frmUmlEditor.pack();

		//Creates panel for major command buttons
		JPanel mainBtnPanel = new JPanel();
		mainBtnPanel.setBackground(Color.LIGHT_GRAY);
		mainBtnPanel.setBounds(10, 10, 183, 679);
		frmUmlEditor.getContentPane().add(mainBtnPanel);
		mainBtnPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		mainBtnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		//Creates command buttons, gives them action commands and listeners, and adds to panel
		//*************************************************************************************//
		JButton btnAddClass = new JButton("Add Class");
		btnAddClass.setActionCommand("Add Class");
		btnAddClass.addActionListener(controller);
		mainBtnPanel.add(btnAddClass);

		JButton btnRemoveClass = new JButton("Remove Class");
		btnRemoveClass.setActionCommand("Remove Class");
		btnRemoveClass.addActionListener(controller);
		mainBtnPanel.add(btnRemoveClass);

		JButton btnRenameClass = new JButton("Rename Class");
		btnRenameClass.setActionCommand("Rename Class");
		btnRenameClass.addActionListener(controller);
		mainBtnPanel.add(btnRenameClass);

		JButton btnAddMethod = new JButton("Add Method");
		btnAddMethod.setActionCommand("Add Method");
		btnAddMethod.addActionListener(controller);
		mainBtnPanel.add(btnAddMethod);

		JButton btnRemoveMethod = new JButton("Remove Method");
		btnRemoveMethod.setActionCommand("Remove Method");
		btnRemoveMethod.addActionListener(controller);
		mainBtnPanel.add(btnRemoveMethod);

		JButton btnRemoveAllMethods = new JButton("Remove All Methods");
		btnRemoveAllMethods.setActionCommand("Remove All Methods");
		btnRemoveAllMethods.addActionListener(controller);
		mainBtnPanel.add(btnRemoveAllMethods);

		JButton btnRenameMethod = new JButton("Rename Method");
		btnRenameMethod.setActionCommand("Rename Method");
		btnRenameMethod.addActionListener(controller);
		mainBtnPanel.add(btnRenameMethod);

		JButton btnAddParameter = new JButton("Add Parameter");
		btnAddParameter.setActionCommand("Add Parameter");
		btnAddParameter.addActionListener(controller);
		mainBtnPanel.add(btnAddParameter);

		JButton btnRemoveParameter = new JButton("Remove Parameter");
		btnRemoveParameter.setActionCommand("Remove Parameter");
		btnRemoveParameter.addActionListener(controller);
		mainBtnPanel.add(btnRemoveParameter);

		JButton btnRemoveAllParameters = new JButton("Remove All Parameters");
		btnRemoveAllParameters.setActionCommand("Remove All Parameters");
		btnRemoveAllParameters.addActionListener(controller);
		mainBtnPanel.add(btnRemoveAllParameters);

		JButton btnChangeParameter = new JButton("Change Parameter");
		btnChangeParameter.setActionCommand("Change Parameter");
		btnChangeParameter.addActionListener(controller);
		mainBtnPanel.add(btnChangeParameter);

		JButton btnChangeAllParameters = new JButton("Change All Parameters");
		btnChangeAllParameters.setActionCommand("Change All Parameters");
		btnChangeAllParameters.addActionListener(controller);
		mainBtnPanel.add(btnChangeAllParameters);

		JButton btnAddField = new JButton("Add Field");
		btnAddField.setActionCommand("Add Field");
		btnAddField.addActionListener(controller);
		mainBtnPanel.add(btnAddField);

		JButton btnRemoveField = new JButton("Remove Field");
		btnRemoveField.setActionCommand("Remove Field");
		btnRemoveField.addActionListener(controller);
		mainBtnPanel.add(btnRemoveField);

		JButton btnRenameField = new JButton("Rename Field");
		btnRenameField.setActionCommand("Rename Field");
		btnRenameField.addActionListener(controller);
		mainBtnPanel.add(btnRenameField);

		JButton btnAddRelationship = new JButton("Add Relationship");
		btnAddRelationship.setActionCommand("Add Relationship");
		btnAddRelationship.addActionListener(controller);
		mainBtnPanel.add(btnAddRelationship);

		JButton btnRemoveRelationship = new JButton("Remove Relationship");
		btnRemoveRelationship.setActionCommand("Remove Relationship");
		btnRemoveRelationship.addActionListener(controller);
		mainBtnPanel.add(btnRemoveRelationship);

		JButton btnChangeRelationship = new JButton("Change Relationship");
		btnChangeRelationship.setActionCommand("Change Relationship");
		btnChangeRelationship.addActionListener(controller);
		mainBtnPanel.add(btnChangeRelationship);

		JButton btnListClasses = new JButton("List Classes");
		btnListClasses.setActionCommand("List Classes");
		btnListClasses.addActionListener(controller);
		mainBtnPanel.add(btnListClasses);

		JButton btnListContents = new JButton("List Contents");
		btnListContents.setActionCommand("List Contents");
		btnListContents.addActionListener(controller);
		mainBtnPanel.add(btnListContents);

		JButton btnListRelationships = new JButton("List Relationships");
		btnListRelationships.setActionCommand("List Relationships");
		btnListRelationships.addActionListener(controller);
		mainBtnPanel.add(btnListRelationships);
		//*************************************************************************************//



		//Creates panel for other buttons
		JPanel extraBtnPanel = new JPanel();
		extraBtnPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		extraBtnPanel.setBackground(Color.LIGHT_GRAY);
		extraBtnPanel.setBounds(1232, 10, 118, 136);
		frmUmlEditor.getContentPane().add(extraBtnPanel);
		extraBtnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		//Creates other buttons, gives them action commands and listeners, and adds to panel
		//*************************************************************************************//
		JButton btnSave = new JButton("Save");
		btnSave.setActionCommand("Save");
		btnSave.addActionListener(controller);
		extraBtnPanel.add(btnSave);

		JButton btnLoad = new JButton("Load");
		btnLoad.setActionCommand("Load");
		btnLoad.addActionListener(controller);
		extraBtnPanel.add(btnLoad);

		JButton btnHelp = new JButton("Help");
		btnHelp.setActionCommand("Help");
		btnHelp.addActionListener(controller);
		extraBtnPanel.add(btnHelp);

		JButton btnSwitch = new JButton("Switch to CLI");
		btnSwitch.setActionCommand("CLI");
		btnSwitch.addActionListener(controller);
		extraBtnPanel.add(btnSwitch);
		//*************************************************************************************//



		//Creates panel for user input
		//*************************************************************************************//
		inputPanel = new JPanel();
		inputPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		inputPanel.setBackground(Color.LIGHT_GRAY);
		inputPanel.setBounds(203, 10, 165, 343);
		frmUmlEditor.getContentPane().add(inputPanel);
		inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		inputLbl = new JLabel("");
		inputPanel.add(inputLbl);

		textField = new JTextField();
		inputPanel.add(textField);
		textField.setColumns(10);

		JButton btnEnter = new JButton("Enter");
		btnEnter.setActionCommand("Enter");
		btnEnter.addActionListener(controller);
		inputPanel.add(btnEnter);
		inputPanel.setVisible(false);
		//*************************************************************************************//



		//Creates panel for JSON string output
		//*************************************************************************************//
		savePanel = new JPanel();
		savePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		savePanel.setBackground(Color.LIGHT_GRAY);
		savePanel.setBounds(1232, 157, 118, 59);
		frmUmlEditor.getContentPane().add(savePanel);
		savePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel copyLabel = new JLabel("<html><div style='text-align:center'>Copy JSON String</div></html>");
		savePanel.add(copyLabel);

		textFieldJSON = new JTextField();
		savePanel.add(textFieldJSON);
		textFieldJSON.setColumns(10);
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(378, 10, 844, 679);
		frmUmlEditor.getContentPane().add(panel);
		panel.setLayout(null);
		savePanel.setVisible(true);
		
		updateBoxes();
	}
	
	public static void createBox(UML uml) {
		lbl = new JLabel("<html>" + uml.getClassName() + "</html>");
		panel.add(lbl);
		lbl.setSize(lbl.getPreferredSize().width + 10, lbl.getPreferredSize().height + 6);
		lbl.setVerticalAlignment(JLabel.TOP);
		lbl.setHorizontalAlignment(JLabel.CENTER);
		lbl.setLocation(uml.getposition_x(), uml.getposition_y());
//		System.out.println(uml.getposition_x() + " " + uml.getposition_y());
		lbl.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lbl.setVisible(true);
		lbl.setOpaque(true);
		lbl.addMouseListener(controller);
		lbl.addMouseMotionListener(controller);
		UML.getJLabels().add(new BoxObject(uml.getClassName(), lbl));
	}
	
	public static void updateBox(BoxObject obj) {
		for(UML uml : UML.getCollection()) {
			if(obj.getJLabelName().equals(uml.getClassName())) {
				String text = "<html>" + uml.getClassName();
				for(Fields field : uml.getField()) {
					text += "<br>" + field.getFieldType() + " " + field.getFieldName();
				}
				for(Methods method : uml.getMethod()) {
					text += "<br>" + method.getMethodType() + " " + method.getMethodName() + "(";
					if(method.getParams().size() >= 1) {
						text += method.getParams().get(0).getParamType() + " " + method.getParams().get(0).getParamName();
					}
					for(int i = 1; i < method.getParams().size(); i++) {
						text += ", " + method.getParams().get(i).getParamType() + " " + method.getParams().get(i).getParamName();
					}
					text += ")";
				}
				text += "</html>";
				obj.getLabel().setText(text);
				obj.getLabel().setSize(obj.getLabel().getPreferredSize().width + 10, obj.getLabel().getPreferredSize().height + 2);
				obj.getLabel().setLocation(uml.getposition_x(), uml.getposition_y());
				panel.add(obj.getLabel());
				break;
			}
		}
	}
	
	public static void updateBoxes() {
		for(BoxObject obj : UML.getJLabels()) {
			for(UML uml : UML.getCollection()) {
				if(obj.getJLabelName().equals(uml.getClassName())) {
					String text = "<html>" + uml.getClassName();
					for(Fields field : uml.getField()) {
						text += "<br>" + field.getFieldType() + " " + field.getFieldName();
					}
					for(Methods method : uml.getMethod()) {
						text += "<br>" + method.getMethodType() + " " + method.getMethodName() + "(";
						if(method.getParams().size() >= 1) {
							text += method.getParams().get(0).getParamType() + " " + method.getParams().get(0).getParamName();
						}
						for(int i = 1; i < method.getParams().size(); i++) {
							text += ", " + method.getParams().get(i).getParamType() + " " + method.getParams().get(i).getParamName();
						}
						text += ")";
					}
					text += "</html>";
					obj.getLabel().setText(text);
					obj.getLabel().setSize(obj.getLabel().getPreferredSize().width + 10, obj.getLabel().getPreferredSize().height + 2);
					obj.getLabel().setLocation(uml.getposition_x(), uml.getposition_y());
					panel.add(obj.getLabel());
					
					break;
				}
			}
		}

	}

	public static void closeGUI() {
		frmUmlEditor.dispose();
	}
}