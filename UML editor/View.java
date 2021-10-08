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
	public static JFrame frmUmlEditor;
	public static JLabel inputLbl;
	public static JLabel outputLbl;
	public static String outputText;
	public static JTextField textField;
	public static JPanel panel_2;
	public static Controller controller = new Controller();
	private JTextField textFieldJSON;

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
		frmUmlEditor = new JFrame();
		frmUmlEditor.setTitle("UML Editor");
		frmUmlEditor.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmUmlEditor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUmlEditor.getContentPane().setLayout(null);
		frmUmlEditor.getContentPane().setPreferredSize(new Dimension(1360, 700));
		frmUmlEditor.pack();

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 10, 165, 539);
		frmUmlEditor.getContentPane().add(panel);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnAddClass = new JButton("Add Class");
		btnAddClass.setActionCommand("Add Class");
		btnAddClass.addActionListener(controller);
		panel.add(btnAddClass);

		JButton btnRemoveClass = new JButton("Remove Class");
		btnRemoveClass.setActionCommand("Remove Class");
		btnRemoveClass.addActionListener(controller);
		panel.add(btnRemoveClass);

		JButton btnRenameClass = new JButton("Rename Class");
		btnRenameClass.setActionCommand("Rename Class");
		btnRenameClass.addActionListener(controller);
		panel.add(btnRenameClass);

		JButton btnAddMethod = new JButton("Add Method");
		btnAddMethod.setActionCommand("Add Method");
		btnAddMethod.addActionListener(controller);
		panel.add(btnAddMethod);

		JButton btnRemoveMethod = new JButton("Remove Method");
		btnRemoveMethod.setActionCommand("Remove Method");
		btnRemoveMethod.addActionListener(controller);
		panel.add(btnRemoveMethod);

		JButton btnRenameMethod = new JButton("Rename Method");
		btnRenameMethod.setActionCommand("Rename Method");
		btnRenameMethod.addActionListener(controller);
		panel.add(btnRenameMethod);

		JButton btnAddParameter = new JButton("Add Parameter");
		btnAddParameter.setActionCommand("Add Parameter");
		btnAddParameter.addActionListener(controller);
		panel.add(btnAddParameter);

		JButton btnRemoveParameter = new JButton("Remove Parameter");
		btnRemoveParameter.setActionCommand("Remove Parameter");
		btnRemoveParameter.addActionListener(controller);
		panel.add(btnRemoveParameter);

		JButton btnRenameParameter = new JButton("Rename Parameter");
		btnRenameParameter.setActionCommand("Rename Parameter");
		btnRenameParameter.addActionListener(controller);
		panel.add(btnRenameParameter);

		JButton btnAddField = new JButton("Add Field");
		btnAddField.setActionCommand("Add Field");
		btnAddField.addActionListener(controller);
		panel.add(btnAddField);

		JButton btnRemoveField = new JButton("Remove Field");
		btnRemoveField.setActionCommand("Remove Field");
		btnRemoveField.addActionListener(controller);
		panel.add(btnRemoveField);

		JButton btnRenameField = new JButton("Rename Field");
		btnRenameField.setActionCommand("Rename Field");
		btnRenameField.addActionListener(controller);
		panel.add(btnRenameField);

		JButton btnAddRelationship = new JButton("Add Relationship");
		btnAddRelationship.setActionCommand("Add Relationship");
		btnAddRelationship.addActionListener(controller);
		panel.add(btnAddRelationship);

		JButton btnRemoveRelationship = new JButton("Remove Relationship");
		btnRemoveRelationship.setActionCommand("Remove Relationship");
		btnRemoveRelationship.addActionListener(controller);
		panel.add(btnRemoveRelationship);

		JButton btnListClasses = new JButton("List Classes");
		btnListClasses.setActionCommand("List Classes");
		btnListClasses.addActionListener(controller);
		panel.add(btnListClasses);

		JButton btnListContents = new JButton("List Contents");
		btnListContents.setActionCommand("List Contents");
		btnListContents.addActionListener(controller);
		panel.add(btnListContents);

		JButton btnListRelationships = new JButton("List Relationships");
		btnListRelationships.setActionCommand("List Relationships");
		btnListRelationships.addActionListener(controller);
		panel.add(btnListRelationships);



		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(1232, 10, 118, 136);
		frmUmlEditor.getContentPane().add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnSave = new JButton("Save");
		btnSave.setActionCommand("Save");
		btnSave.addActionListener(controller);
		panel_1.add(btnSave);

		JButton btnLoad = new JButton("Load");
		btnLoad.setActionCommand("Load");
		btnLoad.addActionListener(controller);
		panel_1.add(btnLoad);

		JButton btnHelp = new JButton("Help");
		btnHelp.setActionCommand("Help");
		btnHelp.addActionListener(controller);
		panel_1.add(btnHelp);

		JButton btnSwitch = new JButton("Switch to CLI");
		btnSwitch.setActionCommand("CLI");
		btnSwitch.addActionListener(controller);
		panel_1.add(btnSwitch);



		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(185, 10, 165, 269);
		frmUmlEditor.getContentPane().add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		inputLbl = new JLabel("");
		panel_2.add(inputLbl);

		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);

		JButton btnEnter = new JButton("Enter");
		btnEnter.setActionCommand("Enter");
		btnEnter.addActionListener(controller);
		panel_2.add(btnEnter);
		panel_2.setVisible(false);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(1232, 157, 118, 82);
		frmUmlEditor.getContentPane().add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel copyLabel = new JLabel("<html><div style='text-align:center'>Copy JSON String</div></html>");
		panel_3.add(copyLabel);

		textFieldJSON = new JTextField();
		panel_3.add(textFieldJSON);
		textFieldJSON.setColumns(10);
		
		outputLbl = new JLabel("");
		outputLbl.setVerticalAlignment(SwingConstants.TOP);
		outputLbl.setFont(outputLbl.getFont().deriveFont(16f));
		outputLbl.setBounds(360, 10, 862, 679);
		frmUmlEditor.getContentPane().add(outputLbl);
		
	}

	public static void closeGUI() {
		frmUmlEditor.dispose();
	}
}
