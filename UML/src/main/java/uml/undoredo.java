package uml;

import java.util.*;


public class undoredo {
    private static ArrayList<String> mem = new ArrayList<String>();
    //private Iterator<String> itr = mem.iterator();
    private static ArrayList<UML> newColl = new ArrayList<UML>();
    static int incr = 0;
   

    public static void stateKeeper(){
        mem.add(JsonFile.save(Model.getCollection()));
        ++incr;
        
    }

    public static void undo(){
        try {
            --incr;
            JsonFile.load(mem.get(incr-1), newColl);
            System.out.println("Action undone!");
        
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nothing left to undo!");
        }
        

    }
    public static void redo(){
        try {
            ++incr;
            JsonFile.load(mem.get(incr -1), newColl);
            System.out.println("Action redone!");
            
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nothing left to redo!");
        }
        

    }
    public static void memClear(){ // if method is called after undo/redo clear any replace index and clear all indices after
        int temp = incr;
        try{
            for (int i = temp + 1; i <= mem.size(); ++temp){

                mem.remove(mem.get(temp+1));
            }
        }
        catch (IndexOutOfBoundsException e){
           ;
        }

    }
}
