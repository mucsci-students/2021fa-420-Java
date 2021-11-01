package uml;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class BoxObject {
	private String jlabelName;
	private JLabel label;
	
	public BoxObject(String jlabelName, JLabel label) {
		this.jlabelName = jlabelName;
		this.label = label;
	}
	
	public String getJLabelName() {
		return jlabelName;
	}
	
	public void setJLabelName(String newName) {
		jlabelName = newName;
	}
	
	public JLabel getLabel() {
		return label;
	}
	
	public static void createBox(UML uml) {
		try {
			View.lbl = new JLabel("<html>" + uml.getClassName() + "</html>");
			View.panel.add(View.lbl);
			View.lbl.setSize(View.lbl.getPreferredSize().width + 10, View.lbl.getPreferredSize().height + 6);
			View.lbl.setVerticalAlignment(JLabel.TOP);
			View.lbl.setHorizontalAlignment(JLabel.CENTER);
			View.lbl.setLocation(uml.getposition_x(), uml.getposition_y());
			View.lbl.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			View.lbl.setVisible(true);
			View.lbl.setOpaque(true);
			View.lbl.addMouseListener(View.controller);
			View.lbl.addMouseMotionListener(View.controller);
			Model.getJLabels().add(new BoxObject(uml.getClassName(), View.lbl));
		} catch (Exception e) {
			;
		}
		
	}
	
	public static void updateBox(BoxObject obj) {
		for(UML uml : Model.getCollection()) {
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
				View.panel.add(obj.getLabel());
				break;
			}
		}
	}
	
	public static void updateBoxes() {
		for(BoxObject obj : Model.getJLabels()) {
			for(UML uml : Model.getCollection()) {
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
					View.panel.add(obj.getLabel());
					
					break;
				}
			}
		}

	}

}