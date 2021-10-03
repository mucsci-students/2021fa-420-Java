import java.util.ArrayList;

public class Methods {
	private String name;
	private String retType;
	private ArrayList<Parameters> param;

	public Methods(String name, String type) {
		this.name = name;
		this.retType = type;
	}

	public String getMethodName() {
		return name;
	}

	public void setMethodName(String newName) {
		name = newName;
	}
	
	public String getMethodType() {
		return retType;
	}

	public void setMethodType(String newType) {
		retType = newType;
	}

	public ArrayList<Parameters> getParamList (){
		return param;
	}

}
