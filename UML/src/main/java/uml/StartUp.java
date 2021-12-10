package uml;

public class StartUp {
    public static boolean CLIstart = false;
    public static void main(String args[]){
    	if(args.length == 0) {
    		Driver.main(args);
    	}
    	else {
    		if(args[0].equals("--cli")) {
                CLIstart = true;
    			Driver.runCLI();

    		}
    		else {
    			System.out.println("Invalid flag. Enter no flag or --cli");
    		}
    	}
    }
}
