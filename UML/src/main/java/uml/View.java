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
import javax.swing.SwingConstants;

public class View {
	//Window
	public static JFrame frmUmlEditor;

	//For user input
	public static JPanel inputPanel;
	public static JLabel inputLbl;
	public static JTextField textField;

	//For printing out info
	public static JLabel outputLbl;
	public static String outputText;

	//JSON string output
	public static JPanel savePanel;
	public static JTextField textFieldJSON;

	//Controller object to run commands
	public static Controller controller = new Controller();

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
		savePanel.setVisible(true);
		//*************************************************************************************//


		//Creates output label
		outputLbl = new JLabel("");
		outputLbl.setVerticalAlignment(SwingConstants.TOP);
		outputLbl.setFont(outputLbl.getFont().deriveFont(16f));
		outputLbl.setBounds(378, 10, 844, 679);
		frmUmlEditor.getContentPane().add(outputLbl);

	}

	public static void closeGUI() {
		frmUmlEditor.dispose();
	}
}
