package uml;
import java.util.*;
public class Commands {
    private static ArrayList<String> allCommands = new ArrayList<>();
    private static final int COMMAND_GREATEST_LENGTH = 26;

    public Commands(){
        allCommands = getCommands();
    }

    public static ArrayList<String> getCommands(){
        allCommands.addAll(namesList);
        return allCommands;
    }

    private static List<String> namesList = Arrays.asList( 
     "addclass",
     "deleteclass",
     "renameclass",
     "addfield", 
     "deletefield", 
     "renamefield", 
     "addmethod", 
     "deletemethod", 
     "deleteallmethods", 
     "renamemethod", 
     "addparameter", 
     "deleteparameter", 
     "deleteallparameters", 
     "changeparameter", 
     "addrelation", 
     "deleterelations", 
     "changerelationshiptype", 
     "listclasses", 
     "listcontents", 
     "listrelationships", 
     "undo", 
     "redo", 
     "screenshot", 
     "help", 
     "save", 
     "load",
     "gui", 
     "exit", 
     "setposition");

     // need case if there are a lot of spaces in the begining
     public static String compare(String command){
        String builder = "";
        for(int i = 0; i<command.length(); ++i){
            if (builder.length() > COMMAND_GREATEST_LENGTH){
                break;
            }
            char buffer = command.charAt(i);
            if(!(buffer == ' ')){
            builder += buffer ;
            }	
        }
        return builder;
     }

     public static String match(String s){
         getCommands();
         String text = s;
         while(!s.isEmpty()){
            s = s.substring(0,s.length());
            text = s;
         for(int i = 0; i < allCommands.size() ; ++i){
            if (s.equals(allCommands.get(i))){
                return text;
            }
         }
         s = s.substring(0,s.length()-1);
        }
        return "-1";
     }

     //THIS GIVES INFINITE LOOP IF COMMAND DOESN'T EXIST
    public static int removeCommand(String s){
        int count =0;
        String compare = compare(s);
        String match = match(compare); 
        //replace first until no spaces and equals matcher
        int run = 0;
        while (!match.equals(s.substring(0, match.length()))){
            
            s = s.replaceFirst(" ", "");
            ++count;
            ++run;
            if (run > 120){
                throw new IllegalArgumentException();
            }
        }
        return count;

    }


    public static ArrayList<String> parse(String given){
        ArrayList<String> parser = new ArrayList<>();
        String comparison = Commands.compare(given);
		String matcher = Commands.match(comparison);

        // int numOfSpaces = countSpaces("   add   class ", matcher);   
        int test = 0;
        try {
           test = removeCommand(given);
        } catch (Exception e) {
            System.out.println("Either too many spaces or the command does not exist!");
        }
		
        
        String command = given.substring(0, matcher.length() + test);
        parser.add(command);
        
        given = given.replace(command, "");
        while(!given.isEmpty() && given.charAt(0) == ' '){
            given = given.replaceFirst(" ", "");
            }
        
        while(!(given.isEmpty())){
            String s = getWords(given);
            parser.add(s);
            given = given.replace(s, "");
            if(!given.isEmpty()){
                while(given.charAt(0) == ' '){
                    given = given.replaceFirst(" ", "");
                    }
            }
        }
        return parser;

    }

    public static String getWords(String s){
        String sb = "";
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == ' '){
                return sb;
            }
            sb += s.charAt(i);
            
        }
        return sb;
    }

    
}
