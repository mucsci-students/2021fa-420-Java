import javax.swing.JLabel;

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
}
