
public class Relationships {
	private String relType;
	private UML receiving;

	public Relationships(UML umlFile, String type) {
		this.relType = type;
		this.receiving = umlFile;
	}

	public String getRelType() {
		return relType;
	}

	public void setRelType(String newType) {
		relType = newType;
	}

	public UML getReceiving() {
		return receiving;
	}

	public void setName(UML uml) {
		receiving = uml;
	}
}
