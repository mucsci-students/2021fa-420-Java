public class Relationships {
	private UML source;
	private UML destination;
	private String type;

	public Relationships(UML source, UML destination, String type) {
		if (testType(type)) {
			this.source = source;
			this.destination = destination;
			this.type = type;
		} else {
			System.out.println("Error:Type must be aggregation, composition, inharitance, or realization.");
		}
	}
	
	private boolean testType (String type) {
		type.toLowerCase();
		if (type == "aggregation"|type == "composition"|type == "inharitance"|type == "realization") {
			return true;
		}
		return false; 
	}

	public UML getSource() {
		return source;
	}
	
	public void setSource(UML source) {
		this.source = source;
	}
	
	public UML getDestination() {
		return destination;
	}
	

	public void setDestination(UML destination) {
		this.destination = destination;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		if (testType(type)) {
			this.type = type;
		} else {
			System.out.println("Error:Type must be aggregation, composition, inharitance, or realization.");
		}
	}
}
