public class Relationships {
	private String source;
	private String destination;
	private String type;

	public Relationships(UML source, UML destination, String type) {
		if (testType(type)) {
			this.source = source.getClassName();
			this.destination = destination.getClassName();
			this.type = type;
		} else {
			System.out.println("Error:Type must be aggregation, composition, inheritance, or realization.");
		}
	}

	private boolean testType (String type) {
		type.toLowerCase();
		if (type.equals("aggregation")||type.equals("composition")||type.equals("inheritance")||type.equals("realization")) {
			return true;
		}
		return false; 
	}

	public String getSource() {
		return source;
	}

	public void setSource(UML source) {
		this.source = source.getClassName();
	}

	public String getDestination() {
		return destination;
	}


	public void setDestination(UML destination) {
		this.destination = destination.getClassName();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		if (testType(type)) {
			this.type = type;
		} else {
			System.out.println("Error:Type must be aggregation, composition, inheritance, or realization.");
		}
	}

	public static void addRel(UML source, UML destination, String type){ //make String type into enum later
        boolean foundDest = false;
        boolean foundSrc = false;
        boolean dupeRel = false;
        for (UML c: UML.getCollection()){
            if (c.getClassName().equals(source.getClassName())) {
                foundSrc = true;
            }
            if (c.getClassName().equals(destination.getClassName())){ // Need to see if the destination file exists
                foundDest = true;
            }
            if(source == destination) {
                foundDest = false;
                foundSrc = false;
            }
        }
        if(foundSrc && foundDest){
            for (Relationships c: source.getRels()) {
                if (c.getDestination() == destination.getClassName()) {
                    dupeRel = true;
                    System.out.println("A relationship from " + source.getClassName() + " to " + destination.getClassName() + " already exists");
                }
            }
            if (dupeRel == false) {
                Relationships r = new Relationships(source, destination, type);
                for(UML u : UML.getCollection()){
                    if( u.getClassName().toLowerCase().equals(source.getClassName().toLowerCase())){ // searches for the class name that we are adding a relationship to
                        u.getRels().add(r); 
                        System.out.println("Relationship added!");

                        return;
                    }
                }
            }
        } else {
            System.out.println("Improper input");

        }
    }

        public static void delRel(String className, UML destination) {
            for(UML u : UML.getCollection()){
                if (u.getClassName().toLowerCase().equals(u.getClassName().toLowerCase())){ //finds uml
                    for (Relationships r : u.getRels()){
                        if (r.getDestination().equals(destination.getClassName()) ){ //Checks if a relationship in the relationship arraylist has the same name as the requested deletion destination 
                            int x = u.getRels().indexOf(r);    // Needed to finds where the relationship is that we need to delete
                            u.getRels().remove(x);
                            System.out.println("Relationship deleted!");
                            return;
                        }

                    }
                    System.out.println(destination + " does not exist");
                }
            }
            System.out.println(className + " does not exist");


    }
}