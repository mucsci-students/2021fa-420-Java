package uml;
import java.util.*;
public class Commands {
    private static ArrayList<String> allCommands = new ArrayList<>();
    private static final int COMMAND_GREATEST_LENGTH = 26;

    public Commands(){
        this.allCommands = getCommands();
    }

    public static ArrayList<String> getCommands(){
        allCommands.addAll(namesList);
        return allCommands;
    }

    public static List<String> namesList = Arrays.asList( 
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

    public static ArrayList<String> parse(String given){
        ArrayList<String> parser = new ArrayList<>();
        String comparison = Commands.compare(given);
		String matcher = Commands.match(comparison);
		parser.add(matcher);
        
        given = given.replace("add class ", "");
        while(!(given.isEmpty())){
            String s = getWords(given);
            parser.add(s);
            given = given.replace(s, "");
            if(!given.isEmpty()){
                given =given.replaceFirst(" ", "");
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
