package uml;
import java.util.*;
import java.util.ArrayList;
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
        while(command.charAt(0) == ' '){
            command = command.replaceFirst(" ", "");
        }
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
            // if (run > 120){
            //     throw new IllegalArgumentException();
            // }
        }
        return count;

    }


    public static ArrayList<String> parse(String given){
        ArrayList<String> parser = new ArrayList<>();
        String comparison = Commands.compare(given);
		String matcher = Commands.match(comparison);
        if (matcher.equals("-1")){
            throw new IllegalArgumentException();
        }

        // int numOfSpaces = countSpaces("   add   class ", matcher);   
        int test = 0;
        try {
           test = removeCommand(given);
        } catch (Exception e) {
            System.out.println("Either too many spaces or the command does not exist!");
        }
		
        
        String command = given.substring(0, matcher.length() + test);
        parser.add(command);
        
        given = given.replaceFirst(command, "");
        while(!given.isEmpty() && given.charAt(0) == ' '){
            given = given.replaceFirst(" ", "");
            }
        
        while(!(given.isEmpty())){
            String s = getWords(given);
            parser.add(s);
            given = given.replaceFirst(s, "");
            if(given.length() != 0){
                while(given.charAt(0) == ' '){
                    given = given.replaceFirst(" ", "");
                        if(given.length() == 0){
                        break;
                        }
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

    public static ArrayList<String> storeArray(String s){
        ArrayList<String> parsed = new ArrayList<>();
        String str = "";
        while (!s.equals("")){
            if (s.charAt(0)== ' '){
                s = s.replaceFirst(" ", ""); 
            } else{
                while ( !s.isEmpty() && s.charAt(0) != ' '){
                    str += s.charAt(0);
                    s = s.substring(1, s.length());
                }
                parsed.add(str);
                str = "";
            }
        }

        return parsed;
    }

    
}
