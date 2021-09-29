
public class Parameters {
	private String name;
	private String type;

	public Parameters(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public String getParamName() {
		return name;
	}

	public void setParamName(String newName) {
		name = newName;
	}
	
	public String getParamType() {
		return type;
	}

	public void setParamType(String newType) {
		type = newType;
	}
}
