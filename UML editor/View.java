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
	public static JLabel outputLbl;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		btnAddClass.addActionListener(new Controller());
		panel.add(btnAddClass);

		JButton btnRemoveClass = new JButton("Remove Class");
		btnRemoveClass.setActionCommand("Remove Class");
		btnRemoveClass.addActionListener(new Controller());
		panel.add(btnRemoveClass);

		JButton btnRenameClass = new JButton("Rename Class");
		btnRenameClass.setActionCommand("Rename Class");
		btnRenameClass.addActionListener(new Controller());
		panel.add(btnRenameClass);

		JButton btnAddMethod = new JButton("Add Method");
		btnAddMethod.setActionCommand("Add Method");
		btnAddMethod.addActionListener(new Controller());
		panel.add(btnAddMethod);

		JButton btnRemoveMethod = new JButton("Remove Method");
		btnRemoveMethod.setActionCommand("Remove Method");
		btnRemoveMethod.addActionListener(new Controller());
		panel.add(btnRemoveMethod);

		JButton btnRenameMethod = new JButton("Rename Method");
		btnRenameMethod.setActionCommand("Rename Method");
		btnRenameMethod.addActionListener(new Controller());
		panel.add(btnRenameMethod);

		JButton btnAddParameter = new JButton("Add Parameter");
		btnAddParameter.setActionCommand("Add Parameter");
		btnAddParameter.addActionListener(new Controller());
		panel.add(btnAddParameter);

		JButton btnRemoveParameter = new JButton("Remove Parameter");
		btnRemoveParameter.setActionCommand("Remove Parameter");
		btnRemoveParameter.addActionListener(new Controller());
		panel.add(btnRemoveParameter);

		JButton btnRenameParameter = new JButton("Rename Parameter");
		btnRenameParameter.setActionCommand("Rename Parameter");
		btnRenameParameter.addActionListener(new Controller());
		panel.add(btnRenameParameter);

		JButton btnAddField = new JButton("Add Field");
		btnAddField.setActionCommand("Add Field");
		btnAddField.addActionListener(new Controller());
		panel.add(btnAddField);

		JButton btnRemoveField = new JButton("Remove Field");
		btnRemoveField.setActionCommand("Remove Field");
		btnRemoveField.addActionListener(new Controller());
		panel.add(btnRemoveField);

		JButton btnRenameField = new JButton("Rename Field");
		btnRenameField.setActionCommand("Rename Field");
		btnRenameField.addActionListener(new Controller());
		panel.add(btnRenameField);

		JButton btnAddRelationship = new JButton("Add Relationship");
		btnAddRelationship.setActionCommand("Add Relationship");
		btnAddRelationship.addActionListener(new Controller());
		panel.add(btnAddRelationship);

		JButton btnRemoveRelationship = new JButton("Remove Relationship");
		btnRemoveRelationship.setActionCommand("Remove Relationship");
		btnRemoveRelationship.addActionListener(new Controller());
		panel.add(btnRemoveRelationship);

		JButton btnListClasses = new JButton("List Classes");
		btnListClasses.setActionCommand("List Classes");
		btnListClasses.addActionListener(new Controller());
		panel.add(btnListClasses);

		JButton btnListContents = new JButton("List Contents");
		btnListContents.setActionCommand("List Contents");
		btnListContents.addActionListener(new Controller());
		panel.add(btnListContents);

		JButton btnListRelationships = new JButton("List Relationships");
		btnListRelationships.setActionCommand("List Relationship");
		btnListRelationships.addActionListener(new Controller());
		panel.add(btnListRelationships);



		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(1232, 10, 118, 136);
		frmUmlEditor.getContentPane().add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnSave = new JButton("Save");
		btnSave.setActionCommand("Save");
		btnSave.addActionListener(new Controller());
		panel_1.add(btnSave);

		JButton btnLoad = new JButton("Load");
		btnLoad.setActionCommand("Load");
		btnLoad.addActionListener(new Controller());
		panel_1.add(btnLoad);

		JButton btnHelp = new JButton("Help");
		btnHelp.setActionCommand("Help");
		btnHelp.addActionListener(new Controller());
		panel_1.add(btnHelp);

		JButton btnSwitch = new JButton("Switch to CLI");
		btnSwitch.setActionCommand("CLI");
		btnSwitch.addActionListener(new Controller());
		panel_1.add(btnSwitch);



		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(185, 10, 165, 269);
		frmUmlEditor.getContentPane().add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel input_1 = new JLabel("New label");
		panel_2.add(input_1);

		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(10);

		JLabel input_2 = new JLabel("New label");
		panel_2.add(input_2);

		textField_2 = new JTextField();
		panel_2.add(textField_2);
		textField_2.setColumns(10);

		JLabel input_3 = new JLabel("New label");
		panel_2.add(input_3);

		textField_3 = new JTextField();
		panel_2.add(textField_3);
		textField_3.setColumns(10);

		JButton btnEnter = new JButton("Enter");
		btnEnter.setActionCommand("Enter");
		btnEnter.addActionListener(new Controller());
		panel_2.add(btnEnter);

		JLabel warningLbl = new JLabel("");
		panel_2.add(warningLbl);



		outputLbl = new JLabel("");
		outputLbl.setBounds(360, 10, 862, 679);
		frmUmlEditor.getContentPane().add(outputLbl);
		outputLbl.setVerticalAlignment(SwingConstants.TOP);
		outputLbl.setFont(outputLbl.getFont().deriveFont(16f));
	}

	public static void closeGUI() {
		frmUmlEditor.dispose();
	}
}
