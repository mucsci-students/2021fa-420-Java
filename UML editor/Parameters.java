import java.util.*;

// Test no duplicates, Test all functions, I think no dupes is currently storign all params not just in per method

public class Parameters {
	private String name;
	private String type;
	private HashSet<String> noPDupes;

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

	public void deleteParameter (Methods m, String pName, String pType){
		ArrayList<Parameters> mList = m.getParamList();
		if(mList.indexOf(new Parameters(pName, pType)) != -1){
			mList.remove(new Parameters(pName, pType));
			removeDupe(pName);
		}
		else {
		System.out.println("Parameter not found!");
		}
	}

	public void deleteAllParameters (Methods m){
		ArrayList<Parameters> mList = m.getParamList();
		mList.clear();
		emptyPDupes();
	}

	public void addParameter(Methods m, String pName, String pType){
		ArrayList<Parameters> mList = m.getParamList();
		Parameters p = addNoDupes(pName, pType);
		mList.add(p);
	}

	public void changeParameter(Methods m, String oldpName, String oldpType, String newpName, String newpType ){
		ArrayList<Parameters> mList = m.getParamList();
		int index = mList.indexOf(new Parameters(oldpName, oldpType));
		if(index != -1){
			removeDupe(oldpName);
			Parameters p = addNoDupes(newpName, newpType);
			mList.set(index, p);
		} else {
		System.out.println("Parameter not found!");
		}

	}
	public void changeAllParameters(Methods m){
		Scanner scanner = new Scanner(System.in);

		ArrayList<Parameters> mList = m.getParamList();

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

	public void listParamaters(Methods m){
		ArrayList<Parameters> mList = m.getParamList();
		for (Parameters p : mList){
			System.out.println("Name: " + p.getParamName()+ " Type: " + p.getParamType());
		}
	}


	public boolean noParameterDupes(String s){
		return noPDupes.contains(s.toLowerCase());
	}

	public Parameters addNoDupes(String name, String type){
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
}
