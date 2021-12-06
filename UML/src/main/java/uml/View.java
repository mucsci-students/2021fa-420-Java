package uml;


/**
 *
 * @author tbren
 */
public class View extends javax.swing.JFrame {

    public static Controller controller = new Controller();

    public View() {
        initComponents();
    }

    public static View view;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

		
/*----------------------------------------------------------------------------------------------------------
* ALL BUTTONS

-----------------------------------------------------------------------------------------------------------*/
		load = new javax.swing.JButton();
		load.addActionListener(controller);
		load.setActionCommand("Load");
		load.setText("Load");

        save = new javax.swing.JButton();
		save.addActionListener(controller);
		save.setActionCommand("Save");
		save.setText("Save");

        help = new javax.swing.JButton();
		help.addActionListener(controller);
		help.setActionCommand("Help");
		help.setText("Help");

		CLI = new javax.swing.JButton();
		CLI.addActionListener(controller);
		CLI.setActionCommand("CLI");
		CLI.setText("CLI");

        screenshot = new javax.swing.JButton();
		screenshot.addActionListener(controller);
		screenshot.setActionCommand("Screenshot");
		screenshot.setText("Screenshot");

		addclass = new javax.swing.JButton();
		addclass.addActionListener(controller);
		addclass.setActionCommand("Add Class");
		addclass.setText("Add Class");

        removeclass = new javax.swing.JButton();
		removeclass.addActionListener(controller);
		removeclass.setActionCommand("Remove Class");
		removeclass.setText("Remove Class");

        renameclass = new javax.swing.JButton();
		renameclass.addActionListener(controller);
		renameclass.setActionCommand("Rename Class");
        renameclass.setText("Rename Class");

		addmethod = new javax.swing.JButton();
		addmethod.addActionListener(controller);
		addmethod.setActionCommand("Add Method");
		addmethod.setText("Add Method");

        removemethod = new javax.swing.JButton();
		removemethod.addActionListener(controller);
		removemethod.setActionCommand("Remove Method");
		removemethod.setText("Remove Method");
		
        removeall = new javax.swing.JButton();
		removeall.addActionListener(controller);
		removeall.setActionCommand("Remove All Methods");
		removeall.setText("Remove All Methods");

		renamemethod = new javax.swing.JButton();
		renamemethod.addActionListener(controller);
		renamemethod.setActionCommand("Rename Method");
		renamemethod.setText("Rename Method");

		addparam = new javax.swing.JButton();
		addparam.addActionListener(controller);
		addparam.setActionCommand("Add Parameter");
		addparam.setText("Add Parameter");

        removeparam = new javax.swing.JButton();
		removeparam.addActionListener(controller);
		removeparam.setActionCommand("Remove Parameter");
		removeparam.setText("Remove Parameter");

        removeallparams = new javax.swing.JButton();
		removeallparams.addActionListener(controller);
		removeallparams.setActionCommand("Remove All Parameters");
		removeallparams.setText("Remove All Parameters");

        changeparams = new javax.swing.JButton();
		changeparams.addActionListener(controller);
		changeparams.setActionCommand("Change Parameter");
		changeparams.setText("Change Parameter");

		addfield = new javax.swing.JButton();
		addfield.addActionListener(controller);
		addfield.setActionCommand("Add Field");
		addfield.setText("Add Field");

        removefield = new javax.swing.JButton();
		removefield.addActionListener(controller);
		removefield.setActionCommand("Remove Field");
		removefield.setText("Remove Field");

        renamefield = new javax.swing.JButton();
		renamefield.addActionListener(controller);
		renamefield.setActionCommand("Rename Field");
		renamefield.setText("Rename Field");

        addrelationship = new javax.swing.JButton();
		addrelationship.addActionListener(controller);
		addrelationship.setActionCommand("Add Relationship");
		addrelationship.setText("Add Realtionship");

        changerelationship = new javax.swing.JButton();
		changerelationship.addActionListener(controller);
		changerelationship.setActionCommand("Change Relationship");
		changerelationship.setText("Change RelationShip");

        removerelationship = new javax.swing.JButton();
		removerelationship.addActionListener(controller);
		removerelationship.setActionCommand("Remove Relationship");
		removerelationship.setText("Remove Relationship");

		undo = new javax.swing.JButton();
		undo.addActionListener(controller);
		undo.setActionCommand("Undo");
		undo.setText("Undo");

		redo = new javax.swing.JButton();
		redo.addActionListener(controller);
		redo.setActionCommand("Redo");
		redo.setText("Redo");

		Enter = new javax.swing.JButton();
		Enter.addActionListener(controller);
		Enter.setActionCommand("Enter");
		Enter.setText("Enter");
		
        
/*----------------------------------------------------------------------------------------------------------
* Panels & Frame & Labels & TextField
-----------------------------------------------------------------------------------------------------------*/
		frmUmlEditor = new javax.swing.JFrame();
        scroll = new javax.swing.JScrollPane();

        panel = new javax.swing.JPanel();
		inputPanel = new javax.swing.JPanel();
		inputPanel.setVisible(false);

		inputLbl = new javax.swing.JLabel();
		inputLbl.setText("");

		textField = new javax.swing.JTextField();
		textField.setText("");
    
/*----------------------------------------------------------------------------------------------------------
* Toolbar
-----------------------------------------------------------------------------------------------------------*/
			
		toolbar = new javax.swing.JToolBar();
		toolbar.setFloatable(false);

        load.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        load.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolbar.add(load);

        save.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        save.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolbar.add(save);

        help.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        help.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolbar.add(help);
        
        CLI.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        CLI.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolbar.add(CLI);

        screenshot.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        screenshot.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolbar.add(screenshot);

        undo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        undo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolbar.add(undo);

        redo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        redo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolbar.add(redo);
/*----------------------------------------------------------------------------------------------------------
* Tabs
-----------------------------------------------------------------------------------------------------------*/
        Tab = new javax.swing.JTabbedPane();
        classTab = new javax.swing.JPanel();
        methodsTab = new javax.swing.JPanel();
		relationshipTab = new javax.swing.JPanel();
        fieldTab = new javax.swing.JPanel();
        paramTab = new javax.swing.JPanel();

		

		//Adding to Tab
		Tab.addTab("Class", classTab);
		Tab.addTab("Methods", methodsTab);
		Tab.addTab("Fields", fieldTab);
		Tab.addTab("Relationships", relationshipTab);
		Tab.addTab("Parameters", paramTab);
        
        	
/*----------------------------------------------------------------------------------------------------------
* FRAME LAYOUT (NO TOUCHY!)
-----------------------------------------------------------------------------------------------------------*/

        

        javax.swing.GroupLayout frameLayout = new javax.swing.GroupLayout(frmUmlEditor.getContentPane());
        frmUmlEditor.getContentPane().setLayout(frameLayout);
        frameLayout.setHorizontalGroup(
            frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        frameLayout.setVerticalGroup(
            frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

/*----------------------------------------------------------------------------------------------------------
* PANEL LAYOUT (NO TOUCHY!)
-----------------------------------------------------------------------------------------------------------*/
        scroll.setBackground(new java.awt.Color(102, 102, 102));

        panel.setBackground(new java.awt.Color(102, 102, 102));
        panel.setAutoscrolls(true);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1792, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1652, Short.MAX_VALUE)
        );

        scroll.setViewportView(panel);


/*----------------------------------------------------------------------------------------------------------
* TAB LAYOUT (NO TOUCHY!)
-----------------------------------------------------------------------------------------------------------*/
		//Classes Tab
        javax.swing.GroupLayout classTabLayout = new javax.swing.GroupLayout(classTab);
        classTab.setLayout(classTabLayout);
        classTabLayout.setHorizontalGroup(
            classTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addclass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(removeclass, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
            .addComponent(renameclass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        classTabLayout.setVerticalGroup(
            classTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(classTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addclass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeclass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(renameclass)
                .addContainerGap(304, Short.MAX_VALUE))
        );
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//Methods Tab
		javax.swing.GroupLayout methodsTabLayout = new javax.swing.GroupLayout(methodsTab);
        methodsTab.setLayout(methodsTabLayout);
        methodsTabLayout.setHorizontalGroup(
            methodsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(renamemethod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(removeall, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
            .addComponent(removemethod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(addmethod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        methodsTabLayout.setVerticalGroup(
            methodsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(methodsTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addmethod)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removemethod)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeall)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(renamemethod)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		//Fields Tab
		javax.swing.GroupLayout fieldTabLayout = new javax.swing.GroupLayout(fieldTab);
        fieldTab.setLayout(fieldTabLayout);
        fieldTabLayout.setHorizontalGroup(
            fieldTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addfield, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(removefield, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
            .addComponent(renamefield, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        fieldTabLayout.setVerticalGroup(
            fieldTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fieldTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addfield)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removefield)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(renamefield)
                .addContainerGap(304, Short.MAX_VALUE))
        );
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Relationship Tab
javax.swing.GroupLayout relationshipTabLayout = new javax.swing.GroupLayout(relationshipTab);
        relationshipTab.setLayout(relationshipTabLayout);
        relationshipTabLayout.setHorizontalGroup(
            relationshipTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addrelationship, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(changerelationship, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(removerelationship, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
        );
        relationshipTabLayout.setVerticalGroup(
            relationshipTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(relationshipTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addrelationship)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changerelationship)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removerelationship)
                .addContainerGap(304, Short.MAX_VALUE))
        );


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Parameters Tab
	javax.swing.GroupLayout paramTabLayout = new javax.swing.GroupLayout(paramTab);
	paramTab.setLayout(paramTabLayout);
	paramTabLayout.setHorizontalGroup(
		paramTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addComponent(addparam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		.addComponent(removeparam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		.addComponent(removeallparams, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		.addComponent(changeparams, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	);
	paramTabLayout.setVerticalGroup(
		paramTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		.addGroup(paramTabLayout.createSequentialGroup()
			.addContainerGap()
			.addComponent(addparam)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(removeparam)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(removeallparams)
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(changeparams)
			.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//Tab pane
javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(43, 43, 43))
            .addGroup(layout.createSequentialGroup()
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tab, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Tab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1027, 1027, 1027))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 897, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
/*----------------------------------------------------------------------------------------------------------
* INPUT PANEL LAYOUT (NO TOUCHY!)
-----------------------------------------------------------------------------------------------------------*/
javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(inputPanel);
inputPanel.setLayout(jPanel2Layout);
jPanel2Layout.setHorizontalGroup(
	jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	.addGroup(jPanel2Layout.createSequentialGroup()
		.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(jPanel2Layout.createSequentialGroup()
				.addContainerGap()
				.addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18))
			.addGroup(jPanel2Layout.createSequentialGroup()
				.addGap(149, 149, 149)
				.addComponent(Enter))
			.addComponent(inputLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
		.addGap(0, 0, Short.MAX_VALUE))
);
jPanel2Layout.setVerticalGroup(
	jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	.addGroup(jPanel2Layout.createSequentialGroup()
		.addComponent(inputLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
			.addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		.addComponent(Enter)
		.addContainerGap())
); 

/*----------------------------------------------------------------------------------------------------------
* Format helper
-----------------------------------------------------------------------------------------------------------*/

    

        pack();
    }// </editor-fold>                        
                                        

    /**
     * @param args the command line arguments
     */
    public static void runGUI() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               view = new View();
			   view.setVisible(true);
            }
        });
    }

	public static void closeGUI(){
		view.setVisible(false);
		
	}

    // Variables declaration - do not modify                     
    private javax.swing.JButton load;
	private javax.swing.JButton save;
	private javax.swing.JButton help;
    private javax.swing.JButton CLI;
    private javax.swing.JButton screenshot;
    private javax.swing.JButton undo;
    private javax.swing.JButton addclass;
    private javax.swing.JButton removeclass;
    private javax.swing.JButton renameclass;
    private javax.swing.JButton addmethod;
    private javax.swing.JButton removemethod;
    private javax.swing.JButton removeall;
    private javax.swing.JButton renamemethod;
    private javax.swing.JButton addparam;
    private javax.swing.JButton removeparam;
    private javax.swing.JButton removeallparams;
    private javax.swing.JButton changeparams;
    private javax.swing.JButton addfield;
    private javax.swing.JButton removefield;
    
    private javax.swing.JButton renamefield;
    private javax.swing.JButton addrelationship;
    private javax.swing.JButton changerelationship;
    private javax.swing.JButton removerelationship;
    private javax.swing.JButton redo;
    private javax.swing.JButton Enter;
    
    public static javax.swing.JFrame frmUmlEditor;
    public static javax.swing.JLabel inputLbl;

    public static javax.swing.JPanel panel;
    private javax.swing.JPanel methodsTab;
    private javax.swing.JPanel fieldTab;
    private javax.swing.JPanel relationshipTab;
    private javax.swing.JPanel paramTab;
    public static javax.swing.JPanel inputPanel;
    private javax.swing.JPanel classTab;

    private javax.swing.JScrollPane scroll;
    private javax.swing.JTabbedPane Tab;
    public static javax.swing.JTextField textField;
    private javax.swing.JToolBar toolbar;
	public static javax.swing.JLabel lbl;
    // End of variables declaration                   
}
