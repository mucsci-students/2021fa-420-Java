import java.util.*;

// Test no duplicates, Test all functions, I think no dupes is currently storign all params not just in per method

public class Parameters {
	private String name;
	private String type;
	private static HashSet<String> noPDupes;

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

	public void deleteParameter (String UMLName, String methodsName, String pName, String pType){
		ArrayList<Parameters> mList = findMethod(UMLName, methodsName);
		if(mList.indexOf(new Parameters(pName, pType)) != -1){
			mList.remove(new Parameters(pName, pType));
			removeDupe(pName);
		}
		else {
		System.out.println("Parameter not found!");
		}
	}

	public void deleteAllParameters (String UMLName, String methodsName){
		ArrayList<Parameters> mList = findMethod(UMLName, methodsName);
		mList.clear();
		emptyPDupes();
	}

	public static void addParameter(String UMLName, String methodsName, String pName, String pType){
		ArrayList<Parameters> mList = findMethod(UMLName, methodsName);
		Parameters p = addNoDupes(pName, pType);
		mList.add(p);
	}

	public void changeParameter(String UMLName, String methodsName, String oldpName, String oldpType, String newpName, String newpType ){
		ArrayList<Parameters> mList = findMethod(UMLName, methodsName);
		int index = mList.indexOf(new Parameters(oldpName, oldpType));
		if(index != -1){
			removeDupe(oldpName);
			Parameters p = addNoDupes(newpName, newpType);
			mList.set(index, p);
		} else {
		System.out.println("Parameter not found!");
		}

	}
	public void changeAllParameters(String UMLName, String methodsName){
		Scanner scanner = new Scanner(System.in);

		ArrayList<Parameters> mList = findMethod(UMLName, methodsName);

		for (int index = 0; index >= mList.size() - 1; ++index ){
			System.out.println("Below is the parameter being changed:");
			System.out.println("Name "+ mList.get(index).getParamName() +" Type: " + mList.get(index).getParamType());

			System.out.println("Whate is the new name?");
			String pName = scanner.nextLine().toLowerCase().replaceAll("\\s","");
			while(noPDupes.contains(pName.toLowerCase())){
				System.out.println("That parameter name already exists! Type a unique parameter name.");
				pName = scanner.nextLine().toLowerCase().replaceAll("\\s","");
			}
				
			System.out.println("What is" + pName + "'s type");
			String pType = scanner.nextLine().toLowerCase().replaceAll("\\s","");

			mList.set(index, new Parameters(pName, pType));
		}
		scanner.close();

	}

	public void listParameters(String UMLName, String methodsName){
		ArrayList<Parameters> mList = findMethod(UMLName, methodsName);
		for (Parameters p : mList){
			System.out.println("Name: " + p.getParamName()+ " Type: " + p.getParamType());
		}
	}


	public static boolean noParameterDupes(String s){
		return noPDupes.contains(s.toLowerCase());
	}

	public static Parameters addNoDupes(String name, String type){
		if (noParameterDupes(name)){
		noPDupes.add(name.toLowerCase());
		return new Parameters(name, type);
		} else {
		System.out.println("Parameter name: " + name + " already exists!");
		System.out.println("Enter a different name");
		return addNoDupes(name, type);
		}
	}

	public boolean removeDupe(String s){
		return noPDupes.remove(s.toLowerCase());
	}

	public void emptyPDupes(){
		noPDupes.clear();
	}

	public static ArrayList<Methods> findMethod(String umlName, String methods ){
		for(UML u : UML.getCollection()){
			if(umlName.equals(u.getClassName)){
				UML foundUML = u;
				break;
			}
		}
		if(foundUML){
			for (Methods m : UML.getMethod()){
				if(methods.equals(u.getClassName)){
					return m;
				}
			}
			System.out.println("Method not found!");
		}
		System.out.println("Class not found!");
	}
}
