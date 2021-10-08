import java.util.*;

// Test no duplicates, Test all functions,

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

	public static void deleteParameter (String UMLName, String methodsName, String pName){
		ArrayList<Parameters> mList = findMethod(UMLName, methodsName);
		int index = -1;

		for(Parameters param : mList){
			if(param.getParamName().equalsIgnoreCase(pName)){
				index = mList.indexOf(param);
				break;
			}
		}

		if(index != -1){
			mList.remove(index);
		}
		else {
			System.out.println("Parameter not found!");
		}
	}

	//works
	public static void deleteAllParameters (String UMLName, String methodsName){
		ArrayList<Parameters> mList = findMethod(UMLName, methodsName);
		mList.clear();
	}

	//works
	public static void addParameter(String UMLName, String methodsName, String pName, String pType){
		ArrayList<Parameters> mList = findMethod(UMLName, methodsName);
		Parameters p = new Parameters(pName, pType);
		mList.add(p);
	}
	//works
	public static void changeParameter(String UMLName, String methodsName, String oldpName, String newpName, String newpType ){

		ArrayList<Parameters> mList = findMethod(UMLName, methodsName);

		int index = -1;

		for(Parameters param : mList){
			if(param.getParamName().equalsIgnoreCase(oldpName)){
				index = mList.indexOf(param);
				break;
			}
		}

		if(index != -1){

			Parameters p = new Parameters(newpName, newpType);
			mList.set(index, p);
		} else {
			System.out.println("Parameter not found!");
		}

	}

	//works
	public static void changeAllParameters(String UMLName, String methodsName){

		Scanner scanner = new Scanner(System.in);
		ArrayList<Parameters> mList = findMethod(UMLName, methodsName);

		for (int index = 0; index <= mList.size() -1; ++index ){

			System.out.println("Below is the parameter being changed:");
			System.out.println("Name " + mList.get(index).getParamName() +" Type: " + mList.get(index).getParamType());

			System.out.println("What is the new name?");
			String pName = scanner.nextLine().toLowerCase().replaceAll("\\s","");


			System.out.println("What is " + pName + "'s type");
			String pType = scanner.nextLine().toLowerCase().replaceAll("\\s","");

			mList.set(index, new Parameters(pName, pType));

		}
	}

	//works
	public static void listParameters(String UMLName, String methodsName){
		ArrayList<Parameters> mList = findMethod(UMLName, methodsName);
		for (Parameters p : mList){
			System.out.println("Name: " + p.getParamName()+ " Type: " + p.getParamType());
		}
	}

	//works
	public static ArrayList<Parameters> findMethod(String umlName, String methods ){
		UML foundUML = null;

		for(UML u : UML.getCollection()){
			if(umlName.equals(u.getClassName())){
				foundUML = u;
				break;
			}
		}
		if(foundUML != null){
			for (Methods m : foundUML.getMethod()){
				if(methods.equals(m.getMethodName())){

					return m.getParams();
				}
			}
			System.out.println("Method not found!");
			System.out.println("Enter a new method name or type exit");
			Scanner scanner = new Scanner(System.in);
			String newTry = scanner.nextLine().toLowerCase().replaceAll("\\s","");
			scanner.close();
			return findMethod(umlName, newTry);
		}

		System.out.println("Class not found!");
		System.out.println("Enter a new method name or type exit");
		Scanner scanner = new Scanner(System.in);
		String newTry2 = scanner.nextLine().toLowerCase().replaceAll("\\s","");
		scanner.close();
		return findMethod(newTry2, methods);
	}		
}