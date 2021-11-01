package uml;

import java.util.*;


public class undoredo {
    private static ArrayList<String> mem = new ArrayList<String>();
    //private Iterator<String> itr = mem.iterator();
    private static ArrayList<UML> newColl = new ArrayList<UML>();
    static int incr = -1;
   

    public static void stateKeeper(){
        mem.add(JsonFile.save(Model.getCollection()));
        ++incr;
      
    }

    public static void undo(){
        try {
            JsonFile.load(mem.get(incr-1), newColl);
            incr--;
            System.out.println("Action undone!");
        
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nothing left to undo!");
        }
        

    }
    public static void redo(){
        try {
            JsonFile.load(mem.get(incr + 1), newColl);
            
            ++incr;
            System.out.println("Action redone!");
            
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nothing left to redo!");
        }
        

    }
    // This is fucked!
    public static void memClear(){ // if method is called after undo/redo clear any replace index and clear all indices after
        int temp = incr;
        try{
            for (int i = temp + 1; i <= mem.size(); ++temp){

                mem.remove(mem.get(temp+1));
            }
            --incr;
        }
        catch (IndexOutOfBoundsException e){
           System.out.println(e.getMessage());
        }
         

    }
    public static void loadClear(){
        mem.clear();
        stateKeeper();
        incr = 0;
        
    }
}
