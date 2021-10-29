package src.main.java.uml;

public class Arrows {
	private BoxObject src;
	private BoxObject dest;
	private String type;
	
	public Arrows(BoxObject src, BoxObject dest, String type) {
		this.src = src;
		this.dest = dest;
		this.type = type;
	}
	
	public BoxObject getSrc() {
		return src;
	}
	
	public BoxObject getDest() {
		return dest;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}
